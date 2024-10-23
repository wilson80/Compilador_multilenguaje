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

/**
 *
 * @author Jonwil
 */
public class FunctionRound extends Instruction{
    private Instruction expression;

    public FunctionRound(Instruction expression, int linea, int col) {
        super(new Tipo(tipoDato.ENTERO), linea, col);
        this.expression = expression;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        //interpretar la expresion
        var valueExp = expression.interpretar(arbol, tabla);
        if(valueExp instanceof Errores){
            return valueExp;
        }
        //validar el tipo
        if(expression.tipo.getTipo()!=tipoDato.DECIMAL && expression.tipo.getTipo()!=tipoDato.ENTERO ){
            mensErr = "Tipo de dato Erroneo, no soporta la funcion ROUND";
            return new Errores("SEMANTIC", mensErr, this.expression.line, this.expression.col);
        }
        int result = 0;
/*
5.4-1 = 4.4
5.4-0.5

*/
        double valuee = (double)valueExp;
        int copia = (int)valuee;        
        double retultado = valuee - 0.5;
        int finall = (int)retultado;
        
        
        if(copia ==finall){
            result = ((int)retultado) + 1;
        }else{
            result = copia;
        }
                
//        System.out.println("roundd: " + result);
        
        return result;
    }
    
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
    
    
}
