/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.instrucciones;

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
public class IncreaseDecrease extends Instruction{
    
    private String id;
    private Instruction expression;
    private boolean increase;

    public IncreaseDecrease(String id, boolean increase, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.increase = increase;
    }

//    num1 = 5;
    
    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        //verificar existencia de la variable 
        var simboloExistente = tabla.getSsymbol(id);
        if (simboloExistente == null) {
            String mensajeError = "La Variable: " + id + " no existe";
            return new Errores("SEMANTICO", mensajeError,
                    this.line, this.col);
        }
        

        //this.tipo.setTipo(variable.getTipo().getTipo());
        if(simboloExistente.isConst()){ // es un error si es constante ya no se le puede asignar un nuevo valor
            return  new Errores("SEMANTIC", "No puede cambiarle el valor a una variable constante", line, col);
        }else{
            int increaseDecrease = 0;
            if(increase){
                increaseDecrease = 1;
            }else{
                increaseDecrease = -1;
            }
            
            switch (simboloExistente.getTipo().getTipo()) {
                case DECIMAL->{
                    simboloExistente.setValor(((Double)(simboloExistente.getValor()) + increaseDecrease));
                    return null;
                }
                case ENTERO->{
                    simboloExistente.setValor(((Integer)(simboloExistente.getValor()) + increaseDecrease));
                    return null;
                    
                }
                default->{
                    String mensajeError = "(tipo no admitido) No puede incrementarle el valor a la variable : " + id;
                    return new Errores("SEMANTICO",mensajeError,
                            this.line, this.col);
                }
            }
                
        }
        
        
    }
    
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
}
