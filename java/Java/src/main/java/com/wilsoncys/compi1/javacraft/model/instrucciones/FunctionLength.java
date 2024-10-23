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
public class FunctionLength extends Instruction{
    private String id;

    public FunctionLength(String id, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        int size = 0;
        boolean isEDD = false;
        List<Object> listSearched=null;
        Object[] vectorSearched=null;
        String cadenaSearched=null;
        
                                                    //Encontrar el simbolo
        Simbolo symSearched = tabla.getSsymbol(id);
        if(symSearched == null){
            mensErr = "Variable: " + id + "Inexistente";
            return new Errores("SEMANTIC", mensErr, line, col);
        }                                               //identificar el tipo de EDD
        if(symSearched.getValor() instanceof ArrayList list){
            size = list.size();
            isEDD = true;
        }
        if(symSearched.getValor() instanceof String strin){
            size = strin.length();
            isEDD = true;
        }
        if(symSearched.getValor() instanceof Object[] objVec){
            size = objVec.length;
            isEDD = true;
        }
        if(symSearched.getValor() instanceof Object[][] objVec){
            size = objVec.length;
            isEDD = true;
        }
        
                                                    //validar el tipo (Vectores, listas, cadenas)
        if(!isEDD){
            return new Errores("SEMANTIC", "La variable solicitada "
                    + "no soporta la funcion length", line, col);
        }
                                                        //set al nuevo tipo
        this.tipo.setTipo(tipoDato.ENTERO);
        
        return size;
    }
    
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
}
