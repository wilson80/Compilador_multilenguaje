/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.instrucciones;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.simbolo.*;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 *
 * @author yoyo
 */
public class Print extends Instruction {

    private Instruction expresion;

    public Print(Instruction expresion, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var resultado = this.expresion.interpretar(arbol, tabla);
        if (resultado instanceof Errores) {
//            arbol.Print(resultado.toString());
            return resultado;
        }
        if(resultado  == null ){
            return new Errores("SEMANTIC", "recibiendo valor Null en Print", line, col);
        }
//        arbol.Print(resultado.toString());
        arbol.Print(StringEscapeUtils.unescapeJava(resultado.toString()));
        return null;
    }
@Override
    public String generarast(Arbol arbol, String anterior) {        // PRINTT -> PRINT ( EXP ) ;
        String nodoPP = "n" + arbol.getCount();
        String nodoP = "n" + arbol.getCount();
        String nodoP1 = "n" + arbol.getCount();
        String nodoExp = "n" + arbol.getCount();
        String nodoP2 = "n" + arbol.getCount();
        String nodoPC = "n" + arbol.getCount();

        String resultado = nodoPP + "[label=\"PRIN`T\"];\n";
        resultado += anterior + " -> " + nodoPP + ";\n";

        resultado += nodoP + "[label=\"println\"];\n";
        resultado += nodoP1 + "[label=\"(\"];\n";
        resultado += nodoExp + "[label=\"EXPRESION\"];\n";
        resultado += nodoP2 + "[label=\")\"];\n";
        resultado += nodoPC + "[label=\";\"];\n";

        resultado += nodoPP + " -> " + nodoP + ";\n";
        resultado += nodoPP + " -> " + nodoP1 + ";\n";
        resultado += nodoPP + " -> " + nodoExp + ";\n";
        resultado += nodoPP + " -> " + nodoP2 + ";\n";
        resultado += nodoPP + " -> " + nodoPC + ";\n";

        resultado += this.expresion.generarast(arbol, nodoExp);

        return resultado;
    }
    
    
}
