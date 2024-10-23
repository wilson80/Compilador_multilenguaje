/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.instrucciones;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Simbolo;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.tablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
public class Start_Main extends Instruction{
    public String id;           //id del metodo
    public LinkedList<Instruction> parametersExp;

    public Start_Main(String id, LinkedList<Instruction> parameters, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.parametersExp = parameters;
    }
    
    @Override
    public Object interpretar(Arbol tree, tablaSimbolos tabla) {
        tree.addTablaReport(tabla);
        LinkedList<HashMap> listParams;      //parametros del metodo o funcion 
                                            //implementacion para los structs y funciones pendiente 
        //buscar la funcion en el arbol
        var functio = tree.getFunction(id);
        if(functio==null){
            mensErr = String.format("No se ha encontrado la funcion: %s(); que inicia la ejecucion del programa",id);
            return new Errores("SEMANTIC", mensErr, line, col);
        }
        if(functio instanceof Method function){
            listParams = function.parameters;
            //crear el entorno
            tablaSimbolos newTable = new tablaSimbolos(tree.getTablaGlobal());
            newTable.setNombre("Start_With");
            tree.addTablaReport(newTable);

            //validar las cantidades de parametros(en las llamada y en la declaracion del metodo)
            if(function.parameters.size() != parametersExp.size() ){
                mensErr = String.format("Cantidad de parametros Incorrecta. Al llamar al metodo: %s ", function.id);
                return new Errores("SEMANTIC", mensErr, line, col);
            }

            int contador = 0;   
            for (var exp : parametersExp) {                                                                
                var valueExp = exp.interpretar(tree, tabla);            //interpretar los parametros
                if(valueExp instanceof Errores){
                    return valueExp;
                }
                HashMap par = listParams.get(contador);             //comparar que el tipo coicida con el orden 
                Tipo tipo = (Tipo)par.get("tipo");
                if(exp.tipo.getTipo() != tipo.getTipo()){
                    mensErr = "Tipos Erronos de parametros al llamar al metodo:  " + function.id;
                    return new Errores("SEMANTIC", mensErr, exp.line, exp.col);
                }
                                                                        //crear las declaraciones e interpretarlas
    //Statement(String identificador, Instruction valorVariable_exp, Tipo tipo, int linea, int col, boolean isMutable) {
                Statement newStt = new Statement(par.get("id").toString(), exp, tipo, line, col, true);
                var statt = newStt.interpretar(tree, newTable);
                if(statt instanceof Errores){
                    return statt;
                }
                contador++;
            }

            var fun = function.interpretar(tree, newTable);     //interpretar la funcion (mandarle la nueva tabla)
            if(fun instanceof Errores){
                return fun;
            }
        }else{
            return new Errores("SEMANTIC", "La funcion que inicia el programa no es de tipo VOID", line, col);
        }
        
        return null;
    }
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
    
}
