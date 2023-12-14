package proyectogrupo1;

/**
 * @author RouryR
 */
import Estructura_Datos.Cola;
import Estructura_Datos.Grafo;
import Estructura_Datos.Lista_Circular_Doble;
import Estructura_Datos.Pila;
import Estructura_Datos.Vertices;
import proyectogrupo1.Interfaz.Menu;
import static proyectogrupo1.Interfaz.Menu.Estado_tren;
import static proyectogrupo1.Interfaz.Menu.Pagos_info;
import static proyectogrupo1.Interfaz.Menu.asientos_fila_discapacidad;
import static proyectogrupo1.Interfaz.Menu.asientos_fila_sin_discapacidad1;
import static proyectogrupo1.Interfaz.Menu.asientos_fila_sin_discapacidad2;
import static proyectogrupo1.Interfaz.Menu.costo_por_kilometro;
import static proyectogrupo1.Interfaz.Menu.C1TextArea;

public class Tren extends Thread {

    private Grafo grafo;
    private Cola[] colasEstaciones;
    private Vagon vagon;
    private int estacionActual;
    private boolean enMovimiento;
    private int estacionesRecorridas;
    private Lista_Circular_Doble listaPasajeros;
    String asteriscos = "*".repeat(81);
    String espacios = " ".repeat(48);

    public StringBuilder sb = new StringBuilder();

// O bien, si prefieres tener un método para acceder a sb
    public String obtenerEstadoTren() {
        return sb.toString();
    }

    public Tren() {
        Grafo g = new Grafo(7);

        g.setArista(Vertices.Guanacaste.ordinal(), Vertices.Alajuela.ordinal(), 40, 25);
        g.setArista(Vertices.Alajuela.ordinal(), Vertices.Limon.ordinal(), 10, 20);
        g.setArista(Vertices.Limon.ordinal(), Vertices.Cartago.ordinal(), 50, 60);
        g.setArista(Vertices.Cartago.ordinal(), Vertices.Heredia.ordinal(), 30, 30);
        g.setArista(Vertices.Heredia.ordinal(), Vertices.SanJose.ordinal(), 25, 35);
        g.setArista(Vertices.SanJose.ordinal(), Vertices.Puntarenas.ordinal(), 40, 40);
        g.setArista(Vertices.Puntarenas.ordinal(), Vertices.Guanacaste.ordinal(), 25, 40);

        this.grafo = g;

        colasEstaciones = new Cola[7]; // Una cola por cada estación
        for (int i = 0; i < colasEstaciones.length; i++) {
            colasEstaciones[i] = new Cola();
            estacionesRecorridas = 0;
        }
        

        listaPasajeros = new Lista_Circular_Doble();
        vagon = new Vagon(asientos_fila_sin_discapacidad1, asientos_fila_sin_discapacidad2, asientos_fila_discapacidad); // Crear un vagón con capacidad especificada
        estacionActual = 0; // Comenzar desde la primera estación

        enMovimiento = true; // El tren inicia en movimiento
    }

