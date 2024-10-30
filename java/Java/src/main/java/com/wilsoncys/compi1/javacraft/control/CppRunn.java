/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.control;

/**
 *
 * @author jonwilson
 */
    
import java.io.*; 

public class CppRunn {

    // Método para crear y ejecutar el archivo .cpp
    public void crearYEjecutarCpp(String codigoCpp) {
        String nombreArchivo = "pruebaSalidas.cpp";
        
        try {
            // Crear el archivo .cpp y escribir el código dentro de él
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));
            escritor.write(codigoCpp);
            escritor.close();
            
            // Compilar el archivo .cpp con g++
            Process procesoCompilacion = Runtime.getRuntime().exec("g++ " + nombreArchivo + " -o programa");
            procesoCompilacion.waitFor();

            // Comprobar si la compilación fue exitosa
            if (procesoCompilacion.exitValue() == 0) {
                System.out.println("Compilación exitosa. Abriendo terminal y ejecutando el programa...");

                // Abre una nueva terminal y ejecuta el programa en ella
                ProcessBuilder pb = new ProcessBuilder("gnome-terminal", "--", "bash", "-c", "./programa; exec bash");
                pb.inheritIO(); // Hereda la entrada y salida de la consola Java
                pb.start();

            } else {
                System.err.println("Error en la compilación:");
                BufferedReader errorCompilacion = new BufferedReader(new InputStreamReader(procesoCompilacion.getErrorStream()));
                String error;
                while ((error = errorCompilacion.readLine()) != null) {
                    System.err.println(error);
                }
                errorCompilacion.close();
            }
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
 
}
