/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.expresiones;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.instrucciones.Structs;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
public class InstanceStruct extends Instruction{
    public String id;
    public String idStruct;
    public boolean isConst;
    public LinkedList<HashMap> id_valor;

    public InstanceStruct(String id, String idStruct, boolean isConst, LinkedList<HashMap> id_valor, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.idStruct = idStruct;
        this.isConst = isConst;
        this.id_valor = id_valor;
    }
    
    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        // buscar el struct en el arbol
           var struct = arbol.getFunction(idStruct);
           if(struct == null){
               return new Errores("SEMANTIC", "No se ha encontrado El struct", line, col);
           }
                                                                                                     
           if(struct instanceof Structs structSearched){
               if(structSearched.parameters.size() != this.id_valor.size()){ //verificar cantidad de valores 
//                                                                recibido con los parametros del struct
                   return new Errores("SEMANTIC", "Valores incorrectos, no corresponden al Struct", line, col);
               }
               
                var hashSym = (HashMap)structSearched.interpretar(arbol, tabla);    // interpretar el struct
                for (int i = 0; i < id_valor.size(); i++) {                              //CICLO
                    Structs structVals;
                    Instruction expParam;
                    HashMap hashInstance = id_valor.get(i);
                    var idParam = hashInstance.get("id");

                    var symm = hashSym.get(idParam);        //buscar el simbolo con el id del parametro
                   
                   
                   
                                                        //si el simbolo es otro hashmap = un struc anidado
                    if(symm == null){
                        mensErr = String.format("El parametro: %s no corresponde al Struct", idParam);
                          return new Errores("SEMANTIC", mensErr, line, col);
                    }
                    if(symm instanceof Simbolo sym){
                   expParam = (Instruction)hashInstance.get("exp");
                        //               interpretar las expresiones
                            var expInterp = expParam.interpretar(arbol, tabla);
                            if(expInterp instanceof Errores){
                                return expInterp;
                            }
                            Tipo tipoS = sym.getTipo();
                            Tipo tipoParam = expParam.tipo;
                            if(tipoS.getTipo() != tipoParam.getTipo()){  // comparar los tipos de la exp con el tipo declarado 
                                mensErr = String.format("El tipo del Parametro: %s no corresponde", idParam);
                                return new Errores("SEMANTIC", mensErr, expParam.line, expParam.col);
                            }
                            sym.setValor(expInterp);
                    }else if (symm instanceof HashMap hashField){               //Struct anidado
                        
                        if(hashInstance.get("exp") instanceof Access accesStruct){          //asignando un Struct como valor de campo de otro struct
                            Simbolo simboloStruct =  tabla.getSsymbol(accesStruct.id);
                            hashSym.put(idParam, simboloStruct.getValor());
                                                            System.out.println("Asignando a un campo un struct encontrado con un id");
                        }else{
                            
                        String idStructAnid = (String)structSearched.parameters.get(i).get("tipo");
                        System.out.println("persona: " + idStructAnid);
                        String idSsss = (String)hashInstance.get("id");
                        System.out.println("p: " + idSsss);
                        
                       structVals = (Structs)hashInstance.get("exp");
                       
                        LinkedList<HashMap> id_valor2 = structVals.parameters;
                                // buscar el struct en el arbol
                        var structSearched2 = arbol.getFunction(idStructAnid);
                        if(structSearched2 == null){
                            return new Errores("SEMANTIC", "No se ha encontrado El struct anid", line, col);
                        }
                        if(structSearched2 instanceof Structs structSearAni){
                            if(structSearAni.parameters.size() != id_valor2.size()){ //verificar cantidad de valores 
//                                                                recibido con los parametros del struct
                                return new Errores("SEMANTIC", "Valores incorrectos, no corresponden al Struct Anid", line, col);
                            }
                            for (int j = 0; j < id_valor2.size(); j++) {
                               HashMap hashInstance2 = id_valor2.get(j);
                               var idParam2 = hashInstance2.get("id");
                               var expParam2 = (Instruction)hashInstance2.get("exp");
                               
                               String idd = structSearAni.parameters.get(j).get("id").toString();
                               Tipo tipoS2 = (Tipo)structSearAni.parameters.get(j).get("tipo");
                                
                                if(idd==null || tipoS2==null){
                                    mensErr = String.format("El parametro anid: %s no corresponde al Struct anid", idParam);
                                      return new Errores("SEMANTIC", mensErr, line, col);
                                }
                        //               interpretar las expresiones
                                var expInterpA = expParam2.interpretar(arbol, tabla);// interpret to expression
                                if(expInterpA instanceof Errores){
                                    return expInterpA;
                                }
                                if(tipoS2.getTipo() != expParam2.tipo.getTipo()){  // comparar los tipos de la exp con el tipo declarado 
                                    mensErr = String.format("El tipo del Parametro: %s no corresponde", idParam);
                                    return new Errores("SEMANTIC", mensErr, expParam2.line, expParam2.col);
                                }
                                Simbolo simAni = new Simbolo(expParam2.tipo, idParam2.toString(), expInterpA, false);
                                hashField.put(idParam2, simAni);
                                
                            }
                //Struct{
                //    nombre: string;
                //    edad: int;
                //    estatura: double;
                //} persona;
                //
                //Struct{
                //    cui: string;
                //    p: persona;
                //} identificacion;
                
                //const id2: identificacion = { cui: "3748614591201", p: { nombre: "Jorge", edad: 23, estatura: 1.70 } };
   
                        }
      
                    }//elif
                        }
                        
                        
                        
               }//for
               
               
//               //        crear el simbolo del struct
               Simbolo symStruc = new Simbolo(this.tipo, id, hashSym, isConst);
               symStruc.setTipoStruct(idStruct);
               if(!(tabla.aquiNoo(symStruc))){
                   return new Errores("SEMANTIC", "Ya existe la variable(al instanciar un struct): " + id, line, col);
               }
               
               
           }else{
               return new Errores("SEMANTIC", "El id ingresano no corresponde a un Struct", line, col);
           }
     return null;
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
        return anterior;
    }
    
}
