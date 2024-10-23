/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.instrucciones;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Simbolo;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.tablaSimbolos;

/**
 *
 * @author Jonwil
 */


public class Statement extends Instruction{

    public String identificador;
    public Instruction valor;
    private boolean declaracionSimple;
    private boolean isConst;

                                                    //    var num1:int;
    //constructor sin asignacion (declaracion simple)
    public Statement(String identificador, Tipo tipo, int linea, int col, boolean isMutable) {
        super(tipo, linea, col);
        this.identificador = identificador;
        this.declaracionSimple = true;
        this.isConst = isMutable;
    }
                                                   //    var num1:int = 5;
    //constructor con asignacion
    public Statement(String identificador, Instruction valorVariable_exp, Tipo tipo, int linea, int col, boolean isMutable) {
        super(tipo, linea, col);
        this.identificador = identificador;
        this.valor = valorVariable_exp;
        this.declaracionSimple = false;
        this.isConst = isMutable;
    }
//    \\\\analizar

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        if(declaracionSimple){
            return declare(arbol, tabla);
        }else{
            return declareAssign(arbol, tabla);
        }
    }

    public Object declare(Arbol arbol, tablaSimbolos tabla) {
            //validando la existencia de la variable
        Simbolo newSymbol = new Simbolo(this.tipo, identificador, darValorDefecto(), isConst);    
        newSymbol.setLinea(line);
        newSymbol.setLinea(col);
        boolean isCreacion = tabla.addSsymbol(newSymbol);
        
        if(isCreacion){
            return null;
        }else{
            return new Errores("SEMANTIC", "la variable ya existe", line, col);
        }
        
    }

    public Object declareAssign(Arbol arbol, tablaSimbolos tabla) {
        // interpretar para obtener el valor
        var valorInterpretado = this.valor.interpretar(arbol, tabla);

        //validar posible error
        if (valorInterpretado instanceof Errores) {
            return valorInterpretado;
        }

        //validar el tipo de la variable a asignar con el tipo declarado
                    if (this.valor.tipo.getTipo() != this.tipo.getTipo()) {
                        return new Errores("SEMANTICO", "Tipos erroneos", this.line, this.col);
                    }

        Simbolo newSsimbol = new Simbolo(this.tipo, this.identificador, valorInterpretado, isConst);
        newSsimbol.setLinea(line);
        newSsimbol.setLinea(col);
        boolean creacion = tabla.addSsymbol(newSsimbol);
        if (creacion) {
            return null; 
        }else{      //si creacion es false(significa que la variable existe) se devuelve un error
            return new Errores("SEMANTICO", "La Variable ya existent", this.line, this.col);
        }

    }
    
    public Object darValorDefecto(){
        switch (tipo.getTipo()) {
            case ENTERO->{
                return 0;
            }
            case DECIMAL->{
                return 0.0;
            }
            case CADENA->{
                return "";
            }
            case BOOLEANO->{
                return  true;
            }
            case CARACTER->{
                return  '0';
            }
            default->{
                return "";
            }
        }
        
                
    }
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
}



