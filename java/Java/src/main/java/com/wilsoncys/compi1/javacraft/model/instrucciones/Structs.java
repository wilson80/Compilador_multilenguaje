/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.instrucciones;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Simbolo;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.tablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */


public class Structs extends Instruction{
    public String id;
    public LinkedList<HashMap> parameters;

    public Structs(String id, LinkedList<HashMap> parameters, int linea, int col) {
        
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.parameters = parameters;
    }
    
    
    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        HashMap hashSym =  new HashMap<String, Object>();
        
        for (int i = 0; i < parameters.size(); i++) {
            String idParam = parameters.get(i).get("id").toString();
            
            var tipo = parameters.get(i).get("tipo");
            //identificar si el tipo es struct
            if(tipo instanceof String){ //campo de Struct
                //crear simbolos
                HashMap hashSymAnid =  new HashMap<String, Object>();
                //insertar los simbolos en un hashmap con par(id, simbolo)
                hashSym.put(idParam, hashSymAnid);
            }else if(tipo instanceof Tipo tipoo){ 
                //crear simbolos
                Simbolo newSym = new Simbolo(tipoo, idParam, null, false);
                //insertar los simbolos en un hashmap con par(id, simbolo)
                hashSym.put(idParam, newSym);
                
            }
            
        }
        return hashSym;
    }
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
}
