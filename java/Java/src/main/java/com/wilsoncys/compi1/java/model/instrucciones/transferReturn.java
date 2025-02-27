/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instrucciones;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores; 
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato; 
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class transferReturn extends Instruction{
    public Instruction expression = null;

    public transferReturn(Instruction expression, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expression = expression;
    }
    
    
    public transferReturn(int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
    }

    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        //interpretar la exp
        var exp = expression.interpretar(arbol, tabla);
        this.tipo.setTipo(this.expression.tipo.getTipo());
        if(exp instanceof  Errores){
           return  exp;
        }else{
            return exp;
        }
    }
    
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
        public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
        
            @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo ambito) {
        String armed = "";
        C3d_Java c =  arbol.getJava();
        
        //create exp
        armed+=this.expression.createC3D(arbol, ambito);
       //VALIdar el tipo del retorno
    
//        c.varsParams.remove(0);
        this.tipo = this.expression.tipo;

 
        
//        if(this.id.equals("getContenido")){
//            JOptionPane.showMessageDialog(null, ">>>>>>> " + symMethod.getTySim() );
//        }
        armed+=c.c3d_asignVal(this.getTyStr(), ambito.getVars(), 1);
        
        armed += "goto " + ambito.getLabelReturn()+ ";\n";
         
        
        return armed;
    }
    
}