    //nombre de estacion en String 
    public void run() {
        sb = new StringBuilder();
        Cola cola = new Cola();
        while (enMovimiento) {
            cola.subirPasajerosAlVagon(vagon);

            //int distancia = grafo.obtenerDistancia(estacionActual, (estacionActual + 1) % 7);
            try {
                Thread.sleep(Menu.tiempo_avance_segundos * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String Estacion_Origen_SRT = Estacion.estacion_String(estacionActual);
            String Estacion_Destino_SRT = Estacion.estacion_String((estacionActual + 1) % 7);

            // Llegada a la estación, bajar pasajeros con destino a esta estación
            sb.append(asteriscos).append("\n");
            sb.append(espacios).append("El tren llegó a: ").append(Estacion_Origen_SRT).append(espacios).append("\n");
            sb.append(asteriscos).append("\n");

            bajarPasajerosEnEstacion(estacionActual, sb);//esta linea baja los pasajeros tren a la estacion correspondiente
            sb.append("\n");

            // Subir pasajeros de la cola de la estación actual si hay asientos disponibles
            sb.append("Subiendo pasajeros en la estación ").append(Estacion_Origen_SRT).append(":\n");
            subirPasajerosEnEstacion(estacionActual, sb);

            sb.append("\n").append(espacios).append("Estado del tren:\n");
            sb.append(imprimirEstadoDePilasDelTren());

            // Imprimir la posición actual del tren y hacia dónde se dirige
            sb.append("Posición actual del tren: Estación: ").append(Estacion_Origen_SRT).append("\n");
            sb.append("Se dirige hacia la Estación ").append(Estacion_Destino_SRT).append("\n\n");
            estacionActual = (estacionActual + 1) % 7;
            estacionesRecorridas++;
            if (estacionesRecorridas == 7) {
                sb.append(asteriscos).append("\n");
                sb.append(espacios).append("Ruta completada\n");
                sb.append(asteriscos).append("\n");
                sb.append("[* El tren se está preparando para partir de nuevo *]\n");

                // Detener el tren por un tiempo antes de iniciar una nueva ruta
                try {
                    Thread.sleep(15000); // Puedes ajustar el tiempo de espera según tus necesidades
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //enMovimiento = false; // Detener el tren después de completar la ruta
                estacionesRecorridas = 0;
                estacionActual = 0;
            }
            // Imprimir el resultado del StringBuilder en la consola
            //System.out.println(sb.toString());
            Estado_tren.setText(sb.toString());
        }
    }

    private String bajarPasajerosEnEstacion(int estacion, StringBuilder result) {

        Pila pilaNoDiscapacitados1 = vagon.getPilaNoDiscapacitados1();
        Pila pilaNoDiscapacitados2 = vagon.getPilaNoDiscapacitados2();
        Pila pilaDiscapacitados = vagon.getPilaDiscapacitados();
        String Estacion_Destino_SRT = Estacion.estacion_String(estacion);

        result.append("Pasajeros que se bajan en la estación ").append(Estacion_Destino_SRT).append(":\n");
        Pila pilaTemporal = new Pila(pilaNoDiscapacitados1.getMaxSize() + pilaNoDiscapacitados2.getMaxSize() + pilaDiscapacitados.getMaxSize());

        int KMTotalRecorrida = 0;
         int MinTotalRecorrida = 0;
        if (estacion > 0) {
            for (int i = 0; i < estacion; i++) {
                KMTotalRecorrida += grafo.obtenerkm(i, (i + 1) % 7);
                 MinTotalRecorrida += grafo.obtenerminutos(i, (i + 1) % 7);
            }
        }

       
  

        // Bajar pasajeros de pilaNoDiscapacitados1 y marcarlos como completados si es su estación de destino
        while (!pilaNoDiscapacitados1.estaVacia()) {
            double totalPagar = KMTotalRecorrida * costo_por_kilometro;

            Pasajero pasajero = pilaNoDiscapacitados1.desapilar();
            if (pasajero.getEstacion_Destino() == estacion) {
                result.append(pasajero.getNombre()).append(" se bajó en la estación ").append(Estacion_Destino_SRT).append("\n");
                pasajero.setCompletado(true); // Marcar al pasajero como completado
                String Estacion_Origen_SRT = Estacion.estacion_String(pasajero.getEstacion_Destino());
                String discapacidadStr = pasajero.getDiscapacitado() == Pasajero.Discapacidad.SI ? "Sí" : "No";
                StringBuilder Factura = new StringBuilder();
                Factura.append("Nombre: ").append(pasajero.getNombre())
                        .append(", Edad: ").append(pasajero.getEdad())
                        .append(", Estacion Origen: ").append(Estacion_Destino_SRT)
                        .append(", Estacion Destino: ").append(Estacion_Origen_SRT)
                        .append(", Discapacitado: ").append(discapacidadStr)
                        .append(", Viaje Completado: ").append(pasajero.obtenerEstado())
                        .append(", KM recorridos: ").append(KMTotalRecorrida)
                        .append(", Tiempo: ").append(MinTotalRecorrida)
                        .append(", Total a pagar: ₡")
                        .append(totalPagar)
                        .append("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")
                        .append("\n");
                //System.out.println(Factura.toString());
                Pagos_info.append(Factura.toString());
            } else {
                // Si no es la estación de destino del pasajero, restaurar a la pila temporal
                pilaTemporal.apilar(pasajero);
            }
        }
        // Restaurar pasajeros a pilaNoDiscapacitados1
        while (!pilaTemporal.estaVacia()) {
            pilaNoDiscapacitados1.apilar(pilaTemporal.desapilar());
        }
        // Bajar pasajeros de pilaNoDiscapacitados2 y marcarlos como completados si es su estación de destino
        while (!pilaNoDiscapacitados2.estaVacia()) {
            double totalPagar = KMTotalRecorrida * costo_por_kilometro;
            Pasajero pasajero = pilaNoDiscapacitados2.desapilar();
            if (pasajero.getEstacion_Destino() == estacion) {
                result.append(pasajero.getNombre()).append(" se bajó en la estación ").append(Estacion_Destino_SRT).append("\n");
                pasajero.setCompletado(true); // Marcar al pasajero como completado
                String Estacion_Origen_SRT = Estacion.estacion_String(pasajero.getEstacion_Origen());
                String discapacidadStr = pasajero.getDiscapacitado() == Pasajero.Discapacidad.SI ? "Sí" : "No";
                StringBuilder Factura = new StringBuilder();
                Factura.append("Nombre: ").append(pasajero.getNombre())
                        .append(", Edad: ").append(pasajero.getEdad())
                                                .append(", Origen: ").append(Estacion_Origen_SRT)
                                                .append(", Destino: ").append(Estacion_Destino_SRT) 
                        .append(", Discapacitado: ").append(discapacidadStr)
                        .append(", Viaje Completado: ").append(pasajero.obtenerEstado())
                       .append(", KM recorridos: ").append(KMTotalRecorrida)
                        .append(", Tiempo: ").append(MinTotalRecorrida)
                        .append(", Total a pagar: ₡")
                        .append(totalPagar)
                         .append("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")
                        .append("\n");
                //System.out.println(Factura.toString());
                Pagos_info.append(Factura.toString());
            } else {
                // Si no es la estación de destino del pasajero, restaurar a la pila temporal
                pilaTemporal.apilar(pasajero);
            }
        }
        // Restaurar pasajeros a pilaNoDiscapacitados2
        while (!pilaTemporal.estaVacia()) {
            pilaNoDiscapacitados2.apilar(pilaTemporal.desapilar());
        }
        // Bajar pasajeros de pilaDiscapacitados y marcarlos como completados si es su estación de destino
        while (!pilaDiscapacitados.estaVacia()) {
            double totalPagar = KMTotalRecorrida * costo_por_kilometro;
            Pasajero pasajero = pilaDiscapacitados.desapilar();
            if (pasajero.getEstacion_Destino() == estacion) {
                result.append(pasajero.getNombre()).append(" se bajó en la estacion ").append(Estacion_Destino_SRT).append("\n");
                pasajero.setCompletado(true); // Marcar al pasajero como completado
                String Estacion_Origen_SRT = Estacion.estacion_String(pasajero.getEstacion_Origen());
                String discapacidadStr = pasajero.getDiscapacitado() == Pasajero.Discapacidad.SI ? "Sí" : "No";
                StringBuilder Factura = new StringBuilder();
                Factura.append("Nombre: ").append(pasajero.getNombre())
                        .append(", Edad: ").append(pasajero.getEdad())
                        .append(", Estacion Origen: ").append(Estacion_Origen_SRT)
                        .append(", Estacion Destino: ").append(Estacion_Destino_SRT)
                        .append(", Discapacitado: ").append(discapacidadStr)
                        .append(", Viaje Completado: ").append(pasajero.obtenerEstado())
                        .append(", KM recorridos: ").append(KMTotalRecorrida)
                        .append(", Tiempo: ").append(MinTotalRecorrida)
                        .append(", Total a pagar: ₡")
                        .append(totalPagar)
                        .append("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")
                        .append("\n");
                //System.out.println(Factura.toString());
                Pagos_info.append(Factura.toString());
            } else {
                // Si no es la estación de destino del pasajero, restaurar a la pila temporal
                pilaTemporal.apilar(pasajero);
            }
        }
        // Restaurar pasajeros a pilaDiscapacitados
        while (!pilaTemporal.estaVacia()) {
            pilaDiscapacitados.apilar(pilaTemporal.desapilar());
        }

        return result.toString();
    }

    private String subirPasajerosEnEstacion(int estacion, StringBuilder result) {
        Cola colaEstacionActual = colasEstaciones[estacion];
        Pila pilaNoDiscapacitados1 = vagon.getPilaNoDiscapacitados1();
        Pila pilaNoDiscapacitados2 = vagon.getPilaNoDiscapacitados2();
        Pila pilaDiscapacitados = vagon.getPilaDiscapacitados();
        Cola pasajerosEnEsperaTemporal = new Cola();

        //System.out.println("cola actual " + colaEstacionActual.size() + ":");
        while (!colaEstacionActual.esVacia()
                && (pilaNoDiscapacitados1.size() < pilaNoDiscapacitados1.getMaxSize()
                || pilaNoDiscapacitados2.size() < pilaNoDiscapacitados2.getMaxSize()
                || pilaDiscapacitados.size() < pilaDiscapacitados.getMaxSize())) {

            Pasajero pasajero = colaEstacionActual.desencolar();
            boolean subido = false;

            if (pasajero.getDiscapacitado() == Pasajero.Discapacidad.SI) {
                if (pilaDiscapacitados.size() < pilaDiscapacitados.getMaxSize()) {
                    pilaDiscapacitados.apilar(pasajero);
                    subido = true;

                }
            } else {
                if (pilaNoDiscapacitados1.size() < pilaNoDiscapacitados1.getMaxSize()) {
                    pilaNoDiscapacitados1.apilar(pasajero);
                    subido = true;
                } else if (pilaNoDiscapacitados2.size() < pilaNoDiscapacitados2.getMaxSize()) {
                    pilaNoDiscapacitados2.apilar(pasajero);
                    subido = true;
                }
            }
            String Estacion_Origen_STR = Estacion.estacion_String(pasajero.getEstacion_Origen());

            if (subido) {
                result.append(pasajero.getNombre())
                        .append(pasajero.isDiscapacitado() ? " (discapacitado)" : "")
                        .append(" se subió en la estación ").append(Estacion_Origen_STR).append("\n");

            } else {
                result.append("\n").append(espacios).append("Cola Espera: \n[  No hay asientos disponibles para ").append(pasajero.getNombre()).append(" en ").append(Estacion_Origen_STR).append("  ]").append("\n");
                C1TextArea.append("Cola espera " + Estacion_Origen_STR + " " + pasajero.es() + "\n");
                C1TextArea.append(pasajero.toString() + "\n\n");

                // Si no se pudo subir al pasajero, encolarlo en la cola temporal de espera
                boolean estado = pasajero.getDiscapacitado() == Pasajero.Discapacidad.SI;
                int Origen = pasajero.getEstacion_Origen();
                pasajerosEnEsperaTemporal.encolar(pasajero, estado, Origen);
            }
        }

        // Actualizar la cola original con los pasajeros que quedaron en espera
        while (!pasajerosEnEsperaTemporal.esVacia()) {
            Pasajero pasajeroEnEspera = pasajerosEnEsperaTemporal.desencolar();
            colaEstacionActual.encolar(pasajeroEnEspera, pasajeroEnEspera.getDiscapacitado() == Pasajero.Discapacidad.SI, pasajeroEnEspera.getEstacion_Origen());
        }

        return result.toString();
    }

    // Método para agregar pasajeros a la cola de una estación específica
    public void agregarPasajeroEstacion(Pasajero pasajero, int estacion) {
        colasEstaciones[estacion].encolar(pasajero, pasajero.getDiscapacitado() == Pasajero.Discapacidad.SI, estacion);
    }

    // Método para detener el movimiento del tren
    public void detenerTren() {
        enMovimiento = false;
    }

    public String imprimirEstadoDePilasDelTren() {
        StringBuilder result = new StringBuilder();
        result.append("Pila 1 de pasajeros NO Discapacitados - ").append("Maximo: ").append(vagon.getPilaNoDiscapacitados1().getMaxSize()).append(" Asientos \n");
        result.append(vagon.getPilaNoDiscapacitados1().imprimirPila()).append("\n");
        result.append("Pila 2 de pasajeros NO Discapacitados - ").append("Maximo: ").append(vagon.getPilaNoDiscapacitados2().getMaxSize()).append(" Asientos \n");
        result.append(vagon.getPilaNoDiscapacitados2().imprimirPila()).append("\n");
        result.append("Pila 3 de pasajeros Discapacitados - ").append("Maximo: ").append(vagon.getPilaDiscapacitados().getMaxSize()).append(" Asientos \n");
        result.append(vagon.getPilaDiscapacitados().imprimirPila()).append("\n");
//        result.append("\n");
        return result.toString();
    }

}
