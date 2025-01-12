/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instruccionesPas;

import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import java.util.LinkedList;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 *
 * @author yoyo
 */
public class PrintPass extends Instruction {

    private  LinkedList<Instruction> expresioness;

    public PrintPass(LinkedList<Instruction> expresion, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresioness = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        String concatenacion  = "";
        
        for (int i = expresioness.size()-1; i >= 0; i--) {
            var resultado = expresioness.get(i).interpretar(arbol, tabla);
            
            if (resultado instanceof Errores) {
    //            arbol.Print(resultado.toString());
                return resultado;
            }
            if(resultado  == null ){
                return new Errores("SEMANTIC", "recibiendo valor Null en Print", line, col);
            }
            concatenacion += resultado.toString();
            
        }
        
//        for (Instruction expr : expresioness) {
            
//        }
        
        

//        arbol.Print(resultado.toString());
        arbol.Print(StringEscapeUtils.unescapeJava(concatenacion));
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

//        resultado += this.expresion.generarast(arbol, nodoExp);

        return resultado;
    }

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
