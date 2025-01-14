/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.poo;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.poo.Mainn;
import com.wilsoncys.compi1.java.model.instrucciones.Statement;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jonwilson
 */
  public class Classs extends Instruction{
    public  String id;
    private  String id_constructor;
    private String idPadre;
    private int cantAttb = 0;
    private List<String>  ambito;   //idclase/metodo/params

    public LinkedList<Instruction> instrucciones;
    
    private boolean main;
    
   // private TablaSimbolos tablaGlobal;              //contiene las variables declaradas globalmente
    
    public Classs(String id, LinkedList<Instruction> instrucciones, int linea, int col) {
        super(new Tipo(tipoDato.OBJECT), linea, col);
        this.id = id;
        this.instrucciones = instrucciones;
        this.tipo.setIdObjeto(this.id);
    }
    
     
    public Classs(String id, String idPadre, LinkedList<Instruction> instrucciones, Tipo tipo, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        
        
    }
  
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        
        for (Instruction ins : instrucciones) {
            TablaSimbolos newTable = new TablaSimbolos(tabla);
            if(ins==null){
                    continue;
            }
            if(ins instanceof Method met){
                 
                var algo = met.interpretar(arbol, newTable);
                if(algo instanceof Errores){
                    return algo;
                }
                    
            }
        }
        
        
        
         
        
        return null;
    }

     
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        this.ambito = new LinkedList<>();
        ambito.add("java");
        ambito.add(this.id);
        
        //attb
        int contador = 0;
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            if(ins instanceof Statement st){
                //ambito
                Simbolo sym = new Simbolo(st.tipo, st.id, tabla, false);
                sym.setCat(categoria.ATRIBUTO);
                sym.setDir(contador);
                sym.setInstruction(ins);
                sym.setAmbito(this.ambito);
                sym.armarAmbito(st.id);
                st.setAmbito(sym.getAmbito());//ambito a la instruccion
                if(!(tabla.addSsymbolPre(sym))){
                    return new Errores("SEMANTIC", "El simbolo ya existe: " + st.id , st.line, st.col);
                }
                
                contador++;
                
            }
        }
        
        this.cantAttb = contador; 
        contador = 0;
        
        //Main
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            
            if(ins instanceof  Mainn mainn){
                mainn.setCantAttb(this.cantAttb);
                contador = 2;
                Simbolo sym = new Simbolo(this.tipo, mainn.id, tabla, false);
                sym.setCat(categoria.CONSTRUCTOR);
                sym.setDir(contador);
                sym.setInstruction(ins);
                sym.armarAmbito("java");
                sym.armarAmbito(this.id);
                sym.armarAmbito(mainn.id);
                List<String> typeParam = new ArrayList<>();
                for (HashMap hash : mainn.parameters) {
                    Tipo tipo = (Tipo)hash.get("tipo");
                    typeParam.add(tipo.getTypeString());
                } 
                sym.getAmbito().addAll(typeParam);          //Car_Car_int_String_Motor
                
                
                if(!(tabla.addSsymbolPre(sym))){
                    return new Errores("SEMANTIC", "El simbolo ya existe: " + mainn.id , mainn.line, mainn.col);
                }
                mainn.setAmbito(sym.getAmbito());
                for (HashMap param : mainn.parameters) {          //syms de params
                    String idparam = (String)param.get("id");
                    Simbolo symPar = new Simbolo((Tipo)param.get("tipo"), idparam, null, false);
                    symPar.setCat(categoria.PARAM);
                    symPar.setDir(contador);
                    symPar.setAmbito(mainn.getAmbito());
                    symPar.armarAmbito((String)param.get("id"));
                    tabla.addSsymbolPre(symPar);            //add symParam
//                    sym.setInstruction(ins);
                    contador++;
                }
                
                mainn.setCantParams(contador);
                mainn.createSym(arbol, tabla);          //create syms
//                    arbol.setSizeHeap(mainn.getCantParams());
//                
            }
        }
        

        //methods
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            
            if(ins instanceof  Method fun){
                fun.setCantAttb(this.cantAttb);
                contador = 2;
                                                    
                Simbolo sym = new Simbolo(fun.tipo, fun.id, null, true);
                sym.setCat(categoria.METHOD);
                sym.setDir(contador);
                sym.setInstruction(ins);
                sym.armarAmbito("java");
                sym.armarAmbito(this.id);
                sym.armarAmbito(fun.id);
                List<String> typeParam = new ArrayList<>();
                for (HashMap hash : fun.parameters) { 
                    Tipo tipo = (Tipo)hash.get("tipo");
                    typeParam.add(tipo.getTypeString());
                }
                sym.getAmbito().addAll(typeParam);                 //Car_Car_int_String_Motor
                
                
                if(!(tabla.addSsymbolPre(sym))){
                    return new Errores("SEMANTIC", "El simbolo ya existe: " + fun.id , fun.line, fun.col);
                }
                fun.setAmbito(sym.getAmbito());
                contador=2;       //add dir(ref,retorno,dir_retorno)
                for (HashMap param : fun.parameters) {          //syms de params
                    String idparam = (String)param.get("id");
                    Simbolo symPar = new Simbolo((Tipo)param.get("tipo"), idparam, null, true);
                    symPar.setCat(categoria.PARAM);
                    symPar.setDir(contador);
                    symPar.setAmbito(fun.getAmbito());
                    symPar.armarAmbito((String)param.get("id"));
                    tabla.addSsymbolPre(symPar);            //add symParam
                    symPar.setInstruction(ins);
                    contador++;
                }
                fun.setCantParams(contador);
                fun.createSym(arbol, tabla);
            }
        }
        
        
        

        //functions
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            if(ins instanceof  Functionss fun){                
                fun.setCantAttb(this.cantAttb);
                contador = 3;
                Simbolo sym = new Simbolo(fun.tipo, fun.id, null, true);
                sym.setCat(categoria.FUNCTION);
//                                                sym.setDir(contador);
                sym.setInstruction(ins); 
                sym.armarAmbito("java");
                sym.armarAmbito(this.id);
                sym.armarAmbito(fun.id);
                List<String> typeParam = new ArrayList<>();
                for (HashMap hash : fun.parameters) { 
                    Tipo tipo = (Tipo)hash.get("tipo");
                    typeParam.add(tipo.getTypeString());
                }
                
                sym.getAmbito().addAll(typeParam);                 //Car_Car_int_String_Motor
                if(!(tabla.addSsymbolPre(sym))){
                    return new Errores("SEMANTIC", "El simbolo ya existe: " + fun.id , fun.line, fun.col);
                }
                fun.setAmbito(sym.getAmbito()); 
                contador=3;     //add dir(ref,retorno,dir_retorno)
                for (HashMap param : fun.parameters) {          //syms de params
                    String idparam = (String)param.get("id");
                    Simbolo symPar = new Simbolo((Tipo)param.get("tipo"), idparam, null, true);
                    symPar.setCat(categoria.PARAM);
                    symPar.setDir(contador);
                    symPar.setAmbito(fun.getAmbito());
                    symPar.armarAmbito((String)param.get("id"));
                    tabla.addSsymbolPre(symPar);            //add symParam
                    symPar.setInstruction(ins);
                    contador++;
                }
                fun.setCantParams(contador);
                fun.createSym(arbol, tabla);
            }
        }
        contador = 0;
 
            
        return null; 
    }
    
    
    


    
    
    
    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        String armed = ""; 
        C3d_Java c = arbol.getJava(); 
        int iniVars = c.contador; 

        arbol.setSizeHeap(this.cantAttb);

        arbol.setAmbito(this.ambito);
        
