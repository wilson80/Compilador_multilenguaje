/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.simbolo;

import com.wilsoncys.compi1.java.model.excepciones.Errores;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author yoyo
 */
public class TablaSimbolos1 {

    private TablaSimbolos1 tablaAnterior;
    private LinkedList<Simbolo> tablaActual;
    private String nombre;

    public TablaSimbolos1() {
//        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public TablaSimbolos1(TablaSimbolos1 tablaAnterior) {
        this.tablaAnterior = tablaAnterior;
//        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }
 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
 
    
//    public boolean addSsymbolPre(Simbolo newSymbol){
////        Simbolo find = (Simbolo)this.tablaActual.get(newSymbol.getId());
//        Simbolo find = (Simbolo)this.tablaActual.get(newSymbol.getAmbito_enID());
//        if(find==null){
////            tablaActual.put(newSymbol.getId(), newSymbol);
//            tablaActual.put(newSymbol.getAmbito_enID(), newSymbol);
//            return true;
//        }else{
//            return false;
//        }
////            tablaActual.put(newSymbol.getAmbito_enID(), newSymbol);
//            
//    }
    
    
   
    
//    public Simbolo getSsymbol(String id){
////        Simbolo simboloEcontrado = (Simbolo)this.tablaActual.get(id.toLowerCase());
////        if(simboloEcontrado!=null){
////             return simboloEcontrado;
////        }else{
//
//
////        for (TablaSimbolos i = this; i!=null; i = i.tablaAnterior) {
////            Simbolo simboloEcontrad = (Simbolo)i.tablaActual.get(id);
////            if(simboloEcontrad!=null){
////                return simboloEcontrad;
////            }
////        }
//            Simbolo simboloEcontrad = (Simbolo)tablaActual.get(id);
//            if(simboloEcontrad!=null){
//                return simboloEcontrad;
//                }
//        
//        return null;
////        }
//        
//    }
//    
    
    
    
    

}
