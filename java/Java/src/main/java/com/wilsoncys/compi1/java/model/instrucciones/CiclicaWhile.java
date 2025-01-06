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
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class CiclicaWhile extends Instruction{
    private Instruction expression;
    private LinkedList<Instruction> instructionss;
    private boolean isDoWhile;

    public CiclicaWhile(Instruction expression, LinkedList<Instruction> instructionss,boolean isDowhile, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expression = expression;
        this.instructionss = instructionss;
        this.isDoWhile = isDowhile;
        
    }
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        if(isDoWhile){
            return this.doWhile(arbol, tabla);
        }
            
            // create new block
        // interpret expression 
        var valorExp = this.expression.interpretar(arbol, tabla);
        
//            verfify type boolean  
        if(this.expression.tipo.getTipo()!=tipoDato.BOOLEANO){
            return new Errores("SEMANTIC", "Valor invalido en la condicion de la sentencia ciclica while", line, col);
        }
        
//            verfify valor de la condicion
            //execute instructions
            
        while (valorExp.toString().equals("true")) {    
        var newTable = new TablaSimbolos(tabla);
            
            for (Instruction instructions : instructionss) {
                if(instructions==null){     //validacion si la instruccion es nula
                    continue;
                }
                if(instructions instanceof transferBreak){
                    return null;
                } 
                if(instructions instanceof transferContinue){
                    break;
                } 
                if(instructions instanceof transferReturn){
                    return instructions;
                } 
                
                var value = instructions.interpretar(arbol, newTable);
                
                if(value instanceof transferReturn){
                    return value;
                } 
                
                if(value instanceof transferContinue){
                    break;
                } 
                if(value instanceof transferBreak){
                    return null;
                } 
                if(value instanceof Errores){
                    return value;
                } 
            }
            valorExp = this.expression.interpretar(arbol, newTable); // interpreta nuevamente la condicion

        }
//            return null; //no entra en el while
//            la actualizacion es hecha por codigo del usuario
        return null;
    }
    
public Object doWhile(Arbol arbol, TablaSimbolos tabla){
        // create new block
        var newTable = new TablaSimbolos(tabla);
//        // interpret expression 
        Object valorExp;
//            verfify type boolean  
        if(this.expression.tipo.getTipo()!=tipoDato.BOOLEANO){
            return new Errores("SEMANTIC", "Valor invalido en la condicion de la sentencia ciclica DoWhile", line, col);
        }
            do {        
                for (Instruction instructions : instructionss) {
                    if(instructions == null){           //validacion de instruccion nula
                        continue;
                    }
            //execute instructions
                    if(instructions instanceof transferBreak){
                        return null;
                    }
                    if(instructions instanceof transferContinue){
                        break;
                    }
                    if(instructions instanceof transferReturn){
                        return instructions;
                    }
                    
                    var value = instructions.interpretar(arbol, newTable);
                    if(value instanceof transferReturn){
                        return value;
                    }
                    if(value instanceof transferContinue){
                        break;
                    }
                    if(value instanceof transferBreak){
                        return null;
                    }
                    if(value instanceof Errores){
                        return value;
                    } 
                }
                valorExp = this.expression.interpretar(arbol, tabla); // interpreta la condicion
                if(valorExp instanceof Errores){        //si hay un error al evaluar la condicion
                    return valorExp;
                }
            } while (valorExp.toString().equals("true"));       //verfify valor de la condicion
//            la actualizacion es hecha por codigo del usuario
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
        
        String finWhile = "finWhile" + c.countCreateVar;
        c.countCreateVar++;
        
        String idIns = "insDo" + c.countCreateVar;
        c.countCreateVar++;
        
        
        //DO
        if(isDoWhile){
                                //instrucciones 
            armed+= idIns + ":{}\n";
            for (Instruction ins : instructionss) {
                if(ins==null){
                    continue;
                }
                armed+= ins.createC3D(arbol, anterior);
            }

            //condition
            if(this.expression instanceof OperateRelacionales){
              armed+= expression.createC3D(arbol, anterior);
              String op1 = c.varsParams.get(0); 
              c.varsParams.removeFirst();
              String op2 = c.varsParams.get(0);  
              c.varsParams.removeFirst();
                  armed+= c.cond_If(op1, op2, idIns, finWhile);

                                      //LOGICAL op
            }else if(this.expression instanceof LogicalOperations log){
                log.setIdIf(idIns);
                log.setIdSalida(finWhile);
                armed += log.createC3D(arbol, anterior);
            }
         //WHILE   
        }else{
             String  idWhile =  "while" + c.countCreateVar ; 
                    //label del while
             armed+= idWhile+ ":{}\n";
             c.countCreateVar++;
             
            //condicion
            if(this.expression instanceof OperateRelacionales){
              armed+= expression.createC3D(arbol, anterior);
              String op1 = c.varsParams.get(0); 
              c.varsParams.removeFirst();
              String op2 = c.varsParams.get(0);  
              c.varsParams.removeFirst();
                  armed+= c.cond_If(op1, op2, idIns, finWhile);

                                      //LOGICAL op
            }else if(this.expression instanceof LogicalOperations log){
                log.setIdIf(idIns);
                log.setIdSalida(finWhile);
                armed += log.createC3D(arbol, anterior);
            }
            
                                        //instrucciones
            armed+= idIns + ":{}\n";        //label ins
            for (Instruction ins : instructionss) {
                if(ins==null){
                    continue;
                }
                armed+= ins.createC3D(arbol, anterior);
            }
            armed += "goto " + idWhile + ";\n";

        }
        
        
//        label salida
        armed+= finWhile +":{}\n";
  
        
        return armed;
    }
    
    
    
}