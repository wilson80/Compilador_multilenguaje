/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.simbolo;

/**
 *
 * @author yoyo
 */
public class Simbolo {
    private Tipo tipo;
    private String id;
    private Object valor;
    private boolean isConst;
    private String tipoStruct = "";
    private int linea = 0;
    private int colu = 0;

//    public Simbolo(Tipo tipo, String id) {
//        this.tipo = tipo;
//        this.id = id;
//    }

    public Simbolo(Tipo tipo, String id, Object valor, boolean isConst) {
        this.tipo = tipo;
        this.id = id;
        this.valor = valor;
        this.isConst = isConst;
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

    
    
    @Override
    public String toString() {
        return "Simbolo{" + "tipo=" + tipo.getTipo().name() + ", id=" + id + ", valor=" + valor.toString() + ", isConst=" + isConst + ", tipoStruct=" + tipoStruct + ", linea=" + linea + ", colu=" + colu + '}';
    }
    
    

    
    
    
}
