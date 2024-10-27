/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.model.instrucciones;

import com.wilsoncys.compi1.javacraft.model.asbtracto.Instruction;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.expresiones.Access;
import com.wilsoncys.compi1.javacraft.model.simbolo.Arbol;
import com.wilsoncys.compi1.javacraft.model.simbolo.Simbolo;
import com.wilsoncys.compi1.javacraft.model.simbolo.Tipo;
import com.wilsoncys.compi1.javacraft.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.javacraft.model.simbolo.tipoDato;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jonwil
 */
public class FunctionToString extends Instruction{
    private Instruction expression;

    public FunctionToString(Instruction Expression, int linea, int col) {
        super(new Tipo(tipoDato.CADENA), linea, col);
        this.expression = Expression;
    }


    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        String newVlue = null;
        
        //verificar si es un struct
        if(expression instanceof Access acc){
//        acceder al acceso del struct simple por el momento
//        revisar el set(tipo del struct del simbolo) de un strutc
            Simbolo sim = tabla.getSsymbol(acc.id);
            if(sim==null){
                return new Errores("SEMANTIC", "No se encontro (en toString)la variable: ", line, col);
            }
            if(sim.getValor() instanceof HashMap hss){
                String cadd = "{";
//                hss.forEach((key, value) -> sb.append("{").append(value).append("\n"));
//                newVlue = sb.toString();
                HashMap<String, Object> hashFirst = hss;

             // Recorrer el HashMap y guardar las claves y valores
                 for (Map.Entry<String, Object> entry : hashFirst.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if(value instanceof HashMap hasAnid){
                        System.out.println("Un simbolooooooooooooooooooooooooooooo");
                        HashMap<String, Object> hashSecond = hasAnid;
                        cadd +="{";
                        for (Map.Entry<String, Object> AE : hashSecond.entrySet()) {
                            String key2 = AE.getKey();
                            Object value2 = AE.getValue();
                            
                            Simbolo simw = (Simbolo)value2;
                            String valor = simw.getValor().toString();
                            cadd +=key2;
                            cadd +="--";
                            cadd +=valor;
                            cadd +="--";
                        }
                        cadd +="}";
                        continue;
                    }
                    
                    Simbolo simw = (Simbolo)value;
                    String valor = simw.getValor().toString();
                    cadd +=key;
                    cadd +="--";
                    cadd +=valor;
                    cadd +="--";
                     
                 }
                 cadd +="}";
                 newVlue = cadd.toString();

                 
            }else{
                var valueExp = this.expression.interpretar(arbol, tabla);
                if(valueExp instanceof Errores){
                    return valueExp; 
                }

                newVlue = valueExp.toString();
            }
        }else{
        //interpretar la exp
            var valueExp = this.expression.interpretar(arbol, tabla);
            if(valueExp instanceof Errores){
                return valueExp; 
            }

            newVlue = valueExp.toString();
            
        }
        

        

        

        return newVlue;
    }
    
    
    
    @Override
    public String generarast(Arbol arbol, String anterior) {
        return "";
    }
        public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        return null;
    }
        
            @Override
    public Object createC3D(Arbol arbol, String anterior) {
        return anterior;
    }
    
    
}
