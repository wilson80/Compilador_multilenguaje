/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.asbtracto;

import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;

/**
 *
 * @author yoyo
 */
public abstract class Instruction {

    public Tipo tipo;
    public int line;
    public int col;
    public String mensErr = "";
    public String posIni = "";

    public Instruction(Tipo tipo, int linea, int col) {
        this.tipo = tipo;
        this.line = linea;
        this.col = col;
    }

    public abstract Object interpretar(Arbol arbol, TablaSimbolos tabla);
    
    public abstract Object createSym(Arbol arbol, TablaSimbolos tabla);
    
    public abstract Object createC3D(Arbol arbol, AmbitoMetodo anterior);
   
    
    
    public abstract String generarast(Arbol arbol, String anterior);

    public void setPos(Arbol arbol){
        arbol.setCurrentLine(this.line);
        arbol.setCurrentCol(this.col);
    }
     
}
