package proyectogrupo1;

import popups.Popups;
import proyectogrupo1.Interfaz.Menu;
import proyectogrupo1.Interfaz.Carga_ini;

public class ProyectoGrupo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Popups.bienvenido();
        Carga_ini dialog = new Carga_ini(new javax.swing.JFrame(), true);
//        //Hacer visible el JDialog
        dialog.setVisible(true);
        Menu inicio = new Menu();
        inicio.setVisible(true);

//Tren tren = new Tren(); // Crear una instancia de la clase Tren
//tren.start(); // Iniciar el hilo del tren para que se mueva y atienda pasajeros
//
//Pasajero pasajero1 = new Pasajero("Fabian 1", 30, 1, 2, Pasajero.Discapacidad.SI);
//Pasajero pasajero2 = new Pasajero("David 2", 30, 0, 6, Pasajero.Discapacidad.SI);
//
//Pasajero pasajero3 = new Pasajero("Karla 3", 22, 3, 4, Pasajero.Discapacidad.SI);
//
//Pasajero pasajero4 = new Pasajero("Diego 4", 28, 3, 6, Pasajero.Discapacidad.NO);
//Pasajero pasajero5 = new Pasajero("Estefan 5", 35, 1, 2, Pasajero.Discapacidad.NO);
//Pasajero pasajero6 = new Pasajero("Moises 6", 22, 4, 6, Pasajero.Discapacidad.NO);
//Pasajero pasajero7 = new Pasajero("Juan 7", 22, 3, 5, Pasajero.Discapacidad.NO);
//Pasajero pasajero8 = new Pasajero("Ricardo 8", 28, 3, 6, Pasajero.Discapacidad.NO);
//Pasajero pasajero9 = new Pasajero("Angela 9", 35, 1, 3, Pasajero.Discapacidad.NO);
//
//Pasajero pasajero10 = new Pasajero("Sofia 10", 22, 1, 4, Pasajero.Discapacidad.NO);
//Pasajero pasajero11 = new Pasajero("Eduardo 11", 22, 0, 1, Pasajero.Discapacidad.NO);
//Pasajero pasajero12 = new Pasajero("Melissa 12", 22, 2, 4, Pasajero.Discapacidad.NO);
//
//         //Crear una cola y encolar pasajeros
//        System.out.println("Cola de pasajeros:");
//        Cola cola = new Cola();
//        cola.encolar(pasajero1, true, 1);
//        cola.encolar(pasajero2, true, 0);
//        cola.encolar(pasajero3, true, 3);
//        cola.encolar(pasajero4, false, 3);
//        cola.encolar(pasajero5, false, 1);
//        cola.encolar(pasajero6, false, 4);
//        cola.encolar(pasajero7, false, 3);
//        cola.encolar(pasajero8, false, 3);
//        cola.encolar(pasajero9, false, 1);
//        // cola.encolar(pasajero10, false, 1);
//        // cola.encolar(pasajero11, false, 0);
//        // cola.encolar(pasajero12, false, 2);
//        System.out.println("");
//        System.out.println("Pasajeros en la cola por Provincia:");
//        cola.imprimirCola();
//        System.out.println("");
//        
//        Vagon vagon = new Vagon(3, 3, 2);
//        cola.subirPasajerosAlVagon(vagon);
//
//        // Imprimir las pilas del vagón para ver los pasajeros que se montaron
//        System.out.println("\nPilas del tren después de subir pasajeros:");
//        //vagon.imprimirPilasDelTren();
//        System.out.println("");
//
//        tren.agregarPasajeroEstacion(pasajero1, 1); // Agregar pasajero1 a la estación 1 (Alajuela)
//        tren.agregarPasajeroEstacion(pasajero2, 0); // Agregar pasajero2 a la estación 0 (Guanacaste)
//        tren.agregarPasajeroEstacion(pasajero3, 3); // Agregar pasajero3 a la estación 5 (San Jose)
//        tren.agregarPasajeroEstacion(pasajero4, 3); // Agregar pasajero4 a la estación 3 (Cartago)
//        tren.agregarPasajeroEstacion(pasajero5, 1); // Agregar pasajero5 a la estación 1 (Alajuela)
//        tren.agregarPasajeroEstacion(pasajero6, 4); // Agregar pasajero6 a la estación 4 (Heredia)
//        tren.agregarPasajeroEstacion(pasajero7, 3); // Agregar pasajero7 a la estación 5 (San Jose)
//        tren.agregarPasajeroEstacion(pasajero8, 3); // Agregar pasajero8 a la estación 3 (Cartago)
//        tren.agregarPasajeroEstacion(pasajero9, 1); // Agregar pasajero9 a la estación 4 (Heredia)
//         tren.agregarPasajeroEstacion(pasajero10, 1); // Agregar pasajero10 a la estación 1 (Alajuela)
//         tren.agregarPasajeroEstacion(pasajero11, 0); // Agregar pasajero11 a la estación 6 (Puntarenas)
//         tren.agregarPasajeroEstacion(pasajero12, 2); // Agregar pasajero12 a la estación 6 (Puntarenas)
//         //Imprimir la cola para ver los pasajeros que quedaron esperando
// 
//        System.out.println("\nPasajeros que quedaron en la cola esperando:");
//        cola.imprimirCola();
//        System.out.println("");
//        // Esperar un tiempo suficiente para que el tren se mueva y atienda pasajeros
//        try {
//            Thread.sleep(3000); // Esperar 30 segundos (tiempo suficiente para el movimiento del tren)
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
