/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.instrucciones;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;

/**
 *
 * @author Jonwil
 */
public class transferReturn extends Instruction{
    public Instruction expression = null;

    public transferReturn(Instruction expression, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expression = expression;
    }
    
    
    public transferReturn(int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
    }

    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        //interpretar la exp
        var exp = expression.interpretar(arbol, tabla);
        this.tipo.setTipo(this.expression.tipo.getTipo());
        if(exp instanceof  Errores){
           return  exp;
        }else{
            return exp;
        }
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
