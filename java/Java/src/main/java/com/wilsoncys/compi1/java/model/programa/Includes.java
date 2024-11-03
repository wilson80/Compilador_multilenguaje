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
    private boolean javaTodo = false;
    private boolean pascalTodo = false;
    private LinkedList<String> claseJava;
    private LinkedList<String> subPPascal;

    public Includes() {
        claseJava = new LinkedList<>();
        subPPascal = new LinkedList<>();
    }

    public String getClaseJava(String id) {
        return "";
    }

     
    
    public void addSubPPascal(String subPPascal) {
        this.subPPascal.add(subPPascal);
    }
    public void addClaseJava(String subPPascal) {
        this.claseJava.add(subPPascal);
    }
 
    
}
