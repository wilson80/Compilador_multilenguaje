/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.simbolo;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yoyo
 */
public class Simbolo {
    
    private int indI;    
    private int indF;    
     
    private boolean isArr = false;

    
    
    
    
    
    private Tipo tipo;
    private String id;
    private Object valor;
    private boolean isConst;
    private String tipoStruct = "";
    private int linea = 0;
    private int colu = 0;
    
    
    
    
    
    private boolean isDeclared = false;
    private visib visib;
    private int numParam = 0;
    private int dims = 0;
    private int direccion = 0;
    private categoria cat;
    private List<String>  ambito;   //idclase/metodo/params
    private Instruction instruction;
    
    

//    public Simbolo(Tipo tipo, String id) {
//        this.tipo = tipo;
//        this.id = id;
//    }

    public Simbolo(Tipo tipo, String id, Object valor, boolean isConst) {
        this.tipo = tipo;
        this.id = id;
        this.valor = valor;
        this.isConst = isConst;
        this.ambito = new ArrayList<>();
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public boolean isConst() {
        return isConst;
    }

    public void setTipoStruct(String tipoStruct) {
        this.tipoStruct = tipoStruct;
    }

    public String getTipoStruct() {
        return tipoStruct;
    }

    public int getLinea() {
        return linea;
    }

    public int getColu() {
        return colu;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public void setColu(int colu) {
        this.colu = colu;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    
    
    @Override
    public String toString() {
        return "Simbolo{" + "tipo=" + tipo.getTipo().name() + ", id=" + id + ", valor=" + valor.toString() + ", isConst=" + isConst + ", tipoStruct=" + tipoStruct + ", linea=" + linea + ", colu=" + colu + '}';
    }
    
    public void armarAmbito(String amb){
        this.ambito.add(amb);
        
    }

    public void setCat(categoria cat) {
        this.cat = cat;
    }

   
    public void setDir(int direccion) {
        this.direccion = direccion;
    }

    public List<String> getAmbito() {
        return ambito;
    }
    public String getAmbito_enID() {
        String amb = "";
        for (String string : ambito) {
            amb+= string;
        }
        return amb;
    }

    public void setAmbito(List<String> ambito) {
        for (String id : ambito) {
            this.ambito.add(id);
        }
    }

    public int getDir() {
        return direccion;
    }

    public categoria getCat() {
        return cat;
    }
    
    
    
    
    
    
    
    
    
    
    public int getIndI() {
        return indI;
    }

    public int getIndF() {
        return indF;
    }

    public void setIndF(int indF) {
        this.indF = indF;
    }

    public void setIndI(int indI) {
        this.indI = indI;
    }

    public void setIsArr(boolean isArr) {
        this.isArr = isArr;
    }

      
    
            
    
}
