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
public class TablaSimbolos {
 
    private TablaSimbolos tablaAnterior;
    private HashMap<String, Object> tablaActual;
    private String nombre;
    private LinkedList<Simbolo> nuevaTabla;
    
    
    public TablaSimbolos() {
        this.tablaActual = new HashMap<>();
        this.nombre = "";
        this.nuevaTabla = new LinkedList<>();
    }

    public TablaSimbolos(TablaSimbolos tablaAnterior) {
        this.tablaAnterior = tablaAnterior;
        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public TablaSimbolos getTablaAnterior() {
        return tablaAnterior;
    }

    public void setTablaAnterior(TablaSimbolos tablaAnterior) {
        this.tablaAnterior = tablaAnterior;
    }

    public HashMap<String, Object> getTablaActual() {
        return tablaActual;
    }
//
    public void setTablaActual(HashMap<String, Object> tablaActual) {
        this.tablaActual = tablaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean aquiNoo(Simbolo newSymbol){
        Simbolo find = (Simbolo)this.tablaActual.get(newSymbol.getId().toLowerCase());
        if(find==null){
            tablaActual.put(newSymbol.getId().toLowerCase(), newSymbol);
            return true;
        }else{
            return false;
        }
    }
    
//    public boolean addSsymbolPre(Simbolo newSymbol){
//        Simbolo find = getSsymbol(newSymbol.getAmbito_enID());
//
//          if(find==null){
//              nuevaTabla.add(newSymbol);
//              return true;
//          }else{
//              return false;
//          }
//          
//              
//    }
    public boolean addSsymbolPre(Simbolo newSymbol){
//        Simbolo find = (Simbolo)this.tablaActual.get(newSymbol.getId());
        Simbolo find = (Simbolo)this.tablaActual.get(newSymbol.getAmbito_enID());
        if(find==null){
//            tablaActual.put(newSymbol.getId(), newSymbol);
            tablaActual.put(newSymbol.getAmbito_enID(), newSymbol);
            return true;
        }else{
            return false;
        }
//            tablaActual.put(newSymbol.getAmbito_enID(), newSymbol);
            
    }
    public boolean addSsymbolPas(Simbolo newSymbol){
//        Simbolo find = (Simbolo)this.tablaActual.get(newSymbol.getId());
        Simbolo find = (Simbolo)this.tablaActual.get(newSymbol.getAmbito_enID().toLowerCase());
        if(find==null){
//            tablaActual.put(newSymbol.getId(), newSymbol);
            tablaActual.put(newSymbol.getAmbito_enID().toLowerCase(), newSymbol);
            return true;
        }else{
            return false;
        }
//            tablaActual.put(newSymbol.getAmbito_enID(), newSymbol);
            
    }
   
    
//    public Simbolo getSsymbol(String id){
//        Simbolo simboloEcontrad = null;
//        for (Simbolo simbolo : nuevaTabla) {
//            if(simbolo.getAmbito_enID().equals(id)){
//                simboloEcontrad = simbolo;
//            }
//        }
//        
//        if(simboloEcontrad!=null){
//            return simboloEcontrad;
//        }
//        
//        
//        return null;
////        }
//        
//    }
    public Simbolo getSsymbol(String id){
//        Simbolo simboloEcontrado = (Simbolo)this.tablaActual.get(id.toLowerCase());
//        if(simboloEcontrado!=null){
//             return simboloEcontrado;
//        }else{


//        for (TablaSimbolos i = this; i!=null; i = i.tablaAnterior) {
//            Simbolo simboloEcontrad = (Simbolo)i.tablaActual.get(id);
//            if(simboloEcontrad!=null){
//                return simboloEcontrad;
//            }
//        }
            Simbolo simboloEcontrad = (Simbolo)tablaActual.get(id);
            if(simboloEcontrad!=null){
                return simboloEcontrad;
                }
        
        return null;
//        }
        
    }
    
    

    
    
    

}
