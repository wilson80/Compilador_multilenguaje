/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.wilsoncys.compi1.java;

 
import com.formdev.flatlaf.themes.FlatMacDarkLaf; 
import com.wilsoncys.compi1.java.control.Control;

/**
 *
 * @author Jonwil
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        try {
//            FlatGradiantoMidnightBlueIJTheme.setup();
//            FlatLightOwlIJTheme.setup();
//            FlatHighContrastIJTheme.setup();
//              FlatGradiantoDeepOceanIJTheme.setup();
//              FlatDarkPurpleIJTheme.setup();
//                FlatMacLightLaf.setup();
//                FlatNativeMacLibrary.setup();
                FlatMacDarkLaf.setup();
//                FlatArcOrangeIJTheme.setup();
//                                                          FlatCobalt2IJTheme.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Control iniciarPrograma = new Control();
        
        
        
    }
        
        
}
