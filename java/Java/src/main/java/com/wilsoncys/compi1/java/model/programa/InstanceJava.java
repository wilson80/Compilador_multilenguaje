/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores; 
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.poo.Classs;
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


//INSTANCIA DE UNA CLASE
public class InstanceJava extends Instruction{
    public String id;
    private String idClase;
    private LinkedList<Instruction> parametersExp;

    public InstanceJava(String identificator, LinkedList<Instruction> parametros, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = identificator;
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
        C3d c =  arbol.getC3d();
        
        int posIni = 2;
        String idSimm = "PROGRAMA"+id;

        Simbolo sym = arbol.getSym(idSimm);
        if(sym == null){
            return new Errores("SEMANTIC", "id no definido: " + id, line, col);
        }
        

        String id_constructor = "java" + idClase + idClase;
                                            //extrayendo los params
        for (Instruction exps : parametersExp) {
            if(exps instanceof NativoC n){               
                n.createC3D(arbol, anterior);
                id_constructor += n.tipo.getTypeString();
                
            }else if(exps instanceof AccessC cs){
                    armed+=cs.createC3D(arbol, anterior);
                id_constructor += cs.tipo.getTypeString();
            }else{
                armed += exps.createC3D(arbol, anterior);
                id_constructor += exps.tipo.getTypeString();
            }
        }

        
        arbol.getClasesJava().getclase(idClase).setId_constructor(id_constructor);
        this.tipo.setTipo(tipoDato.OBJECT);
        this.tipo.setIdObjeto(idClase);
        
        
        
        
                                                            //stack temp
        armed+=c.c3d_ptrTemp(arbol.attbPrincipal);
        
          
                                            //PREPARED params en el stack
        for (Instruction exps : parametersExp) {
                armed += c.c3d_asignVar("", posIni);
                posIni++;
        }
        
        
        
        c.clearPtrTemp();   
        
                                            //ejecutar el metodo
        armed+=c.c3d_moveToStack(true, arbol.attbPrincipal);
        armed+= c.callJava(idClase + "_" + idClase);
        armed+=c.c3d_moveToStack(false, arbol.attbPrincipal);
         
        
                            //create a la Clase
        c.clearVarParams();
//        arbol.attbClassJava = (((Classs)arbol.getSym("java" + this.idClase).getInstruction()).getCantAttb());
        arbol.getSym("java" + this.idClase).getInstruction().createC3D(arbol, anterior);
        c.clearVarParams();
        
        
        
//        if(otrosim == null){
//                 JOptionPane.showMessageDialog(null, "nulll");
//            
//        }


//                    mover el ptr temporal
        armed+=c.c3d_ptrTemp(arbol.attbPrincipal);
            //obtener valor de la referencia
        armed+=c.c3d_accesTemp(id, 0);

        
        // realizar la asignacion 
        armed+=c.c3d_asignVal(id, sym.getDir());
            
        return armed;
    }
    

    
    
    
    
    public void setIdClase(String idClase) {
        this.idClase = idClase;
    }

    public String getIdClase() {
        return idClase;
    }
    
 
    
}
