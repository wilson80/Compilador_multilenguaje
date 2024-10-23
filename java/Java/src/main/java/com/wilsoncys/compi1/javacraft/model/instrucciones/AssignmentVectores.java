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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonwil
 */
public class AssignmentVectores extends Instruction{
    private String identificator1;
    private Instruction index1 = null;
    private Instruction index2 = null;
            
    private Instruction newExpresion;

    
    
    
//asignar en la posicion de un vector una expresion(puede ser el valor de una posicion de otro vector) 
    public AssignmentVectores(String identificator1, Instruction index1, Instruction exp, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.identificator1 = identificator1;
        this.index1 = index1;
        this.newExpresion = exp;
    }

//asignacion de vectores 2D
    public AssignmentVectores(String identificator1, Instruction index1, Instruction index2, Instruction newExpresion,  int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.identificator1 = identificator1;
        this.index1 = index1;
        this.index2 = index2;
        this.newExpresion = newExpresion;
    }
    
    
    @Override                                                   //       vector1[1] = "World";
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Object [] vector;
        if(index2!=null){
            return this.assignment2D(arbol, tabla);
        }
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
        if(simbolSearch.getValor() instanceof ArrayList){        //verificar si es una LIST
            return assignmentLists(arbol, tabla, (int)valueIndex1, simbolSearch);
        }
        
        vector = (Object[])simbolSearch.getValor();

//                validar el rango del indice
                if((int)valueIndex1>=vector.length || (int)valueIndex1<0){
                    mensErr = String.format("Indice: %d  fuera de rango en el vector con id: ",(int)valueIndex1, identificator1 );
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
            vector[(int)valueIndex1] = valueExp;
            //set al tipo 
            this.tipo.setTipo(newExpresion.tipo.getTipo());
            
            return null;
        }
    }
    
    
    
    public Object assignment2D(Arbol arbol, tablaSimbolos tabla) {
        Object [][] vector;
        int rows = 0;
        int cols = 0;
        //Encontrar el simbolo 
        var simbolSearch = tabla.getSsymbol(identificator1);
        if(simbolSearch==null){
            mensErr = "No se encontro el id del vector solicitado";
            return new Errores("SEMANTIC", mensErr, line, col);
        }
        vector = (Object[][])simbolSearch.getValor();
        //identificar lineas y columnas
        for (Object[] objects : vector) {
            rows++;
        }
        for (Object fila : vector[0]) {
            cols++;
        }
        
        //        interpretar el indice 1 
        var valueIndex1 = index1.interpretar(arbol, tabla);
                if(valueIndex1 instanceof Errores){
                    return valueIndex1;
                }
                if(index1.tipo.getTipo()!=tipoDato.ENTERO){ //        validar que sea de tipo Entero
                    mensErr = String.format("El indice  %s  no es un entero, al "
                            + "intentar asignar al vector 2D %s", valueIndex1.toString(), identificator1);
                    return new Errores("SEMANTIC", mensErr, this.index1.line, this.index1.col);
                }
//                validar el rango del indice 1
                if((int)valueIndex1>=rows || (int)valueIndex1 <0){
                    mensErr = String.format("Indice: %d fuera de rango en el vector con id: %s ", (int)valueIndex1, identificator1);
                    return new Errores("SEMANTIC", mensErr, this.index1.line, this.index1.col);
                }
        //        interpretar el indice 2 
        var valueIndex2 = index2.interpretar(arbol, tabla);
                if(valueIndex2 instanceof Errores){
                    return valueIndex2;
                }
                if(index2.tipo.getTipo()!=tipoDato.ENTERO){ //        validar que sea de tipo Entero
                    mensErr = String.format("El indice  %s  no es un entero, al "
                            + "intentar asignar al vector 2D %s", valueIndex2.toString(), identificator1);
                    return new Errores("SEMANTIC", mensErr, this.index2.line, this.index2.col);
                }
//                validar el rango del indice 2
                if((int)valueIndex2>=cols || (int)valueIndex2<0){
                    mensErr = String.format("Indice: %d fuera de rango en el vector con id: %s ", (int)valueIndex2, identificator1);
                    return new Errores("SEMANTIC", mensErr, this.index2.line, this.index2.col);
                }
        //interpretar la expresion
        var valueExp = newExpresion.interpretar(arbol, tabla);
        if(valueExp instanceof Errores){
            return valueExp;
        }
        //validar el tipo de la expresion con el tipo del simbolo que es el vector
        if(newExpresion.tipo.getTipo()!=simbolSearch.getTipo().getTipo()){
            mensErr = String.format("Tipos erroneos al intentar asignar: %s al vector con id: %s ", valueExp.toString(), identificator1 );
            return new Errores("SEMANTIC", mensErr, this.newExpresion.line, this.newExpresion.col);
        }else{
            //verificacion si el simbolo es constante
            if(simbolSearch.isConst()){
                return new Errores("SEMANTIC", "Variable con id:  "+identificator1 + "Es constante", line, col);
            }
            //realizar la asignacion
            vector[(int)valueIndex1][(int)valueIndex2] = valueExp;
                                                                                //set al tipo 
            this.tipo.setTipo(newExpresion.tipo.getTipo());
            return null;
        }        
                
        
        
    }
    
    
    
    public Object assignmentLists(Arbol arbol, tablaSimbolos tabla, int index, Simbolo simbolSearch) {
        List<Object> listaSearched = (List<Object>)simbolSearch.getValor();

//                validar el rango del indice
        if(index>=listaSearched.size() || index<0){
            mensErr = String.format("Indice: %d  fuera de rango en la lista con id: ",index, identificator1 );
            return new Errores("SEMANTIC", mensErr, this.index1.line, this.index1.col);
        }

        //interpretar la expresion
        var valueExp = newExpresion.interpretar(arbol, tabla); 
        if(valueExp instanceof Errores){
            return  valueExp;
        }
        
        //validar el tipo de la expresion con el tipo del simbolo que es la lista
        if(newExpresion.tipo.getTipo()!=simbolSearch.getTipo().getTipo()){
            mensErr = "Tipos erroneos al intentar asignar a la lista con id: " + identificator1;
            return new Errores("SEMANTIC", mensErr, this.newExpresion.line, this.newExpresion.col);
        }else{
            
            //realizar la asignacion
            listaSearched.set(index, valueExp);
            //set al tipo 
            this.tipo.setTipo(newExpresion.tipo.getTipo());
            
            return null;
        }
    }

    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
    
    
}
