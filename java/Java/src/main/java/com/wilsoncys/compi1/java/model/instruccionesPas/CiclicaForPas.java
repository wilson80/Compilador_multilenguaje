/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instruccionesPas;

import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.expresiones.Aritmeticas.Suma;
import com.wilsoncys.compi1.java.model.expresiones.Enums.OperadoresAritmeticos;
import com.wilsoncys.compi1.java.model.expresiones.Enums.Relational_LogicalOperations;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.expresiones.OperateRelacionales;
import com.wilsoncys.compi1.java.model.expresionesPas.AccessPas;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.simbolo.*;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */

public class CiclicaForPas extends Instruction {

    private Instruction inicialVal;
    private Instruction finalVal;
    private Instruction actualizacion;
    private String id;
    private LinkedList<Instruction> instrucciones;

    public CiclicaForPas(String id, Instruction initialVal, Instruction finalVal, LinkedList<Instruction> instrucciones, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.inicialVal = initialVal;
        this.finalVal = finalVal;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        System.out.println("Ejecutando un ciclo");
        //crear el entorno
        var newTabla = new TablaSimbolos(tabla);
        
        var inicialValue = this.inicialVal.interpretar(arbol, tabla);
        
        if(this.inicialVal.tipo.getTipo() != tipoDato.ENTERO){
            return new Errores("SEMANTIC", "el valor inicial del ciclo no es de tipo numérico", line, col);
        }
        
        AssignmenttPas asignacion = new AssignmenttPas(id, inicialVal, line, col);
        // asignacion/declaracion
        var res1 = asignacion.interpretar(arbol, newTabla);
        if (res1 instanceof Errores) {
            return res1;
        }
        
        //validar valor final del ciclo
        var cond = this.finalVal.interpretar(arbol, newTabla);
        if (cond instanceof Errores) {
            return cond;
        }
        if (this.finalVal.tipo.getTipo() != tipoDato.ENTERO) {
            return new Errores("SEMANTICO", "El valor final no es un entero",
                    this.line, this.col);
        }
        System.out.println("Ejecutando un ciclo");
        
        Instruction condicionCoump =  new OperateRelacionales(new AccessPas(id, line, col), finalVal, Relational_LogicalOperations.MENOR_IGUAL, line, col);
        
//        id = id + 1;
        Instruction nativo1 = new Nativo(1, new Tipo(tipoDato.ENTERO), line, col);
        
        Instruction suma = new Suma(nativo1, new AccessPas(id, line, col),  OperadoresAritmeticos.NEGACION, line, col);
        actualizacion = new AssignmenttPas(id, suma, line, col);
        
        
        while ((boolean) condicionCoump.interpretar(arbol, newTabla)) {
            //nuevo entorno
            var newTabla2 = new TablaSimbolos(newTabla);

            //ejecutar instrucciones
            for (var i : this.instrucciones) {
                if(i==null){        //validacion por si hay una instruccion nula
                    continue;
                }
                if (i instanceof transferBreakPas) {
                    return null;
                }
                if (i instanceof transferContinuePas) {
                    System.out.println("continue1");
                    break;
                }
                if (i instanceof transferReturn_eliminar) {
                    return i;
                }
                var resIns = i.interpretar(arbol, newTabla2);   //Instrucciones del ciclo
                
                if (resIns instanceof transferReturn_eliminar) {
                    return resIns;
                }

                if (resIns instanceof Errores) {        //identificar el error
                    return resIns;
                }
                if (resIns instanceof transferContinuePas) {
                    System.out.println("continue2");
                    break;
                }
                if (resIns instanceof transferBreakPas) {
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

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
return "";}
}