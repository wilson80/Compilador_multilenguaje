/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.expresiones;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonwil
 */
public class AccesVectorC extends Instruction{
    private String identificador;
    private int size = 0;
    private Instruction requestIndex1 = null;
    private Instruction requestIndex2 = null;
    
    //vectores 1D
    public AccesVectorC(String identificador, Instruction requestIndex1, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.identificador = identificador;
        this.requestIndex1 = requestIndex1;
    }
    
    public AccesVectorC(String identificador, Instruction requestIndex1, Instruction requestIndex2, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.identificador = identificador;
        this.requestIndex1 = requestIndex1;
        this.requestIndex2 = requestIndex2;
    }
    
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object vector [] = null;
        if(requestIndex2!= null){
            return this.acceso2D(arbol, tabla);
        }
        
        //interpretar el valor del indice 
        var index = requestIndex1.interpretar(arbol, tabla);
        if(index instanceof Errores){
            return index;
        }
        
        if(requestIndex1.tipo.getTipo() != tipoDato.ENTERO){     //validar que el valor del indice sea un Entero
            mensErr = String.format("El indice: %s indicado no es un entero", requestIndex1.toString());
            return new Errores("SEMANTIC", mensErr, this.requestIndex1.line, this.requestIndex1.col);
        }
        
        var simbolSearch = tabla.getSsymbol(identificador);          //buscar el simbolo en la tabla
        if(simbolSearch !=null){
            if(simbolSearch.getValor() instanceof ArrayList){       //identificar si es una LIST
                return accesDynamicList(arbol, tabla, (int)index, simbolSearch);
            }
            this.tipo = simbolSearch.getTipo();     //set al nuevo tipo 
            vector = (Object[])simbolSearch.getValor();
        }else{
            mensErr = "No se ha encontrado la variable con Id: " + identificador;
            return new Errores("SEMANTIC", mensErr, line, col);
        }
//        tamanno: 4
//        0 1 2 3
//        0 1 2 3 
        size = vector.length;  
        if((int)index<0 || (int)index>= size){  //validar el rango del indice
            mensErr = String.format("Indice: %d fuera de rango en el vector: %s", (int)index, identificador ); 
            return new Errores("SEMANTIC", mensErr, this.requestIndex1.line, this.requestIndex1.col);
        }else{
//            System.out.println("Este es el nuevo tipo(acceso vectores:  )"  + this.tipo.getTipo());
            return vector[(int)index];
        }
    }

    
        public Object acceso2D(Arbol arbol, TablaSimbolos tabla) {
            Object vector [] []= null;
            //buscar el simbolo
            var simbolSearch = tabla.getSsymbol(identificador);          //buscar el simbolo en la tabla
            if(simbolSearch !=null){
                this.tipo = simbolSearch.getTipo();     //set al nuevo tipo
                vector = (Object[][])simbolSearch.getValor();                       //set al vector 
            }else{
                mensErr = "/No se ha encontrado la variable con Id: " + identificador;
                return new Errores("SEMANTIC", mensErr, line, col);
            }
            
            var valueInx1= requestIndex1.interpretar(arbol, tabla); //interpret index1
            if(valueInx1 instanceof Errores){
                return valueInx1;
            }
            if(requestIndex1.tipo.getTipo() != tipoDato.ENTERO){     //validar que el valor del indice 1 sea un Entero
                mensErr = String.format("El indice1: %s no es un entero", valueInx1.toString());
                return new Errores("SEMANTIC", mensErr, this.requestIndex1.line, this.requestIndex1.col);
            }
            var valueInx2= requestIndex2.interpretar(arbol, tabla); //interpret index2
            if(valueInx2 instanceof Errores){
                return valueInx2;
            }
            if(requestIndex2.tipo.getTipo() != tipoDato.ENTERO){     //validar que el valor del indice 2 sea un Entero
                mensErr = String.format("El indice2: %s no es un entero", valueInx2.toString());
                return new Errores("SEMANTIC", mensErr, this.requestIndex2.line, this.requestIndex2.col);
            }
            
            
            //tamano del vector encontrado
            int rows = 0;
            int cols = 0;
            for (Object[] i : vector) {
                rows++;
            }
            for (Object j : vector[0]) {
                    cols++;
            }

            //validar limite de los indices recibidos 
            if(((int)valueInx1<0 || (int)valueInx1>= rows)){
                mensErr = String.format("Indice: %d fuera de rango en el vector: %s ", (int)valueInx1, identificador);
                return new Errores("SEMANTIC", mensErr, this.requestIndex1.line, this.requestIndex1.col);
            }else if((int)valueInx2<0 || (int)valueInx2>= cols ){ 
                mensErr = String.format("Indice: %d fuera de rango en el vector: %s ", (int)valueInx2, identificador);
                return new Errores("SEMANTIC", mensErr, this.requestIndex2.line, this.requestIndex2.col);
            }else{
//                System.out.println("Este es el nuevo tipo(acceso vectores:  )"  + this.tipo.getTipo());
                return vector[(int)valueInx1][(int)valueInx2];
            }
        }        
        
        public Object accesDynamicList(Arbol arbol, TablaSimbolos tabla, int index, Simbolo symSearched) {
            List<Object> listSearched = (List<Object>)symSearched.getValor();
            //validar el rango del indice
            if(index<0 || index>=listSearched.size()){
                mensErr = "Indice: " + index +" fuera de rango al acceder a la lista: " + identificador;
                return new Errores("SEMANTIC", mensErr, this.requestIndex1.line, this.requestIndex1.col);
            }
            //set al nuevo tipo
            this.tipo = symSearched.getTipo();

            return listSearched.get(index);
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
        return anterior;
    }
    
    
    
    
}
