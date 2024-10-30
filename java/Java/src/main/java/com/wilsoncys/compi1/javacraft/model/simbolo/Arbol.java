/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.simbolo;

//import abstracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores; 
import com.wilsoncys.compi1.javacraft.model.poo.Method;
import com.wilsoncys.compi1.javacraft.model.instrucciones.Structs;
import com.wilsoncys.compi1.javacraft.model.poo.Classs;
import com.wilsoncys.compi1.javacraft.model.poo.Functionss;
import com.wilsoncys.compi1.javacraft.model.poo.Mainn;
import com.wilsoncys.compi1.javacraft.model.sC3D.C3d;
import java.util.LinkedList;

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
    private LinkedList<Instruction> functions;          //list of methods, functions and Structs
    private LinkedList<TablaSimbolos> tablaReport = new LinkedList<>();          //par la tabla de simbolos
    
    private Classs classMain; 
    private Mainn methodMain; 
    public C3d c3d;
    public int sizeStack = 0;
    private int posReturn = 0;
    
   
    public int count;
    
    

    
    private LinkedList<Errores> listaErrores = new LinkedList<>();


    public Arbol(LinkedList<Instruction> instrucciones) {
        this.instrucciones = instrucciones;
        this.consola = "";
        this.tablaGlobal = new TablaSimbolos();
        this.errores = new LinkedList<>();
        this.functions = new LinkedList<>();     
        this.count = 0;
        c3d = new C3d();

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
        return functions;
    }

    public void setFunctions(LinkedList<Instruction> functions) {
        this.functions = functions;
    }
    public void addFunctions(Instruction functions) {
        this.functions.add(functions);
    }
    
    public Instruction getFunction(String id){
        for (Instruction fun :  functions) {
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

    public void setClassMain(Classs classMain) {
        this.classMain = classMain;
    }

    public Classs getClassMain() {
        return classMain;
    }
    

    public void setMethodMain(Mainn methodMain) {
        this.methodMain = methodMain;
    }

    public Mainn getMethodMain() {
        return methodMain;
    }
    
    public Simbolo getSym(String id){
        return  tablaGlobal.getSsymbol(id);
    }

    public C3d getC3d() {
        return c3d;
    }

    public void setSizeStack(int sizeStack) {
        this.sizeStack = sizeStack;
    }

    public int getSizeStack() {
        return sizeStack;
    }

    public void setPosReturn(int posReturn) {
        this.posReturn = posReturn;
    }

    public int getPosReturn() {
        return posReturn;
    }
    
    

    
    
}
