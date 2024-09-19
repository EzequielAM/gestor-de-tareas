package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorDeTareas gestor = new GestorDeTareas();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de Gestión de Tareas ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Actualizar tarea");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Buscar tareas por título");
            System.out.println("6. Buscar tareas por estado (completadas/no completadas)");
            System.out.println("7. Marcar tarea como completada/incompleta");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Fecha de vencimiento: ");
                    String fecha = scanner.nextLine();
                    gestor.agregarTarea(titulo, descripcion, fecha);
                    break;
                case 2:
                    gestor.listarTareas();
                    break;
                case 3:
                    System.out.print("ID de la tarea a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Nuevo título: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.print("Nueva descripción: ");
                    String nuevaDescripcion = scanner.nextLine();
                    System.out.print("Nueva fecha de vencimiento: ");
                    String nuevaFecha = scanner.nextLine();
                    gestor.actualizarTarea(idActualizar, nuevoTitulo, nuevaDescripcion, nuevaFecha);
                    break;
                case 4:
                    System.out.print("ID de la tarea a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    gestor.eliminarTarea(idEliminar);
                    break;
                case 5:
                    System.out.print("Ingrese el título para buscar: ");
                    String tituloBusqueda = scanner.nextLine();
                    gestor.buscarTareasPorTitulo(tituloBusqueda);
                    break;
                case 6:
                    System.out.print("¿Buscar tareas completadas? (true/false): ");
                    boolean estadoBusqueda = scanner.nextBoolean();
                    gestor.buscarTareasPorEstado(estadoBusqueda);
                    break;
                case 7:
                    System.out.print("ID de la tarea a marcar como completada/incompleta: ");
                    int idMarcar = scanner.nextInt();
                    System.out.print("¿Marcar como completada? (true/false): ");
                    boolean completada = scanner.nextBoolean();
                    gestor.marcarTareaComoCompletada(idMarcar, completada);
                    break;
                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}

