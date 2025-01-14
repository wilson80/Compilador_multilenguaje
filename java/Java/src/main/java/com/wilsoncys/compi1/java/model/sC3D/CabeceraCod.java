/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.sC3D;

/**
 *
 * @author jonwilson
 */
public class CabeceraCod {
    String cabezera = "#include <iostream>\n" 
                            +"#include <termios.h>\n" +
                             "#include <unistd.h>"+
                            "\n" +
                            "using namespace std;\n" +
                            "\n" +
            
            
            
                            "int stack[1000];\n" +
                            "int heap[1000];\n" +
                            "int ptr = 0;\n" +
                            "int h = 0;\n\n";

    public String getCabezera() {
        String al = "";
                
                
        return cabezera;
    }

 
    
    
}
