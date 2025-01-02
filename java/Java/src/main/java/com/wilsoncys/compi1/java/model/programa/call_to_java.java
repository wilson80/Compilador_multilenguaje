/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores; 
import com.wilsoncys.compi1.java.model.instrucciones.Statement;
import com.wilsoncys.compi1.java.model.poo.Functionss;
import com.wilsoncys.compi1.java.model.poo.Method;
import com.wilsoncys.compi1.java.model.programa.expresiones.AccessC;
import com.wilsoncys.compi1.java.model.programa.expresiones.NativoC;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class call_to_java extends Instruction{
    private String idRef;
    public String idMethod;
    private LinkedList<Instruction> parametersExp;

    public call_to_java(String idObject, String idMethod, LinkedList<Instruction> parametros, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.idMethod = idMethod;
        this.idRef = idObject;
        this.parametersExp = parametros;
    }
    
    
    
    @Override
    public Object interpretar(Arbol tree, TablaSimbolos tabla) {
        
        
        return null;
    }
    
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
    
    
    
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
         
        return null;
    }
        
    
    
    
//    	JAVA.call1.unvoid(x);

    
            @Override
    public Object createC3D(Arbol arbol, String anterior) {
               
        String armed = "";
        C3d c =  arbol.getC3d();
        
        String idSimm = "PROGRAMA"+idRef;
        String idObject  = "";

        Simbolo sym = arbol.getSym(idSimm);
        if(sym == null){
            return new Errores("SEMANTIC", "id no definido: " + idMethod, line, col);
        }
        
        idObject = ((InstanceJava)sym.getInstruction()).getIdClase();
        
        
 
                                        //buscando el tipo del objeto
        if(sym.getInstruction() instanceof InstanceJava met){
            arbol.getCurrentAmbit().set(1, met.tipo.getTypeString());
//                arbol.setSizeHeap(3);
        }        
        
        
        
                //set a la referencia (stack[0]) 
        armed+= c.c3d_acces(armed, sym.getDir());

        armed+=c.c3d_ptrTemp(arbol.attbPrincipal);

        armed+= c.c3d_asignVar("", 0);
        
        
        
        
        String id_Methodo = "java" + idObject + idMethod;
                                            //extrayendo los params
        for (Instruction exps : parametersExp) {
            if(exps instanceof NativoC n){               
//                armed+=n.createC3D(arbol, anterior);
                n.createC3D(arbol, anterior);
                id_Methodo += n.tipo.getTypeString();
                
                
            }else if(exps instanceof AccessC cs){
                    armed+=cs.createC3D(arbol, anterior);
                id_Methodo += cs.tipo.getTypeString();
            }else{
                armed += exps.createC3D(arbol, anterior);
                id_Methodo += exps.tipo.getTypeString();
            }
        }
                                                            //stack temp
        armed+=c.c3d_ptrTemp(arbol.attbPrincipal);
        
           
 
    //        arbol.setAmbito(ambito);
                                    //create al metodo/funcion
        Simbolo symMethod = arbol.getSym(id_Methodo);
        int posIni = 0;
        if(symMethod.getCat().equals(categoria.FUNCTION) ){
            ((Functionss)symMethod.getInstruction()).setIdClase(idObject);
            symMethod.getInstruction().createC3D(arbol, anterior);
            posIni = 3;   
        }else if(symMethod.getCat().equals(categoria.METHOD)){
           
        
            
            ((Method)symMethod.getInstruction()).setIdClase(idObject);
            symMethod.getInstruction().createC3D(arbol, anterior);
            posIni = 2;   
        }
         
                                            //PREPARED params en el stack
        for (Instruction exps : parametersExp) {
                armed += c.c3d_asignVar("", posIni);
                posIni++;
        }
         
        c.clearPtrTemp();   
                                            //ejecutar el metodo
        armed+=c.c3d_moveToStack(true, arbol.attbPrincipal);
        armed+= c.callJava(idObject+"_"+idMethod);
        armed+=c.c3d_moveToStack(false, arbol.attbPrincipal);
        
        //dejar el retorno
        if(symMethod.getCat().equals(categoria.FUNCTION) ){
          armed += c.c3d_ptrTemp(arbol.attbPrincipal);
          armed += c.c3d_accesTemp(armed, 1);
            
        }
        

        
        return armed;
    }
    
    
    
    
    
    public void setIdClase(String idClase) {
        this.idRef = idClase;
    }
    
 
    
}
