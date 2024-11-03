/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa;


import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.LinkedList;

/**
 *
 * @author jonwilson
 */
public class Programa extends Instruction{
    
    
    private LinkedList<Instruction> instrucciones;
    private Includes includes;
    private Instruction main;
    
    
    
    public Programa(Includes includes, LinkedList<Instruction> instrucciones,Instruction main, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.instrucciones = instrucciones;
        this.includes = includes;
        this.main = main;
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
    public Object createC3D(Arbol arbol, String anterior) {
        return "";
    }

    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
}
