/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.expresiones.Aritmeticas;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.expresiones.Enums.OperadoresAritmeticos;
import com.wilsoncys.compi1.javacraft.model.sC3D.C3d;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Simbolo;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
public class Suma extends Instruction {

    private Instruction operando1;
    private Instruction operando2;
    private OperadoresAritmeticos operacion;
    private Instruction operandoUnico;


    //cualquier operacion menos negacion
    public Suma(Instruction operando1, Instruction operando2, OperadoresAritmeticos operacion, int linea, int col) {
        super(new Tipo(tipoDato.ENTERO), linea, col);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object opIzq = null;
        Object opDer = null; 
 
        opIzq = this.operando1.interpretar(arbol, tabla);
        if (opIzq instanceof Errores) {
            return opIzq;
        }
        opDer = this.operando2.interpretar(arbol, tabla);
        if (opDer instanceof Errores) {
            return opDer;
        }
        return  sumar(opIzq, opDer);
    }

    public Object sumar(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        
        
        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        return (int) op1 + (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (int) op1 + (double) op2;
                    }
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        int first = (int)op1;
                        char caracter = op2.toString().charAt(0);
                        int second = caracter;
                        return first+second;
                    }   
                    case BOOLEANO -> {
                        return new Errores("SEMANTIC ERROR", "No puede sumar un entero con un booleano", this.line, this.col);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea (tipo2 invalido) al sumar enteros", this.line, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 + (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 + (double) op2;
                    }
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        char opSecond = op2.toString().charAt(0);
                        int operador2 = opSecond;
                        return (double)op1 + operador2;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea (tipo 2 invalido)en operacion: entero + decimales", this.line, this.col);
                    }
                }
            }
            case BOOLEANO -> {
                switch (tipo2) {
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "sumando un booleano con un operando diferente de cadena", this.line, this.col);

                    }
                } 
            }
            case CARACTER -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        char charac = op1.toString().charAt(0);
                        int opfirst = charac;
                        return opfirst + (int)op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        char charac = op1.toString().charAt(0);
                        int opfirst = charac;
                        return opfirst + (double)op2;
                    }
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "sumando a un caracter tipo 2 invalido", this.line, this.col);

                    }
                }
            }
            
//             1 + 9 - 8 * 2 / 4 % 2 + (5 ** 2);
            
            case CADENA -> {
//                switch (tipo1) {
//                    case CADENA->{
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
//                    }
//                    default->{
//                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.col);
//
//                    }
//                }
            }
            
            default -> {
                return new Errores("SEMANTICO", "Suma erronea (tipo 1 invalido)", this.line, this.col);

            }
        }
    }

   @Override
    public String generarast(Arbol arbol, String anterior) {
        // neg y exp sig exp
//        if (this.operacion == OperadoresAritmeticos.NEGACION) {
//            return "";
//        }

        //exp op exp
//                String nodoExp1 = "n" + arbol.getCount();
//                String nodoOp = "n" + arbol.getCount();
//                String nodoExp2 = "n" + arbol.getCount();
//
//                String strinRes = anterior + " -> " + nodoExp1 + ";\n";
//                strinRes += anterior + " ->" + nodoOp + ";\n";
//                strinRes += anterior + " ->" + nodoExp2 + ";\n";
//
//                strinRes += nodoExp1 + "[label=\"EXP\"];\n";
//                strinRes += nodoOp + "[label=\"+\"];\n";
//                strinRes += nodoExp2 + "[label=\"EXP\"];\n";
                String algo = anterior;
                String op = "+";
                String op1 = this.operando1.generarast(arbol, "");
                String op2 = this.operando2.generarast(arbol, "");
                algo+= op1 + op + op2;
                

                return algo;
    }
    
    
    
    
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
    
    
        @Override
    public Object createC3D(Arbol arbol, String anterior) {
        String armed = "";
        C3d c=  arbol.getC3d();
        c.varsParams = new ArrayList<>();
        armed+=operando1.createC3D(arbol, anterior);
        armed+=operando2.createC3D(arbol, anterior);
        
        return armed;
    }
}