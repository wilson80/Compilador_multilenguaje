/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.sC3D;

import java.util.ArrayList;
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
    public List<String> varsParams;
    
 
    int DIR_RF = 0;
    int RETURN = 0;
    int RETURNPoo = 1;
    int DIR_R = 2;
    String STACK = "stack";
    String saltoLinea = "\n";
    String ASSIG = "=";
    String PTR = "ptr";
    String H = "h";
        
    String MAS = "+";
    String MENOS = "-";
    String SEMIC = ";";
    String PAR_L = "(";
    String PAR_R = ")";
    String KEY_L = "{";
    String KEY_R = "}";

    public C3d() {
        varsParams = new ArrayList<>();
    }
    
    
    
    
    public void control(){
        
    }
    
 
    public String c3d_operation(String val, int dir){
        String armed = c3d_newVar() + ASSIG + varsParams.get(0)+varsParams.get(1) + SEMIC+saltoLinea;
        varsParams = new ArrayList<>();
        varsParams.add("w"+(contador-1));
        return  armed;
    }
    public String c3d_acces(String val, int dir){
        String armed = c3d_newVar() + ASSIG + PTR +MAS+dir + SEMIC+saltoLinea;
        armed += c3d_newVar() + ASSIG + c3d_stack("w" + (contador-2))  + SEMIC+saltoLinea;
        varsParams.add("w" + (contador-1));
        return  armed;
    }
    
    public String c3d_asignVal(String val, int dir){
        String armed = c3d_newVar() + ASSIG + PTR +MAS+dir + SEMIC+saltoLinea;
        armed += c3d_stack("w" + (contador-1)) + ASSIG + val + SEMIC+saltoLinea;
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
        ptrTemp = "";
        ptrTemp += "w" + contador;
            arm = c3d_newVar() + ASSIG  + PTR + MAS +size + SEMIC +saltoLinea   ;
        return arm; 
    }
    
    public String c3d_metodo(String id, String body){
        String armed = "";
        String VOID = "void ";
        armed = VOID + id + PAR_L + PAR_R + KEY_L +  saltoLinea+  
                body + saltoLinea + KEY_R;
        
        return  armed;
    }
        
    
     
    
    public void clearCount(){
        contador = 0;
    }

    public void setPtrTemp() {
        this.ptrTemp = "";
    }
    
    
     
        
    
}
