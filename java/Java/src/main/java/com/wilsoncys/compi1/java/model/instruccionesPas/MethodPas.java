/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instruccionesPas;


import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.instrucciones.Statement;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jonwil
 */
public class MethodPas extends Instruction{
    public String id;
    public LinkedList<HashMap> parameters;
    public LinkedList<Instruction> localDeclaraTions;
    public LinkedList<Instruction> instrucciones;
    private int cantParams = 0;
    private List<String>  ambito;   //idclase/metodo/params
    
    
    private AmbitoMetodo ambitoContent;

    
   public MethodPas(String identificator, LinkedList<HashMap> parameters, LinkedList<Instruction> instrucciones,
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
        
        
        for (var instruct : this.instrucciones) {
            
            if (instruct == null) {
                    continue;
            }
             
//            if(instruct instanceof transferReturn){  //puede venir una instruccion dentro del metodo de tipo return
//                return null; 
//            }
//            if(instruct instanceof transferReturn){
//                return instruct;
//            }
            if(instruct instanceof transferReturn_eliminar){
                return instruct;
            }
            // el problema de eso ^^ es que no la expresion podria retornar // Verify
//            algo que no es y el error tiene que ser devuelto por la llamada y no por la asignacion
            var ressult = instruct.interpretar(arbol, table);
            if(ressult instanceof transferReturn_eliminar){
                return ressult;
            }
            if(ressult instanceof transferReturn_eliminar){
                return ressult;
            }
            
            
            if(ressult instanceof Errores error){
                arbol.addError(error);
            }
            
//            if(ressult instanceof transferReturn){
//                return null; 
//            }
            
        }
        
        return null;
    }
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
 
  

    public LinkedList<Instruction> getLocalDeclaraTions() {
        return localDeclaraTions;
    }

 

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        for (Instruction vars : localDeclaraTions) { 
            if(vars instanceof StatementPas st){
                for (String idx : st.getIds()) {
                    
                    //ambito
                    Simbolo sym = new Simbolo(st.tipo, st.id, tabla, false);
                    sym.setCat(categoria.VARL);
                    sym.setDir(cantParams);
                    sym.setInstruction(vars);
                    sym.setAmbito(ambito);
                    sym.armarAmbito(idx);
                    if( !tabla.addSsymbolPas(sym)){
                        return (new Errores("semantic", "el la variable con id: " + idx + " ya existe", line, col));

                    }
                    cantParams++;
                }
                 
            }
            
            
        }
        
        
        return null;
    }

    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        setPos(arbol);
        String armed = "";
        C3d c = arbol.getC3d();
        
        String devVars = "";
        int iniVars = c.contador;
                        //ambito anterior
        
        String idRetorno ="retorno" + c.contador;
        c.contador++;
        
        arbol.setCurrentAmbit(this.ambito);
        String bodyMet = "";
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }

            String posPrepared = "" + this.cantParams;
            this.ambitoContent = new AmbitoMetodo(posPrepared, idRetorno, this.ambito);
            var result =ins.createC3D(arbol, this.ambitoContent);
            if(result instanceof  Errores){
                return result;
            }else{
                bodyMet += result; 
            }
        }
        
        bodyMet += idRetorno + ":\n";
        bodyMet += "    cout<< \" \";";
        
        int finVars = c.contador;

        for (int i = iniVars; i < finVars; i++) {
            devVars += "int w" + i+  ";\n";
        }
            
        armed = devVars + "\n";
        armed += bodyMet;
        
        
//        armed = c.c3d_metodo("java_" + arbol.getCurrentAmbit().get(1) +"_"+ id, armed);
        armed = c.c3d_metodo(arbol.getAmbito_asID(), armed);
        
     
        arbol.Print(armed);
 
     
        
        
        return armed;
        
        
        
        
        
        
        
        
        
    }

    public void setAmbito(List<String> ambito) {
        this.ambito = ambito;
    }

    public List<String> getAmbito() {
        return ambito;
    }

    public void setCantParams(int cantParams) {
        this.cantParams = cantParams;
    }

    public int getCantParams() {
        return cantParams;
    }
 
    

    
}
