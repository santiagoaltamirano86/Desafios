/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class GestorTareas {
    private List<Tarea> tareas;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
    }

    // Agregar una tarea nueva
    public void agregarTarea(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return; // no agrega vacíos
        }
        tareas.add(new Tarea(nombre.trim()));
    }

    // Marcar una tarea como completada según su índice
    public void marcarCompletada(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.get(indice).marcarCompletada();
        }
    }

    // (Opcional) Eliminar tarea
    public void eliminarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.remove(indice);
        }
    }

    // Devolver la lista completa (para que el controlador la use)
    public List<Tarea> getTareas() {
        return tareas;
    }
}
