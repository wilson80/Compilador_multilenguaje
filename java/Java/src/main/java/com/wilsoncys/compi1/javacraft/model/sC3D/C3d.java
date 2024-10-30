/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.sC3D;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.List;

/**
 *
 * @author jonwilson
 */
public class C3d {
    int contador = 0;
    String var1 = "";
    String var2 = "";
    private String ptrTemp = "";
    public LinkedList<String> varsParams;
    
 
    int DIR_RF = 0;
    int RETURN = 0;
    int RETURNPoo = 1;
    int DIR_R = 2;
    String STACK = "stack";
    String saltoLinea = "\n";
    String ASSIG = " = ";
    String PTR = "ptr";
    String H = "h";
        
    String OPRT = " + ";
    String MAS = " + ";
    String MENOS = " - ";
    String SEMIC = ";";
    String PAR_L = "(";
    String PAR_R = ")";
    String KEY_L = "{";
    String KEY_R = "}";

    public C3d() {
        varsParams = new LinkedList<>();
    }
    
    
    
    
    public void control(){
        
    }
    
 
    public String c3d_operation(String val, int dir){
        String armed = c3d_newVar() + ASSIG + varsParams.get(0)+OPRT+varsParams.get(1) + SEMIC+saltoLinea;
        varsParams = new LinkedList<>();
        varsParams.add("w"+(contador-1));  //guarda el id de la var q contiene el resultado
        return  armed;
    }
    public String c3d_acces(String val, int dir){
        String armed = c3d_newVar() + ASSIG + PTR +MAS+dir + SEMIC+saltoLinea;
        armed += c3d_newVar() + ASSIG + c3d_stack("w" + (contador-2))  + SEMIC+saltoLinea;
        varsParams.add("w" + (contador-1));
        return  armed;
    }
    public String c3d_accesTemp(String val, int dir){
                                                    //    t28 = t27 + 0;
                                                    //    t29 = stack[t28];
        String armed = c3d_newVar() + ASSIG + ptrTemp +MAS+dir + SEMIC+saltoLinea;
        armed += c3d_newVar() + ASSIG + c3d_stack("w" + (contador-2))  + SEMIC+saltoLinea;
        varsParams.add("w" + (contador-1));
        return  armed;
    }
    
    public String c3d_asignVal(String val, int dir){    //asignacion de nativos
        String armed = c3d_newVar() + ASSIG + PTR +MAS+dir + SEMIC+saltoLinea;
        armed += c3d_stack("w" + (contador-1)) + ASSIG + varsParams.get(0) + SEMIC+saltoLinea;
        varsParams.removeFirst();
        return  armed;
    }   
//    t26 = t25 + 1;    
//    stack[t26] = t22; 
    public String c3d_asignVar(String val, int dir){
        String armed = c3d_newVar() + ASSIG +  ptrTemp +MAS+dir + SEMIC+saltoLinea;
        armed += c3d_stack("w" + (contador-1)) + ASSIG + varsParams.get(0) + SEMIC+saltoLinea;
        varsParams.removeFirst();
        return  armed;
    }
//    public String c3d_asignVarNat(String val, int dir){
//        String armed = c3d_newVar() + ASSIG +  ptrTemp +MAS+dir + SEMIC+saltoLinea;
//        armed += c3d_stack("w" + (contador-1)) + ASSIG + val + SEMIC+saltoLinea;
//        varsParams.removeFirst();
//        return  armed;
//    }
    
    public String c3d_printVar(boolean  ln){
        String armed = "";  
        if(ln){
            armed = "cout<<" + varsParams.get(0) +"<<endl"+ SEMIC + saltoLinea;
        }else{
            armed = "cout<<" + varsParams.get(0) + SEMIC + saltoLinea;
        }
        return armed; 
    }
    
    public String c3d_printNativo(String val, boolean  ln){
        String armed = "";  




        if(ln){
            armed = "cout<<" + "\"" + val +"\" " +"<<endl"+ SEMIC + saltoLinea;
        }else{
            armed = "cout<<" + "\""+val + "\"" + SEMIC + saltoLinea;
        }
        return armed; 
    }
    
//    public String c3d_statement(String val, int dir){
//        String armed = c3d_newVar() + ASSIG + PTR +dir + saltoLinea;
//        armed += c3d_stack(curVar) + ASSIG + val;
//        return  armed;
//    }
//    tr6 = ptr + dir;
//    stack[tr6] = var;
    
    
    public String c3d_newVar(){
        String varInt = "int w" + contador;
//        ptrTemp = varInt;
        contador++;
        return varInt;
    } 
    
    public String c3d_stack(String i){
        String BR_L = "[";
        String BR_R = "]";
        String arm = STACK + BR_L +i+ BR_R;
        return arm; 
    }    
    
    public String c3d_moveToStack(boolean go_Back, int size){       
                        //preparar, al ejecutar un metodo
        String arm = "";
        if(go_Back){
            arm = PTR + ASSIG  + PTR + MAS +size + SEMIC+saltoLinea ;
        }else{
            arm = PTR + ASSIG  + PTR + MENOS +size + SEMIC+saltoLinea ;
        }
        return arm; 
    }
    public String c3d_ptrTemp(int size){       
                        //preparar, temporalmente
        String arm = "";
            arm+="\n";
        ptrTemp = "";
        ptrTemp += "w" + contador;
            arm = c3d_newVar() + ASSIG  + PTR + MAS +size + SEMIC +saltoLinea   ;
            arm+="\n";
        return arm; 
    }
    
    public String c3d_metodo(String id, String body){
        String armed = "";
        String VOID = "void ";
        armed = VOID + id + PAR_L + PAR_R + KEY_L +  saltoLinea+  
                body + saltoLinea + KEY_R + saltoLinea;
        
        return  armed;
    }
    
    public String c3d_main(String id, String body){
        String armed = "";
        String INT = "int";
        armed = INT +" "+ id + PAR_L + PAR_R + KEY_L +  saltoLinea+  
                body + saltoLinea + KEY_R;
        
        return  armed;
    }
        
    
     
    
    public void clearCount(){
        contador = 0;
    }

    public void setPtrTemp(String s) {
        this.ptrTemp = s;
    }

    public String getPtrTemp() {
        return ptrTemp;
    }
    
    public void clearPtrTemp() {
        this.ptrTemp = "";
    }

    public void setOPRT(String OPRT) {
        this.OPRT = OPRT;
    }

    public void clearVarParams(){
        varsParams =  new LinkedList<>();
    }
    
    
     
        
    
}
