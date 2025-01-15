/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.instrucciones;

import com.wilsoncys.compi1.java.model.asbtracto.CreadorC3d;
import com.wilsoncys.compi1.java.model.instrucciones.*;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
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
public class CaseMatchC extends Instruction{
    private Instruction expression;
    private LinkedList<Instruction> instructionss;
    private boolean isDefault;
    private Object valorMatch;
    private tipoDato tipoValorMatch;
    
    
    private String valStringMatch = "";
     
    private String idSalida = "";
    private String idNextCase = "";
    private String idLabel = "";
    private boolean lastCase = false;
    
    
    
    public CaseMatchC(Instruction expression, LinkedList<Instruction> instructionss, boolean isDefault,  int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expression = expression;
        this.instructionss = instructionss;
        this.isDefault = isDefault;
    }

    @Override                               
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        
        //interpret valor de la expresion del caso
        var valorCase = this.expression.interpretar(arbol, tabla);
        if(valorCase instanceof Errores){
            return valorCase;
        }
        
        
        //verify type expresion del match con el expresion del caso
        if(tipoValorMatch!=this.expression.tipo.getTipo()){
            String mensajeError = "Tipos erroneos del caso con expresion: " + valorMatch.toString() + "En instruccion Match";
            return new Errores("SEMANTIC", mensajeError, line, col);
        }
        
//        verify match
        if(valorMatch.equals(valorCase)){
//            ejecutarInstrucciones
            for (Instruction ins : instructionss) {
                var instruccionDelCaso = ins.interpretar(arbol, tabla);
                if(instruccionDelCaso instanceof Errores){
                    return instruccionDelCaso;
                }
                
            }
            return true;
        }else{
            return false;
        }
    }
    
    public void setExpressionMatch(Object expressionMatch) {
        this.valorMatch = expressionMatch;
    }

    public void setTipoValorMatch(tipoDato tipoValorMatch) {
        this.tipoValorMatch = tipoValorMatch;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public LinkedList<Instruction> getInstructionss() {
        return instructionss;
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
        C3d_Java c = arbol.getJava();   
 
        String idCase = "caseIns" + c.contador;
        c.contador++;
            
        
        armed += idLabel + ":\n";
        
        if(this.expression != null){
                //exp del switch
            String op1 = valStringMatch;
                //exp del case
            if(this.expression instanceof Nativo) {
                expression.createC3D(arbol, anterior) ;  
            }else{
                armed += expression.createC3D(arbol, anterior) ;  
            } 
            String op2 = c.varsParams.get(0);
            c.varsParams.clear();

                        //comparacion y saltos
            c.setOPRT("==");

            armed += c.cond_If(op1, op2, idCase, idNextCase);
//                                                    operador de comparacion
        } 
        
        
                                //INSTRUCCIONES DEL case
        if(this.expression != null){
            armed +=  idCase+ ":\n" ;
        }            
        for (Instruction ins : instructionss) {
            if(ins ==null){
                continue;
            }
            
            armed += ins.createC3D(arbol, anterior);
        }
        
                    //goto a la salida 
        if(this.expression !=null){
            armed +=  "goto " + idSalida + ";\n";
        }
        
        
        return armed;
    }

    public void setIdSalida(String idSalida) {
        this.idSalida = idSalida;
    }

    public void setIdNextCase(String idNextCase) {
        this.idNextCase = idNextCase;
    }

    public void setValStringMatch(String valStringMatch) {
        this.valStringMatch = valStringMatch;
    }

    public void setLastCase(boolean lastCase) {
        this.lastCase = lastCase;
    }

    public void setIdLabel(String idLabel) {
        this.idLabel = idLabel;
    }

    public String getIdLabel() {
        return idLabel;
    }

    public String getIdNextCase() {
        return idNextCase;
    }

 
    
    
    
    
    
    
}
