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

    public int getEstacion_Origen() {
        return Estacion_Origen;
    }

    public int getEstacion_Destino() {
        return Estacion_Destino;
    }

    public Cola getColaDisc() {
        return ColaDisc;
    }

    public Cola getColaNoDisc() {
        return ColaNoDisc;
    }
    //metodo
    // Método que retorna el nombre de la estación
    
    public String obtenerNombreEstacion() {
        if (Estacion_id == 0) {
            return "San Jose";
        } else if (Estacion_id == 1) {
            return "Alajuela";
        } else if (Estacion_id == 2) {
            return "Cartago";
        } else if (Estacion_id == 3) {
            return "Heredia";
        } else if (Estacion_id == 4) {
            return "Puntarenas";
        } else if (Estacion_id == 5) {
            return "Guanacaste";
        } else if (Estacion_id == 6) {
            return "Limon";    
        } else 
           return"";                                    
    }
     
            
  
   
    
}//fin de la clase Estacion

