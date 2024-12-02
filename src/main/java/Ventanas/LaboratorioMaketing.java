/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;



import Ventanas.personalizados.ThemedFrame;
import cvx.Aplication.Services.EquipoService;
import cvx.Aplication.Services.ReservaService;
import cvx.Aplication.Services.UsuarioService;
import cvx.Domain.Equipo;
import cvx.Domain.Reserva;
import cvx.Domain.Usuario;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import scrollbar.ScrollBarCustom;
import Ventanas.personalizados.TableRender;
import Ventanas.personalizados.ThemeManager;
import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.intellijthemes.FlatAllIJThemes;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;



import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;





public class LaboratorioMaketing extends javax.swing.JFrame implements ThemedFrame {
    
    
    private final EquipoService equipoService;
    private final UsuarioService usuarioService;
    private final ReservaService reservaService;
    private Usuario usuario;
     private Timer animationTimer;
    private int patternOffset = 0;
      private float alpha = 0.0f; // Transparencia inicial
    private boolean fadeIn = true; // Control de dirección de desvanecimiento

    
    TableRender claseRender = new TableRender();
    JCheckBox check = new JCheckBox();
    
      
    
   
    
    
      String columnas[] = {"ID", "Fecha de inicio", "Fecha de finalizacion", "Equipo reservado","Ubicacion", "Reservante"};
    Boolean columnasSeleccionables[] = {false, false, false, false, false,false};

