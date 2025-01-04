/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instrucciones;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.LogicalOperations;
import com.wilsoncys.compi1.java.model.expresiones.OperateRelacionales;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
public class IF extends Instruction{
    private Instruction expression;
    private LinkedList<Instruction> instructionss;
    private LinkedList<Instruction> instructionsElse;

    private Instruction  elif;
                                                     //simple IF
    public IF(Instruction expression, LinkedList<Instruction> instructionss, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expression = expression;
        this.instructionss = instructionss;
    }

                                                    //elssssssssss
    public IF(Instruction expression, LinkedList<Instruction> instructionss, LinkedList<Instruction> instructionsElse, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expression = expression;
        this.instructionss = instructionss;
        this.instructionsElse = instructionsElse;
    }
                                                   //ELIfffff
    public IF(Instruction expression, LinkedList<Instruction> instructionss,  Instruction elif, int linea, int col) {
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
                if(instructions instanceof transferBreak){
                    return instructions;
                }
                if(instructions instanceof transferContinue){
                    return instructions;
                }
                
                                if(instructions instanceof transferReturn){
                                    return instructions;
                                }
                var ifSimple = instructions.interpretar(arbol, blockTabla);
                if(ifSimple instanceof transferReturn){
                    return ifSimple;
                }
                
                if(ifSimple instanceof transferContinue){
                    return ifSimple;
                }
                if(ifSimple instanceof transferBreak){
                    return ifSimple;
                }
                
                if(ifSimple instanceof Errores){
                    return ifSimple;
                }
                
            }
        }else{
            if(instructionsElse!=null){     //realiza las instrucciones del else
                for (var instructions : instructionsElse) {
                    if(instructions instanceof transferBreak){
                        return instructions;
                    }
                    if(instructions instanceof transferContinue){
                        return instructions;
                    }
                    if(instructions instanceof transferReturn){
                        return instructions;
                    }
                  
                    var elseResult = instructions.interpretar(arbol, blockTabla);       //execute Ins
                    if(elseResult instanceof transferReturn){
                        return elseResult;
                    }
                    if(elseResult instanceof transferContinue){
                        return instructions;
                    }
                    if( elseResult instanceof transferBreak){
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
                    if(resultElif instanceof transferReturn){
                        return resultElif;
                    }
                    if(resultElif instanceof transferContinue){
                        return resultElif;
                    }
                    if( resultElif instanceof transferBreak){
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
        String armed = "";
        C3d_Java c = arbol.getJava();
        
        String idIf = "if" + c.countCreateVar;
        c.countCreateVar++;
        String idSalida= "salida" + c.countCreateVar;
        c.countCreateVar++;
        
        String idElse= "ifElse" + c.countCreateVar;
        c.countCreateVar++;
          
        
        //create a la condicion 
        if(this.expression instanceof OperateRelacionales){
          armed+= expression.createC3D(arbol, anterior);
          String op1 = c.varsParams.get(0); 
          c.varsParams.removeFirst();
          String op2 = c.varsParams.get(0);  
          c.varsParams.removeFirst();
          
          if(instructionsElse==null){
              armed+= c.cond_If(op1, op2, idIf, idSalida);
          }else{
              armed+= c.cond_If(op1, op2, idIf, idElse);
          }

        }else if(this.expression instanceof LogicalOperations log){
            if(instructionsElse!=null){
                log.setElseIns(true);
            }
            armed += log.createC3D(arbol, anterior);
        }
                                
        
//        label if
        armed+= idIf +  ":\n";
                                          //instrucciones del IF
        for (Instruction instructions : instructionss) {
            if(instructions ==null){
                continue;
            }
            armed+= instructions.createC3D(arbol, anterior);
//            arbol.getCurrentAmbit().set(1, ambitoAnt);
    
        }
        armed+= "goto " + idSalida + ";\n";
        
        
        if(instructionsElse!=null){         //instrucciones del ELSE 
        //        label else
        armed+= idElse +  ":\n";      
        for (Instruction instructions : instructionsElse) {
            if(instructions ==null){
                continue;
            }
            armed+= instructions.createC3D(arbol, anterior);
//            arbol.getCurrentAmbit().set(1, ambitoAnt);
    
        }

//                      label salida
            armed+= idSalida +  ":\n";

        }else if(elif!=null){   // instrucciones del Elif



        }else{
//                      label salida
            armed+= idSalida +  ":\n";
            
        }
            
             
        
         
        
        return armed;
    }
    
}
