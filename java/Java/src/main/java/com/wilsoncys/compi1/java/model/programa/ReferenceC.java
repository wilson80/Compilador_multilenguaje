/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa;

import com.wilsoncys.compi1.java.model.poo.*;
import com.wilsoncys.compi1.java.model.poo.Method;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores; 
import com.wilsoncys.compi1.java.model.instrucciones.Statement;
import com.wilsoncys.compi1.java.model.instrucciones.transferReturn;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class ReferenceC extends Instruction{
    private String id;
    private LinkedList<Instruction> calls;

    public ReferenceC(String id, LinkedList<Instruction> llamadas, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.calls = llamadas;
    }
    
    
    
    @Override
    public Object interpretar(Arbol tree, TablaSimbolos tabla) {
         
        return null;
    }
    
    
    
 
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {

//        int contador = arbol.attbPrincipal;
        for (Instruction call : calls ) {
             if(call instanceof CallJavaC cl){
                 cl.setIdClase(this.id);
                 Tipo tipo = new Tipo(tipoDato.OBJECT);
                 tipo.setIdObjeto(this.id);
                 Simbolo sym = new Simbolo(tipo, cl.id, cl, true);
                 sym.setCat(categoria.REFERENCIA);
                 sym.setDir(arbol.attbPrincipal);
                 sym.armarAmbito("PROGRAMA");
//                 sym.armarAmbito(this.id);        
                 sym.armarAmbito(cl.id);
                 sym.setInstruction(cl);
                 if(!(tabla.addSsymbolPre(sym))){
                    return new Errores("SEMANTIC", "El simbolo ya existe: " + cl.id , cl.line, cl.col);
                 }
                 
             }
            arbol.attbPrincipal++;
             
        }
             
        return null;
    }



    
            @Override
    public Object createC3D(Arbol arbol, String anterior) {
        String armed = "";
        
        for (Instruction call : calls) {
            if(call instanceof CallJavaC cll){
                cll.setIdClase(this.id);
                armed += cll.createC3D(arbol, anterior);
            }
            
        }
        
        
        
        return armed;
    }   
    
    
    
    
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
}

