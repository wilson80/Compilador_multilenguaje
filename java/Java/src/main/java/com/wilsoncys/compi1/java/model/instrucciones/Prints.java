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
   
//        resultado += this.expresion.generarast(arbol, nodoExp);

        return "";
    }

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
        
    
    
    
    
        @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {  
        setPos(arbol);
        String armed = "";
        C3d_Java c = arbol.getJava();
        
        for (Instruction exp : expresioness) {
                armed+= exp.createC3D(arbol, anterior);
                armed+=c.c3d_printVar();
                c.clearVarParams();
        }   
        
        if(ln){
            armed+= "cout<<endl;\n";
        }
        
        return armed;
    }
    
}
