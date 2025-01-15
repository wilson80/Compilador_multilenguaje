    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.instrucciones;

import com.wilsoncys.compi1.java.model.instrucciones.*;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.Input;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
 
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
public class VectorsStatementC extends Instruction{
    public String id;
    private boolean isConst;
    private Instruction dimExp1;
    private Instruction dimExp2;
    
    private LinkedList<LinkedList<Instruction>> valuesVect2D = null;


    public VectorsStatementC(boolean isConst, String identificador, Instruction exp1, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.id = identificador;
        this.dimExp1 = exp1;
        this.isConst = isConst;
    }
    
    public VectorsStatementC(boolean isConst, String identificador, 
                                    Instruction exp1, Instruction exp2,
                                    Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.id = identificador;
        this.isConst = isConst;
        this.dimExp1 = exp1;
        this.dimExp2 = exp2;
    }


    
 
    
    
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
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
        String idArmed = "PROGRAMA"+ this.id;
        
        Simbolo sym = arbol.getSym(idArmed);
        int dir  = sym.getDir();
        
        
 


//        if(whatConstruct == 1){
            
//            if(exp instanceof Input inp){
//                    inp.createC3D(arbol, anterior);
//                    armed+= c.c3d_Input();  
////                    armed+=c.c3d_asignVal("", dir);
//                    c.varsParams = new LinkedList<>();
//                
//            }else if(exp instanceof Nativo n){
//                    armed += n.createC3D(arbol, anterior); //create exp
////                                                            //asignacion
//                armed+=c.c3d_asignVal(this.getTyStr(), anterior.getVars(), dir);
//            }else{
//                armed+=this.exp.createC3D(arbol, anterior); //create exp
//                                                            //asignacion
//                armed+=c.c3d_asignVal(this.getTyStr(), anterior.getVars(), dir);
//            }
            
            
//        }
         
        
        
        
        return armed;
         
    }
}
