package view;

import dao.IDaoExtendido;
import dao.IDaoGenerico;
import daoImpl.InsumoDaoImpl;
import daoImpl.SalidaInsumoDaoImpl;
import java.sql.Timestamp;
import java.time.Instant;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Insumo;
import model.SalidaInsumo;

public class FrmSalida extends javax.swing.JFrame {
    
    private int idSalida;
    private String origen = txtIdUsuario.getText();
    private IDaoGenerico<SalidaInsumo> crudDao;
    private DefaultTableModel modelo;
    private Object[] filaDatos;

    public FrmSalida() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        txtIdUsuario.setEditable(false); // Hacer el campo de texto de solo lectura

        filaDatos = new Object[5];
        modelo = new DefaultTableModel();
        crudDao = new SalidaInsumoDaoImpl();

        listar();
        comboInsumo();
    }

    private void limpiarTabla() {
        modelo = (DefaultTableModel) tblSalida.getModel();
        modelo.getDataVector().removeAllElements();
        tblSalida.removeAll();
    }

    private void listar() {

        try {
            limpiarTabla();
            modelo = (DefaultTableModel) tblSalida.getModel();
            for (SalidaInsumo e : crudDao.listar()) {
                filaDatos[0] = e.getIdSalida();
                filaDatos[1] = e.getIdInsumo();
                filaDatos[2] = e.getCantidad();
                filaDatos[3] = e.getFechaSalida();
                filaDatos[4] = e.getIdUsuario();
                modelo.addRow(filaDatos);
            }
        } catch (Exception e) {
        }
    }

    private void comboInsumo() {
        IDaoExtendido<Insumo> daoExtendido;
        daoExtendido = new InsumoDaoImpl();
        cboInsumo.addItem("Seleccionar");
        for (Insumo insumo : daoExtendido.listar()) {
            cboInsumo.addItem(insumo.getNombreInsumo());
        }
    }

    private void limpiar() {
        txtIdUsuario.setText(origen);
        txtCantidad.setText("");
        cboInsumo.setSelectedIndex(0);
        txtCantidad.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblInsumo = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnMinimizar2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalida = new javax.swing.JTable();
        cboInsumo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/out-of-stock.png"))); // NOI18N
        jLabel1.setText("Salida de Insumos");

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel4.setText("Ingresar la información correcta para la salida de Insumos");

        lblInsumo.setBackground(new java.awt.Color(0, 0, 0));
        lblInsumo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblInsumo.setText("Insumo");

        lblCantidad.setBackground(new java.awt.Color(0, 0, 0));
        lblCantidad.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblCantidad.setText("Cantidad");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/ic_nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/ic_registra.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnAtras.setBackground(new java.awt.Color(255, 255, 255));
        btnAtras.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(0, 0, 0));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/undo.png"))); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnMinimizar2.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimizar2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnMinimizar2.setForeground(new java.awt.Color(0, 0, 0));
        btnMinimizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/minimizar.png"))); // NOI18N
        btnMinimizar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnMinimizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizar2ActionPerformed(evt);
            }
        });

        tblSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Salida", "ID Insumo ", "Cantidad ", "Fecha de Salida", "ID usuario "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblSalidaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblSalida);
        if (tblSalida.getColumnModel().getColumnCount() > 0) {
            tblSalida.getColumnModel().getColumn(0).setResizable(false);
            tblSalida.getColumnModel().getColumn(1).setResizable(false);
            tblSalida.getColumnModel().getColumn(4).setResizable(false);
        }

        cboInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboInsumoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("ID usuario ");

        txtIdUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMinimizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblInsumo)
                                    .addComponent(cboInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(150, 150, 150)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCantidad)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(150, 150, 150)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnMinimizar2)
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidad)
                    .addComponent(jLabel5)
                    .addComponent(lblInsumo))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(15, 15, 15)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtras))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        btnRegistrar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.setVisible(false);
        FrmMenu.getInstancia().setVisible(true); // Mostrar la instancia existente de FrmInventario
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if ((!"Seleccionar".equals((String) cboInsumo.getSelectedItem())) && ((txtCantidad.getText()).matches("[0-9]+")) && !txtIdUsuario.getText().isEmpty()) {

            IDaoExtendido daoExtendido = new InsumoDaoImpl();
            int idInusmo = daoExtendido.obtenerId(cboInsumo.getSelectedItem().toString());
            int cantidad = Integer.parseInt(txtCantidad.getText());

            if (crudDao.agregar(new SalidaInsumo(Timestamp.from(Instant.now()), cantidad, Integer.parseInt(txtIdUsuario.getText()), idInusmo))) {
                JOptionPane.showMessageDialog(null, "El registro se agregó corectamente");
            } else {
                JOptionPane.showMessageDialog(null, "El registro no se pudo agregar");
            }

            limpiarTabla();
            listar();
        } else {
            JOptionPane.showMessageDialog(null, "Los valores registrados no son correctos");
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnMinimizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizar2ActionPerformed
        this.setExtendedState(1);
    }//GEN-LAST:event_btnMinimizar2ActionPerformed

    private void cboInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboInsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboInsumoActionPerformed

    private void tblSalidaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSalidaMouseReleased
        int fila = tblSalida.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar una Fila");
        } else {
            idSalida = Integer.parseInt(tblSalida.getValueAt(fila, 0).toString());
            IDaoExtendido daoExtendido = new InsumoDaoImpl();
            cboInsumo.setSelectedItem(daoExtendido.obtenerNombre(Integer.parseInt(tblSalida.getValueAt(fila, 1).toString())));
            txtCantidad.setText(tblSalida.getValueAt(fila, 2).toString());
            txtIdUsuario.setText(tblSalida.getValueAt(fila, 4).toString());
            
            btnRegistrar.setEnabled(false);
        }
    }//GEN-LAST:event_tblSalidaMouseReleased

    private void txtIdUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSalida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnMinimizar2;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboInsumo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblInsumo;
    private javax.swing.JTable tblSalida;
    private javax.swing.JTextField txtCantidad;
    protected static final javax.swing.JTextField txtIdUsuario = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables
}
