package sistemaPuntuacion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SistemaPuntuacion {
    private List<Criterios> criterio;
    private List<Jugador> jugadores;
    private List<Evaluacion> evaluaciones;

    public SistemaPuntuacion() {
        this.criterio = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.evaluaciones = new ArrayList<>();
    }

    public void agregarCriterio(String nombre, int peso) {
        criterio.add(new Criterios(nombre, peso));
    }

    public Criterios obtenerCriterio(String nombre) {
        return criterio.stream()
                .filter(criterio -> criterio.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Criterio no encontrado."));
    }

    public void agregarJugador(String nombre, String clase, String especializacion) {
        Jugador jugador = new Jugador(nombre, clase, especializacion);
        jugadores.add(jugador);
        evaluaciones.add(new Evaluacion(jugador, criterio)); // Crear evaluación para el jugador
    }

    public Evaluacion obtenerEvaluacionPorJugador(String nombreJugador) {
        return evaluaciones.stream()
                .filter(evaluacion -> evaluacion.getJugador().getNombre().equalsIgnoreCase(nombreJugador))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Jugador no encontrado."));
    }

    public void mostrarResultados() {
        for (Evaluacion evaluacion : evaluaciones) {
            System.out.println("Jugador: " + evaluacion.getJugador());
            System.out.println("Puntuaciones:");
            evaluacion.getPuntuaciones().forEach((criterio, puntuacion) -> 
                System.out.println("- " + criterio.getNombre() + ": " + puntuacion));
            System.out.println("Puntuación Total: " + evaluacion.calcularPuntuacionTotal());
            System.out.println();
        }
    }

    public void guardarResultadosEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Evaluacion evaluacion : evaluaciones) {
                writer.write("Jugador: " + evaluacion.getJugador() + "\n");
                writer.write("Puntuaciones:\n");
                for (var entry : evaluacion.getPuntuaciones().entrySet()) {
                    writer.write("- " + entry.getKey().getNombre() + ": " + entry.getValue() + "\n");
                }
                writer.write("Puntuación Total: " + evaluacion.calcularPuntuacionTotal() + "\n\n");
            }
            System.out.println("Resultados guardados en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
