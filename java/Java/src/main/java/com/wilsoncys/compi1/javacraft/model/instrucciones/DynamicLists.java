/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.instrucciones;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Simbolo;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.tablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jonwil
 */
public class DynamicLists extends Instruction{
    private String id;
    private List<Object> listNativos;
    private Instruction expression = null;
    private boolean isAdd_remove;
    
    //Statement
    public DynamicLists(String id, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.id = id;
    }
//remove and append
    public DynamicLists(String id, Instruction expresion, boolean isAdd_remove, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expression = expresion;
        this.isAdd_remove = isAdd_remove;
    }
    

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        if(isAdd_remove && expression !=null){
            return this.append(arbol, tabla);
        }
        if(expression !=null){
            return remove(arbol, tabla);
        }
        
        //crear el nuevo simbolo e insertar en la tabla
        listNativos = new ArrayList<>();
        Simbolo newSimboll = new Simbolo(tipo, id, this.listNativos, false);
        newSimboll.setLinea(line);
        newSimboll.setLinea(col);
        if(!tabla.addSsymbol(newSimboll)){
            return new Errores("SEMANTIC", "La variable: " + id+ "Ya existe", line, col);
        }
        
        
        
        
        return null;
    }
    
    
    public Object append(Arbol arbol, tablaSimbolos tabla) {        //es una instruccion
        //buscar el simbolo
        var simbolSearch = tabla.getSsymbol(id);
        if(simbolSearch==null){
            return new Errores("SEMANTIC", "Variable: " + id+" Inexistente", line, col);
        }
        //interpretar la expresion del nuevo valor
        var newValue = expression.interpretar(arbol, tabla);
        if(newValue instanceof Errores){
            return newValue;
        }
        //validar tipos
        if(expression.tipo.getTipo()!= simbolSearch.getTipo().getTipo()){
            mensErr = "Tipo del valor: " + newValue.toString() + "Erroneo";
            return new Errores("SEMANTIC", mensErr, line, col);
        }
        //agregar el valor a la lista
        List<Object> listSearched = (List<Object>)simbolSearch.getValor();
        listSearched.add(newValue);
        return null;
    }
    
    
    public Object remove(Arbol arbol, tablaSimbolos tabla) {            //es una expresion
        //buscar el simbolo
        var simbolSearch = tabla.getSsymbol(id);
        if(simbolSearch==null){
            return new Errores("SEMANTIC", "Variable: " + id+" Inexistente", line, col);
        }
        //interpretar la expresion del nuevo valor
        var valueIndex = expression.interpretar(arbol, tabla);
        if(valueIndex instanceof Errores){
            return valueIndex;
        }
        //validar que el indice sea de un  tipo entero
        if(expression.tipo.getTipo()!= tipoDato.ENTERO){
            mensErr = "El indice no es un entero al acceder a la Lista con id: " + id;
            return new Errores("SEMANTIC", mensErr, expression.line, expression.col);
        }
        
        //validar la longitud de la lista
        List<Object> listSearched = (List<Object>)simbolSearch.getValor();
        int  size = listSearched.size();
        if((int)valueIndex>=size || size<0){
            return new Errores("SEMANTIC", "Indice: "+ (int)valueIndex+" fuera de rango al acceder a la Lista con id:  " + id, 
                    expression.line, expression.col);
        }
        
        //set al nuevo tipo
        this.tipo.setTipo(simbolSearch.getTipo().getTipo());
//        retornar el valor y quitarlo de la lista
        Object valueRemoved = listSearched.get((int)valueIndex);
        listSearched.remove((int)valueIndex);
        return valueRemoved;
//        return null;
    }

    
    
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
    
}
