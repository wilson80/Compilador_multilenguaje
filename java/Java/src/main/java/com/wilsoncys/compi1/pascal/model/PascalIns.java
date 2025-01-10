/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.pascal.model;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;

/**
 *
 * @author jonwilson
 */
public class PascalIns extends Instruction{

    public PascalIns(Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
    }

    
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return "";
    }

    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo  anterior) {
        return "";
    }

    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
}
