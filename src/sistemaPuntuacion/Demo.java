package sistemaPuntuacion;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        SistemaPuntuacion sistema = new SistemaPuntuacion();
        Scanner scanner = new Scanner(System.in);

        // Definir criterios iniciales
        sistema.agregarCriterio("Puntualidad", 2);
        sistema.agregarCriterio("Actitud", 3);
        sistema.agregarCriterio("Mecánicas", 5);
        sistema.agregarCriterio("Consumibles", 1);

        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== Menú ===");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Modificar puntuación");
            System.out.println("3. Mostrar resultados");
            System.out.println("4. Guardar resultados en archivo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del jugador: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Clase del jugador: ");
                    String clase = scanner.nextLine();
                    System.out.print("Especialización del jugador: ");
                    String especializacion = scanner.nextLine();
                    sistema.agregarJugador(nombre, clase, especializacion);
                    System.out.println("Jugador agregado con éxito.");
                    break;
                case 2:
                    System.out.print("Nombre del jugador a modificar: ");
                    String nombreJugador = scanner.nextLine();
                    System.out.print("Criterio a modificar: ");
                    String criterio = scanner.nextLine();
                    System.out.print("Cambio en la puntuación (puede ser negativo): ");
                    int cambio = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    try {
                        sistema.obtenerEvaluacionPorJugador(nombreJugador)
                               .modificarPuntuacion(sistema.obtenerCriterio(criterio), cambio);
                        System.out.println("Puntuación modificada con éxito.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    sistema.mostrarResultados();
                    break;
                case 4:
                    System.out.print("Guardando... ");
                    String archivo = "Core.txt";
                    sistema.guardarResultadosEnArchivo(archivo);
                    break;
                case 5:
                    salir = true;
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
