/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.simbolo;

//import abstracto.Instruction;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores; 
import com.wilsoncys.compi1.java.model.poo.Method;
import com.wilsoncys.compi1.java.model.instrucciones.Structs;
import com.wilsoncys.compi1.java.model.poo.Classs;
import com.wilsoncys.compi1.java.model.poo.Functionss;
import com.wilsoncys.compi1.java.model.poo.Mainn;
import com.wilsoncys.compi1.java.model.programa.ClasesJava;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author yoyo
 */
public class Arbol {

    private String consola;     //contiene el texto de las salidas de la funcion println
    
    private TablaSimbolos tablaGlobal;              //contiene las variables declaradas globalmente

//    private LinkedList<TablaSimbolos> tablaGlobal;              //contiene las variables declaradas globalmente

    
    private LinkedList<Errores> errores;
    private LinkedList<Instruction> instrucciones;      //contiene todas las intrucciones (funciones, metodos,asignaciones, declaraciones)
    private LinkedList<Instruction> functionsPascal;          //list of methods, functions and Structs
    private LinkedList<TablaSimbolos> tablaReport = new LinkedList<>();          //par la tabla de simbolos
    
    
    public C3d cMain;
    public C3d_Java java;
    private List<String>  currentAmbit;   //idclase/metodo/params


    
    public int attbClassJava = 0;
    public int attbPrincipal = 0;
    private int posReturn = 1;
    
    
    public int count;       //contador de las variables que se van creando
    
    
    private LinkedList<Errores> listaErrores = new LinkedList<>();


    public Arbol(LinkedList<Instruction> instrucciones) {
        this.instrucciones = instrucciones;
        this.consola = "";
        this.tablaGlobal = new TablaSimbolos();
        this.errores = new LinkedList<>();
        this.functionsPascal = new LinkedList<>();   
        this.currentAmbit = new ArrayList<>();
        this.count = 0;
        cMain = new C3d();
        java = new C3d_Java();

    }

    public LinkedList<Instruction> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(LinkedList<Instruction> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

//    public tablaSimbolos getTablaGlobal() {
    public TablaSimbolos getTablaGlobal() {
        return tablaGlobal;
    }

    public void setTablaGlobal(TablaSimbolos tablaGlobal) {
//    public void addTabla(TablaSimbolos tablaGlobal) {
        this.tablaGlobal = tablaGlobal;
    }

    public LinkedList<Errores> getErrores() {
        return errores;
    }

    public void setErrores(LinkedList<Errores> errores) {
        this.errores = errores;
    }

    public void Print(String valor) {
        this.consola += valor + "\n";
    }

    public LinkedList<Instruction> getListFunctions() {
        return functionsPascal;
    }

    public void setFunctions(LinkedList<Instruction> functions) {
        this.functionsPascal = functions;
    }
    public void addFunctions(Instruction functions) {
        this.functionsPascal.add(functions);
    }
    
    public Instruction getFunction(String id){
        for (Instruction fun :  functionsPascal) {
            if(fun instanceof Method method){       //identifica metodos
                if(method.id.equalsIgnoreCase(id)){     //identifica el metodo con el id solicitado
                    return fun;
                }
            }
            if(fun instanceof Functionss Fun){       //identifica metodos
                if(Fun.id.equalsIgnoreCase(id)){     //identifica el metodo con el id solicitado
                    return fun;
                }
            }
            if(fun instanceof Structs str){       //identifica metodos
                if(str.id.equalsIgnoreCase(id)){     //identifica el metodo con el id solicitado
                    return fun;
                }
            }
        }
        
        return null;
    }

    public void addError(Errores error) {
        this.listaErrores.add(error);
    }

    public LinkedList<Errores> getListaErrores() {
        return listaErrores;
    }

    public void addTablaReport(TablaSimbolos tablaReport) {
        this.tablaReport.add(tablaReport);
    }

    public LinkedList<TablaSimbolos> getTablaReport() {
        return tablaReport;
    }
    
    public int getCount() {
        this.count++;
        return this.count;

    }

 
 
 
    public Simbolo getSym(String id){
        return  tablaGlobal.getSsymbol(id);
    }

    public C3d getC3d() {
        return cMain;
    }

    public void setSizeHeap(int sizeStack) {
        this.attbClassJava = sizeStack;
    }

    public int getSizeHeap() {
        return attbClassJava;
    }

    public void setPosReturn(int posReturn) {
        this.posReturn = posReturn;
    }

    public int getPosReturn() {
        return posReturn;
    }

    public C3d_Java getJava() {
        return java;
    }
    public ClasesJava getClasesJava(){
        ClasesJava clases = null;
        for (Instruction ins : instrucciones) {
            if(ins instanceof ClasesJava cl){
                clases = cl;
            }
        }   
        
        return clases;
    } 

    
    
    
    
        public void setAmbito(List<String> ambito) {
            this.currentAmbit = new LinkedList<>();
            for (String st : ambito) {
                this.currentAmbit.add(st);
            }
        }

    
    public String getAmbito_asID(){
        String ambi = "";
        for (String st : currentAmbit) {
            ambi +=st;
        }
        return ambi; 
                
    }
    
    public List<String> getCurrentAmbit() {
        return currentAmbit;
    }

    public void setCurrentAmbit(List<String> currentAmbit) {
        this.currentAmbit = currentAmbit;
    }
    
    
    
    
    

    
    
    
    
    
    
    
}
