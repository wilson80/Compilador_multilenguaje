/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.instrucciones;

import com.wilsoncys.compi1.java.model.asbtracto.CreadorC3d;
import com.wilsoncys.compi1.java.model.instrucciones.*;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.LogicalOperations;
import com.wilsoncys.compi1.java.model.expresiones.OperateRelacionales;
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

public class CiclicaForC extends Instruction {

    private Instruction assignment;
    private Instruction condicion;
    private Instruction actualizacion;
    private LinkedList<Instruction> instrucciones;

    public CiclicaForC(Instruction asignacion, Instruction condicion, Instruction actualizacion, LinkedList<Instruction> instrucciones, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.assignment = asignacion;
        this.condicion = condicion;
        this.actualizacion = actualizacion;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        System.out.println("Ejecutando un ciclo");
        //crear el entorno
        var newTabla = new TablaSimbolos(tabla);
        
        // asignacion/declaracion
        var res1 = this.assignment.interpretar(arbol, newTabla);
        if (res1 instanceof Errores) {
            return res1;
        }

        //validar la condicion -> Booleano
        var cond = this.condicion.interpretar(arbol, newTabla);
        if (cond instanceof Errores) {
            return cond;
        }

        if (this.condicion.tipo.getTipo() != tipoDato.BOOLEANO) {
            return new Errores("SEMANTICO", "La condicion debe ser bool",
                    this.line, this.col);
        }
        System.out.println("Ejecutando un ciclo");

        while ((boolean) this.condicion.interpretar(arbol, newTabla)) {
            //nuevo entorno
            var newTabla2 = new TablaSimbolos(newTabla);

            //ejecutar instrucciones
            for (var i : this.instrucciones) {
                if(i==null){        //validacion por si hay una instruccion nula
                    continue;
                }
                if (i instanceof transferBreak) {
                    return null;
                }
                if (i instanceof transferContinue) {
                    System.out.println("continue1");
                    break;
                }
                if (i instanceof transferReturn) {
                    return i;
                }
                var resIns = i.interpretar(arbol, newTabla2);   //Instrucciones del ciclo
                
                if (resIns instanceof transferReturn) {
                    return resIns;
                }

                if (resIns instanceof Errores) {        //identificar el error
                    return resIns;
                }
                if (resIns instanceof transferContinue) {
                    System.out.println("continue2");
                    break;
                }
                if (resIns instanceof transferBreak) {
                    return null;
                }
                
            }

            //actualizar la variable
            var act = this.actualizacion.interpretar(arbol, newTabla);
            if (act instanceof Errores) {
                return act;
            }
        }
        return null;
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
        setPos(arbol);
        String armed = "";
        
//        C3d c = arbol.getC3d();   
        CreadorC3d c;   
        if(anterior.getLenguaje().equals("java")){
            c = arbol.getJava();
        }else{
            c = arbol.getC3d();
        }
        
        
//        C3d_Java c = arbol.getJava();
        String idLoop = "label_Loop" + c.contador;
        c.contador++;
        String idSalida = "salida" + c.contador;
        c.contador++;
        String idIns = "label_ins" + c.contador;
        c.contador++;
        
        
        //realizar la asignacion 
        armed+=this.assignment.createC3D(arbol, anterior);
       
        //label loop
        armed +=  idLoop+ ":{}\n" ;

        
        //evalular la condicion
        if(this.condicion instanceof OperateRelacionales){
 
          armed+= this.condicion.createC3D(arbol, anterior);
          String op1 = c.varsParams.get(0); 
          c.varsParams.removeFirst();
          String op2 = c.varsParams.get(0);  
          c.varsParams.removeFirst();
          
          armed+= c.cond_If(op1, op2, idIns, idSalida);
        } 

        
        //INSTRUCCIONES
        //label INS
        armed +=  idIns+ ":{}\n" ;

        for (Instruction ins : instrucciones) {
            if(ins ==null){
                continue;
            }
            armed += ins.createC3D(arbol, anterior);
        }
        
        
        //realizar el incremento
        armed += this.actualizacion.createC3D(arbol, anterior);
        
        armed +=  "goto " + idLoop+ ";\n" ;
        
        armed +=  idSalida+ ":{}\n" ;

         
        
        return armed;
    }
    
}