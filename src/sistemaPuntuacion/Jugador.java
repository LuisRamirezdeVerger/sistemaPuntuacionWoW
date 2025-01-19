package sistemaPuntuacion;

public class Jugador {

	private String nombre;
	private String clase;
	private String especializacion;
	
	public Jugador (String nombre, String clase, String especializacion) {
		this.nombre = nombre;
		this.clase = clase;
		this.especializacion = especializacion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getClase() {
		return this.clase;
	}
	
	public String getEspecializacion() {
		return this.especializacion;
	}
	
	@Override
	public String toString() {
        return "Nombre: " + nombre + ", Clase: " + clase + ", Especialización: " + especializacion;
	}
}
