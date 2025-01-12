/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.expresionesPas;


import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.HashMap;

/**
 *
 * @author Jonwil
 */
public class AccessPas extends Instruction{
    public String id; 
    private String idFiel = null; 
    private String elseFiel = null; 

    public AccessPas(String id, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
    }

    public AccessPas(String id, String idFiel, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.idFiel = idFiel;
    }
    public AccessPas(String id, String idFiel, String elseField, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.idFiel = idFiel;
        this.elseFiel = elseField;
    }
    
    
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
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
    
    
    
    public Object accesStruct(Arbol arbol, TablaSimbolos tabla) {
        
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

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
