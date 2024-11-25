/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.instrucciones;

import com.wilsoncys.compi1.java.model.instrucciones.*;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
 
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.LinkedList;

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
                if (i instanceof transferBreakC) {
                    return null;
                }
                if (i instanceof transferContinueC) {
                    System.out.println("continue1");
                    break;
                }
                if (i instanceof transferReturnC) {
                    return i;
                }
                var resIns = i.interpretar(arbol, newTabla2);   //Instrucciones del ciclo
                
                if (resIns instanceof transferReturnC) {
                    return resIns;
                }

                if (resIns instanceof Errores) {        //identificar el error
                    return resIns;
                }
                if (resIns instanceof transferContinueC) {
                    System.out.println("continue2");
                    break;
                }
                if (resIns instanceof transferBreakC) {
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
    public Object createC3D(Arbol arbol, String anterior) {
        return anterior;
    }
    
}