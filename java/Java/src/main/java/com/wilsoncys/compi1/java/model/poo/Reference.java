/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.poo;

import com.wilsoncys.compi1.java.model.poo.Method;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores; 
import com.wilsoncys.compi1.java.model.expresiones.Access;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.instrucciones.Statement;
import com.wilsoncys.compi1.java.model.instrucciones.transferReturn;
import com.wilsoncys.compi1.java.model.programa.expresiones.AccessC;
import com.wilsoncys.compi1.java.model.programa.expresiones.NativoC;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.HashMap;
import java.util.LinkedList;
import java_cup.runtime.Symbol;

/**
 *
 * @author Jonwil
 */
public class Reference extends Instruction{
    private String id;
    private LinkedList<Instruction> parametersExp;

    public Reference(String id, LinkedList<Instruction> parametros, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.parametersExp = parametros;
    }
    
    
    
    @Override
    public Object interpretar(Arbol tree, TablaSimbolos tabla) {
        LinkedList<HashMap> listParams;      //parametros del metodo o funcion 

        //buscar la funcion
        var functio = tree.getFunction(id);
        if(functio == null){
            return new Errores("SEMANTIC", "El id ingresado no corresponde a ningun tipo de funcion/metodo/struct", line, col);
        }
        if(functio instanceof Method theMethod){
            listParams = theMethod.parameters;
            //crear el entorno
                                //            tablaSimbolos newTable = new tablaSimbolos(tree.getTablaGlobal());
            TablaSimbolos newTable = new TablaSimbolos(tabla);
            newTable.setNombre("Metodo: " + id);
            tree.addTablaReport(newTable);
            
            
            //validar las cantidades de parametros(en las llamada y en la declaracion del metodo)
            if(listParams.size() != parametersExp.size() ){
                mensErr = String.format("Cantidad de parametros Incorrecta. Al llamar al metodo: %s ", theMethod.id);
                return new Errores("SEMANTIC", mensErr, line, col);
            }
            
            int contador = 0;   
            for (var exp : parametersExp) {                         //CICLO                                                                        
                HashMap par = listParams.get(contador);             //comparar que el tipo coicida con el orden 
                Tipo tipo = (Tipo)par.get("tipo");
                                                                //crear la declaracion sin valor
                Statement newStt = new Statement(par.get("id").toString(), tipo, line, col, false);    
                var sttm = newStt.interpretar(tree, newTable);     //interpretar la declaracion
                if(sttm instanceof Errores){
                    return sttm;
                }
                
                var valueExp = exp.interpretar(tree, tabla);        //interpretar los parametros
                if(valueExp instanceof Errores){
                    return valueExp;
                }
                
                if(exp.tipo.getTipo() != tipo.getTipo()){       //verificar los tipos
                    mensErr = "Tipos Erronos de parametros al llamar al metodo:  " + theMethod.id;
                    return new Errores("SEMANTIC", mensErr, exp.line, exp.col);
                }
                Simbolo symm = newTable.getSsymbol(par.get("id").toString());   //realizar la asignacion                                                              //realizar la asignacion
                if(symm == null){
                    return new Errores("SEMANTIC", "No se encontro el parametro en funcion: " 
                                                        + id, line, col);
                }
                symm.setValor(valueExp);
                contador++;
            }
            
            var metodoVoid = theMethod.interpretar(tree, newTable);     //interpretar la funcion (mandarle la nueva tabla)
            if(metodoVoid instanceof Errores){
                return metodoVoid;
            }
            
            if(metodoVoid instanceof transferReturn metodd){
                if(metodd.expression!=null){
                    return  new Errores("SEMANTIC", "Retorno con expresion en Metodo: " + theMethod.id, theMethod.line, theMethod.col);
                }
                return null;
            }
            
        }
        if(functio instanceof Functionss function){

            
            listParams = function.parameters;
            //crear el entorno
                        //            tablaSimbolos newTable = new tablaSimbolos(tree.getTablaGlobal());
            TablaSimbolos newTable = new TablaSimbolos(tabla);
            newTable.setNombre("Funcion: " + id);
            tree.addTablaReport(newTable);
            
            //validar las cantidades de parametros(en las llamada y en la declaracion del metodo)
            if(listParams.size() != parametersExp.size() ){
                mensErr = String.format("Cantidad de parametros Incorrecta. Al llamar al metodo: %s ", function.id);
                return new Errores("SEMANTIC", mensErr, line, col);
            }
            
            int contador = 0;   
            for (var exp : parametersExp) {                         //CICLO                                                                        
                HashMap par = listParams.get(contador);             //comparar que el tipo coicida con el orden 
                Tipo tipo = (Tipo)par.get("tipo");
                                                                //crear la declaracion sin valor
                Statement newStt = new Statement(par.get("id").toString(), tipo, line, col, false);    
                var sttm = newStt.interpretar(tree, newTable);     //interpretar la declaracion
                if(sttm instanceof Errores){
                    return sttm;
                }
                
                var valueExp = exp.interpretar(tree, tabla);        //interpretar los parametros
                if(valueExp instanceof Errores){
                    return valueExp;
                }
                
                if(exp.tipo.getTipo() != tipo.getTipo()){       //verificar los tipos
                    mensErr = "Tipos Erronos de parametros al llamar al metodo:  " + function.id;
                    return new Errores("SEMANTIC", mensErr, exp.line, exp.col);
                }
                Simbolo symm = newTable.getSsymbol(par.get("id").toString());                                                                 //realizar la asignacion
                if(symm == null){
                    return new Errores("SEMANTIC", "No se encontro el parametro en funcion: " 
                                                        + id, line, col);
                }
                symm.setValor(valueExp);
                contador++;
            }
            var fun = function.interpretar(tree, newTable);     //interpretar la funcion (mandarle la nueva tabla)
            if(fun instanceof Errores){
                return fun;
            }    
            if(fun == null){
                return new Errores("SEMANTIC", "Funcion sin valor de retorno: " + ((Functionss) functio).id, functio.line, functio.col);
            }
            boolean thereReturn = false;
            if(fun instanceof transferReturn){
                if(((transferReturn) fun).expression == null){
                    return new Errores("SEMANTIC", "Return sin valor a retornar: " + ((Functionss) functio).id, functio.line, functio.col);
                }
                var returnVAlue = ((transferReturn) fun).interpretar(tree, newTable); //interpretar el return
                if(returnVAlue instanceof Errores){
                    return returnVAlue;
                }else{
                    thereReturn = true;     //hay return en la funcion
                    this.tipo = ((transferReturn) fun).tipo;
                    //verificar tipo de la funcion y tipo del valor del retorno  
                    if(this.tipo.getTipo() != function.tipo.getTipo()){
                        return new Errores("SEMANTIC", "Tipo de valor de retorno no corresponde al tipo de la funcion", 
                                ((transferReturn) fun).expression.line, ((transferReturn) fun).expression.col);
                    }

                    return returnVAlue;
                }
                
            }
            if(!thereReturn){       //si no hay un retur al finalizar todas las instrucciones
                return new Errores("SEMANTIC", "Funcion sin valor de retorno: " + function.id+  " ", function.line, function.col);
            }
            
        }
        
        return null;
    }
    
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
            
