/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.asbtracto;

import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.tablaSimbolos;

/**
 *
 * @author yoyo
 */
public abstract class Instruction {

    public Tipo tipo;
    public int line;
    public int col;
    public String mensErr = "";

    public Instruction(Tipo tipo, int linea, int col) {
        this.tipo = tipo;
        this.line = linea;
        this.col = col;
    }

    public abstract Object interpretar(Arbol arbol, tablaSimbolos tabla);
    public abstract String generarast(Arbol arbol, String anterior);

}
