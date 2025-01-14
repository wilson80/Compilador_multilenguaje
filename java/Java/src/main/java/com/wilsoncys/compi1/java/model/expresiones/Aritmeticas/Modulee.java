/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.expresiones.Aritmeticas;



import com.wilsoncys.compi1.java.model.asbtracto.CreadorC3d;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.Enums.OperadoresAritmeticos;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
/**
 *
 * @author Jonwil
 */


public class Modulee extends Instruction {

    private Instruction operando1;
    private Instruction operando2;
    private OperadoresAritmeticos operacion;


    //cualquier operacion menos negacion
    public Modulee(Instruction operando1, Instruction operando2, OperadoresAritmeticos operacion, int linea, int col) {
        super(new Tipo(tipoDato.DECIMAL), linea, col);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object opIzq = null;
        Object opDer = null; 
 
        opIzq = this.operando1.interpretar(arbol, tabla);
        if (opIzq instanceof Errores) {
            return opIzq;
        }
        opDer = this.operando2.interpretar(arbol, tabla);
        if (opDer instanceof Errores) {
            return opDer;
        }
        return  Modulo(opIzq, opDer);
    }

    
    
     public Object Modulo(Object obj1, Object obj2){
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();
        
        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double)((int) obj1 % (int) obj2);
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return ((int) obj1 % (double) obj2);
                    }

                    default->{
                            return  new Errores("SEMANTICO","Operando2 diferente de Decimales y enteros, al operar con Mod", this.line, this.col );
                    }
                }
            }
            
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return ((double) obj1 % (int) obj2);
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return ((double) obj1 % (double) obj2);
                    }
                    default->{
                            return  new Errores("SEMANTICO","Operando2 diferente de Decimales y enteros, al operar con Mod", this.line, this.col );
                    }
                }
            }
            default->{
                return new Errores("SEMANTIC", "operando1 diferente de Decimales y enteros, al operar con Mod", line, col);
            }
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
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
                setPos(arbol);
        String armed = "";
        String op1 = "";
        String op2 = "";
          
            C3d_Java c=arbol.getJava();
//        }else{
//             c =  arbol.getC3d();
//        } 
        
        if(operando1 instanceof Nativo){        
            operando1.createC3D(arbol, anterior);   //inser en la lista
            op1 = c.varsParams.get(0);
            c.varsParams.removeFirst();
            armed+=c.c3d_asignAlone(op1);
            op1 = c.varsParams.get(0);
            c.varsParams.removeFirst();
            
        }else{
            armed+=operando1.createC3D(arbol, anterior);
            op1 = c.varsParams.get(0);
            c.varsParams.removeFirst();
            
        }
        
        if(operando2 instanceof Nativo){            
            operando2.createC3D(arbol, anterior);   //inser en la lista
            op2 = c.varsParams.get(0);
            c.varsParams.removeFirst();
            armed+=c.c3d_asignAlone(op2);
            op2 = c.varsParams.get(0);
            c.varsParams.removeFirst();
        }else{
            armed+=operando2.createC3D(arbol, anterior);
            op2 = c.varsParams.get(0);
            c.varsParams.removeFirst();
        }
        
        c.setOPRT("%");
        armed+=c.c3d_operation(op1, op2);
        c.varsParams.add("w"+(c.getContador()-1));  //guarda el id de la var q contiene el resultado

        return armed;
         
    }
    
 
}