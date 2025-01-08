/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.java.model.instrucciones;

/**
 *
 * @author jonwilson
 */
public class NewClass {

    int uno;
    int dos;
    int tres;

    public NewClass(int uno, int dos, int tres) {
        this.uno = uno;
        this.dos = dos;
        this.tres = tres;
    }

    public void crearCartas() {
        // Prueba del método recursivo
        int numero = 6;
        int resultado = calcularFibonacci(numero);

        // println("El factorial de " , numero + " es: " , resultado);
        System.out.println("El factorial de essssss: " + resultado);

    }

    public int calcularFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // Caso recursivo: n * factorial(n - 1)
        return n * calcularFactorial(n - 1);

    }

    public int calcularFibonacci(int n){
            if (n == 0) {
                return 0;  // Caso base
            } else if (n == 1) {
                return 1;  // Caso base
            } else {
                return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);  // Caso recursivo
            }
		
    } 
    
    
    
    
    
    
    
    
    //hacer pruebas en c+++++++
    
    
    
    public static void main(String[] args) {
        NewClass algo = new NewClass(1, 1, 1);
        algo.crearCartas();
    }

}
