/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instrucciones;

/**
 *
 * @author jonwilson
 */ 
 
public class NewClass {
      Nodo primero;
      Nodo ultimo;
      int size;

    public NewClass() {
    }
     
     public void agregar(int contenido) {
        Nodo nuevoNodo = new Nodo(contenido);
        if (esVacia()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo); 
            nuevoNodo.setAnterior(ultimo);
            ultimo = nuevoNodo;
        }
        
        size++;
    }
    
    public boolean esVacia() {
        return primero == null;
    }

  
    
    public void imprimirLista() {
        if (esVacia()) {
             System.out.println("La lista esta vacia");
        } else {
        
            Nodo actual = primero;
            while(actual.getSiguiente() != null) {
                 System.out.println("contenido: " + actual.getContenido());
                actual = actual.getSiguiente();
            }
             System.out.println("contenido: " + actual.getContenido());
        }
    }
    



  
    
    public static void main(String[] args) {
        
            NewClass lista = new NewClass();

            lista.agregar(99);
            lista.agregar(37);
            lista.agregar(43);
            lista.imprimirLista();
            
            // listaString.eliminarUltimo();
            // listaString.eliminarUltimo();
            // listaString.imprimirLista();
            
            // listaString.eliminarUltimo();
            // listaString.imprimirLista();
        
        
    }
    
}



   
//         
// 
 


    
 