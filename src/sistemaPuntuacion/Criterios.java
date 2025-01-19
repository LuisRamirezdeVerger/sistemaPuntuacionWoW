package sistemaPuntuacion;

public class Criterios {
    private String nombre;
    private int peso;

    public Criterios(String nombre, int peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPeso() {
        return peso;
    }
}
