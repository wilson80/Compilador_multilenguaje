/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.expresiones;



import com.wilsoncys.compi1.javacraft.model.expresiones.Enums.Relational_LogicalOperations;
import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.tablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;
/**
 *
 * @author Jonwil
 */
public class LogicalOperations extends Instruction{
    private Instruction operand1;
    private Instruction operand2;
    private Relational_LogicalOperations operator;
    private Object operL = null;
    private Object operR = null;


    //cualquier operacion menos negacion
    public LogicalOperations(Instruction operando1, Instruction operando2, Relational_LogicalOperations operator, int line, int col) {
        super(new Tipo(tipoDato.BOOLEANO), line, col);
        this.operand1 = operando1;
        this.operand2 = operando2;
        this.operator = operator;
    }
    
    public LogicalOperations(Instruction operando1, Relational_LogicalOperations operator, int line, int col) {
        super(new Tipo(tipoDato.BOOLEANO), line, col);
        this.operand1 = operando1;
        this.operator = operator;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        
        operL = this.operand1.interpretar(arbol, tabla);
        if (operL instanceof Errores) {
            return operL;
        }
        if(operand2!=null){
            operR = this.operand2.interpretar(arbol, tabla);
            if (operR instanceof Errores) {
                return operR;
            }
        }else{
            return negarExpression(operL);
        }
        return  operarLogicos(operL, operR);
    }

    private Object operarLogicos(Object oper1, Object oper2) {
        //            (1 == 2) || (10 < 5) || (!false);
        boolean op1;
        boolean op2;
        if(oper1.toString().equals("true")){
            op1 = true;
        }else{
            op1 = false;
        }
        if(oper2.toString().equals("true")){
            op2 = true;
        }else{
            op2 = false;
        }
        switch (operator) {
            case AND->{
                return op1&& op2;
            }
            case OR->{
                return op1 || op2;
            }
            case XOR->{
                return op1 ^ op2;
            }
            default->{
                return new Errores("SEMANTIC","al operar logicos", line , col);
            }
                    
        }
    }
    
    private Object negarExpression(Object op1) {
        if((op1.toString().equals("true"))){
            return !true;
        }else{
            return !false;
        }
    }


    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
}



