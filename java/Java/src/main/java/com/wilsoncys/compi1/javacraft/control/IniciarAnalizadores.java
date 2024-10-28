/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.control;

//import com.wilsoncys.compi1.javacraft.analizadores.CupJavaCraft;
//import com.wilsoncys.compi1.javacraft.analizadores.LexerJavaCraft;
import com.wilsoncys.compi1.javacraft.Main;
import com.wilsoncys.compi1.javacraft.model.analisis.parser;
import com.wilsoncys.compi1.javacraft.model.analisis.scanner;
import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.poo.Classs; 
import com.wilsoncys.compi1.javacraft.model.poo.Mainn;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Simbolo;
import com.wilsoncys.compi1.javacraft.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.categoria;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;

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
                if(ins instanceof Classs cl){
                    Simbolo newSym = new 
                    Simbolo(new Tipo(tipoDato.VOID), cl.getId(), tabla, true);
                    newSym.setCat(categoria.CLASE);
                    newSym.setInstruction(ins);
                    tabla.addSsymbolPre(newSym);
                    
                    
                    var algo =  cl.createSym(ast, tabla);
                    if(algo instanceof Errores err){
                        listaErrores.add(err);
                    }
                    
                }
                
            }
            
            //Generate C3D
            Classs mainnC = ast.getClassMain();
            Mainn mainnMet = ast.getMethodMain();
                mainnC.setMain(true);
            String c3d_Main = "";
            String bodyMain = (String)mainnC.createC3D(ast, "") ;
            bodyMain += (String)mainnMet.createC3D(ast, "");
            
            c3d_Main = ast.c3d.c3d_metodo(mainnC.getId(), bodyMain);
            
            System.out.println("c3d:\n" + c3d_Main);
            //hacer el statement
            
            System.out.println("/n/n>>>\n" + ast.getConsola());
            
            
            
            
//            //SEMANTIC 
//            for (Instruction ins : ast.getInstrucciones()) {
//                if(ins instanceof Classs cl){
//                    cl.interpretar(ast, tabla);
//                }
//            }
             
//            Classs mainClass = null;
//            for (Instruction ins : ast.getInstrucciones()) {   
//                                                        //buscando el metodomain
//                if(ins instanceof Classs cl){
//                    for (Instruction insCl : cl.instrucciones) {
//                        if(insCl instanceof Mainn ma){
//                            cl.setMain(ma);
//                            mainClass = cl;
//                        }
//                        
//                    }
//                }
//                
//            }
       
//            TablaSimbolos tablaClass = new TablaSimbolos();
//            var algo =  mainClass.interpretar(ast, tablaClass);
//            if(algo instanceof Errores err){
//                listaErrores.add(err);
//            }
            
            
             









            
            
            //GENERATE AST
//            String cadena = "digraph ast{\n";
//            cadena += "nINICIO[label=\"INICIO\"];\n";
//            cadena += "nINSTRUCCIONES[label=\"INSTRUCCIONES\"];\n";
//            cadena += "nINICIO -> nINSTRUCCIONES;\n";
//
//            for (var i : ast.getInstrucciones()) {
//                if (i == null) {
//                    continue;
//                }
//                if(i instanceof Classs cl){
//                    String nodoAux = "n" + ast.getCount();
//                    cadena += nodoAux + "[label=\"INSTRUCCION\"];\n";
//                    cadena += "nINSTRUCCIONES -> " + nodoAux + ";\n";
//                    cadena += cl.generarast(ast, nodoAux);
//                    
//                }
//            }
//
//            cadena += "\n}";
//            System.out.println(cadena);
//            //AST
//            
            
            
            
                        System.out.println(ast.getConsola());
                                            mensajeEjecucion = ast.getConsola();
            for (var i : listaErrores) {
                mensajeErrores += i + "\n";
                //                System.out.println(i);
            }
            
            
                        //            this.tablaReport = arbolAst.getTablaReport();
            
        } catch (Exception ex) {
            System.out.println("Algo salio mal");
            mensaExp +=ex;
            ex.printStackTrace(new PrintWriter(sw));
//                                ex.printStackTrace();
                    //            System.out.println(ex);
        }
        
        String errorMessage = sw.toString();
            
        mensajeErrores+="\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n" +mensaExp+"\n"  + errorMessage;
        mensajeEjecucion += "\n_________________________________________________\n" + mensajeErrores;
        
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

    
        
        
        
        
        
        
        
        
        
        
        
        
        
//        StringReader reader = new StringReader(texto);
//        LexerJavaCraft lexer = new LexerJavaCraft(reader);
//        
//        
//        CupJavaCraft cup = new CupJavaCraft(lexer);
//        
//        try {
//            var algo = cup.parse();
//            
//        } catch (Exception e) {
//              
//            System.out.println("Try Catch en CupJavaCraft");
//            e.printStackTrace();
//        }
        
        
//        consulta.imprimirconsulta();
//        instruccionCorrecta = consulta.isInstruccionCorrecta();
        
//        char algo = lexer.yycharat(4);
//        System.out.println("yycharart: " + algo);

    public LinkedList<Errores> getListaErrores() {
        return listaErrores;
    }
        
            
    
    
    
    
    
}