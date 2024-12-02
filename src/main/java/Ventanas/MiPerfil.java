/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Ventanas.personalizados.ThemedFrame;
import Ventanas.personalizados.TableRender;
import Ventanas.personalizados.ThemeManager;
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
import java.awt.Color;
import java.awt.EventQueue;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Nicolas
 */
public class MiPerfil extends javax.swing.JFrame implements ThemedFrame{
     private final EquipoService equipoService;
    private final UsuarioService usuarioService;
    private final ReservaService reservaService;
    private Usuario usuario;
    private boolean areAllChecked = false;
    
    TableRender claseRender = new TableRender();
    JCheckBox check = new JCheckBox();
    
    
    
    
      String columnas[] = {"ID", "Fecha de inicio", "Fecha de finalizacion", "Equipo reservado", "Ubicacion","Seleccionar"};
    Boolean columnasSeleccionables[] = {false, false, false, false, false,true};

    Class[] types = new Class[]{
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

            return column == modelo.getColumnCount() - 1;

        }
    };

    public Class getColumnClass(int index) {
        return types[index];
    }
    

   
    public MiPerfil(UsuarioService usuarioService,EquipoService equipoService,ReservaService reservaService,Usuario usuarioActual) {
        this.equipoService = equipoService;
        this.usuarioService = usuarioService;
        this.reservaService = reservaService;
        this.usuario = usuarioActual;
        
        
        
        ThemeManager.getInstance().registerFrame(this);
        initComponents();
        applyTheme();
        
        setTitle("Eleccion");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        jTextField1.setText(usuarioActual.getNombre());
        
        modelo.setColumnIdentifiers(columnas);

        jTable1.setModel(modelo);
        
        createThemeButton();
        
        List<Reserva> reservas = reservaService.listaReservas();
        
        Stream<Reserva> reservaUsuario = reservas.stream();
        
         List<Reserva> reservan = reservaUsuario.filter(reserva -> reserva.getUsuario().getId() == usuarioActual.getId()).toList();
         
            TableRender claseRender = new TableRender();
            JCheckBox check = new JCheckBox();

            DefaultCellEditor defaultCellEditor = new DefaultCellEditor(check);
         
         
      
        
        
         reservan.forEach((Reserva reserva) -> modelo.addRow(new Object[]{
            reserva.getId(), // Columna ID
            reserva.getFechaInicio(),
            reserva.getFechaFin(),
            reserva.getEquipo().getNombre(),
            reserva.getEquipo().getUbicacion(),
            false
           
             
        }));

        jTable1.setDefaultRenderer(jTable1.getColumnClass(0), claseRender);
        jTable1.getColumnModel().getColumn(5).setCellEditor(defaultCellEditor);
        
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        button3 = new Ventanas.personalizados.Button();
        button1 = new Ventanas.personalizados.Button();
        button4 = new Ventanas.personalizados.Button();
        button2 = new Ventanas.personalizados.Button();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        button5 = new Ventanas.personalizados.Button();
        button6 = new Ventanas.personalizados.Button();
        button7 = new Ventanas.personalizados.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user (5).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, 157));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user (3).png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 5, 40, 50));

        button3.setForeground(new java.awt.Color(0, 0, 0));
        button3.setText("Mi perfil");
        button3.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        jPanel1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, 110, -1));

        button1.setForeground(new java.awt.Color(0, 0, 0));
        button1.setText("Regresar a pantalla de eleccion");
        button1.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 270, 49));

        button4.setForeground(new java.awt.Color(0, 0, 0));
        button4.setText("Laboratorio de ingenierias");
        button4.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        jPanel1.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 8, 270, 49));

        button2.setForeground(new java.awt.Color(0, 0, 0));
        button2.setText("Laboratorio de marketing");
        button2.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 8, 270, 49));

        jLabel4.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel4.setText("Mis datos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 130, 40));

        jLabel5.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        jLabel5.setText("Mis reservas ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 120, 220, 100));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha de inicio", "Fecha de finalizacion", "Equipo reservado", "Ubicacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 770, 340));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 190, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, 200, 30));

        jLabel7.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        jLabel7.setText("Nombre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, -1));

        jLabel8.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        jLabel8.setText("Contraseña");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, 110, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrast.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 10, 50, 40));

        button5.setForeground(new java.awt.Color(0, 0, 0));
        button5.setText("Actualizar perfil");
        button5.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        jPanel1.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, 240, 45));

        button6.setText("Cancelar reservas seleccionadas");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        jPanel1.add(button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 550, 210, -1));

        button7.setText("Seleccionar todas las casillas");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        jPanel1.add(button7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 540, 220, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
       
    }//GEN-LAST:event_button3ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
            ventanaIngreso ingreso = new ventanaIngreso(usuarioService, equipoService, reservaService, usuario);
            ingreso.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        LaboratorioMaketing marketing = new LaboratorioMaketing(usuarioService, equipoService, reservaService, usuario);
        applyTheme();
        marketing.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_button2ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        LaboratorioIngenieria ingenieria = new LaboratorioIngenieria(usuarioService, equipoService, reservaService, usuario);

        ingenieria.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_button4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
           
        usuario.setNombre(jTextField1.getText());
        usuarioService.actualizarUsuario(usuario);
        
         JOptionPane.showMessageDialog(this,
                    "<html><b style =\"color : green; font-size:10px;\">Perfil actualizado correctamente</b></html>",
                    "Proceso realizado con éxito", JOptionPane.PLAIN_MESSAGE, getIcon("/Imagenes/check.png", 60, 60));
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
       
          boolean foundSelected = false;

        // Recorremos las filas en orden inverso para evitar problemas al eliminar
        for (int i = jTable1.getRowCount() - 1; i >= 0; i--) {
            boolean isChecked = (Boolean) modelo.getValueAt(i, 5); // Columna del JCheckBox
            int idreserva = ((Long) modelo.getValueAt(i, 0)).intValue(); // ID del paciente en la columna 0
            
             Reserva reserva = reservaService.obtenerReserva(idreserva);
             Equipo equipo = equipoService.obtenerEquipo(reserva.getEquipo().getId());
             
            
            if (isChecked) {
                reservaService.eliminarReserva(idreserva); // Llamada para eliminar el paciente en la base de datos
              
                equipo.setEstado("Libre");
                
                equipoService.actualizarEquipo(equipo);
                
                modelo.removeRow(i); // Eliminamos la fila del modelo
                foundSelected = true;
            }
        }

        // Si no se seleccionó ninguna fila
        if (!foundSelected) {
            JOptionPane.showMessageDialog(this, "<html><b  style =\"color : red; font-size:10px; font:Times new Roman; \">No se han encontrado pacientes seleccionados en la tabla</b></html>", "Fallo en proceso", JOptionPane.PLAIN_MESSAGE, getIcon("/resources/cancel.png", 30, 30));

        }
        
        
        
        
    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
         int num = jTable1.getRowCount();
        if (num != 0) {
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                modelo.setValueAt(!areAllChecked, i, 5);
            }

            areAllChecked = !areAllChecked;

            // Cambiar el texto del botón según el estado
            if (areAllChecked) {
                jButton2.setText("Desmarcar Todos");
            } else {
                jButton2.setText("Marcar Todos");

            }
        } else {
            JOptionPane.showMessageDialog(null,"No cuentas con niguna reserva en estos momentos ");
        }
    }//GEN-LAST:event_button7ActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Ventanas.personalizados.Button button1;
    private Ventanas.personalizados.Button button2;
    private Ventanas.personalizados.Button button3;
    private Ventanas.personalizados.Button button4;
    private Ventanas.personalizados.Button button5;
    private Ventanas.personalizados.Button button6;
    private Ventanas.personalizados.Button button7;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
        
    
    
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
                    
                    jPanel1.setBackground(new java.awt.Color(255,255,255));
                    
                    button1.setForeground(Color.black);
                    button2.setForeground(Color.black);
                    button4.setForeground(Color.black);
                    button3.setForeground(Color.black);
                    button5.setForeground(Color.black);
                    
                    button1.setBackground(Color.white);
                    button2.setBackground(Color.white);
                    button3.setBackground(Color.white);
                    button4.setBackground(Color.white);
                    button5.setBackground(Color.white);
                    
                    
                    jLabel4.setForeground(Color.black);
                    jLabel5.setForeground(Color.black);
                    jLabel7.setForeground(Color.black);
                    jLabel8.setForeground(Color.black);
                    
      
                    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrast.png"))); 
                    
                     
                       
                });
            } else {
                EventQueue.invokeLater(() -> {
                    //Cuando pasa a negro
                    
                    FlatAnimatedLafChange.showSnapshot();
                    FlatMacDarkLaf.setup();
                    FlatLaf.updateUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                    
                    jPanel1.setBackground(new java.awt.Color(0,0,0));
                   
                   
                    button1.setForeground(Color.white);
                    button2.setForeground(Color.white);
                    button3.setForeground(Color.white);
                    button4.setForeground(Color.white);
                    button5.setForeground(Color.white);
                    
                    button1.setBackground(Color.black);
                    button2.setBackground(Color.black);
                    button3.setBackground(Color.black);
                    button4.setBackground(Color.black);
                    button5.setBackground(Color.black);
                    
            
                    jLabel4.setForeground(Color.white);
                    jLabel5.setForeground(Color.white);
                    jLabel7.setForeground(Color.white);
                    jLabel8.setForeground(Color.white);
                   

                    jTable1.setForeground(Color.black);
                    
                    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/full-moon (1).png"))); 
                   
                    
                    
                });
            }
        });
       
    }
    
    
    
    
    
    
    
     @Override
    public void applyTheme() {
        if (FlatLaf.isLafDark()) {
             
                    FlatAnimatedLafChange.showSnapshot();
                    FlatMacDarkLaf.setup();
                    FlatLaf.updateUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                    
                   
                     jPanel1.setBackground(new java.awt.Color(0,0,0));
                     
                    button1.setForeground(Color.white);
                    button2.setForeground(Color.white);
                    button3.setForeground(Color.white);
                    button4.setForeground(Color.white);
                    button5.setForeground(Color.white);
                    
                    button1.setBackground(Color.black);
                    button2.setBackground(Color.black);
                    button3.setBackground(Color.black);
                    button4.setBackground(Color.black);
                    button5.setBackground(Color.black);
                    
            
                    jLabel4.setForeground(Color.white);
                    jLabel5.setForeground(Color.white);
                    jLabel7.setForeground(Color.white);
                    jLabel8.setForeground(Color.white);
                   

                    jTable1.setForeground(Color.black);
                    
                    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/full-moon (1).png"))); 
                    
                

            FlatMacDarkLaf.setup();
            FlatLaf.updateUI();
        } else {
            FlatAnimatedLafChange.showSnapshot();
                    FlatMacLightLaf.setup();
                    FlatLaf.updateUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                    
                  jPanel1.setBackground(new java.awt.Color(255,255,255));
                    
                    button1.setForeground(Color.black);
                    button2.setForeground(Color.black);
                    button4.setForeground(Color.black);
                    button3.setForeground(Color.black);
                    button5.setForeground(Color.black);
                    
                    button1.setBackground(Color.white);
                    button2.setBackground(Color.white);
                    button3.setBackground(Color.white);
                    button4.setBackground(Color.white);
                    button5.setBackground(Color.white);
                    
                    
                    jLabel4.setForeground(Color.black);
                    jLabel5.setForeground(Color.black);
                    jLabel7.setForeground(Color.black);
                    jLabel8.setForeground(Color.black);
                    
      
                    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrast.png"))); 
                
        }
    }
}
