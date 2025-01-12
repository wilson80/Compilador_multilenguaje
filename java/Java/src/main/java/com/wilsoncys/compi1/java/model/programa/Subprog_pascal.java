/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.instruccionesPas.FunctionssPas;
import com.wilsoncys.compi1.java.model.instruccionesPas.MethodPas;
import com.wilsoncys.compi1.java.model.poo.Functionss;
import com.wilsoncys.compi1.java.model.poo.Method;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
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
public class Subprog_pascal extends Instruction{
    LinkedList<Instruction> funcionesPascal;
    LinkedList<Instruction> todasLasins;

    public Subprog_pascal(LinkedList<Instruction> funciones) {
        super(new Tipo(tipoDato.VOID), 0, 0);
        this.funcionesPascal = funciones;
    }
    public Subprog_pascal() {
        super(new Tipo(tipoDato.VOID), 0, 0);
    }
  
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        if(funcionesPascal == null){
            funcionesPascal = new LinkedList<>();
        }
        
        for (Instruction ins : todasLasins) {
            if(ins instanceof Subprog_pascal sub){
                this.funcionesPascal = sub.getFuncionesPascal();
            }
        }
        
        int contador = 0;
        for (Instruction subP : funcionesPascal) {
            if(subP instanceof  MethodPas procedure){
                contador = 2;
                   
                Simbolo sym = new Simbolo(procedure.tipo, procedure.id, null, true);
                sym.setCat(categoria.METHOD);
                sym.setDir(contador);
                sym.setInstruction(subP);
                sym.armarAmbito("pas");
                sym.armarAmbito(procedure.id);
                
                
                List<String> typeParam = new ArrayList<>();
                for (HashMap hash : procedure.parameters) { 
                    Tipo tipo = (Tipo)hash.get("tipo");
                    typeParam.add(tipo.getTypeString());
                }
                sym.getAmbito().addAll(typeParam);                 //Car_Car_int_String_Motor
                
                
                                                //agregar el simbolo pasando todo a minusculas
                if(!(tabla.addSsymbolPas(sym))){
                    return new Errores("SEMANTIC", "El simbolo ya existe: " + procedure.id , procedure.line, procedure.col);
                }
                                                    //crear los simbolos a los parametros
                
                procedure.setAmbito(sym.getAmbito());
                for (HashMap param : procedure.parameters) {          //syms de params
                    String idparam = (String)param.get("id");
                    Simbolo symPar = new Simbolo((Tipo)param.get("tipo"), idparam, null, true);
                    symPar.setCat(categoria.PARAM);
                    symPar.setDir(contador);
                    symPar.setAmbito(procedure.getAmbito());
                    symPar.armarAmbito((String)param.get("id"));
                    tabla.addSsymbolPas(symPar);            //add symParam
                    sym.setInstruction(subP);
                    contador++;
                }
                procedure.setCantParams(contador);
                procedure.createSym(arbol, tabla);
            }
            
            //  FUNCTIONS
            
            if(subP instanceof  FunctionssPas fun){                
                contador = 3;
                Simbolo sym = new Simbolo(fun.tipo, fun.id, null, true);
                sym.setCat(categoria.FUNCTION);
                sym.setDir(contador);
                sym.setInstruction(subP); 
                sym.armarAmbito("pas");
                sym.armarAmbito(fun.id);
                List<String> typeParam = new ArrayList<>();
                for (HashMap hash : fun.parameters) { 
                    Tipo tipo = (Tipo)hash.get("tipo");
                    typeParam.add(tipo.getTypeString());
                }
                sym.getAmbito().addAll(typeParam);                 //Car_Car_int_String_Motor
                
                
                
                
                if(!(tabla.addSsymbolPas(sym))){
                    return new Errores("SEMANTIC", "El simbolo ya existe: " + fun.id , fun.line, fun.col);
                }                               //simbolo a los parametros
                fun.setAmbito(sym.getAmbito()); 
                contador=3;     //add dir(ref,retorno,dir_retorno)
                for (HashMap param : fun.parameters) {          //syms de params
                    String idparam = (String)param.get("id");
                    Simbolo symPar = new Simbolo((Tipo)param.get("tipo"), idparam, null, true);
                    symPar.setCat(categoria.PARAM);
                    symPar.setDir(contador);
                    symPar.setAmbito(fun.getAmbito());
                    symPar.armarAmbito((String)param.get("id"));
                    tabla.addSsymbolPas(symPar);            //add symParam
                    sym.setInstruction(fun);
                    contador++;
                }
                fun.setCantParams(contador);
                fun.createSym(arbol, tabla);
            }
            
        }
        
        return null;
    }

    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String generarast(Arbol arbol, String anterior) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setTodasLasins(LinkedList<Instruction> todasLasins) {
        this.todasLasins = todasLasins;
    }

    public LinkedList<Instruction> getFuncionesPascal() {
        return funcionesPascal;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
