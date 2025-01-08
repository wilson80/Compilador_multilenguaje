/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.poo;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.Statement;
import com.wilsoncys.compi1.java.model.instrucciones.transferReturn;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class Method extends Instruction{
    public String id;
    public String idClase = "";
    public LinkedList<HashMap> parameters;
    public LinkedList<Instruction> instrucciones;
    private boolean isCreate = false;
    private int cantParams = 0;
    private int cantAttb = 0;

    private List<String>  ambito;   //idclase/metodo/params
    private int cantSyms = 0;
    

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
                cantParams++;       //pte analisis 

        for (Instruction ins : instrucciones) {
            if(ins instanceof Statement st){
                //ambito
                Simbolo sym = new Simbolo(st.tipo, st.id, tabla, true);
                sym.setCat(categoria.VARL);
                sym.setDir(cantParams);
                sym.setInstruction(ins);
                sym.setAmbito(ambito);
                sym.armarAmbito(st.id);
                tabla.addSsymbolPre(sym);
                cantParams++;
            }
        } 
        
        return null;
    }
        
    
    
    
    
            @Override
    public Object createC3D(Arbol arbol, String anterior) {
        String armed = "";
        C3d_Java c = arbol.getJava();
        
        String devVars = "";
        int iniVars = c.countCreateVar;
                        //ambito anterior
        List<String> ambitoAntList = new ArrayList<>(arbol.getCurrentAmbit());
        
        
        String ambitoAnt = arbol.getCurrentAmbit().get(1);
        arbol.setCurrentAmbit(this.ambito);

        
        String bodyMet = "";
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            bodyMet += (String)ins.createC3D(arbol, anterior);
//            arbol.setCurrentAmbit(this.getAmbito());
            arbol.getCurrentAmbit().set(1, ambitoAnt);

        }
        arbol.setCurrentAmbit(ambitoAntList);
        
        int finVars = c.countCreateVar;

        for (int i = iniVars; i < finVars; i++) {
            devVars += "int w" + i+  ";\n";
        }
            
        armed = devVars + "\n";
        armed += bodyMet;
        
        
        armed = c.c3d_metodo("java_" + ambitoAnt +"_"+ id, armed);
        
        
        
        if(!isCreate){
            arbol.Print(armed);
            this.isCreate = true;
        }
        
        return "";
    }

     
    
    
    public void setCantParams(int cantParams) {
        this.cantParams = cantParams;
    }

    public int getCantParams() {
        return cantParams;
    }

    public void setAmbito(List<String> ambito) {
        this.ambito = ambito;
    }

    public List<String> getAmbito() {
        return ambito;
    }

    public String getIdClase() {
        return idClase;
    }

    public void setIdClase(String idClase) {
        this.idClase = idClase;
    }

    public int getCantAttb() {
        return cantAttb;
    }

    public void setCantAttb(int cantAttb) {
        this.cantAttb = cantAttb;
    }
    
    
     
}
