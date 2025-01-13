/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.instrucciones;

import com.wilsoncys.compi1.java.model.instrucciones.*;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.Access;
import com.wilsoncys.compi1.java.model.expresiones.Aritmeticas.Resta;
import com.wilsoncys.compi1.java.model.expresiones.Aritmeticas.Suma;
import com.wilsoncys.compi1.java.model.expresiones.Enums.OperadoresAritmeticos;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.programa.expresiones.AccessC;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;

/**
 *
 * @author Jonwil
 */
public class IncreaseDecreaseC extends Instruction{
    
    private String id;
    private Instruction expression;
    private boolean increase;

    public IncreaseDecreaseC(String id, boolean increase, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.increase = increase;
    }

//    num1 = 5;
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
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
    
        public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
        
            @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        String armed = "";
        C3d_Java c = arbol.getJava();
        
        
        //creando una asignacion
               //creando el nativo a sumar
               Nativo nat = new Nativo(1, new Tipo(tipoDato.ENTERO), line, col);
               
               //creando el acceso
                AccessC acc = new AccessC(id, line, col);
               
               Instruction suma_resta;
               //creando la operacion
               if(increase){
                   suma_resta = new Suma(acc, nat, OperadoresAritmeticos.SUMA, line, col);
               }else{
                   suma_resta = new Resta(acc, nat, OperadoresAritmeticos.RESTA, line, col);
               }
        AssignmenttC assig = new AssignmenttC(id, suma_resta, line, col);
        //crear la asignacion
        armed += assig.createC3D(arbol, anterior);
        
        return armed;
    }
    
}
