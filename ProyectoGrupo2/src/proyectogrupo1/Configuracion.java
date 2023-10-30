package proyectogrupo1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.ini4j.Ini;
import popups.Popups;

/**
 *
 * @author RouryR
 */
public class Configuracion {
    private int filas_vagon_discapacidad = 1;
    private int filas_vagon_sin_discapacidad = 2;
    private int asientos_fila_discapacidad = 1;
    private int asientos_fila_sin_discapacidad = 3;
    private String nombre_empresa = "Fidelitas Team 2";
    private int tiempo_avance_segundos = 1;
    private int costo_por_kilometro = 100;

    public Configuracion() {
        String mensaje = "Aplicando configuración....";
        Popups Config = new Popups();
        Config.espera(mensaje);
        try {
            Ini ini = new Ini(new File("proyectogrupo2/config.ini"));
            this.filas_vagon_discapacidad = Integer.parseInt(ini.get("Configuracion", "filas_vagon_discapacidad"));
            this.filas_vagon_sin_discapacidad = Integer.parseInt(ini.get("Configuracion", "filas_vagon_sin_discapacidad"));
            this.asientos_fila_discapacidad = Integer.parseInt(ini.get("Configuracion", "asientos_fila_discapacidad"));
            this.asientos_fila_sin_discapacidad = Integer.parseInt(ini.get("Configuracion", "asientos_fila_sin_discapacidad"));
            this.nombre_empresa = ini.get("Configuracion", "nombre_empresa");
            this.tiempo_avance_segundos = Integer.parseInt(ini.get("Configuracion", "tiempo_avance_segundos"));
            this.costo_por_kilometro = Integer.parseInt(ini.get("Configuracion", "costo_por_kilometro"));
       } catch (FileNotFoundException e) {
        System.out.println("Error: Archivo de configuración no encontrado.");
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public int getfilas_vagon_discapacidad() {
        return filas_vagon_discapacidad;
    }

    public void setfilas_vagon_discapacidad(int filas_vagon_discapacidad) {
        this.filas_vagon_discapacidad = filas_vagon_discapacidad;
    }

    public int getfilas_vagon_sin_discapacidad() {
        return filas_vagon_sin_discapacidad;
    }

    public void setfilas_vagon_sin_discapacidad(int filas_vagon_sin_discapacidad) {
        this.filas_vagon_sin_discapacidad = filas_vagon_sin_discapacidad;
    }

    public int getasientos_fila_discapacidad() {
        return asientos_fila_discapacidad;
    }

    public void setasientos_fila_discapacidad(int asientos_fila_discapacidad) {
        this.asientos_fila_discapacidad = asientos_fila_discapacidad;
    }

    public int getasientos_fila_sin_discapacidad() {
        return asientos_fila_sin_discapacidad;
    }

    public void setasientos_fila_sin_discapacidad(int asientos_fila_sin_discapacidad) {
        this.asientos_fila_sin_discapacidad = asientos_fila_sin_discapacidad;
    }

    public String getnombre_empresa() {
        return nombre_empresa;
    }

    public void setnombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public int gettiempo_avance_segundos() {
        return tiempo_avance_segundos;
    }

    public void settiempo_avance_segundos(int tiempo_avance_segundos) {
        this.tiempo_avance_segundos = tiempo_avance_segundos;
    }

    public int getcosto_por_kilometro() {
        return costo_por_kilometro;
    }

    public void setcosto_por_kilometro(int costo_por_kilometro) {
        this.costo_por_kilometro = costo_por_kilometro;
    }

    
}
