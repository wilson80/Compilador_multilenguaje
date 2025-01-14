/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instrucciones;

import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jonwilson
 */
public class AmbitoMetodo {
    private static final String JAVA = "java";
    private static final String PROGRAMA = "PROGRAMA";
    private static final String PASS = "pas";
    
    private String lenguaje = "";
    
    private List<String> ambito;
    
    private LinkedList<String> vars;
     
    
    private String posTemp = "";
    private String labelReturn = "";
    
 
    
    
    public AmbitoMetodo(String pos, String labelR, List<String> ambito ) {
        this.posTemp = pos;
        this.labelReturn = labelR;
        this.ambito = ambito;
        this.vars = new LinkedList<>();
        if(ambito.size() != 0){
            setLenguaje(ambito.get(0));
                
        }
    }
    
    
    
    public String getPosTemp() {
        return posTemp;
    }

    public void setPosTemp(String posTemp) {
        this.posTemp = posTemp;
    }

    public String getLabelReturn() {
        return labelReturn;
    }

    public void setLabelReturn(String labelReturn) {
        this.labelReturn = labelReturn;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public LinkedList<String> getVars() {
        return vars;
    }

    
    public String getDeclar(){
        String al = "";
        for (String var : vars) {
            al += var;
        }
        return al;
    }
    
    
 
        
        
        
        
    }
    
    
    
    
     