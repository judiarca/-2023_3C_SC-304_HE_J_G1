/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

/**
 *
 * @author RouryR
 */
public class Cola {
    private Nodo frente;
    private Nodo finalCola;
    private int size;
    


    public Cola() {
        this.frente = null;
        this.finalCola = null;
        this.size = 0;
    }

    public void encolar(Pasajero pasajero, boolean discapacitado, int Origen) {
        Nodo nuevoNodo = new Nodo(pasajero);
        if (esVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.setSiguiente(nuevoNodo);
            finalCola = nuevoNodo;
        }
        size++;
        String Estacion_Origen_SRT = Estacion.estacion_String(Origen);
        if (discapacitado) {
            System.out.println("Pasajero " + pasajero.getNombre() + " discapacitado encolado en la provincia " + Estacion_Origen_SRT);
        } else {
            System.out.println("Pasajero " + pasajero.getNombre() + " no discapacitado encolado en la provincia " + Estacion_Origen_SRT);
        }
    }
    
    public void encolar_espera(Pasajero pasajero, boolean discapacitado, int Origen) {
        Nodo nuevoNodo = new Nodo(pasajero);
        if (esVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.setSiguiente(nuevoNodo);
            finalCola = nuevoNodo;
        }
        size++;
        if (discapacitado) {
            
            System.out.println("El pasajero " + pasajero.getNombre()+ " discapacitado no se pudo subir al tren por falta de asiento");
        } else {
            System.out.println("El pasajero " + pasajero.getNombre()+ " no discapacitado no se pudo subir al tren por falta de asiento");
        }
        
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
    Nodo nodoActual = frente;
    StringBuilder resultado = new StringBuilder();
    Nodo[] gruposPorEstacion = new Nodo[8]; // Suponiendo 7 estaciones

    while (nodoActual != null) {
        Pasajero pasajero = nodoActual.getPasajero();
        int estacionDestino = pasajero.getEstacion_Origen();

        if (gruposPorEstacion[estacionDestino] == null) {
            gruposPorEstacion[estacionDestino] = new Nodo(pasajero);
        } else {
            Nodo ultimoPasajero = gruposPorEstacion[estacionDestino];
            while (ultimoPasajero.getSiguiente() != null) {
                ultimoPasajero = ultimoPasajero.getSiguiente();
            }
            ultimoPasajero.setSiguiente(new Nodo(pasajero));
        }
        nodoActual = nodoActual.getSiguiente();
    }

    for (int estacion = 0; estacion < gruposPorEstacion.length; estacion++) {
        Nodo grupo = gruposPorEstacion[estacion];
        String Estacion_Destino_SRT1 = Estacion.estacion_String(estacion);
        if (grupo != null) {
            resultado.append("\nCola de ").append(Estacion_Destino_SRT1).append(":\n");
            while (grupo != null) {
                Pasajero pasajero = grupo.getPasajero();
                String Estacion_Destino_SRT = Estacion.estacion_String(pasajero.getEstacion_Origen());
                String Estacion_Origen_SRT = Estacion.estacion_String(pasajero.getEstacion_Destino());
                String discapacidadStr = pasajero.getDiscapacitado() == Pasajero.Discapacidad.SI ? "Sí" : "No";
                String estadoStr = pasajero.getEstado() == Pasajero.Estado.EN_COLA ? "En cola" : "En camino";
                resultado.append("Nombre: ").append(pasajero.getNombre())
                        .append(", Edad: ").append(pasajero.getEdad())
                        .append(", Estacion Origen: ").append(Estacion_Destino_SRT)
                        .append(", Estacion Destino: ").append(Estacion_Origen_SRT)
                        .append(", Discapacitado: ").append(discapacidadStr)
                        .append(", Estado: ").append(estadoStr)
                        .append(", Completado: ").append(pasajero.isCompletado()).append("\n");
                grupo = grupo.getSiguiente();
            }
             resultado.append("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }
    return resultado.toString();
}


    public void subirPasajerosAlVagon(Vagon vagon) {
    Cola pasajerosEnEspera = new Cola(); // Nueva cola para almacenar pasajeros que quedan en espera
    Nodo nodoActual = frente;
    while (nodoActual != null) {
        Pasajero pasajero = nodoActual.getPasajero();
        boolean subido = vagon.subirPasajero(pasajero);
        if (!subido) {
            // Si no se pudo subir al pasajero, encolarlo en la nueva cola de espera
            //obtener estado del pasajero
            boolean estado = false;
            if (pasajero.getDiscapacitado() == Pasajero.Discapacidad.SI) {
                estado = true;
            }
            int Origen = 0; // Define la provincia adecuada para los pasajeros en espera
            pasajerosEnEspera.encolar_espera(pasajero, estado, Origen);
        }
        nodoActual = nodoActual.getSiguiente();
    }

    // Reemplazar la cola original con la nueva cola de pasajeros en espera
    frente = pasajerosEnEspera.frente;
    finalCola = pasajerosEnEspera.finalCola;
    size = pasajerosEnEspera.size;
}

    public boolean estaLlena() {
        return false;
    }

public void encolarPasajerosEnEspera(Cola colaEspera) {
    Nodo nodoActual = colaEspera.frente;
    while (nodoActual != null) {
        Pasajero pasajero = nodoActual.getPasajero();
        boolean discapacitado = pasajero.getDiscapacitado() == Pasajero.Discapacidad.SI;
        int Origen = 0; // Define la provincia adecuada para los pasajeros en espera
    
        encolar(pasajero, discapacitado, Origen);
        nodoActual = nodoActual.getSiguiente();
    }
}
    

}
