
package Ventanas;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import cvx.Aplication.Services.EquipoService;
import cvx.Aplication.Services.ReservaService;
import cvx.Aplication.Services.UsuarioService;
import cvx.Domain.Usuario;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JLabel;



public class ventanaIngreso extends javax.swing.JFrame {
    
    private final EquipoService equipoService;
    private final UsuarioService usuarioService;
    private final ReservaService reservaService;
    private Usuario usuario;
    
   
    public ventanaIngreso(UsuarioService usuarioService,EquipoService equipoService,ReservaService reservaService, Usuario usuarioActual) {
        this.equipoService = equipoService;
        this.usuarioService = usuarioService;
        this.reservaService = reservaService;
        this.usuario = usuarioActual;
        
        initComponents();
        
        setTitle("Eleccion");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
       
        jLabel3.setText(usuarioActual.getNombre());
        adjustFontSizeToFit(jLabel3, usuarioActual.getNombre());
        
        
      
   
      
        
        createThemeButton();
        applyTheme();

        
        
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        button3 = new Ventanas.personalizados.Button();
        button1 = new Ventanas.personalizados.Button();
        button2 = new Ventanas.personalizados.Button();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 63, 112));
        jLabel1.setText("Laboratorio de marketing");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, 180, 30));

        jLabel2.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 63, 112));
        jLabel2.setText("Laboratorio de ingenierias");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 500, 190, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user (3).png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 10, 40, 50));

        jLabel3.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 20, 60, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrast.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 20, 60, 30));

        button3.setForeground(new java.awt.Color(0, 0, 0));
        button3.setText("Cerrar sesion");
        button3.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        jPanel1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 49));

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/planning (1).png"))); // NOI18N
        button1.setFocusPainted(false);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 210, 210));

        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/civil-engineering (1).png"))); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 290, 210, 210));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2148459762.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 0, 1630, 1390));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 220, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
         LaboratorioMaketing laboratorioMaketing = new LaboratorioMaketing(usuarioService,equipoService,reservaService,usuario);
        
        laboratorioMaketing.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_button1ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
          IngresoDeUsuario loginRegisterApp = new  IngresoDeUsuario(usuarioService, equipoService, reservaService, usuario);
       
       loginRegisterApp.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_button3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
         LaboratorioIngenieria laboratorioIngenieria = new LaboratorioIngenieria(usuarioService, equipoService, reservaService, usuario);

        laboratorioIngenieria.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_button2ActionPerformed
    
    
    private void createThemeButton() {
      
        jButton1.addActionListener(e -> {
            if (FlatLaf.isLafDark()) {
                EventQueue.invokeLater(() -> {
                    FlatAnimatedLafChange.showSnapshot();
                    FlatMacLightLaf.setup();
                    FlatLaf.updateUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                    
                
                    button3.setForeground(Color.black);
                    button3.setBackground(Color.white);
                    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrast.png"))); 
                    
                     
                       
                });
            } else {
                EventQueue.invokeLater(() -> {
                    //Cuando pasa a negro
                    
                    FlatAnimatedLafChange.showSnapshot();
                    FlatMacDarkLaf.setup();
                    FlatLaf.updateUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                     
                    button3.setForeground(Color.white);    
                    button3.setBackground(Color.black);
                 
                    

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
                    
                  button3.setForeground(Color.white);    
                    button3.setBackground(Color.black);
                 
                    

                    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/full-moon (1).png"))); 

            FlatMacDarkLaf.setup();
            FlatLaf.updateUI();
        } else {
            FlatAnimatedLafChange.showSnapshot();
                    FlatMacLightLaf.setup();
                    FlatLaf.updateUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                    
                   
                    button3.setForeground(Color.black);
                    button3.setBackground(Color.white);
                    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrast.png"))); 
        }
    }
   
    private void adjustFontSizeToFit(JLabel label, String text) {
    Font labelFont = new Font("SansSerif", Font.PLAIN, 14);
    int stringWidth = label.getFontMetrics(labelFont).stringWidth(text);
    int componentWidth = label.getWidth();

    // Si el texto es más ancho que el componente, ajusta el tamaño de la fuente
    if (stringWidth > componentWidth) {
        double widthRatio = (double) componentWidth / (double) stringWidth;
        int newFontSize = (int) (labelFont.getSize() * widthRatio);
        int componentHeight = label.getHeight();

        // Asegúrate de que el nuevo tamaño de fuente no sea mayor que el original
        int fontSizeToUse = Math.min(newFontSize, 14);

        // Establece el nuevo tamaño de fuente
        label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
    } else {
        // Si el texto cabe, usa el tamaño de fuente original
        label.setFont(labelFont);
    }
}

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Ventanas.personalizados.Button button1;
    private Ventanas.personalizados.Button button2;
    private Ventanas.personalizados.Button button3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
