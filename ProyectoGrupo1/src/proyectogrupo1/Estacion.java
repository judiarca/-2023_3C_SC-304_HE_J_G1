package proyectogrupo1;


/**
 *
 * @author RouryR
 */
public class Estacion {
    private static String nombre;
    private int distancia;
    private int tiempo;
    private int estacion;
    
    public Estacion(String nombre, int distancia, int tiempo,int estacion) {
        Estacion.nombre = nombre;
        this.distancia = distancia;
        this.tiempo = tiempo;
        this.estacion = estacion;
    }

    public Estacion() {

    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getDistancia() {
        return distancia;
    }
    
    public int getTiempo() {
        return tiempo;
    }

    

    public static String estacion_String(int estacion) {
        if (estacion == 0) {
            nombre = "Guanacaste";
        }
        if (estacion == 1) {
            nombre = "Alajuela";
        }
        if (estacion == 2) {
            nombre = "Limon ";
        }
        if (estacion == 3) {
            nombre = "Cartago";
        }
        if (estacion == 4) {
            nombre = "Heredia";
        }
        if (estacion == 5) {
            nombre = "San Jose";
        }
        if (estacion == 6) {
            nombre = "Puntarenas";
        }
        
        return nombre;
    }

    public int getEstacion() {
        return estacion;
    }

    
}
