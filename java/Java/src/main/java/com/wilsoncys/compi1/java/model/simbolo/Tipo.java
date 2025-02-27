/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.simbolo;

import javax.swing.JOptionPane;

/**
 *
 * @author yoyo
 */
public class Tipo {
    private tipoDato tipo;
    private String idObjeto = "";
    
    public Tipo(tipoDato tipo) {
        this.tipo = tipo;
    }

    public tipoDato getTipo() {
        return tipo;
    }

    public void setTipo(tipoDato tipo) {
        this.tipo = tipo;
    }

    public String getTypeString(){
        
        switch (tipo) {
            case ENTERO:
                return "int";
            case DECIMAL:
                return "float";    //podria ser real
                
            case CARACTER:
                return "char";
                
            case BOOLEANO:
                return "boolean";
                
            case CADENA:
                return "string";
            case OBJECT:
                return idObjeto;
                
            default:
                System.out.println("default en typeStringgg");
                return "";
                    
        }
        
    } 

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getIdObjeto() {
        return idObjeto;
    }
    
    
    
    
    

    
}
