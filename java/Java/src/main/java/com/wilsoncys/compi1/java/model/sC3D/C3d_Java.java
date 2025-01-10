/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.sC3D;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jonwilson
 */
public class C3d_Java {
    private final String STACK = "stack";
    private final String HEAP = "heap";
    private final String MAS = " + ";
    private final String MENOS = " - ";
    private final String SEMIC = ";\n";
    private final String PAR_L = "(";
    private final String PAR_R = ")";
    private final String KEY_L = "{";
    private final String KEY_R = "}";
    private final String ASSIG = " = ";
    private final String saltoLinea = "\n";
    public int countCreateVar = 0;
    String var1 = "";
    String var2 = "";
    public LinkedList<String> varsParams;
    public LinkedList<String> varsRef;
    
 
    String OPRT = " + ";
    private String ptrTemp = "";
    int DIR_RF = 0;
    int RETURN = 0;
    int RETURNPoo = 1;
    int DIR_R = 2;
    String PTR = "ptr";
    String H = "h";
        
    
    public C3d_Java() {
        varsParams = new LinkedList<>();
        varsRef = new LinkedList<>();
    }
    
    
    
    
    public void control(){
    }
    
 
    public String c3d_operation(String val1, String val2){
        String armed = c3d_newVar() + ASSIG + val1+OPRT+val2 + SEMIC;
        return  armed;
    }
    public String c3d_operationRelation(String val1, String val2){
        String armed = c3d_newVarCond()+ ASSIG + val1+OPRT+val2 + SEMIC;
        return  armed;
    }
    
    public String c3d_accesParam(String val, int dir){
        String armed = c3d_newVar() + ASSIG + PTR +MAS+dir + SEMIC;
        armed += c3d_newVar() + ASSIG + c3d_stack("w" + (countCreateVar-2))  + SEMIC +saltoLinea;
        varsParams.add("w" + (countCreateVar-1));
        return  armed;
    }
    
    int dirRef = 0;
    
    public String c3d_accesAttVarl(String val, int dir){
        String armed = c3d_newVar() + ASSIG + varsRef.getFirst() +MAS+dir + SEMIC;
        varsRef.removeFirst();
        armed += c3d_newVar() + ASSIG + c3d_heap("w" + (countCreateVar-2))  + SEMIC +saltoLinea;
        varsParams.add("w" + (countCreateVar-1));
        //bugggg
        return  armed;
    }
    
     public String c3d_acces(String val, int dir){
        String armed = c3d_newVar() + ASSIG + PTR +MAS+dir + SEMIC;
        armed += c3d_newVar() + ASSIG + c3d_stack("w" + (countCreateVar-2))  + SEMIC +saltoLinea;
        varsParams.add("w" + (countCreateVar-1));
//        varsParams.addFirst("w" + (countCreateVar-1));
        return  armed;
    }
     public String c3d_accesRef(String val, int dir){
        String armed = c3d_newVar() + ASSIG + PTR +MAS+dir + SEMIC;
        armed += c3d_newVar() + ASSIG + c3d_stack("w" + (countCreateVar-2))  + SEMIC +saltoLinea;
        varsRef.add("w" + (countCreateVar-1));
//        varsParams.addFirst("w" + (countCreateVar-1));
        return  armed;
    }
    
    
    public String c3d_accesTemp(String val, int dir){
                                                    //    t28 = t27 + 0;
                                                    //    t29 = stack[t28];
        String armed = c3d_newVar() + ASSIG + ptrTemp +MAS+dir + SEMIC;
        armed += c3d_newVar() + ASSIG + c3d_stack("w" + (countCreateVar-2))  + SEMIC+saltoLinea;
        varsParams.add("w" + (countCreateVar-1));
        return  armed;
    }
    
    public String c3d_asignVal(String val, int dir){    //asignacion de nativos
        String armed = c3d_newVar() + ASSIG + PTR +MAS+dir + SEMIC;
        armed += c3d_stack("w" + (countCreateVar-1)) + ASSIG + varsParams.get(0) + SEMIC+saltoLinea;
        varsParams.removeFirst();
        return  armed;
    }   
//    t26 = t25 + 1;    
//    stack[t26] = t22;     
    public String c3d_asignVar(String val, int dir){
        String armed = c3d_newVar() + ASSIG +  val +MAS+dir + SEMIC;
        armed += c3d_stack("w" + (countCreateVar-1)) + ASSIG + varsParams.get(0) + SEMIC+saltoLinea;
        varsParams.removeFirst();
        return  armed;
    }
    
    public String c3d_asignTemp(String val, int dir){
        String armed = c3d_newVar() + ASSIG +  ptrTemp +MAS+dir + SEMIC;
        armed += c3d_stack("w" + (countCreateVar-1)) + ASSIG + varsParams.get(0) + SEMIC+saltoLinea;
        varsParams.removeFirst();
        return  armed;
    }
    
