/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa;

import com.wilsoncys.compi1.java.model.poo.*;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.instrucciones.Statement;
import com.wilsoncys.compi1.java.model.instrucciones.transferReturn;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jonwil
 */
public class MainnC extends Instruction{
//    public String id;
//    private List<String>  ambito;   //idclase/metodo/params
    public LinkedList<Instruction> instrucciones;
    private int cantParams = 0;

    
    public MainnC(String id, LinkedList<Instruction> instrucciones, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
//        this.id = id;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos table) {
        for (var instruct : this.instrucciones) {
             if (instruct == null) {
                    continue;
            }
            
//            if(instruct instanceof transferReturn){  //puede venir una instruccion dentro del metodo de tipo return
//                return null; 
//            }
//            if(instruct instanceof transferReturn){
//                return instruct;
//            }
            if(instruct instanceof transferReturn){
                return instruct;
            }
            // El problema de eso ^^ es que no la expresion podria retornar // Verify
//            algo que no es y el error tiene que ser devuelto por la llamada y no por la asignacion
            var ressult = instruct.interpretar(arbol, table);
            if(ressult instanceof transferReturn){
                return ressult;
            }
            if(ressult instanceof transferReturn){
                return ressult;
            }
            
            
            if(ressult instanceof Errores error){
                arbol.addError(error);
            }
            
//            if(ressult instanceof transferReturn){
//                return null; 
//            }
            
        }
        
        return null;
    }
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
    
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        //dentro del main c no hay vars locales\
        
        return "";
    }
        
    
            @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        List<String> ambito = new ArrayList<>();
        ambito.add("PROGRAMA");
        
        String idRetorno = "labelReturn" + arbol.getC3d().contador;
        arbol.getC3d().contador++;
        
        
        setPos(arbol);
        String armed = "";
        C3d c = arbol.getC3d();
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            
            var result =ins.createC3D(arbol, new AmbitoMetodo(arbol.attbPrincipal + "", idRetorno, ambito));
            if(result instanceof Errores){
                return result;
            }else{
                armed += result;
            }
            c.clearVarParams();
        }
        
        armed += idRetorno + ":\n";
        armed += "\ncout<<endl;";
        
        
        
        return armed;
    }
    
    
    
    
    
    
    
    
    
    
    
    public void setCantParams(int cantParams) {
        this.cantParams = cantParams;
    }

    public int getCantParams() {
        return cantParams;
    }

//    public List<String> getAmbito() {
//        return ambito;
//    }
//
//    public void setAmbito(List<String> ambito) {
//        this.ambito = ambito;
//    }
     
    
}
