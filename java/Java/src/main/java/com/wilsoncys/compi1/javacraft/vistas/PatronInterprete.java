package com.wilsoncys.compi1.javacraft.vistas;


import com.wilsoncys.compi1.javacraft.model.analisis.parser;
import com.wilsoncys.compi1.javacraft.model.analisis.scanner;
import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.tablaSimbolos;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author yoyo
 */
public class PatronInterprete {

    /**
     * @param args the command line arguments   
     */
    public static void main(String[] args) {
        // TODO code application logic hereimprimir
        try {
//            String texto = "imprimir(  \" El resultado de las operaciones es:   \" + (1 + 9 -8 * 2 / 4 % 2 + (5 ** 2) ));";
            String texto = 
                    "println(\"hola mundo\naqui\nalla\");"; 
            
            
            scanner s = new scanner(new BufferedReader(new StringReader(texto)));
            parser p = new parser(s);
            var resultado = p.parse();
            var ast = new Arbol((LinkedList<Instruction>) resultado.value);
            var tabla = new tablaSimbolos();
            tabla.setNombre("GLOBAL");
            ast.setConsola("");
            LinkedList<Errores> lista = new LinkedList<>();
            lista.addAll(s.listaErrores);       //errores lexicos
            lista.addAll(p.listaErrores);       //errores sintacticos
            for (var a : ast.getInstrucciones()) {
                if (a == null) {
                    continue;
                }   
                var res = a.interpretar(ast, tabla);        //ejecuta el metodo interpretar de cada instruccion en la lista
                if (res instanceof Errores) {
                    lista.add((Errores) res);        //errores semanticos
                }   
            }
            
            System.out.println(ast.getConsola());
            
            for (var i : lista) {
                System.out.println(i);
            }
            
            
        } catch (Exception ex) {
            System.out.println("Algo salio mal");
            ex.printStackTrace();
            System.out.println(ex);
        }
    }
//    public static void algo(){
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
//    }

}
