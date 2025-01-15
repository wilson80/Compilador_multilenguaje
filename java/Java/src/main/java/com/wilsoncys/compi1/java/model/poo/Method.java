/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.poo;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.Statement;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.instrucciones.transferReturn;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class Method extends Instruction{
    public String id;
    public String idClase = "";
    public LinkedList<HashMap> parameters;
    public LinkedList<Instruction> instrucciones;
    private boolean isCreate = false;
    private int cantParams = 0;
    private int cantAttb = 0;

    private List<String>  ambito;   //idclase/metodo/params
    private int cantSyms = 0;
    
    private AmbitoMetodo ambitoContent;    


    public Method(String id, LinkedList<HashMap> parametros, LinkedList<Instruction> instrucciones, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.id = id;
        this.parameters = parametros;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos table) {
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
            if(instruct instanceof transferReturn){
                return instruct;
            }
            // el problema de eso ^^ es que no la expresion podria retornar // Verify
//            algo que no es y el error tiene que ser devuelto por la llamada y no por la asignacion
            var ressult = instruct.interpretar(arbol, table);
            if(ressult instanceof transferReturn){
                return ressult;
            }
            if(ressult instanceof transferReturn){
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
        String algo = anterior;
        for (Instruction ins : instrucciones) {
            algo = ins.generarast(arbol, algo);
            
        }
        
        return algo;
    }
    
    
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
 
        for (Instruction ins : instrucciones) {
            if(ins instanceof Statement st){
                //ambito
                Simbolo sym = new Simbolo(st.tipo, st.id, tabla, true);
                sym.setCat(categoria.VARL);
                sym.setDir(cantParams);
                sym.setInstruction(ins);
                sym.setAmbito(ambito);
                sym.armarAmbito(st.id);
                tabla.addSsymbolPre(sym);
                cantParams++;
            }
        } 
        
        return null;
    }
        
    
    
    
    
            @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        setPos(arbol);
        String armed = "";
        C3d_Java c = arbol.getJava();
//         C3d_Java c = new C3d_Java();

        String idRetorno ="retorno" + c.contador;
        c.contador++;
                                    //label de retorno
//        arbol.setLabelRetorno(idRetorno);
                        
                        
        
        List<String> ambitoAntList = new ArrayList<>(arbol.getCurrentAmbit());
        String posPrepared = "" + this.cantParams;
        this.ambitoContent = new AmbitoMetodo(posPrepared, idRetorno, this.ambito);
        arbol.setCurrentAmbit(this.ambito);

        
        String bodyMet = "";
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }

            bodyMet +=  ins.createC3D(arbol, this.ambitoContent);
            arbol.setCurrentAmbit(this.getAmbito());

        }       
        arbol.setCurrentAmbit(ambitoAntList);
        
        bodyMet += idRetorno + ":\n";
//        bodyMet += arbol.getLabelRetorno() + ":\n";
        bodyMet += "    cout<< \" \";";
        
    
        armed += this.ambitoContent.getDeclar();
        armed += bodyMet;
        
        
        armed = c.c3d_metodo(this.getAmbito_asID(), armed);
        arbol.addPrototipo(getAmbito_asID());
        
        
        
        if(!isCreate){
            arbol.Print(armed);
            this.isCreate = true;
        }
        
        return "";
    }

     
    
    
    public void setCantParams(int cantParams) {
        this.cantParams = cantParams;
    }

    public int getCantParams() {
        return cantParams;
    }

    public void setAmbito(List<String> ambito) {
        this.ambito = ambito;
    }

    public List<String> getAmbito() {
        return ambito;
    }

    public String getIdClase() {
        return idClase;
    }

    public void setIdClase(String idClase) {
        this.idClase = idClase;
    }

    public int getCantAttb() {
        return cantAttb;
    }

    public void setCantAttb(int cantAttb) {
        this.cantAttb = cantAttb;
    }
        public String getAmbito_asID(){
        String ambi = "";
        for (String st : this.ambito) {
            ambi +=st;
        }
        return ambi; 
                
    }
      
}
