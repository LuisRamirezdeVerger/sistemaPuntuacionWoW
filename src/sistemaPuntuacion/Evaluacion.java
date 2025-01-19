package sistemaPuntuacion;
import java.util.*;

public class Evaluacion {

	private Jugador jugador;
	private Map<Criterios, Integer> puntuaciones;
	
	public Evaluacion(Jugador jugador, List<Criterios> criterio) {
		this.jugador = jugador;
		this.puntuaciones = new HashMap<>();
		
		for (Criterios criterios : criterio) {
			puntuaciones.put(criterios, 0); //Inicializar todas las puntuaciones en 0
		}
	}
	
	public void modificarPuntuacion(Criterios criterios, int cambio) {
		puntuaciones.put(criterios, puntuaciones.getOrDefault(criterios, 0) + cambio);
	}
	
	public Map<Criterios, Integer> getPuntuaciones(){
		return puntuaciones;
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	
	public int calcularPuntuacionTotal() {
		return puntuaciones.entrySet().stream()
				.mapToInt(entry -> entry.getValue() * entry.getKey().getPeso())
				.sum();
	}
}
