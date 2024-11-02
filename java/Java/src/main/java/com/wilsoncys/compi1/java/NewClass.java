/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java;

/**
 *
 * @author jonwilson
 */
public class NewClass {
    
    
    public static void main(String[] args) {
        int num1 = 4;
        int num2 = 6;
        int total = 0;
        
        NewClass algo = new NewClass();
        System.out.println(algo.sumar(num1, num2));
       
        
        
    }
    
    public int sumar(int x, int y){
        int total = x+y;
        return total;
    }
            
    
    
}
