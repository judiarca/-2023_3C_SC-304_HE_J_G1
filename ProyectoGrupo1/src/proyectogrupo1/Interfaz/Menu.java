/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectogrupo1.Interfaz;

import Estructura_Datos.Cola;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import popups.Popups;
import proyectogrupo1.Pasajero;
import proyectogrupo1.Tren;

/**
 *
 * @author RouryR
 */
public class Menu extends javax.swing.JFrame {

    public static double costo_por_kilometro = 250;
//public static int filas_vagon_discapacidad = 5;
// public static int filas_vagon_sin_discapacidad = 2;
    public static int asientos_fila_discapacidad = 1;
    public static int asientos_fila_sin_discapacidad1 = 1;
    public static int asientos_fila_sin_discapacidad2 = 1;
    public static String nombre_empresa = "Grupo 1";
    public static int tiempo_avance_segundos = 2;
    private boolean statusVagonVisible = false;
    
    public static Cola cola = new Cola();
    Tren tren = new Tren();
    //Vagon vagon = new Vagon(asientos_fila_sin_discapacidad1, asientos_fila_sin_discapacidad2, asientos_fila_discapacidad);

    /**
     * Creates new form Menu
     */
    public Menu() {
        setUndecorated(true);
        initComponents();
        Asientos_NoDis1.setText("Asientos Fila 1 No Dis: " + asientos_fila_sin_discapacidad1);
        Asientos_NoDis2.setText("Asientos Fila 2 No Dis: " + asientos_fila_sin_discapacidad2);
         Asientos_dis.setText("Asientos Fila 3  Dis:  " + asientos_fila_discapacidad);
        tiempo_tren.setText("Tiempo Avance: " + Integer.toString(tiempo_avance_segundos) + " Seg.");
        empresa_name.setText("-- " + nombre_empresa + " --");
        Precioxkm.setText("Costo KM:₡" + costo_por_kilometro);
        iniFormulario();
        iniEstado_Vagon();

        if (cola.esVacia()) {
            Lista_Pasajeros_Estaciones.setText("No hay pasajeros esperando el tren");
        }

    }
    
