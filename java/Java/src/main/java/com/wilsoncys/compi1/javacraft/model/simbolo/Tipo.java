/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.simbolo;

/**
 *
 * @author yoyo
 */
public class Tipo {
    private tipoDato tipo;

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
                return "double";    //podria ser real
                
            case CARACTER:
                return "char";
                
            case BOOLEANO:
                return "boolean";
                
            case CADENA:
                return "String";
            case VOID:
                return "nombreClase";
                
            default:
                System.out.println("Error(al crear la tabla(clase tipos))");
                return "";
                    
        }
        
    } 
    
    

    
}
