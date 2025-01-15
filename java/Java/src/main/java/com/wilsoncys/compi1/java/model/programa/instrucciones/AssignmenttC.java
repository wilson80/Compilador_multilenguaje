/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.instrucciones;

import com.wilsoncys.compi1.java.model.instrucciones.*;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.Access;
import com.wilsoncys.compi1.java.model.expresiones.Input;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.poo.Call;
import com.wilsoncys.compi1.java.model.programa.call_to_java;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.lang.annotation.Native;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class AssignmenttC extends Instruction{
    private String id;
    private String idField = null;
    private String elseField = null;
    private Instruction expr;
    private int whatConstruct = 0;
    private boolean isThis = false;

    public AssignmenttC(String id, Instruction exp, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expr = exp;
        this.whatConstruct = 0;
    }

//    public AssignmenttC(boolean isThis, String id, Instruction expression, int linea, int col) {
//        super(new Tipo(tipoDato.VOID), linea, col);
//        this.id = id;
//        this.expr = expression;
//        this.whatConstruct = 1;
//        this.isThis = isThis;
//    }
//    
//    public AssignmenttC(String id,  String idField, String elseField, Instruction expression, int linea, int col) {
//        super(new Tipo(tipoDato.VOID), linea, col);
//        this.id = id;
//        this.expr = expression;
//        this.idField = idField;
//        this.elseField = elseField;
//        this.whatConstruct = 2;
//    }

  
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
   
        
        //verificar existencia de la variable 
        var simboloExistente = tabla.getSsymbol(id);
        if (simboloExistente == null) {
            String mensajeError = "La Variable: " + id + " no existe";
            return new Errores("SEMANTICO", mensajeError,
                    this.line, this.col);
        }
        
        // interpretar el nuevo valor a asignar
        var newValor = this.expr.interpretar(arbol, tabla);
        if (newValor instanceof Errores) {
            return newValor;
        }


        //this.tipo.setTipo(variable.getTipo().getTipo());
        if(simboloExistente.isConst()){ // es un error si es constante ya no se le puede asignar un nuevo valor
            return  new Errores("SEMANTIC", "No puede cambiarle el valor a una variable constante", line, col);
        }else{
            //validar tipos del valor a asignar y de la variable existente
//            var tipo1
            if (simboloExistente.getTipo().getTipo() != this.expr.tipo.getTipo()) {
                String mensajeError = "Tipos erroneos al asignar a la variable: " + id;
                return new Errores("SEMANTICO",mensajeError,
                        this.expr.line, this.expr.col);
            }
            simboloExistente.setValor(newValor);
            return null;
        }
        
        
    }
    
//    public boolean verifyMuta(Simbolo simbolo){
//        if(simbolo.isMutable()){
//            return true;
//        }else{
//            return false;
//        }
//    }

    
 
        
        @Override
    public String generarast(Arbol arbol, String anterior) {
        String algo = anterior;
        algo = expr.generarast(arbol, anterior);
        
        
        return algo;
    }
    
        public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
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
        
        if(expr instanceof getchC gg){
            gg.setTipoGetch(this.getTyStr());
            armed += gg.createC3D(arbol, anterior);
            armed += c.c3d_asignVal(this.getTyStr(), anterior.getVars(), dir);
            
             
         }else {    //declaracion con valor nativo
               armed += this.expr.createC3D(arbol, anterior);
              armed += c.c3d_asignVal(this.getTyStr(), anterior.getVars(), dir);
         } 
            
         
         
            armed +="\n";
        return armed;
    }
}


