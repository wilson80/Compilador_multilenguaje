/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instruccionesPas;



import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.simbolo.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class FunctionssPas extends Instruction{
    public String id;
    public LinkedList<HashMap> parameters;
    public LinkedList<Instruction> localDeclaraTions;
    public LinkedList<Instruction> instrucciones;
    public LinkedList<Tipo> tablaTipos;
    public TablaSimbolos tablaSimbolos;
            
    private int cantParams = 0;
    private List<String>  ambito;   //idclase/metodo/params
    
    
    
    public FunctionssPas(String identificator, LinkedList<HashMap> parameters, LinkedList<Instruction> instrucciones,
            LinkedList<Instruction> localDec, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.id = identificator;
        this.parameters = parameters;
        this.instrucciones = instrucciones;
        this.localDeclaraTions = localDec;
    }
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos table) {
        
        for (Instruction localDeclaraTion : localDeclaraTions) {
            
            if(localDeclaraTion instanceof StatementPas){
                var algo = localDeclaraTion.interpretar(arbol, table);
                if(algo instanceof Errores){
                    return algo;
                }
            }
            if(localDeclaraTion instanceof VectorsStatementPas){
                var algo = localDeclaraTion.interpretar(arbol, table);
                if(algo instanceof Errores){
                    return algo;
                }
            }
        }
        
          
        //verificar que halla una instruccion return que devuleva un dato del tipo de la funcion
        for (var instruct : this.instrucciones) {
            if (instruct == null) {
                    continue;
            }
 
//            if(instruct instanceof transferReturn retur){       //verificar si el return no tiene exp de retorno
//                if(retur.expression == null){
//                    return new Errores("SEMANTIC", "La funcion no especifica un valor de retorno", instruct.line, instruct.col);
//                }
//            }
            if(instruct instanceof transferReturn_eliminar){
                return instruct;
            }
            
            var ressult = instruct.interpretar(arbol, table);
            if(ressult instanceof transferReturn_eliminar){
                return ressult;
            }
            
//            if(instruct.tipo.getTipo()!=this.tipo.getTipo()){
//                return new Errores("SEMANTIC", "Valor de retorno con tipo Erroneo", instruct.line, instruct.col);
//            }
            
            if(ressult instanceof Errores error){
                arbol.addError(error);
            }
            
        }
        
        return null;
        
    }
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }

    public void addTipo_Function(Tipo tipo) {
        this.tablaTipos.add(tipo);
    }
    
    public LinkedList<Tipo> getTablaTipos() {
        return tablaTipos;
    }
  
    public LinkedList<Instruction> getLocalDeclaraTions() {
        return localDeclaraTions;
    }

    public void setTabla(TablaSimbolos tabla) {
        this.tablaSimbolos = tabla;
        tablaSimbolos.setNombre(id);
    }

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        for (Instruction vars : localDeclaraTions) {
            if(vars instanceof StatementPas st){
                for (String idx : st.getIds()) {
                    
                    //ambito
                    Simbolo sym = new Simbolo(st.tipo, st.id, tabla, true);
                    sym.setCat(categoria.VARL);
                    sym.setDir(cantParams);
                    sym.setInstruction(vars);
                    sym.setAmbito(ambito);
                    sym.armarAmbito(idx);
                    if( !tabla.addSsymbolPas(sym)){
                        arbol.addError(new Errores("semantic", "el la variable con id: " + idx + " ya existe", line, col));

                    }
                    cantParams++;
                }
                
                
                
            }
        }
                return null;
    }

    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCantParams() {
        return cantParams;
    }

    public void setCantParams(int cantParams) {
        this.cantParams = cantParams;
    }

    public List<String> getAmbito() {
        return ambito;
    }

    public void setAmbito(List<String> ambito) {
        this.ambito = ambito;
    }
    
    
    
    
    
    
}
