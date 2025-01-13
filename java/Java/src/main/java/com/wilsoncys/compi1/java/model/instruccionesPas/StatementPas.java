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
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */

    
public class StatementPas extends Instruction{

    public String id;
    public Instruction valor;
    private boolean declaracionSimple;
    private boolean isConst;
    private LinkedList<String> ids;
    
    //constructor sin asignacion (declaracion simple)
    public StatementPas(LinkedList<String>  ids, Tipo tipo, int linea, int col, boolean isMutable) {
        super(tipo, linea, col);
        this.ids = ids;
        this.declaracionSimple = true;
        this.isConst = isMutable;
    }
    
    //constrcutor para declaracion de constantes
    public StatementPas(String id, Instruction exp, Tipo tipo, int linea, int col, boolean constante) {
        super(tipo, linea, col);
        this.valor = exp;
        this.id = id;
        this.declaracionSimple = false;
        this.isConst = true;
    }
//    PI = 3.14;
//    constructor con asignacion
//    public Statement(String identificador, Instruction valorVariable_exp, Tipo tipo, int linea, int col, boolean isMutable) {
//        super(tipo, linea, col);
//        this.identificador = identificador;
//        this.valor = valorVariable_exp;
//        this.declaracionSimple = false;
//        this.isConst = isMutable;
//    }
//    \\\\analizar

    @Override
    
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        if(declaracionSimple){
            return declare(arbol, tabla);
        }else{
            return declareAssign(arbol, tabla);
        }
    }

    public Object declare(Arbol arbol, TablaSimbolos tabla) {
        boolean recordCreated = false;
            //validando la existencia de la variable
        boolean isCreacion = false;
        for (String id : ids) {
            Simbolo newSymbol = new Simbolo(this.tipo, id, darValorDefecto(), isConst);
            newSymbol.setLinea(line);
           newSymbol.setLinea(col);    
                isCreacion = tabla.addSsymbolPre(newSymbol);
        }
        
        if(isCreacion){
            return null;
        }else{
            return new Errores("SEMANTIC", "la variable ya existe", line, col);
        }
        
    }

    public Object declareAssign(Arbol arbol, TablaSimbolos tabla) {
        // interpretar para obtener el valor
        var valorInterpretado = this.valor.interpretar(arbol, tabla);

        //validar posible error
        if (valorInterpretado instanceof Errores) {
            return valorInterpretado;
        }

        Simbolo newSsimbol = new Simbolo(this.valor.tipo, this.id, valorInterpretado, isConst);
        newSsimbol.setLinea(line);
        newSsimbol.setLinea(col);
        boolean creacion = tabla.addSsymbolPre(newSsimbol);
        if (creacion) {
            return null; 
        }else{      //si creacion es false(significa que la variable existe) se devuelve un error
            return new Errores("SEMANTICO", "La Variable ya existent", this.line, this.col);
        }

    }
    
    public Object darValorDefecto(){
        switch (tipo.getTipo()) {
            case ENTERO->{
                return 0;
            }
            case DECIMAL->{
                return 0.0;
            }
            case CADENA->{
                return "";
            }
            case BOOLEANO->{
                return  0;
            }
            case CARACTER->{
                return  '@';
            }
            default->{
                return "";
            }
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
//        setPos(arbol);
//        String armed = "";
//        C3d c =  arbol.getC3d();
//        String idArmed = "pas"+ arbol.getAmbito_asID() +this.id;
//        
//        
//        int dir  = arbol.getSym(idArmed).getDir();
//
//        
//                                            //valor por defecto conforme el tipo
//            armed += c.c3d_statementNativoC("0", dir);

            
            
            
        
        
        return "";
    }

    public LinkedList<String> getIds() {
        return ids;
    }
    
    
     
}



