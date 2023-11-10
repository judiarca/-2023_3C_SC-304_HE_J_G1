/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

/**
 *
 * @author RouryR
 */
public class Nodo {
    Pasajero pasajero;
    Nodo siguiente;
    Nodo anterior;
    private int estacionOrigen;
    private int estacionDestino;


    public Nodo(Pasajero pasajero) {
        this.pasajero = pasajero;
        this.siguiente = null;
        this.anterior = null;
        this.estacionOrigen = pasajero.getEstacion_Origen();
        this.estacionDestino = pasajero.getEstacion_Destino();
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public int getEstacionOrigen() {
        return estacionOrigen;
    }

    public int getEstacionDestino() {
        return estacionDestino;
    }
    
    

    
}
