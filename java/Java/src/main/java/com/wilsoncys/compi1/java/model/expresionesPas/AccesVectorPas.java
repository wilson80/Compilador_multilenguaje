/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.expresionesPas;


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
public class AccesVectorPas extends Instruction{
    private String identificador;
    private int size = 0;
    private Instruction requestIndex1 = null; 
    
    //vectores 1D
    public AccesVectorPas(String identificador, Instruction requestIndex1, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.identificador = identificador;
        this.requestIndex1 = requestIndex1;
    }
//    AssignmentVectores::= ID:id BRACK_L EXPRESION:exp BRACK_R ASSIGNMENT EXPRESION

    public AccesVectorPas(String identificador, Instruction requestIndex1, Instruction requestIndex2, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.identificador = identificador;
        this.requestIndex1 = requestIndex1; 
    }
    
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object vector [] = null;

        
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
            
            this.tipo = simbolSearch.getTipo();     //set al nuevo tipo 
            vector = (Object[])simbolSearch.getValor();
        }else{
            mensErr = "No se ha encontrado la variable con Id: " + identificador;
            return new Errores("SEMANTIC", mensErr, line, col);
        }
        
        size = vector.length;  
        if((int)index<simbolSearch.getIndI() || (int)index>simbolSearch.getIndF()){  //validar el rango del indice
            mensErr = String.format("Indice: %d fuera de rango en el vector: %s", (int)index, identificador ); 
            return new Errores("SEMANTIC", mensErr, this.requestIndex1.line, this.requestIndex1.col);
        }else{
//            System.out.println("Este es el nuevo tipo(acceso vectores:  )"  + this.tipo.getTipo());
            return vector[(int)index - simbolSearch.getIndI()];
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
