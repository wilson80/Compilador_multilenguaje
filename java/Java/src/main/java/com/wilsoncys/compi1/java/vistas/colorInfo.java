/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.vistas;

/**
 *
 * @author jonwilson
 */
public class colorInfo {
    private TipoT type;
    private long posI;
    private int size;

    public colorInfo(TipoT type, long posI, int size) {
        this.type = type;
        this.posI = posI;
        this.size = size;
    }
//    public colorInfo() {
//    }

    public TipoT getType() {
        return type;
    }

    public void setType(TipoT type) {
        this.type = type;
    }

    public long getPosI() {
        return posI;
    }

    public void setPosI(long posI) {
        this.posI = posI;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    

    
    
    
}