//        interpretar todos lo funciones/funciones de esta clase
                            for (Instruction fun : instrucciones) {
                                if(fun instanceof Functionss funn){
                                    funn.createC3D(arbol, anterior);
                                }
                            }

                            for (Instruction fun : instrucciones) {
                                if(fun instanceof Method met){
                                    met.createC3D(arbol, anterior);
                                }
                            }
                            for (Instruction fun : instrucciones) {
                                if(fun instanceof Mainn constr){
                                    constr.createC3D(arbol, anterior);
                                }
                            }
        
//        arbol.getSym(id_constructor).getInstruction().createC3D(arbol, anterior);
        


        
        //crear el constructor por default
         //identificar,  si no hay un constructor por default se crea uno
        
        
         
         
         
//        
//        //reservar el espacio en el  heap
//        armed+= c.c3d_reserveHeap(arbol.getSizeHeap());
//        
//        //set a la referencia (stack[0])
//        armed+= c.c3d_asignVal("", 0);
//        
////         List<String> currentAmbito = arbol.getCurrentAmbit();
//        arbol.setCurrentAmbit(this.getAmbito());
//        for (Instruction ins : instrucciones) {
//            if(ins instanceof Statement st){
//                armed += (String)st.createC3D(arbol, anterior);
//            }
//        }
//        int contador = 0;
//        buscar su constructor  dependiendo los parametros enviados
//        Mainn mainEcontrado = null;
//        for (Instruction ins : instrucciones) {
//            
//            if(ins instanceof Mainn mn){    //Main(clase de los constructores)
//                contador++;
//                if(mn.id.equals(this.id)){
//                    //identificar el constructor
//                    if(this.id_constructor.equals(mn.getAmbito_asID())){
//                        mainEcontrado = mn;
//                    }
//                }else{
//                                            //validacion >> el nombre del constructor debe ser igual al nombre de la clase
//                    JOptionPane.showMessageDialog(null, "error en el nombre del constructor");
//                }
//            }
//            
//        }
        
        
        
                    //MAIN
