/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores; 
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.instrucciones.Statement;
import com.wilsoncys.compi1.java.model.poo.Functionss;
import com.wilsoncys.compi1.java.model.poo.Method;
import com.wilsoncys.compi1.java.model.programa.expresiones.AccessC;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
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
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
               
        String armed = "";
        C3d_Java c =  arbol.getJava();
        
        String idSimm = "PROGRAMA"+idRef;
        String idObject  = "";

        Simbolo sym = arbol.getSym(idSimm);
        if(sym == null){
            arbol.addError(new Errores("SEMANTIC", "id no definido: " + idRef, line, col));
        }
        
        idObject = ((InstanceJava)sym.getInstruction()).getIdClase();
        
        
 
                                        //buscando el tipo del objeto
//        if(sym.getInstruction() instanceof InstanceJava met){
////            arbol.getCurrentAmbit().set(1, met.tipo.getTypeString());
//        }        
        
        
        
                //set a la referencia (stack[0]) 
//        armed+= c.c3d_accesParam(armed, sym.getDir());
        armed+= c.c3d_accesParam("int", anterior.getVars(), sym.getDir());

        armed+=c.c3d_ptrTemp(anterior.getVars(),arbol.attbPrincipal);

        armed+= c.c3d_asignTemp("int", anterior.getVars(), 0);
            
        
        
        
        String id_Methodo = "java" + idObject + idMethod;
        LinkedList<String> tipos = new LinkedList<>();
        
                                            //extrayendo los params
        for (Instruction exps : parametersExp) {
                armed += exps.createC3D(arbol, anterior);
                  tipos.add(exps.tipo.getTypeString());
            
        }       
        for (String typs : tipos) {
            id_Methodo += typs;
        }
        
                                                            //stack temp
        armed+=c.c3d_ptrTemp(anterior.getVars(), arbol.attbPrincipal);
  
                                    //create al metodo/funcion
        Simbolo symMethod = arbol.getSym(id_Methodo);
        if(symMethod == null){
            arbol.addError(new Errores("semantic", "el metodo del objeto no existe: " + this.idMethod, line, col));
        }
        
        int posIni = 0;
        if(symMethod.getCat().equals(categoria.FUNCTION) ){
            posIni = 3;   
        }else if(symMethod.getCat().equals(categoria.METHOD)){
            posIni = 2;   
        }
        int contador = 0; 
                                            //PREPARED params en el stack
        for (Instruction exps : parametersExp) {
                armed += c.c3d_asignVar(tipos.get(contador), c.getPtrTemp(), anterior.getVars(), posIni);
                posIni++; contador++;
        }
         
        c.clearPtrTemp();   
                                            //ejecutar el metodo
        armed+=c.c3d_moveToStack(true, arbol.attbPrincipal + "");
        armed+= c.callJava(id_Methodo);
        armed+=c.c3d_moveToStack(false, arbol.attbPrincipal + "");
        
        //dejar el retorno
        if(symMethod.getCat().equals(categoria.FUNCTION) ){
          armed += c.c3d_ptrTemp(anterior.getVars(), arbol.attbPrincipal);
          //tipo del retorno
          String tipoRe = "";
          if(sym.getTipo().getTipo() == tipoDato.OBJECT){
              tipoRe = "int";
          }else{
              tipoRe = sym.getInstruction().getTyStr();
          }
          armed += c.c3d_accesTemp(tipoRe, anterior.getVars(), 1);
            
        }
        

        
        return armed;
    }
    
    
    
    
    
    public void setIdClase(String idClase) {
        this.idRef = idClase;
    }
    
 
    
}
