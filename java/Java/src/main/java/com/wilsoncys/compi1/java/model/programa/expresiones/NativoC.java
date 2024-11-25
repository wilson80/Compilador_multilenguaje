/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.expresiones;

import com.wilsoncys.compi1.java.model.expresiones.*;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;

/**
 *
 * @author yoyo
 */
public class NativoC extends Instruction{
    public Object valor;

    public NativoC(Object valor, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        return this.valor;
    }
    
    @Override
    public String generarast(Arbol arbol, String anterior) {      
//        String nodoNativo = "n" + arbol.getCount();//n1
//        String nodoValor = "n" + arbol.getCount();//n2
//
//        String resultado = anterior + " -> " + nodoNativo+";\n";
//
//        resultado += nodoNativo + "[label=\"NATIVO\"];\n";
//        resultado += nodoValor + "[label=\""
//                + this.valor.toString() + "\"];\n";
//
//        resultado += nodoNativo + " -> " + nodoValor+";\n";
//        return resultado;
        return valor.toString();
    }
    
        public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
 
        
        @Override
    public Object createC3D(Arbol arbol, String anterior) {
        arbol.cMain.varsParams.add(valor.toString());
        return valor.toString();
    }
    
    
    
}
