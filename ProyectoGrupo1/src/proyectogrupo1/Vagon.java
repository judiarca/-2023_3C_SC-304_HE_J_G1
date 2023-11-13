/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

/**
 *
 * @author moise
 */
public class Vagon {

    private Pila[] asientos;
    private int capacidadMaxima;
    private int capacidadMaximaDisc;

    public Vagon(int numFilas,  int numFilasDisc) {
        this.asientos = new Pila[numFilas];
        this.asientos = new Pila[numFilasDisc];
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadMaximaDisc = capacidadMaximaDisc;
        for (int i = 0; i < numFilas; i++) {
            asientos[i] = new Pila(capacidadMaxima);
        }
         for (int i = 0; i < numFilasDisc; i++) {
            asientos[i] = new Pila(capacidadMaximaDisc);
        }
    }
    
// cambiar este for each por un metodo distinto que no lo use 
    public boolean subirPasajero(Pasajero pasajero) {
        for (Pila fila : asientos) {
            if (!fila.estaLlena()) {
                fila.apilar(pasajero);
                return true;
            }
        }
        return false;
    }

    public String imprimirEstadoVagon() {
        StringBuilder resultado = new StringBuilder();

        resultado.append("Estado Actual del Vagon\n");

        for (int i = 0; i < asientos.length; i++) {
            resultado.append("Fila ").append(i + 1).append(": ");
            resultado.append(asientos[i].imprimirPila()).append("\n");
        }

        resultado.append("Capacidad Máxima: ").append(capacidadMaxima).append("\n");
        resultado.append("Espacios Disponibles: ").append(obtenerEspaciosDisponibles()).append("\n");

        return resultado.toString();
    }

    public int obtenerEspaciosDisponibles() {
        int espaciosDisponibles = 0;
        for (Pila fila : asientos) {
            espaciosDisponibles += fila.contarCapacidad();
        }
        return espaciosDisponibles;
    }

}//Final de la clase 
