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
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.poo.Call;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import java.util.LinkedList;
import javax.swing.JOptionPane;
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
        return "";
    }

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        setPos(arbol);
            String armed = "";
            C3d c = arbol.getC3d();
        
            
        for (Instruction exp : expresioness) {
            if(exp instanceof Nativo){
                String val = (String)exp.createC3D(arbol, anterior);
                armed+=c.c3d_printNativo(val);
                c.clearVarParams();
            }else{
                var algo  = exp.createC3D(arbol, anterior);
                if(algo instanceof Errores){
                    return algo;
                }else{
                    armed+= algo; 
                }
                 
                armed+=c.c3d_printVar();
                c.clearVarParams();
            }
        }   
        
 
            armed+= "cout<<endl;\n";
  
        
        return armed;
         
    }
    
    
}
