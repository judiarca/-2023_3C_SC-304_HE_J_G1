package Estructura_Datos;

import proyectogrupo1.Pasajero;

/**
 *
 * @author RouryR
 */

public class Nodo_cola {
    Pasajero pasajero;
    Nodo_cola siguiente;
    Nodo_cola anterior;
    private int estacionOrigen;
    private int estacionDestino;


    public Nodo_cola(Pasajero pasajero) {
        this.pasajero = pasajero;
        this.siguiente = null;
        this.anterior = null;
        this.estacionOrigen = pasajero.getEstacion_Origen();
        this.estacionDestino = pasajero.getEstacion_Destino();
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public Nodo_cola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo_cola siguiente) {
        this.siguiente = siguiente;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Nodo_cola getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo_cola anterior) {
        this.anterior = anterior;
    }

    public int getEstacionOrigen() {
        return estacionOrigen;
    }

    public int getEstacionDestino() {
        return estacionDestino;
    }
    
    

    
}


