/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

/**
 *
 * @author estefanleon
 */
public class Estacion {
    //Variables
    private int Estacion_id;
    private int Estacion_Origen;
    private int Estacion_Destino;        
    Cola ColaDisc = new Cola();
    Cola ColaNoDisc = new Cola();
    
    //Constructor    
    public Estacion(int Estacion_id, int Estacion_Origen, int Estacion_Destino) {
        this.Estacion_id = Estacion_id;
        this.Estacion_Origen = Estacion_Origen;
        this.Estacion_Destino = Estacion_Destino;
    }
    //metodo para convertir numero de estacion a su respectivo nombre
    private String NumeroEstacion(int numeroEstacion) {
       
        switch (numeroEstacion) {
            case 1: return "San Jose";
            case 2: return "Alajuela";
            case 3: return "Cartago";
            case 4: return "Heredia";
            case 5: return "Guanacaste";
            case 6: return "Puntarenas";
            case 7: return "Limón";
            default: return "Desconocido";
        }
    }
    //metodo para leer e imprimir las estaciones de tren
    public void leerEImprimirEstaciones() {
        for (int i = 1; i <= 7; i++) {
            Estacion estacion = new Estacion(i, i + 10, i + 20); 
            System.out.println("Estación ID: " + estacion.Estacion_id);
            System.out.println("Origen: " + NumeroEstacion(estacion.Estacion_Origen));
            System.out.println("Destino: " + NumeroEstacion(estacion.Estacion_Destino));
            System.out.println("--------------");
        }
    }//fin del metodo leerEimprimirEstaciones
    
    }//fin de la clase Estacion

   
       

