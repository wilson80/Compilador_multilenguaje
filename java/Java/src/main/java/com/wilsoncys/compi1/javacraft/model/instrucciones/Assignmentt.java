/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.instrucciones;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.expresiones.Nativo;
import com.wilsoncys.compi1.javacraft.model.poo.Call;
import com.wilsoncys.compi1.javacraft.model.sC3D.C3d;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Simbolo;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;
import java.lang.annotation.Native;
import java.util.HashMap;

/**
 *
 * @author Jonwil
 */
public class Assignmentt extends Instruction{
    private String id;
    private String idField = null;
    private String elseField = null;
    private Instruction expr;
    private int whatConstruct = 0;


    public Assignmentt(String id, Instruction exp, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expr = exp;
        this.whatConstruct = 0;
    }

    public Assignmentt(String id,  String idField, Instruction expression, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expr = expression;
        this.idField = idField;
        this.whatConstruct = 1;
    }
    
    public Assignmentt(String id,  String idField, String elseField, Instruction expression, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expr = expression;
        this.idField = idField;
        this.elseField = elseField;
        this.whatConstruct = 2;
    }


    
    

//    num1 = 5;
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        if(idField!=null){
            return structAssignment(arbol, tabla);
        }
        
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

        public Object structAssignment(Arbol arbol, TablaSimbolos tabla) {
            Simbolo symStruc = tabla.getSsymbol(id);        //buscar el simbolo
            if(symStruc ==  null){
                mensErr = "No se encontro la variable con ID: " + id+ " ";
                return new Errores("SEMANTIC",mensErr, line, col);
            }
            if(symStruc.getTipoStruct().isEmpty()){         //verificar si es un struct 
                mensErr = "El struct: " + id+ " No existe ";
                return new Errores("SEMANTIC",mensErr, line, col);
            }
            
            
            HashMap hassym =(HashMap)symStruc.getValor();
            if(elseField!=null){ //id.id.id     id1(identifi).p(persona).nombre
                HashMap elseMap = (HashMap)hassym.get(idField);
                Simbolo sym3 = (Simbolo)elseMap.get(elseField);
                //interpretar la exp
                    var valueExp = this.expr.interpretar(arbol, tabla);
                    if(valueExp instanceof  Errores){
                        return valueExp;
                    }
                    //validar los tipos
                    if(symStruc.isConst()){ // es un error si es constante ya no se le puede asignar un nuevo valor
                        return  new Errores("SEMANTIC", "Struct instanciado como const (Al asignar)", line, col);
                    }else{
                        //validar tipos 
                        if (sym3.getTipo().getTipo() != this.expr.tipo.getTipo()) {
                            mensErr = "Tipos erroneos al asignar a un campo de Struct " + id + " ";
                            return new Errores("SEMANTICO",mensErr,
                                    this.expr.line, this.expr.col);
                        }
                        sym3.setValor(valueExp);
                        return null;
                    }
                    
                    
            }else{               // id.id           p.nombre
                Simbolo fieldSymbol = (Simbolo)hassym.get(idField);
                if(fieldSymbol ==null){
                        mensErr = "Campo del struct incorrecto: " + idField+ " ";
                        return new Errores("SEMANTIC",mensErr, line, col);
                    }

                    //interpretar la exp
                    var valueExp = this.expr.interpretar(arbol, tabla);
                    if(valueExp instanceof  Errores){
                        return valueExp;
                    }

                    //validar los tipos
                    if(symStruc.isConst()){ // es un error si es constante ya no se le puede asignar un nuevo valor
                        return  new Errores("SEMANTIC", "Struct instanciado como const (Al asignar)", line, col);
                    }else{
                        //validar tipos 
                        if (fieldSymbol.getTipo().getTipo() != this.expr.tipo.getTipo()) {
                            mensErr = "Tipos erroneos al asignar a un campo de Struct " + id + " ";
                            return new Errores("SEMANTICO",mensErr,
                                    this.expr.line, this.expr.col);
                        }
                        fieldSymbol.setValor(valueExp);
                        return null;
                    }
            }
            

        }

        
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
    public Object createC3D(Arbol arbol, String anterior) {
        String armed = "";
        C3d c3d =  arbol.getC3d();
        if(this.expr instanceof Nativo){    //declaracion con valor vativo
            int dir = arbol.getSym(id).getDir();
            this.expr.createC3D(arbol, anterior);
            armed = c3d.c3d_asignVal("", dir);
        }else if(this.expr instanceof Call call){                          //declaracion y asignacion
            int dir = arbol.getSym(id).getDir();
                //pndte
                                                //create a la llamada
            armed+= call.createC3D(arbol, anterior);
                                            //asignacion
//            //mover el ptr temporal
//            armed+=c3d.c3d_ptrTemp(arbol.getSizeStack());
//            //obtener valor del return
//            armed+=c3d.c3d_accesTemp(id, arbol.getPosReturn());
            //asignar
            c3d.setPtrTemp("ptr");
            armed+=c3d.c3d_asignVar(id, dir);
            c3d.clearPtrTemp();
            
        }
        
        
        
        
//        //assig 
//    tr6 = ptr + dir;
//    stack[tr6] = var;
        
        
            armed +="\n";
        return armed;
    }
}