        return null;
    }
         
        
            @Override
    public Object createC3D(Arbol arbol, String anterior) {
        String armed = "";
        int posIni = 2;
        
        C3d_Java c = arbol.getJava();
        String id_constructor = "java" + this.id + this.id;
                                            //extrayendo los params
        for (Instruction exps : parametersExp) {
            if(exps instanceof Nativo n){             
                n.createC3D(arbol, anterior);
                id_constructor += n.tipo.getTypeString();
                
            }else if(exps instanceof Access cs){
                armed+=cs.createC3D(arbol, anterior);
                id_constructor += cs.tipo.getTypeString();
            }else{
                armed += exps.createC3D(arbol, anterior);
                id_constructor += exps.tipo.getTypeString();
            }
        }


        arbol.getClasesJava().getclase(this.id).setId_constructor(id_constructor);
           
                                                    //stack temp
        armed+=c.c3d_ptrTemp(arbol.attbClassJava);

                                                    //PREPARED params en el stack
        for (Instruction exps : parametersExp) {
                armed += c.c3d_asignTemp("", posIni);
                posIni++;
        }
        
        
        int cantAttbCurrent = arbol.attbClassJava;
        c.clearPtrTemp(); 

                                                //ejecutar el metodo
        armed+= c.c3d_moveToStack(true, arbol.attbClassJava);
        armed+= c.callJava(this.id + "_" + this.id);
        armed+=c.c3d_moveToStack(false, arbol.attbClassJava);
        
           
                            //create a la Clase
        Simbolo symClass = arbol.getSym("java" + this.id);
        arbol.setSizeHeap(((Classs)symClass.getInstruction()).getCantAttb());
        symClass.getInstruction().createC3D(arbol, anterior);


                                            //mover el ptrtemp Temporal
        armed+=c.c3d_ptrTemp(cantAttbCurrent);
                                            //obtener valor de la referencia
        armed+=c.c3d_accesTemp("", 0);
 
         
        
        return armed;
    }
}

