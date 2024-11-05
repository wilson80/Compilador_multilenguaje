    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instrucciones;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
public class VectorsStatement extends Instruction{
    public String identificador;
    private boolean isConst;
    private int sizeFilas;
    private int sizeCol;
    
    private LinkedList<Instruction> valuesVect;
    private LinkedList<LinkedList<Instruction>> valuesVect2D = null;
    private Object vectorzito[];
    private Object vectorzito2D[][];


//    public VectorsOneD(String identificador, boolean isConst, LinkedList<Instruction> valuesVect, Tipo tipo, int linea, int col) {
//        super(tipo, linea, col);
//        this.identificador = identificador;
//        this.isConst = isConst;
//        this.valuesVect = valuesVect;
//    }

    public VectorsStatement(String identificador, boolean isConst, LinkedList<Instruction> valuesVect, LinkedList<LinkedList<Instruction>> valuesVect2D, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.identificador = identificador;
        this.isConst = isConst;
        this.valuesVect = valuesVect;
        this.valuesVect2D = valuesVect2D;
    }
    
    
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        if(valuesVect2D!=null){
            return this.vectors2D(arbol, tabla);
            }
            
        //difinir tamanno
        this.sizeFilas = valuesVect.size();
        
//        crear el vector 
        vectorzito = new Object[sizeFilas];

        int contador = 0;
        for (Instruction val : valuesVect) {            //ciclo
//        interpretar los valores
            var valor = val.interpretar(arbol, tabla);
            if(valor instanceof Errores){
                return valor;
            }
//        verificar que el tipo de cada valor coincida con el tipo declarado
                                if(val.tipo.getTipo() != this.tipo.getTipo()){
                                    mensErr = "Tipo del valor Erroneo al asignar al del vector con ID: " + identificador;
                                    return new Errores("SEMANTIC", mensErr, val.line, val.col);
                                }
            vectorzito[contador] = valor;       //      introducir el valor al vector
            contador++;
        }

//        crear el newSimboll
          Simbolo newSimbol = new Simbolo(this.tipo, this.identificador, this.vectorzito, this.isConst);
          newSimbol.setLinea(line);
          newSimbol.setLinea(col);
//        insertar el simbolo en la tabla
          boolean insetarSimbol = tabla.aquiNoo(newSimbol);
          if(insetarSimbol){
              return null;
          }else{
              mensErr = String.format("La variable con id: %s ya existe", identificador);
              return new Errores("SEMANTIC", mensErr, line, col);
          }
    }
    
    public Object vectors2D(Arbol arbol, TablaSimbolos tabla){
        //set al tamanno de filas y columnas
        this.sizeFilas = valuesVect2D.size();
        this.sizeCol = valuesVect2D.get(0).size();
   
//        crear el vector 
        vectorzito2D = new Object[sizeFilas][sizeCol];
   
        for (int i = 0; i < valuesVect2D.size(); i++) {                              //ciclo de filas
        //verificar tamano de las columnas 
            if(valuesVect2D.get(i).size()!= sizeCol){
                mensErr = String.format("Cantidad de valores erronea al insertar en el vector2D con id:%s ",identificador);
                return new Errores("SEMANTIC", mensErr, valuesVect2D.get(i).getLast().line,
                         valuesVect2D.get(i).getLast().col);
            }
    
            for (int j = 0; j <valuesVect2D.get(0).size(); j++) {                       //ciclo de columnas
            //interpretar el valor    
                var valuee = valuesVect2D.get(i).get(j).interpretar(arbol, tabla);
                if(valuee instanceof Errores){
                    return valuee;
                }
                //validar el tipo
                if(this.tipo.getTipo() != valuesVect2D.get(i).get(j).tipo.getTipo()){
                    mensErr = String.format("Tipos errones al insertar en el vector: %s, "
                            + " valor con error: valor: %s", identificador, valuee.toString());
                    return new Errores("SEMANTIC", mensErr,  valuesVect2D.get(i).get(j).line, valuesVect2D.get(i).get(j).col);
                }
                //agregar el valor al vector
                vectorzito2D[i][j] = valuee;
            }
        }
        //Crear y agregar el simbolo a la tabla
        Simbolo newSimboll = new Simbolo(this.tipo, identificador, vectorzito2D, isConst);
        newSimboll.setLinea(line);
        newSimboll.setLinea(col);
        if(tabla.aquiNoo(newSimboll)){
            return null;
        }else{
            mensErr = String.format("La variable con id: %s ya existe", identificador);
            return new Errores("SEMANTIC", mensErr, line, col);
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
        return anterior;
    }
}
