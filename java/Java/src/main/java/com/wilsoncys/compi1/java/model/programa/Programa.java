/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa;


import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.poo.Classs;
import com.wilsoncys.compi1.java.model.programa.instrucciones.StatementC;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.LinkedList;
import java_cup.runtime.Symbol;
import javax.swing.JOptionPane;

/**
 *
 * @author jonwilson
 */
public class Programa extends Instruction{
    
    
    private LinkedList<Instruction> instrucciones;
    private Includes includes;
    private Instruction main;
    public int contadorStackP = 0;
    
    
    
    public Programa(Includes includes, LinkedList<Instruction> instrucciones,Instruction main, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.instrucciones = instrucciones;
        this.includes = includes;
        this.main = main;
    } 
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        setPos(arbol);
         
       
        for (String ids : includes.getClaseJava()) {
            if(ids.equals("\"JAVA.*\"")){
                includes.setJavaTodo(true);
            }
        }
        

           
         ClasesJava clasesJ = arbol.getClasesJava();
         if(includes.isJavaTodo()){
             for (Instruction clss : clasesJ.getListaClasesJava()) {
                 Simbolo sym = new Simbolo(tipo, "java"  + ((Classs)clss).id, "", true);
                 sym.armarAmbito("java");
                 sym.armarAmbito(((Classs)clss).id);
                 
                 sym.setInstruction(clss);
                 if(!tabla.addSsymbolPre(sym)){
                     JOptionPane.showMessageDialog(null, "noooo crearndo SYMMM: java"+ ((Classs)clss).id);
                 } 
                 
                 
                 
                 
                  var algo = clss.createSym(arbol, tabla);
                  if(algo instanceof  Errores){
                      return algo;
                  }
             }
             
             for (String idClase : includes.getClaseJava()) {
                 if(idClase.equals("\"JAVA.*\"") || idClase.equals("PASCAL")){
                      continue;
                  }
                  Classs claseEncontrada = clasesJ.getclase(idClase);
                  if(claseEncontrada==null){
                      return new Errores("SEMANTIC", "NO se ha encotrado el include: " + idClase, line, col);
                  } 
                   var algo = claseEncontrada.createSym(arbol, tabla);
                  if(algo instanceof  Errores){
                      return algo;
                  }
             }
            
             
             
         }else{
              for (String idClase : includes.getClaseJava()) {
                  if(idClase.equals("\"JAVA.*\"") || idClase.equals("PASCAL")){
                      continue;
                  }
                  Classs claseEncontrada = clasesJ.getclase(idClase);
                  if(claseEncontrada==null){
                      return new Errores("SEMANTIC", "NO se ha encotrado el include: " + idClase, line, col);
                  } 
                  claseEncontrada.createSym(arbol, tabla);
                   
                   
             }
             
         }
         
          

        //sttm
        int contador = 0;
        for (Instruction ins : instrucciones) { 
            if(ins==null){
                continue;
            }
            if(ins instanceof StatementC stt){
                Simbolo sym = new Simbolo(stt.tipo, stt.id, tabla, stt.isConst);
                 //ambito   
                sym.setCat(categoria.ATRIBUTO);
                sym.setDir(contador);
                sym.setInstruction(stt);
                sym.armarAmbito("PROGRAMA");
                sym.armarAmbito(stt.id);
                if(!(tabla.addSsymbolPre(sym))){
                    return new Errores("SEMANTIC", "El simbolo ya existe: " + stt.id , stt.line, stt.col);
                }
                
                contador++;
            } 
        }
        
        arbol.attbPrincipal+=contador;
        
        
        for (Instruction ins : instrucciones) {
             if(ins==null){
                continue;
            }
            if(ins instanceof ReferenceC ref){
                var algo = ref.createSym(arbol, tabla);
                if(algo instanceof Errores){
                    return algo;
                }
            }
        }
        
        
         
         
        
        return null;
    }

    
    
    
       @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
       setPos(arbol);
        String ArmedPrincipal = "";
        String ArmedJavas = "";

         ClasesJava clasesJ = arbol.getClasesJava();
//         if(includes.isJavaTodo()){
         if(includes.isJavaTodo()){
                //             for (Instruction clss : clasesJ.getListaClasesJava()) {
                //                 if(clss instanceof Classs cl){
                //                  ArmedJavas+=  "\n\n\n"+ cl.createC3D(arbol, anterior);
                //                 }
                //             }
             
             
//             for (String idClase : includes.getClaseJava()) {
//                 if(idClase.equals("\"JAVA.*\"") || idClase.equals("PASCAL")){
//                      continue;
//                  }
//                  Classs claseEncontrada = clasesJ.getclase(idClase);
//                  if(claseEncontrada==null){
//                      return new Errores("SEMANTIC", "NO se ha encotrado el include: " + idClase, line, col);
//                  } 
//                   var algo = claseEncontrada.createSym(arbol, tabla);
//                  if(algo instanceof  Errores){
//                      return algo;
//                  }
//             }
            
             arbol.Print(ArmedJavas);
             
         }else{
//              for (String idClase : includes.getClaseJava()) {
//                  if(idClase.equals("\"JAVA.*\"") || idClase.equals("PASCAL")){
//                      continue;
//                  }
//                  Classs claseEncontrada = clasesJ.getclase(idClase);
//                  if(claseEncontrada==null){
//                      return new Errores("SEMANTIC", "NO se ha encotrado el include: " + idClase, line, col);
//                  } 
//                  claseEncontrada.createSym(arbol, tabla);
//                   
//                   
//             }
             
         }
        
        
          
        int iniVars = arbol.getC3d().contador;
        
        for (Instruction ins : instrucciones) {
               if(ins instanceof StatementC stt){
                   var result = stt.createC3D(arbol, anterior);
                   if(result instanceof  Errores ){
                       return result;
                   }else{
                       ArmedPrincipal+= result;
                   }
               }
        }
       for (Instruction ins : instrucciones) {
           if(ins instanceof ReferenceC ref){
               var result = ref.createC3D(arbol, anterior);
                   if(result instanceof  Errores ){
                       return result;
                   }else{
                       ArmedPrincipal+= result;
                   }
           } 
       }
        
                    //JAVA
        for (Instruction clss : clasesJ.getListaClasesJava()) {
                if(clss instanceof Classs cl){
                    cl.createC3D(arbol, anterior);
                }
        }


               //instrucciones del programa principal
       var resutl =this.main.createC3D(arbol, anterior);  
       if(resutl instanceof Errores){
           return resutl;
       }else{
           ArmedPrincipal += resutl; 
       }        
       

       String devVars = "";
        int finVars = arbol.getC3d().contador;
        for (int i = iniVars; i < finVars; i++) {
            devVars += "int w" + i+  ";\n";
        }
            
        String temp = ArmedPrincipal;
        ArmedPrincipal = devVars + "\n";
        ArmedPrincipal += temp;
       
       
        return ArmedPrincipal;
    }

    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
}
