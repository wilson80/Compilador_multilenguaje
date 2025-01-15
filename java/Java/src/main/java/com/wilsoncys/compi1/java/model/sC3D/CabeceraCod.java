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
            
//                                "#include <conio.h>" + 
            
                                "int stackint[10000];\n" +
                                "string stackstring[10000];\n" +
                                "float stackfloat[10000];\n" +
                                "char stackchar[10000];\n" +
                                "int heapint[10000];\n" +
                                "string heapstring[10000];\n" +
                                "float heapfloat[10000];\n" +
                                "char heapchar[10000];\n" +
//                            "int stack[1000];\n" +
            
            
                            "int ptr = 0;\n" +
                            "int h = 0;\n\n";

    public String getCabezera() {
        String al = "";
                
                
        return cabezera;
    }

 
    
    
}
