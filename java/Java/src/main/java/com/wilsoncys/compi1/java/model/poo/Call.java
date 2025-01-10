 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.poo;

import com.wilsoncys.compi1.java.model.poo.Method;
import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores; 
import com.wilsoncys.compi1.java.model.expresiones.Access;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.instrucciones.Statement;
import com.wilsoncys.compi1.java.model.instrucciones.transferReturn;
import com.wilsoncys.compi1.java.model.programa.InstanceJava;
import com.wilsoncys.compi1.java.model.programa.expresiones.AccessC;
import com.wilsoncys.compi1.java.model.programa.expresiones.NativoC;
import com.wilsoncys.compi1.java.model.sC3D.C3d;
import com.wilsoncys.compi1.java.model.sC3D.C3d_Java;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.categoria;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class Call extends Instruction{
    private String id;
    private Call llamada;
    private String otroId;
    private boolean recursiva;
    
    private String nombreObjeto = "";
    
    private LinkedList<Instruction> parametersExp;

                                //algo()
    public Call(String identificator, LinkedList<Instruction> parametros, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = identificator;
        this.parametersExp = parametros;
        this.llamada = null;
    }
                                //objeto.algo()
    public Call(String identificator, Call  llamada, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = identificator;
        this.llamada = llamada;
        this.parametersExp = null;
    }
                                //objeto().algo()
    public Call(String identificator, LinkedList<Instruction> parametros, Call llamada, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = identificator;
        this.parametersExp = parametros;
        this.llamada = llamada;
    }
    
    
    
    @Override
    public Object interpretar(Arbol tree, TablaSimbolos tabla) {
        LinkedList<HashMap> listParams;      //parametros del metodo o funcion 

        //buscar la funcion
        var functio = tree.getFunction(id);
        if(functio == null){
            return new Errores("SEMANTIC", "El id ingresado no corresponde a ningun tipo de funcion/metodo/struct", line, col);
        }
        if(functio instanceof Method theMethod){
            listParams = theMethod.parameters;
            //crear el entorno
                                //            tablaSimbolos newTable = new tablaSimbolos(tree.getTablaGlobal());
            TablaSimbolos newTable = new TablaSimbolos(tabla);
            newTable.setNombre("Metodo: " + id);
            tree.addTablaReport(newTable);
            
            
            //validar las cantidades de parametros(en las llamada y en la declaracion del metodo)
            if(listParams.size() != parametersExp.size() ){
                mensErr = String.format("Cantidad de parametros Incorrecta. Al llamar al metodo: %s ", theMethod.id);
                return new Errores("SEMANTIC", mensErr, line, col);
            }
            
            int contador = 0;   
            for (var exp : parametersExp) {                         //CICLO                                                                        
                HashMap par = listParams.get(contador);             //comparar que el tipo coicida con el orden 
                Tipo tipo = (Tipo)par.get("tipo");
                                                                //crear la declaracion sin valor
                Statement newStt = new Statement(par.get("id").toString(), tipo, line, col, false);    
                var sttm = newStt.interpretar(tree, newTable);     //interpretar la declaracion
                if(sttm instanceof Errores){
                    return sttm;
                }
                
                var valueExp = exp.interpretar(tree, tabla);        //interpretar los parametros
                if(valueExp instanceof Errores){
                    return valueExp;
                }
                
                if(exp.tipo.getTipo() != tipo.getTipo()){       //verificar los tipos
                    mensErr = "Tipos Erronos de parametros al llamar al metodo:  " + theMethod.id;
                    return new Errores("SEMANTIC", mensErr, exp.line, exp.col);
                }
                Simbolo symm = newTable.getSsymbol(par.get("id").toString());   //realizar la asignacion                                                              //realizar la asignacion
                if(symm == null){
                    return new Errores("SEMANTIC", "No se encontro el parametro en funcion: " 
                                                        + id, line, col);
                }
                symm.setValor(valueExp);
                contador++;
            }
            
            var metodoVoid = theMethod.interpretar(tree, newTable);     //interpretar la funcion (mandarle la nueva tabla)
            if(metodoVoid instanceof Errores){
                return metodoVoid;
            }
            
            if(metodoVoid instanceof transferReturn metodd){
                if(metodd.expression!=null){
                    return  new Errores("SEMANTIC", "Retorno con expresion en Metodo: " + theMethod.id, theMethod.line, theMethod.col);
                }
                return null;
            }
            
        }
        if(functio instanceof Functionss function){

            
            listParams = function.parameters;
            //crear el entorno
                        //            tablaSimbolos newTable = new tablaSimbolos(tree.getTablaGlobal());
            TablaSimbolos newTable = new TablaSimbolos(tabla);
            newTable.setNombre("Funcion: " + id);
            tree.addTablaReport(newTable);
            
            //validar las cantidades de parametros(en las llamada y en la declaracion del metodo)
            if(listParams.size() != parametersExp.size() ){
                mensErr = String.format("Cantidad de parametros Incorrecta. Al llamar al metodo: %s ", function.id);
                return new Errores("SEMANTIC", mensErr, line, col);
            }
            
            int contador = 0;   
            for (var exp : parametersExp) {                         //CICLO                                                                        
                HashMap par = listParams.get(contador);             //comparar que el tipo coicida con el orden 
                Tipo tipo = (Tipo)par.get("tipo");
                                                                //crear la declaracion sin valor
                Statement newStt = new Statement(par.get("id").toString(), tipo, line, col, false);    
                var sttm = newStt.interpretar(tree, newTable);     //interpretar la declaracion
                if(sttm instanceof Errores){
                    return sttm;
                }
                
                var valueExp = exp.interpretar(tree, tabla);        //interpretar los parametros
                if(valueExp instanceof Errores){
                    return valueExp;
                }
                
                if(exp.tipo.getTipo() != tipo.getTipo()){       //verificar los tipos
                    mensErr = "Tipos Erronos de parametros al llamar al metodo:  " + function.id;
                    return new Errores("SEMANTIC", mensErr, exp.line, exp.col);
                }
                Simbolo symm = newTable.getSsymbol(par.get("id").toString());                                                                 //realizar la asignacion
                if(symm == null){
                    return new Errores("SEMANTIC", "No se encontro el parametro en funcion: " 
                                                        + id, line, col);
                }
                symm.setValor(valueExp);
                contador++;
            }
            var fun = function.interpretar(tree, newTable);     //interpretar la funcion (mandarle la nueva tabla)
            if(fun instanceof Errores){
                return fun;
            }    
            if(fun == null){
                return new Errores("SEMANTIC", "Funcion sin valor de retorno: " + ((Functionss) functio).id, functio.line, functio.col);
            }
            boolean thereReturn = false;
            if(fun instanceof transferReturn){
                if(((transferReturn) fun).expression == null){
                    return new Errores("SEMANTIC", "Return sin valor a retornar: " + ((Functionss) functio).id, functio.line, functio.col);
                }
                var returnVAlue = ((transferReturn) fun).interpretar(tree, newTable); //interpretar el return
                if(returnVAlue instanceof Errores){
                    return returnVAlue;
                }else{
                    thereReturn = true;     //hay return en la funcion
                    this.tipo = ((transferReturn) fun).tipo;
                    //verificar tipo de la funcion y tipo del valor del retorno  
                    if(this.tipo.getTipo() != function.tipo.getTipo()){
                        return new Errores("SEMANTIC", "Tipo de valor de retorno no corresponde al tipo de la funcion", 
                                ((transferReturn) fun).expression.line, ((transferReturn) fun).expression.col);
                    }

                    return returnVAlue;
                }
                
            }
            if(!thereReturn){       //si no hay un retur al finalizar todas las instrucciones
                return new Errores("SEMANTIC", "Funcion sin valor de retorno: " + function.id+  " ", function.line, function.col);
            }
            
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
    public Object createC3D(Arbol arbol, String anterior) {
         
        String armed = "";
        
                           //llamada simple calcular();
        if(llamada == null){
            armed += simpleCall(arbol, anterior);
        } 
         
        
                                    // int uno = objeto1.getCui();  
                                    //encontrar el simbolo del objeto
        if(parametersExp == null){

//            JOptionPane.showMessageDialog(null, "iniii: "
//                        + arbol.getCurrentAmbit().get(1)); 
            
            C3d_Java c =  arbol.getJava();
            Simbolo sym0 = null;

            String armedId = "";
            armedId= arbol.getAmbito_asID() + id;

            sym0 = arbol.getSym(armedId);
            
            if(sym0==null){      //si no se encuentra en el ambito local buscar en el ambito global
                armedId = arbol.getCurrentAmbit().get(0);
                armedId += arbol.getCurrentAmbit().get(1) + id;
                sym0 = arbol.getSym(armedId);
                if(sym0 == null){        //revisar esto

                    JOptionPane.showMessageDialog(null,
                            "error en llamada OBJ no se ha encontrado el symbolo" + armedId);
//                    return new Errores(id, "no se ha encontrado el simboloooooooooooooo", line, col);
                }
            }
             
            
//            String currentAmbit = arbol.getCurrentAmbit().get(1);  
                                            //buscando el tipo del objeto
//            if(sym0.getInstruction() instanceof Statement met){
//                arbol.getCurrentAmbit().set(1, met.tipo.getTypeString());
////                JOptionPane.showMessageDialog(null, "call277: " + met.tipo.getTypeString());
////                arbol.setSizeHeap(3);
//            }else{
 

            
        llamada.setNombreObjeto(sym0.getTipo().getTypeString());
 
        
        
            if(sym0.getCat() == categoria.ATRIBUTO){
                        //set a la referencia (stack[0]) 
                armed+= c.c3d_accesRef("", 0);
                armed+= c.c3d_accesAttVarl("", sym0.getDir());
            }else if(sym0.getCat() == categoria.PARAM || sym0.getCat()== categoria.VARL){
                armed+= c.c3d_acces("", sym0.getDir()); 
             } 
             
                         //interpretar la llamada
            armed += llamada.createC3D(arbol, anterior);
            
//            arbol.getCurrentAmbit().set(1, currentAmbit);
             
        }
        

         
        return armed;
    }
    
    
    
    
    
    
    
    
    public Object simpleCall(Arbol arbol, String anterior) {
 
               
        String armed = "";
        String ref = "";
        String id_to_call = "";
        boolean callPoo = false;
        C3d_Java c =  arbol.getJava();

        int ptrTemp = 0;
        
        
        
                                            //extrayendo los params
//        identificando llamada a objeto
        if(c.varsParams.size()!=0 || c.varsRef.size() != 0){
            if(c.varsParams.size()!=0){
                ref = c.varsParams.getFirst();
                c.varsParams.removeFirst();
                callPoo = true;
            } 
        } 
        
        String id_Methodo = "";
        String id_Methodo2 = "";
        
        if(callPoo){
              id_Methodo = "java"  + nombreObjeto + this.id;
        }else{
              id_Methodo = "java"  + arbol.getCurrentAmbit().get(1) + this.id;
              id_Methodo2 = "java"  + arbol.getAmbito_asID() + this.id;
        }
                                         
        
        
        for (Instruction exps : parametersExp) {
            if(exps instanceof Nativo n){        

//                armed+=n.createC3D(arbol, anterior);
                n.createC3D(arbol, anterior);
                id_Methodo += n.tipo.getTypeString(); 

            }else if(exps instanceof Access cs){
                armed+= cs.createC3D(arbol, anterior);
                id_Methodo += cs.tipo.getTypeString();
                
            }else{
                armed += exps.createC3D(arbol, anterior);
                id_Methodo += exps.tipo.getTypeString();
            }
        }
        
        if(arbol.getAmbito_asID().equals(id_Methodo)){
            recursiva =true;
        }
        
        
                                    //set a la posicion inicial para dejar los parametros
        Simbolo symMethod = arbol.getSym(id_Methodo);
        id_to_call = id_Methodo;
        if(symMethod == null){
            symMethod = arbol.getSym(id_Methodo2);
            id_to_call = id_Methodo2;
            if(symMethod ==null){
                JOptionPane.showMessageDialog(null, "error en  simpleCall"
                    + "no se ha encontrado el symbolo: " + this.id );
            }
//            return new Errores("SEMANTIC", "id no definido: " + this.id, line, col);
        } 
  
         

 
   

        ptrTemp = arbol.getCurrentPos();
        
 
                //para poner los parametros
        int posIni = 0;
        if(symMethod.getCat().equals(categoria.FUNCTION) ){
            posIni = 3;
        }else if(symMethod.getCat().equals(categoria.METHOD)){
            posIni = 2;
        }
         
        
                                        //stack temp
            armed+=c.c3d_ptrTemp(ptrTemp);

                                //dando la direccion de referencia
        if(!callPoo){
            armed+= c.c3d_acces("", 0);
            String simpleRef = c.varsParams.getLast();
            c.varsParams.removeLast();
            c.varsParams.add(0, simpleRef);
        }else{
            c.varsParams.addFirst(ref);
        }                     
                                     //dando la ref en el stack del metodo llamado
        armed+= c.c3d_asignVar(c.getPtrTemp(), 0);
 
        
        
                   
                                            //PREPARED params en el stack
        for (Instruction exps : parametersExp) {
                armed += c.c3d_asignVar(c.getPtrTemp(), posIni);
                posIni++;
        }
        c.clearPtrTemp();   
        
        
 


                                            //llamada del metodo/funcion
        armed+=c.c3d_moveToStack(true, ptrTemp);
        
        if(callPoo){
            armed+= c.callJava(nombreObjeto+ "_" + this.id);
        }else{
            armed+= c.callJava(arbol.getCurrentAmbit().get(1) + "_" + this.id);
        }
        armed+=c.c3d_moveToStack(false, ptrTemp);
        
        
                                            //create al metodo/funcion
        c.clearVarParams();
        if(!recursiva ){
            if(symMethod.getCat().equals(categoria.FUNCTION) ){
                symMethod.getInstruction().createC3D(arbol, anterior);
            }else if(symMethod.getCat().equals(categoria.METHOD)){
                symMethod.getInstruction().createC3D(arbol, anterior);
            }
        }
        c.clearVarParams();
        
                                           //dejar el retorno
            if(symMethod.getCat() == categoria.FUNCTION  ){
                armed += "\n//retorno\n";
                armed += c.c3d_ptrTemp(ptrTemp);
                armed += c.c3d_accesTemp("", 1);
                armed += "\n//retorno\n";

            } 
//            JOptionPane.showMessageDialog(null,    "Size varP: "  
//       +  c.varsParams.size() + " varRef : " +  c.varsRef.size());

  
        return armed;
    }

    public void setId(String otroId) {
        this.id = otroId;
    }

    public String getId() {
        return id;
    }

    public void setRecursiva(boolean recursiva) {
        this.recursiva = recursiva;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    
    
    
    
    
    


    
    
    
}