//        if(mainEcontrado!=null){
            //realizar el constructor por defecto
                    //inicializar los attb con valores por defecto
                    
           
//            String devVars = "";
//            
//            armed+=mainEcontrado.createC3D(arbol, anterior);
//            int finVars = c.countCreateVar;
//            
//            
//
//            for (int i = iniVars; i < finVars; i++) {
//                devVars += "int w" + i+  ";\n";
//            }
//
//            String temp = armed; 
//            armed = "\n" + devVars + "\n";
//            armed += temp;
//            
//        }else{
//            if(contador!=0 || !(id_constructor.equals("java" + id + id))){  
//                    //no hay constructor por defecto
//                JOptionPane.showMessageDialog(null, "Parametros incorrectos al instanciar una clase");
//            } 
//        }
        
        
//        armed = c.c3d_metodo("java_"+id + "_"+ id, armed);
        
            
//        if(!mainEcontrado.isIsCreate()){
//            arbol.Print(armed);
//            mainEcontrado.setIsCreate(true);
//        }
        
//        if(currentAmbito.size() != 0){
//            arbol.setAmbito(currentAmbito);
//        } 
        
        return "";
    }

    
    
    
    
    
    
    public String getAmbito_asID() {
        String algo = "";
        for (String st : ambito) {
            algo+=st;
        }
        
        return algo;
    }
    
    
    
    
    
    
    
    
    
    public String getId() {
        return id;
    }

    public String getIdPadre() {
        return idPadre;
    }


//    public void setCantAttb(int cantAttb) {
//        this.cantAttb = cantAttb;
//    }
//
//    public int getCantAttb() {
//        return cantAttb;
//    }

    public boolean isMain() {
        return main;
    }

    public List<String> getAmbito() {
        return ambito;
    }

    public void setId_constructor(String id_constructor) {
        this.id_constructor = id_constructor;
    }

    public void setCantAttb(int cantAttb) {
        this.cantAttb = cantAttb;
    }

    public int getCantAttb() {
        return cantAttb;
    }
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
    @Override
    public String generarast(Arbol arbol, String anterior) {
//    public String generarast(Arbol arbol, int direccion) {
//    public String generarast(Arbol arbol, simbolo ) {
        String algo = anterior;
        for (Instruction instruccione : instrucciones) {
            if(instruccione instanceof Method){
                algo = instruccione.generarast(arbol, algo); 
            }
        }


        return  algo;
    }
       
    
    
    
    
}
