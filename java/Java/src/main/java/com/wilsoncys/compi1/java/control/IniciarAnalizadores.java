/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.control;

import com.wilsoncys.compi1.java.Main;
import com.wilsoncys.compi1.java.model.analisis.*;
import com.wilsoncys.compi1.java.model.asbtracto.*;
import com.wilsoncys.compi1.java.model.excepciones.*;
import com.wilsoncys.compi1.java.model.poo.*; 
import com.wilsoncys.compi1.java.model.programa.ClasesJava;
import com.wilsoncys.compi1.java.model.programa.Programa;
import com.wilsoncys.compi1.java.model.simbolo.*;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
public class IniciarAnalizadores {
    private String texto;
    private String mensajeEjecucion = "";
    private String mensajeErrores = "";
    private String mensaExp  = "";
    private String expStack  = "";
    private Exception ex;
                StringWriter sw = new StringWriter();
                
    private LinkedList<Errores> listaErrores = new LinkedList<>();
    private LinkedList<TablaSimbolos> tablaReport = new LinkedList<>();          //par la tabla de simbolos

                

    public IniciarAnalizadores(String texto) {
        this.texto = texto;
    }
 
    
    public void Interpretar(){
        try {
            scanner s = new scanner(new BufferedReader(new StringReader(texto)));
            parser p = new parser(s);
            var resultado = p.parse();
             
            var ast = new Arbol((LinkedList<Instruction>) resultado.value);

            TablaSimbolos tabla = new TablaSimbolos();
                tabla.setNombre("GLOBAL");
                ast.setConsola("");
                ast.setTablaGlobal(tabla);
        
            listaErrores = new LinkedList<>();
            listaErrores.addAll(s.listaErrores);       //  lexicos
            listaErrores.addAll(p.listaErrores);       //  sintacticos
            
            
            
            
             
            
            //UNA SOLA TABLA DE SIMBOLOS        suponiendo que todo llega sin problemas 
            for (Instruction ins : ast.getInstrucciones()) { 
                if(ins ==null){
                    continue;
                }
                if(ins instanceof Programa pp){
                    
                    Simbolo newSym = new 
                    Simbolo(new Tipo(tipoDato.VOID), "PROGRAMA", tabla, true);
                    newSym.setCat(categoria.CLASE);
                    newSym.setInstruction(ins);
                    tabla.addSsymbolPre(newSym);
                    
                    var algo =  pp.createSym(ast, tabla);
                }
                
              
            }      
             
            
//            Generate C3D             
//            valid si no se encuentra el programa Principan y el Main
                            String c3d_Main = "";
                            c3d_Main = "#include <iostream>\n" +
                                        "\n" +
                                        "using namespace std;\n" +
                                        "\n" +
                                        "int stack[100];\n" +
                                        "int heap[100];\n" +
                                        "int ptr = 0;\n" +
                                        "int h = 0;\n\n";
                            
                            String bodyMain ="";
                            
                            for (Instruction ins : ast.getInstrucciones()) {
                                if(ins ==null){
                                    continue;
                                }
                                if(ins instanceof  Programa cl){
                                    bodyMain += (String)cl.createC3D(ast, "");
                                    
                                }
                
                                
                            }
                            c3d_Main += ast.java.c3d_main("main", bodyMain);
                            ast.setConsola(c3d_Main);
            
            

            
            
           
 
            
            listaErrores.addAll(ast.getListaErrores());
            
//                        System.out.println(ast.getConsola());
                                            mensajeEjecucion = ast.getConsola();
            for (var i : listaErrores) {
                mensajeErrores += i + "\n";
                //                System.out.println(i);
            }
            
                                     ast.addTablaReport(tabla);
                                    this.tablaReport = ast.getTablaReport();
            
        } catch (Exception ex) {
            System.out.println("Algo salio mal");
            mensaExp +=ex;
            ex.printStackTrace(new PrintWriter(sw));
//                                ex.printStackTrace();
                    //            System.out.println(ex);
        }
        
        String errorMessage = sw.toString();
            
//        mensajeErrores+="\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n" +mensaExp+"\n"  + errorMessage;
//        mensajeEjecucion += "\n_________________________________________________\n" + mensajeErrores;
        mensajeErrores+="\n//n!!!!!!!!!!!!!!!!!!!! !!!!\n" +mensaExp+"\n"  + errorMessage;
        mensajeEjecucion += "//________________\n" + mensajeErrores;
        
//        if(this.ex!=null){
//            this.ex.printStackTrace();
//        }
            
//         return mensajeEjecucion;
         
         
    }   

    public String getMensajeEjecucion() {
        return mensajeEjecucion;
    }

    public LinkedList<TablaSimbolos> getTablaReport() {
        return tablaReport;
    }

 

    public LinkedList<Errores> getListaErrores() {
        return listaErrores;
    }
        
            
    
    
    
    
    
}