/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.vistas;

import com.wilsoncys.compi1.java.model.analisis.colorear2;
import java.io.IOException;
import java.io.StringReader;
import javax.swing.JTextPane;
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
    
    
    
//        private void pintar(Coloreado coloreado){
//        StyledDocument doc = this.pane.getStyledDocument();
//        doc.setCharacterAttributes(
//                (int) coloreado.getInitPos(), 
//                coloreado.getLength(), 
//                coloreado.getType().getAttributeSet(), 
//                false
//        );
//    } 
    
    private void pintar(colorInfo color){
        StyledDocument doc = this.pane.getStyledDocument();
        doc.setCharacterAttributes((int)color.getPosI(), 
                color.getSize(), 
                color.getType().getAttributeSet(), false);
        
    }
    
    
    
    
    
    @Override
       public void run(){
        StringReader reader = new StringReader(pane.getText());
        colorear2 lexer = new colorear2(reader);
        
//        StringReader reader = new StringReader(pane.getText());
//        PintorLexer lexer = new PintorLexer(reader);


        while (!lexer.yyatEOF()) {
            try {
                   
                colorInfo coloreado = lexer.yylex();
                if(coloreado != null){
                    pintar(coloreado);
                }
//                Coloreado coloreado = lexer.yylex();
//                    pintar(coloreado);
//                if(coloreado != null){
//                }
                
                
 

              
            }catch (IOException e) {
                        e.printStackTrace();
            }catch (NullPointerException ext){
                ext.printStackTrace();
            }
        }
      
    } 
        
        
    
    
 
    
        
    
    
    
    
    
    
    
    
    
}
