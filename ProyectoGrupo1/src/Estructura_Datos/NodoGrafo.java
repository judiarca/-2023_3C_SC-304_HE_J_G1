
package Estructura_Datos;

public class NodoGrafo {
    private final int km;
    private final int minutos;

    public NodoGrafo(int _km, int _minutos) {
        this.km = _km;
        this.minutos = _minutos;
    }

    public int getKm() {
        return this.km;
    }

    public int getMinutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        return "KM: " + this.km + ", Distancia: " + this.minutos;
    }
}

