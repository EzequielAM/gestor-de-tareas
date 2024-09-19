package org.example;

public class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private String fechaVencimiento;
    private boolean completada;

    public Tarea(int id, String titulo, String descripcion, String fechaVencimiento) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.completada = false; // Por defecto la tarea no está completada
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Titulo: " + titulo + ", Descripción: " + descripcion +
                ", Fecha de Vencimiento: " + fechaVencimiento + ", Completada: " + (completada ? "Sí" : "No");
    }
}
