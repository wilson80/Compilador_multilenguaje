/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.vistas;

import com.wilsoncys.compi1.javacraft.control.Control;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;
import com.wilsoncys.compi1.javacraft.model.simbolo.Simbolo;
import com.wilsoncys.compi1.javacraft.model.simbolo.TablaSimbolos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jonwil
 */

public class VistaGeneral extends javax.swing.JFrame {
    private JTabbedPane tabbedPane;
    private String textoActual;
    private Control control;
    private FrameReportes reportes;
    private LinkedList<Errores> listaErrores;
    private LinkedList<TablaSimbolos> tablaReport = new LinkedList<>();          //par la tabla de simbolos

    public VistaGeneral(Control control) {
        this.control = control;
        tabbedPane = new JTabbedPane();
        initComponents();
        panelCajonTexto.add(tabbedPane, BorderLayout.CENTER);
//        identificarPestana();
        ininicializarPestañas();



        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCajonTexto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cajonConsola = new javax.swing.JTextArea();
        botonEjecutar = new javax.swing.JButton();
        botonNuevoArchivo = new javax.swing.JButton();
        botonNuevoArchivo1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelLine = new javax.swing.JLabel();
        labelCol = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuReportes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panelCajonTexto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        panelCajonTexto.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelCajonTexto);
        panelCajonTexto.setBounds(10, 60, 660, 710);

        cajonConsola.setEditable(false);
        cajonConsola.setColumns(20);
        cajonConsola.setRows(5);
        jScrollPane1.setViewportView(cajonConsola);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(690, 62, 750, 710);

        botonEjecutar.setBackground(new java.awt.Color(0, 102, 255));
        botonEjecutar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonEjecutar.setForeground(new java.awt.Color(255, 255, 255));
        botonEjecutar.setText("Run");
        botonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEjecutarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEjecutar);
        botonEjecutar.setBounds(1120, 10, 80, 40);

        botonNuevoArchivo.setBackground(new java.awt.Color(0, 102, 255));
        botonNuevoArchivo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonNuevoArchivo.setForeground(new java.awt.Color(255, 255, 255));
        botonNuevoArchivo.setText("Nuevo Archivo +");
        botonNuevoArchivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonNuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoArchivoActionPerformed(evt);
            }
        });
        getContentPane().add(botonNuevoArchivo);
        botonNuevoArchivo.setBounds(470, 10, 190, 40);

        botonNuevoArchivo1.setBackground(new java.awt.Color(0, 102, 255));
        botonNuevoArchivo1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonNuevoArchivo1.setForeground(new java.awt.Color(255, 255, 255));
        botonNuevoArchivo1.setText("Crear AST");
        botonNuevoArchivo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonNuevoArchivo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoArchivo1ActionPerformed(evt);
            }
        });
        getContentPane().add(botonNuevoArchivo1);
        botonNuevoArchivo1.setBounds(910, 10, 190, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Chayan3D");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 200, 30);

        labelLine.setText("Line: 0");
        getContentPane().add(labelLine);
        labelLine.setBounds(240, 20, 90, 30);

        labelCol.setText("Col: 0");
        getContentPane().add(labelCol);
        labelCol.setBounds(340, 20, 90, 30);

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        menuArchivo.setText("Archivo");
        menuArchivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuArchivoMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuArchivo);

        menuReportes.setText("Reportes");
        menuReportes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuReportesMouseClicked(evt);
            }
        });
        menuReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReportesActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuReportes);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public JScrollPane configurarLineas(String texto){
        JTextPane textPane = new JTextPane();
        textPane.setText(texto);
        
        JScrollPane scrollPane = new JScrollPane(textPane);
        
        TextLineNumber lineNumber = new TextLineNumber(textPane, 3);
        lineNumber.setLabelLine(labelLine);
        lineNumber.setLabelCol(labelCol);
        
        lineNumber.setUpdateFont(false);
        float fontSize = textPane.getFont().getSize() - 6;
        Font font = textPane.getFont().deriveFont( fontSize );
        lineNumber.setForeground(Color.BLUE);
        scrollPane.setRowHeaderView( lineNumber );
        
        return scrollPane;
    }
 
    
    public void identificarPestanaSelected(){
                int selectedIndex = tabbedPane.getSelectedIndex();
                if (selectedIndex != -1) {
//                    JScrollPane scrollPane = (JScrollPane) tabbedPane.getComponentAt(selectedIndex);
                    JScrollPane scrollPane = (JScrollPane) tabbedPane.getComponentAt(selectedIndex);
                    JViewport viewport = scrollPane.getViewport();
//                    JTextArea textArea = (JTextArea) viewport.getView();
                    JTextPane cajonText = (JTextPane) viewport.getView();
                    String content = cajonText.getText();
                    textoActual = content;
//                    System.out.println("una pestana:   ");
//                    System.out.println(content);
                }
    }
            
    private void menuArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuArchivoMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto", "jc"));

        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                addTab(selectedFile.getName(), abrirArchivo(selectedFile.getAbsolutePath()));
                    
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_menuArchivoMouseClicked

    private void botonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEjecutarActionPerformed
         identificarPestanaSelected();
