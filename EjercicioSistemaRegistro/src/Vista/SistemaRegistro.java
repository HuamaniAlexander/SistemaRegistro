package Vista;

import Controlador.GestionLenguaje;
import Modelo.LenguajeProgramacion;
import java.util.Scanner;

public class SistemaRegistro {
    // Creación de un objeto de la clase GestionLenguaje para manejar los lenguajes
    private static GestionLenguaje gestor = new GestionLenguaje();
    // Se instancia el Scanner para leer la entrada del usuario
    private static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        // Llama al método menu para mostrar las opciones
        menu(); 
    }

    // MÉTODO VACIO
    // Muestra el menu de opciones
    private static void menu() {
        int opcion;
        do {
            System.out.println("═════════════════════════════════════════════════════");
            System.out.println("     SISTEMA DE LENGUAJES DE PROGRAMACIÓN      ");
            System.out.println("═════════════════════════════════════════════════════");
            System.out.println("  [1] Agregar nuevo lenguaje                   ");
            System.out.println("  [2] Buscar lenguaje                          ");
            System.out.println("  [3] Eliminar lenguaje                        ");
            System.out.println("  [4] Ver todos los lenguajes                  ");
            System.out.println("  [5] Salir                                    ");
            System.out.println("═════════════════════════════════════════════════════");
            System.out.print("Seleccione una opción: ");

            opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                // Agregar un nuevo lenguaje
                case 1 -> {
                    System.out.println("\n=== AGREGAR NUEVO LENGUAJE ===");

                    System.out.print("Nombre: ");
                    String nombre = lector.nextLine();

                    System.out.print("Año de creación: ");
                    int anioCreacion = lector.nextInt();
                    lector.nextLine();

                    System.out.print("Característica principal: ");
                    String caracteristica = lector.nextLine();

                    System.out.print("Utilización: ");
                    String utilizacion = lector.nextLine();

                    gestor.agregarLenguaje(anioCreacion, caracteristica, nombre, utilizacion);
                }
                // Buscar un lenguaje
                case 2 -> {
                    System.out.print("\nIngrese el nombre del lenguaje a buscar: ");
                    String nombre = lector.nextLine();

                    LenguajeProgramacion lenguaje = gestor.buscarLenguaje(nombre);
                    if (lenguaje != null) {
                        System.out.println("\nLENGUAJE ENCONTRADO:");
                        System.out.println(lenguaje.toString());
                    } else {
                        System.out.println("LENGUAJE NO ENCONTRADO.");
                    }
                }
                // Eliminar un lenguaje
                case 3 -> {
                    System.out.print("\nIngrese el nombre del lenguaje a eliminar: ");
                    String nombre = lector.nextLine();

                    if (gestor.eliminarLenguaje(nombre)) {
                        System.out.println("Lenguaje eliminado exitosamente.");
                    } else {
                        System.out.println("Lenguaje no encontrado.");
                    }
                }
                // Ver todos los lenguajes
                case 4 -> gestor.imprimirLenguajes();
                // Salir del programa
                case 5 -> System.out.println("Cerrando programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
}
