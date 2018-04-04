/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion_computadora;

import java.awt.Color;
import javax.swing.JFileChooser;
import logica.fachada.FabricaLogica;

/**
 *
 * @author Lourdes
 */
public class AltaUsuario extends javax.swing.JFrame {

    int id_usuario = 0;
    
    /**
     * Creates new form AltaUsuario
     */
    public AltaUsuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        pnlBarra = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JPasswordField();
        txtNombreUsuario = new javax.swing.JTextField();
        txtCorreoElectronico = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtUbicacion = new javax.swing.JTextArea();
        txtArchivo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        clnFechaAlta = new org.freixas.jcalendar.JCalendarCombo();
        lblFechaBaja = new javax.swing.JLabel();
        clnFechaBaja = new org.freixas.jcalendar.JCalendarCombo();
        lblAsteriscoFechaBaja = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblAsteriscoFechaBaja1 = new javax.swing.JLabel();
        lblAsteriscoFechaBaja2 = new javax.swing.JLabel();
        lblAsteriscoFechaBaja3 = new javax.swing.JLabel();
        lblAsteriscoFechaBaja4 = new javax.swing.JLabel();
        lblAsteriscoFechaBaja5 = new javax.swing.JLabel();
        lblAsteriscoFechaBaja6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRepetirContrasenia = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        lblAsteriscoFechaBaja7 = new javax.swing.JLabel();
        lblAsteriscoFechaBaja8 = new javax.swing.JLabel();
        btnDirectorio = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        lblFuncionalidadEliminada = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlFondo.setBackground(new java.awt.Color(216, 207, 215));
        pnlFondo.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));

        pnlBarra.setBackground(java.awt.Color.lightGray);
        pnlBarra.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBarraLayout = new javax.swing.GroupLayout(pnlBarra);
        pnlBarra.setLayout(pnlBarraLayout);
        pnlBarraLayout.setHorizontalGroup(
            pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBarraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar))
        );
        pnlBarraLayout.setVerticalGroup(
            pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBarraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar)))
        );

        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Alta de Usuario.png"))); // NOI18N
        lblTitulo.setToolTipText("");
        lblTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jPanel1.setBackground(new java.awt.Color(158, 182, 203));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Contraseña:");

        jLabel3.setText("Nombre de Usuario:");

        jLabel5.setText("Correo Electronico:");

        jLabel6.setText("Descripción:");

        jLabel8.setText("Ubicación:");

        jLabel7.setText("Archivo:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        txtUbicacion.setColumns(20);
        txtUbicacion.setRows(5);
        txtUbicacion.setText("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\TitulosFuncionalidades");
        txtUbicacion.setEnabled(false);
        jScrollPane2.setViewportView(txtUbicacion);

        jLabel9.setText("Fecha de Alta");

        lblFechaBaja.setBackground(new java.awt.Color(255, 102, 102));
        lblFechaBaja.setText("Fecha de Baja");
        lblFechaBaja.setOpaque(true);

        clnFechaBaja.setForeground(new java.awt.Color(255, 0, 0));

        lblAsteriscoFechaBaja.setForeground(new java.awt.Color(255, 0, 0));
        lblAsteriscoFechaBaja.setText("(*)");

        jLabel12.setText("Los campos marcados con");

        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("(*)");

        jLabel14.setText("no pueden estar vacíos.");

        lblAsteriscoFechaBaja1.setForeground(new java.awt.Color(255, 0, 0));
        lblAsteriscoFechaBaja1.setText("(*)");

        lblAsteriscoFechaBaja2.setForeground(new java.awt.Color(255, 0, 0));
        lblAsteriscoFechaBaja2.setText("(*)");

        lblAsteriscoFechaBaja3.setForeground(new java.awt.Color(255, 0, 0));
        lblAsteriscoFechaBaja3.setText("(*)");

        lblAsteriscoFechaBaja4.setForeground(new java.awt.Color(255, 0, 0));
        lblAsteriscoFechaBaja4.setText("(*)");

        lblAsteriscoFechaBaja5.setForeground(new java.awt.Color(255, 0, 0));
        lblAsteriscoFechaBaja5.setText("(*)");

        lblAsteriscoFechaBaja6.setForeground(new java.awt.Color(255, 0, 0));
        lblAsteriscoFechaBaja6.setText("(*)");

        txtUsuario.setEditable(false);

        jLabel4.setText("IdUsuario:");

        jLabel10.setText("Repetir Contrasenia:");

        lblAsteriscoFechaBaja7.setForeground(new java.awt.Color(255, 0, 0));
        lblAsteriscoFechaBaja7.setText("(*)");

        lblAsteriscoFechaBaja8.setForeground(new java.awt.Color(255, 0, 0));
        lblAsteriscoFechaBaja8.setText("(*)");

        btnDirectorio.setText("...");
        btnDirectorio.setActionCommand("ColorSubrayado");
        btnDirectorio.setEnabled(false);
        btnDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirectorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAsteriscoFechaBaja3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAsteriscoFechaBaja2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAsteriscoFechaBaja))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAsteriscoFechaBaja1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtRepetirContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAsteriscoFechaBaja7))
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAsteriscoFechaBaja4)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFechaBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clnFechaBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(clnFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAsteriscoFechaBaja6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAsteriscoFechaBaja5)
                    .addComponent(lblAsteriscoFechaBaja8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAsteriscoFechaBaja6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lblAsteriscoFechaBaja1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(lblAsteriscoFechaBaja2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(clnFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAsteriscoFechaBaja5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRepetirContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(lblAsteriscoFechaBaja7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lblAsteriscoFechaBaja3)
                    .addComponent(lblFechaBaja)
                    .addComponent(clnFechaBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAsteriscoFechaBaja8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblAsteriscoFechaBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAsteriscoFechaBaja4)
                        .addGap(10, 10, 10)
                        .addComponent(btnDirectorio))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(15, 15, 15))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addGap(42, 42, 42))
        );

        jPanel2.setBackground(new java.awt.Color(247, 252, 169));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UsuarioAdministrador.png"))); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel1.setText("Nombre Completo:");

        lblFuncionalidadEliminada.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblFuncionalidadEliminada.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblFoto)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFuncionalidadEliminada, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(lblFuncionalidadEliminada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        lblMensaje.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        try
        {
            this.dispose();
        }
        catch(Exception ex)
        {
            this.lblMensaje.setForeground(Color.RED);
            this.lblMensaje.setText(ex.toString());
        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        try
        {
            //this.lblMensaje.setText("" + this.txtContrasenia.getText());
        }
        catch(Exception ex)
        {
            this.lblMensaje.setForeground(Color.RED);
            this.lblMensaje.setText(ex.toString());
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirectorioActionPerformed
        // TODO add your handling code here:
        try
        {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new java.io.File("C:\\Users\\Lourdes"));
            fc.setDialogTitle("Seleccione una ubicacion");
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            if(fc.showOpenDialog(this.btnDirectorio) == JFileChooser.APPROVE_OPTION)
            {
                this.txtUbicacion.setText(fc.getSelectedFile().getAbsolutePath());
            }
            else
            {
                this.lblMensaje.setForeground(Color.BLACK);
                this.lblMensaje.setText("Operacion Cancelada");
            }
        }
        catch(Exception ex)
        {
            this.lblMensaje.setForeground(Color.RED);
            this.lblMensaje.setText(ex.toString());
        }

    }//GEN-LAST:event_btnDirectorioActionPerformed

    public void RecargarValores(int pAccion)
    {
        /*Asigno o limpio valores*/
//        id_tipo_permiso = FabricaLogica.getControladorTipoPermiso().VerSiguienteId();
//         this.txtIdTipoPermiso.setText("" + id_tipo_permiso);            
//         this.txtTitulo.setText("");
//         this.txtDescripcion.setText("");
//         this.txtDescAbreviada.setText("");
//         this.lblFuncionalidadEliminada.setText("");
        
         switch(pAccion)
            {
                case 0:
                 
                 /*Habilito o Deshabilito botones*/
                 this.clnFechaBaja.setVisible(false); 
                 this.lblFechaBaja.setVisible(false);
                 this.lblAsteriscoFechaBaja.setVisible(false);
                 this.txtNombreUsuario.setEnabled(true);
                 this.txtContrasenia.setEnabled(true);
                 this.txtDescripcion.setEnabled(true);
                 this.txtUbicacion.setEnabled(true);
                 this.txtArchivo.setEnabled(true);
                 
                 this.clnFechaAlta.setEnabled(true);
                 this.txtDescripcion.setForeground(Color.BLACK);   
                 this.clnFechaAlta.setForeground(Color.BLACK);
                 lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Alta de Usuario.png")));
                break;
//                case 1:
//                   this.txtIdTipoPermiso.setEnabled(true);
//                   this.btnBuscar.setEnabled(true);
//                   this.txtTitulo.setEnabled(false);
//                   this.txtDescripcion.setEnabled(false);
//                   this.txtDescAbreviada.setEnabled(false);
//                   this.clnFechaAlta.setEnabled(false);
//                   this.clnFechaBaja.setVisible(false);
//                   this.btnAceptar.setEnabled(false);
//                   this.txtTitulo.setForeground(Color.BLACK);
//                   this.txtDescripcion.setForeground(Color.BLACK);
//                   this.txtDescAbreviada.setForeground(Color.BLACK);
//                   this.clnFechaAlta.setForeground(Color.BLACK);
//                   this.lblFuncionalidadEliminada.setVisible(false);
//                   this.lblFuncionalidadEliminada.setText("");
//                   lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modificación de Tipo de Permiso.png")));
//                break;
//                case 2: 
//                 this.txtIdTipoPermiso.setEnabled(true);
//                 this.btnBuscar.setEnabled(true);
//                 this.txtTitulo.setEnabled(false);
//                 this.txtDescripcion.setEnabled(false);
//                 this.txtDescAbreviada.setEnabled(false);
//                 this.clnFechaAlta.setEnabled(false);
//                 this.clnFechaBaja.setVisible(true);
//                 this.btnAceptar.setEnabled(false);
//                 this.lblFechaBaja.setVisible(true);
//                 this.lblAsteriscoFechaBaja.setVisible(true);
//                 this.clnFechaBaja.setVisible(true);
//                 this.btnAceptar.setEnabled(false);
//                 this.txtTitulo.setForeground(Color.BLACK);
//                 this.txtDescripcion.setForeground(Color.BLACK);
//                 this.txtDescAbreviada.setForeground(Color.BLACK);
//                 this.clnFechaAlta.setForeground(Color.BLACK);
//                 this.clnFechaBaja.setForeground(Color.RED);
//                 this.lblFuncionalidadEliminada.setVisible(false);
//                 this.lblFuncionalidadEliminada.setText("");
//                 lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baja de Tipo de Permiso.png")));
//                break;
//               default:
//               this.lblFechaBaja.setVisible(true);
//               this.lblAsteriscoFechaBaja.setVisible(true);
//               this.clnFechaBaja.setVisible(true);
//               this.lblFuncionalidadEliminada.setVisible(false);
//               this.txtIdTipoPermiso.setEnabled(true);
//               this.btnBuscar.setEnabled(true);
//               this.txtTitulo.setEnabled(false);
//               this.txtDescripcion.setEnabled(false);
//               this.txtDescAbreviada.setEnabled(false);
//               this.clnFechaAlta.setEnabled(false);
//               this.clnFechaBaja.setEnabled(false);
//               this.btnAceptar.setEnabled(false);
//               this.clnFechaBaja.setForeground(Color.RED);
//               this.lblFuncionalidadEliminada.setText("");
//               lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reingreso de Tipo de Permiso.png")));
               
            }
    }
    
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
            java.util.logging.Logger.getLogger(AltaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDirectorio;
    private org.freixas.jcalendar.JCalendarCombo clnFechaAlta;
    private org.freixas.jcalendar.JCalendarCombo clnFechaBaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblAsteriscoFechaBaja;
    private javax.swing.JLabel lblAsteriscoFechaBaja1;
    private javax.swing.JLabel lblAsteriscoFechaBaja2;
    private javax.swing.JLabel lblAsteriscoFechaBaja3;
    private javax.swing.JLabel lblAsteriscoFechaBaja4;
    private javax.swing.JLabel lblAsteriscoFechaBaja5;
    private javax.swing.JLabel lblAsteriscoFechaBaja6;
    private javax.swing.JLabel lblAsteriscoFechaBaja7;
    private javax.swing.JLabel lblAsteriscoFechaBaja8;
    private javax.swing.JLabel lblFechaBaja;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblFuncionalidadEliminada;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBarra;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTextField txtArchivo;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JPasswordField txtRepetirContrasenia;
    private javax.swing.JTextArea txtUbicacion;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
