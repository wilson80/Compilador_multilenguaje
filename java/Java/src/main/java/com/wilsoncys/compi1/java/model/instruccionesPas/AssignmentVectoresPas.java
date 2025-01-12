/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instruccionesPas;
 
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonwil
 */
public class AssignmentVectoresPas extends Instruction{
    private String identificator1;
    private Instruction index1 = null;
    private Instruction index2 = null;
            
    private Instruction newExpresion;
    
     
    public AssignmentVectoresPas(String identificator1, Instruction index1, Instruction exp, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.identificator1 = identificator1;
        this.index1 = index1;
        this.newExpresion = exp;
    }

    
    
    @Override                                                   //       vector1[1] = 'adsf';
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object [] vector;
 
        //        interpretar el indice
        var valueIndex1 = index1.interpretar(arbol, tabla);
        if(valueIndex1 instanceof Errores){
            return valueIndex1;
        }
        if(index1.tipo.getTipo()!=tipoDato.ENTERO){ //        validar que sea de tipo Entero
            mensErr = String.format("El indice: %s indicado no es un entero,"
                    + " al intentar asignar al vector", valueIndex1.toString(), identificator1);
            return new Errores("SEMANTIC", mensErr, this.newExpresion.line, this.newExpresion.col);
        }
        
        //Encontrar el simbolo 
        var simbolSearch = tabla.getSsymbol(identificator1);
        if(simbolSearch==null){
            mensErr = "No se encontro el id del vector solicitado";
            return new Errores("SEMANTIC", mensErr, line, col);
        }
 
        vector = (Object[])simbolSearch.getValor();
//                validar el rango del indice

                    if((int)valueIndex1<simbolSearch.getIndI() || (int)valueIndex1>simbolSearch.getIndF()){
                        mensErr = String.format("Indice: %d  fuera de rango en el vector con id: %s",(int)valueIndex1, identificator1 );
                        return new Errores("SEMANTIC", mensErr, this.index1.line, this.index1.col);
                    }

        //interpretar la expresion
        var valueExp = newExpresion.interpretar(arbol, tabla);
        if(valueExp instanceof Errores){
            return valueExp;
        }
        //validar el tipo de la expresion con el tipo del simbolo que es el vector
        if(newExpresion.tipo.getTipo()!=simbolSearch.getTipo().getTipo()){
            mensErr = "Tipos erroneos al intentar asignar al vector con id: " + identificator1;
            return new Errores("SEMANTIC", mensErr, this.newExpresion.line, this.newExpresion.col);
        }else{
            //verificacion si el simbolo es constante
            if(simbolSearch.isConst()){
                return new Errores("SEMANTIC", "Variable con id:  "+identificator1 + "Es constante",
                        this.newExpresion.line, this.newExpresion.col);
            }
            //realizar la asignacion
            vector[(int)valueIndex1 - simbolSearch.getIndI()] = valueExp;
            //set al tipo 
            this.tipo.setTipo(newExpresion.tipo.getTipo());
            
            return null;
        }
    }
  
 
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
