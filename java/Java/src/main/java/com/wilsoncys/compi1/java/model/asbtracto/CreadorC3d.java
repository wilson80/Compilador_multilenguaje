/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.asbtracto;

import java.util.LinkedList;

/**
 *
 * @author jonwilson
 */
public abstract class CreadorC3d {
    public int contador = 0;
    public LinkedList<String> varsParams;
    
    
    public abstract String c3d_asignAlone(String val); 
    public abstract String c3d_operation(String val1, String val2);
    public abstract void setOPRT(String OPRT);
    public abstract String cond_If(String op1, String op2, String labelif, String labelSalida);
    
        
        
    public int getContador() {
        return contador;
    }

    public LinkedList<String> getVarsParams() {
        return varsParams;
    }
    
    
    
    
    
}
