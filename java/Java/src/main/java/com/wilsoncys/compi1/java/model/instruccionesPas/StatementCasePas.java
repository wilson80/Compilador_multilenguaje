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
public class StatementCasePas extends Instruction {
    private Instruction expression;
    private LinkedList<OneCasePas> cazzos;
    private LinkedList<Instruction> insElse;

//    private CaseMatch defaultCase;
    
    public StatementCasePas(Instruction expression, LinkedList<OneCasePas> cazzos, LinkedList<Instruction>  instruccionesElse,int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expression = expression;
        this.cazzos = cazzos;
        this.insElse = instruccionesElse;
    }

    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
//        interpret valor de la expresion del sttcase
        var valorMatch = this.expression.interpretar(arbol, tabla);
        if(valorMatch instanceof Errores){
            return valorMatch;
        }
        
        //nuevo entorno
//        var newTable = new tablaSimbolos(tabla);
        
        //validar el valor de la expresion del match

        
        //al hacerle interpretar  a la lista de casos se le va pasando el valor de la exp del match y se va comparando
        boolean match = false;
        for (OneCasePas cazzo : cazzos) {
                cazzo.setExpressionMatch(valorMatch);
                cazzo.setTipoValorMatch(this.expression.tipo.getTipo()  );
                //si al interpretar el caso y retorna true Cortar el ciclo
                var resultadoDelCaso = cazzo.interpretar(arbol, tabla);      //execute instructions
                if(resultadoDelCaso instanceof Errores){
                    return resultadoDelCaso;
                }
                if(resultadoDelCaso.equals(true)){
                    match = true;
                }
        }
        
        if(!match){                           //execute instructions del default
            if(insElse==null){
                return null;
            }else{
                    for (Instruction insDef : insElse) {
                        var resultIns = insDef.interpretar(arbol, tabla);
                        if(resultIns instanceof Errores){
                            return resultIns;
                        }
                    }
            }
        }  
            return null;
        
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
