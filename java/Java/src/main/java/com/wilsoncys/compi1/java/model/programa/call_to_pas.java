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
public class call_to_pas extends Instruction{
    public String idMethod;
    private LinkedList<Instruction> parametersExp;

    public call_to_pas( String idMethod, LinkedList<Instruction> parametros, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.idMethod = idMethod;
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
        
    
     

    
            @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        String armed = "";
        armed+= "\n\n//invocacion a subP de pascal, id: " + idMethod + "\n";
        C3d_Java c =  arbol.getJava();
               
        String armedId = "pas"+idMethod.toLowerCase();
 
        
        armed+=c.c3d_ptrTemp(anterior.getVars(), arbol.attbPrincipal);

                                            //extrayendo los params
        for (Instruction exps : parametersExp) {
            if(exps instanceof Nativo n){               
//                armed+=n.createC3D(arbol, anterior);
                n.createC3D(arbol, anterior);
                armedId += n.tipo.getTypeString();
            }else if(exps instanceof AccessC cs){
                    armed+=cs.createC3D(arbol, anterior);
                armedId += cs.tipo.getTypeString();
            }else{
                armed += exps.createC3D(arbol, anterior);
                armedId += exps.tipo.getTypeString();
            }
        }
           
        
        Simbolo symMethod = arbol.getSym(armedId);
        if(symMethod == null){
            return (new Errores("SEMANTIC", "no se encontro el proccedure/function de pascal: " + idMethod, line, col));
        }
         
        int posIni = 0;
        if(symMethod.getCat().equals(categoria.FUNCTION) ){
            posIni = 3;   
        }else if(symMethod.getCat().equals(categoria.METHOD)){
            posIni = 2;   
        }
         
                                            //PREPARED params en el stack
        for (Instruction exps : parametersExp) {
//                armed += c.c3d_asignVar("", posIni);
                posIni++;
        }
        
        
        c.clearPtrTemp();   
                                            //crear la llamada
//        armed+=c.c3d_moveToStack(true, arbol.attbPrincipal);
//        armed+= c.callPas(symMethod.getAmbito_enID());
//        armed+=c.c3d_moveToStack(false, arbol.attbPrincipal);
        
        //dejar el retorno
        
        //identi tipo del retorno
        if(symMethod.getCat().equals(categoria.FUNCTION) ){
          armed += c.c3d_ptrTemp(anterior.getVars(), arbol.attbPrincipal);
//          armed += c.c3d_accesTemp(armed, 1);
            
        }
        return armed;
    }   
    
    
    
    
}
