/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.vistas;

import java.awt.Color;
import java.awt.color.ColorSpace;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author jonwilson
 */
public enum TipoT {
    SECTION(Color.GREEN),   // Azul claro (coincide con palabras clave específicas como secciones)
    ERROR(new Color(240, 80, 80)),     // Rojo brillante (para errores)
    RESERV(Color.BLUE),  // Morado claro (para palabras reservadas)
    INT(new Color(181, 206, 168)),     // Verde pastel (para valores numéricos o constantes)
    VAL(Color.CYAN),     // Amarillo claro (para valores específicos o variables)
    SYMSS(new Color(212, 212, 212)),   // Gris claro (para símbolos y operadores)
    TODOO(new Color(128, 128, 128)),   // Gris medio (para tareas pendientes o marcadores)
    COMMENT(new Color(106, 153, 85));  // Verde oliva (para comentarios)

    
     
 
    
    
    
    private AttributeSet attributeSet; 
            
    private TipoT(Color col ){
        StyleContext cont = StyleContext.getDefaultStyleContext();
        this.attributeSet = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, col);
    }

    public AttributeSet getAttributeSet() {
        return this.attributeSet;
    }
    
    
    
}
