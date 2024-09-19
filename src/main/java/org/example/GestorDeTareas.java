package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GestorDeTareas {
    private List<Tarea> tareas = new ArrayList<>();
    private int idCounter = 1;
    private final String archivo = "tareas.json";
    private Gson gson = new Gson();

    public GestorDeTareas() {
        cargarTareas();
    }

    // Método para crear una nueva tarea
    public void agregarTarea(String titulo, String descripcion, String fechaVencimiento) {
        Tarea nuevaTarea = new Tarea(idCounter++, titulo, descripcion, fechaVencimiento);
        tareas.add(nuevaTarea);
        guardarTareas();
        System.out.println("Tarea añadida exitosamente.");
    }

    // Método para listar todas las tareas
    public void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas disponibles.");
        } else {
            for (Tarea tarea : tareas) {
                System.out.println(tarea);
            }
        }
    }

    // Método para actualizar una tarea por ID
    public void actualizarTarea(int id, String nuevoTitulo, String nuevaDescripcion, String nuevaFecha) {
        Tarea tarea = buscarTareaPorId(id);
        if (tarea != null) {
            tarea.setTitulo(nuevoTitulo);
            tarea.setDescripcion(nuevaDescripcion);
            tarea.setFechaVencimiento(nuevaFecha);
            guardarTareas();
            System.out.println("Tarea actualizada.");
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }

    // Método para eliminar una tarea por ID
    public void eliminarTarea(int id) {
        Tarea tarea = buscarTareaPorId(id);
        if (tarea != null) {
            tareas.remove(tarea);
            guardarTareas();
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }

    // Método para buscar una tarea por ID
    private Tarea buscarTareaPorId(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                return tarea;
            }
        }
        return null;
    }

    // Método para buscar tareas por título
    public void buscarTareasPorTitulo(String titulo) {
        boolean encontrada = false;
        for (Tarea tarea : tareas) {
            if (tarea.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                System.out.println(tarea);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No se encontraron tareas con ese título.");
        }
    }

    // Método para buscar tareas por estado (completadas/no completadas)
    public void buscarTareasPorEstado(boolean completada) {
        boolean encontrada = false;
        for (Tarea tarea : tareas) {
            if (tarea.isCompletada() == completada) {
                System.out.println(tarea);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No se encontraron tareas con ese estado.");
        }
    }

    // Método para guardar las tareas en un archivo JSON
    private void guardarTareas() {
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(tareas, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar las tareas: " + e.getMessage());
        }
    }

    // Método para cargar las tareas desde un archivo JSON
    private void cargarTareas() {
        try (FileReader reader = new FileReader(archivo)) {
            tareas = gson.fromJson(reader, new TypeToken<List<Tarea>>() {}.getType());
            if (tareas != null && !tareas.isEmpty()) {
                idCounter = tareas.get(tareas.size() - 1).getId() + 1;
            } else {
                tareas = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("No se encontró el archivo, iniciando con una lista vacía.");
        }
    }

    public void marcarTareaComoCompletada(int id, boolean completada) {
        Tarea tarea = buscarTareaPorId(id);
        if (tarea != null) {
            tarea.setCompletada(completada);
            guardarTareas();
            System.out.println("Tarea " + (completada ? "completada" : "marcada como incompleta") + " exitosamente.");
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }
}
