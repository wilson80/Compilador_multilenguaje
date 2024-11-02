/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.expresiones;

import com.wilsoncys.compi1.java.model.expresiones.Enums.OperadoresAritmeticos;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;

/**
 *
 * @author Jonwil
 */
/*
- E
E + E
E - E
 */
public class Negacion extends Instruction {

    private OperadoresAritmeticos operacion;
    private Instruction operandoUnico;

    //negacion 
    public Negacion(Instruction operandoUnico, OperadoresAritmeticos operacion, int linea, int col) {
        super(new Tipo(tipoDato.ENTERO), linea, col);
        this.operacion = operacion;
        this.operandoUnico = operandoUnico;
    }


    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object opIzq = null;
        Object opDer = null; 
        Object Unico = null;
        if (this.operandoUnico != null) {
            Unico = this.operandoUnico.interpretar(arbol, tabla);
            if (Unico instanceof Errores) {
                return Unico;
            }
        } 
        return this.negacion(Unico);
    }
    
    
    public Object negacion(Object op1) {
        var opU = this.operandoUnico.tipo.getTipo();
        switch (opU) {
            case ENTERO -> {
                this.tipo.setTipo(tipoDato.ENTERO);
                return (int) op1 * -1;
            }
            case DECIMAL -> {
                this.tipo.setTipo(tipoDato.DECIMAL);
                return (double) op1 * -1;
            }
            case  CADENA -> {
                return new Errores("SEMANTICO", "Negacion erronea aplicada a una cadena", this.line, this.col);
            }
            case  CARACTER -> {
                return new Errores("SEMANTICO", "Negacion erronea aplicada a un caracter", this.line, this.col);
            }
            case  BOOLEANO -> {
                return new Errores("SEMANTICO", "Negacion erronea aplicada a un Booleand", this.line, this.col);
            }
            default -> {
                return new Errores("SEMANTICO", "Negacion erronea", this.line, this.col);
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
