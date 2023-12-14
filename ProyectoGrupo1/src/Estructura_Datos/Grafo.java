package Estructura_Datos;

/**
 *
 * @author RouryR
 */
    public class Grafo {
   
    //TODO: Actualizar a clase Dato con atributos conexion (bool) y peso (int)
    private final NodoGrafo matrizAdyacencia[][];
    private final int numVertices;

    // Initialize the matrix
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.matrizAdyacencia = new NodoGrafo[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrizAdyacencia[i][j] = null;
            }
        }
    }

     // Add edges with peso and distancia
    public void setArista(int i, int j, int _peso, int _distancia) {
        matrizAdyacencia[i][j] = new NodoGrafo(_peso, _distancia);
        //matrizAdyacencia[j][i] = new NodoGrafo(_peso, _distancia);
    }

    // Remove edges
    public void eliminarArista(int i, int j) {
        matrizAdyacencia[i][j] = null;
        //matrizAdyacencia[j][i] = null;
    }

    // Print the matrix
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < numVertices; i++) {
            s.append(Vertices.values()[i]).append(" | ");
        }
        s.append("\n");
        for (int i = 0; i < numVertices; i++) {
            s.append(Vertices.values()[i]).append(": ");
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdyacencia[i][j] != null) {
                    s.append(matrizAdyacencia[i][j].toString()).append(" | ");
                } else {
                    s.append("_ | ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }


    // Funcion utilitaria para encontrar el vertice con la distancia minima, 
    // a partir del conjunto de los vertices todavia no incluidos en el 
    // camino mas corto
    private int minDistance(int[] dist, boolean[] verticeYaProcesado) {
        // Initialize min value
        int min = Integer.MAX_VALUE;
        int min_index = 0;

        for (int v = 0; v < numVertices; v++) {
            if (verticeYaProcesado[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    // Funcion utilitaria para imprimir el arreglo de distancias calculadas
    private void printSolution(int[] dist, int src) {
        System.out.println("Distancia del vertice desde el origen: " + Vertices.values()[src]);
        for (int i = 0; i < numVertices; i++) {
            System.out.println(Vertices.values()[i] + ": " + dist[i]);
        }
    }

    public void dijkstra(int src) {
        int[] dist = new int[numVertices];
        // dist[i] guarda la distancia mas corta desde src hasta el vertice i

        boolean[] verticeYaProcesado = new boolean[this.numVertices];
        //Este arreglo tiene true si el vertice i ya fue procesado

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < numVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            verticeYaProcesado[i] = false;
        }
        // La distancia del vertice origen hacia el mismo es siempre 0
        dist[src] = 0;

        //Encuentra el camino mas corto para todos los vertices
        for (int count = 0; count < numVertices; count++) {

            //Toma el vertice con la distancia minima del cojunto de vertices aun no procesados
            //En la primera iteracion siempre se devuelve src
            int u = minDistance(dist, verticeYaProcesado);

            // Se marca como ya procesado
            verticeYaProcesado[u] = true;

            // Update dist value of the adjacent vertices of the picked vertex.
            for (int v = 0; v < numVertices; v++) //Se actualiza la dist[v] solo si no esta en verticeYaProcesado, hay un
            //arco desde u a v y el peso total del camino desde src hasta v a traves de u es 
            // mas pequeno que el valor actual de dist[v]
            {
                if (matrizAdyacencia[u][v] != null) {
                    if (!verticeYaProcesado[v] && matrizAdyacencia[u][v].getKm() > 0 && dist[u] != Integer.MAX_VALUE
                            && dist[u] + matrizAdyacencia[u][v].getKm() < dist[v]) {
                        dist[v] = dist[u] + matrizAdyacencia[u][v].getKm();
                    }
                }
            }
        }

        // se imprime el arreglo con las distancias
        printSolution(dist, src);
    }
    
    
    //obtiene la distancia de estacacion origen a estacion destino
    public int obtenerkm(int estacionOrigen, int estacionDestino) {
        if (estacionOrigen >= 0 && estacionOrigen < numVertices
                && estacionDestino >= 0 && estacionDestino < numVertices) {
            NodoGrafo nodo = matrizAdyacencia[estacionOrigen][estacionDestino];
            if (nodo != null) {
                return nodo.getKm();
            }
        }
        // Si no hay conexión directa, puede imprimir un numero para identificar que es un error
        return Integer.MAX_VALUE;
    }

    public int obtenerminutos(int estacionOrigen, int estacionDestino) {
        if (estacionOrigen >= 0 && estacionOrigen < numVertices
                && estacionDestino >= 0 && estacionDestino < numVertices) {
            NodoGrafo nodo = matrizAdyacencia[estacionOrigen][estacionDestino];
            if (nodo != null) {
                return nodo.getMinutos();
            }
        }
        // Si no hay conexión directa, puede imprimir un numero para identificar que es un error
        return Integer.MAX_VALUE;
    }
    
    
    }