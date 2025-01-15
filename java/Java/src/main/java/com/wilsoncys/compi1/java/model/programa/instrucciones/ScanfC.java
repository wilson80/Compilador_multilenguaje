/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.instrucciones;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.programa.expresiones.AccessC;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;

/**
 *
 * @author jonwilson
 */
public class ScanfC extends Instruction{
    String id;

    public ScanfC(String id, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.id = id;
    }

    
    
       @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
                    setPos(arbol);
        
        String armed = "";
        C3d_Java c =  arbol.getJava();
        Simbolo sym = arbol.getSym("PROGRAMA" + id);            //pdt
        int dir = 0;
        
        if(sym == null){
            arbol.addError(new Errores("semantic", 
                    "no existe la variable con id: " + this.id, line, col));
        }else{
            dir = sym.getDir();
            this.tipo = sym.getTipo();
            
        }
        //verificar constante
        if(sym.isConst()){
            arbol.addError(new Errores("semantic", 
                    "no puede asignar a una constante: " + this.id, line, col));
        }
        
        armed+= c.c3d_accesParam(getTyStr(), anterior.getVars(), dir);
        
        armed+= "//un cin\n\n\n\ncin>> " + c.varsParams.get(0) + ";\n";
        
        c.varsParams.remove(0);
        
        
        
        
        return armed;
    }
    
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 

    @Override
    public String generarast(Arbol arbol, String anterior) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
