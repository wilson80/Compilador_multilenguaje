/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instruccionesPas;


import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.HashMap;

/**
 *
 * @author Jonwil
 */
  public class AssignmenttPas extends Instruction{
    private String id;
    private String idField = null;
    private String elseField = null;
    private Instruction expression;

    public AssignmenttPas(String id, Instruction exp, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expression = exp;
    }

    public AssignmenttPas(String id,  String idField, Instruction expression, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expression = expression;
        this.idField = idField;
    }
    
    public AssignmenttPas(String id,  String idField, String elseField, Instruction expression, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expression = expression;
        this.idField = idField;
        this.elseField = elseField;
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
        var newValor = this.expression.interpretar(arbol, tabla);
        if (newValor instanceof Errores) {
            return newValor;
        }


        //this.tipo.setTipo(variable.getTipo().getTipo());
        if(simboloExistente.isConst()){ // es un error si es constante ya no se le puede asignar un nuevo valor
            return  new Errores("SEMANTIC", "No puede cambiarle el valor a una variable constante", line, col);
        }else{
            //validar tipos del valor a asignar y de la variable existente
//            var tipo1

            if (simboloExistente.getTipo().getTipo() != this.expression.tipo.getTipo()) {
                String mensajeError = "Tipos erroneos al asignar a la variable: " + id;
//                if(simboloExistente.getTipo().getTipo() == tipoDato.NEWTYPE){
//                    if(this.expression.tipo.getTipo() != simboloExistente.getTipo().getCurrentType()){
//                        return new Errores("SEMANTICO",mensajeError,
//                                this.expression.line, this.expression.col);
//                    }
//                }else{
//                    return new Errores("SEMANTICO",mensajeError,
//                            this.expression.line, this.expression.col);
//                }
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
                    var valueExp = this.expression.interpretar(arbol, tabla);
                    if(valueExp instanceof  Errores){
                        return valueExp;
                    }
                    //validar los tipos
                    if(symStruc.isConst()){ // es un error si es constante ya no se le puede asignar un nuevo valor
                        return  new Errores("SEMANTIC", "Struct instanciado como const (Al asignar)", line, col);
                    }else{
                        //validar tipos 
                        if (sym3.getTipo().getTipo() != this.expression.tipo.getTipo()) {
                            mensErr = "Tipos erroneos al asignar a un campo de Struct " + id + " ";
                            return new Errores("SEMANTICO",mensErr,
                                    this.expression.line, this.expression.col);
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
                    var valueExp = this.expression.interpretar(arbol, tabla);
                    if(valueExp instanceof  Errores){
                        return valueExp;
                    }

                    //validar los tipos
                    if(symStruc.isConst()){ // es un error si es constante ya no se le puede asignar un nuevo valor
                        return  new Errores("SEMANTIC", "Struct instanciado como const (Al asignar)", line, col);
                    }else{
                        //validar tipos 
                        if (fieldSymbol.getTipo().getTipo() != this.expression.tipo.getTipo()) {
                            mensErr = "Tipos erroneos al asignar a un campo de Struct " + id + " ";
                            return new Errores("SEMANTICO",mensErr,
                                    this.expression.line, this.expression.col);
                        }
                        fieldSymbol.setValor(valueExp);
                        return null;
                    }
            }
            

        }

        
        @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}


