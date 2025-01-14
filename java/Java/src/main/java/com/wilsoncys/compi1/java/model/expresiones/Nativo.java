    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.expresiones;

import com.wilsoncys.compi1.java.model.asbtracto.CreadorC3d;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;

/**
 *
 * @author yoyo
 */
public class Nativo extends Instruction{
    public Object valor;
    public  boolean getch = false;

    public Nativo(Object valor, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        return this.valor;
    }
    
    @Override
    public String generarast(Arbol arbol, String anterior) {      
        return valor.toString();
    }
    
    
    
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
 
        
        @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        String armed = "";
            C3d_Java c=arbol.getJava();
//        }else{
//            c = arbol.getC3d();
//        }
        String nuevoVAl = "";
        if(this.getTyStr().equals("string")){
            nuevoVAl  = "\""+valor.toString() + "\"";
        }else if(this.getTyStr().equals("char")){
            nuevoVAl  = "\'"+valor.toString() + "\'";
        }else if (this.getTyStr().equals("float")){
            nuevoVAl = valor.toString();
        }else if (this.getTyStr().equals("int")){
            nuevoVAl = valor.toString();
        }

        
        armed += c.c3d_newNativo(this.getTyStr(), nuevoVAl, anterior.getVars());
        
        return armed;
    }
    
    
    
}
