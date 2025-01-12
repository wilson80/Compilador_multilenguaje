    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instruccionesPas;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
public class VectorsStatementPas extends Instruction
{
    public String identificador;
    private boolean isConst;
    private int sizeFilas;
    private int sizeCol;
    private Instruction expII;
    private Instruction expI_F;
    
    private Object vectorzito[];


//    public VectorsOneD(String identificador, boolean isConst, LinkedList<Instruction> valuesVect, Tipo tipo, int linea, int col) {
//        super(tipo, linea, col);
//        this.identificador = identificador;
//        this.isConst = isConst;
//        this.valuesVect = valuesVect;
//    }

    public VectorsStatementPas(String identificador, Instruction indI, Instruction indF, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.identificador = identificador;
        this.isConst = false;
        this.expII = indI;
        this.expI_F = indF;
    }
    
    
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        
//        interpretar los inddices
                                        //indF
            var valIInicial = this.expII.interpretar(arbol, tabla);
            if(valIInicial instanceof  Errores){
                return valIInicial;
            }
            //validacion tipo entero
            if(this.expII.tipo.getTipo()!=tipoDato.ENTERO){
                return new Errores("SEMANTIC", "Tipo erroneo (el indice inicial ingresado no es un entero)", line, col);
            }
                                        //indF
            var valIFinal = this.expI_F.interpretar(arbol, tabla);
            if(valIFinal instanceof  Errores){
                return valIFinal;
            }
            //validacion tipo entero
            if(this.expI_F.tipo.getTipo()!=tipoDato.ENTERO){
                return new Errores("SEMANTIC", "Tipo erroneo (el indice final ingresado no es un entero)", line, col);
            }
            
           int indiceInicial =  (int)valIInicial;   
           int indicefinal =  (int)valIFinal;
        //difinir tamanno
        
//        crear el vector 
        vectorzito = new Object[ (indicefinal - indiceInicial)+1];
        
//        crear el newSimboll
          Simbolo  newSimbol = new Simbolo(this.tipo, this.identificador, this.vectorzito, this.isConst);
          newSimbol.setIndI(indiceInicial);
          newSimbol.setIndF(indicefinal);
          newSimbol.setIsArr(true);;
          newSimbol.setLinea(line);
          newSimbol.setLinea(col);
          
//        insertar el simbolo en la tabla
          boolean insetarSimbol = tabla.addSsymbolPre(newSimbol);
          if(insetarSimbol){
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

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
