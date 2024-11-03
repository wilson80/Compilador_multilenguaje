/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.vistas;

import com.wilsoncys.compi1.java.model.analisis.colorear2;
import java.io.IOException;
import java.io.StringReader;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 *
 * @author jonwilson
 */
public class SetColor extends Thread{
    private JTextPane pane;

    public SetColor(JTextPane pane) {
        this.pane = pane;
    }
    
    
    private void pintar(colorInfo color){
        StyledDocument doc = this.pane.getStyledDocument();
        doc.setCharacterAttributes((int)color.getPosI(), 
                color.getSize(), 
                color.getType().getAttributeSet(), false);
        
    }
    
    public void run(){
        StringReader reader = new StringReader(pane.getText());
        colorear2 lex = new colorear2(reader);
        
        
        try {
            while (!lex.yyatEOF()) {
                colorInfo colorr = lex.yylex();
                pintar(colorr);


                if (colorr != null) {
                        pintar(colorr); // Aplicar el color al JTextPane
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException ext){
            ext.printStackTrace();
        }
        
        
    }
    
    
        
    
    
    
    
    
    
    
    
    
}
