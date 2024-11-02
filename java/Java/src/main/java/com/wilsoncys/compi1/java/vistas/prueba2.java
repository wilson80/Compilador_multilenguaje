/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.vistas;

import java.util.List;

/**
 *
 * @author Jonwil
 */
public class prueba2 {

    public static void main(String[] args) {
        prueba2 a = new prueba2();
        a.algo();
    }

    
    public void algo() {
        int result = 0;
/*
5.4-1 = 4.4
5.4-0.5

*/
        double valueExp = 5;
        int copia = (int)valueExp;        
        double retultado = valueExp - 0.5;
        int finall = (int)retultado;
        
        
        if(copia ==finall){
            result = ((int)retultado) + 1;
        }else{
            result = copia;
        }
                
        System.out.println("roundd: " + result);
    

        
    }
    
    public void metodooo(int agg){
        agg = 5;
        
        int numero = 0;
        System.out.println("");
        if(true){
            
        }
        System.out.println("");
        System.out.println("");

        if(true){
            return;
        }
        
        
    }
    
    
    
    
    




}
