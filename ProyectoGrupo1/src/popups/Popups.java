package popups;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;


public class Popups {

  public static void bienvenido() {
    String error_o_mensaje = "¡Bienvenido a nuestra App! \n \n HECHO POR: \n -Diego Jose Ramirez Corrales \n -Juan Diego Araya \n -Juan Diego Araya \n -Estefan Leon Cordero ";
    JDialog dialog = new JDialog((Frame) null, true);
        dialog.setUndecorated(true);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Borde
        Border border = BorderFactory.createLineBorder(new Color(204,0,51), 2);
        dialog.getRootPane().setBorder(border);

        UIManager.put("OptionPane.background", new Color(255, 255, 255));
        UIManager.put("OptionPane.messageForeground", new Color(204, 0, 51));
        UIManager.put("Panel.background", new Color(255, 255, 255));
        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14)); 

        ClassLoader classLoader = Popups.class.getClassLoader();
        ImageIcon icono2 = new ImageIcon(classLoader.getResource("img/bienvenido.gif"));

        JOptionPane pane = new JOptionPane(
                error_o_mensaje,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                icono2,
                new Object[]{},
                null);
        dialog.setContentPane(pane);
        dialog.setTitle("Estructura de Datos 2023");
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
  }//FIN BIENVENIDO

  public static void despedida() {
    String error_o_mensaje = "¡Bienvenido a nuestra App! \n \n HECHO POR: \n -Diego Jose Ramirez Corrales";
    JDialog dialog = new JDialog((Frame) null, true);
        dialog.setUndecorated(true);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Borde
        Border border = BorderFactory.createLineBorder(new Color(204,0,51), 2);
        dialog.getRootPane().setBorder(border);

        UIManager.put("OptionPane.background", new Color(255, 255, 255));
        UIManager.put("OptionPane.messageForeground", new Color(204, 0, 51));
        UIManager.put("Panel.background", new Color(255, 255, 255));
        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14)); 

        ClassLoader classLoader = Popups.class.getClassLoader();
        ImageIcon icono2 = new ImageIcon(classLoader.getResource("img/bye.jpg"));

        JOptionPane pane = new JOptionPane(
                error_o_mensaje,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                icono2,
                new Object[]{},
                null);
        dialog.setContentPane(pane);
        dialog.setTitle("Estructura de Datos 2023");
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
  }//FIN DESPEDIDA

  public void espera(String error_o_mensaje) {
    JDialog dialog = new JDialog((Frame) null, true);
        dialog.setUndecorated(true);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Borde
        Border border = BorderFactory.createLineBorder(new Color(204,0,51), 2);
        dialog.getRootPane().setBorder(border);

        UIManager.put("OptionPane.background", new Color(255, 255, 255));
        UIManager.put("OptionPane.messageForeground", new Color(204, 0, 51));
        UIManager.put("Panel.background", new Color(255, 255, 255));
        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14)); 

        ClassLoader classLoader = Popups.class.getClassLoader();
        ImageIcon icono2 = new ImageIcon(classLoader.getResource("img/search.gif"));

        JOptionPane pane = new JOptionPane(
                error_o_mensaje,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                icono2,
                new Object[]{},
                null);

        dialog.setContentPane(pane);
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
  }//FIN ESPERA

  public void error(String error_o_mensaje) {
    JDialog dialog = new JDialog((Frame) null, true);
        dialog.setUndecorated(true);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Borde
       Border border = BorderFactory.createLineBorder(new Color(204,0,51), 2);
        dialog.getRootPane().setBorder(border);

        UIManager.put("OptionPane.background", new Color(255, 255, 255));
        UIManager.put("OptionPane.messageForeground", new Color(204, 0, 51));
        UIManager.put("Panel.background", new Color(255, 255, 255));
        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14)); 

        ClassLoader classLoader = Popups.class.getClassLoader();
        ImageIcon icono2 = new ImageIcon(classLoader.getResource("img/error.gif"));

        JOptionPane pane = new JOptionPane(
                error_o_mensaje,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                icono2,
                new Object[]{},
                null);

        dialog.setContentPane(pane);
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
  }//FIN ERROR

  public void pulgar_arriba(String error_o_mensaje) {
    JDialog dialog = new JDialog((Frame) null, true);
        dialog.setUndecorated(true);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Borde
        Border border = BorderFactory.createLineBorder(new Color(204,0,51), 2);
        dialog.getRootPane().setBorder(border);

        UIManager.put("OptionPane.background", new Color(255, 255, 255));
        UIManager.put("OptionPane.messageForeground", new Color(204, 0, 51));
        UIManager.put("Panel.background", new Color(255, 255, 255));
        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14)); 

        ClassLoader classLoader = Popups.class.getClassLoader();
        ImageIcon icono2 = new ImageIcon(classLoader.getResource("proyecto_pizzeria/images/pulgar_arriba.gif"));

        JOptionPane pane = new JOptionPane(
                error_o_mensaje,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                icono2,
                new Object[]{},
                null);

        dialog.setContentPane(pane);
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
  }//FIN PULGAR ARRIBA

  public void cerrando_sesion(String error_o_mensaje) {
    JDialog dialog = new JDialog((Frame) null, true);
        dialog.setUndecorated(true);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Borde
        Border border = BorderFactory.createLineBorder(new Color(204,0,51), 2);
        dialog.getRootPane().setBorder(border);

        UIManager.put("OptionPane.background", new Color(255, 255, 255));
        UIManager.put("OptionPane.messageForeground", new Color(204, 0, 51));
        UIManager.put("Panel.background", new Color(255, 255, 255));
        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14)); 

        ClassLoader classLoader = Popups.class.getClassLoader();
        ImageIcon icono2 = new ImageIcon(classLoader.getResource("proyecto_pizzeria/images/cargando.gif"));

        JOptionPane pane = new JOptionPane(
                error_o_mensaje,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                icono2,
                new Object[]{},
                null);

        dialog.setContentPane(pane);
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
  }//FIN CERRANDO SESION

  public void eliminando(String error_o_mensaje) {
    JDialog dialog = new JDialog((Frame) null, true);
        dialog.setUndecorated(true);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Borde
        Border border = BorderFactory.createLineBorder(new Color(204,0,51), 2);
        dialog.getRootPane().setBorder(border);

        UIManager.put("OptionPane.background", new Color(255, 255, 255));
        UIManager.put("OptionPane.messageForeground", new Color(204, 0, 51));
        UIManager.put("Panel.background", new Color(255, 255, 255));
        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14)); 

        ClassLoader classLoader = Popups.class.getClassLoader();
        ImageIcon icono2 = new ImageIcon(classLoader.getResource("proyecto_pizzeria/images/eliminando.gif"));

        JOptionPane pane = new JOptionPane(
                error_o_mensaje,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                icono2,
                new Object[]{},
                null);

        dialog.setContentPane(pane);
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
  }//FIN ELIMINANDO

  public void editando(String error_o_mensaje) {
    JDialog dialog = new JDialog((Frame) null, true);
        dialog.setUndecorated(true);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Borde
        Border border = BorderFactory.createLineBorder(new Color(204,0,51), 2);
        dialog.getRootPane().setBorder(border);

        UIManager.put("OptionPane.background", new Color(255, 255, 255));
        UIManager.put("OptionPane.messageForeground", new Color(204, 0, 51));
        UIManager.put("Panel.background", new Color(255, 255, 255));
        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14)); 

        ClassLoader classLoader = Popups.class.getClassLoader();
        ImageIcon icono2 = new ImageIcon(classLoader.getResource("proyecto_pizzeria/images/editing.gif"));

        JOptionPane pane = new JOptionPane(
                error_o_mensaje,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                icono2,
                new Object[]{},
                null);

        dialog.setContentPane(pane);
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);;
  }//FIN EDITANDO

  public void registrando(String error_o_mensaje) {
    JDialog dialog = new JDialog((Frame) null, true);
        dialog.setUndecorated(true);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Borde
        Border border = BorderFactory.createLineBorder(new Color(204,0,51), 2);
        dialog.getRootPane().setBorder(border);

        UIManager.put("OptionPane.background", new Color(255, 255, 255));
        UIManager.put("OptionPane.messageForeground", new Color(204, 0, 51));
        UIManager.put("Panel.background", new Color(255, 255, 255));
        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14)); 

        ClassLoader classLoader = Popups.class.getClassLoader();
        ImageIcon icono2 = new ImageIcon(classLoader.getResource("proyecto_pizzeria/images/registrando.gif"));

        JOptionPane pane = new JOptionPane(
                error_o_mensaje,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                icono2,
                new Object[]{},
                null);

        dialog.setContentPane(pane);
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
  }//FIN REGISTRANDO
  
}//FIN CLASE