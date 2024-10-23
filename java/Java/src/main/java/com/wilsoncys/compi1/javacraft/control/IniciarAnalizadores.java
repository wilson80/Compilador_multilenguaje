/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.control;

//import com.wilsoncys.compi1.javacraft.analizadores.CupJavaCraft;
//import com.wilsoncys.compi1.javacraft.analizadores.LexerJavaCraft;
import com.wilsoncys.compi1.javacraft.model.analisis.parser;
import com.wilsoncys.compi1.javacraft.model.analisis.scanner;
import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.instrucciones.Assignmentt;
import com.wilsoncys.compi1.javacraft.model.instrucciones.DynamicLists;
import com.wilsoncys.compi1.javacraft.model.instrucciones.Functionss;
import com.wilsoncys.compi1.javacraft.model.instrucciones.Method;
import com.wilsoncys.compi1.javacraft.model.instrucciones.Start_Main;
import com.wilsoncys.compi1.javacraft.model.instrucciones.Statement;
import com.wilsoncys.compi1.javacraft.model.instrucciones.Structs;
import com.wilsoncys.compi1.javacraft.model.instrucciones.VectorsStatement;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.tablaSimbolos;

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
    private LinkedList<tablaSimbolos> tablaReport = new LinkedList<>();          //par la tabla de simbolos

                

    public IniciarAnalizadores(String texto) {
        this.texto = texto;
    }

    
 
    
    public void Interpretar(){
        try {
            scanner s = new scanner(new BufferedReader(new StringReader(texto)));
            parser p = new parser(s);
            var resultado = p.parse();
            if(resultado.value instanceof  LinkedList){ 
                System.out.println("Siiiiii es lista");
            }else{
                System.out.println("Noooooo es lista");
                
            }
//            var arbolAst = new Arbol((LinkedList<Instruction>) resultado.value);
//            var tabla = new tablaSimbolos();
//            tabla.setNombre("GLOBAL");
//            arbolAst.setConsola("");
//            arbolAst.setTablaGlobal(tabla);
//            listaErrores = new LinkedList<>();
            listaErrores.addAll(s.listaErrores);       //errores lexicos
            listaErrores.addAll(p.listaErrores);       //errores sintacticos
            
            
            
            //identificate and save the funciones, metodos and struct in the tree
//                                for (var instruct : arbolAst.getInstrucciones()) {
//                                                                        if (instruct == null) {
//                                                                            continue;
//                                                                        }   
//                                                                        if(instruct instanceof Method){
//                                                                            arbolAst.addFunctions(instruct);
//                                                                        }
//                                                                        if(instruct instanceof Functionss || instruct instanceof Structs ){
//                                                                            arbolAst.addFunctions(instruct);
//                                                                        }
//
//                    //                var res = instruct.interpretar(arbolAst, tabla);        //ejecuta el metodo interpretar de cada instruccion en la lista
//                    //                if (res instanceof Errores errors) {
//                    //                    listaErrores.add(errors);        //errores semanticos
//                    //                }   
//                                }
        ////            identificar instrucciones de tipo Asignacion y declaracion globales
        //                        for (var instruct : arbolAst.getInstrucciones()) {
        //                            if(instruct == null){
        //                                continue;
        //                            }
        //                            if((instruct instanceof Statement )|| (instruct instanceof Assignmentt)){
        //                                var ress = instruct.interpretar(arbolAst, tabla);
        //                                if(ress instanceof Errores errors){
        //                                    listaErrores.add(errors);       //errores semanticos
        //                                }
        //                            }
        //                            if((instruct instanceof VectorsStatement )|| (instruct instanceof DynamicLists)){
        //                                var ress = instruct.interpretar(arbolAst, tabla);
        //                                if(ress instanceof Errores errors){
        //                                    listaErrores.add(errors);   //errores semanticos
        //                                }
        //                            }
        //
        //                        }
//                        System.out.println("Despues de guardar las funciones y interpretaas asignaciones");
//                        Start_Main starrr = null;
//                        for (var ins : arbolAst.getInstrucciones()) {
//                            if(ins == null){
//                                continue;
//                            }
//                            if(ins instanceof Start_Main start){    //            identificar la instruccion star_whit
//                                starrr = start;
//                            }
//                        }
//            
//                                if(starrr!=null){                               //validacion si no se encuentra la sentencia start
//                                    var main = starrr.interpretar(arbolAst, tabla);     //interpretar la instruccion Start
//                                    if(main instanceof Errores errors){
//                                        listaErrores.add(errors);
//                                    }
//                                }else{
//                                    Errores err = new Errores("SEMANTIC", "No se encontro la sentencia que indica cual "
//                                            + "es el metodo que inicia el programa", 0, 0);
//                                    listaErrores.add(err);
//                                    
//                                }
//                                                                                //agregar  los errores dentro de los metodos 
//                                listaErrores.addAll(arbolAst.getListaErrores());
        
            
//            //GENERATE AST
//            String cadena = "digraph ast{\n";
//            cadena += "nINICIO[label=\"INICIO\"];\n";
//            cadena += "nINSTRUCCIONES[label=\"INSTRUCCIONES\"];\n";
//            cadena += "nINICIO -> nINSTRUCCIONES;\n";
//
//            for (var i : arbolAst.getInstrucciones()) {
//                if (i == null) {
//                    continue;
//                }
//                String nodoAux = "n" + arbolAst.getCount();
//                cadena += nodoAux + "[label=\"INSTRUCCION\"];\n";
//                cadena += "nINSTRUCCIONES -> " + nodoAux + ";\n";
//                cadena += i.generarast(arbolAst, nodoAux);
//            }
//
//            cadena += "\n}";
//            System.out.println(cadena);
//            //AST
//            
            
            
            
            //            System.out.println(ast.getConsola());
//                                            mensajeEjecucion = arbolAst.getConsola();
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

    public LinkedList<tablaSimbolos> getTablaReport() {
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