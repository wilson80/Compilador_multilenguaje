/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa;


import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.poo.Classs;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.LinkedList;
import java_cup.runtime.Symbol;

/**
 *
 * @author jonwilson
 */
public class Programa extends Instruction{
    
    
    private LinkedList<Instruction> instrucciones;
    private Includes includes;
    private Instruction main;
    public int contadorStackP = 0;
    
    
    
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
                                                                    //includes
         ClasesJava clasesJ = arbol.getClasesJava();
         if(includes.isJavaTodo()){
             for (Instruction ins : instrucciones) {
                 
             }
         }else{
              for (String idClase : includes.getClaseJava()) {
                  Classs claseEncontrada = clasesJ.getclase(idClase);
                  claseEncontrada.createSym(arbol, tabla);
                   
                   
             }
             
         }
         
          
         
        
        int contador = 0;
        for (Instruction ins : instrucciones) {
            if(ins==null){
                continue;
            }
            if(ins instanceof StatementC as){
                Simbolo sym = new Simbolo(as.tipo, as.id, tabla, as.isConst);
                 //ambito
                sym.setCat(categoria.ATRIBUTO);
                sym.setDir(contador);
                sym.setInstruction(as);
                sym.armarAmbito("PROGRAMA");
                sym.armarAmbito(as.id);
                if(!(tabla.addSsymbolPre(sym))){
                    arbol.addError(new Errores("SEMANTIC", "El simbolo ya existe: " + as.id , as.line, as.col));
                }
                
                contador++;
            } 
        }
        arbol.attbClassPrincipal+=contador;
        
        for (Instruction ins : instrucciones) {
             if(ins==null){
                continue;
            }
            if(ins instanceof ReferenceC ref){
                ref.createSym(arbol, tabla);    
            }
        }
        
        
         
         
        
        return null;
    }

    
    
    
       @Override
    public Object createC3D(Arbol arbol, String anterior) {
        String ArmedTodo = "";
         
        
        ClasesJava clasesJ = arbol.getClasesJava();
         if(includes.isJavaTodo()){
             for (Instruction ins : instrucciones) {
                 
             }
         }else{
              for (String idClase : includes.getClaseJava()) {
                  Classs claseEncontrada = clasesJ.getclase(idClase);
                  claseEncontrada.createC3D(arbol, anterior);
                   
                   
             }
             
         }
        
        
        
        
        
        
        
        
        
        
        
        
//           for (Instruction instruccione : instrucciones) {
//               if(ins instanceof StatementC as){
//                   
//               }
//           }
        
        
        
        
        
        
        
        
        return "";
    }

    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
}
