/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.poo;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.instrucciones.Statement;
import com.wilsoncys.compi1.javacraft.model.instrucciones.transferReturn;
import com.wilsoncys.compi1.javacraft.model.sC3D.C3d;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Simbolo;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.categoria;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jonwil
 */
public class Functionss extends Instruction{
    public String id;
    public LinkedList<HashMap> parameters;
    public LinkedList<Instruction> instrucciones;
    
    private List<String>  ambito;   //idclase/metodo/params
    private int cantParams = 0;
    private int cantSyms = 0;


    public Functionss(String identificator, LinkedList<HashMap> parameters, LinkedList<Instruction> instrucciones, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.id = identificator;
        this.parameters = parameters;
        this.instrucciones = instrucciones;
    }
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos table) {
        //verificar que halla una instruccion return que devuleva un dato del tipo de la funcion
        for (var instruct : this.instrucciones) {
            if (instruct == null) {
                    continue;
            }
            
//            if(instruct instanceof transferReturn retur){       //verificar si el return no tiene exp de retorno
//                if(retur.expression == null){
//                    return new Errores("SEMANTIC", "La funcion no especifica un valor de retorno", instruct.line, instruct.col);
//                }
//            }
            if(instruct instanceof transferReturn){
                return instruct;
            }
            
            var ressult = instruct.interpretar(arbol, table);
            if(ressult instanceof transferReturn){
                return ressult;
            }
            
//            if(instruct.tipo.getTipo()!=this.tipo.getTipo()){
//                return new Errores("SEMANTIC", "Valor de retorno con tipo Erroneo", instruct.line, instruct.col);
//            }
            
            if(ressult instanceof Errores error){
                arbol.addError(error);
            }
            
        }
        
        return null;
        
    }
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        //dir ref
        //retorno
        //dir dir ret
        //desde la clase se le hace set a la cantidad de params
        cantParams++;       //pte analisis

        for (Instruction ins : instrucciones) {
            if(ins instanceof Statement st){
                //ambito
                Simbolo sym = new Simbolo(tipo, st.id, tabla, true);
                sym.setCat(categoria.VARL);
                sym.setDir(cantParams);
                sym.setInstruction(ins);
                sym.setAmbito(ambito);
                tabla.addSsymbolPre(sym);
                cantParams++;
            }
        } 
        
        return null;
    }
        
            @Override
    public Object createC3D(Arbol arbol, String anterior) {
        String armed = "";
        C3d c = new C3d();
        String bodyMet = "";
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            bodyMet += (String)ins.createC3D(arbol, anterior);
        }
        armed+=c.c3d_metodo(id, bodyMet);
            
        arbol.Print(armed);
        
        return "";
    }

    public void setCantParams(int cantParams) {
        this.cantParams = cantParams;
    }

    public int getCantParams() {
        return cantParams;
    }

    public void setAmbito(List<String> ambito) {
        this.ambito = ambito;
    }

    public List<String> getAmbito() {
        return ambito;
    }
    
        
    
    
    
    
}
