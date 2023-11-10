/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

/**
 *
 * @author RouryR
 */
    public class Grafo {
    private int[][] matrizAdyacencia;
    private int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.matrizAdyacencia = new int[numVertices][numVertices];
    }

    public void agregarRuta(int origen, int destino, int distancia) {
        matrizAdyacencia[origen][destino] = distancia;
        matrizAdyacencia[destino][origen] = distancia; // La ruta es bidireccional
    }

    public int obtenerDistancia(int origen, int destino) {
        return matrizAdyacencia[origen][destino];
    }
}

