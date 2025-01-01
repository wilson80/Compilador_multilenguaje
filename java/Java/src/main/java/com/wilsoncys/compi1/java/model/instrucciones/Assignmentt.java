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
import com.wilsoncys.compi1.java.model.poo.Reference;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
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
            return null;
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
        Simbolo sym = null;
        if(isThis){
                                                //  buscar el sym solo en el ambito global
            String armedId = arbol.getCurrentAmbit().get(0);
             armedId += arbol.getCurrentAmbit().get(1)+id;
             sym = arbol.getSym(armedId);
                dir = sym.getDir();
                
        }else{                  //buscando en el ambito local
            String armedId = "";
            armedId= arbol.getAmbito_asID() + id;
            sym = arbol.getSym(armedId);
            if(sym==null){      //si no se encuentra en el ambito local buscar en el ambito global
                armedId = arbol.getCurrentAmbit().get(0);
                armedId += arbol.getCurrentAmbit().get(1) + id;
                sym = arbol.getSym(armedId);
                if(sym == null){        //revisar esto
                    return new Errores(id, "no se ha encontrado el simboloooooooooooooo", line, col);
                }else{
                    dir = sym.getDir();
                }
            }else{
                dir = sym.getDir();
            }
            

        }

 
                                                      // create a la expresion
         if(expr instanceof Input inp){
                inp.createC3D(arbol, anterior);
                armed+= c.c3d_Input();          //new var  
                armed+=c.c3d_asignVal("", dir);     //Entrada cin
                c.varsParams = new LinkedList<>();  //limpiar despues de agregar
             
         }else if(this.expr instanceof Nativo n){    //declaracion con valor vativo
            n.createC3D(arbol, anterior);   
            varr = c.varsParams.getFirst();
            c.varsParams.removeFirst();
        
//         else if(this.expr instanceof Call call){                          //declaracion y asignacion
//                                                  //create a la llamada
//              armed+= call.createC3D(arbol, anterior);
//              varr = c.varsParams.get(0);
//              c.clearVarParams();
//         }else if(expr instanceof Access a){
//             armed+= a.createC3D(arbol, anterior);
//            varr = c.varsParams.getFirst();
//            c.varsParams.removeFirst();
//        }else if(this.expr instanceof Reference ref){
//                                                  //create a la llamada
//              armed+= ref.createC3D(arbol, anterior);
//              varr = c.varsParams.get(0);
//              c.clearVarParams();
//            
        }else{
            armed +=this.expr.createC3D(arbol, anterior);
            varr = c.varsParams.getFirst();
            c.varsParams.removeFirst();
        }
         
         
          
         
                                            //realizando la asignacion
        if(sym.getCat() == categoria.ATRIBUTO){
                                            //instance dir
            armed+= c.c3d_acces("", 0);            
                                                   //insert en heap
            armed+= c.c3d_asignHeap(varr, dir);
         
        }else{
                                            //instance dir
                                                   //insert en stack
            armed+= c.c3d_asignAlone(varr);
            
            armed+= c.c3d_asignVal("", dir);

        }

               
        if(this.id.equals("objeto1")){
            JOptionPane.showMessageDialog(null, "dirObjetctVAR: "  + varr);
        } 
//        //assig 
//    tr6 = ptr + dir;
//    stack[tr6] = var;
 
        
            armed +="\n";
        return armed;
    }
}


