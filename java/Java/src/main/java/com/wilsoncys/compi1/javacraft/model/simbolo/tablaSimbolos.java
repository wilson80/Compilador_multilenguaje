/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.simbolo;

import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import java.util.HashMap;

/**
 *
 * @author yoyo
 */
public class tablaSimbolos {

    private tablaSimbolos tablaAnterior;
    private HashMap<String, Object> tablaActual;
    private String nombre;

    public tablaSimbolos() {
        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public tablaSimbolos(tablaSimbolos tablaAnterior) {
        this.tablaAnterior = tablaAnterior;
        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public tablaSimbolos getTablaAnterior() {
        return tablaAnterior;
    }

    public void setTablaAnterior(tablaSimbolos tablaAnterior) {
        this.tablaAnterior = tablaAnterior;
    }

    public HashMap<String, Object> getTablaActual() {
        return tablaActual;
    }

    public void setTablaActual(HashMap<String, Object> tablaActual) {
        this.tablaActual = tablaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean addSsymbol(Simbolo newSymbol){
        Simbolo find = (Simbolo)this.tablaActual.get(newSymbol.getId().toLowerCase());
        if(find==null){
            tablaActual.put(newSymbol.getId().toLowerCase(), newSymbol);
            return true;
        }else{
            return false;
        }
    }
    
    public Simbolo getSsymbol(String id){
//        Simbolo simboloEcontrado = (Simbolo)this.tablaActual.get(id.toLowerCase());
//        if(simboloEcontrado!=null){
//             return simboloEcontrado;
//        }else{
        for (tablaSimbolos i = this; i!=null; i = i.tablaAnterior) {
            Simbolo simboloEcontrad = (Simbolo)i.tablaActual.get(id.toLowerCase());
            if(simboloEcontrad!=null){
                return simboloEcontrad;
            }
        }
        
        return null;
//        }
        
    }
    
    
    
    
    

}
