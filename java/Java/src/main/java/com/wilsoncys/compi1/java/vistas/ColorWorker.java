/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.vistas;

import com.wilsoncys.compi1.java.model.analisis.colorear2;
import java.io.StringReader;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;
import javax.swing.text.StyledDocument;

/**
 *
 * @author jonwilson
 */ 
    
// SwingWorker para manejar la coloración de fondo
public class ColorWorker extends SwingWorker<Void, Void> {
    private JTextPane pane;

    public ColorWorker(JTextPane pane) {
        this.pane = pane;
    }

    @Override
    protected Void doInBackground() throws Exception {
        StringReader reader = new StringReader(pane.getText());
        colorear2 lex = new colorear2(reader);

        try {
            while (!lex.yyatEOF()) {
                colorInfo colorr = lex.yylex();
                if (colorr != null) {
                    pintar(colorr); // Aplica el color en segundo plano
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Actualiza el JTextPane en el hilo de interfaz gráfica después de colorear
    @Override
    protected void done() {
        pane.repaint();
    }

    private void pintar(colorInfo color) {
        StyledDocument doc = this.pane.getStyledDocument();
        doc.setCharacterAttributes((int) color.getPosI(),
                color.getSize(),
                color.getType().getAttributeSet(), false);
    }
}
