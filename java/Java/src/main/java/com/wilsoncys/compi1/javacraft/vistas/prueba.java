/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.compi1.javacraft.vistas;

/**
 *
 * @author Jonwil
 */
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class prueba extends JFrame {

    private JTabbedPane tabbedPane;

    public prueba() {
        setTitle("Visor de Archivos de Texto en Pestañas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem openFileItem = new JMenuItem("Abrir archivo...");

        openFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        fileMenu.add(openFileItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        add(tabbedPane, BorderLayout.CENTER);

        tabbedPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndex = tabbedPane.getSelectedIndex();
                if (selectedIndex != -1) {
                    JScrollPane scrollPane = (JScrollPane) tabbedPane.getComponentAt(selectedIndex);
                    JViewport viewport = scrollPane.getViewport();
                    JTextArea textArea = (JTextArea) viewport.getView();
                    String content = textArea.getText();
                    JOptionPane.showMessageDialog(prueba.this, content, "Contenido de la pestaña", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto", "txt"));

        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                String content = readFile(selectedFile);
                addTab(selectedFile.getName(), content);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String readFile(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        try ( BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private void addTab(String title, String content) {
        JTextArea textArea = new JTextArea(content);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        tabbedPane.addTab(title, scrollPane);
        int tabIndex = tabbedPane.indexOfComponent(scrollPane);
        tabbedPane.setTabComponentAt(tabIndex, new ClosableTabComponent(title));
    }

    class ClosableTabComponent extends JPanel {

        public ClosableTabComponent(String title) {
            setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            setOpaque(false);

            JLabel label = new JLabel(title);
            add(label);

            JButton button = new JButton("x");
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                prueba viewer = new prueba();
                viewer.setVisible(true);
            }
        });
    }
}
