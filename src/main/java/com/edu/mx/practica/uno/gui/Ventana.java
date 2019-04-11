package com.edu.mx.practica.uno.gui;

import com.edu.mx.practica.uno.convertidor.Convertidor;
import com.edu.mx.practica.uno.Persona.Datos;
import org.json.JSONObject;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{
    private JTextArea entrada, salida;
    private JButton JBconvertir;
    private JComboBox selector;
    private JPanel Principal;
    private JScrollPane barra,barra2;
    String[] Persona;
    Datos d;
    Convertidor convertidor;


    public Ventana() {
        this.setSize(700, 600);
        Principal = new JPanel();
        Principal.setBounds(0, 0, 750, 500);
        Principal.setLayout(null);
        entrada = new JTextArea();
        barra = new JScrollPane(entrada);
        barra.setBounds(10, 20, 250, 400);
        salida = new JTextArea();
        barra2 = new JScrollPane(salida);
        barra2.setBounds(420, 20, 250, 400);
        JBconvertir = new JButton("Convertir");
        JBconvertir.setBounds(300, 240, 100, 30);
        selector = new JComboBox();
        selector.setBounds(100, 440, 100, 30);
        selector.addItem("XML");
        selector.addItem("Java");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(Principal);
        Principal.add(JBconvertir);
        Principal.add(selector);
        Principal.add(barra);
        Principal.add(barra2);
        inicializar();
    }

    public void inicializar(){
        JBconvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selector.getSelectedItem() == "XML") {
                    String textoEntrada = entrada.getText();
                    if (textoEntrada.trim().length() == 0) {
                    } else {
                        convertidor = new Convertidor();
                        JSONObject textoConvertido = convertidor.convertirXmToJson(textoEntrada);
                        salida.setText("");
                        salida.setText(textoConvertido.toString());
                    }
                }
            }
        });

        JBconvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selector.getSelectedItem() == "Java") {
                    String textoEntrada = entrada.getText();
                    if (textoEntrada.trim().length() == 0) {
                    } else {
                        convertidor = new Convertidor();
                        Persona = textoEntrada.split(" ");
                        d = new Datos(Persona[0],Persona[1],Persona[2]);
                        String resultado = convertidor.Objecttojson(d);
                        salida.setText("");
                        salida.setText(resultado);
                    }
                }
            }
        });
    }
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }

}