/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.poo.Classs;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.LinkedList;

/**
 *
 * @author jonwilson
 */
public class ClasesJava extends Instruction{

    private LinkedList<Instruction>  clasesJava;

    public ClasesJava(LinkedList<Instruction> clasesJava, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.clasesJava = clasesJava;
    }
            
    

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        
        
        
      return null;
    }
    
     

    @Override
    public Object createC3D(Arbol arbol, String anterior) {
        return null;
    } 
    
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
     @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
    
 
    public Classs getclase(String id){
        Classs clase = null;
        for (Instruction cl : clasesJava) {
            if(cl instanceof Classs cla){
                if(cla.id.equals(id)){
                    clase = cla;
                }
            }
        }
        return clase;
    }

    public LinkedList<Instruction> getListaClasesJava() {
        return clasesJava;
    }
    
    
    
}
