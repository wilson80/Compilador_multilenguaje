/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.poo;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.Statement;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.instrucciones.transferReturn;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jonwil
 */
public class Functionss extends Instruction{
    public String id;
    public String idClase = "";

    public LinkedList<HashMap> parameters;
    public LinkedList<Instruction> instrucciones;
    
    private List<String>  ambito;   //idclase/metodo/params
    private int cantParams = 0;
    private int cantAttb = 0;

    private int cantSyms = 0;
    private boolean isCreate = false;

    private AmbitoMetodo ambitoContent;    


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
 
        for (Instruction ins : instrucciones) {
            if(ins instanceof Statement st){
                //ambito
                Simbolo sym = new Simbolo(st.tipo, st.id, tabla, true);
                sym.setCat(categoria.VARL);
                sym.setDir(cantParams);
                sym.setInstruction(ins);
                sym.setAmbito(ambito);
                sym.armarAmbito(st.id);
                tabla.addSsymbolPre(sym);
                cantParams++;
            }
        } 
        
        return null;
    }
        
    
    
    
            @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        setPos(arbol);
        String armed = "";
        C3d_Java c = arbol.getJava();
        
        
        String idRetorno ="retorno" + c.contador;
        c.contador++;
                                    //label de retorno
        arbol.setLabelRetorno(idRetorno);
        
        
        List<String> ambitoAntList = new ArrayList<>(arbol.getCurrentAmbit());
        this.ambitoContent = new AmbitoMetodo(this.cantParams + "", idRetorno, this.ambito);
        arbol.setCurrentAmbit(this.ambito);
        

        String bodyMet = "";
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            
            bodyMet += (String)ins.createC3D(arbol, this.ambitoContent);
            arbol.setCurrentAmbit(this.getAmbito());

        }
        
        arbol.setCurrentAmbit(ambitoAntList);
        
        bodyMet += idRetorno + ":\n";
//        bodyMet += arbol.getLabelRetorno() + ":\n";
        bodyMet += "    cout<< \"\";";
        
        
         
//                            creando la declaracion de vars del ambito
        armed += this.ambitoContent.getDeclar() + "\n";
        armed += bodyMet;
        
        armed = c.c3d_metodo(this.getAmbito_asID(), armed);
        arbol.addPrototipo(getAmbito_asID());
        
        
        if(!isCreate){
            arbol.Print(armed);       
            isCreate = true;
        }
//        c.clearCount();
        
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

    public String getIdClase() {
        return idClase;
    }

    public void setIdClase(String idClase) {
        this.idClase = idClase;
    }

    public int getCantAttb() {
        return cantAttb;
    }

    public void setCantAttb(int cantAttb) {
        this.cantAttb = cantAttb;
    }
    
        
    public String getAmbito_asID(){
        String ambi = "";
        for (String st : this.ambito) {
            ambi +=st;
        }
        return ambi; 
        
    }
    
    
    
}
