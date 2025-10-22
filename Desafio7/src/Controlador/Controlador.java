/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



package Controlador;

import Modelo.Conversor;
import Vista.Vista;

import javax.swing.*;

public class Controlador {

    private final Conversor modelo;
    private final Vista vista;

    public Controlador(Conversor modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Enlazar acción del botón
        this.vista.btnConvertir.addActionListener(e -> convertir());
    }

    private void convertir() {
        try {
            double valor = Double.parseDouble(vista.txtValor.getText().trim());
            String tipo = (String) vista.cmbTipo.getSelectedItem();

            double res = (tipo != null && tipo.startsWith("Celsius"))
                    ? modelo.celsiusAFahrenheit(valor)
                    : modelo.fahrenheitACelsius(valor);

            vista.lblResultado.setText(String.format("Resultado: %.2f", res));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista,
                    "Ingresá un número válido.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE);
            vista.txtValor.requestFocus();
        }
    }

    // Punto de entrada
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Conversor modelo = new Conversor();
            Vista vista = new Vista();
            new Controlador(modelo, vista);
            vista.setVisible(true);
        });
    }
}
