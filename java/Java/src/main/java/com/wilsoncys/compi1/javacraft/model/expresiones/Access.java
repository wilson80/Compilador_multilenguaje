/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.expresiones;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Simbolo;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.tablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;
import java.util.HashMap;

/**
 *
 * @author Jonwil
 */
public class Access extends Instruction{
    public String id; 
    private String idFiel = null; 
    private String elseFiel = null; 

    public Access(String id, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
    }

    public Access(String id, String idFiel, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.idFiel = idFiel;
    }
    public Access(String id, String idFiel, String elseField, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.idFiel = idFiel;
        this.elseFiel = elseField;
    }
    
    
    
    
    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        //verificar si es un struct
        if(idFiel!= null){
            return accesStruct(arbol, tabla);
        }

        
        var simbolo = tabla.getSsymbol(id);
        if(simbolo!=null){
            this.tipo.setTipo(simbolo.getTipo().getTipo());
            return simbolo.getValor();
        }else{
            String mensajeError = "No se encontro la variable, ID: " + id+ " ";
            return new Errores("SEMANTIC",mensajeError, line, col);
        }
    }
    
    
    
    public Object accesStruct(Arbol arbol, tablaSimbolos tabla) {
        
        Simbolo symStruc = tabla.getSsymbol(id);        //buscar el simbolo
        if(symStruc ==  null){
            mensErr = "No se encontro la variable con ID: " + id+ " ";
            return new Errores("SEMANTIC",mensErr, line, col);
        }
        if(symStruc.getTipoStruct().isEmpty()){         //verificar si es un struct 
            mensErr = "El struct: " + id+ " No existe ";
            return new Errores("SEMANTIC",mensErr, line, col);
        }
        
        Object valor;
        if(elseFiel!=null){
            HashMap hassym = (HashMap)symStruc.getValor();
            HashMap otroHash = (HashMap)hassym.get(idFiel);
            
            if(otroHash ==null){
                mensErr = "Campo del struct incorrecto: " + idFiel+ " ";
                return new Errores("SEMANTIC",mensErr, line, col);
            }
            Simbolo valorAnid =(Simbolo) otroHash.get(elseFiel);
            this.tipo = valorAnid.getTipo();
            System.out.println("_____________________");
            System.out.println("tipo Acces: "+ this.tipo.getTipo().toString());
            System.out.println("tipo simbolo: "+ valorAnid.getTipo().getTipo().toString());
            System.out.println("_____________________");

            valor = valorAnid.getValor();
            
            
        }else{
            HashMap hassym = (HashMap)symStruc.getValor();
            Simbolo fieldSymbol = (Simbolo)hassym.get(idFiel);
            if(fieldSymbol ==null){
                mensErr = "Campo del struct incorrecto: " + idFiel+ " ";
                return new Errores("SEMANTIC",mensErr, line, col);
            }

            this.tipo = fieldSymbol.getTipo();
            valor = fieldSymbol.getValor();
            
        }
        
        
        return valor;
        
//        this.tipo.setTipo(simbolo.getTipo().getTipo());
//        return simbolo.getValor();
        
        
//        return null;
    }

    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
}
