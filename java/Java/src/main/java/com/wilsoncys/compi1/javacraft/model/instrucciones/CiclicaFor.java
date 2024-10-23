/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.instrucciones;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.tablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */

public class CiclicaFor extends Instruction {

    private Instruction assignment;
    private Instruction condicion;
    private Instruction actualizacion;
    private LinkedList<Instruction> instrucciones;

    public CiclicaFor(Instruction asignacion, Instruction condicion, Instruction actualizacion, LinkedList<Instruction> instrucciones, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.assignment = asignacion;
        this.condicion = condicion;
        this.actualizacion = actualizacion;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        System.out.println("Ejecutando un ciclo");
        //crear el entorno
        var newTabla = new tablaSimbolos(tabla);
        
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
            var newTabla2 = new tablaSimbolos(newTabla);

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
}