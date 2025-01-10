/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.instrucciones;

import com.wilsoncys.compi1.java.model.instrucciones.*;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
 
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */


public class StructsC extends Instruction{
    public String id;
    public LinkedList<HashMap> parameters;

    public StructsC(String id, LinkedList<HashMap> parameters, int linea, int col) {
        
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.parameters = parameters;
    }
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
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
        public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
            @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        return anterior;
    }
    
    
    
}
