/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.sC3D;

import com.wilsoncys.compi1.java.model.asbtracto.CreadorC3d;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.List;
import javax.sound.sampled.Line;
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
    String var1 = "";
    String var2 = "";
    public LinkedList<String> varsRef;
    public LinkedList<String> varsParams;
    

 
    String OPRT = " + ";
    private String ptrTemp = "";
    public int contador = 0;
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
    
    public String c3d_accesParam(String tipo, LinkedList<String> vars, int dir){
        String armed = c3d_newVar("int", vars) + ASSIG + PTR +MAS+dir + SEMIC;
        armed += c3d_newVar(tipo, vars) + ASSIG + c3d_stack(tipo,"int" + (contador-2))  + SEMIC +saltoLinea;
        varsParams.add(tipo + (contador-1));
        return  armed;
    }
//    public String c3d_acces(String val, int dir){
//        String armed = c3d_newVar() + ASSIG + PTR +MAS+dir + SEMIC;
//        armed += c3d_newVar() + ASSIG + c3d_stack("w" + (contador-2))  + SEMIC +saltoLinea;
//        varsParams.add("w" + (contador-1));
//        return  armed;
//    }
     
    
    
    
    
    int dirRef = 0;
    
    public String c3d_accesAttVarl(String val, int dir){
        String armed = c3d_newVar() + ASSIG + varsRef.getFirst() +MAS+dir + SEMIC;
        varsRef.removeFirst();
        armed += c3d_newVar() + ASSIG + c3d_heap("w" + (contador-2))  + SEMIC +saltoLinea;
        varsParams.add("w" + (contador-1));
        //bugggg
        return  armed;
    }
    

     
     public String c3d_accesRef(String val, int dir){
        String armed = c3d_newVar("int", varsParams) + ASSIG + PTR +MAS+dir + SEMIC;
        armed += c3d_newVar() + ASSIG + c3d_stack("int","int" + (contador-2))  + SEMIC +saltoLinea;
        varsRef.add("int" + (contador-1));
//        varsParams.addFirst("w" + (countCreateVar-1));
        return  armed;
    }
    
    
    public String c3d_accesTemp(String tipo, LinkedList<String> vars, int dir){
                                                    //    t28 = t27 + 0;
                                                    //    t29 = stack[t28];
        String armed = c3d_newVar("int", vars) + ASSIG + ptrTemp +MAS+dir + SEMIC;
        armed += c3d_newVar(tipo, vars) + ASSIG + c3d_stack(tipo,"int" + (contador-2))  + SEMIC+saltoLinea;
        varsParams.add(tipo + (contador-1));
        return  armed;
    }
                                        //simple
    public String c3d_asignVal(String tipo,  LinkedList<String> vars , int dir){    //asignacion de nativos
        String armed = c3d_newVar("int", vars) + ASSIG + PTR +MAS+dir + SEMIC;
        armed += c3d_stack(tipo,"int" + (contador-1)) + ASSIG + varsParams.get(0) + SEMIC+saltoLinea;
        varsParams.removeFirst();
        return  armed;
    }   
//    t26 = t25 + 1;    
//    stack[t26] = t22;                         
    public String c3d_asignVar(String tipo, String val, LinkedList<String> vars,int dir){
        String armed = c3d_newVar("int", vars) + ASSIG +  val +MAS+dir + SEMIC;
        armed += c3d_stack(tipo, "w" + (contador-1)) + ASSIG + varsParams.get(0) + SEMIC+saltoLinea;
        varsParams.removeFirst();
        return  armed;
    }
    
    public String c3d_asignTemp(String tipo, LinkedList<String> vars, int dir){
        String armed = c3d_newVar("int", vars)+ ASSIG +  ptrTemp +MAS+dir + SEMIC;
        armed += c3d_stack(tipo,"int" + (contador-1)) + ASSIG + varsParams.get(0) + SEMIC+saltoLinea;
        varsParams.removeFirst();
        return  armed;
    }
    
    public String c3d_asignHeap(String val, int dir){
        String armed = c3d_newVar() + ASSIG +  varsParams.getFirst() +MAS+dir + SEMIC;
        armed += c3d_heap("w" + (contador-1)) + ASSIG + val + SEMIC+saltoLinea;
        varsParams.removeFirst();
        return  armed;
    }
    public String accesHeap(String val, int dir){
        String armed = c3d_newVar() + ASSIG +  varsParams.getFirst() +MAS+dir + SEMIC;
        armed += c3d_newVar() + ASSIG +c3d_heap("w" + (contador-1))   + SEMIC+saltoLinea;
        varsParams.removeFirst();
        return  armed;
    }
    
    public String c3d_asignAlone(String val){
        String armed = c3d_newVar() + ASSIG +  val+ SEMIC+saltoLinea;
        varsParams.add("w"+(contador-1));
        return  armed;
    }
    public String c3d_reserveHeap(LinkedList<String> vars, int stackSize){
        String armed = c3d_newVar("int", vars) + ASSIG + H + SEMIC;
        armed += H + ASSIG +  "int" + (contador -1)+MAS +stackSize+ SEMIC+saltoLinea;
        varsParams.add("int"+(contador-1));
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
            armed = "\ncout<<" + varsParams.get(0) + SEMIC ;
        return armed; 
    }
    
    
    public String c3d_printNativo(String val){
        String armed = "";  
            armed = "\ncout<<" + "\""+val + "\"" + SEMIC ;
        return armed; 
    }
 
    
     
    public String c3d_newNativo(String tipo, String val, LinkedList<String> vars) {
        String id = c3d_newVar(tipo, vars);
        varsParams.add(id);
        return   id + ASSIG +  val + SEMIC;
        
    }
    
    
    private String c3d_newVar(String s, LinkedList<String> vars){
        String id =   s + contador;
        String dec = s +" "+ id + SEMIC;
        contador++;
        vars.add(dec + "\n");
        return id;
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
        String varInt = "w" + contador;
//        ptrTemp = varInt;
        contador++;
        return varInt;
    } 
    
    
    private String c3d_newVarCond(){
//        String varInt = "bool w" + countCreateVar;
        String varInt = " w" + contador;
//        ptrTemp = varInt;
        contador++;
        return varInt;
    } 
    
    public String c3d_stack(String ty, String dir){
        String BR_L = "[";
        String BR_R = "]";
        String arm = STACK+ ty + BR_L +dir+ BR_R;
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
    public String c3d_ptrTemp(LinkedList<String> vars, int size){       
                        //preparar, temporalmente
        String arm = "";
            arm+="\n";
        ptrTemp = "";
        ptrTemp += "int" + contador;
            arm = c3d_newVar("int", vars) + ASSIG  + PTR + MAS +size + SEMIC;
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
        armed += "cin>>" + "w" + (contador-1)  + SEMIC +saltoLinea;
        varsParams.add("w"+(contador-1));
        return  armed;
    }
    
    public String callJava(String id){
        return  id + "()" +  SEMIC;
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

    public int getContador() {
        return contador;
    }


    
     
        
    
}
