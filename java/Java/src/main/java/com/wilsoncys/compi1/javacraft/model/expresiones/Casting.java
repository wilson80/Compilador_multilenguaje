/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.expresiones;

import com.wilsoncys.compi1.javacraft.model.expresiones.Enums.OperadoresAritmeticos;
import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;

/**
 *
 * @author Jonwil
 */

public class Casting extends Instruction {
    private Instruction exp;

    public Casting(Tipo tipo, Instruction exp, int linea, int col) {
        super(tipo, linea, col);
        this.exp = exp;
    }
    

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        var valor = this.exp.interpretar(arbol, tabla);
        if(valor!=null){
            if(valor instanceof Errores){
                return valor;
            }
        }
        return this.cast(valor);
        
    }
    
    public Object cast(Object valorCasting) {
        var typeOne = this.tipo.getTipo();
        var typeTwo = this.exp.tipo.getTipo();
        switch (typeOne) {
            case ENTERO -> {
                switch (typeTwo) {
                    case ENTERO->{
                        return (int)valorCasting;
                    }
                    case DECIMAL->{
                        return (int)((double)valorCasting);
                    }
                    case CARACTER->{
                        char character = valorCasting.toString().charAt(0);
                        int newValuee = character;
                        return newValuee;
                    }
                    default->{
                                            return (int)valorCasting;
                            
//                        return new Errores("SEMANTIC", "El tipo de la variable no admite casteo", line,col);
                    }
                }
                
            }
            
            case CARACTER -> {
                switch (typeTwo) {
                    case ENTERO->{
                        int newValor = (int)valorCasting;
                        return (char)newValor;
                    }
                    case CARACTER->{
                        return valorCasting;
                    }
                    default->{
                        return new Errores("SEMANTIC", "El tipo de la variable no admite casteo", line,col);
                    }
                }
                
            }
            case DECIMAL -> {
                switch (typeTwo) {
                    case ENTERO->{
                        int newValor = (int)valorCasting;
                        return (double)newValor;
                    }
                    case DECIMAL->{
                        return (double)valorCasting;
                    }
                    case CARACTER->{
                        char character = valorCasting.toString().charAt(0);
                        int newValuee = character;
                        return (double)newValuee;
                    }
                    default->{
                        return new Errores("SEMANTIC", "El tipo de la variable no admite casteo", line,col);
                    }
                }
                
            }
            
            default -> {
//                            return valorCasting.toString();
                return new Errores("SEMANTICO", "El tipo ingresado no admite casteo", this.line, this.col);
            }
        }
    }
    
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
    
        public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
    
        
            @Override
    public Object createC3D(Arbol arbol, String anterior) {
        return anterior;
    }
}

