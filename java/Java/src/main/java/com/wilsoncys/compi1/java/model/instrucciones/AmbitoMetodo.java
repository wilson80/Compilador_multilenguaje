/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instrucciones;

/**
 *
 * @author jonwilson
 */
public class AmbitoMetodo {
    private String posTemp = "";
    private String labelReturn = "";

    public AmbitoMetodo(String pos, String labelR) {
        this.posTemp = pos;
        this.labelReturn = labelR;
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

  
 
    
    
             
            
            
}
