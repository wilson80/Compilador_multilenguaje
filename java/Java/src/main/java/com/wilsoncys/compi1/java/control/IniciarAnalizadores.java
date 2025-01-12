/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.control;

import com.wilsoncys.compi1.java.Main;
import com.wilsoncys.compi1.java.model.analisis.*;
import com.wilsoncys.compi1.java.model.asbtracto.*;
import com.wilsoncys.compi1.java.model.excepciones.*;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.poo.*; 
import com.wilsoncys.compi1.java.model.programa.ClasesJava;
import com.wilsoncys.compi1.java.model.programa.Programa;
import com.wilsoncys.compi1.java.model.programa.Subprog_pascal;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.simbolo.*;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.LinkedList;
import javax.swing.JOptionPane;

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
            
            
            
            LinkedList<Instruction> todasLasIns = ast.getInstrucciones();
            if(todasLasIns == null){
                todasLasIns = new LinkedList<Instruction>();
            }
            
        
            
            
            //UNA SOLA TABLA DE SIMBOLOS        suponiendo que todo llega sin problemas 
            for (Instruction ins : todasLasIns) { 
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
                    if(algo instanceof  Errores err){
                        listaErrores.add(err);
                    }
                }
                
              
            } 
                                            //creacionde simbolos de pascal
            Subprog_pascal subprogramasP = new Subprog_pascal();
            subprogramasP.setTodasLasins(todasLasIns);
            subprogramasP.createSym(ast, tabla);
            
            
            
              
            
//            Generate C3D             
//            valid si no se encuentra el programa Principan y el Main
                String c3d_Main = "";
                c3d_Main = "#include <iostream>\n" +
                            "\n" +
                            "using namespace std;\n" +
                            "\n" +
                            "int stack[1000];\n" +
                            "int heap[1000];\n" +
                            "int ptr = 0;\n" +
                            "int h = 0;\n\n";
                ast.Print(c3d_Main);
                
                
                

                String bodyMain ="";
                for (Instruction ins : todasLasIns) {
                    if(ins ==null){
                        continue;
                    }
                    if(ins instanceof  Programa cl){            //  creacion del programa principal
                        
                        C3d c3d = ast.getC3d();
                        int iniVars = c3d.contador;
                        bodyMain += (String)cl.createC3D(ast, new AmbitoMetodo("", ""));
                        int finVars = c3d.contador;
                        String devVars = "";
                        for (int i = iniVars; i < finVars; i++) {
                            devVars += "int w" + i+  ";\n";
                        }
                        String temp = bodyMain;
                        bodyMain = devVars + "\n";
                        bodyMain += temp;
                    }


                }
                bodyMain= ast.java.c3d_main("main", bodyMain);
                ast.Print(bodyMain);
            
            

            
            
           
 
            
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