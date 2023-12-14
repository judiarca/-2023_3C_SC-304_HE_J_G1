package Estructura_Datos;


import proyectogrupo1.Estacion;
import proyectogrupo1.Pasajero;
import proyectogrupo1.Vagon;


/**
 *
 * @author RouryR
 */
public class Cola {
    private Nodo_cola frente;
    private Nodo_cola finalCola;
    private int size;

    public Nodo_cola getFrente() {
        return frente;
    }

    public Nodo_cola getFinalCola() {
        return finalCola;
    }

    public int getSize() {
        return size;
    }
    

    public Cola() {
        this.frente = null;
        this.finalCola = null;
        this.size = 0;
    }

    public void encolar(Pasajero pasajero, boolean discapacitado, int Origen) {
        Nodo_cola nuevoNodo = new Nodo_cola(pasajero);
        if (esVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.setSiguiente(nuevoNodo);
            finalCola = nuevoNodo;
        }
        size++;
    }

   
    public Pasajero desencolar() {
        if (esVacia()) {
            return null;
        }
        Pasajero pasajeroDesencolado = frente.getPasajero();
        frente = frente.getSiguiente();
        size--;
        return pasajeroDesencolado;
    }

    public boolean esVacia() {
        return frente == null;
    }

    public int size() {
        return size;
    }

    //imprime la cola
   public String imprimirCola() {
    Nodo_cola nodoActual = frente;
    StringBuilder resultado = new StringBuilder();
    Nodo_cola[] gruposPorEstacion = new Nodo_cola[8]; // Suponiendo 7 estaciones

    while (nodoActual != null) {
        Pasajero pasajero = nodoActual.getPasajero();
        int estacionDestino = pasajero.getEstacion_Origen();

        if (gruposPorEstacion[estacionDestino] == null) {
            gruposPorEstacion[estacionDestino] = new Nodo_cola(pasajero);
        } else {
            Nodo_cola ultimoPasajero = gruposPorEstacion[estacionDestino];
            while (ultimoPasajero.getSiguiente() != null) {
                ultimoPasajero = ultimoPasajero.getSiguiente();
            }
            ultimoPasajero.setSiguiente(new Nodo_cola(pasajero));
        }
        nodoActual = nodoActual.getSiguiente();
    }

    for (int estacion = 0; estacion < gruposPorEstacion.length; estacion++) {
        Nodo_cola grupo = gruposPorEstacion[estacion];
        String Estacion_Destino_SRT = Estacion.estacion_String(estacion);
        if (grupo != null) {
            resultado.append("\nCola de ").append(Estacion_Destino_SRT).append(":\n");

            // Separar pasajeros por discapacidad
            Nodo_cola colaDiscapacitados = null;
            Nodo_cola colaNoDiscapacitados = null;

            while (grupo != null) {
                Pasajero pasajero = grupo.getPasajero();
                if (pasajero.getDiscapacitado() == Pasajero.Discapacidad.SI) {
                    if (colaDiscapacitados == null) {
                        colaDiscapacitados = new Nodo_cola(pasajero);
                    } else {
                        Nodo_cola ultimoPasajero = colaDiscapacitados;
                        while (ultimoPasajero.getSiguiente() != null) {
                            ultimoPasajero = ultimoPasajero.getSiguiente();
                        }
                        ultimoPasajero.setSiguiente(new Nodo_cola(pasajero));
                    }
                } else {
                    if (colaNoDiscapacitados == null) {
                        colaNoDiscapacitados = new Nodo_cola(pasajero);
                    } else {
                        Nodo_cola ultimoPasajero = colaNoDiscapacitados;
                        while (ultimoPasajero.getSiguiente() != null) {
                            ultimoPasajero = ultimoPasajero.getSiguiente();
                        }
                        ultimoPasajero.setSiguiente(new Nodo_cola(pasajero));
                    }
                    
                }
                grupo = grupo.getSiguiente();
            }

            // Imprimir cola de discapacitados
            resultado.append("*Discapacitados:\n");
            imprimirPasajeros(colaDiscapacitados, resultado);

            // Imprimir cola de no discapacitados
            resultado.append("\n*No discapacitados:\n");
            imprimirPasajeros(colaNoDiscapacitados, resultado);

            resultado.append("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
             
        }
    }
    return resultado.toString();
}

// Método auxiliar para imprimir pasajeros de una cola
private void imprimirPasajeros(Nodo_cola cola, StringBuilder resultado) {
    while (cola != null) {
        Pasajero pasajero = cola.getPasajero();
        String Estacion_Destino_SRT = Estacion.estacion_String(pasajero.getEstacion_Destino());
        String Estacion_Origen_SRT = Estacion.estacion_String(pasajero.getEstacion_Origen());
        String discapacidadStr = pasajero.getDiscapacitado() == Pasajero.Discapacidad.SI ? "Sí" : "No";
        String estadoStr = pasajero.getEstado() == Pasajero.Estado.EN_COLA ? "En cola" : "En camino";
        resultado.append("Nombre: ").append(pasajero.getNombre())
                .append(", Edad: ").append(pasajero.getEdad())
                .append(", Estacion Origen: ").append(Estacion_Origen_SRT)
                .append(", Estacion Destino: ").append(Estacion_Destino_SRT)
                .append(", Discapacitado: ").append(discapacidadStr)
                .append(", Estado: ").append(estadoStr)
                .append(", Completado: ").append(pasajero.obtenerEstado()).append("\n");
        cola = cola.getSiguiente();
    }
}



   public void subirPasajerosAlVagon(Vagon vagon) {
    Cola pasajerosEnEsperaTemporal = new Cola(); // Cola temporal para almacenar pasajeros que quedan en espera
    Nodo_cola nodoActual = frente;

    while (nodoActual != null) {
        Pasajero pasajero = nodoActual.getPasajero();
        boolean subido = vagon.subirPasajero(pasajero);

        if (!subido) {
            // Si no se pudo subir al pasajero, encolarlo en la cola temporal de espera
            boolean estado = pasajero.getDiscapacitado() == Pasajero.Discapacidad.SI;
            int Origen = pasajero.getEstacion_Origen();
            pasajerosEnEsperaTemporal.encolar(pasajero, estado, Origen);
        }

        nodoActual = nodoActual.getSiguiente();
    }
    
    // Actualizar la cola original con los pasajeros que quedaron en espera
    frente = pasajerosEnEsperaTemporal.getFrente();
    finalCola = pasajerosEnEsperaTemporal.getFinalCola();
    size = pasajerosEnEsperaTemporal.getSize();
}




    public boolean estaLlena() {
        return false;
    }
    

    public void vaciarCola() {
    frente = null;
    finalCola = null;
    size = 0;
}
}