//        String textoNotEsc =  textoActual.replace("\\n", "\n")
//                .replace("\\t", "\t")
////                .replace("\\\"", "\"");
////                .replace("\\\\", "\\")
//                .replace("\\\'", "\'");
        
        listaErrores = new LinkedList<>();
//        String textoEjecucion = control.analizar(textoActual);  
        control.analizar(textoActual);  //realizar analisis
        listaErrores = control.getListaErrores();
                    
        setCajonConsola(control.getMconsola());
        
        tablaReport = this.control.getTablaReport();

    }//GEN-LAST:event_botonEjecutarActionPerformed

    public void llenarTablaSimbolos(){
        
        List<List<String>> listSim = new ArrayList<>();
        int contador = 0;
        for (TablaSimbolos simbolos : tablaReport) {
             HashMap<String, Object> hashSecond =simbolos.getTablaActual() ;
            for (Map.Entry<String, Object> AE : hashSecond.entrySet()) {
                contador++;
                String key2 = AE.getKey();
                Object value2 = AE.getValue();
                Simbolo sim = (Simbolo)value2;
                List <String> listInd = new ArrayList<>();
                            listInd.add(String.valueOf(contador));
                            listInd.add(sim.getId());
                            listInd.add(String.valueOf(sim.isConst()));
                            listInd.add(sim.getTipo().getTipo().toString());
                            listInd.add(simbolos.getNombre());
                            listInd.add(sim.getValor().toString());
                            listInd.add(String.valueOf(sim.getLinea()));
                            listInd.add(String.valueOf(sim.getColu()));
                listSim.add(listInd);
            }
        }
        
        Object [][]datosTabla = new Object[listSim.size()][8];       //llenando la tabla
        for (int i = 0; i < listSim.size(); i++) {
            for (int j = 0; j < listSim.get(i).size(); j++) {
                datosTabla[i][j] = listSim.get(i).get(j);
            }
        }
        
//        for (List<String> list : listSim) {
//            for (String string : list) {
//                System.out.print(string + "  ");
//            }
//            System.out.println("");
//        }
        
        
        
//        System.out.println(listaErrores.toString());


        
//        for (int i = 0; i < filas; i++) { //llenar la tabla
//            for (int j = 0; j < 6; j++) {
//                switch (j) {
//                    case 0:
//                    datosTabla[i][j] = i;
//                        break;
//                    case  1:
//                    datosTabla[i][j] = listaErrores.get(i).getTipo();
//                        break;
//                    case 2:
//                    datosTabla[i][j] = listaErrores.get(i).getDesc();
//                        
//                        break;
//                    case 3:
//                    datosTabla[i][j] = listaErrores.get(i).getLinea();
//                        
//                        break;
//                    case 4:
//                    datosTabla[i][j] = listaErrores.get(i).getColumna();
//                        break;
//                    case 5:
//                    datosTabla[i][j] = listaErrores.get(i).getColumna();
//                        break;
//                    case 6:
//                    datosTabla[i][j] = listaErrores.get(i).getColumna();
//                        break;
//                    case 7:
//                    datosTabla[i][j] = listaErrores.get(i).getColumna();
//                        break;
//                    default:
//                        System.out.println("break al llenar la tabla");
//                        break;
//                        
//                }
//
//            }
//        }
        
        
        JTable tabla;
        String[] columnasCabecerasTAblas = {"#", "ID","isConst","TIPO","ENTORNO","VALOR", "LINEA", "COLUMNA"};
        
        //        for (int i = 0; i < columnasIndices.length; i++) {
        //            columnasCabecerasTAblas[i] = textoCSv_comas[columnasIndices[i]];
        //        }

        
        DefaultTableModel model = new DefaultTableModel(listSim.size(), 8); //modelo con la cantidad de columnas y filas resultantes
        tabla = new JTable(model);
        tabla.setEnabled(false);
        model.setDataVector(datosTabla, columnasCabecerasTAblas);             //set a los datos de la tabla e ID de las columnas
        tabla.setBackground(new Color(51,51,51));
        tabla.setForeground(Color.WHITE);
        
        JScrollPane scrollErrores = new JScrollPane(tabla);
        
        
        reportes.getPanelSimbolo().add(scrollErrores);
        reportes.getPanelSimbolo().updateUI();
        
        
        
        
        
        
    }
    
    
    public void llenandoJtable(){
        
        reportes = new FrameReportes();
        int filas = listaErrores.size();
        System.out.println("LISSSS:    " + filas );
//        System.out.println(listaErrores.toString());


        Object [][]datosTabla = new Object[filas][5];   
        
        for (int i = 0; i < filas; i++) { //llenar la tabla
            for (int j = 0; j < 6; j++) {
                switch (j) {
                    case 0:
                    datosTabla[i][j] = i;
                        break;
                    case  1:
                    datosTabla[i][j] = listaErrores.get(i).getTipo();
                        break;
                    case 2:
                    datosTabla[i][j] = listaErrores.get(i).getDesc();
                        
                        break;
                    case 3:
                    datosTabla[i][j] = listaErrores.get(i).getLinea();
                        
                        break;
                    case 4:
                    datosTabla[i][j] = listaErrores.get(i).getColumna();
                        break;
                    default:
                        System.out.println("break al llenar la tabla");
                        break;
                        
                }

            }
        }
        
        
        JTable tabla;
        String[] columnasCabecerasTAblas = {"#", "Tipo","Descripcion","Linea","Columna"};
        
        //        for (int i = 0; i < columnasIndices.length; i++) {
        //            columnasCabecerasTAblas[i] = textoCSv_comas[columnasIndices[i]];
        //        }

        
        DefaultTableModel model = new DefaultTableModel(filas, 5); //modelo con la cantidad de columnas y filas resultantes
        tabla = new JTable(model);
        tabla.setEnabled(false);
        model.setDataVector(datosTabla, columnasCabecerasTAblas);             //set a los datos de la tabla e ID de las columnas
        tabla.setBackground(new Color(51,51,51));
        tabla.setForeground(Color.WHITE);
        
        JScrollPane scrollErrores = new JScrollPane(tabla);
        
        
        reportes.getPanelReportes().add(scrollErrores);
        reportes.getPanelReportes().updateUI();
        
        llenarTablaSimbolos();
    }
    
    private void botonNuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoArchivoActionPerformed
        addTabbb("START_WITH main();\n" +
                               "\n" +
                               "var global: int = 10;\n" +
                               "\n" +
                               "void main(){\n" +
                               "    println(\"Hello Word\");\n" +
                               "\n" +
                               "\n" +
                               "}");
    }//GEN-LAST:event_botonNuevoArchivoActionPerformed

    public void addTabbb(String algo){
        addTab("Nuevo archivo", algo);
    }
    
    private void menuReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReportesActionPerformed
        System.out.println("Reportess");
    }//GEN-LAST:event_menuReportesActionPerformed

    private void menuReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuReportesMouseClicked
         System.out.println("Reportess");
         llenandoJtable();
         setDefaultCloseOperation(HIDE_ON_CLOSE);
        reportes.setVisible(true);
        
                
        
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_menuReportesMouseClicked

    private void botonNuevoArchivo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoArchivo1ActionPerformed
        
    }//GEN-LAST:event_botonNuevoArchivo1ActionPerformed

    
    public void setCajonConsola(String resultados){
        cajonConsola.setText(resultados);
    }
            
            
    private void addTab(String title, String content) {
        JTextArea textArea = new JTextArea(content);
         
                                        textArea.setLineWrap(true);
                                        textArea.setWrapStyleWord(true);
        textArea.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        textArea.setCaretColor(new java.awt.Color(255, 51, 0));

        textArea.setEditable(true);
        JScrollPane scrollPane;
        scrollPane = configurarLineas(content);
        tabbedPane.addTab(title, scrollPane);
        int tabIndex = tabbedPane.indexOfComponent(scrollPane);
                                    tabbedPane.setTabComponentAt(tabIndex, new ClosableTabComponent(title));




//  // Etiquetas globales para mostrar la línea y columna  
//    JTextArea textArea = new JTextArea(content);
//    
//    // Agregar el CaretListener para cada JTextArea
//    textArea.addCaretListener(new CaretListener() {
//        public void caretUpdate(CaretEvent e) {
//            int caretPos = textArea.getCaretPosition();
//            try {
//                int line = textArea.getLineOfOffset(caretPos) + 1;
//                int col = caretPos - textArea.getLineStartOffset(line - 1) + 1;
//                
//                // Actualizar los JLabel globales con la información de línea y columna
//                labelLine.setText("Line: " + line);
//                labelCol.setText("Col: " + col);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//    });
//    
//    textArea.setLineWrap(true);
//    textArea.setWrapStyleWord(true);
//    textArea.setCaretColor(new java.awt.Color(255, 51, 0));
//    textArea.setEditable(true);
//    
//    // Crear JScrollPane y agregar el área de texto
//    JScrollPane scrollPane = new JScrollPane(textArea);
//    
//    // Agregar la pestaña al JTabbedPane
//    tabbedPane.addTab(title, scrollPane);
//    int tabIndex = tabbedPane.indexOfComponent(scrollPane);
//    tabbedPane.setTabComponentAt(tabIndex, new ClosableTabComponent(title));
//    
//    // Detectar cuando una pestaña es seleccionada
//    tabbedPane.addChangeListener(e -> {
//        // Solo actualizamos si la pestaña seleccionada es esta
//        if (tabbedPane.getSelectedComponent() == scrollPane) {
//            int caretPos = textArea.getCaretPosition();
//            try {
//                int line = textArea.getLineOfOffset(caretPos) + 1;
//                int col = caretPos - textArea.getLineStartOffset(line - 1) + 1;
//                
//                // Actualizar las etiquetas con la posición actual del cursor
//                labelLine.setText("Line: " + line);
//                labelCol.setText("Col: " + col);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//    });

 




//        tabbedPane.addTab(title, scrollPane);
//        int tabIndex = tabbedPane.indexOfComponent(scrollPane);
//                                    tabbedPane.setTabComponentAt(tabIndex, new ClosableTabComponent(title));
 
 
    }

    
    
    private void ininicializarPestañas() {
        String uno = readResourceFile("archivo1.jc");
        String dos = readResourceFile("archivo2.jc");
        String tres = readResourceFile("archivo3.jc");
        addTabbb(uno);
        addTabbb(dos);
        addTabbb(tres);
        
        
    }
    
    

    public String readResourceFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }        
        
    class ClosableTabComponent extends JPanel {
        public ClosableTabComponent(String title) {
            setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            setOpaque(false);

            JLabel label = new JLabel(title);
            add(label);

            JButton button = new JButton("x");
            button.setBorder(null);
            button.setMargin(new Insets(0, 0, 0, 0));
            button.setPreferredSize(new Dimension(15, 15));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int index = tabbedPane.indexOfTabComponent(ClosableTabComponent.this);
                    if (index != -1) {
                        tabbedPane.remove(index);
                    }
                }
            });
            add(button);
        }
    }
    
        
    public String abrirArchivo(String rutaFile){
         String texto = " ";
        try {
            // Leer todas las líneas del archivo y guardarlas en una lista
            List<String> linea_lineas = new ArrayList<>(); 
            linea_lineas = Files.readAllLines(Paths.get(rutaFile));
            for (int i = 0; i < linea_lineas.size(); i++) {
                texto += linea_lineas.get(i); 
                    if(i != (linea_lineas.size()-1)){
                        texto +=  "\n"; 
                    }
            }
        } catch (IOException e) {
            // Manejar el caso en el que ocurra un error de lectura
            System.out.println("Error al leer el archivo (clase crearArchivos): " + e.getMessage());
        }
        return texto;
    }   
    

    
//    public static void main(String args[]) {
//     
//     
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                VistaGeneral vista = new VistaGeneral();
//                vista.setVisible(true);
//                vista.setBounds(0, 0, 1100, 800);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEjecutar;
    private javax.swing.JButton botonNuevoArchivo;
    private javax.swing.JButton botonNuevoArchivo1;
    private javax.swing.JTextArea cajonConsola;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCol;
    private javax.swing.JLabel labelLine;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JPanel panelCajonTexto;
    // End of variables declaration//GEN-END:variables
}
