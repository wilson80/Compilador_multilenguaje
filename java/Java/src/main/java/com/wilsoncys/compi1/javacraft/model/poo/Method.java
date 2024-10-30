/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.poo;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.instrucciones.Statement;
import com.wilsoncys.compi1.javacraft.model.instrucciones.transferReturn;
import com.wilsoncys.compi1.javacraft.model.sC3D.C3d;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Simbolo;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.categoria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jonwil
 */
public class Method extends Instruction{
    public String id;
    public LinkedList<HashMap> parameters;
    public LinkedList<Instruction> instrucciones;
    
    private int cantParams = 0;
    private List<String>  ambito;   //idclase/metodo/params
    

    public Method(String id, LinkedList<HashMap> parametros, LinkedList<Instruction> instrucciones, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.id = id;
        this.parameters = parametros;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos table) {
        for (var instruct : this.instrucciones) {
             if (instruct == null) {
                    continue;
            }
            
//            if(instruct instanceof transferReturn){  //puede venir una instruccion dentro del metodo de tipo return
//                return null; 
//            }
//            if(instruct instanceof transferReturn){
//                return instruct;
//            }
            if(instruct instanceof transferReturn){
                return instruct;
            }
            // el problema de eso ^^ es que no la expresion podria retornar // Verify
//            algo que no es y el error tiene que ser devuelto por la llamada y no por la asignacion
            var ressult = instruct.interpretar(arbol, table);
            if(ressult instanceof transferReturn){
                return ressult;
            }
            if(ressult instanceof transferReturn){
                return ressult;
            }
            
            
            if(ressult instanceof Errores error){
                arbol.addError(error);
            }
            
//            if(ressult instanceof transferReturn){
//                return null; 
//            }
            
        }
        
        return null;
    }
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        String algo = anterior;
        for (Instruction ins : instrucciones) {
            algo = ins.generarast(arbol, algo);
            
        }
        
        return algo;
    }
    
    
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        //dir ref
        //retorno
        //dir dir ret
        //desde la clase se le hace set a la cantidad de params
        for (Instruction ins : instrucciones) {
            if(ins instanceof Statement st){
                //ambito
                Simbolo sym = new Simbolo(tipo, st.id, tabla, true);
                sym.setCat(categoria.VARL);
                sym.setDir(cantParams);
                sym.setInstruction(ins);
                sym.setAmbito(ambito);
                tabla.addSsymbolPre(sym);
                cantParams++;
            }
        } 
        
        return null;
    }
        
    
    
    
    
            @Override
    public Object createC3D(Arbol arbol, String anterior) {
        String armed = "";
        C3d c = new C3d();
        String bodyMet = "";
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            bodyMet += (String)ins.createC3D(arbol, anterior);
        }
        armed+=c.c3d_metodo(id, bodyMet);
            
        arbol.Print(armed);
        
        return ">>Methos<<";
    }

     
    
    
    public void setCantParams(int cantParams) {
        this.cantParams = cantParams;
    }

    public void setAmbito(List<String> ambito) {
        this.ambito = ambito;
    }

    public int getCantParams() {
        return cantParams;
    }
     
}
