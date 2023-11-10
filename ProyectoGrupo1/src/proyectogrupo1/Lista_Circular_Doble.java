/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

/**
 *
 * @author RouryR
 */
public class Lista_Circular_Doble {
    private Nodo primer_Nodo;

    public Lista_Circular_Doble() {
        this.primer_Nodo = null;
    }

    public boolean insertar_Ordenado(Pasajero pasajero) {
        Nodo nuevoNodo = new Nodo(pasajero);
        if (primer_Nodo == null) {
            nuevoNodo.siguiente = nuevoNodo;
            nuevoNodo.anterior = nuevoNodo;
            primer_Nodo = nuevoNodo;
        } else {
            Nodo actual = primer_Nodo;
            do {
                if (pasajero.getNombre().compareTo(actual.pasajero.getNombre()) <= 0) {
                    nuevoNodo.siguiente = actual;
                    nuevoNodo.anterior = actual.anterior;
                    actual.anterior.siguiente = nuevoNodo;
                    actual.anterior = nuevoNodo;
                    if (actual == primer_Nodo) {
                        primer_Nodo = nuevoNodo;
                    }
                    System.out.println("Pasajero " + pasajero.getNombre() + " insertado en la cola.");
                    return true;
                }
                actual = actual.siguiente;
            } while (actual != primer_Nodo);
            nuevoNodo.siguiente = primer_Nodo;
            nuevoNodo.anterior = primer_Nodo.anterior;
            primer_Nodo.anterior.siguiente = nuevoNodo;
            primer_Nodo.anterior = nuevoNodo;
            System.out.println("Pasajero " + pasajero.getNombre() + " insertado en la cola.");
            return true; 
        }
        return false; 
    }

    public void imprimir_Lista() {
        if (primer_Nodo == null) {
            System.out.println("La lista está vacía.");
        } else {
            Nodo actual = primer_Nodo;
            do {
                System.out.println("Nombre: " + actual.pasajero.getNombre());
                actual = actual.siguiente;
            } while (actual != primer_Nodo);
        }
    }

    public Pasajero quitar_Primero() {
        if (primer_Nodo == null) {
            return null;
        }

        Pasajero pasajero = primer_Nodo.pasajero;
        if (primer_Nodo.siguiente == primer_Nodo) {
            primer_Nodo = null;
        } else {
            primer_Nodo.anterior.siguiente = primer_Nodo.siguiente;
            primer_Nodo.siguiente.anterior = primer_Nodo.anterior;
            primer_Nodo = primer_Nodo.siguiente;
        }
        return pasajero;
    }

    public void esta_Vacia() {
        if (primer_Nodo == null) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("La lista no está vacía.");
        }
    }

 

}





