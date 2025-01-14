/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.expresiones.Aritmeticas;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.asbtracto.CreadorC3d;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.Enums.OperadoresAritmeticos;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

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
 

                return "";
    }
    
     
    
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
    
    
        @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        setPos(arbol);
        String armed = "";
        String op1 = "";
        String op2 = "";
        C3d_Java c = arbol.getJava();
//        }else{
//             c =  arbol.getC3d();
//        }
        
          
//        c.getVarsParams().clear();
//        
//        if(operando1 instanceof Nativo){        
//            operando1.createC3D(arbol, anterior);   //inser en la lista
//            op1 = c.getVarsParams().get(0);
//            c.getVarsParams().removeFirst();
//            armed+=c.c3d_asignAlone(op1);
//            op1 = c.getVarsParams().get(0);
//            c.getVarsParams().removeFirst();
//            
//        }else{
//            armed+=operando1.createC3D(arbol, anterior);
//            op1 = c.getVarsParams().get(0);
//            c.getVarsParams().removeFirst();
//            
//        }
//        
//        if(operando2 instanceof Nativo){            
//            operando2.createC3D(arbol, anterior);   //inser en la lista
//            op2 = c.getVarsParams().get(0);
//            c.getVarsParams().removeFirst();
//            armed+=c.c3d_asignAlone(op2);
//            op2 = c.getVarsParams().get(0);
//            c.getVarsParams().removeFirst();
//        }else{
//            armed+=operando2.createC3D(arbol, anterior);
//            op2 = c.getVarsParams().get(0);
//            c.getVarsParams().removeFirst();
//        }
//        
//        c.setOPRT("+");
//        armed+=c.c3d_operation(op1, op2);
//        c.getVarsParams().add("w"+(c.getContador()-1));  //guarda el id de la var q contiene el resultado

        return armed;
    }
}