    public String c3d_asignHeap(String val, int dir){
        String armed = c3d_newVar() + ASSIG +  varsParams.getFirst() +MAS+dir + SEMIC;
        armed += c3d_heap("w" + (countCreateVar-1)) + ASSIG + val + SEMIC+saltoLinea;
        varsParams.removeFirst();
        return  armed;
    }
    public String accesHeap(String val, int dir){
        String armed = c3d_newVar() + ASSIG +  varsParams.getFirst() +MAS+dir + SEMIC;
        armed += c3d_newVar() + ASSIG +c3d_heap("w" + (countCreateVar-1))   + SEMIC+saltoLinea;
        varsParams.removeFirst();
        return  armed;
    }
    
    public String c3d_asignAlone(String val){
        String armed = c3d_newVar() + ASSIG +  val+ SEMIC+saltoLinea;
        varsParams.add("w"+(countCreateVar-1));
        return  armed;
    }
    public String c3d_reserveHeap(int stackSize){
        String armed = c3d_newVar() + ASSIG + H + SEMIC;
        armed += H + ASSIG +  "w" + (countCreateVar -1)+MAS +stackSize+ SEMIC+saltoLinea;
        varsParams.add("w"+(countCreateVar-1));
        return  armed;
    }
    
//    public String c3d_asignVarNat(String val, int dir){
//        String armed = c3d_newVar() + ASSIG +  ptrTemp +MAS+dir + SEMIC+saltoLinea;
//        armed += c3d_stack("w" + (contador-1)) + ASSIG + val + SEMIC+saltoLinea;
//        varsParams.removeFirst();
//        return  armed;
//    }
    
    public String c3d_printVar(){
        String armed = "";  
            armed = "cout<<" + varsParams.get(0) + SEMIC ;
        return armed; 
    }
    
    public String c3d_printNativo(String val){
        String armed = "";  
            armed = "cout<<" + "\""+val + "\"" + SEMIC ;
        return armed; 
    }
    
//    public String c3d_statement(String val, int dir){
//        String armed = c3d_newVar() + ASSIG + PTR +dir + saltoLinea;
//        armed += c3d_stack(curVar) + ASSIG + val;
//        return  armed;
//    }
//    tr6 = ptr + dir;
//    stack[tr6] = var;
    
    
    private String c3d_newVar(){
//        String varInt = "int w" + countCreateVar;
        String varInt = "w" + countCreateVar;
//        ptrTemp = varInt;
        countCreateVar++;
        return varInt;
    } 
    private String c3d_newVarCond(){
//        String varInt = "bool w" + countCreateVar;
        String varInt = " w" + countCreateVar;
//        ptrTemp = varInt;
        countCreateVar++;
        return varInt;
    } 
    
    public String c3d_stack(String i){
        String BR_L = "[";
        String BR_R = "]";
        String arm = STACK + BR_L +i+ BR_R;
        return arm; 
    }    
    public String c3d_heap(String i){
        String BR_L = "[";
        String BR_R = "]";
        String arm =   HEAP+BR_L +i+ BR_R;
        return arm; 
    }    
    
    public String c3d_moveToStack(boolean go_Back, String size){       
                        //preparar, al ejecutar un metodo
        String arm = "";
        if(go_Back){
            arm = PTR + ASSIG  + PTR + MAS +size + SEMIC ;
        }else{
            arm = PTR + ASSIG  + PTR + MENOS +size + SEMIC ;
        }
        return arm; 
    }
    public String c3d_ptrTemp(String size){       
                        //preparar, temporalmente
        String arm = "";
            arm+="\n";
        ptrTemp = "";
        ptrTemp += "w" + countCreateVar;
            arm = c3d_newVar() + ASSIG  + PTR + MAS +size + SEMIC;
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
        armed = INT +" "+ id + PAR_L + PAR_R + KEY_L +  saltoLinea +  
                body + saltoLinea + KEY_R;
        return  armed;
    }

    public String c3d_Input(){
        String armed = c3d_newVar() + SEMIC  ;
        armed += "cin>>" + "w" + (countCreateVar-1)  + SEMIC +saltoLinea;
        varsParams.add("w"+(countCreateVar-1));
        return  armed;
    }
    
    public String callJava(String id){
        return  "java_" + id + "()" +  SEMIC;
    }
    
    public String cond_If(String op1, String op2, String labelif, String labelSalida){
        String armed = "";
        armed =  "if" + PAR_L + op1;
        armed+= OPRT + op2 + PAR_R + 
                                "goto " + labelif+ SEMIC;
        
        armed+= "goto " + labelSalida + SEMIC;
        
        return armed;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
        
    
     
    
    public void clearCount(){
        countCreateVar = 0;
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

    public int getContador() {
        return countCreateVar;
    }
    
    
     
        
    
}
