/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.poo;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.poo.Mainn;
import com.wilsoncys.compi1.java.model.instrucciones.Statement;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
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

    
    
 
        
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        //attb 
        int contador = 0;
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            if(ins instanceof Statement st){
                //ambito
                Simbolo sym = new Simbolo(tipo, st.id, tabla, false);
                sym.setCat(categoria.ATRIBUTO);
                sym.setDir(contador);
                sym.setInstruction(ins);
                sym.armarAmbito("java");
                sym.armarAmbito(this.id);
                sym.armarAmbito(st.id);
                if(!(tabla.addSsymbolPre(sym))){
                    arbol.addError(new Errores("SEMANTIC", "El simbolo ya existe: " + st.id , st.line, st.col));
                }
                
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
                Simbolo sym = new Simbolo(tipo, mainn.id, tabla, false);
                sym.setCat(categoria.CONSTRUCTOR);
                            //                sym.setDir(contador);
                sym.setInstruction(ins);
                sym.armarAmbito("java");
                sym.armarAmbito(this.id);
                sym.armarAmbito(mainn.id);
                List<String> typeParam = new ArrayList<>();
                for (HashMap hash : mainn.parameters) {
                    Tipo tipo = (Tipo)hash.get("tipo");
                    typeParam.add(tipo.getTypeString());
                }
                    
                sym.getAmbito().addAll(typeParam);          //Car_Car_int_String_Motor
                if(!(tabla.addSsymbolPre(sym))){
                    arbol.addError(new Errores("SEMANTIC", "El simbolo ya existe: " + mainn.id , mainn.line, mainn.col));
                }
                mainn.setAmbito(sym.getAmbito());
                contador = 2;
                for (HashMap param : mainn.parameters) {          //syms de params
                    String idparam = (String)param.get("id");
                    Simbolo symPar = new Simbolo(mainn.tipo, idparam, null, false);
                    symPar.setCat(categoria.PARAM);
                    symPar.setDir(contador);
                    symPar.setAmbito(mainn.getAmbito());
                    symPar.armarAmbito((String)param.get("id"));
                    tabla.addSsymbolPre(symPar);            //add symParam
//                    sym.setInstruction(ins);
                    contador++;
                }
                
                    mainn.setCantParams(cantAttb);
                    mainn.createSym(arbol, tabla);          //create syms
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
                if(!(tabla.addSsymbolPre(sym))){
                    arbol.addError(new Errores("SEMANTIC", "El simbolo ya existe: " + met.id , met.line, met.col));
                }
                
                
                
                
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
//                                                sym.setDir(contador);
                sym.setInstruction(ins);
                sym.armarAmbito(this.id);
                sym.armarAmbito(fun.id);
                List<String> typeParam = new ArrayList<>();
                for (HashMap hash : fun.parameters) { 
                    Tipo tipo = (Tipo)hash.get("tipo");
                    typeParam.add(tipo.getTypeString());
                }
                
                sym.getAmbito().addAll(typeParam);                 //Car_Car_int_String_Motor
                tabla.addSsymbolPre(sym);               //add sym
                fun.setAmbito(sym.getAmbito());
                                //add dir(ref,retorno,dir_retorno)
                contador=3; 
                for (HashMap param : fun.parameters) {          //syms de params
                    String idparam = (String)param.get("id");
                    Simbolo symPar = new Simbolo(fun.tipo, idparam, null, true);
                    symPar.setCat(categoria.PARAM);
                    symPar.setDir(contador);
                    symPar.setAmbito(fun.getAmbito());
                    symPar.armarAmbito((String)param.get("id"));
                    tabla.addSsymbolPre(symPar);            //add symParam
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
    
    
    


    
    
    
    @Override
    public Object createC3D(Arbol arbol, String anterior) {
        String armed = ""; 
        C3d_Java c = arbol.getJava(); 
        for (Instruction ins : instrucciones) {
            if(ins instanceof Statement st){
                armed += (String)st.createC3D(arbol, anterior);
            }
        }
//        buscar su constructor     pte
        for (Instruction ins : instrucciones) {
            if(ins instanceof Mainn){
                armed+=ins.createC3D(arbol, anterior);
            }
        }
        
        
        return armed;
    }
    
    
    
    
    public String getId() {
        return id;
    }

    public String getIdPadre() {
        return idPadre;
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
       
    
    
    
    
}
