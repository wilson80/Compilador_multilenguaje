/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instrucciones;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class Match extends Instruction{
    private Instruction expression;
    private LinkedList<CaseMatch> cazzos;
    private LinkedList<Instruction> insOfDefault;

//    private CaseMatch defaultCase;
    
    public Match(Instruction expression, LinkedList<CaseMatch> cazzos, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expression = expression;
        this.cazzos = cazzos;
    }
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        setDefault(); //identificar el caso default en la lista de cazzos 
        
        
//        interpret valor de la expresion
        var valorMatch = this.expression.interpretar(arbol, tabla);
        if(valorMatch instanceof Errores){
            return valorMatch;
        }
        
        //nuevo entorno
        var newTable = new TablaSimbolos(tabla);
        
        //validar el valor de la expresion del match

        
        //al hacerle interpretar  a la lista de casos se le va pasando el valor de la exp del match y se va comparando
        boolean noMatch = false;
        for (CaseMatch cazzo : cazzos) {
            if(!cazzo.isDefault()){
                cazzo.setExpressionMatch(valorMatch);
                cazzo.setTipoValorMatch(this.expression.tipo.getTipo()  );
                //si al interpretar el caso y retorna true Cortar el ciclo
                var resultadoDelCaso = cazzo.interpretar(arbol, newTable);      //execute instructions
                if(resultadoDelCaso instanceof Errores){
                    return resultadoDelCaso;
                }
                if(resultadoDelCaso.equals(true)){
                    noMatch = true;
                    System.out.println("EJECUTANDO UN CASO DENTRO DEL MATCH");
                    return null;
                }
            }    
        }
        if(!noMatch){                           //execute instructions del default
            if(insOfDefault!=null){     //validacion si no hay default
                for (Instruction insDef : insOfDefault) {
                    var resultIns = insDef.interpretar(arbol, newTable);
                    if(resultIns instanceof Errores){
                        return resultIns;
                    }
                }
            }
        }
        
        
//        match "wi" {
//            "algo"     => { println("algoooo.");}
//            "nada"   => { println("nadaaaaa");}
//              _=>{ println("ningunaaaa");}
//        }
        
        return null;
    }

    public void setDefault() {
        for (CaseMatch cazzo : this.cazzos) {
            if(cazzo.isDefault()){
                this.insOfDefault = cazzo.getInstructionss();
            }
        }
        
    }
    public CaseMatch getDefault() {
        CaseMatch casee = null;
        for (CaseMatch cazzo : this.cazzos) {
            if(cazzo.isDefault()){
                casee = cazzo;
            }
        }
        return casee;
        
    }
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
    
        @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        String armed = "";
        C3d_Java c = arbol.getJava();
        
        String idSalida = "salida" + c.contador;
        c.contador++;
        String idDef = "";
                            //identificar el default del resto de casos
        CaseMatch caseDef = getDefault();

        
                                    //create a la expression
 
        armed += this.expression.createC3D(arbol, anterior);
      
        String valMatch = c.varsParams.get(0);
        c.varsParams.remove(0);
        
        
        
        int idSwitch = c.contador;
        c.contador++;
        
        if(caseDef!=null ){
            cazzos.remove(caseDef);
            idDef = "deff"  + c.contador;
            c.contador++;
            caseDef.setIdLabel(idDef);
            caseDef.setIdSalida(idSalida);
            caseDef.setIdNextCase(idSalida);
            
        }
        
        
        for (int i = 0; i < cazzos.size(); i++) {
            cazzos.get(i).setValStringMatch(valMatch);
            cazzos.get(i).setIdSalida(idSalida);
            cazzos.get(i).setIdLabel("case" + idSwitch + "_" +i);
                              
            if((cazzos.size()-1) == i ){
                if(caseDef != null){
                    cazzos.get(i).setIdNextCase(idDef);
                }else{
                    cazzos.get(i).setIdNextCase(idSalida);
                }
            }
        }
 
                                    //set label del siguiente caso 
        for (int i = 0; i < cazzos.size(); i++) {
            if(!(cazzos.size()-1 == i)){

                cazzos.get(i).setIdNextCase(cazzos.get(i+1).getIdLabel());
            }
        }
        
        
         
        
                                //crear el codigo 3D
        for (CaseMatch cazzo : cazzos) {
            armed += cazzo.createC3D(arbol, anterior);

        }
         
                            //crear el codigo 3D del default
        if(caseDef!=null){
            armed += caseDef.createC3D(arbol, anterior);
        } 
        
        armed += idSalida + ":\n";
        
        
        return armed;
    }
}
