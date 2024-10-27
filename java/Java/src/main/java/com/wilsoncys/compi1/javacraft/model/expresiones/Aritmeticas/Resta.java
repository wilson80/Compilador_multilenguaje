/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.expresiones.Aritmeticas;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.expresiones.Enums.OperadoresAritmeticos;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;

/**
 *
 * @author Jonwil
 */
public class Resta extends Instruction {

    private Instruction operando1;
    private Instruction operando2;
    private OperadoresAritmeticos operacion;
    private Instruction operandoUnico;


    //cualquier operacion menos negacion
    public Resta(Instruction operando1, Instruction operando2, OperadoresAritmeticos operacion, int linea, int col) {
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
        return this.restar(opIzq, opDer);
    }



    public Object restar(Object obj1, Object obj2){
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();
        
        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        return (int) obj1 - (int) obj2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (int) obj1 - (double) obj2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        int first = (int)obj1;
                        char caracter = obj2.toString().charAt(0);
                        int second = caracter;
                        return first-second;
                    }
                    default->{
                            return  new Errores("SEMANTICO","restando a un entero", this.line, this.col );
                    }
                }
            }
            
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) obj1 - (int) obj2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) obj1 - (double) obj2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        double first = (double)obj1;
                        char caracter = obj2.toString().charAt(0);
                        int second = caracter;
                        return first-second;
                    }
                    default->{
                            return  new Errores("SEMANTICO","restando a un entero", this.line, this.col );
                    }
                }
            }
            
            case CARACTER -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        char charac = obj1.toString().charAt(0);
                        int firstdOp = charac;
                        return  firstdOp - (int) obj2;
                    }
                    case DECIMAL -> {   
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        char charac = obj1.toString().charAt(0);
                        int firstdOp = charac;
                        return firstdOp - (double)obj2;
                    }
                    case CARACTER -> {
                        return  new Errores("SEMANTIC","restando un caracter a un caracter", this.line, this.col );
                    }
                    default->{
                            return  new Errores("SEMANTIC","restando a un entero", this.line, this.col );
                    }
                }
            }
            default->{
                return new Errores("SEMANTIC", "operando1 invalido al realizar una resta", line, col);

            }
        }        
                    
    } 
    
@Override
    public String generarast(Arbol arbol, String anterior) {
        //exp op exp
        String nodoExp1 = "n" + arbol.getCount();
        String nodoOp = "n" + arbol.getCount();
        String nodoExp2 = "n" + arbol.getCount();

        String strinRes = anterior + " -> " + nodoExp1 + ";\n";
        strinRes += anterior + " ->" + nodoOp + ";\n";
        strinRes += anterior + " ->" + nodoExp2 + ";\n";

        strinRes += nodoExp1 + "[label=\"EXP\"];\n";
        strinRes += nodoOp + "[label=\"-\"];\n";
        strinRes += nodoExp2 + "[label=\"EXP\"];\n";
        strinRes += this.operando1.generarast(arbol, nodoExp1);
        strinRes += this.operando2.generarast(arbol, nodoExp2);
        return strinRes;
    }
    
    
    
        public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
        
            @Override
    public Object createC3D(Arbol arbol, String anterior) {
        return anterior;
    }
    
}