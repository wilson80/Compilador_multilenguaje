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
public class FunctionFindd extends Instruction{
    private String identificator;
    private Instruction expression;

    public FunctionFindd(String identificator, Instruction expression,int linea, int col) {
        super(new Tipo(tipoDato.BOOLEANO), linea, col);
        this.identificator = identificator;
        this.expression = expression;
    }

    
    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        boolean searched = false;
        boolean isEDD = false;
        //encontrar el simbolo
        Simbolo symSearched = tabla.getSsymbol(identificator);
        if(symSearched==null){
            mensErr = "Variable: " + identificator + " inexistente (function Find)";
            return new Errores("SEMANTIC", mensErr, line, col);
        }
        //interpretar la expresion
        var valueExp = this.expression.interpretar(arbol, tabla);
        if(valueExp instanceof  Errores){
            return  valueExp;
        }
        
        
                                                           //buscar el valor en la EDD
        if(symSearched.getValor() instanceof  ArrayList list){//si es una lista
            List<Object> listSearch = list; 
            searched = listSearch.contains(valueExp);
            isEDD = true;
        }
        
        if(symSearched.getValor() instanceof Object[] vec){ //si es un vector 1D
            Object [] vector = vec;
            for (Object obj : vector) {
                if(obj.equals(valueExp)){
                    searched = true;
                }
            }
            isEDD = true;
        }        
        if(symSearched.getValor() instanceof Object[][] vec){ //si es un vector 2D
            for (Object[] obj : vec) {
                for (Object object : obj) {
                    if(object.equals(valueExp)){
                        searched = true;
                    }
                }
            }
            isEDD = true;
        }
        if(!isEDD){
            return new Errores("SEMANTIC", "La variable: " + identificator + " No soporta funcion Find", 
                    line, col);
        }
        
        //validar el tipo de la exp con el del simbolo encontrado
        if(this.expression.tipo.getTipo() != symSearched.getTipo().getTipo()){
            mensErr = "Tipos Erroneos. Al realizar una busqueda";
            return new Errores("SEMANTIC", mensErr, this.expression.line, this.expression.col);
        }
        
        return searched;
    }
    

@Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }

}
