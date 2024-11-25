/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instrucciones;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.Access;
import com.wilsoncys.compi1.java.model.expresiones.Input;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.poo.Call;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.lang.annotation.Native;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class Assignmentt extends Instruction{
    private String id;
    private String idField = null;
    private String elseField = null;
    private Instruction expr;
    private int whatConstruct = 0;
    private boolean isThis = false;

    public Assignmentt(String id, Instruction exp, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expr = exp;
        this.whatConstruct = 0;
    }
//isthis
    public Assignmentt(boolean isThis, String id, Instruction expression, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expr = expression;
        this.whatConstruct = 1;
        this.isThis = isThis;
    }
    
    public Assignmentt(String id,  String idField, String elseField, Instruction expression, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expr = expression;
        this.idField = idField;
        this.elseField = elseField;
        this.whatConstruct = 2;
    }


    
    

//    num1 = 5;
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        if(idField!=null){
            return structAssignment(arbol, tabla);
        }
        
        //verificar existencia de la variable 
        var simboloExistente = tabla.getSsymbol(id);
        if (simboloExistente == null) {
            String mensajeError = "La Variable: " + id + " no existe";
            return new Errores("SEMANTICO", mensajeError,
                    this.line, this.col);
        }
        
        // interpretar el nuevo valor a asignar
        var newValor = this.expr.interpretar(arbol, tabla);
        if (newValor instanceof Errores) {
            return newValor;
        }


        //this.tipo.setTipo(variable.getTipo().getTipo());
        if(simboloExistente.isConst()){ // es un error si es constante ya no se le puede asignar un nuevo valor
            return  new Errores("SEMANTIC", "No puede cambiarle el valor a una variable constante", line, col);
        }else{
            //validar tipos del valor a asignar y de la variable existente
//            var tipo1
            if (simboloExistente.getTipo().getTipo() != this.expr.tipo.getTipo()) {
                String mensajeError = "Tipos erroneos al asignar a la variable: " + id;
                return new Errores("SEMANTICO",mensajeError,
                        this.expr.line, this.expr.col);
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

        public Object structAssignment(Arbol arbol, TablaSimbolos tabla) {
            Simbolo symStruc = tabla.getSsymbol(id);        //buscar el simbolo
            if(symStruc ==  null){
                mensErr = "No se encontro la variable con ID: " + id+ " ";
                return new Errores("SEMANTIC",mensErr, line, col);
            }
            if(symStruc.getTipoStruct().isEmpty()){         //verificar si es un struct 
                mensErr = "El struct: " + id+ " No existe ";
                return new Errores("SEMANTIC",mensErr, line, col);
            }
            
            
            HashMap hassym =(HashMap)symStruc.getValor();
            if(elseField!=null){ //id.id.id     id1(identifi).p(persona).nombre
                HashMap elseMap = (HashMap)hassym.get(idField);
                Simbolo sym3 = (Simbolo)elseMap.get(elseField);
                //interpretar la exp
                    var valueExp = this.expr.interpretar(arbol, tabla);
                    if(valueExp instanceof  Errores){
                        return valueExp;
                    }
                    //validar los tipos
                    if(symStruc.isConst()){ // es un error si es constante ya no se le puede asignar un nuevo valor
                        return  new Errores("SEMANTIC", "Struct instanciado como const (Al asignar)", line, col);
                    }else{
                        //validar tipos 
                        if (sym3.getTipo().getTipo() != this.expr.tipo.getTipo()) {
                            mensErr = "Tipos erroneos al asignar a un campo de Struct " + id + " ";
                            return new Errores("SEMANTICO",mensErr,
                                    this.expr.line, this.expr.col);
                        }
                        sym3.setValor(valueExp);
                        return null;
                    }
                    
                    
            }else{               // id.id           p.nombre
                Simbolo fieldSymbol = (Simbolo)hassym.get(idField);
                if(fieldSymbol ==null){
                        mensErr = "Campo del struct incorrecto: " + idField+ " ";
                        return new Errores("SEMANTIC",mensErr, line, col);
                    }

                    //interpretar la exp
                    var valueExp = this.expr.interpretar(arbol, tabla);
                    if(valueExp instanceof  Errores){
                        return valueExp;
                    }

                    //validar los tipos
                    if(symStruc.isConst()){ // es un error si es constante ya no se le puede asignar un nuevo valor
                        return  new Errores("SEMANTIC", "Struct instanciado como const (Al asignar)", line, col);
                    }else{
                        //validar tipos 
                        if (fieldSymbol.getTipo().getTipo() != this.expr.tipo.getTipo()) {
                            mensErr = "Tipos erroneos al asignar a un campo de Struct " + id + " ";
                            return new Errores("SEMANTICO",mensErr,
                                    this.expr.line, this.expr.col);
                        }
                        fieldSymbol.setValor(valueExp);
                        return null;
                    }
                    
            }
            

        }

        
        @Override
    public String generarast(Arbol arbol, String anterior) {
        String algo = anterior;
        algo = expr.generarast(arbol, anterior);
        
        
        return algo;
    }
    
        public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
    
        
        
        
        
        
        
        
        
        
            @Override
    public Object createC3D(Arbol arbol, String anterior) {
        String armed = "";
        C3d_Java c =  arbol.getJava();
        int dir = 0;
        String varr = "";
        
        if(isThis){
            String armedId = arbol.getCurrentAmbit().get(0);
             armedId += arbol.getCurrentAmbit().get(1)+id;
                dir = arbol.getSym(armedId).getDir();            
            
//            buscar el sym solo en el ambito global


        }else{
            Simbolo encontrado = null;
            String armedId = arbol.getAmbito_asID() + id;
            encontrado = arbol.getSym(armedId);
//            buscar el sym en abmos ambitos
               if(encontrado == null){
                   
               }else{
               
               }

        }
        
         if(expr instanceof Input inp){
                inp.createC3D(arbol, anterior);
                armed+= c.c3d_Input();          //new var  
                armed+=c.c3d_asignVal("", dir);     //Entrada cin
                c.varsParams = new LinkedList<>();  //limpiar despues de agregar
             
         }else{
            if(this.expr instanceof Nativo){    //declaracion con valor vativo

              this.expr.createC3D(arbol, anterior);
              armed = c.c3d_asignVal("", dir);
              
            }else if(this.expr instanceof Call call){                          //declaracion y asignacion
                    //pndte
                                                    //create a la llamada
                armed+= call.createC3D(arbol, anterior);
                                                //asignacion
 
                c.setPtrTemp("ptr");
                armed+=c.c3d_asignVar(id, dir);
                c.clearPtrTemp();

            }else if(expr instanceof Access){
               armed+= expr.createC3D(arbol, anterior);
              varr = c.varsParams.getFirst();
              c.varsParams.removeFirst();
            }       
            
         }
         
                                                //instance dir
         armed+= c.c3d_acces("", 0);            
                                                //insert en heap
         armed+= c.c3d_asignHeap(varr, dir);
         
        
//        //assig 
//    tr6 = ptr + dir;
//    stack[tr6] = var;
        
        
            armed +="\n";
        return armed;
    }
}