    Class[] types = new Class[]{
        java.lang.Object.class,
        java.lang.Object.class,
        java.lang.Object.class,
        java.lang.Object.class,
        java.lang.Object.class,
        java.lang.Object.class,
        java.lang.Object.class,
        java.lang.Boolean.class
    };

    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {

            return false;

        }
    };

    public Class getColumnClass(int index) {
        return types[index];
    }

  
    public LaboratorioMaketing(UsuarioService usuarioService,EquipoService equipoService,ReservaService reservaService,Usuario usuarioActual) {
            this.equipoService = equipoService;
        this.usuarioService = usuarioService;
        this.reservaService = reservaService;
        this.usuario = usuarioActual;

        ThemeManager.getInstance().registerFrame(this);  // Registrar el frame
        initComponents();
        applyTheme();

        // Configurar el fondo del jPanel1
        jPanel1 = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
                drawPattern(g2d);
                g2d.dispose();
            }
        };
      
       
     

        // Iniciar la animación
        startAnimation();

        
        modelo.setColumnIdentifiers(columnas);

        jTable1.setModel(modelo);
        
        createThemeButton();
        
        
        setTitle("Apartado de marketing");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
       
        button2.setText("Mi perfil");
        
       
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        
      
        
        
        
        
         reservaService.listaReservas().forEach((Reserva reserva) -> modelo.addRow(new Object[]{ 
            reserva.getId(), // Columna ID
            reserva.getFechaInicio(),
            reserva.getFechaFin(),
            reserva.getEquipo().getNombre(),
            reserva.getEquipo().getUbicacion(),
            reserva.getUsuario().getNombre()
          
            
           
 
        }));

        jTable1.setDefaultRenderer(jTable1.getColumnClass(0), claseRender);
      
     
        
        
    }
    
        private void drawPattern(Graphics g) {
        int width = jPanel1.getWidth();
        int height = jPanel1.getHeight();
        g.setColor(new Color(200, 200, 200)); // Color de las líneas

        for (int i = 0; i < width + height; i += 20) {
            g.drawLine(i, 0, 0, i); // Líneas diagonales
        }
    }

    private void startAnimation() {
        animationTimer = new Timer(50, e -> {
            if (fadeIn) {
                alpha += 0.01f;
                if (alpha >= 1.0f) {
                    alpha = 1.0f;
                    fadeIn = false;
                }
            } else {
                alpha -= 0.01f;
                if (alpha <= 0.0f) {
                    alpha = 0.0f;
                    fadeIn = true;
                }
            }
            jPanel1.repaint();
        });
        animationTimer.start();
    }

    @Override
    public void dispose() {
        if (animationTimer != null) {
            animationTimer.stop();
        }
        super.dispose();
    }

    // ... código existente ...

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        button2 = new Ventanas.personalizados.Button();
        button3 = new Ventanas.personalizados.Button();
        button4 = new Ventanas.personalizados.Button();
        button5 = new Ventanas.personalizados.Button();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listaSalas = new Ventanas.personalizados.Combobox();
        listaFechasEquipos = new Ventanas.personalizados.Combobox();
        listaEquipos = new Ventanas.personalizados.Combobox();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new Ventanas.personalizados.Button();
        button1 = new Ventanas.personalizados.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        listaFechas = new Ventanas.personalizados.Combobox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel2.setText("Fechas para salas disponibles");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel3.setText("Fechas para equipos disponibles");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 270, 230, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel4.setText("Salas disponibles");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user (3).png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 5, 40, 50));

        button2.setForeground(new java.awt.Color(0, 0, 0));
        button2.setText("Mi perfil");
        button2.setFocusPainted(false);
        button2.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 10, 110, -1));

        button3.setForeground(new java.awt.Color(0, 0, 0));
        button3.setText("Regresar a pantalla de eleccion");
        button3.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        jPanel1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 49));

        button4.setForeground(new java.awt.Color(0, 0, 0));
        button4.setText("Laboratorio de ingenierias");
        button4.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        jPanel1.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 270, 49));

        button5.setForeground(new java.awt.Color(0, 0, 0));
        button5.setText("Laboratorio de marketing");
        button5.setFocusable(false);
        button5.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        jPanel1.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 270, 49));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrast.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 16, 30, 30));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/SalaMarketing (1).jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 680, 460));

        listaSalas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        listaSalas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sala principal", "Sala N", "Sala S", "Sala E" }));
        listaSalas.setSelectedIndex(-1);
        listaSalas.setFocusable(false);
        listaSalas.setLabeText("");
        listaSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaSalasActionPerformed(evt);
            }
        });
        jPanel1.add(listaSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, 220, 40));

        listaFechasEquipos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        listaFechasEquipos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inicio: 2024/05/11 fin: 2024/05/15", "Inicio: 2024/07/05 fin: 2024/07/10", "Inicio: 2024/07/20 fin: 2024/07/25", "Inicio: 2024/10/05 fin: 2024/10/05" }));
        listaFechasEquipos.setSelectedIndex(-1);
        listaFechasEquipos.setFocusable(false);
        listaFechasEquipos.setLabeText("");
        listaFechasEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaFechasEquiposActionPerformed(evt);
            }
        });
        jPanel1.add(listaFechasEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 300, 260, 40));

        listaEquipos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        listaEquipos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Portatil Lenovo", "iPad pro", "Camara Samsung", "Microfono USB", "Sillas de oficina" }));
        listaEquipos.setSelectedIndex(-1);
        listaEquipos.setFocusable(false);
        listaEquipos.setLabeText("");
        listaEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaEquiposActionPerformed(evt);
            }
        });
        jPanel1.add(listaEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 300, 220, 40));

        jLabel6.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel6.setText("Equipos disponibles");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, 160, -1));

        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Reservar sala");
        jButton1.setFocusable(false);
        jButton1.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 180, 220, 40));

        button1.setForeground(new java.awt.Color(0, 0, 0));
        button1.setText("Reservar equipo");
        button1.setFocusable(false);
        button1.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 300, 220, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha de inicio", "Fecha de finalizacion", "Equipo reservado", "Ubicacion", "Reservante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 410, 750, 230));

        jLabel7.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel7.setText("Registro de reservas generales");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 380, 220, -1));

        listaFechas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inicio: 2024/11/16 fin: 2024/11/19", "Inicio: 2024/12/01 fin: 2024/12/05", "Inicio: 2024/02/20 fin: 2024/02/23", "Inicio: 2024/04/10 fin: 2024/04/13" }));
        listaFechas.setSelectedIndex(-1);
        listaFechas.setFocusable(false);
        listaFechas.setLabeText("");
        jPanel1.add(listaFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 180, 260, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
 
    private void listaSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaSalasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaSalasActionPerformed

    private void listaFechasEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaFechasEquiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaFechasEquiposActionPerformed

    private void listaEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaEquiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaEquiposActionPerformed

    
    
       // En ReservaService.java
public List<Reserva> obtenerReservasPorUsuario(Usuario usuario) {
    List<Reserva> reservasUsuario = new ArrayList<>();
    for (Reserva reserva : reservaService.listaReservas()) {
        if (reserva.getUsuario().equals(usuario)) {
            reservasUsuario.add(reserva);
        }
    }
    return reservasUsuario;
}
  

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            String fecha = listaFechas.getSelectedItem().toString();
            String[] partes = fecha.split(" ");
            String Inicio = partes[1];
            String Fin = partes[3];

    try {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaInicio = formato.parse(Inicio);
        Date fechaFin = formato.parse(Fin);

        String ubicacion = listaSalas.getSelectedItem().toString();

        List<Equipo> equipos = equipoService.listaEquipos();
        List<Reserva> reservasUsuario = obtenerReservasPorUsuario(usuario);

        if (reservasUsuario.size() >= 10) {
            throw new Exception("No puedes tener más de 3 equipos de la sala de marketing reservados al mismo tiempo.");
        }

        boolean equipoEncontrado = false;
        Equipo equipoSeleccionado = null;

        for (Equipo equipo : equipos) {
            if (ubicacion.equals(equipo.getNombre())) {
                equipoEncontrado = true;
                equipoSeleccionado = equipo;
                break;
            }
        }

        if (equipoEncontrado) {
            for (Reserva reserva : reservaService.listaReservas()) {
                if (reserva.getEquipo().equals(equipoSeleccionado) &&
                    !(reserva.getFechaFin().before(fechaInicio) || reserva.getFechaInicio().after(fechaFin))) {
                    throw new Exception("El equipo ya está reservado en este horario.");
                }
            }

            Reserva reserva = new Reserva(fechaInicio, fechaFin, usuario, equipoSeleccionado);
            reservaService.registrarReserva(reserva);

            // Verificar si todas las fechas están ocupadas
            boolean todasFechasOcupadas = true;
            for (int i = 0; i < listaFechas.getModel().getSize(); i++) {
                String fechaDisponible = listaFechas.getModel().getElementAt(i).toString();
                String[] partesFecha = fechaDisponible.split(" ");
                Date inicioDisponible = formato.parse(partesFecha[1]);
                Date finDisponible = formato.parse(partesFecha[3]);

                boolean fechaOcupada = false;
                for (Reserva r : reservaService.listaReservas()) {
                    if (r.getEquipo().equals(equipoSeleccionado) &&
                        !(r.getFechaFin().before(inicioDisponible) || r.getFechaInicio().after(finDisponible))) {
                        fechaOcupada = true;
                        break;
                    }
                }

                if (!fechaOcupada) {
                    todasFechasOcupadas = false;
                    break;
                }
            }

            if (todasFechasOcupadas) {
                equipoSeleccionado.setEstado("Ocupado");
            } else {
                equipoSeleccionado.setEstado("Libre");
            }

            equipoService.actualizarEquipo(equipoSeleccionado);

            modelo.addRow(new Object[]{
                reserva.getId(),
                Inicio,
                Fin,
                reserva.getEquipo().getNombre(),
                reserva.getEquipo().getUbicacion(),
                reserva.getUsuario().getNombre()
            });
            
            
            
            

            JOptionPane.showMessageDialog(this,
                "<html><b style =\"color : green; font-size:10px;\">Reserva registrada correctamente</b></html>",
                "Proceso realizado con éxito", JOptionPane.PLAIN_MESSAGE, getIcon("/Imagenes/check.png", 60, 60));
        } else {
            JOptionPane.showMessageDialog(null, "El equipo se encuentra ocupado en este momento");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed
    
 
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        String fecha = listaFechasEquipos.getSelectedItem().toString();
    String[] partes = fecha.split(" ");
    String Inicio = partes[1];
    String Fin = partes[3];

    try {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaInicio = formato.parse(Inicio);
        Date fechaFin = formato.parse(Fin);

        String ubicacion = listaEquipos.getSelectedItem().toString();

        List<Equipo> equipos = equipoService.listaEquipos();
        List<Reserva> reservasUsuario = obtenerReservasPorUsuario(usuario);

        if (reservasUsuario.size() >= 10) {
            throw new Exception("No puedes tener más de 3 equipos de la sala de marketing reservados al mismo tiempo.");
        }

        boolean equipoEncontrado = false;
        Equipo equipoSeleccionado = null;

        for (Equipo equipo : equipos) {
            if (ubicacion.equals(equipo.getNombre())) {
                equipoEncontrado = true;
                equipoSeleccionado = equipo;
                break;
            }
        }

        if (equipoEncontrado) {
            for (Reserva reserva : reservaService.listaReservas()) {
                if (reserva.getEquipo().equals(equipoSeleccionado) &&
                    !(reserva.getFechaFin().before(fechaInicio) || reserva.getFechaInicio().after(fechaFin))) {
                    throw new Exception("El equipo ya está reservado en este horario.");
                }
            }

            Reserva reserva = new Reserva(fechaInicio, fechaFin, usuario, equipoSeleccionado);
            reservaService.registrarReserva(reserva);

            // Verificar si todas las fechas están ocupadas
            boolean todasFechasOcupadas = true;
            for (int i = 0; i < listaFechasEquipos.getModel().getSize(); i++) {
                String fechaDisponible = listaFechasEquipos.getModel().getElementAt(i).toString();
                String[] partesFecha = fechaDisponible.split(" ");
                Date inicioDisponible = formato.parse(partesFecha[1]);
                Date finDisponible = formato.parse(partesFecha[3]);

                boolean fechaOcupada = false;
                for (Reserva r : reservaService.listaReservas()) {
                    if (r.getEquipo().equals(equipoSeleccionado) &&
                        !(r.getFechaFin().before(inicioDisponible) || r.getFechaInicio().after(finDisponible))) {
                        fechaOcupada = true;
                        break;
                    }
                }

                if (!fechaOcupada) {
                    todasFechasOcupadas = false;
                    break;
                }
            }

            if (todasFechasOcupadas) {
                equipoSeleccionado.setEstado("Ocupado");
            } else {
                equipoSeleccionado.setEstado("Libre");
            }

            equipoService.actualizarEquipo(equipoSeleccionado);

            modelo.addRow(new Object[]{
                reserva.getId(),
                Inicio,
                Fin,
                reserva.getEquipo().getNombre(),
                reserva.getEquipo().getUbicacion(),
                reserva.getUsuario().getNombre()
            });

            JOptionPane.showMessageDialog(this,
                "<html><b style =\"color : green; font-size:10px;\">Reserva registrada correctamente</b></html>",
                "Proceso realizado con éxito", JOptionPane.PLAIN_MESSAGE, getIcon("/Imagenes/check.png", 60, 60));
        } else {
            JOptionPane.showMessageDialog(null, "El equipo se encuentra ocupado en este momento");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_button1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        if(this.isVisible()){
            return;
        }
    }//GEN-LAST:event_button5ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        LaboratorioIngenieria laboratorioIngenieria = new LaboratorioIngenieria(usuarioService, equipoService, reservaService, usuario);

        laboratorioIngenieria.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_button4ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        ventanaIngreso b = new ventanaIngreso(usuarioService, equipoService, reservaService,usuario);

        b.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_button3ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        MiPerfil perfil = new MiPerfil(usuarioService, equipoService, reservaService, usuario);
        perfil.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_button2ActionPerformed
    
    
    private Icon getIcon(String paht, int w, int h) {

        return new ImageIcon(new ImageIcon(getClass().getResource(paht)).getImage().getScaledInstance(w, h, 0));

    }
    
    private void createThemeButton() {
      
        jButton2.addActionListener(e -> {
            if (FlatLaf.isLafDark()) {
                EventQueue.invokeLater(() -> {
                    FlatAnimatedLafChange.showSnapshot();
                    FlatMacLightLaf.setup();
                    FlatLaf.updateUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                    
                    button1.setForeground(Color.black);
                    button2.setForeground(Color.black);
                    button4.setForeground(Color.black);
                    button5.setForeground(Color.black);
                    button3.setForeground(Color.black);
                    jButton1.setForeground(Color.black);
                    
                    
                    button2.setBackground(Color.white);
                    button4.setBackground(Color.white);
                    button5.setBackground(Color.white);
                    button3.setBackground(Color.white);
                    button1.setBackground(Color.white);
                    jButton1.setBackground(Color.white);
                    
                    
                    
                    jLabel2.setForeground(Color.black);
                    jLabel4.setForeground(Color.black);
                    jLabel6.setForeground(Color.black);
                    jLabel3.setForeground(Color.black);
                    jLabel7.setForeground(Color.black);
                    
                   
                    listaSalas.setForeground(Color.black);
                    listaFechas.setForeground(Color.black);
                    listaFechasEquipos.setForeground(Color.black);
                    listaEquipos.setForeground(Color.black);
                    listaSalas.setForeground(Color.black);
                    
                    
                    
                    
                    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrast.png"))); 
                    
                     
                       
                });
            } else {
                EventQueue.invokeLater(() -> {
                    //Cuando pasa a negro
                    
                    FlatAnimatedLafChange.showSnapshot();
                    FlatMacDarkLaf.setup();
                    FlatLaf.updateUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                    
                    button1.setForeground(Color.white);
                    button2.setForeground(Color.white);
                    button4.setForeground(Color.white);
                    button5.setForeground(Color.white);
                    button3.setForeground(Color.white);
                    jButton1.setForeground(Color.white);
                    
                    
                    button2.setBackground(Color.black);
                    button4.setBackground(Color.black);
                    button5.setBackground(Color.black);
                    button3.setBackground(Color.black);
                    button1.setBackground(Color.black);
                    jButton1.setBackground(Color.black);
                    
                    
                   
                    
                   
                    
                    jLabel2.setForeground(Color.white);
                    jLabel4.setForeground(Color.white);
                    jLabel6.setForeground(Color.white);
                    jLabel3.setForeground(Color.white);
                    jLabel7.setForeground(Color.white);
                    
                    listaSalas.setForeground(Color.black);
                    listaFechas.setForeground(Color.black);
                    listaFechasEquipos.setForeground(Color.black);
                    listaEquipos.setForeground(Color.black);
                    listaSalas.setForeground(Color.black);
                    
                 
                    
                    jTable1.setForeground(Color.black);
                    
                    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/full-moon (1).png"))); 
                   
                    
                    
                });
            }
        });
       
    }
    
     public static ImageIcon redimensionarImagen(ImageIcon originalIcon, int ancho, int alto) {
        Image imagenOriginal = originalIcon.getImage();
        BufferedImage imagenRedimensionada = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = imagenRedimensionada.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(imagenOriginal, 0, 0, ancho, alto, null);
        g2d.dispose();

        return new ImageIcon(imagenRedimensionada);
    }
    
    
   
    private javax.swing.JList<String> jList1;
    private scrollbar.ScrollBarCustom scrollBarCustom1;
    private scrollbar.ScrollBarCustom sp;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Ventanas.personalizados.Button button1;
    private Ventanas.personalizados.Button button2;
    private Ventanas.personalizados.Button button3;
    private Ventanas.personalizados.Button button4;
    private Ventanas.personalizados.Button button5;
    private Ventanas.personalizados.Button jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private Ventanas.personalizados.Combobox listaEquipos;
    private Ventanas.personalizados.Combobox listaFechas;
    private Ventanas.personalizados.Combobox listaFechasEquipos;
    private Ventanas.personalizados.Combobox listaSalas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void applyTheme() {
        if (FlatLaf.isLafDark()) {
                    FlatAnimatedLafChange.showSnapshot();
                    FlatMacDarkLaf.setup();
                    FlatLaf.updateUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                    
                    button1.setForeground(Color.white);
                    button2.setForeground(Color.white);
                    button4.setForeground(Color.white);
                    button5.setForeground(Color.white);
                    button3.setForeground(Color.white);
                    jButton1.setForeground(Color.white);
                    
                    
                    button2.setBackground(Color.black);
                    button4.setBackground(Color.black);
                    button5.setBackground(Color.black);
                    button3.setBackground(Color.black);
                    button1.setBackground(Color.black);
                    jButton1.setBackground(Color.black);
                    
                   
                    
                    jLabel2.setForeground(Color.white);
                    jLabel4.setForeground(Color.white);
                    jLabel6.setForeground(Color.white);
                    jLabel3.setForeground(Color.white);
                    jLabel7.setForeground(Color.white);
                    
                    listaSalas.setForeground(Color.black);
                    listaFechas.setForeground(Color.black);
                    listaFechasEquipos.setForeground(Color.black);
                    listaEquipos.setForeground(Color.black);
                    listaSalas.setForeground(Color.black);
                    
                 
                    
                    jTable1.setForeground(Color.black);
                    
                    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/full-moon (1).png"))); 

            FlatMacDarkLaf.setup();
            FlatLaf.updateUI();
        } else {
            FlatAnimatedLafChange.showSnapshot();
                    FlatMacLightLaf.setup();
                    FlatLaf.updateUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                    
                    button1.setForeground(Color.black);
                    button2.setForeground(Color.black);
                    button4.setForeground(Color.black);
                    button5.setForeground(Color.black);
                    button3.setForeground(Color.black);
                    jButton1.setForeground(Color.black);
                    
                    
                    button2.setBackground(Color.white);
                    button4.setBackground(Color.white);
                    button5.setBackground(Color.white);
                    button3.setBackground(Color.white);
                    button1.setBackground(Color.white);
                    jButton1.setBackground(Color.white);
                    
                    
                    
                    
                    jLabel2.setForeground(Color.black);
                    jLabel4.setForeground(Color.black);
                    jLabel6.setForeground(Color.black);
                    jLabel3.setForeground(Color.black);
                    jLabel7.setForeground(Color.black);
                    
                   
                    listaSalas.setForeground(Color.black);
                    listaFechas.setForeground(Color.black);
                    listaFechasEquipos.setForeground(Color.black);
                    listaEquipos.setForeground(Color.black);
                    listaSalas.setForeground(Color.black);
                    
                    
                    
                    
                    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrast.png"))); 
        }
    }
    

   
}
