/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.poo;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;

/**
 *
 * @author jonwilson
 */
public class Null extends  Instruction{

    private Instruction nat;
    
    public Null(Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
    }

    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }

    @Override
    public Object createC3D(Arbol arbol, String anterior) {
         arbol.java.varsParams.add(" -1");
        return "";
        
    }

    @Override
    public String generarast(Arbol arbol, String anterior) {
       return "";
  
    }
    
    
    
    
    
}
