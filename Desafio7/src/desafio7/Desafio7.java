/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package desafio7;

import Controlador.Controlador;
import Controlador.ControladorTareas;
import Modelo.Conversor;
import Modelo.GestorTareas;
import Vista.Vista;
import Vista.VistaTareas;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Desafio7 {

    public static void main(String[] args) {

        // Aseguramos que la UI se cree en el hilo de Swing
        SwingUtilities.invokeLater(() -> {

            String[] opciones = {
                "Conversor de Temperatura",
                "Gestor de Tareas"
            };

            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "¿Qué ejercicio querés probar?",
                    "Desafío 7",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            if (opcion == 0) {
                // Ejercicio 1 — Conversor de Temperatura
                Conversor modelo = new Conversor();
                Vista vista = new Vista();
                new Controlador(modelo, vista);
                vista.setVisible(true);

            } else if (opcion == 1) {
                // Ejercicio 2 — Gestor de Tareas
                GestorTareas modelo = new GestorTareas();
                VistaTareas vista = new VistaTareas();
                new ControladorTareas(modelo, vista);
                vista.setVisible(true);
            }
        });
    }
}
