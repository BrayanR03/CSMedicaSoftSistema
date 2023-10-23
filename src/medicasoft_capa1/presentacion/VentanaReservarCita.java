package medicasoft_capa1.presentacion;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import medicasoft_capa2.aplicacion.ReservarCitaServicio;
import medicasoft_capa2.aplicacion.RegistrarHorarioDeAtencionServicio;
import medicasoft_capa2.aplicacion.RegistrarPacienteServicio;
import medicasoft_capa3.dominio.Cita;
import medicasoft_capa3.dominio.HorarioAtencion;
//import medicasoft_capa3.dominio.Horario;
import medicasoft_capa3.dominio.Paciente;
//import medicasoft_capa4.persistencia.CitaPostgreSQL;

/**
 *
 * @author Miguel
 */
public class VentanaReservarCita extends javax.swing.JDialog {
    
    int xMouse;
    int yMouse;

    DefaultTableModel modelo = new DefaultTableModel();
    private Cita cita;
    private static int usuarioid;
    private ReservarCitaServicio registrarCitaServicio;

    public VentanaReservarCita(java.awt.Frame parent, boolean modal, int idusuario) {
        super(parent, modal);
        this.setUndecorated(true);
        initComponents();
        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        AWTUtilities.setWindowShape(this, forma);
        setLocationRelativeTo(this);
        cambiarEstilosTextField();
        this.usuarioid = idusuario;
        inicializarNuevaCita();
        try {

            registrarCitaServicio.MostrarHorario(modelo, usuarioid);
            TableColumn columna = jTableHorario.getColumnModel().getColumn(6);
            columna.setMaxWidth(0);
            columna.setMinWidth(0);
            columna.setPreferredWidth(0);
            jTableHorario.doLayout();
        } catch (Exception e) {
        }
        jTableHorario.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if (Mouse_evt.getClickCount() == 1) {
                    txtIdHorarioAtencion.setText(jTableHorario.getValueAt(jTableHorario.getSelectedRow(), 0).toString());
                    txthorafin.setText(jTableHorario.getValueAt(jTableHorario.getSelectedRow(), 4).toString());
                    txtestadohorario.setText(jTableHorario.getValueAt(jTableHorario.getSelectedRow(), 1).toString());
                    txtfecha.setText(jTableHorario.getValueAt(jTableHorario.getSelectedRow(), 2).toString());
                    txthorainicio.setText(jTableHorario.getValueAt(jTableHorario.getSelectedRow(), 3).toString());
                    txtnombreodontologo.setText(jTableHorario.getValueAt(jTableHorario.getSelectedRow(), 5).toString());
                    txtcododontologo.setText(jTableHorario.getValueAt(jTableHorario.getSelectedRow(), 6).toString());

                }
            }

        });

    }
    
    private void cambiarEstilosTextField(){
        txtIdCita.setBorder(new LineBorder(Color.decode("#0097B2"), 1));
        txtestadocita.setBorder(new LineBorder(Color.decode("#0097B2"), 1));
        txtDniPaciente.setBorder(new LineBorder(Color.decode("#0097B2"), 1));
        txtNombrePaciente.setBorder(new LineBorder(Color.decode("#0097B2"), 1));
        txtIdHorarioAtencion.setBorder(new LineBorder(Color.decode("#0097B2"), 1));
        txtestadocita.setBorder(new LineBorder(Color.decode("#0097B2"), 1));
        txtfecha.setBorder(new LineBorder(Color.decode("#0097B2"), 1));
        txthorainicio.setBorder(new LineBorder(Color.decode("#0097B2"), 1));
        txthorafin.setBorder(new LineBorder(Color.decode("#0097B2"), 1));
        txtnombreodontologo.setBorder(new LineBorder(Color.decode("#0097B2"), 1));
    }

    private void inicializarNuevaCita() {
        registrarCitaServicio = new ReservarCitaServicio();
        try {
            int idSiguienteCita = registrarCitaServicio.MostrarID();
            txtIdCita.setText(String.valueOf(idSiguienteCita));
        } catch (Exception e) {
        }
        try {
            registrarCitaServicio.MostrarHorario(modelo, usuarioid);
        } catch (Exception e) {
        }
        cita = new Cita();
        txtDniPaciente.requestFocus();
        txtIdHorarioAtencion.setText("");
        txtfecha.setText("");
        txthorafin.setText("");
        txtestadohorario.setText("");
        txthorainicio.setText("");
        txtnombreodontologo.setText("");
        txtDniPaciente.setText("");
        txtNombrePaciente.setText("");
        txtidpaciente.setText("");
        txtidpaciente.setVisible(false);
        botonGuardar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtestadocita = new javax.swing.JTextField();
        txtIdCita = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtDniPaciente = new javax.swing.JTextField();
        botonBuscarPaciente = new javax.swing.JButton();
        txtNombrePaciente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtidpaciente = new javax.swing.JTextField();
        txtcododontologo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHorario = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        txtestadohorario = new javax.swing.JTextField();
        txtIdHorarioAtencion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txthorainicio = new javax.swing.JTextField();
        txthorafin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtnombreodontologo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRAR CITA");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/banner-top.png"))); // NOI18N
        jLabel1.setText("RESERVAR CITA");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtestadocita.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtestadocita.setText("Pendiente");
        jPanel2.add(txtestadocita, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 151, 30));

        txtIdCita.setEditable(false);
        txtIdCita.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtIdCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 151, 30));

        jLabel2.setText("ID CITA:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel3.setText("ESTADO:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 60, -1));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 300, 100));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("DNI DEL PACIENTE:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 120, -1));

        txtDniPaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtDniPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 110, 30));

        botonBuscarPaciente.setBackground(new java.awt.Color(0, 151, 178));
        botonBuscarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarPaciente.setText("BUSCAR");
        botonBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarPacienteActionPerformed(evt);
            }
        });
        jPanel3.add(botonBuscarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 123, -1));

        txtNombrePaciente.setEditable(false);
        txtNombrePaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtNombrePaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 260, 30));

        jLabel9.setText("NOMBRE DEL PACIENTE:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtidpaciente.setEditable(false);
        jPanel3.add(txtidpaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 345, 180, -1));
        jPanel3.add(txtcododontologo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 10, -1));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 450, 100));

        jSeparator1.setBackground(new java.awt.Color(166, 166, 166));
        jSeparator1.setForeground(new java.awt.Color(166, 166, 166));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 10, 98));

        jSeparator2.setBackground(new java.awt.Color(166, 166, 166));
        jSeparator2.setForeground(new java.awt.Color(166, 166, 166));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 800, -1));

        jTableHorario.setModel(modelo);
        jScrollPane1.setViewportView(jTableHorario);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 800, 180));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setForeground(new java.awt.Color(0, 151, 178));
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 140, 30));

        botonGuardar.setBackground(new java.awt.Color(0, 151, 178));
        botonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardar.setText("RESERVAR");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 164, 30));

        txtestadohorario.setEditable(false);
        jPanel4.add(txtestadohorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 100, 30));

        txtIdHorarioAtencion.setEditable(false);
        jPanel4.add(txtIdHorarioAtencion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 100, 30));

        jLabel10.setText(" ID HORARIO ATENCION");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabel13.setText("ESTADO");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, -1));

        jLabel12.setText("FECHA");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        txtfecha.setEditable(false);
        jPanel4.add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 120, 30));

        jLabel14.setText("HORA INICIO");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, -1, -1));

        txthorainicio.setEditable(false);
        jPanel4.add(txthorainicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 100, 30));

        txthorafin.setEditable(false);
        jPanel4.add(txthorafin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 100, 30));

        jLabel11.setText("HORA FIN");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, -1, -1));

        txtnombreodontologo.setEditable(false);
        txtnombreodontologo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtnombreodontologo, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 380, 110, 30));

        jLabel15.setText("ODONTOLOGO");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 350, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 890, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarPacienteActionPerformed
        String dniPaciente = txtDniPaciente.getText().trim();

        try {
            Paciente paciente = registrarCitaServicio.buscarPaciente(dniPaciente);
            cita.setPacienteID(paciente);
            txtNombrePaciente.setText(paciente.getPacienteNombres() + " " + paciente.getPacienteApellidos());
            txtidpaciente.setText(String.valueOf(paciente.getPacienteID()));
            activarBotonGuardar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            txtNombrePaciente.setText("");
            txtDniPaciente.requestFocus();
        }


    }//GEN-LAST:event_botonBuscarPacienteActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        try {
            capturarDatosDeCita();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            guardarCita();
            EnviaCorreoCita();
            inicializarNuevaCita();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Reservar La Cita : " + " " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_botonGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void guardarCita() throws Exception {
        registrarCitaServicio.GuardarCita(cita);
        registrarCitaServicio.MostrarHorario(modelo, usuarioid);
        JOptionPane.showMessageDialog(this, "Se reservo la cita", "Información", JOptionPane.INFORMATION_MESSAGE);

    }

    private void EnviaCorreoCita() throws Exception {

        String dni = txtDniPaciente.getText().trim();
        int idHorario = Integer.parseInt(txtIdHorarioAtencion.getText().trim());
        int idCita = Integer.parseInt(txtIdCita.getText().trim());
        registrarCitaServicio.EnviarCorreoCita(dni, idHorario, idCita);
        JOptionPane.showMessageDialog(this, "Datos de la Cita, enviados a su correo.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    private void capturarDatosDeCita() throws Exception {
        cita.setCitaID(Integer.parseInt(txtIdCita.getText().trim()));
        cita.setCitaEstado(txtestadocita.getText().trim());

        try {
            int IDHorarioAtencion = Integer.parseInt(txtIdHorarioAtencion.getText());

            HorarioAtencion horario = registrarCitaServicio.buscarHorario(IDHorarioAtencion);

            cita.setHorarioAtencionID(horario);
            activarBotonGuardar();
        } catch (Exception e) {
            throw new Exception("Debes seleccionar un horario de atencion", e);
        }

    }

    private void activarBotonGuardar() {
        if (cita.getPacienteID() != null) {
            botonGuardar.setEnabled(true);
        } else {
            botonGuardar.setEnabled(false);
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
            java.util.logging.Logger.getLogger(VentanaReservarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaReservarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaReservarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaReservarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaReservarCita dialog = new VentanaReservarCita(new javax.swing.JFrame(), true, usuarioid);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarPaciente;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableHorario;
    private javax.swing.JTextField txtDniPaciente;
    private javax.swing.JTextField txtIdCita;
    private javax.swing.JTextField txtIdHorarioAtencion;
    private javax.swing.JTextField txtNombrePaciente;
    private javax.swing.JTextField txtcododontologo;
    private javax.swing.JTextField txtestadocita;
    private javax.swing.JTextField txtestadohorario;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txthorafin;
    private javax.swing.JTextField txthorainicio;
    private javax.swing.JTextField txtidpaciente;
    private javax.swing.JTextField txtnombreodontologo;
    // End of variables declaration//GEN-END:variables
}
