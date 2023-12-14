package proyectogrupo1;

import Estructura_Datos.Lista_Circular_Doble;
import Estructura_Datos.Pila;


/**
 *
 * @author RouryR
 */
public class Vagon {
    private Lista_Circular_Doble listaPasajeros;
    private Pila pilaNoDiscapacitados1;
    private Pila pilaNoDiscapacitados2;
    private Pila pilaDiscapacitados;
    //private Cola colaEsperaNoDiscapacitados;
    //private Cola colaEsperaDiscapacitados;
    
       public Vagon(int maxSizeFila1, int maxSizeFila2, int maxSizeFilaDiscapacitados) {
        this.listaPasajeros = new Lista_Circular_Doble();
        this.pilaNoDiscapacitados1 = new Pila(maxSizeFila1);
        this.pilaNoDiscapacitados2 = new Pila(maxSizeFila2);
        this.pilaDiscapacitados = new Pila(maxSizeFilaDiscapacitados);
        //this.colaEsperaNoDiscapacitados = new Cola();
        //this.colaEsperaDiscapacitados = new Cola();
    }

    public Pila getPilaNoDiscapacitados1() {
        return pilaNoDiscapacitados1;
    }

    public void setPilaNoDiscapacitados1(Pila pilaNoDiscapacitados1) {
        this.pilaNoDiscapacitados1 = pilaNoDiscapacitados1;
    }

    public Pila getPilaNoDiscapacitados2() {
        return pilaNoDiscapacitados2;
    }

    public void setPilaNoDiscapacitados2(Pila pilaNoDiscapacitados2) {
        this.pilaNoDiscapacitados2 = pilaNoDiscapacitados2;
    }

    public Pila getPilaDiscapacitados() {
        return pilaDiscapacitados;
    }

    public void setPilaDiscapacitados(Pila pilaDiscapacitados) {
        this.pilaDiscapacitados = pilaDiscapacitados;
    }

 

//    public void agregarPasajeroNoDiscapacitado(Pasajero pasajero) {
//        listaPasajeros.insertarOrdenado(pasajero);
//    }
//
//    public void agregarPasajeroDiscapacitado(Pasajero pasajero) {
//        listaPasajeros.insertarOrdenado(pasajero);
//    }
//
//    public Pasajero quitarPasajeroNoDiscapacitado() {
//        Pasajero pasajero = listaPasajeros.quitarPrimero();
//        if (pasajero != null && pasajero.getDiscapacitado() == Pasajero.Discapacidad.NO) {
//            return pasajero;
//        } else {
//            return null;
//        }
//    }
//
//    public Pasajero quitarPasajeroDiscapacitados() {
//        Pasajero pasajero = listaPasajeros.quitarPrimero();
//        if (pasajero != null && pasajero.getDiscapacitado() == Pasajero.Discapacidad.SI) {
//            return pasajero;
//        } else {
//            return null;
//        }
//    }

    //si
    public boolean subirPasajero(Pasajero pasajero) {
    Pila pilaTemporal = null;
    if (pasajero.getDiscapacitado() == Pasajero.Discapacidad.NO) {
        pilaTemporal = new Pila(pilaNoDiscapacitados1.getMaxSize());
        // Restaurar pasajeros a la pila temporal
        // Intentar agregar el pasajero a la pila 1 nuevamente
        if (!pilaNoDiscapacitados1.estaLlena()) {
            pilaNoDiscapacitados1.apilar(pasajero);
            // Restaurar pasajeros a la pila original
            while (!pilaTemporal.estaVacia()) {
                // Si no se pudo agregar, colocarlo en la cola de espera de no discapacitados
                pilaNoDiscapacitados1.apilar(pilaTemporal.desapilar());
            }
            // Utilizar insertarOrdenado para agregar el pasajero al tren
            return listaPasajeros.insertarOrdenado(pasajero);

        } else if (!pilaNoDiscapacitados2.estaLlena()) {
            pilaNoDiscapacitados2.apilar(pasajero);
            // Restaurar pasajeros a la pila original
            while (!pilaTemporal.estaVacia()) {
                // Si no se pudo agregar, colocarlo en la cola de espera de no discapacitados
                pilaNoDiscapacitados2.apilar(pilaTemporal.desapilar());
            }
            // Utilizar insertarOrdenado para agregar el pasajero al tren
            return listaPasajeros.insertarOrdenado(pasajero);
        }

    } else {
        // Lógica para pasajeros discapacitados
        pilaTemporal = new Pila(pilaDiscapacitados.getMaxSize());
        // Restaurar pasajeros a la pila temporal
        // Intentar agregar el pasajero discapacitado a la pila nuevamente
        if (!pilaDiscapacitados.estaLlena()) {
            pilaDiscapacitados.apilar(pasajero);
            // Restaurar pasajeros a la pila original
            while (!pilaTemporal.estaVacia()) {
                // Si no se pudo agregar, colocarlo en la cola de espera de discapacitados
                pilaDiscapacitados.apilar(pilaTemporal.desapilar());
            }
            // Utilizar insertarOrdenado para agregar el pasajero al tren
            return listaPasajeros.insertarOrdenado(pasajero);
        }

    }
    return false;
}
}


//    private void imprimirPil(Pila pila) {
//    int maxSize = pila.getMaxSize(); // Obtener el tamaño máximo de la pila
//    Pila tempPila = new Pila(maxSize);
//    while (!pila.estaVacia()) {
//        Pasajero pasajero = pila.desapilar();
//        String Estacion_Origen_SRT = Estacion.estacion_String(pasajero.getEstacion_Origen());
//        String Estacion_Destino_SRT = Estacion.estacion_String(pasajero.getEstacion_Destino());
//        System.out.println("Nombre: " + pasajero.getNombre() +
//                ", Edad: " + pasajero.getEdad() +
//                ", Estacion Origen: " + Estacion_Origen_SRT +
//                ", Estacion Destino: " + Estacion_Destino_SRT +
//                ", Discapacitado: " + (pasajero.getDiscapacitado() == Pasajero.Discapacidad.SI ? "Sí" : "No") +
//                ", Estado: " + (pasajero.getEstado() == Pasajero.Estado.EN_COLA ? "En cola" : "En camino") +
//                ", Completado: " + pasajero.obtenerEstado());
//        tempPila.apilar(pasajero);
//    }
//
//    // Restaurar la pila original
//    while (!tempPila.estaVacia()) {
//        pila.apilar(tempPila.desapilar());
//    }
//}



//