   public void iniEstado_Vagon() {
    Status_Vagon.setVisible(false);

    // Configurar el JTextArea para mostrar el estado de los vagones
    JTextArea estadoVagonTextArea = new JTextArea();
    // estadoVagonTextArea.setLineWrap(true);  // Para que el texto se ajuste automáticamente al ancho
    // estadoVagonTextArea.setWrapStyleWord(true);  // Para que las palabras no se corten en líneas

    JScrollPane scrollPane = new JScrollPane(estadoVagonTextArea);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    // Establecer el tamaño preferido del JTextArea
    Dimension preferredSize = new Dimension(440, 165);  // Ajusta según tus necesidades
    scrollPane.setPreferredSize(preferredSize);

    // Agregar componentes al JTextArea Status_Vagon
    Status_Vagon.setLayout(new BorderLayout()); // Usar BorderLayout para organizar los componentes
    Status_Vagon.add(scrollPane, BorderLayout.CENTER);

    Ver_estado_vagones.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Si el panel está visible, lo oculta, de lo contrario, lo muestra
        if (statusVagonVisible) {
            Status_Vagon.setVisible(false);
        } else {
            // Muestra el panel para ver el estado de los vagones
            // Puedes actualizar el contenido del JTextArea aquí según el estado de los vagones
            estadoVagonTextArea.setText(tren.imprimirEstadoDePilasDelTren());

            // Ajustar la posición del caret para que el JScrollPane inicie desde la parte superior
            estadoVagonTextArea.setCaretPosition(0);

            Status_Vagon.setVisible(true);
        }

        // Actualiza el estado de visibilidad
        statusVagonVisible = !statusVagonVisible;
    }
});

    // Repintar el JTextArea para asegurar que los cambios sean visibles
    Status_Vagon.revalidate();
    Status_Vagon.repaint();
}


    public void iniFormulario() {
        Agregar_Pasajero.setVisible(false);

        // Acción del botón "Agregar Pasajero"
        Agregar_Pasajeros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Muestra el panel para agregar pasajeros
                Agregar_Pasajero.setVisible(true);
            }
        });

        // Crear y configurar componentes del formulario de ingreso de pasajeros
        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreTextField = new JTextField();
        JLabel edadLabel = new JLabel("Edad:");
        JTextField edadTextField = new JTextField();
        JLabel estacionOrigenLabel = new JLabel("Estación de Origen:");
        JComboBox<String> estacionOrigenComboBox = new JComboBox<>(new String[]{"Guanacaste", "Alajuela", "Limón ", "Cartago ", "Heredia ", "San Jose ", "Puntarenas "}); // Reemplaza con tus estaciones
        JLabel estacionDestinoLabel = new JLabel("Estación de Destino:");
        JComboBox<String> estacionDestinoComboBox = new JComboBox<>(new String[]{"Guanacaste", "Alajuela", "Limón ", "Cartago ", "Heredia ", "San Jose ", "Puntarenas "}); // Reemplaza con tus estaciones
        JLabel discapacidadLabel = new JLabel("Discapacidad:");
        JComboBox<String> discapacidadComboBox = new JComboBox<>(new String[]{"SI", "NO"});
        JButton agregarButton = new JButton("Agregar");
        JButton ocultarButton = new JButton("Ocultar");
        // Acción del botón "Agregar"
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener datos del formulario
                String nombre = nombreTextField.getText();
                int edad = Integer.parseInt(edadTextField.getText());
                int estacionOrigen = estacionOrigenComboBox.getSelectedIndex();
                int estacionDestino = estacionDestinoComboBox.getSelectedIndex();
                Pasajero.Discapacidad discapacidad = Pasajero.Discapacidad.valueOf((String) discapacidadComboBox.getSelectedItem());

                // Crear pasajero y agregarlo a la cola
                Pasajero pasajero = new Pasajero(nombre, edad, estacionOrigen, estacionDestino, discapacidad);
                pasajero.setEstado(Pasajero.Estado.EN_COLA);
                cola.encolar(pasajero, discapacidad == Pasajero.Discapacidad.SI, estacionOrigen);
                tren.agregarPasajeroEstacion(pasajero, estacionOrigen);

                // Limpiar campos del formulario
                nombreTextField.setText("");
                edadTextField.setText("");
                estacionOrigenComboBox.setSelectedIndex(0);
                estacionDestinoComboBox.setSelectedIndex(0);
                discapacidadComboBox.setSelectedIndex(0);
                if (cola.esVacia()) {
                    Lista_Pasajeros_Estaciones.setText("No hay pasajeros esperando el tren");
                } else {
                    String contenidoCola = cola.imprimirCola();
                    Lista_Pasajeros_Estaciones.setText(contenidoCola);
                }

                // Repintar el JPanel para asegurar que los cambios sean visibles
                Agregar_Pasajero.revalidate();
                Agregar_Pasajero.repaint();
            }
        });

        // Acción del botón "Ocultar"
        ocultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Agregar_Pasajero.setVisible(false); // Oculta el JPanel
            }
        });

        // Agregar componentes al JPanel Agregar_Pasajero
        Agregar_Pasajero.setLayout(new GridLayout(7, 2)); // Usar GridLayout para organizar los componentes en filas y columnas
        Agregar_Pasajero.add(nombreLabel);
        Agregar_Pasajero.add(nombreTextField);
        Agregar_Pasajero.add(edadLabel);
        Agregar_Pasajero.add(edadTextField);
        Agregar_Pasajero.add(estacionOrigenLabel);
        Agregar_Pasajero.add(estacionOrigenComboBox);
        Agregar_Pasajero.add(estacionDestinoLabel);
        Agregar_Pasajero.add(estacionDestinoComboBox);
        Agregar_Pasajero.add(discapacidadLabel);
        Agregar_Pasajero.add(discapacidadComboBox);
        Agregar_Pasajero.add(agregarButton);
        Agregar_Pasajero.add(ocultarButton);
        // Repintar el JPanel para asegurar que los cambios sean visibles
        Agregar_Pasajero.revalidate();
        Agregar_Pasajero.repaint();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                Color colorInicial = Color.decode("#D16BA5"); // Color inicial en formato HEX
                Color colorFinal = Color.decode("#86A8E7"); // Color final en formato HEX
                GradientPaint gradientPaint = new GradientPaint(0, 0, colorInicial, w, h, colorFinal);
                g2d.setPaint(gradientPaint);
                g2d.fillRect(0, 0, w, h);
            }
        };
        header = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                Color colorInicial = Color.decode("#C4A0B4"); // Color inicial en formato HEX
                Color colorFinal = Color.decode("#4A84EE"); // Color final en formato HEX
                GradientPaint gradientPaint = new GradientPaint(0, 0, colorInicial, w, h, colorFinal);
                g2d.setPaint(gradientPaint);
                g2d.fillRect(0, 0, w, h);
            }
        };
        Cargar_Pasajeros = new javax.swing.JButton();
        Agregar_Pasajeros = new javax.swing.JButton();
        Ver_Lista = new javax.swing.JButton();
        about = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Asientos_NoDis1 = new javax.swing.JLabel();
        Asientos_NoDis2 = new javax.swing.JLabel();
        tiempo_tren = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Asientos_dis = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Ver_estado_vagones = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista_Pasajeros_Estaciones = new javax.swing.JTextArea();
        Agregar_Pasajero = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Pagos_info = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        empresa_name = new javax.swing.JLabel();
        Precioxkm = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        C1TextArea = new javax.swing.JTextArea();
        Status_Vagon = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Detener_tren = new javax.swing.JButton();
        Iniciar_tren = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Estado_tren = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto Grupo 2");

        jDesktopPane1.setBackground(new java.awt.Color(255, 153, 153));

        header.setBackground(new java.awt.Color(209, 107, 165));
        header.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Menu Pasajeros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        header.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Cargar_Pasajeros.setBackground(new java.awt.Color(153, 204, 255));
        Cargar_Pasajeros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Cargar_Pasajeros.setForeground(new java.awt.Color(255, 255, 255));
        Cargar_Pasajeros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pasajeros.png"))); // NOI18N
        Cargar_Pasajeros.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Cargar Pasajeros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        Cargar_Pasajeros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cargar_Pasajeros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Cargar_Pasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cargar_PasajerosActionPerformed(evt);
            }
        });

        Agregar_Pasajeros.setBackground(new java.awt.Color(153, 204, 255));
        Agregar_Pasajeros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Agregar_Pasajeros.setForeground(new java.awt.Color(255, 255, 255));
        Agregar_Pasajeros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        Agregar_Pasajeros.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Agregar Pasajero", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        Agregar_Pasajeros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Agregar_Pasajeros.setHideActionText(true);
        Agregar_Pasajeros.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Agregar_Pasajeros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Agregar_Pasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_PasajerosActionPerformed(evt);
            }
        });

        Ver_Lista.setBackground(new java.awt.Color(153, 204, 255));
        Ver_Lista.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Ver_Lista.setForeground(new java.awt.Color(255, 255, 255));
        Ver_Lista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lista1.png"))); // NOI18N
        Ver_Lista.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Ver lista", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        Ver_Lista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Ver_Lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ver_ListaActionPerformed(evt);
            }
        });

        about.setBackground(new java.awt.Color(255, 204, 153));
        about.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        about.setForeground(new java.awt.Color(255, 255, 255));
        about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/about.png"))); // NOI18N
        about.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Aceca de", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        about.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });

        Exit.setBackground(new java.awt.Color(204, 0, 51));
        Exit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 255, 255));
        Exit.setText("Exit");
        Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(204, 0, 0), java.awt.Color.black, java.awt.Color.lightGray), "Configuración", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 14), new java.awt.Color(204, 0, 51))); // NOI18N

        Asientos_NoDis1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Asientos_NoDis1.setForeground(new java.awt.Color(0, 0, 0));
        Asientos_NoDis1.setText("Asientos No Dis1:");
        Asientos_NoDis1.setFocusable(false);

        Asientos_NoDis2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Asientos_NoDis2.setForeground(new java.awt.Color(0, 0, 0));
        Asientos_NoDis2.setText("Asientos No Dis2:");
        Asientos_NoDis2.setFocusable(false);

        tiempo_tren.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tiempo_tren.setForeground(new java.awt.Color(0, 0, 0));
        tiempo_tren.setText("Tiempo Avance");
        tiempo_tren.setFocusable(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/config.png"))); // NOI18N

        Asientos_dis.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Asientos_dis.setForeground(new java.awt.Color(0, 0, 0));
        Asientos_dis.setText("Asientos_dis");
        Asientos_dis.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(Asientos_dis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Asientos_NoDis2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Asientos_NoDis1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tiempo_tren, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Asientos_NoDis1)
                .addGap(18, 18, 18)
                .addComponent(Asientos_NoDis2)
                .addGap(18, 18, 18)
                .addComponent(Asientos_dis)
                .addGap(18, 18, 18)
                .addComponent(tiempo_tren)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Version 3.14.12.23");

        Ver_estado_vagones.setBackground(new java.awt.Color(153, 204, 255));
        Ver_estado_vagones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/asiento.png"))); // NOI18N
        Ver_estado_vagones.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Ver Vagon", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        Ver_estado_vagones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ver_estado_vagonesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Agregar_Pasajeros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cargar_Pasajeros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ver_Lista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(about, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ver_estado_vagones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(15, 15, 15))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Agregar_Pasajeros)
                .addGap(18, 18, 18)
                .addComponent(Cargar_Pasajeros)
                .addGap(18, 18, 18)
                .addComponent(Ver_Lista)
                .addGap(18, 18, 18)
                .addComponent(Ver_estado_vagones)
                .addGap(18, 18, 18)
                .addComponent(about)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(Exit)
                .addGap(26, 26, 26)
                .addComponent(jLabel1))
        );

        Lista_Pasajeros_Estaciones.setEditable(false);
        Lista_Pasajeros_Estaciones.setBackground(new java.awt.Color(255, 255, 255));
        Lista_Pasajeros_Estaciones.setColumns(20);
        Lista_Pasajeros_Estaciones.setForeground(new java.awt.Color(0, 0, 0));
        Lista_Pasajeros_Estaciones.setRows(5);
        Lista_Pasajeros_Estaciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Lista_Pasajeros_Estaciones.setFocusable(false);
        jScrollPane1.setViewportView(Lista_Pasajeros_Estaciones);

        Agregar_Pasajero.setBackground(new java.awt.Color(204, 255, 153));
        Agregar_Pasajero.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Agregar un Pasajero", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        javax.swing.GroupLayout Agregar_PasajeroLayout = new javax.swing.GroupLayout(Agregar_Pasajero);
        Agregar_Pasajero.setLayout(Agregar_PasajeroLayout);
        Agregar_PasajeroLayout.setHorizontalGroup(
            Agregar_PasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Agregar_PasajeroLayout.setVerticalGroup(
            Agregar_PasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Pagos_info.setEditable(false);
        Pagos_info.setBackground(new java.awt.Color(255, 255, 255));
        Pagos_info.setColumns(20);
        Pagos_info.setForeground(new java.awt.Color(0, 0, 0));
        Pagos_info.setRows(5);
        Pagos_info.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane4.setViewportView(Pagos_info);

        jLabel2.setBackground(new java.awt.Color(204, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Colas de Pasajeros por Estación");

        jLabel3.setBackground(new java.awt.Color(204, 0, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cola Espera");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Viajes Completados");

        empresa_name.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        empresa_name.setText("Empresa Name");

        Precioxkm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Precioxkm.setForeground(new java.awt.Color(204, 0, 51));
        Precioxkm.setText("\"Costo KM:₡\" + costo_por_kilometro");

        C1TextArea.setEditable(false);
        C1TextArea.setBackground(new java.awt.Color(255, 255, 255));
        C1TextArea.setColumns(20);
        C1TextArea.setForeground(new java.awt.Color(0, 0, 0));
        C1TextArea.setRows(5);
        C1TextArea.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane2.setViewportView(C1TextArea);

        Status_Vagon.setBackground(new java.awt.Color(204, 255, 153));
        Status_Vagon.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Estado del vagon incial", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        javax.swing.GroupLayout Status_VagonLayout = new javax.swing.GroupLayout(Status_Vagon);
        Status_Vagon.setLayout(Status_VagonLayout);
        Status_VagonLayout.setHorizontalGroup(
            Status_VagonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Status_VagonLayout.setVerticalGroup(
            Status_VagonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(header, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(Agregar_Pasajero, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(empresa_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(Precioxkm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(Status_Vagon, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(empresa_name)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Precioxkm))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(Agregar_Pasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(314, 314, 314)
                                .addComponent(jLabel2))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(Status_Vagon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(413, 413, 413)
                                .addComponent(jLabel3))))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(empresa_name))
                .addGap(3, 3, 3)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(Agregar_Pasajero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Status_Vagon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Precioxkm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Tren en Curso", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18), new java.awt.Color(0, 153, 153))); // NOI18N

        Detener_tren.setBackground(new java.awt.Color(255, 153, 153));
        Detener_tren.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Detener_tren.setForeground(new java.awt.Color(0, 0, 0));
        Detener_tren.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Stop.png"))); // NOI18N
        Detener_tren.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Detener Tren", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        Detener_tren.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Detener_tren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Detener_trenActionPerformed(evt);
            }
        });

        Iniciar_tren.setBackground(new java.awt.Color(153, 255, 153));
        Iniciar_tren.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Iniciar_tren.setForeground(new java.awt.Color(0, 0, 0));
        Iniciar_tren.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png"))); // NOI18N
        Iniciar_tren.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Iniciar Tren", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        Iniciar_tren.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Iniciar_tren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Iniciar_trenActionPerformed(evt);
            }
        });

        Estado_tren.setEditable(false);
        Estado_tren.setBackground(new java.awt.Color(204, 255, 204));
        Estado_tren.setColumns(20);
        Estado_tren.setRows(5);
        jScrollPane3.setViewportView(Estado_tren);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Iniciar_tren, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(245, 245, 245)
                        .addComponent(Detener_tren, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Iniciar_tren, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Detener_tren, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
       Popups.despedida();
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed

        About acerca_de = new About(new javax.swing.JFrame(), true);
        acerca_de.setVisible(true);
    }//GEN-LAST:event_aboutActionPerformed

    private void Cargar_PasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cargar_PasajerosActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo CSV");
        int seleccion = fileChooser.showOpenDialog(this);

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
                    //Pasajero.Estado estado = Pasajero.Estado.valueOf(datos[5].trim());
                    Pasajero pasajero = new Pasajero(nombre, edad, estacionOrigen, estacionDestino, discapacidad);
                    //pasajero.setEstado(estado);        
                    cola.encolar(pasajero, discapacidad == Pasajero.Discapacidad.SI, estacionOrigen);
                    tren.agregarPasajeroEstacion(pasajero, estacionOrigen);

                }
                String mensaje = "Cargando Pasajeros....";
                Popups Config = new Popups();
                Config.espera(mensaje);
                // Establecer el texto del JTextArea
                String contenidoCola = cola.imprimirCola();
                Lista_Pasajeros_Estaciones.setText(contenidoCola);
                Lista_Pasajeros_Estaciones.setCaretPosition(0);

            } catch (IOException e) {
                e.printStackTrace();
                // Manejar la excepción
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Manejar la excepción de conversión de número
            }
        }
    }//GEN-LAST:event_Cargar_PasajerosActionPerformed

    private void Agregar_PasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_PasajerosActionPerformed
        Agregar_Pasajero.setVisible(true);

    }//GEN-LAST:event_Agregar_PasajerosActionPerformed

    private void Ver_ListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ver_ListaActionPerformed
        if (cola.esVacia()) {
            Lista_Pasajeros_Estaciones.setText("Aun no hay pasajeros esperando el tren");
        } else {
            String contenidoCola = cola.imprimirCola();
            Lista_Pasajeros_Estaciones.setText(contenidoCola);
            Lista_Pasajeros_Estaciones.setCaretPosition(0);

        }
    }//GEN-LAST:event_Ver_ListaActionPerformed

    private void Iniciar_trenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Iniciar_trenActionPerformed
        tren.start();

