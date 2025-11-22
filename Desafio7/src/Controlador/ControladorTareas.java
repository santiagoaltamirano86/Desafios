/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.GestorTareas;
import Modelo.Tarea;
import Vista.VistaTareas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ControladorTareas implements ActionListener {

    private GestorTareas modelo;
    private VistaTareas vista;
    private DefaultListModel<String> modeloLista;   // ← String en lugar de Tarea

    public ControladorTareas(GestorTareas modelo, VistaTareas vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Modelo para la JList
        modeloLista = new DefaultListModel<>();
        vista.getLstTareas().setModel(modeloLista);

        // Eventos
        vista.getBtnAgregar().addActionListener(this);
        vista.getBtnMarcarCompletada().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == vista.getBtnAgregar()) {
            agregarTarea();
        } else if (src == vista.getBtnMarcarCompletada()) {
            marcarCompletada();
        }
    }

    private void agregarTarea() {
        String texto = vista.getTxtNuevaTarea().getText().trim();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(vista,
                    "Ingrese un nombre para la tarea",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        modelo.agregarTarea(texto);
        vista.getTxtNuevaTarea().setText("");
        actualizarLista();
    }

    private void marcarCompletada() {
        int indice = vista.getLstTareas().getSelectedIndex();
        if (indice == -1) {
            JOptionPane.showMessageDialog(vista,
                    "Seleccione una tarea de la lista",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        modelo.marcarCompletada(indice);
        actualizarLista();
    }

    private void actualizarLista() {
        modeloLista.clear();
        for (Tarea t : modelo.getTareas()) {
            modeloLista.addElement(t.toString());  // ← ahora cargamos el texto
        }
    }
}
