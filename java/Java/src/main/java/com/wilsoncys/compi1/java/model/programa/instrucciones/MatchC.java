/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.instrucciones;

import com.wilsoncys.compi1.java.model.instrucciones.*;
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
public class MatchC extends Instruction{
    private Instruction expression;
    private LinkedList<CaseMatchC> cazzos;
    private LinkedList<Instruction> insOfDefault;

//    private CaseMatch defaultCase;
    
    public MatchC(Instruction expression, LinkedList<CaseMatchC> cazzos, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expression = expression;
        this.cazzos = cazzos;
    }

    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        setDefault(); //identificar el caso default en la lista de cazzos 
        
        
//        interpret valor de la expresion
        var valorMatch = this.expression.interpretar(arbol, tabla);
        if(valorMatch instanceof Errores){
            return valorMatch;
        }
        
        //nuevo entorno
        var newTable = new TablaSimbolos(tabla);
        
        //validar el valor de la expresion del match

        
        //al hacerle interpretar  a la lista de casos se le va pasando el valor de la exp del match y se va comparando
        boolean noMatch = false;
        for (CaseMatchC cazzo : cazzos) {
            if(!cazzo.isDefault()){
                cazzo.setExpressionMatch(valorMatch);
                cazzo.setTipoValorMatch(this.expression.tipo.getTipo()  );
                //si al interpretar el caso y retorna true Cortar el ciclo
                var resultadoDelCaso = cazzo.interpretar(arbol, newTable);      //execute instructions
                if(resultadoDelCaso instanceof Errores){
                    return resultadoDelCaso;
                }
                if(resultadoDelCaso.equals(true)){
                    noMatch = true;
                    System.out.println("EJECUTANDO UN CASO DENTRO DEL MATCH");
                    return null;
                }
            }    
        }
        if(!noMatch){                           //execute instructions del default
            if(insOfDefault!=null){     //validacion si no hay default
                for (Instruction insDef : insOfDefault) {
                    var resultIns = insDef.interpretar(arbol, newTable);
                    if(resultIns instanceof Errores){
                        return resultIns;
                    }
                }
            }
        }
        
        
//        match "wi" {
//            "algo"     => { println("algoooo.");}
//            "nada"   => { println("nadaaaaa");}
//              _=>{ println("ningunaaaa");}
//        }
        
        return null;
    }

    public void setDefault() {
        for (CaseMatchC cazzo : this.cazzos) {
            if(cazzo.isDefault()){
                this.insOfDefault = cazzo.getInstructionss();
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
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        return anterior;
    }
}
