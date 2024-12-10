/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instrucciones;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.Access;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.poo.Call;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;  
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 *
 * @author yoyo
 */
public class Prints extends Instruction {
    private boolean ln;
    private  LinkedList<Instruction> expresioness;

    public Prints(LinkedList<Instruction> expresion, boolean ln, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.ln = ln;
        this.expresioness = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        String concatenacion  = "";
        
        for (int i = 0; i <= expresioness.size()-1; i++) {
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
        return null;
    }
        
    
    
    
    
        @Override
    public Object createC3D(Arbol arbol, String anterior) {        
        String armed = "";
            C3d_Java c = arbol.java;
        
        for (Instruction exp : expresioness) {
                    //		println(sumar(num1, num2));
            if(exp instanceof Call){
                armed+= exp.createC3D(arbol, anterior);
                armed+=c.c3d_printVar();
            }else if(exp instanceof Nativo){
                String val= (String)exp.createC3D(arbol, anterior);
                armed+=c.c3d_printNativo(val);
                c.clearVarParams();
            }else{

                armed+= exp.createC3D(arbol, anterior);
                armed+=c.c3d_printVar();
                c.clearVarParams();
            }
        }   
        
        if(ln){
            armed+= "cout<<endl;\n";
        }
        
        return armed;
    }
    
}
