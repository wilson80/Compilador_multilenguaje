/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.vistas;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.StyledDocument;

/**
 *
 * @author jonwilson
 */ 

public class controlColores {
    private static Timer timer;
    
//    public controlColores(JTextPane pane){
//        StyledDocument doc = pane.getStyledDocument();
//
//        // Agregar un DocumentListener para detectar cambios en el texto
//        doc.addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                textoCambiado(pane);
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                textoCambiado(pane);
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                
//            }
//        });
//    }
    
    private void setcolores(JTextPane pane) {
        if (timer != null) {
            timer.cancel(); 
        }
        
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SetColor setColorThread = new SetColor(pane);
                setColorThread.start();
            }
        }, 500); 
    }

     
      
}
