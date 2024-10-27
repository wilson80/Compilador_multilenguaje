/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.poo;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.instrucciones.transferReturn;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.TablaSimbolos;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
public class Mainn extends Instruction{
    public String id;
    public LinkedList<HashMap> parameters;
    public LinkedList<Instruction> instrucciones;

    public Mainn(String id, LinkedList<HashMap> parametros, LinkedList<Instruction> instrucciones, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.id = id;
        this.parameters = parametros;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos table) {
        for (var instruct : this.instrucciones) {
             if (instruct == null) {
                    continue;
            }
            
//            if(instruct instanceof transferReturn){  //puede venir una instruccion dentro del metodo de tipo return
//                return null; 
//            }
//            if(instruct instanceof transferReturn){
//                return instruct;
//            }
            if(instruct instanceof transferReturn){
                return instruct;
            }
            // el problema de eso ^^ es que no la expresion podria retornar // Verify
//            algo que no es y el error tiene que ser devuelto por la llamada y no por la asignacion
            var ressult = instruct.interpretar(arbol, table);
            if(ressult instanceof transferReturn){
                return ressult;
            }
            if(ressult instanceof transferReturn){
                return ressult;
            }
            
            
            if(ressult instanceof Errores error){
                arbol.addError(error);
            }
            
//            if(ressult instanceof transferReturn){
//                return null; 
//            }
            
        }
        
        return null;
    }
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
    
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        
        return null;
    }
        
            @Override
    public Object createC3D(Arbol arbol, String anterior) {
        return anterior;
    }
    
    
}
