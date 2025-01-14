/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.expresiones;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
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
public class Access extends Instruction{
    public String id; 
    private String idFiel = null; 
    private String elseFiel = null; 
    private boolean isThis = false;
    
    public Access(String id, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
    }
                                                                //acces con this
    public Access(String id, boolean isThis, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.isThis = isThis;
    }
    
    public Access(String id, String idFiel, String elseField, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.idFiel = idFiel;
        this.elseFiel = elseField;
    }
    
    
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
         
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
 
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
    
        
             @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        
        String armed = "";
        C3d_Java c =  arbol.getJava();
        Simbolo sym = null;
        if(this.isThis){
            String armedId = arbol.getCurrentAmbit().get(0);
            armedId += arbol.getCurrentAmbit().get(1) + id;
            sym = arbol.getSym(armedId);
//            this.tipo = sym.getTipo();


        }else{      // si no se usa this.

            String armedId = "";
            armedId= arbol.getAmbito_asID() + id;
//            if(this.id.equals("nuevoNodo")){
//                JOptionPane.showMessageDialog(null, "ambit asID: " + arbol.getAmbito_asID()
//                    +"  \nID: "+this.id);
//            }
      
            sym = arbol.getSym(armedId);    
//            this.tipo = sym.getTipo();
            
            if(sym==null){      //si no se encuentra en el ambito local buscar en el ambito global
                armedId = arbol.getCurrentAmbit().get(0);
                armedId += arbol.getCurrentAmbit().get(1) + id;
                sym = arbol.getSym(armedId);
                       
                if(sym == null){        //revisar esto
//                    JOptionPane.showMessageDialog(null, "acces no sym: " +armedId);
                    arbol.addError(new Errores(id, "no se ha encontrado la variable con id: " + this.id, line, col));
                }else{
                    this.tipo = sym.getTipo();
                }
            }

        }
 

        
        int dir = sym.getDir();
        
        if(sym.getCat()==categoria.PARAM){  
            armed+= c.c3d_accesParam(id, dir);
        }else if(sym.getCat()==categoria.ATRIBUTO){ 
                armed+= c.c3d_accesRef("", 0);
                armed+= c.c3d_accesAttVarl("", dir);

        }else if(sym.getCat()==categoria.VARL){
            armed+= c.c3d_acces("", sym.getDir());
            
        }

        
        if(sym!=null){
            this.tipo = sym.getTipo();
        } 
                 
        return armed;
    }
}
