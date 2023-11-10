/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

/**
 *
 * @author RouryR
 */

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
    String separador = "+------------------+"; 
    resultado.append(separador).append("\n");

    // Itera a través de los pasajeros en la pila
    for (int i = 0; i < maxSize; i++) {
        StringBuilder contenidoCelda = new StringBuilder("|"); // Inicializa el contenido de la celda con el delimitador "|"

      
        if (i <= top && pasajeros[i] != null) {
            String nombre = pasajeros[i].getNombre();
            int longitudNombre = nombre.length(); 
            int espaciosAntes = (18 - longitudNombre) / 2;
            int espaciosDespues = 18 - longitudNombre - espaciosAntes;
           
            nombre = String.format("%" + (espaciosAntes + longitudNombre) + "s%" + espaciosDespues + "s", nombre, "");
            contenidoCelda.append(nombre).append("|");
        } else {
            contenidoCelda.append("                  |"); 
        }

        resultado.append(contenidoCelda).append("\n");
        resultado.append(separador).append("\n"); 
    }

    return resultado.toString();
}


    
}



