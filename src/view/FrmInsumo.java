package view;

import dao.IDaoExtendido;
import dao.IDaoGenerico;
import daoImpl.CategoriaDaoImpl;
import daoImpl.InsumoDaoImpl;
import daoImpl.ProveedorDaoImpl;
import daoImpl.UnidadMedidaDaoImpl;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Insumo;
import model.Proveedor;
import model.UnidadMedida;

public class FrmInsumo extends javax.swing.JFrame {

    private int idInsumo;
    private IDaoGenerico<Insumo> crudDao;
    private DefaultTableModel modelo;
    private Object[] filaDatos;

    public FrmInsumo() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);//Para maximizar.

        filaDatos = new Object[5];
        modelo = new DefaultTableModel();
        crudDao = new InsumoDaoImpl();

        listar();
        comboUnidadMedida();
        comboCategoria();
        comboProveedor();
    
    }

    private void limpiarTabla() {
        modelo = (DefaultTableModel) tblInsumo.getModel();
        modelo.getDataVector().removeAllElements();
        tblInsumo.removeAll();
    }

    private void listar() {

        try {
            limpiarTabla();
            modelo = (DefaultTableModel) tblInsumo.getModel();
            for (Insumo i : crudDao.listar()) {
                filaDatos[0] = i.getIdInsumo();
                filaDatos[1] = i.getNombreInsumo();
                filaDatos[2] = i.getIdUnidadMedida();
                filaDatos[3] = i.getIdCategoria();
                filaDatos[4] = i.getIdProveedor();
                modelo.addRow(filaDatos);
            }
        } catch (Exception e) {
        }
    }

    private void comboUnidadMedida() {
        IDaoExtendido<UnidadMedida> daoExtendido;
        daoExtendido = new UnidadMedidaDaoImpl();
        cboUnidadMedida.addItem("Seleccionar");
        for (UnidadMedida unidadMedida : daoExtendido.listar()) {
            cboUnidadMedida.addItem(unidadMedida.getNombreUnidadMedida());
        }
    }

    private void comboCategoria() {
        IDaoExtendido<Categoria> crudDaoExtendido = new CategoriaDaoImpl();
        cboCategoria.addItem("Seleccionar");
        for (Categoria categoria : crudDaoExtendido.listar()) {
            cboCategoria.addItem(categoria.getNombreCategoria());
        }
    }

    private void comboProveedor() {
        IDaoExtendido<Proveedor> crudDaoExtendido = new ProveedorDaoImpl();
        cboProveedor.addItem("Seleccionar");
        for (Proveedor proveedor : crudDaoExtendido.listar()) {
            cboProveedor.addItem(proveedor.getNombreProveedor());
        }
    }

    private void limpiar() {
        txtNombre.setText("");
        cboUnidadMedida.setSelectedIndex(0);
        cboCategoria.setSelectedIndex(0);
        cboProveedor.setSelectedIndex(0);
        txtNombre.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblRegistroProductos = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblPrecioUnidad = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblUnidadMedida = new javax.swing.JLabel();
        lblIntruccion = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInsumo = new javax.swing.JTable();
        cboUnidadMedida = new javax.swing.JComboBox<>();
        cboCategoria = new javax.swing.JComboBox<>();
        cboProveedor = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 800));

        lblRegistroProductos.setBackground(new java.awt.Color(0, 0, 0));
        lblRegistroProductos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRegistroProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/RegistraProducto.png"))); // NOI18N
        lblRegistroProductos.setText("Registro de Insumo");

        lblNombre.setBackground(new java.awt.Color(0, 0, 0));
        lblNombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblNombre.setText("Nombre ");

        lblPrecioUnidad.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblPrecioUnidad.setText("Proveedor ");

        lblCategoria.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblCategoria.setText("Categoría");

        lblUnidadMedida.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblUnidadMedida.setText("Unidad de medida");

        lblIntruccion.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        lblIntruccion.setText("Ingresar la información correcta para los Insumos");

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

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/ic_guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/ic_modificar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/ic_eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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

        tblInsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Insumo ", "Nombre ", "ID unidad de medida", "ID categoría", "ID proveedor "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblInsumoMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblInsumo);
        if (tblInsumo.getColumnModel().getColumnCount() > 0) {
            tblInsumo.getColumnModel().getColumn(0).setMinWidth(150);
            tblInsumo.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblInsumo.getColumnModel().getColumn(0).setMaxWidth(150);
            tblInsumo.getColumnModel().getColumn(2).setMinWidth(150);
            tblInsumo.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblInsumo.getColumnModel().getColumn(2).setMaxWidth(150);
            tblInsumo.getColumnModel().getColumn(3).setMinWidth(150);
            tblInsumo.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblInsumo.getColumnModel().getColumn(3).setMaxWidth(150);
            tblInsumo.getColumnModel().getColumn(4).setMinWidth(150);
            tblInsumo.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblInsumo.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        cboUnidadMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUnidadMedidaActionPerformed(evt);
            }
        });

        cboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriaActionPerformed(evt);
            }
        });

        cboProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(lblRegistroProductos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(lblIntruccion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(lblNombre)
                        .addGap(232, 232, 232)
                        .addComponent(lblUnidadMedida)
                        .addGap(179, 179, 179)
                        .addComponent(lblCategoria)
                        .addGap(225, 225, 225)
                        .addComponent(lblPrecioUnidad))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cboUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnMinimizar)
                .addGap(11, 11, 11)
                .addComponent(lblRegistroProductos)
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addComponent(lblIntruccion)
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblUnidadMedida)
                    .addComponent(lblCategoria)
                    .addComponent(lblPrecioUnidad))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(20, 20, 20)
                        .addComponent(btnGuardar)
                        .addGap(20, 20, 20)
                        .addComponent(btnActualizar)
                        .addGap(20, 20, 20)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtras))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (!txtNombre.getText().isEmpty() && ((!"Seleccionar".equals((String) cboUnidadMedida.getSelectedItem()))) && ((!"Seleccionar".equals((String) cboCategoria.getSelectedItem()))) && ((!"Seleccionar".equals((String) cboProveedor.getSelectedItem())))) {
            IDaoExtendido daoExtendido = new UnidadMedidaDaoImpl();
            int idUnidadMedida = daoExtendido.obtenerId(cboUnidadMedida.getSelectedItem().toString());
            daoExtendido = new CategoriaDaoImpl();
            int idCategoria = daoExtendido.obtenerId(cboCategoria.getSelectedItem().toString());
            daoExtendido = new ProveedorDaoImpl();
            int idProveedor = daoExtendido.obtenerId(cboProveedor.getSelectedItem().toString());

            if (crudDao.agregar(new Insumo(txtNombre.getText(), idUnidadMedida, idCategoria, idProveedor))) {
                JOptionPane.showMessageDialog(null, "El registro se agregó corectamente");
            } else {
                JOptionPane.showMessageDialog(null, "El registro no se pudo agregar");
            }

            limpiarTabla();
            listar();
        } else {
            JOptionPane.showMessageDialog(null, "Los datos ingresados no son correctos.");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        IDaoExtendido daoExtendido = new UnidadMedidaDaoImpl();
        int idUnidadMedida = daoExtendido.obtenerId(cboUnidadMedida.getSelectedItem().toString());
        daoExtendido = new CategoriaDaoImpl();
        int idCategoria = daoExtendido.obtenerId(cboCategoria.getSelectedItem().toString());
        daoExtendido = new ProveedorDaoImpl();
        int idProveedor = daoExtendido.obtenerId(cboProveedor.getSelectedItem().toString());

        if (crudDao.actualizar(new Insumo(idInsumo, txtNombre.getText(), idUnidadMedida, idCategoria, idProveedor))) {
            JOptionPane.showMessageDialog(null, "El registro se actualizó corectamente");
        } else {
            JOptionPane.showMessageDialog(null, "El registro no se pudo actualizar");
        }

        limpiarTabla();
        listar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblInsumo.getSelectedRow();

        if (fila == -1)
            JOptionPane.showMessageDialog(this, "Debe seleccionar una Fila");
        else if (JOptionPane.showConfirmDialog(null, "Desea eliminar el registro", "Eliminar", JOptionPane.YES_NO_OPTION, 3) == 0) {

            if (crudDao.eliminar(new Insumo(idInsumo))) {
                JOptionPane.showMessageDialog(null, "EL Registro fue eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
            }

            limpiarTabla();
            listar();
            btnNuevoActionPerformed(evt);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.setVisible(false);
        FrmMenu.getInstancia().setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(1);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void tblInsumoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInsumoMouseReleased
        int fila = tblInsumo.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar una Fila");
        } else {
            idInsumo = Integer.parseInt(tblInsumo.getValueAt(fila, 0).toString());
            txtNombre.setText(tblInsumo.getValueAt(fila, 1).toString());
            IDaoExtendido daoExtendido = new UnidadMedidaDaoImpl();
            cboUnidadMedida.setSelectedItem(daoExtendido.obtenerNombre(Integer.parseInt(tblInsumo.getValueAt(fila, 2).toString())));
            daoExtendido = new CategoriaDaoImpl();
            cboCategoria.setSelectedItem(daoExtendido.obtenerNombre(Integer.parseInt(tblInsumo.getValueAt(fila, 3).toString())));
            daoExtendido = new ProveedorDaoImpl();
            cboProveedor.setSelectedItem(daoExtendido.obtenerNombre(Integer.parseInt(tblInsumo.getValueAt(fila, 4).toString())));
        
            btnGuardar.setEnabled(false);
        }

    }//GEN-LAST:event_tblInsumoMouseReleased

    private void cboProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboProveedorActionPerformed

    private void cboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCategoriaActionPerformed

    private void cboUnidadMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUnidadMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboUnidadMedidaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInsumo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JComboBox<String> cboProveedor;
    private javax.swing.JComboBox<String> cboUnidadMedida;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblIntruccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecioUnidad;
    private javax.swing.JLabel lblRegistroProductos;
    private javax.swing.JLabel lblUnidadMedida;
    private javax.swing.JTable tblInsumo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
