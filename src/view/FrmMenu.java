package view;

import javax.swing.JOptionPane;

public class FrmMenu extends javax.swing.JFrame {

    private static FrmMenu instancia = null;

    private FrmMenu() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);//Para maximizar.
        setResizable(false);
    }

    public static FrmMenu getInstancia() {
        if (instancia == null) {
            instancia = new FrmMenu();
        }
        return instancia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSalida = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblImgDecofruta = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblImgAlmacen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 800));

        btnSalida.setBackground(new java.awt.Color(252, 253, 255));
        btnSalida.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSalida.setForeground(new java.awt.Color(0, 0, 0));
        btnSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/out-of-stock.png"))); // NOI18N
        btnSalida.setText("   Salida de Insumo");
        btnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaActionPerformed(evt);
            }
        });

        btnInventario.setBackground(new java.awt.Color(252, 253, 255));
        btnInventario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(0, 0, 0));
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/warehouse (2).png"))); // NOI18N
        btnInventario.setText("       Inventario Actual");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnEntrada.setBackground(new java.awt.Color(252, 253, 255));
        btnEntrada.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEntrada.setForeground(new java.awt.Color(0, 0, 0));
        btnEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/inventory-management.png"))); // NOI18N
        btnEntrada.setText(" Entrada de Insumo");
        btnEntrada.setPreferredSize(new java.awt.Dimension(226, 45));
        btnEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradaActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/turn-off.png"))); // NOI18N
        btnSalir.setText("  Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRegistrosInsumo.setBackground(new java.awt.Color(252, 253, 255));
        btnRegistrosInsumo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegistrosInsumo.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrosInsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/RegistraProducto.png"))); // NOI18N
        btnRegistrosInsumo.setText(" Registro de Insumo");
        btnRegistrosInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrosInsumoActionPerformed(evt);
            }
        });

        lblImgDecofruta.setBackground(new java.awt.Color(255, 255, 255));
        lblImgDecofruta.setForeground(new java.awt.Color(255, 255, 255));
        lblImgDecofruta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/LogoDecofrutaSinfondo.png"))); // NOI18N

        btnRegistrosUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrosUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegistrosUsuario.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrosUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/agregarUsuario.png"))); // NOI18N
        btnRegistrosUsuario.setText("Registro de Usuario ");
        btnRegistrosUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrosUsuarioActionPerformed(evt);
            }
        });

        btnRegistrosProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrosProveedor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegistrosProveedor.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrosProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Proveedor.png"))); // NOI18N
        btnRegistrosProveedor.setText("Registro de Proveedor");
        btnRegistrosProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrosProveedorActionPerformed(evt);
            }
        });

        btnMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnMinimizar.setForeground(new java.awt.Color(0, 0, 0));
        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/minimizar.png"))); // NOI18N
        btnMinimizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrosInsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrosUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrosProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnInventario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(btnSalida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(lblImgDecofruta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnMinimizar)
                .addGap(48, 48, 48)
                .addComponent(lblImgDecofruta)
                .addGap(133, 133, 133)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrosUsuario))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalida)
                    .addComponent(btnRegistrosProveedor))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInventario)
                    .addComponent(btnRegistrosInsumo))
                .addGap(48, 48, 48)
                .addComponent(btnSalir)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));
        jPanel1.getAccessibleContext().setAccessibleName("");

        jPanel2.setBackground(new java.awt.Color(181, 208, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 800));

        lblImgAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Logo_inventario.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblImgAlmacen)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(lblImgAlmacen)
                .addContainerGap(214, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, -1, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrosInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrosInsumoActionPerformed
        this.setVisible(false);
        FrmInsumo insumo = new FrmInsumo();
        insumo.setVisible(true);
    }//GEN-LAST:event_btnRegistrosInsumoActionPerformed

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

    private void btnEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradaActionPerformed
        this.setVisible(false);
        FrmEntrada entrada = new FrmEntrada();
        entrada.setVisible(true);
    }//GEN-LAST:event_btnEntradaActionPerformed

    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaActionPerformed
        this.setVisible(false);
        FrmSalida salida = new FrmSalida();
        salida.setVisible(true);
    }//GEN-LAST:event_btnSalidaActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        this.setVisible(false);
        FrmInventario inventario = new FrmInventario();
        inventario.setVisible(true);
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnRegistrosUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrosUsuarioActionPerformed
        this.setVisible(false);
        FrmUsuario usuario = new FrmUsuario();
        usuario.setVisible(true);
    }//GEN-LAST:event_btnRegistrosUsuarioActionPerformed

    private void btnRegistrosProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrosProveedorActionPerformed
        this.setVisible(false);
        FrmProveedor proveedor = new FrmProveedor();
        proveedor.setVisible(true);
    }//GEN-LAST:event_btnRegistrosProveedorActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(1);
    }//GEN-LAST:event_btnMinimizarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static final javax.swing.JButton btnEntrada = new javax.swing.JButton();
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnMinimizar;
    protected static final javax.swing.JButton btnRegistrosInsumo = new javax.swing.JButton();
    protected static final javax.swing.JButton btnRegistrosProveedor = new javax.swing.JButton();
    protected static final javax.swing.JButton btnRegistrosUsuario = new javax.swing.JButton();
    private javax.swing.JButton btnSalida;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblImgAlmacen;
    private javax.swing.JLabel lblImgDecofruta;
    // End of variables declaration//GEN-END:variables
}
