package Estructura_Datos;

import proyectogrupo1.Pasajero;




public class Pila {
    private Pasajero[] pasajeros;
    private int maxSize;
    private int top;

    public Pila(int maxSize) {
        this.maxSize = maxSize;
        this.pasajeros = new Pasajero[maxSize];
        this.top = -1;
    }

    public void apilar(Pasajero pasajero) {
        if (top < maxSize - 1) {
            pasajeros[++top] = pasajero;
        } else {
            System.out.println("La pila está llena, no se puede apilar más pasajeros.");
        }
    }

    public Pasajero desapilar() {
        if (top >= 0) {
            return pasajeros[top--];
        } else {
            System.out.println("La pila está vacía, no se pueden desapilar más pasajeros.");
            return null;
        }
    }
    
    public void desapilarRespetandoFila(int numPasajerosADesapilar) {
        if (numPasajerosADesapilar <= 0 || numPasajerosADesapilar > maxSize) {
            System.out.println("Número de pasajeros a desapilar no válido.");
            return;
        }

        Pila pilaAuxiliar = new Pila(numPasajerosADesapilar);

        // Desapilar los pasajeros y almacenarlos en la pila auxiliar
        for (int i = 0; i < numPasajerosADesapilar; i++) {
            if (!estaVacia()) {
                pilaAuxiliar.apilar(desapilar());
            } else {
                System.out.println("La pila está vacía, no se pueden desapilar más pasajeros.");
                break;
            }
        }

        // Volver a apilar los pasajeros en la pila original en el mismo orden
        while (!pilaAuxiliar.estaVacia()) {
            apilar(pilaAuxiliar.desapilar());
        }
    }


    public boolean estaVacia() {
        return top == -1;
    }
    
    public boolean estaLlena() {
    return top == maxSize - 1;
}

    public int getMaxSize() {
        return maxSize;
    }
    
    public int size() {
        return top + 1;
    }

    public boolean isFull() {
        return false;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
    //contar espacios sin pasajeros
    public int contarCapacidad() {
        int capacidad = 0;
        for (int i = 0; i < maxSize; i++) {
            if (pasajeros[i] == null) {
                capacidad++;
            }
        }
        return capacidad;
    }
    
    public Pasajero peek() {
        if (top >= 0) {
            return pasajeros[top];
        } else {
            System.out.println("La pila está vacía, no hay elementos para hacer peek.");
            return null;
        }
    }
    


public String imprimirPila() {
    StringBuilder resultado = new StringBuilder();
   

    StringBuilder contenidoCelda = new StringBuilder(""); // Inicializa el contenido de la celda con el delimitador "|"

    // Itera a través de los pasajeros en la pila
    for (int i = 0; i < maxSize; i++) {
        // Si hay un pasajero en esta posición, obtén su nombre y ajusta el formato
        if (i <= top && pasajeros[i] != null) {
            String nombre = pasajeros[i].getNombre();
            int longitudNombre = nombre.length(); // Obtiene la longitud del nombre
            int espaciosAntes = (18 - longitudNombre) / 2;
            int espaciosDespues = 18 - longitudNombre - espaciosAntes;
            // Asegura que el nombre tenga un máximo de 18 caracteres y ajústalo al centro
            nombre = String.format("%" + (espaciosAntes + longitudNombre) + "s%" + espaciosDespues + "s", nombre, "");
            contenidoCelda.append("[ ").append(nombre).append(" ]").append("  ");
        } else {
            contenidoCelda.append(" [             vacia                  ]").append("  "); // Espacios en blanco para una celda vacía

        }
    }
//    int longitud = contenidoCelda.length();
//    String asteriscos = "-".repeat(longitud);
//    resultado.append(asteriscos).append("\n");
    resultado.append(contenidoCelda).append("\n");
//    resultado.append(asteriscos);
   

    return resultado.toString();
}

    
//public String imprimirPila() {
//    StringBuilder resultado = new StringBuilder();
//    String separador = "+---------------------+"; // Representa el formato del separador para una celda en la pila
//    resultado.append(separador).append("\n");
//
//    StringBuilder contenidoCelda = new StringBuilder("|"); // Inicializa el contenido de la celda con el delimitador "|"
//
//    // Itera a través de los pasajeros en la pila
//    for (int i = 0; i < maxSize; i++) {
//        // Si hay un pasajero en esta posición, obtén su nombre y ajusta el formato
//        if (i <= top && pasajeros[i] != null) {
//            String nombre = pasajeros[i].getNombre();
//            int longitudNombre = nombre.length(); // Obtiene la longitud del nombre
//            int espaciosAntes = (18 - longitudNombre) / 2;
//            int espaciosDespues = 18 - longitudNombre - espaciosAntes;
//            // Asegura que el nombre tenga un máximo de 18 caracteres y ajústalo al centro
//            nombre = String.format("%" + (espaciosAntes + longitudNombre) + "s%" + espaciosDespues + "s", nombre, "");
//            contenidoCelda.append(nombre).append("|");
//        } else {
//            contenidoCelda.append(" |             vacia                  |"); // Espacios en blanco para una celda vacía
//            
//        }
//    }
//
//    resultado.append(contenidoCelda).append("\n");
//    resultado.append(separador).append("\n"); // Agrega el separador después de cada celda
//
//    return resultado.toString();
//}





//public String imprimirPila() {
//    StringBuilder resultado = new StringBuilder();
//    String separador = "+---------------------+"; // Representa el formato del separador para una celda en la pila
//    resultado.append(separador).append("\n");
//
//    // Itera a través de los pasajeros en la pila
//    for (int i = 0; i < maxSize; i++) {
//        StringBuilder contenidoCelda = new StringBuilder("|"); // Inicializa el contenido de la celda con el delimitador "|"
//
//        // Si hay un pasajero en esta posición, obtén su nombre y ajusta el formato
//        if (i <= top && pasajeros[i] != null) {
//            String nombre = pasajeros[i].getNombre();
//            int longitudNombre = nombre.length(); // Obtiene la longitud del nombre
//            int espaciosAntes = (18 - longitudNombre) / 2;
//            int espaciosDespues = 18 - longitudNombre - espaciosAntes;
//            // Asegura que el nombre tenga un máximo de 18 caracteres y ajústalo al centro
//            nombre = String.format("%" + (espaciosAntes + longitudNombre) + "s%" + espaciosDespues + "s", nombre, "");
//            contenidoCelda.append(nombre).append("|");
//        } else {
//            contenidoCelda.append("                             |"); // Espacios en blanco para una celda vacía
//        }
//
//        resultado.append(contenidoCelda).append("\n");
//        resultado.append(separador).append("\n"); // Agrega el separador después de cada celda
//    }
//
//    return resultado.toString();
//}
    
}



