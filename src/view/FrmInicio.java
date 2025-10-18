package view;

import daoImpl.UsuarioDaoImpl;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import model.Usuario;

public class FrmInicio extends javax.swing.JFrame {
    private int intentosAcceso = 0;
    private final int MAXIMO_INTENTOS_INICIO = 3;

    public FrmInicio() {
        initComponents();
        setLocationRelativeTo(null);//centro
        setVisible(true);
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("view/images/logoesquina.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBienvenido = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        lblfondoderecha = new javax.swing.JLabel();
        lblfondoizquierdo = new javax.swing.JLabel();
        pfClave = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(780, 470));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBienvenido.setBackground(new java.awt.Color(43, 45, 48));
        lblBienvenido.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lblBienvenido.setText(" BIENVENIDO");
        jPanel1.add(lblBienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 150, 40));

        lblUsuario.setBackground(new java.awt.Color(223, 225, 229));
        lblUsuario.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(43, 45, 48));
        lblUsuario.setText("Usuario");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, -1, -1));

        lblClave.setBackground(new java.awt.Color(223, 225, 229));
        lblClave.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        lblClave.setForeground(new java.awt.Color(43, 45, 48));
        lblClave.setText("Clave");
        jPanel1.add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, -1));

        lblfondoderecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/LogoDecofrutaSinfondo.png"))); // NOI18N
        jPanel1.add(lblfondoderecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        lblfondoizquierdo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/decoracionPlatillo2.png"))); // NOI18N
        jPanel1.add(lblfondoizquierdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 470));

        pfClave.setBackground(new java.awt.Color(204, 204, 204));
        pfClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfClaveActionPerformed(evt);
            }
        });
        jPanel1.add(pfClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 210, -1));

        txtUsuario.setBackground(new java.awt.Color(204, 204, 204));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 236, 210, -1));

        btnIngresar.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/import.png"))); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, -1, -1));

        btnSalir.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/logout.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pfClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfClaveActionPerformed

    }//GEN-LAST:event_pfClaveActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed

    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

        String nombreUsuario = txtUsuario.getText();
        String contrasena = new String(pfClave.getPassword());

        UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
        Usuario usuarioEncontrado = usuarioDao.obtenerUsuario(nombreUsuario, contrasena);
        
        if(usuarioEncontrado != null) {
            JOptionPane.showMessageDialog(null, "Acceso concedido. Bienvenido");
            this.setVisible(false);
            
            FrmMenu.getInstancia().setVisible(true); // Mostrar la instancia existente de FrmInventario
            
            FrmEntrada.txtIdUsuario.setText(Integer.toString(usuarioEncontrado.getIdUsuario()));
            FrmSalida.txtIdUsuario.setText(Integer.toString(usuarioEncontrado.getIdUsuario()));
            
            if (usuarioEncontrado.getIdRol()==2) {
                FrmMenu.btnRegistrosUsuario.setEnabled(false);
            } else if (usuarioEncontrado.getIdRol()==3) {
                FrmMenu.btnRegistrosUsuario.setEnabled(false);
                FrmMenu.btnRegistrosProveedor.setEnabled(false);
                FrmMenu.btnRegistrosInsumo.setEnabled(false);
                FrmMenu.btnEntrada.setEnabled(false);
            } 
            
        }else {
            if (intentosAcceso >= MAXIMO_INTENTOS_INICIO) {
                JOptionPane.showMessageDialog(null, "Número de intentos excedidos. Cerrando programa...");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Acceso denegado. Usuario o clave incorrectos");
                intentosAcceso++;
            }
        }
 
    }//GEN-LAST:event_btnIngresarActionPerformed
    

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int respuesta = JOptionPane.showOptionDialog(
                null,
                "¿Desea salir del programa?",
                "Salir del programa",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Aceptar", "Cancelar"},
                "Cancelar"); //Valor por defecto
        if (respuesta == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblfondoderecha;
    private javax.swing.JLabel lblfondoizquierdo;
    private javax.swing.JPasswordField pfClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
