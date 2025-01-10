/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instrucciones;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.Input;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */


public class Statement extends Instruction{

    public String id;
    public Instruction exp;
    private boolean declaracionSimple;
    private boolean isConst;
    private int whatConstruct = 0;
    private List<String>  ambito;   //idclase/metodo/params

    
    
                                                    //    var num1:int;
    //constructor sin asignacion (declaracion simple)
    public Statement(String identificador, Tipo tipo, int linea, int col, boolean isMutable) {
        super(tipo, linea, col);
        this.id = identificador;
        this.declaracionSimple = true;
        this.isConst = isMutable;
        this.whatConstruct = 0;
    }
                                                   //    var num1:int = 5;
    //constructor con asignacion
    public Statement(String identificador, Instruction exp, Tipo tipo, int linea, int col, boolean isMutable) {
        super(tipo, linea, col);
        this.id = identificador;
        this.exp = exp;
        this.declaracionSimple = false;
        this.isConst = isMutable;
        this.whatConstruct = 1;
    }
//    \\\\analizar

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        if(declaracionSimple){
            return declare(arbol, tabla);
        }else{
            return declareAssign(arbol, tabla);
        }
    }

    public Object declare(Arbol arbol, TablaSimbolos tabla) {
            //validando la existencia de la variable
        Simbolo newSymbol = new Simbolo(this.tipo, id, darValorDefecto(), isConst);    
        newSymbol.setLinea(line);
        newSymbol.setLinea(col);
        boolean isCreacion = tabla.aquiNoo(newSymbol);
        
        if(isCreacion){
            return null;
        }else{
            return new Errores("SEMANTIC", "la variable ya existe", line, col);
        }
        
    }

    public Object declareAssign(Arbol arbol, TablaSimbolos tabla) {
        // interpretar para obtener el valor
        var valorInterpretado = this.exp.interpretar(arbol, tabla);

        //validar posible error
        if (valorInterpretado instanceof Errores) {
            return valorInterpretado;
        }

        //validar el tipo de la variable a asignar con el tipo declarado
                    if (this.exp.tipo.getTipo() != this.tipo.getTipo()) {
                        return new Errores("SEMANTICO", "Tipos erroneos", this.line, this.col);
                    }

        Simbolo newSsimbol = new Simbolo(this.tipo, this.id, valorInterpretado, isConst);
        newSsimbol.setLinea(line);
        newSsimbol.setLinea(col);
        boolean creacion = tabla.aquiNoo(newSsimbol);
        if (creacion) {
            return null; 
        }else{      //si creacion es false(significa que la variable existe) se devuelve un error
            return new Errores("SEMANTICO", "La Variable ya existent", this.line, this.col);
        }

    }
    
    public Object darValorDefecto(){
        switch (tipo.getTipo()) {
            case ENTERO->{
                return 0;
            }
            case DECIMAL->{
                return 0.0;
            }
            case CADENA->{
                return "";
            }
            case BOOLEANO->{
                return  true;
            }
            case CARACTER->{
                return  '0';
            }
            default->{
                return "";
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
        C3d_Java c =  arbol.getJava();
//        int dir  = arbol.getSym(this.getAmbito_asID()).getDir();
        Simbolo sym = arbol.getSym(arbol.getAmbito_asID()+ id);
        int dir  = arbol.getSym(arbol.getAmbito_asID()+ id) .getDir();

        
        
        
        if(whatConstruct == 0){
//            c.varsParams.add("0");
            //si el valor es un nativo
            //-1 si es un objeto para marcar que esta nulo
            //halar la ref
                                    //pendiente de tipos
            String valDefault = "0";
            
            if(sym.getTipo().getTipo() == tipoDato.OBJECT){
                valDefault = "-1";
            }
            
                                            //val por defecto asignar
            if(sym.getCat() == categoria.ATRIBUTO){
                                                            //dir ref
                armed += c.c3d_acces("ptr", 0);
                armed += c.c3d_asignHeap(valDefault, dir);
            }else if(sym.getCat() == categoria.VARL){
                armed += c.c3d_asignAlone(valDefault);
                armed += c.c3d_asignVal(id, dir);
            }
            
            
            
        }
        
        if(whatConstruct == 1){
            
            if(exp instanceof Input inp){
                    inp.createC3D(arbol, anterior);
                    armed+= c.c3d_Input();  
                    armed+=c.c3d_asignVal("", dir);
                    c.varsParams = new LinkedList<>();
                
            }else if(exp instanceof Nativo n){
                 n.createC3D(arbol, anterior); //create exp
                                                            //asignacion
                armed+=c.c3d_asignVal("", dir);
                c.varsParams = new LinkedList<>();
                
                
            }else{
                armed+=this.exp.createC3D(arbol, anterior); //create exp
                                                            //asignacion
//                armed+=c.c3d_asignVal(c.varsParams.get(0), dir);
//                for (String vaa : c.varsParams) {
//               }
                armed+=c.c3d_asignVal("", dir);
                
                c.varsParams = new LinkedList<>();
            }
            
            
        }
         
        return armed;
    }

    
    
        public void setAmbito(List<String> ambito) {
            this.ambito = new LinkedList<>();
            for (String st : ambito) {
                this.ambito.add(st);
            }
        }

    public List<String> getAmbito() {
        return ambito;
    }

    
    public String getAmbito_asID(){
        String ambi = "";
        for (String st : ambito) {
            ambi +=st;
        }
        return ambi; 
                
    }

    public String getId() {
        return id;
    }
    
    
    
    
}



