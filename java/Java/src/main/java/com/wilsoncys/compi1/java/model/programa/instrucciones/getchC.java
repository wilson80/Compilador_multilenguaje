/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.programa.instrucciones;

import com.wilsoncys.compi1.java.model.asbtracto.Instruction;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.expresiones.Nativo;
import com.wilsoncys.compi1.java.model.instrucciones.AmbitoMetodo;
import com.wilsoncys.compi1.java.model.simbolo.Arbol;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.model.simbolo.Tipo;
import com.wilsoncys.compi1.java.model.simbolo.tipoDato;

/**
 *
 * @author jonwilson
 */
public class getchC extends Instruction{
    boolean isInstruc;
    private String tipoGetch;

    public getchC(boolean isInstruc, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.isInstruc = isInstruc;
    }

    
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        return null; 
    }

    @Override
    public Object createSym(Arbol arbol, TablaSimbolos tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object createC3D(Arbol arbol, AmbitoMetodo anterior) {
        String armed = "";
        String gChar ="char getchchar() {\n" +
"    struct termios oldt, newt;\n" +
"    char ch;\n" +
"    tcgetattr(STDIN_FILENO, &oldt);           // Guardar configuración actual del terminal\n" +
"    newt = oldt;\n" +
"    newt.c_lflag &= ~(ICANON | ECHO);         // Desactivar modo canónico y eco\n" +
"    tcsetattr(STDIN_FILENO, TCSANOW, &newt);  // Aplicar nueva configuración\n" +
"    ch = getchar();                           // Leer un carácter\n" +
"    tcsetattr(STDIN_FILENO, TCSANOW, &oldt);  // Restaurar configuración original\n" +
"    return ch;\n" +
"}";
 
        String gInt = "\nint getchint() {\n" +
"    struct termios oldt, newt;\n" +
"    char ch;\n" +
"    tcgetattr(STDIN_FILENO, &oldt);           // Guardar configuración actual del terminal\n" +
"    newt = oldt;\n" +
"    newt.c_lflag &= ~(ICANON | ECHO);         // Desactivar modo canónico y eco\n" +
"    tcsetattr(STDIN_FILENO, TCSANOW, &newt);  // Aplicar nueva configuración\n" +
"    ch = getchar();                           // Leer un carácter\n" +
"    tcsetattr(STDIN_FILENO, TCSANOW, &oldt);  // Restaurar configuración original\n" +
"    return static_cast<int>(ch);              // Retornar el valor ASCII como entero\n" +
"}\n";
        
        
        if(!isInstruc){
            if(!(tipoGetch.equals("int") || tipoGetch.equals("char"))){
                arbol.addError(new Errores("semantic", "getch solo para asignar a int y char", line, col));
            }
            
            if(!arbol.isThereGetchInt()){
                arbol.Print("\n" + gInt + "\n");
                arbol.setThereGetchInt(true);
            }
            if(!arbol.isThereGetchChar()){
                arbol.Print("\n" + gChar + "\n");
                arbol.setThereGetchChar(true);
            }
            armed += arbol.getJava().getch(tipoGetch, anterior.getVars());
            
            
            
        }else{
            if(!arbol.isThereGetchInt()){
                arbol.Print("\n" + gInt + "\n");
                arbol.setThereGetchInt(true);
            }
            
             armed += "\n// un getch";
            armed += "\ngetchint();\n";
        }

        
        return armed;
    }

    @Override
    public String generarast(Arbol arbol, String anterior) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setTipoGetch(String tipoGetch) {
        this.tipoGetch = tipoGetch;
    }
    
    
    
    
    
}
