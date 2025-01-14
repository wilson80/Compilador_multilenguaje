    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.expresiones;

import com.wilsoncys.compi1.java.model.asbtracto.CreadorC3d;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
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
        CreadorC3d c;
        if(anterior.getLenguaje().equals("java")){
            c = arbol.getJava();
        }else{
            c = arbol.getC3d();
        } 

        String idVAr = "w" + c.getContador();
        c.contador++;
        
        armed += c.c3d_newNativo(this.tipo.getTipo());
        
        
        if(tipo.getTipo() == tipoDato.CADENA){
            armed += valor.toString();
        }else{
            armed += ""+idVAr + " = " +valor.toString() + ";"+ "\n //nativ\n";
        }
        
        
        c.varsParams.add(valor.toString());
        
        
        
//        if(anterior.getLenguaje().equals("java")){
//            arbol.java.varsParams.add(valor.toString());
//        }else{
//            arbol.cMain.varsParams.add(valor.toString());
//        }
        return armed;
//        return "";
    }
    
    
    
}
