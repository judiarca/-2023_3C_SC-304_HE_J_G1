package proyectogrupo1;

/**
 *
 * @author RouryR
 */
public class Pasajero {

    public enum Estado {
        EN_COLA,
        EN_CAMINO,
        COMPLETADO
    }

    // Discapacidad del pasajero
    public enum Discapacidad {
        SI,
        NO
    }

    private String nombre;
    private int edad;
    private int Estacion_Origen;
    private int Estacion_Destino;
    private Discapacidad discapacitado;
    private Estado estado;
    private boolean completado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEstacion_Origen() {
        return Estacion_Origen;
    }

    public void setEstacion_Origen(int Estacion_Origen) {
        this.Estacion_Origen = Estacion_Origen;
    }

    public int getEstacion_Destino() {
        return Estacion_Destino;
    }

    public void setEstacion_Destino(int Estacion_Destino) {
        this.Estacion_Destino = Estacion_Destino;
    }

    public Discapacidad getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(Discapacidad discapacitado) {
        this.discapacitado = discapacitado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Pasajero(String nombre, int edad, int Estacion_Origen, int Estacion_Destino, Discapacidad discapacitado) {
        this.nombre = nombre;
        this.edad = edad;
        this.Estacion_Origen = Estacion_Origen;
        this.Estacion_Destino = Estacion_Destino;
        this.discapacitado = discapacitado;
        this.estado = Estado.EN_COLA; // Otra inicialización si es necesaria
        this.completado = false; // Otra inicialización si es necesaria
    }

    @Override
    public String toString() {
          String Estacion_Destino_SRT = Estacion.estacion_String(Estacion_Destino);
        String Estacion_Origen_SRT = Estacion.estacion_String(Estacion_Origen);
        String discapacidadStr = discapacitado == Discapacidad.SI ? "Si" : "No";
        String estadoStr = estado == Estado.EN_COLA ? "En cola" : "En camino";
        return "Nombre: " + nombre + ", Edad: " + edad + ", Estacion Origen: " + Estacion_Origen_SRT +
                ", Estacion Destino: " + Estacion_Destino_SRT + ", Discapacitado: " + discapacidadStr +
                ", Estado: " + estadoStr + ", Completado: " + obtenerEstado();
    }

    public String obtenerEstado() {
    if (completado) {
        return "Si";
    } else {
         return "No";
    }
}

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public boolean isDiscapacitado() {
        return discapacitado == Discapacidad.SI;
       
    }

    
public String es(){
    if (isDiscapacitado()){
        return "Discapacitado";
    }else{
        return " NO Discapacitado";
    }
}

}
