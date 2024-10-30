/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.expresiones;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;

/**
 *
 * @author yoyo
 */
public class Input extends Instruction{

    public Input(Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
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
                switch (tipo.getTipo()) {
                    case ENTERO:
                        
                        break;
                    case CARACTER:
                        
                        break;
                    case DECIMAL:
                        
                        break;
                        
                }
        return "";
    }
    
}
