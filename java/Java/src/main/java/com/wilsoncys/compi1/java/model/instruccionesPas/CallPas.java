/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instruccionesPas;


import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author Jonwil
 */
public class CallPas extends Instruction{
    private String identificator;
    private LinkedList<Instruction> parametersExp;
    private LinkedList<HashMap> listParams;
    public CallPas(String identificator, LinkedList<Instruction> parametros, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.identificator = identificator;
        this.parametersExp = parametros;
    }
    
    
    
    @Override
    public Object interpretar(Arbol tree, TablaSimbolos tabla) {
        verificarMismoTipo();
         
               //parametros del metodo o funcion 
//
//        //buscar la funcion
        var functio = tree.getFunction(identificator);
        if(functio == null){
            return new Errores("SEMANTIC", "El id ingresado no corresponde a ningun tipo de funcion/metodo/struct", line, col);
        }
        if(functio instanceof MethodPas theMethod){
            listParams = theMethod.parameters;
            //crear el entorno
            TablaSimbolos newTable = new TablaSimbolos(tree.getTablaGlobal());
            newTable.setNombre("Metodo: " + identificator);
            tree.addTablaReport(newTable);
            
            
            //validar las cantidades de parametros(en las llamada y en la declaracion del metodo)
            if(listParams.size() != parametersExp.size() ){
                mensErr = String.format("Cantidad de parametros Incorrecta. Al llamar al metodo: %s ", theMethod.id);
                return new Errores("SEMANTIC", mensErr, line, col);
            }
            
            int contador = 0;   
            for (var exp : parametersExp) {                         //CICLO                                                                        
                HashMap par = listParams.get(contador);             //comparar que el tipo coicida con el orden 
                Tipo tipo = (Tipo)par.get("tipo");
                LinkedList<String> la = new LinkedList<>();
               String emptyDec = "";                                 //crear la declaracion sin valor
                try {
                    emptyDec =  par.get("id").toString();
                    la.add(emptyDec);
                  
                  
                  
                } catch (Exception e) {
                    System.out.println("Error en ingreso de parametros de un procedimiento");
                   la =  (LinkedList<String>)par.get("ids");
                }
                                                
                
                StatementPas newStt = new StatementPas(la, tipo, line, col, false);    
                var sttm = newStt.interpretar(tree, newTable);     //interpretar la declaracion
                if(sttm instanceof Errores){
                    return sttm;
                }
                
                var valueExp = exp.interpretar(tree, tabla);        //interpretar los parametros
                if(valueExp instanceof Errores){
                    return valueExp;
                }
                
                if(exp.tipo.getTipo() != tipo.getTipo()){       //verificar los tipos
                    mensErr = "Tipos Erronos de parametros al llamar al metodo:  " + theMethod.id;
                    return new Errores("SEMANTIC", mensErr, exp.line, exp.col);
                }
                
                
                Simbolo symm = newTable.getSsymbol(par.get("id").toString());   //realizar la asignacion                                                              //realizar la asignacion
                if(symm == null){
                    return new Errores("SEMANTIC", "No se encontro el parametro en funcion: " 
                                                        + identificator, line, col);
                }
                symm.setValor(valueExp);
                contador++;
            }//for(exp)
            
            var metodoVoid = theMethod.interpretar(tree, newTable);     //interpretar la funcion (mandarle la nueva tabla)
            if(metodoVoid instanceof Errores){
                return metodoVoid;
            }
            
            if(metodoVoid instanceof transferReturn_eliminar metodd){
                if(metodd.expression!=null){
                    return  new Errores("SEMANTIC", "Retorno con expresion en Metodo: " + theMethod.id, theMethod.line, theMethod.col);
                }
                return null;
            }
            
        }
        
        
        
        
        if(functio instanceof FunctionssPas theFun){
            listParams = theFun.parameters;
            //crear el entorno
            TablaSimbolos newTable = new TablaSimbolos(tree.getTablaGlobal());
            newTable.setNombre("Metodo: " + identificator);
            tree.addTablaReport(newTable);
            
            
            //validar las cantidades de parametros(en las llamada y en la declaracion del metodo)
            if(listParams.size() != parametersExp.size() ){
                mensErr = String.format("Cantidad de parametros Incorrecta. Al llamar al metodo: %s ", theFun.id);
                return new Errores("SEMANTIC", mensErr, line, col);
            }
            
            int contador = 0;   
            for (var exp : parametersExp) {                         //CICLO                                                                        
                HashMap par = listParams.get(contador);             //comparar que el tipo coicida con el orden 
                Tipo tipo = (Tipo)par.get("tipo");
                LinkedList<String> la = new LinkedList<>();
               String emptyDec = "";                                 //crear la declaracion sin valor
                try {
                    emptyDec =  par.get("id").toString();
                    la.add(emptyDec);
                  
                  
                  
                } catch (Exception e) {
                    System.out.println("Error en ingreso de parametros de un procedimiento");
                   la =  (LinkedList<String>)par.get("ids");
                }
                                                
                
                StatementPas newStt = new StatementPas(la, tipo, line, col, false);    
                var sttm = newStt.interpretar(tree, newTable);     //interpretar la declaracion
                if(sttm instanceof Errores){
                    return sttm;
                }
                
                var valueExp = exp.interpretar(tree, tabla);        //interpretar los parametros
                if(valueExp instanceof Errores){
                    return valueExp;
                }
                
                if(exp.tipo.getTipo() != tipo.getTipo()){       //verificar los tipos
                    mensErr = "Tipos Erronos de parametros al llamar al metodo:  " + theFun.id;
                    return new Errores("SEMANTIC", mensErr, exp.line, exp.col);
                }
                
                
                Simbolo symm = newTable.getSsymbol(par.get("id").toString());   //realizar la asignacion                                                              //realizar la asignacion
                if(symm == null){
                    return new Errores("SEMANTIC", "No se encontro el parametro en funcion: " 
                                                        + identificator, line, col);
                }
                symm.setValor(valueExp);
                contador++;
            }//for(exp)
            
            var fun = theFun.interpretar(tree, newTable);     //interpretar la funcion (mandarle la nueva tabla)
            if(fun instanceof Errores){
                return fun;
            }
            
            if(fun instanceof Errores){
                return fun;
            }    
            if(fun == null){
                return new Errores("SEMANTIC", "Funcion sin valor de retorno: " + ((FunctionssPas) functio).id, functio.line, functio.col);
            }
            boolean thereReturn = false;
            if(fun instanceof transferReturn_eliminar){
                if(((transferReturn_eliminar) fun).expression == null){
                    return new Errores("SEMANTIC", "Return sin valor a retornar: " + ((FunctionssPas) functio).id, functio.line, functio.col);
                }
                var returnVAlue = ((transferReturn_eliminar) fun).interpretar(tree, newTable); //interpretar el return
                if(returnVAlue instanceof Errores){
                    return returnVAlue;
                }else{
                    thereReturn = true;     //hay return en la funcion
                    this.tipo = ((transferReturn_eliminar) fun).tipo;
                    //verificar tipo de la funcion y tipo del valor del retorno  
                    if(this.tipo.getTipo() != theFun.tipo.getTipo()){
                        return new Errores("SEMANTIC", "Tipo de valor de retorno no corresponde al tipo de la funcion", 
                                ((transferReturn_eliminar) fun).expression.line, ((transferReturn_eliminar) fun).expression.col);
                    }

                    return returnVAlue;
                }
                
            }
            if(!thereReturn){       //si no hay un retur al finalizar todas las instrucciones
                return new Errores("SEMANTIC", "Funcion sin valor de retorno: " + ((FunctionssPas) functio).id+  " ", functio.line, functio.col);
            } 
        }
              

        
 
        
        return null;
    }
    
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }

    private void verificarMismoTipo() {
        for (Instruction instruction : parametersExp) {
            
            
            
        }
//        HashMap<String, Object> hashSecond =simbolos.getTablaActual() ;
//            for (Map.Entry<String, Object> AE : hashSecond.entrySet()) {
//                contador++;
//                String key2 = AE.getKey();
//                Object value2 = AE.getValue();
//                Simbolo sim = (Simbolo)value2;
//                
//                
//                
//                
//            }
    }

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
}
