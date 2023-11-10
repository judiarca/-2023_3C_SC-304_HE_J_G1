/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author RouryR
 */
public class Cargar_Pasajeros_CSV {
    public Cola cola = new Cola();
    
    public void Cargar_ejemplos_CSV(){
    JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo CSV");
        int seleccion = fileChooser.showOpenDialog(fileChooser);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoCSV = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
                String linea;
                boolean primeraLinea = true;
                while ((linea = br.readLine()) != null) {
                    if (linea.trim().isEmpty()) {
                        // Ignorar líneas vacías
                        continue;
                    }
                    if (primeraLinea) {
                        primeraLinea = false;
                        continue; // Saltar la primera línea (encabezados)
                    }
                    String[] datos = linea.split(";");
                    String nombre = datos[0];
                    int edad = Integer.parseInt(datos[1]);
                    int estacionOrigen = Integer.parseInt(datos[2].trim()); // Parsear como entero
                    int estacionDestino = Integer.parseInt(datos[3].trim()); // Parsear como entero
                    Pasajero.Discapacidad discapacidad = Pasajero.Discapacidad.valueOf(datos[4].trim());
                    Pasajero.Estado estado = Pasajero.Estado.valueOf(datos[5].trim());

                    Pasajero pasajero = new Pasajero(nombre, edad, estacionOrigen, estacionDestino, discapacidad);
                    pasajero.setEstado(estado);
                    cola.encolar(pasajero, discapacidad == Pasajero.Discapacidad.SI, estacionOrigen);
                    

                }
                // Establecer el texto en un text area aqui*********
                String contenidoCola = cola.imprimirCola();
                
                //Aqui hacer un setText al tex area
                //xxxxx.setText(contenidoCola);
                //Tren tren = new Tren(); // Crear una instancia de la clase Tren
                //tren.start(); // Iniciar el hilo del tren para que se mueva y atienda pasajeros
                // Sube pasajeros al tren desde la cola
                //Vagon vagon = new Vagon(3, 3, 2);
                cola.subirPasajerosAlVagon(vagon);
                // Imprime el estado del tren en el JTextArea
       
        
          // Esperar un tiempo suficiente para que el tren se mueva y atienda pasajeros
        try {
            Thread.sleep(3000); // Esperar 30 segundos (tiempo suficiente para el movimiento del tren)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            } catch (IOException e) {
                e.printStackTrace();
                // Manejar la excepción
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Manejar la excepción de conversión de número
            }
        }
}
}
