/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.expresiones;

import com.wilsoncys.compi1.java.model.expresiones.Enums.Relational_LogicalOperations;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.LinkedList;
/**
 *
 * @author Jonwil
 */

public class OperateRelacionales extends Instruction {

    private Instruction operando1;
    private Instruction operando2;
    private Relational_LogicalOperations relacion;
    private Object opIzq = null;
    private Object opDer = null;


    //cualquier operacion menos negacion
    public OperateRelacionales(Instruction operando1, Instruction operando2, Relational_LogicalOperations relacion, int linea, int col) {
        super(new Tipo(tipoDato.BOOLEANO), linea, col);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.relacion = relacion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        opIzq = this.operando1.interpretar(arbol, tabla);
        if (opIzq instanceof Errores) {
            return opIzq;
        }
        opDer = this.operando2.interpretar(arbol, tabla);
        if (opDer instanceof Errores) {
            return opDer;
        }
        return  IdentificarTipos(opIzq, opDer);
    }

    
     public Object IdentificarTipos(Object obj1, Object obj2){
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();
        
        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
        
                        switch (relacion) {
                            case MAYOR->{
                                return (int) obj1 > (int) obj2;
                            }
                            case MENOR->{
//                                System.out.println("entrando en el menor");
//                                System.out.println(obj1);
//                                System.out.println(obj2);
                                
//                                System.out.println((Integer) obj1 < (Integer) obj2);
//                                System.out.println("saliendo en el menor");
                                
                                return (int) obj1 < (int) obj2;
                            }   
                            case MAYOR_IGUAL->{
                                return (int) obj1 >= (int) obj2;
                            }
                            case MENOR_IGUAL->{
                                return (int) obj1 <= (int) obj2;
                            }
                            case IGUALA->{
//                                System.out.println("__________________");
//                                System.out.println("entrando en el igual");
//                                System.out.println((Integer) obj1 == (Integer) obj2);
//                                System.out.println("__________________");
                                return (int) obj1 == (int) obj2;
                            }
                            case DIFERENTEQUE->{
                                return (int) obj1 != (int) obj2;
                            }
                            default->{
                                return  new Errores("SEMANTICO","al operar entero con Entero", this.line, this.col );
 
                            }
                        }
                    }
                    case DECIMAL -> {
                        switch (relacion) {
                            case MAYOR->{
                                return (int) obj1 > (double) obj2;
                            }
                            case MENOR->{
                                return (int) obj1 < (double) obj2;
                            }
                            case MAYOR_IGUAL->{
                                return (int) obj1 >= (double) obj2;
                            }
                            case MENOR_IGUAL->{
                                return (int) obj1 <= (double) obj2;
                            }
                            case IGUALA->{
                                return (int) obj1 == (double) obj2;
                            }
                            case DIFERENTEQUE->{
                                return (int) obj1 != (double) obj2;
                            }
                            default->{
                                return  new Errores("SEMANTICO","al operar entero con Decimal", this.line, this.col );
                            }
                        }                        
                    }
                    case BOOLEANO->{
                        int dos;
                                if(obj2.toString().equals("true")){
                                     dos = 1; 
                                }else{
                                     dos = 0; 
                                }
                        switch (relacion) {
                            case MAYOR->{
                                
                                return (int) obj1 > dos;
                            }
                            case MENOR->{
                                return (int) obj1 < dos;
                            }
                            case MAYOR_IGUAL->{
                                return (int) obj1 >= dos;
                            }
                            case MENOR_IGUAL->{
                                return (int) obj1 <= dos;
                            }
                            case IGUALA->{
                                return (int) obj1 == dos;
                            }
                            case DIFERENTEQUE->{
                                return (int) obj1 != dos;
                            }
                            default->{
                                return  new Errores("SEMANTICO","al operar entero con bolllll", this.line, this.col );
 
                            }
                        }
                        
//                        return  new Errores("SEMANTICO","NO se puede operar un entero con uxn Booleano", this.line, this.col );
                        
                    }
                    case CADENA->{
                        return  new Errores("SEMANTICO","NO se puede operar un entero con una cadena", this.line, this.col );
                    }
                    
                    case CARACTER -> {
                        char caracter = obj2.toString().charAt(0);
                        int secondOperador = caracter;
                        switch (relacion) {
                            case MAYOR->{
                                return (int) obj1 > secondOperador;
                            }
                            case MENOR->{
                                return (int) obj1 < secondOperador;
                            }
                            case MAYOR_IGUAL->{
                                return (int) obj1 >=  secondOperador;
                            }
                            case MENOR_IGUAL->{
                                return (int) obj1 <=  secondOperador;
                            }
                            case IGUALA->{
                                return (int) obj1 == secondOperador;
                            }
                            case DIFERENTEQUE->{
                                return (int) obj1 !=  secondOperador;
                            }
                            default->{
                                return  new Errores("SEMANTICO","al operar entero con caracter", this.line, this.col );
                            }
                        }
                    }
                    
