/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.poo;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.poo.Mainn;
import com.wilsoncys.compi1.javacraft.model.instrucciones.Statement;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Simbolo;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.categoria;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;
import java.util.LinkedList;

/**
 *
 * @author jonwilson
 */
  public class Classs extends Instruction{
    String id;
    String idPadre;
    private Mainn Main;
    
    public LinkedList<Instruction> instrucciones;
    
    
    
    
   // private TablaSimbolos tablaGlobal;              //contiene las variables declaradas globalmente
   
    
    public Classs(String id, LinkedList<Instruction> instrucciones, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.instrucciones = instrucciones;
        
    }
    
     
    public Classs(String id, String idPadre, LinkedList<Instruction> instrucciones, Tipo tipo, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        
        
    }
 
    
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        
        for (Instruction ins : instrucciones) {
            TablaSimbolos newTable = new TablaSimbolos(tabla);
            if(ins==null){
                    continue;
            }
            if(ins instanceof Method met){
                 
                var algo = met.interpretar(arbol, newTable);
                if(algo instanceof Errores){
                    return algo;
                }
                    
            }
        }
        
        
        
         
        
        return null;
    }

    
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
//    public String generarast(Arbol arbol, int direccion) {
//    public String generarast(Arbol arbol, simbolo ) {
        String algo = anterior;
        for (Instruction instruccione : instrucciones) {
            if(instruccione instanceof Method){
                algo = instruccione.generarast(arbol, algo); 
            }
        }


        return  algo;
    }
    
    
        
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        //attb 
        int contador = 0;
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            if(ins instanceof Statement st){
                //ambito
                Simbolo sym = new Simbolo(tipo, id, tabla, true);
                sym.setCat(categoria.ATRIBUTO);
                sym.setDir(contador);
                sym.setInstruction(ins);
                sym.armarAmbito(this.id);
                tabla.addSsymbol(sym);
                contador++;
                
            }
        }
        contador = 0;
        
        //Main
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            if(ins instanceof Mainn mainn){
                Simbolo sym = new Simbolo(tipo, id, tabla, true);
                sym.setCat(categoria.METODO);
                sym.setDir(contador);
                sym.setInstruction(ins);
                sym.armarAmbito(this.id);
                sym.armarAmbito(mainn.id);
                tabla.addSsymbol(sym);
                contador++;
                arbol.setClassMain(this);
                arbol.setMethodMain(mainn);
                    mainn.createSym(arbol, tabla);
            }   
        }    
        contador = 0;

        //methods
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            
            if(ins instanceof  Method met){
                Simbolo sym = new Simbolo(tipo, id, tabla, true);
                sym.setCat(categoria.METODO);
                sym.setDir(contador);
                sym.setInstruction(ins);
                sym.armarAmbito(this.id);
                sym.armarAmbito(met.id);
                tabla.addSsymbol(sym);
                contador++;
                met.createSym(arbol, tabla);
            }
        }
        contador = 0;

        //functions
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            if(ins instanceof  Functionss met){
                Simbolo sym = new Simbolo(tipo, id, tabla, true);
                sym.setCat(categoria.METODO);
                sym.setDir(contador);
                sym.setInstruction(ins);
                sym.armarAmbito(this.id);
                sym.armarAmbito(met.id);
                tabla.addSsymbol(sym);
                contador++;
                met.createSym(arbol, tabla);
            }
        }
        contador = 0;
 
            
        return null; 
    }
    
    
    

    public String getId() {
        return id;
    }

    public String getIdPadre() {
        return idPadre;
    }

    public void setMain(Mainn Main) {
        this.Main = Main;
    }
    
    @Override
    public Object createC3D(Arbol arbol, String anterior) {
        return anterior;
    }
    
    
    
    
    
}
