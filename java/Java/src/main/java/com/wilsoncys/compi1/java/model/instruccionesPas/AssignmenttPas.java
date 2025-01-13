/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instruccionesPas;


import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.Input;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
  public class AssignmenttPas extends Instruction{
    private String id;
    private String idField = null;
    private String elseField = null;
    private Instruction expression;

    public AssignmenttPas(String id, Instruction exp, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expression = exp;
    }

    public AssignmenttPas(String id,  String idField, Instruction expression, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expression = expression;
        this.idField = idField;
    }
    
    public AssignmenttPas(String id,  String idField, String elseField, Instruction expression, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expression = expression;
        this.idField = idField;
        this.elseField = elseField;
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
        
        // interpretar el nuevo valor a asignar
        var newValor = this.expression.interpretar(arbol, tabla);
        if (newValor instanceof Errores) {
            return newValor;
        }


        //this.tipo.setTipo(variable.getTipo().getTipo());
        if(simboloExistente.isConst()){ // es un error si es constante ya no se le puede asignar un nuevo valor
            return  new Errores("SEMANTIC", "No puede cambiarle el valor a una variable constante", line, col);
        }else{
            //validar tipos del valor a asignar y de la variable existente
//            var tipo1

            if (simboloExistente.getTipo().getTipo() != this.expression.tipo.getTipo()) {
                String mensajeError = "Tipos erroneos al asignar a la variable: " + id;
//                if(simboloExistente.getTipo().getTipo() == tipoDato.NEWTYPE){
//                    if(this.expression.tipo.getTipo() != simboloExistente.getTipo().getCurrentType()){
//                        return new Errores("SEMANTICO",mensajeError,
//                                this.expression.line, this.expression.col);
//                    }
//                }else{
//                    return new Errores("SEMANTICO",mensajeError,
//                            this.expression.line, this.expression.col);
//                }
            }
            simboloExistente.setValor(newValor);
            return null;
        }
        
        
    }
    
//    public boolean verifyMuta(Simbolo simbolo){
//        if(simbolo.isMutable()){
//            return true;
//        }else{
//            return false;
//        }
//    }

 
        
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
        C3d c =  arbol.getC3d();
        setPos(arbol);
        String varr = "";
        String armed = "";
        int dir  = 0;
        
        String armedID = "";
        
        Simbolo sym = arbol.getSymPas(arbol.getAmbito_asID() +id);            //pdt
        if(sym == null){
            //verificar si es asignacion en la misma funcion
            sym = arbol.getSymPas( arbol.getAmbito_asID());            //pdt
            if(sym != null){
               dir = 1;
            }else{
                arbol.addError(new Errores("semantic", "no existe la variable: " + this.id, line, col));
            }
        }else{
           dir = sym.getDir();
        }
        
        
        
         if(this.expression instanceof Input inp){
                inp.createC3D(arbol, anterior);
                armed+= c.c3d_Input();          //new var  
                armed+=c.c3d_asignVal("", dir);     //Entrada cin
                c.varsParams = new LinkedList<>();  //limpiar despues de agregar
             
         }else if(this.expression instanceof Nativo){    //declaracion con valor nativo

              this.expression.createC3D(arbol, anterior);
              armed += c.c3d_asignVal("", dir);
              
        }else{   //peude ser un acceso
                armed += expression.createC3D(arbol, anterior);
                                                //realizar la asignacion
                armed +=c.c3d_asignVal("", dir);
            
        }
         
         
            armed +="\n";
        return armed;
         
        
    }
    
    
}


