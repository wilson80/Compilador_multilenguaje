/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.expresiones;



import com.wilsoncys.compi1.java.model.asbtracto.CreadorC3d;
import com.wilsoncys.compi1.java.model.expresiones.Enums.Relational_LogicalOperations;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import static com.wilsoncys.compi1.java.model.expresiones.Enums.Relational_LogicalOperations.DIFERENTEQUE;
import static com.wilsoncys.compi1.java.model.expresiones.Enums.Relational_LogicalOperations.IGUALA;
import static com.wilsoncys.compi1.java.model.expresiones.Enums.Relational_LogicalOperations.MAYOR;
import static com.wilsoncys.compi1.java.model.expresiones.Enums.Relational_LogicalOperations.MAYOR_IGUAL;
import static com.wilsoncys.compi1.java.model.expresiones.Enums.Relational_LogicalOperations.MENOR;
import static com.wilsoncys.compi1.java.model.expresiones.Enums.Relational_LogicalOperations.MENOR_IGUAL;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
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
public class LogicalOperations extends Instruction{
    private Instruction operando1;
    private Instruction operando2;
    private Relational_LogicalOperations operator;
    private Object operL = null;
    private Object operR = null;
    private boolean elseIns = false;
    private boolean elifIns = false;

    
    private String idIf = ""; 
    private String idSalida= ""; 
    private String idElse= "";
    private String idElif= "";
    
    
    
    //cualquier operacion menos negacion
    public LogicalOperations(Instruction operando1, Instruction operando2, Relational_LogicalOperations operator, int line, int col) {
        super(new Tipo(tipoDato.BOOLEANO), line, col);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operator = operator;
    }
    
    public LogicalOperations(Instruction operando1, Relational_LogicalOperations operator, int line, int col) {
        super(new Tipo(tipoDato.BOOLEANO), line, col);
        this.operando1 = operando1;
        this.operator = operator;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        
        operL = this.operando1.interpretar(arbol, tabla);
        if (operL instanceof Errores) {
            return operL;
        }
        if(operando2!=null){
            operR = this.operando2.interpretar(arbol, tabla);
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
//            case XOR->{
//                return op1 ^ op2;
//            }
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
    
    
        public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
    
        
            @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        String armed = "";
        String op1 = "";
        String op2 = "";
        String ope1 = "";
        String ope2 = "";
        CreadorC3d c;
        
        if( anterior.getLenguaje().equals("java") ){
             c = arbol.getJava();
        }else{
             c =  arbol.getC3d();
        } 
        
//        C3d_Java c=  arbol.getJava();
//        c.varsParams = new LinkedList<>();
        
        //op1
        armed+=operando1.createC3D(arbol, anterior);
        op1 = c.varsParams.get(0);
        c.varsParams.removeFirst();
        op2 = c.varsParams.get(0);
        c.varsParams.removeFirst();


        
        
        String cmpOp2 = "cmpOp2" + c.contador;
        c.contador++;
        if(operator == Relational_LogicalOperations.AND){
            if(!elseIns  && !elifIns){
                armed+= c.cond_If(op1, op2,cmpOp2, idSalida); 
            }
            if(elseIns){
                armed+= c.cond_If(op1, op2,cmpOp2, idElse); 
            } 
            if(elifIns){
                armed+= c.cond_If(op1, op2,cmpOp2, "label" + idElif); 
            }
            
        }else if(operator == Relational_LogicalOperations.OR){
            armed+= c.cond_If(op1, op2, idIf, cmpOp2);       
        }
       
 

        //op2
                armed+=operando2.createC3D(arbol, anterior);
        ope1 = c.varsParams.get(0);
        c.varsParams.removeFirst();
        ope2 = c.varsParams.get(0);
        c.varsParams.removeFirst();
        
        
        armed += cmpOp2 + ":\n";
        
        if(!elifIns && !elseIns){
            armed += c.cond_If(ope1, ope2, idIf, idSalida);
        }
        
        if(elseIns){
            armed += c.cond_If(ope1, ope2, idIf, idElse);
        }
        
        if(elifIns){
            armed+= c.cond_If(ope1, ope2, idIf, "label" + idElif);       
        }
        
        
        return armed;
    }
    
    
    
    
    

    public void setElseIns(boolean elseIns) {
        this.elseIns = elseIns;
    }

    public void setElifIns(boolean elifIns) {
        this.elifIns = elifIns;
    }

    public void setIdIf(String idIf) {
        this.idIf = idIf;
    }

    public void setIdElse(String idElse) {
        this.idElse = idElse;
    }

    public void setIdSalida(String idSalida) {
        this.idSalida = idSalida;
    }

    public void setIdElif(String idElif) {
        this.idElif = idElif;
    }
    
    
    

    
    
    
     
    
}



