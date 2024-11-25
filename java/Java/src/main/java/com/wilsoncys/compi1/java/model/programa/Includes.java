/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa;

import java.util.LinkedList;

/**
 *
 * @author jonwilson
 */
public class Includes {
//    private boolean javaTodo = false;
    private boolean javaTodo = false;
    private boolean pascalTodo = false;
    private LinkedList<String> claseJava;
    private LinkedList<String> subPPascal;

    public Includes() {
        claseJava = new LinkedList<>();
        subPPascal = new LinkedList<>();
    }

      
    
    public void addSubPPascal(String subPPascal) {
        this.subPPascal.add(subPPascal);
    }
    public void addClaseJava(String subPPascal) {
        this.claseJava.add(subPPascal);
    }

    public LinkedList<String> getClaseJava() {
        return claseJava;
    }

    public LinkedList<String> getSubPPascal() {
        return subPPascal;
    }

    public boolean isJavaTodo() {
        return javaTodo;
    }

    public boolean isPascalTodo() {
        return pascalTodo;
    }

    public void setJavaTodo(boolean javaTodo) {
        this.javaTodo = javaTodo;
    }

    public void setPascalTodo(boolean pascalTodo) {
        this.pascalTodo = pascalTodo;
    }
    
    
    
    
 
    
}