                    default->{
                            return  new Errores("SEMANTICO","El 2do. Operando es ilegal al comparar con un Entero", this.line, this.col );
                    }
                }
            }
            
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        switch (relacion) {
                            case MAYOR->{
                                
                                
                                return (double) obj1 > (int) obj2;
                            }
                            case MENOR->{
                                return (double) obj1 < (int) obj2;
                            }
                            case MAYOR_IGUAL->{
                                return (double) obj1 >= (int) obj2;
                            }
                            case MENOR_IGUAL->{
                                return (double) obj1 <= (int) obj2;
                            }
                            case IGUALA->{
                                return (double) obj1 == (int) obj2;
                            }
                            case DIFERENTEQUE->{
                                return (double) obj1 != (int) obj2;
                            }
                            default->{
                                return  new Errores("SEMANTICO","Al operar con Decimal con Entero", this.line, this.col );
 
                            }
                        }
                    }
                    case DECIMAL -> {
                        switch (relacion) {
                            case MAYOR->{
                                return (double) obj1 > (double) obj2;
                            }
                            case MENOR->{
                                return (double) obj1 < (double) obj2;
                            }
                            case MAYOR_IGUAL->{
                                return (double) obj1 >= (double) obj2;
                            }
                            case MENOR_IGUAL->{
                                return (double) obj1 <= (double) obj2;
                            }
                            case IGUALA->{
                                return (double) obj1 == (double) obj2;
                            }
                            case DIFERENTEQUE->{
                                return (double) obj1 != (double) obj2;
                            }
                            default->{
                                return  new Errores("SEMANTICO","al operar Decimal con Decimal", this.line, this.col );
                            }
                        }                        
                    }
                    case BOOLEANO->{
                        return  new Errores("SEMANTIC","NO se puede operar un Decimal con un Booleano", this.line, this.col );
                    }
                    case CADENA->{
                        return  new Errores("SEMANTIC","NO se puede operar un Decimal con una cadena", this.line, this.col );
                    }
                    
                    case CARACTER -> {
                        char caracter = obj2.toString().charAt(0);
                        int secondOperador = caracter;
                        switch (relacion) {
                            case MAYOR->{
                                return (double) obj1 > secondOperador;
                            }
                            case MENOR->{
                                return (double) obj1 < secondOperador;
                            }
                            case MAYOR_IGUAL->{
                                return (double) obj1 >=  secondOperador;
                            }
                            case MENOR_IGUAL->{
                                return (double) obj1 <=  secondOperador;
                            }
                            case IGUALA->{
                                return (double) obj1 == secondOperador;
                            }
                            case DIFERENTEQUE->{
                                return (double) obj1 !=  secondOperador;
                            }
                            default->{
                                return  new Errores("SEMANTICO","al operar entero con caracter", this.line, this.col );
                            }
                        }
                    }
                    default->{
                            return  new Errores("SEMANTICO","El 2do. Operando es ilegal al comparar con un Decimal", this.line, this.col );
                    }
                }                
                
            }
            
            case BOOLEANO -> {
                int firstOp;
                if(obj1.toString().equals("true")){
                    firstOp = 1;
                }else{
                    firstOp = 0;
                }
                int secondOp;
                if(obj2.toString().equals("true")){
                    secondOp = 1;
                }else{
                    secondOp= 0;
                }
                switch (tipo2) {
                    case BOOLEANO -> {
                        switch (relacion) {
                            case MAYOR->{
                                return firstOp > secondOp;
                            }
                            case MENOR->{
                                return firstOp < secondOp;
                            }
                            case MAYOR_IGUAL->{
                                return firstOp >= secondOp;
                            }
                            case MENOR_IGUAL->{
                                return firstOp <= secondOp;
                            }
                            case IGUALA->{
                                return firstOp == secondOp;
                            }
                            case DIFERENTEQUE->{
                                return firstOp != secondOp;
                            }
                            default->{
                                return  new Errores("SEMANTICO","Al operar entero con boleano", this.line, this.col );
                            }
                        }
                    }

                    default->{
                            return  new Errores("SEMANTIC","El 2do. operando es ilegal al comparar un booleano", this.line, this.col );
                    }
                }
            }
            
            
            case CARACTER -> {
                char character =  obj1.toString().charAt(0);
                int firstOp = character;
                switch (tipo2) {
                    case ENTERO -> {
                        switch (relacion) {
                            case MAYOR->{
                                return  firstOp > (int) obj2;
                            }
                            case MENOR->{
                                return firstOp < (int) obj2;
                            }
                            case MAYOR_IGUAL->{
                                return firstOp >= (int) obj2;
                            }
                            case MENOR_IGUAL->{
                                return firstOp <= (int) obj2;
                            }
                            case IGUALA->{
                                return firstOp == (int) obj2;
                            }
                            case DIFERENTEQUE->{
                                return firstOp != (int) obj2;
                            }
                            default->{
                                return  new Errores("SEMANTICO","al operar entero con Entero", this.line, this.col );
 
                            }
                        }
                    }
                    case DECIMAL -> {
                        switch (relacion) {
                            case MAYOR->{
                                return firstOp > (double) obj2;
                            }
                            case MENOR->{
                                return firstOp < (double) obj2;
                            }
                            case MAYOR_IGUAL->{
                                return firstOp >= (double) obj2;
                            }
                            case MENOR_IGUAL->{
                                return firstOp <= (double) obj2;
                            }
                            case IGUALA->{
                                return firstOp == (double) obj2;
                            }
                            case DIFERENTEQUE->{
                                return firstOp != (double) obj2;
                            }
                            default->{
                                return  new Errores("SEMANTICO","al operar entero con Decimal", this.line, this.col );
                            }
                        }                        
                    }
                    case BOOLEANO->{
                        return  new Errores("SEMANTICO","NO se puede operar un caracter con un Booleano", this.line, this.col );
                    }
                    case CADENA->{
                        return  new Errores("SEMANTICO","NO se puede operar un caracter con una cadena", this.line, this.col );
                    }
                    
                    case CARACTER -> {
                        char caracter = obj2.toString().charAt(0);
                        int secondOperador = caracter;
                        switch (relacion) {
                            case MAYOR->{
                                return firstOp > secondOperador;
                            }
                            case MENOR->{
                                return firstOp < secondOperador;
                            }
                            case MAYOR_IGUAL->{
                                return firstOp >=  secondOperador;
                            }
                            case MENOR_IGUAL->{
                                return firstOp <=  secondOperador;
                            }
                            case IGUALA->{
                                return firstOp == secondOperador;
                            }
                            case DIFERENTEQUE->{
                                return firstOp !=  secondOperador;
                            }
                            default->{
                                return  new Errores("SEMANTICO","al operar entero con caracter", this.line, this.col );
                            }
                        }
                    }
                    
                    default->{
                            return  new Errores("SEMANTICO","El 2do. Operando es ilegal al comparar con un Entero", this.line, this.col );
                    }
                }
            }
            
            case CADENA->{
                int firstOp = obj1.toString().length();
                int secondOp = obj2.toString().length();
                    switch (tipo2) {
                    case CADENA->{
                        switch (relacion) {
                            case MAYOR->{
                                return firstOp > secondOp;
                            }
                            case MENOR->{
                                return firstOp < secondOp;
                            }
                            case MAYOR_IGUAL->{
                                return firstOp >=  secondOp;
                            }
                            case MENOR_IGUAL->{
                                return firstOp <=  secondOp;
                            }
                            case IGUALA->{
                                return obj1.toString().equalsIgnoreCase(obj2.toString());
                            }
                            case DIFERENTEQUE->{
                                return !(obj1.toString().equalsIgnoreCase(obj2.toString()));
                            }
                            default->{
                                return  new Errores("SEMANTICO","al operar entero con caracter", this.line, this.col );
                            }
                        }
                        
                    }
                    default->{
                        return  new Errores("SEMANTIC","El 2do. operando es ilegal al realizar ", this.line, this.col );
                    }
                }
            }
                    
                
            default->{
                return  new Errores("SEMANTIC","El 1er. operando es ilegal al realizar una comparacion", this.line, this.col );
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
    public Object createC3D(Arbol arbol, String anterior) {
         String armed = "";
        String op1 = "";
        String op2 = "";
          
        C3d_Java c=  arbol.getJava();
        c.varsParams = new LinkedList<>();
        
        
        if(operando1 instanceof Nativo){        
            operando1.createC3D(arbol, anterior);   //inser en la lista
            op1 = c.varsParams.get(0);
            c.varsParams.removeFirst();
//            armed+=c.c3d_asignAlone(op1);
//            op1 = c.varsParams.get(0);
//            c.varsParams.removeFirst();
            
        }else{
            armed+=operando1.createC3D(arbol, anterior);
            op1 = c.varsParams.get(0);
            c.varsParams.removeFirst();
            
        }
        
        if(operando2 instanceof Nativo){            
            operando2.createC3D(arbol, anterior);   //inser en la lista
            op2 = c.varsParams.get(0);
            c.varsParams.removeFirst();
//            armed+=c.c3d_asignAlone(op2);
//            op2 = c.varsParams.get(0);
//            c.varsParams.removeFirst();
        }else{
            armed+=operando2.createC3D(arbol, anterior);
            op2 = c.varsParams.get(0);
            c.varsParams.removeFirst();
        }
           
         switch (relacion) {
                            case MAYOR->{
                                c.setOPRT(">");
                                break;
                            }
                            case MENOR->{
                                c.setOPRT("<");
                                break;
                            }   
                            case MAYOR_IGUAL->{
                                c.setOPRT(">=");
                                break;
                            }
                            case MENOR_IGUAL->{
                                c.setOPRT("<=");
                                break;
                            }
                            case IGUALA->{
                                c.setOPRT("==");
                                break;
                            }
                            case DIFERENTEQUE->{
                                c.setOPRT("!=");
                                break;
                            }
                            default->{
                                return  new Errores("SEMANTICO","al operar entero con Entero", this.line, this.col );
 
                            }
                        }
        
//        armed+=c.c3d_operationRelation(op1, op2);
        c.clearVarParams();
        c.varsParams.add(op1);   
        c.varsParams.add(op2);
        
        return armed;
    }
    
}