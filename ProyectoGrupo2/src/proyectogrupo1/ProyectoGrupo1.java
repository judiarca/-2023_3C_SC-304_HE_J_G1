/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectogrupo1;

import popups.Popups;
import proyectogrupo1.Interfaz.Menu;
import proyectogrupo1.Interfaz.info_config;

/**
 *
 * @author RouryR
 */
public class ProyectoGrupo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Popups.bienvenido();
        

        info_config dialog = new info_config(new javax.swing.JFrame(), true);

        // Hacer visible el JDialog
        dialog.setVisible(true);
        
         Menu inicio = new Menu();
        inicio.setVisible(true);
    }
    
}
