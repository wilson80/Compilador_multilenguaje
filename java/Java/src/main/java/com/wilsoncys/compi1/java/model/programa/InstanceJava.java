/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores; 
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.poo.Classs;
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
        setPos(arbol);
        String armed = "";
        C3d_Java c =  arbol.getJava();
        
        int posIni = 2;
        String idSimm = "PROGRAMA"+id;

        Simbolo sym = arbol.getSym(idSimm);
        if(sym == null){
            return new Errores("SEMANTIC", "id no definido: " + id, line, col);
        }
        

        String id_constructor = "java" + idClase + idClase;
                                            //extrayendo los params
         LinkedList<String> tipos = new LinkedList<>();
                                   
        for (Instruction exps : parametersExp) {
                armed+= exps.createC3D(arbol, anterior);
                tipos.add(exps.tipo.getTypeString());
        }
        for (String typs : tipos) {
            id_constructor += typs;
        }
        
        Simbolo constSim = arbol.getSym(id_constructor);
        if(constSim == null){
            arbol.addError(new Errores("semantic", 
                    "no se encontro el constructor o los parametros son incorrectos", line, col));
        }
        
//        arbol.getClasesJava().getclase(idClase).setId_constructor(id_constructor);
//        this.tipo.setTipo(tipoDato.OBJECT);
//        this.tipo.setIdObjeto(idClase);
        
        
        
        
                                                            //stack temp
        armed+=c.c3d_ptrTemp(anterior.getVars(), arbol.attbPrincipal + "");

          
                                            //PREPARED params en el stack
         
        int contador = 0; 
                                            //PREPARED params en el stack
        for (Instruction exps : parametersExp) {
                armed += c.c3d_asignVar(tipos.get(contador), c.getPtrTemp(), anterior.getVars(), posIni);
                posIni++; contador++;
        }
        
        
        
        
        c.clearPtrTemp();   
        
                                            //ejecutar el metodo
        armed+=c.c3d_moveToStack(true, arbol.attbPrincipal + "");
        armed+= c.callJava(id_constructor);
        armed+=c.c3d_moveToStack(false, arbol.attbPrincipal + "");
         
        c.clearVarParams();

        
//                    mover el ptr temporal
        armed+=c.c3d_ptrTemp(anterior.getVars(), arbol.attbPrincipal+"");

            //obtener valor de la referencia
        armed+=c.c3d_accesTemp("int", anterior.getVars(), 0);

        // realizar la asignacion 
        armed+=c.c3d_asignVal("int", anterior.getVars(), sym.getDir());
            
        
        return armed;
    }
    

    
    
    
    
    public void setIdClase(String idClase) {
        this.idClase = idClase;
    }

    public String getIdClase() {
        return idClase;
    }
    
 
    
}
