/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.control;

import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.simbolo.tablaSimbolos;
import com.wilsoncys.compi1.javacraft.vistas.VistaGeneral;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
public class Control {
    private VistaGeneral vistaGeneral;
    private LinkedList<Errores> listaErrores = new LinkedList<>();
    private String mconsola = "";
    private LinkedList<tablaSimbolos> tablaReport = new LinkedList<>();          //par la tabla de simbolos

    
    public Control() {
        configurarVentana();
        
    }
    
    
    public void configurarVentana(){
        vistaGeneral = new VistaGeneral(this);
//        vistaGeneral.setExtendedState(vistaGeneral.MAXIMIZED_BOTH);
        vistaGeneral.setBounds(0, 0, 1500, 830);
        vistaGeneral.setVisible(true);
        
    }
    
    public void analizar(String texto){
        IniciarAnalizadores analizar = new IniciarAnalizadores(texto);
        analizar.Interpretar();
        listaErrores = analizar.getListaErrores();
        mconsola = analizar.getMensajeEjecucion();
        tablaReport = analizar.getTablaReport();
    }

    public LinkedList<Errores> getListaErrores() {
        return listaErrores;
    }

    public String getMconsola() {
        return mconsola;
    }

    public LinkedList<tablaSimbolos> getTablaReport() {
        return tablaReport;
    }

    
    
    
    
}
