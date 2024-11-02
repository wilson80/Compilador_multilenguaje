/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.simbolo;

/**
 *
 * @author yoyo
 */
public class Tipo {
    private tipoDato tipo;
    private String idObjeto;
    
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

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getIdObjeto() {
        return idObjeto;
    }
    
    
    
    
    

    
}
