package proyectogrupo1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import popups.Popups;


public class Cargar_CSV_Pasajeros {

    public static void Cargar_CSV_Pasajeros1() {
//        String archivo = "src/proyectogrupo1/Lista_Pasajeros_CSV.csv";
//        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
//            String linea;
//            while ((linea = br.readLine()) != null) {
//                String[] datos = linea.split(",");
//                if (datos.length == 6) { // Asegurarse de que haya suficientes campos en una línea del CSV
//                    Pasajero pasajero = new Pasajero();
//                    pasajero.setNombre(datos[0]);
//                    pasajero.setEdad(Integer.parseInt(datos[1]));
//                    pasajero.setEstacion_Origen(datos[2]);
//                    pasajero.setEstacion_Destino(datos[3]);
//                    pasajero.setDiscapacitado(Discapacidad.valueOf(datos[4].toUpperCase()));
//                    pasajero.setEstado(Estado.valueOf(datos[5].toUpperCase()));
//                    // Agregar el pasajero a donde corresponda (en una cola, lista, etc.)
//
//                    String error_MSG = " encontrado.";
//                    Popups error = new Popups();
//                    error.error(error_MSG);
//                }
//            }
//        } catch (FileNotFoundException e) {
//            String error_MSG = "Error: Archivo de configuracion no encontrado.";
//            Popups error = new Popups();
//            error.error(error_MSG);
//            //System.out.println("Error: Archivo de configuracion no encontrado.");
//            //System.out.println("Ruta del archivo: " + new File("config.ini").getAbsolutePath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    //para llamarlo
    // CargadorDePasajeros.cargarPasajerosDesdeCSV("ejemplo_pasajeros.csv");
    // Puedes agregar lógica adicional para manipular los pasajeros cargados
}