//        // Esperar un tiempo suficiente para que el tren se mueva y atienda pasajeros
//        try {
//            Thread.sleep(5000); // Esperar 30 segundos (tiempo suficiente para el movimiento del tren)
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }//GEN-LAST:event_Iniciar_trenActionPerformed

    private void Detener_trenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Detener_trenActionPerformed
        Estado_tren.append("\nSe detuvo el tren");
        tren.detenerTren();
    }//GEN-LAST:event_Detener_trenActionPerformed

    private void Ver_estado_vagonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ver_estado_vagonesActionPerformed
           
    }//GEN-LAST:event_Ver_estado_vagonesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Agregar_Pasajero;
    private javax.swing.JButton Agregar_Pasajeros;
    private javax.swing.JLabel Asientos_NoDis1;
    private javax.swing.JLabel Asientos_NoDis2;
    private javax.swing.JLabel Asientos_dis;
    public static javax.swing.JTextArea C1TextArea;
    private javax.swing.JButton Cargar_Pasajeros;
    private javax.swing.JButton Detener_tren;
    public static javax.swing.JTextArea Estado_tren;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Iniciar_tren;
    private javax.swing.JTextArea Lista_Pasajeros_Estaciones;
    public static javax.swing.JTextArea Pagos_info;
    private javax.swing.JLabel Precioxkm;
    private javax.swing.JPanel Status_Vagon;
    private javax.swing.JButton Ver_Lista;
    private javax.swing.JButton Ver_estado_vagones;
    private javax.swing.JButton about;
    private javax.swing.JLabel empresa_name;
    private javax.swing.JPanel header;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel tiempo_tren;
    // End of variables declaration//GEN-END:variables
}
