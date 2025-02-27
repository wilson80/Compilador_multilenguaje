/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.poo;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.instrucciones.Statement;
import com.wilsoncys.compi1.java.model.instrucciones.transferReturn;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class Mainn extends Instruction{
    public String id;
    public LinkedList<HashMap> parameters;
    public LinkedList<Instruction> instrucciones;
    private int cantParams = 0;
    private int cantAttb = 0;

    private List<String>  ambito;   //idclase/metodo/params
    private boolean isCreate = false;
    private AmbitoMetodo ambitoContent;
    
    
    public Mainn(String id, LinkedList<HashMap> parametros, LinkedList<Instruction> instrucciones, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
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
        return "";
    }   
    
    
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
                //dir ref
        //retorno
        //dir dir ret
        //desde la clase se le hace set a la cantidad de params
                                                            //pte
//        cantParams++;
        for (Instruction ins : instrucciones) {
            if(ins instanceof Statement st){
                //ambito
                Simbolo sym = new Simbolo(st.tipo, st.id, "", false);
                sym.setCat(categoria.VARL);
                sym.setDir(cantParams);
                sym.setInstruction(ins);
                sym.setAmbito(ambito);
                sym.armarAmbito(st.id);
                if(!(tabla.addSsymbolPre(sym))){
                    arbol.addError(new Errores("SEMANTIC", "El simbolo ya existe: " + st.id , st.line, st.col));
                }
                
                cantParams++;
            }
        } 
        
        
        return "";
    }
        
    
            @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        setPos(arbol);
        String armed = "";
        C3d_Java c = arbol.getJava();
//        C3d_Java c = new C3d_Java();

        String posPrepared = "" + this.cantParams;


        String idRetorno ="retorno" + c.contador;
        c.contador++;
                                    //label de retorno
//        arbol.setLabelRetorno(idRetorno);
        
        
         this.ambitoContent = new AmbitoMetodo(posPrepared, idRetorno, this.ambito);
        List<String> ambitoAntList = new ArrayList<>(arbol.getCurrentAmbit());
        arbol.setCurrentAmbit(this.ambito);

        
        
        String bodyMet = "";
//        String ambitoAnt = arbol.getCurrentAmbit().get(1);
    
         //reservar el espacio en el  heap
        bodyMet += c.c3d_reserveHeap(ambitoContent.getVars(), arbol.getSizeHeap());
        
        //set a la referencia (stack[0])
        bodyMet += c.c3d_asignVal("int", ambitoContent.getVars(), 0);
        
        
        
        
        for (Instruction ins : instrucciones) {
            if(ins ==null){
                    continue;
            }

            bodyMet += ins.createC3D(arbol, this.ambitoContent);
            arbol.setAmbito(this.ambito);
//            arbol.getCurrentAmbit().set(1, ambitoAnt);
        }
        arbol.setCurrentAmbit(ambitoAntList);
        
        bodyMet += idRetorno + ":\n";
        bodyMet += "    cout<< \"\";";
        
         
                            //creando la declaracion de vars del ambito
        armed += this.ambitoContent.getDeclar() + "\n";
        armed += bodyMet;
                
        armed = c.c3d_metodo(this.getAmbito_asID(), armed);
        arbol.addPrototipo(getAmbito_asID());
        
        
        if(!isCreate){
            arbol.Print(armed);       
            isCreate = true;
        }
        
        
        
        
        
        return "";
    }

    
    
    
    
    
    
    
    
    public void setCantParams(int cantParams) {
        this.cantParams = cantParams;
    }

    public int getCantParams() {
        return cantParams;
    }

    public List<String> getAmbito() {
        return ambito;
    }

 
    
    
    public void setAmbito(List<String> ambito) {
        this.ambito = new LinkedList<>();
        for (String st : ambito) {
            this.ambito.add(st);
        }
    }
    
    public String getAmbito_asID(){
        String ambi = "";
        for (String st : ambito) {
            ambi +=st;
        }
        return ambi; 
                
    }

    
    public boolean isIsCreate() {
        return isCreate;
    }

    public void setIsCreate(boolean isCreate) {
        this.isCreate = isCreate;
    }

    public int getCantAttb() {
        return cantAttb;
    }

    public void setCantAttb(int cantAttb) {
        this.cantAttb = cantAttb;
    }
    
    
            
    
    
}
