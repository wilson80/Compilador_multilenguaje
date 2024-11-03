/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.wilsoncys.compi1.java.vistas;

import com.wilsoncys.compi1.java.control.Control;
import com.wilsoncys.compi1.java.control.CppRunn;
import com.wilsoncys.compi1.java.model.analisis.colorear2;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.model.simbolo.Simbolo;
import com.wilsoncys.compi1.java.model.simbolo.TablaSimbolos;
import com.wilsoncys.compi1.java.vistas.colorInfo;
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
import java.io.StringReader;
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
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel; 

//colores
import javax.swing.text.Style; 
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;





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
    private JTextPane paneActual;
    
    
    
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
        botonEjecutar = new javax.swing.JButton();
        botonNuevoArchivo = new javax.swing.JButton();
        botonNuevoArchivo1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelLine = new javax.swing.JLabel();
        labelCol = new javax.swing.JLabel();
        botonc = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cajonConsola = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelReportes = new javax.swing.JPanel();
        panelSimbolo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuReportes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panelCajonTexto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        panelCajonTexto.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelCajonTexto);
        panelCajonTexto.setBounds(10, 60, 650, 860);

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
        botonEjecutar.setBounds(1150, 10, 80, 40);

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
        botonNuevoArchivo1.setText("otra cosa");
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

        botonc.setBackground(new java.awt.Color(0, 102, 255));
        botonc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonc.setForeground(new java.awt.Color(255, 255, 255));
        botonc.setText("Run c++");
        botonc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncActionPerformed(evt);
            }
        });
        getContentPane().add(botonc);
        botonc.setBounds(770, 10, 110, 40);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setLayout(null);

        cajonConsola.setColumns(20);
        cajonConsola.setRows(5);
        jScrollPane1.setViewportView(cajonConsola);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 760, 800);

        jTabbedPane1.addTab("C3d", jPanel2);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(null);

        jLabel2.setText("Reportes Errores");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 6, 520, 25);

        panelReportes.setBackground(new java.awt.Color(102, 102, 102));
        panelReportes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelReportes.setLayout(new java.awt.GridLayout(0, 1));
        jPanel1.add(panelReportes);
        panelReportes.setBounds(6, 49, 1220, 270);

        panelSimbolo.setBackground(new java.awt.Color(102, 102, 102));
        panelSimbolo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelSimbolo.setLayout(new java.awt.BorderLayout());
        jPanel1.add(panelSimbolo);
        panelSimbolo.setBounds(10, 400, 1210, 390);

        jLabel3.setText("Reporta Tabla de simbolos");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 360, 520, 25);

        jTabbedPane1.addTab("Errores", jPanel1);
        jTabbedPane1.addTab("algo", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(670, 60, 1230, 840);

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


//    public JScrollPane configurarLineas(String texto){
//        JTextPane textPane = new JTextPane();
//        textPane.setText(texto);
//        
//        JScrollPane scrollPane = new JScrollPane(textPane);
//        
//        TextLineNumber lineNumber = new TextLineNumber(textPane, 3);
//        lineNumber.setLabelLine(labelLine);
//        lineNumber.setLabelCol(labelCol);
//        
//        lineNumber.setUpdateFont(false);
//        float fontSize = textPane.getFont().getSize() - 6;
//        Font font = textPane.getFont().deriveFont( fontSize );
//        lineNumber.setForeground(Color.BLUE);
//        scrollPane.setRowHeaderView( lineNumber );
//        
//          return scrollPane;
//    }
 
    
    
    
    public JScrollPane configurarLineas(String texto) {
    JTextPane textPane = new JTextPane();
    textPane.setText(texto);
  
        Timer timer = new Timer(500, e -> {
        SetColor setColorThread = new SetColor(textPane);
        setColorThread.start();
    });
    timer.setRepeats(false); // Asegúrate de que el temporizador no repita

    // Agrega el DocumentListener para colorear el texto al escribir
    textPane.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            timer.restart(); // Reinicia el temporizador en cada inserción
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            timer.restart(); // Reinicia el temporizador en cada eliminación
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // No se necesita implementar en este caso
        }
    });
    
