/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.expresionesPas;


import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.HashMap;
import javax.swing.JOptionPane;

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
 
        
        var simbolo = tabla.getSsymbol(id);
        if(simbolo!=null){
            this.tipo.setTipo(simbolo.getTipo().getTipo());
            return simbolo.getValor();
        }else{
            String mensajeError = "No se encontro la variable, ID: " + id+ " ";
            return new Errores("SEMANTIC",mensajeError, line, col);
        }
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
        setPos(arbol);
        String armed = "";
        C3d c =  arbol.getC3d();
         
//                    JOptionPane.showMessageDialog(null, "aquiiiiAcces: " + id);

        
        Simbolo sym = null;

        String armedId = arbol.getAmbito_asID()+ id;
        sym = arbol.getSymPas(armedId);
       
        if(sym==null){       
            return (new Errores("semantic", "la variable con id: "
                    + id + " no existe", line, col));
        }
        int dir = sym.getDir();
 
        armed+= c.c3d_acces("", sym.getDir());
   

        if(sym!=null){
            this.tipo = sym.getTipo();
        } 
                 
        
        return armed;
    }
        
         
    
}
