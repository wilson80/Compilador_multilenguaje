/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instruccionesPas;


import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
public class OneCasePas extends Instruction{
    private Instruction instruction;
    private LinkedList<Instruction> expresiones;
    private Object valorMatch;
    private tipoDato tipoValorMatch;
    
    private boolean matchh = false;

    public OneCasePas(LinkedList<Instruction> expresiones, Instruction  instruction, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresiones = expresiones;
        this.instruction = instruction;
    }

    @Override                               
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        for (Instruction expresion : expresiones) {
             //interpret valor de la expresion del caso
            var valorCase = expresion.interpretar(arbol, tabla);
            if(valorCase instanceof Errores){
                return valorCase;
            }

            //verify type expresion del match con el expresion del caso
            if(tipoValorMatch != expresion.tipo.getTipo()){
                String mensajeError = "Tipos erroneos del caso con expresion: " + valorMatch.toString() + "En instruccion Match";
                return new Errores("SEMANTIC", mensajeError, line, col);
            }//        verify match
            if(valorMatch.equals(valorCase)){
                matchh = true;
            }
        }
        
        if(matchh){             //interpreta la instruccion
            var instruccionDelCaso = instruction.interpretar(arbol, tabla);
            if(instruccionDelCaso instanceof Errores){
                return instruccionDelCaso;
            }
            return true;
        }else{
            return false;
        }  
                //            ejecutarInstrucciones
        
    }
    
    public void setExpressionMatch(Object expressionMatch) {
        this.valorMatch = expressionMatch;
    }

    public void setTipoValorMatch(tipoDato tipoValorMatch) {
        this.tipoValorMatch = tipoValorMatch;
    }


//    public LinkedList<Instruction> getInstructionss() {
//        return instructionss;
//    }

    public boolean isMatchh() {
        return matchh;
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
