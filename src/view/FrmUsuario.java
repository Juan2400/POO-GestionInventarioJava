package view;

import dao.IDaoExtendido;
import dao.IDaoGenerico;
import daoImpl.RolDaoImpl;
import daoImpl.UsuarioDaoImpl;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Rol;
import model.Usuario;

public class FrmUsuario extends javax.swing.JFrame {

    private int idUsuario;
    private IDaoGenerico<Usuario> crudDao;
    private DefaultTableModel modelo;
    private Object[] filaDatos;
    private String contraseniaOriginal; // Para comparar si cambió

    public FrmUsuario() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);

        filaDatos = new Object[8];
        modelo = new DefaultTableModel();
        crudDao = new UsuarioDaoImpl();

        listar();
        comboRol();
    }

    private void limpiarTabla() {
        modelo = (DefaultTableModel) tblUsuario.getModel();
        modelo.getDataVector().removeAllElements();
        tblUsuario.removeAll();
    }

    private void listar() {
        try {
            limpiarTabla();
            modelo = (DefaultTableModel) tblUsuario.getModel();

            for (Usuario u : crudDao.listar()) {
                filaDatos[0] = u.getIdUsuario();
                filaDatos[1] = u.getNombre();
                filaDatos[2] = u.getApellido();
                filaDatos[3] = u.getDni();
                filaDatos[4] = u.getNombreUsuario();
                // OCULTAR CONTRASEÑA EN LA TABLA
                filaDatos[5] = "••••••••"; // Mostrar asteriscos en lugar del hash
                filaDatos[6] = u.getEmail();
                filaDatos[7] = u.getIdRol();
                modelo.addRow(filaDatos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar: " + e.getMessage());
        }
    }

    private void comboRol() {
        IDaoExtendido<Rol> daoExtendido;
        daoExtendido = new RolDaoImpl();
        cboRol.addItem("Seleccionar");
        for (Rol rol : daoExtendido.listar()) {
            cboRol.addItem(rol.getNombreRol());
        }
    }

    private void limpiar() {
        txtNombre.setText("");
        txtDni.setText("");
        txtApellido.setText("");
        txtNombreUsuario.setText("");
        txtContrasena.setText("");
        txtEmail.setText("");
        cboRol.setSelectedIndex(0);
        txtNombre.requestFocus();
        contraseniaOriginal = null;
        idUsuario = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        lblIntruccion = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        cboRol = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 800));

        lbl.setBackground(new java.awt.Color(0, 0, 0));
        lbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/agregarUsuario.png"))); // NOI18N
        lbl.setText("Registro de Usuario ");

        lblDni.setBackground(new java.awt.Color(0, 0, 0));
        lblDni.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblDni.setText("DNI");

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        lblNombre.setBackground(new java.awt.Color(0, 0, 0));
        lblNombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblNombre.setText("Nombres ");

        lblCategoria.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblCategoria.setText("Apellidos ");

        lblIntruccion.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        lblIntruccion.setText("Ingresar la información correcta para los usuarios  ");

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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Nombre Usuario");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Contraseña");

        txtContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasenaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Email ");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Rol");

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

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre ", "Apellido", "Dni", "Nombre Usuario", "Contraseña", "Email ", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblUsuarioMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuario);
        if (tblUsuario.getColumnModel().getColumnCount() > 0) {
            tblUsuario.getColumnModel().getColumn(0).setMinWidth(60);
            tblUsuario.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblUsuario.getColumnModel().getColumn(0).setMaxWidth(60);
            tblUsuario.getColumnModel().getColumn(3).setMinWidth(80);
            tblUsuario.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblUsuario.getColumnModel().getColumn(3).setMaxWidth(80);
            tblUsuario.getColumnModel().getColumn(4).setMinWidth(120);
            tblUsuario.getColumnModel().getColumn(4).setPreferredWidth(120);
            tblUsuario.getColumnModel().getColumn(4).setMaxWidth(120);
            tblUsuario.getColumnModel().getColumn(5).setMinWidth(100);
            tblUsuario.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblUsuario.getColumnModel().getColumn(5).setMaxWidth(100);
            tblUsuario.getColumnModel().getColumn(6).setMinWidth(250);
            tblUsuario.getColumnModel().getColumn(6).setPreferredWidth(250);
            tblUsuario.getColumnModel().getColumn(6).setMaxWidth(250);
            tblUsuario.getColumnModel().getColumn(7).setMinWidth(60);
            tblUsuario.getColumnModel().getColumn(7).setPreferredWidth(60);
            tblUsuario.getColumnModel().getColumn(7).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lblIntruccion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategoria))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDni)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cboRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(303, 303, 303))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnMinimizar)
                .addGap(11, 11, 11)
                .addComponent(lbl)
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addComponent(lblIntruccion)
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblCategoria)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblDni))
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1541, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContrasenaActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.setVisible(false);
        FrmMenu.getInstancia().setVisible(true); // Mostrar la instancia existente de FrmInventario
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblUsuario.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario de la tabla");
        } else {
            int confirmacion = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro de eliminar este usuario?\nEsta acción no se puede deshacer.",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                if (crudDao.eliminar(new Usuario(idUsuario))) {
                    JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
                    limpiarTabla();
                    listar();
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario");
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // Validación de campos
        if (idUsuario == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario de la tabla");
            return;
        }
        
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre es obligatorio");
            return;
        }
        
        if (!txtDni.getText().matches("[0-9]{8}")) {
            JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 dígitos");
            return;
        }

        // Verificar si la contraseña cambió
        String contraseniaActual = txtContrasena.getText();
        boolean contrasenaCambio = !contraseniaActual.equals(contraseniaOriginal);
        
        if (contrasenaCambio && !contraseniaActual.isEmpty()) {
            if (contraseniaActual.length() < 6) {
                JOptionPane.showMessageDialog(null, "La nueva contraseña debe tener al menos 6 caracteres");
                return;
            }
            
            int confirmacion = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro de cambiar la contraseña de este usuario?",
                "Confirmar cambio de contraseña",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );
            
            if (confirmacion != JOptionPane.YES_OPTION) {
                return;
            }
        }

        // Obtener ID del rol
        IDaoExtendido daoExtendido = new RolDaoImpl();
        int idRol = daoExtendido.obtenerId(cboRol.getSelectedItem().toString());

        // Crear objeto usuario actualizado
        Usuario usuarioActualizado = new Usuario(
            idUsuario,
            txtNombre.getText().trim(),
            txtApellido.getText().trim(),
            txtDni.getText().trim(),
            txtNombreUsuario.getText().trim(),
            txtContrasena.getText(), // El DAO manejará si está hasheada o no
            txtEmail.getText().trim(),
            idRol
        );

        if (crudDao.actualizar(usuarioActualizado)) {
            JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
            limpiarTabla();
            listar();
            limpiar();
            btnGuardar.setEnabled(true);
            btnActualizar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el usuario");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
         // Validación de campos
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre es obligatorio");
            txtNombre.requestFocus();
            return;
        }
        
        if (txtApellido.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El apellido es obligatorio");
            txtApellido.requestFocus();
            return;
        }
        
        if (!txtDni.getText().matches("[0-9]{8}")) {
            JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 dígitos");
            txtDni.requestFocus();
            return;
        }
        
        if (txtNombreUsuario.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario es obligatorio");
            txtNombreUsuario.requestFocus();
            return;
        }
        
        if (txtContrasena.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La contraseña es obligatoria");
            txtContrasena.requestFocus();
            return;
        }
        
        if (txtContrasena.getText().length() < 6) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 6 caracteres");
            txtContrasena.requestFocus();
            return;
        }
        
        if (txtEmail.getText().trim().isEmpty() || !txtEmail.getText().contains("@")) {
            JOptionPane.showMessageDialog(null, "El email es inválido");
            txtEmail.requestFocus();
            return;
        }
        
        if ("Seleccionar".equals((String) cboRol.getSelectedItem())) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un rol");
            cboRol.requestFocus();
            return;
        }

        // Obtener ID del rol
        IDaoExtendido daoExtendido = new RolDaoImpl();
        int idRol = daoExtendido.obtenerId(cboRol.getSelectedItem().toString());

        // Crear y guardar usuario
        Usuario nuevoUsuario = new Usuario(
            txtNombre.getText().trim(),
            txtApellido.getText().trim(),
            txtDni.getText().trim(),
            txtNombreUsuario.getText().trim(),
            txtContrasena.getText(), // Se encriptará en el DAO
            txtEmail.getText().trim(),
            idRol
        );

        if (crudDao.agregar(nuevoUsuario)) {
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
            limpiarTabla();
            listar();
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el usuario");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        btnGuardar.setEnabled(true);
        btnActualizar.setEnabled(false);
        txtContrasena.setEnabled(true);
        txtContrasena.setToolTipText("Ingrese la contraseña para el nuevo usuario");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(1);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void tblUsuarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuarioMouseReleased
        int fila = tblUsuario.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        } else {
            // Obtener datos de la fila seleccionada
            idUsuario = Integer.parseInt(tblUsuario.getValueAt(fila, 0).toString());
            txtNombre.setText(tblUsuario.getValueAt(fila, 1).toString());
            txtApellido.setText(tblUsuario.getValueAt(fila, 2).toString());
            txtDni.setText(tblUsuario.getValueAt(fila, 3).toString());
            txtNombreUsuario.setText(tblUsuario.getValueAt(fila, 4).toString());
            txtEmail.setText(tblUsuario.getValueAt(fila, 6).toString());
            
            // IMPORTANTE: Obtener el hash real de la base de datos
            java.util.List<Usuario> usuarios = crudDao.listar();
            for (Usuario u : usuarios) {
                if (u.getIdUsuario() == idUsuario) {
                    contraseniaOriginal = u.getContrasenia(); // Guardar hash original
                    txtContrasena.setText(contraseniaOriginal); // Mostrar hash (será manejado por el DAO)
                    break;
                }
            }
            
            IDaoExtendido daoExtendido = new RolDaoImpl();
            cboRol.setSelectedItem(daoExtendido.obtenerNombre(
                Integer.parseInt(tblUsuario.getValueAt(fila, 7).toString())
            ));
            
            // Configurar botones
            btnGuardar.setEnabled(false);
            btnActualizar.setEnabled(true);
            
            // Cambiar tooltip para indicar que puede cambiar contraseña
            txtContrasena.setToolTipText(
                "Contraseña actual (encriptada). Modifique este campo solo si desea cambiar la contraseña."
            );
        }
    }//GEN-LAST:event_tblUsuarioMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(
                java.util.logging.Level.SEVERE, null, ex
            );
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FrmUsuario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblIntruccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
