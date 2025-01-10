/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.instrucciones;

import com.wilsoncys.compi1.java.model.instrucciones.*;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.Access;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.poo.Call;
 
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;  
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 *
 * @author yoyo
 */
public class PrintsC extends Instruction {
    private  LinkedList<String> ids;
    private String cadena;
    public PrintsC(String cadena, LinkedList<String> ids, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.cadena = cadena;
        this.ids = ids;
    }
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        String concatenacion  = "";
        
//        for (int i = 0; i <= ids.size()-1; i++) {
//            var resultado = ids.get(i).interpretar(arbol, tabla);
//            
//            if (resultado instanceof Errores) {
//    //            arbol.Print(resultado.toString());
//                return resultado;
//            }
//            if(resultado  == null ){
//                return new Errores("SEMANTIC", "recibiendo valor Null en Print", line, col);
//            }
//            concatenacion += resultado.toString();
//            
//        }
//        
////        for (Instruction expr : expresioness) {
//            
////        }
//        
//        
//
////        arbol.Print(resultado.toString());
//        arbol.Print(StringEscapeUtils.unescapeJava(concatenacion));
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
        
   
    
    
//    printf("la suma de %d mas %d es igual a %d", x, y, total );
      
    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {        
        String armed = "";
        C3d c = arbol.getC3d();
        
        String [] cadenas = cadena.split("%c|%d|%f"); 
        
        int contador = 0;
        for (String vars : ids) {
            //encontrar el simbolo
            Simbolo sim = arbol.getSym("PROGRAMA" + vars);
            //crear el acceso
            armed += c.c3d_acces(vars, sim.getDir());
            armed += c.c3d_printNativo(cadenas[contador]);
            armed += c.c3d_printVar();
            c.clearVarParams();
            contador++;
        }   
        
        
        
//imprimir las cadenas  
//        printf(“Valor %d”, var);
//            ver que hacer para no imprimir el comodin 
//                        ->>> imfprimir varias variables
        
//        if(ln){
            armed+= "cout<<endl;";
//        }
        
        return armed;
    }
    
}
