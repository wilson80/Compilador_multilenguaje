/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instruccionesPas;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
public class ReadlnPas extends Instruction{

    private LinkedList<String> ids;

    public ReadlnPas(LinkedList<String> ids, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.ids = ids;
    }
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
//        verificar si existe el la variable
        for (String id : ids) {
            Simbolo sim = tabla.getSsymbol(id);
            if(sim == null){
                return new Errores("SEMANTIC", " READLN: la variable:  " + id + " No existe", line, col);
            }
        }
        return null;
    }

    @Override
    public String generarast(Arbol arbol, String anterior) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        return "";
    }
    
    
    
    
    
}
