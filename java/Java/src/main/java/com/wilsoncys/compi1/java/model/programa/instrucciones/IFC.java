/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.instrucciones;

import com.wilsoncys.compi1.java.model.asbtracto.CreadorC3d;
import com.wilsoncys.compi1.java.model.programa.instrucciones.*;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.LogicalOperations;
import com.wilsoncys.compi1.java.model.expresiones.OperateRelacionales;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.instrucciones.IF;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
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
public class IFC extends Instruction{
    private Instruction expression;
    private LinkedList<Instruction> instructionss;
    private LinkedList<Instruction> instructionsElse;

    private Instruction  elif;
    
    private String idIf = "";
    private String idSalida = "";
    private boolean isElif = false;
    
    
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
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        setPos(arbol);
        String armed = "";
        C3d_Java c= arbol.getJava();
 
        
        if(idIf.isEmpty()){
            idIf = "if" + c.contador;
            c.contador++;
        }
        
        if(idSalida.isEmpty()){
            idSalida= "salida" + c.contador;
            c.contador++;
        }
        String idElse= "else" + c.contador;
        c.contador++;
        String idElif= "elif" + c.contador;
        c.contador++;   
          
        
        //create a la condicion 
        if(this.expression instanceof OperateRelacionales){
            var res =expression.createC3D(arbol, anterior);
            if(res instanceof Errores){
                return  res;
            }else{
              armed+= res;
            }
          String op1 = c.varsParams.get(0); 
          c.varsParams.removeFirst();
          String op2 = c.varsParams.get(0);  
          c.varsParams.removeFirst();
          
          if(instructionsElse==null && elif==null){//simple if
              armed+= c.cond_If(op1, op2, idIf, idSalida);
          }else{
              if(elif!=null){           //elif
                  armed+= c.cond_If(op1, op2, idIf, "label" + idElif);
              }else{                //else
                  armed+= c.cond_If(op1, op2, idIf, idElse);
              }
          } 
          if(isElif){
//            armed+= "}\n";
            armed+= "\n";
          }
                                            //LOGICAL op
        }else if(this.expression instanceof LogicalOperations log){
            if(instructionsElse!=null){
                log.setElseIns(true);
            }
            if(elif!=null){
                log.setElifIns(true);
            }
            log.setIdIf(idIf);
            log.setIdSalida(idSalida);
            log.setIdElse(idElse);
            log.setIdElif(idElif);
            var res= log.createC3D(arbol, anterior);
            if(res instanceof Errores){
                return res;
            }else{
                armed += res;
            }
            //            armed+= "}\n";

        }
        
        
//        label if
        armed+= idIf +  ":\n";
        
 
        
                                          //INS del IF
 
        for (Instruction instructions : instructionss) {
            if(instructions ==null){
                continue;
            }
            var res =instructions.createC3D(arbol, anterior);
            if(res instanceof Errores){
                return res;
            }else{
                armed+= res; 
            }
//            arbol.getCurrentAmbit().set(1, ambitoAnt);
       
        }
        armed += "\n";
        armed+= "goto " + idSalida + ";\n";
//        arbol.setCurrentAmbit(ambitoAntList);
        
        
        
        
        
        if(instructionsElse!=null){         //INS del ELSE 
            //label else
            armed+= idElse +  ":\n";      
            for (Instruction instructions : instructionsElse) {
                if(instructions ==null){
                    continue;
                }
                var res = instructions.createC3D(arbol, anterior);
                if(res instanceof  Errores){
                    return res;
                }else{
                    armed+=res; 
                }
 
            }
            
            armed += "\n";

    //                      label salida
            armed+= idSalida +  ":\n";

        }else if(elif!=null){                        //INS del Elif
            armed+= "label"+idElif+":\n";
                    
            ((IFC)elif).setIsElif(true);
            ((IFC)elif).setIdIf(idElif);
            ((IFC)elif).setIdSalida(idSalida);
            var res =elif.createC3D(arbol, anterior);
            if(res instanceof Errores){
                return res;
            }else{
                armed += res; 
            }
            
        }else{
//                      label salida
            armed+= idSalida +  ":\n";
        }
        
        return armed;
    }

    public void setIdIf(String idIf) {
        this.idIf = idIf;
    }

    public void setIdSalida(String idSalida) {
        this.idSalida = idSalida;
    }

    public void setIsElif(boolean isElif) {
        this.isElif = isElif;
    }


    
    
    
    
    
    
    
}

