/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instrucciones;

/**
 *
 * @author jonwilson
 */
public class Nodo {
    
    
    int contenido;
    Nodo siguiente;
    Nodo anterior;

    public Nodo(int contenido) {
        this.contenido = contenido;
    }

        

    // public void setContenido(String contenido) {
    //     this.contenido = contenido;
    // }

    public int getContenido() {
        return contenido;
    }
     public Nodo getSiguiente() {
         return siguiente;
     }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
      

    // public Nodo getAnterior() {
    //     return anterior;
    // }
    
    
}
