/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.vistas;

import java.awt.Color;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author jonwilson
 */
public enum TipoT {
    
    SECTION(Color.GREEN),
    ERROR(Color.RED),
    RESERV(Color.MAGENTA),
    INT(Color.MAGENTA),
    VAL(Color.MAGENTA),
    SYMSS(Color.CYAN),
    TODOO(Color.BLACK),
    ;
    
    
    
    private AttributeSet attributeSet; 
            
    private TipoT(Color col ){
        StyleContext cont = StyleContext.getDefaultStyleContext();
        this.attributeSet = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, col);
    }

    public AttributeSet getAttributeSet() {
        return this.attributeSet;
    }
    
    
    
}
