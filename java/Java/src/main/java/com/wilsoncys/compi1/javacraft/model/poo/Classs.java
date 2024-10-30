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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jonwilson
 */
  public class Classs extends Instruction{
    String id;
    String idPadre;
    int cantAttb = 0;
    
    public LinkedList<Instruction> instrucciones;
    
    private boolean main;
    Mainn mainMethod;
    
    
    
    
    
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
                Simbolo sym = new Simbolo(tipo, st.id, tabla, true);
                sym.setCat(categoria.ATRIBUTO);
                sym.setDir(contador);
                sym.setInstruction(ins);
                sym.armarAmbito(this.id);
                tabla.addSsymbolPre(sym);
                contador++;
                
            }
        }
        cantAttb = contador;
        contador = 0;
        
        //Main
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            
            if(ins instanceof  Mainn mainn){
                contador = 0;
                Simbolo sym = new Simbolo(tipo, mainn.id, tabla, true);
                sym.setCat(categoria.METHOD);
                sym.setDir(contador);
                sym.setInstruction(ins);
                sym.armarAmbito(this.id);
                sym.armarAmbito(mainn.id);
                List<String> typeParam = new ArrayList<>();
                for (HashMap hash : mainn.parameters) {
                    hash.get("tipo");
                    typeParam.add(id);
                }
                
                sym.getAmbito().addAll(typeParam);                 //Car_Car_int_String_Motor
                tabla.addSsymbolPre(sym);
                    mainn.setCantParams(cantAttb);
                    mainn.setAmbito(sym.getAmbito());
                    mainn.createSym(arbol, tabla);          //create syms
                arbol.setClassMain(this);
                arbol.setMethodMain(mainn);
                arbol.setSizeStack(mainn.getCantParams());
                
            }
        }
        

        //methods
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            
            if(ins instanceof  Method met){
                contador = 0;
                Simbolo sym = new Simbolo(tipo, met.id, tabla, true);
                sym.setCat(categoria.METHOD);
                sym.setDir(contador);
                sym.setInstruction(ins);
                sym.armarAmbito(this.id);
                sym.armarAmbito(met.id);
                List<String> typeParam = new ArrayList<>();
                for (HashMap hash : met.parameters) {
//                    hash.get("id");
                    Tipo tipo = (Tipo)hash.get("tipo");
                    typeParam.add(tipo.getTypeString());
                }    
                //syms de c/param
                
                sym.getAmbito().addAll(typeParam);                 //Car_Car_int_String_Motor
                tabla.addSsymbolPre(sym);
                contador++;
                    met.setCantParams(contador);
                    met.setAmbito(sym.getAmbito());
                    met.createSym(arbol, tabla);
                
            }
        }
        
        

        //functions
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            if(ins instanceof  Functionss fun){
                contador = 0;
                Simbolo sym = new Simbolo(tipo, fun.id, null, true);
                sym.setCat(categoria.FUNCTION);
                sym.setDir(contador);
                sym.setInstruction(ins);
                sym.armarAmbito(this.id);
                sym.armarAmbito(fun.id);
                List<String> typeParam = new ArrayList<>();
                for (HashMap hash : fun.parameters) {
//                    hash.get("id");
                    Tipo tipo = (Tipo)hash.get("tipo");
                    typeParam.add(tipo.getTypeString());
                }
                
                sym.getAmbito().addAll(typeParam);                 //Car_Car_int_String_Motor
                tabla.addSsymbolPre(sym);
                fun.setAmbito(sym.getAmbito());
                //add dir(ref,retorno,dir_retorno)
                contador++; //retorno
                for (HashMap param : fun.parameters) {          //syms de params
                    String idparam = (String)param.get("id");
                    Simbolo symPar = new Simbolo(fun.tipo, idparam, null, true);
                    symPar.setCat(categoria.PARAM);
                    symPar.setDir(contador);
                    symPar.setAmbito(fun.getAmbito());
                    tabla.addSsymbolPre(symPar);
//                    sym.setInstruction(ins);
                    contador++;
                }
                fun.setCantParams(contador);
                fun.createSym(arbol, tabla);
            }
        }
        contador = 0;

//        constructor
        
        
        
        
            
        return null; 
    }
    
    
    

    public String getId() {
        return id;
    }

    public String getIdPadre() {
        return idPadre;
    }

    
    
    
    @Override
    public Object createC3D(Arbol arbol, String anterior) {
        String armed = ""; 
        if(isMain()){
            for (Instruction ins : instrucciones) {
                if(ins instanceof Statement st){
                    armed += (String)st.createC3D(arbol, anterior);
                }
            }
        }
        return armed;
    }
    
    
    

    public void setCantAttb(int cantAttb) {
        this.cantAttb = cantAttb;
    }

    public int getCantAttb() {
        return cantAttb;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public void setMainMethod(Mainn mainMethod) {
        this.mainMethod = mainMethod;
    }

    public Mainn getMainMethod() {
        return mainMethod;
    }
    
    
    
    
    
}