//    // Agrega el DocumentListener para colorear el texto al escribir
//    textPane.getDocument().addDocumentListener(new DocumentListener() {
//        @Override
//        public void insertUpdate(DocumentEvent e) {
//            SetColor setColorThread = new SetColor(textPane);
//            setColorThread.start();
////            colorearTexto(textPane);
////            panelCajonTexto.updateUI();
//        }
//
//        @Override
//        public void removeUpdate(DocumentEvent e) {
//            SetColor setColorThread = new SetColor(textPane);
//            setColorThread.start();
////            colorearTexto(textPane);
//        }
//
//        @Override
//        public void changedUpdate(DocumentEvent e) {
////            colorearTexto(textPane);
//        }
//    });
    
    JScrollPane scrollPane = new JScrollPane(textPane);
    
    // Configuración del número de líneas
    TextLineNumber lineNumber = new TextLineNumber(textPane, 3);
    lineNumber.setLabelLine(labelLine);
    lineNumber.setLabelCol(labelCol);
    lineNumber.setUpdateFont(false);
    float fontSize = textPane.getFont().getSize() - 6;
    Font font = textPane.getFont().deriveFont(fontSize);
    lineNumber.setForeground(Color.BLUE);
    scrollPane.setRowHeaderView(lineNumber);
    
    return scrollPane;
}

// Método para aplicar colores usando JFlex
 

    
    
    
    
    public void identificarPestanaSelected(){
         
                int selectedIndex = tabbedPane.getSelectedIndex();
                if (selectedIndex != -1) {
                    JScrollPane scrollPane = (JScrollPane) tabbedPane.getComponentAt(selectedIndex);
                    JViewport viewport = scrollPane.getViewport();
                    JTextPane cajonText = (JTextPane) viewport.getView();
                    this.paneActual = cajonText; 
                    
                    String content = cajonText.getText();
                    textoActual = content;
                }
    }
            
    
    
    private void menuArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuArchivoMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto", "mlg"));

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
        setCajonConsola("-----");
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

        panelSimbolo.removeAll();
        panelReportes.removeAll();
        llenandoJtable();
        panelReportes.updateUI();
        panelSimbolo.updateUI();
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
        
        
        panelSimbolo.add(scrollErrores);
        panelSimbolo.updateUI();
        
        
        
        
        
        
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
        
        
        panelReportes.add(scrollErrores);
        panelReportes.updateUI();
        
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
//         System.out.println("Reportess");
//         llenandoJtable();
//         setDefaultCloseOperation(HIDE_ON_CLOSE);
//        reportes.setVisible(true);
        
// TODO add your handling code here:
    }//GEN-LAST:event_menuReportesMouseClicked

    private void botonNuevoArchivo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoArchivo1ActionPerformed
        
    }//GEN-LAST:event_botonNuevoArchivo1ActionPerformed

    private void botoncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncActionPerformed
        CppRunn run = new CppRunn();
        run.crearYEjecutarCpp(control.getMconsola());
    }//GEN-LAST:event_botoncActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
//        llenandoJtable();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        panelReportes.removeAll();
        llenandoJtable();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    
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
 
    }

    
    
    private void ininicializarPestañas() {
        String tres = readResourceFile("archivo3.jc");
        String uno = readResourceFile("archivo1.jc");
        String dos = readResourceFile("archivo2.jc");
        addTabbb(tres);
        addTabbb(uno);
        addTabbb(dos);
        
        
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
    private javax.swing.JButton botonc;
    private javax.swing.JTextArea cajonConsola;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelCol;
    private javax.swing.JLabel labelLine;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JPanel panelCajonTexto;
    private javax.swing.JPanel panelReportes;
    private javax.swing.JPanel panelSimbolo;
    // End of variables declaration//GEN-END:variables
}
