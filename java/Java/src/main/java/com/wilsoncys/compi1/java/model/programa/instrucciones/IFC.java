/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.instrucciones;

import com.wilsoncys.compi1.java.model.programa.instrucciones.*;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
 
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
public class IFC extends Instruction{
    private Instruction expression;
    private LinkedList<Instruction> instructionss;
    private LinkedList<Instruction> instructionsElse;

    private Instruction  elif;
                                                     //simple IF
    public IFC(Instruction expression, LinkedList<Instruction> instructionss, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expression = expression;
        this.instructionss = instructionss;
    }

                                                    //elssssssssss
    public IFC(Instruction expression, LinkedList<Instruction> instructionss, LinkedList<Instruction> instructionsElse, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expression = expression;
        this.instructionss = instructionss;
        this.instructionsElse = instructionsElse;
    }
                                                   //ELIfffff
    public IFC(Instruction expression, LinkedList<Instruction> instructionss,  Instruction elif, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expression = expression;
        this.instructionss = instructionss;
        this.elif = elif;
    }
    
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        var valueExp = this.expression.interpretar(arbol, tabla);
        if(valueExp instanceof Errores){
            return valueExp;
        }
        
        if(this.expression.tipo.getTipo()!=tipoDato.BOOLEANO){
            return new Errores("SEMANTIC", "tipo invalido dentro de una condicional", line, col);    //entrar verificar el else
        }
        
        var  blockTabla = new TablaSimbolos(tabla);
        
        String isTruee = valueExp.toString();
        
        if(isTruee.equals("true")){             //primer Ifff
            for (var instructions : instructionss) {
                //agregar el continue por si viene una instruccion nula
                if(instructions instanceof transferBreakC){
                    return instructions;
                }
                if(instructions instanceof transferContinueC){
                    return instructions;
                }
                
                                 
                var ifSimple = instructions.interpretar(arbol, blockTabla);
              
                if(ifSimple instanceof transferContinueC){
                    return ifSimple;
                }
                if(ifSimple instanceof transferBreakC){
                    return ifSimple;
                }
                
                if(ifSimple instanceof Errores){
                    return ifSimple;
                }
                
            }
        }else{
            if(instructionsElse!=null){     //realiza las instrucciones del else
                for (var instructions : instructionsElse) {
                    if(instructions instanceof transferBreakC){
                        return instructions;
                    }
                    if(instructions instanceof transferContinueC){
                        return instructions;
                    }
                     
                  
                    var elseResult = instructions.interpretar(arbol, blockTabla);       //execute Ins
                     
                    if(elseResult instanceof transferContinueC){
                        return instructions;
                    }
                    if( elseResult instanceof transferBreakC){
                        return elseResult;
                    }
                    if(elseResult instanceof Errores){
                        return elseResult;
                    }
                        
                }
            }else if(elif!=null){   //realiza las instrucciones del Elif
                var resultElif = elif.interpretar(arbol, blockTabla);       //execute
                    if(resultElif instanceof Errores){
                        return resultElif;
                    }
                    
                    if(resultElif instanceof transferContinueC){
                        return resultElif;
                    }
                    if( resultElif instanceof transferBreakC){
                        return resultElif;
                    }
            }
        }   
        return null;
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
