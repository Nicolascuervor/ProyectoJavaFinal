/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Ventanas.personalizados.TableRender;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import cvx.Aplication.Services.EquipoService;
import cvx.Aplication.Services.ReservaService;
import cvx.Aplication.Services.UsuarioService;
import cvx.Domain.Equipo;
import cvx.Domain.Reserva;
import cvx.Domain.Usuario;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class LaboratorioIngenieria extends javax.swing.JFrame {
      private final EquipoService equipoService;
      private final UsuarioService usuarioService;
      private final ReservaService reservaService;
      private Usuario usuario;
    
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

   
    public LaboratorioIngenieria(UsuarioService usuarioService,EquipoService equipoService,ReservaService reservaService,Usuario usuarioActual) {
        this.equipoService = equipoService;
        this.usuarioService = usuarioService;
        this.reservaService = reservaService;
        this.usuario = usuarioActual;
        
        
        
        initComponents();
        
        
        
        setTitle("Apartado de ingenierias");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
       
        modelo.setColumnIdentifiers(columnas);
        jTable2.setModel(modelo);
        
        
        createThemeButton();
        applyTheme();
        
        
        
        
         reservaService.listaReservas().forEach((Reserva reserva) -> modelo.addRow(new Object[]{ 
            reserva.getId(), // Columna ID
            reserva.getFechaInicio(),
            reserva.getFechaFin(),
            reserva.getEquipo().getNombre(),
            reserva.getEquipo().getUbicacion(),
            reserva.getUsuario().getNombre()

        }));

        jTable2.setDefaultRenderer(jTable2.getColumnClass(0), claseRender);
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button1 = new Ventanas.personalizados.Button();
        button2 = new Ventanas.personalizados.Button();
        button3 = new Ventanas.personalizados.Button();
        button4 = new Ventanas.personalizados.Button();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        button5 = new Ventanas.personalizados.Button();
        button6 = new Ventanas.personalizados.Button();
        listaEquipos = new Ventanas.personalizados.Combobox();
        listaSalas = new Ventanas.personalizados.Combobox();
        listaFechasEquipos = new Ventanas.personalizados.Combobox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        listaFechas = new Ventanas.personalizados.Combobox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button1.setForeground(new java.awt.Color(0, 0, 0));
        button1.setText("Regresar a pantalla de eleccion");
        button1.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 49));

        button2.setForeground(new java.awt.Color(0, 0, 0));
        button2.setText("Laboratorio de ingenierias");
        button2.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jPanel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 270, 49));

        button3.setForeground(new java.awt.Color(0, 0, 0));
        button3.setText("Laboratorio de marketing");
        button3.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        jPanel1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 270, 49));

        button4.setForeground(new java.awt.Color(0, 0, 0));
        button4.setText("Mi perfil");
        button4.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        jPanel1.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 10, 110, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user (3).png"))); // NOI18N
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 5, 40, 50));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LaboratorioING2 (1) (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(31, 31, 31))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 770, 520));

        button5.setForeground(new java.awt.Color(0, 0, 0));
        button5.setText("Reservar sala");
        button5.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        jPanel1.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 160, 180, 40));

        button6.setForeground(new java.awt.Color(0, 0, 0));
        button6.setText("Reservar equipo");
        button6.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        jPanel1.add(button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 270, 180, -1));

        listaEquipos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Arduino", "Computador", "Implementos de construccion", "Impresora 3D", "Tablero inteligente" }));
        listaEquipos.setSelectedIndex(-1);
        listaEquipos.setFocusable(false);
        listaEquipos.setLabeText("");
        jPanel1.add(listaEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 220, 40));

        listaSalas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cuarto de electricidad", "Cuarto de practicas", "Cuarto de computadores", "Cuarto de conferencias", "Cuarto de maquetacion" }));
        listaSalas.setSelectedIndex(-1);
        listaSalas.setFocusable(false);
        listaSalas.setLabeText("");
        jPanel1.add(listaSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, 220, 40));

        listaFechasEquipos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inicio: 2024/01/25 Fin: 2024/01/28", "Inicio: 2024/03/12 Fin: 2024/03/16", "Inicio: 2024/05/18 Fin 2024/05/22" }));
        listaFechasEquipos.setSelectedIndex(-1);
        listaFechasEquipos.setFocusable(false);
        listaFechasEquipos.setLabeText("");
        jPanel1.add(listaFechasEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 270, 260, 40));

        jLabel4.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel4.setText("Fechas para equipos disponibles");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel5.setText("Salas disponibles");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 130, -1));

        jLabel6.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel6.setText("Fechas para salas disponibles");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel7.setText("Registro de reservas generales");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 360, -1, -1));

        jLabel8.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel8.setText("Equipos disponibles");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 240, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 390, 750, 230));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrast.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 16, 30, 30));

        listaFechas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inicio: 2024/11/11 fin: 2024/11/14", "Inicio: 2024/10/18 Fin: 2024/10/21", "Inicio: 2024/05/23 Fin: 2024/05/26", "Inicio: 2024/02/10 Fin: 2024/02/13" }));
        listaFechas.setSelectedIndex(-1);
        listaFechas.setLabeText("");
        jPanel1.add(listaFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 160, 260, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
          ventanaIngreso b = new ventanaIngreso(usuarioService, equipoService, reservaService,usuario);

        b.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_button1ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        LaboratorioMaketing marketing = new LaboratorioMaketing(usuarioService, equipoService, reservaService, usuario);
        
        marketing.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_button3ActionPerformed

    
    
    
    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
         MiPerfil perfil = new MiPerfil(usuarioService, equipoService, reservaService, usuario);
        perfil.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_button4ActionPerformed

    
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
  
    
    
    
    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
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
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
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
    }//GEN-LAST:event_button6ActionPerformed

    private Icon getIcon(String paht, int w, int h) { return new ImageIcon(new ImageIcon(getClass().getResource(paht)).getImage().getScaledInstance(w, h, 0));}
    
    
    
     private void createThemeButton() {
      
        jButton1.addActionListener(e -> {
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
                    button6.setForeground(Color.black);
                    jButton1.setForeground(Color.black);
                    
                    
                    button2.setBackground(Color.white);
                    button4.setBackground(Color.white);
                    button5.setBackground(Color.white);
                    button3.setBackground(Color.white);
                    button1.setBackground(Color.white);   
                    button6.setBackground(Color.white);
         
                    jButton1.setBackground(Color.white);
                    
                    
                    
                   
                    jLabel5.setForeground(Color.black);
                    jLabel6.setForeground(Color.black);
                    jLabel8.setForeground(Color.black);
                    jLabel4.setForeground(Color.black);
                    
                   
                    listaSalas.setForeground(Color.black);
                    listaFechas.setForeground(Color.black);
                    listaFechasEquipos.setForeground(Color.black);
                    listaEquipos.setForeground(Color.black);
                    listaSalas.setForeground(Color.black);
                    
                    
                    
                    
                    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrast.png"))); 
                    
                     
                       
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
                    button6.setForeground(Color.white);
                    jButton1.setForeground(Color.white);
                    
                    
                    button2.setBackground(Color.black);
                    button4.setBackground(Color.black);
                    button5.setBackground(Color.black);
                    button3.setBackground(Color.black);
                    button1.setBackground(Color.black);
                    button6.setBackground(Color.black);
                    jButton1.setBackground(Color.black);
                    
                    
                   
                    
                   
                    
                  
                    jLabel5.setForeground(Color.white);
                    jLabel6.setForeground(Color.white);
                    jLabel8.setForeground(Color.white);
                    jLabel4.setForeground(Color.white);
                    
                    listaSalas.setForeground(Color.black);
                    listaFechas.setForeground(Color.black);
                    listaFechasEquipos.setForeground(Color.black);
                    listaEquipos.setForeground(Color.black);
                    listaSalas.setForeground(Color.black);
                    
                 
                    
                    jTable2.setForeground(Color.black);
                    
                    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/full-moon (1).png"))); 
                   
                    
                    
                });
            }
        });
       
    }
     
     
  
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
                    button6.setForeground(Color.white);
                    jButton1.setForeground(Color.white);
                    
                    
                    button2.setBackground(Color.black);
                    button4.setBackground(Color.black);
                    button5.setBackground(Color.black);
                    button3.setBackground(Color.black);
                    button1.setBackground(Color.black);
                    button6.setBackground(Color.black);
                    jButton1.setBackground(Color.black);
                    
                    
                   
                    
                   
                    
                  
                    jLabel5.setForeground(Color.white);
                    jLabel6.setForeground(Color.white);
                    jLabel8.setForeground(Color.white);
                    jLabel4.setForeground(Color.white);
                    
                    listaSalas.setForeground(Color.black);
                    listaFechas.setForeground(Color.black);
                    listaFechasEquipos.setForeground(Color.black);
                    listaEquipos.setForeground(Color.black);
                    listaSalas.setForeground(Color.black);
                    
                 
                    
                    jTable2.setForeground(Color.black);
                    
                    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/full-moon (1).png"))); 
                   

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
                    button6.setForeground(Color.black);
                    jButton1.setForeground(Color.black);
                    
                    
                    button2.setBackground(Color.white);
                    button4.setBackground(Color.white);
                    button5.setBackground(Color.white);
                    button3.setBackground(Color.white);
                    button1.setBackground(Color.white);   
                    button6.setBackground(Color.white);
         
                    jButton1.setBackground(Color.white);
                    
                    
                    
                   
                    jLabel5.setForeground(Color.black);
                    jLabel6.setForeground(Color.black);
                    jLabel8.setForeground(Color.black);
                    jLabel4.setForeground(Color.black);
                    
                   
                    listaSalas.setForeground(Color.black);
                    listaFechas.setForeground(Color.black);
                    listaFechasEquipos.setForeground(Color.black);
                    listaEquipos.setForeground(Color.black);
                    listaSalas.setForeground(Color.black);
                    
                    
                    
                    
                    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrast.png"))); 
        }
    }
    
     
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Ventanas.personalizados.Button button1;
    private Ventanas.personalizados.Button button2;
    private Ventanas.personalizados.Button button3;
    private Ventanas.personalizados.Button button4;
    private Ventanas.personalizados.Button button5;
    private Ventanas.personalizados.Button button6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private Ventanas.personalizados.Combobox listaEquipos;
    private Ventanas.personalizados.Combobox listaFechas;
    private Ventanas.personalizados.Combobox listaFechasEquipos;
    private Ventanas.personalizados.Combobox listaSalas;
    // End of variables declaration//GEN-END:variables
}
