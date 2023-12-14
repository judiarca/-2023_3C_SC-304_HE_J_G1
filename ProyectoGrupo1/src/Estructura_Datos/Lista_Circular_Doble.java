package Estructura_Datos;

import proyectogrupo1.Pasajero;



public class Lista_Circular_Doble {
    private Nodo_cola primerNodo;

    public Lista_Circular_Doble() {
        this.primerNodo = null;
    }

    public boolean insertarOrdenado(Pasajero pasajero) {
        Nodo_cola nuevoNodo = new Nodo_cola(pasajero);
        if (primerNodo == null) {
            nuevoNodo.siguiente = nuevoNodo;
            nuevoNodo.anterior = nuevoNodo;
            primerNodo = nuevoNodo;
        } else {
            Nodo_cola actual = primerNodo;
            do {
                if (pasajero.getNombre().compareTo(actual.pasajero.getNombre()) <= 0) {
                    nuevoNodo.siguiente = actual;
                    nuevoNodo.anterior = actual.anterior;
                    actual.anterior.siguiente = nuevoNodo;
                    actual.anterior = nuevoNodo;
                    if (actual == primerNodo) {
                        primerNodo = nuevoNodo;
                    }
                    System.out.println("Pasajero " + pasajero.getNombre() + " insertado en la cola.");
                    return true; // Indica que la inserción fue exitosa
                }
                actual = actual.siguiente;
            } while (actual != primerNodo);
            nuevoNodo.siguiente = primerNodo;
            nuevoNodo.anterior = primerNodo.anterior;
            primerNodo.anterior.siguiente = nuevoNodo;
            primerNodo.anterior = nuevoNodo;
            System.out.println("Pasajero " + pasajero.getNombre() + " insertado en la cola.");
            return true; // Indica que la inserción fue exitosa
        }
        return false; // Indica que la inserción no fue exitosa
    }

    public void imprimirLista() {
        if (primerNodo == null) {
            System.out.println("La lista está vacía.");
        } else {
            Nodo_cola actual = primerNodo;
            do {
                System.out.println("Nombre: " + actual.pasajero.getNombre());
                actual = actual.siguiente;
            } while (actual != primerNodo);
        }
    }

    public Pasajero quitarPrimero() {
        if (primerNodo == null) {
            return null;
        }

        Pasajero pasajero = primerNodo.anterior.pasajero;
        if (primerNodo.anterior == primerNodo) {
            primerNodo = null;
        } else {
            primerNodo.anterior = primerNodo.anterior.anterior;
            primerNodo.anterior.siguiente = primerNodo;
        }
        return pasajero;
    }

    public boolean estaVacia() {
    return primerNodo == null;
}

    // Método para desapilar todos los pasajeros y volver a apilar respetando la fila de asientos
  public void desapilarRespetandoFila() {
    if (primerNodo == null) {
        System.out.println("La lista está vacía.");
        return;
    }

    Nodo_cola auxiliar = primerNodo.anterior; // Nodo auxiliar al fondo de la lista
    Nodo_cola actual = primerNodo.anterior; // Nodo actual al fondo de la lista

    // Crear pila auxiliar
    Lista_Circular_Doble pilaAuxiliar = new Lista_Circular_Doble();

    // Desapilar y apilar en la pila auxiliar
    do {
        pilaAuxiliar.insertarOrdenado(actual.pasajero);
        actual = actual.anterior;
    } while (actual != auxiliar);

    // Vaciar la lista original
    primerNodo = null;

    // Reapilar en la lista original respetando la fila de asientos
    while (!pilaAuxiliar.estaVacia()) {
    insertarOrdenado(pilaAuxiliar.quitarPrimero());
}
}



    
}