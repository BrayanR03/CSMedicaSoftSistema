
package presentacion;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import aplicacion.RegistrarHorarioDeAtencionServicio;
import dominio.Odontologo;
import java.sql.*;
import dominio.HorarioAtencion;

public class VentanaRegistrarHorarioDeAtencion extends javax.swing.JDialog {

    
    private RegistrarHorarioDeAtencionServicio registrarHorarioDeAtencionServicio;
    private HorarioAtencion horario;
    public VentanaRegistrarHorarioDeAtencion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        txtIdHorarioAtencion.setEditable(false);
        inicializarNuevoHorario();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdHorarioAtencion = new javax.swing.JTextField();
        txthorainicio = new javax.swing.JTextField();
        txtestado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdniodontologo = new javax.swing.JTextField();
        botonBuscarOdontologo = new javax.swing.JButton();
        txtnombresodontologo = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        txtfecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txthorafin = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRAR HORARIOS DE ATENCION");

        jLabel2.setText("ID HORARIO ATENCION");

        jLabel4.setText("FECHA");

        jLabel5.setText("HORA INICIO");

        jLabel6.setText("ESTADO");

        txtestado.setEditable(false);
        txtestado.setText("DISPONIBLE");

        jLabel7.setText("DNI ODONTOLOGO");

        botonBuscarOdontologo.setText("BUSCAR");
        botonBuscarOdontologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarOdontologoActionPerformed(evt);
            }
        });

        txtnombresodontologo.setEditable(false);

        botonGuardar.setText("REGISTRAR HORARIO");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        jLabel3.setText("HORA FIN");

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE HORARIO DE ATENCION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30)
                        .addComponent(txtdniodontologo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(botonBuscarOdontologo)
                        .addGap(36, 36, 36)
                        .addComponent(txtnombresodontologo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(botonGuardar)
                        .addGap(91, 91, 91)
                        .addComponent(btnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdHorarioAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txthorainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txthorafin, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdHorarioAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthorainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthorafin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7))
                    .addComponent(txtdniodontologo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarOdontologo)
                    .addComponent(txtnombresodontologo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(btnSalir))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarOdontologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarOdontologoActionPerformed
        
        String dniodontologo=txtdniodontologo.getText();
        try {
            Odontologo odontologo=registrarHorarioDeAtencionServicio.buscar(dniodontologo);
            horario.setOdontologoID(odontologo);
            txtnombresodontologo.setText(odontologo.getOdontologoNombres()+" "+odontologo.getOdontologoApellidos());
            activarBotonGuardar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            txtnombresodontologo.setText("");
            txtdniodontologo.requestFocus();
        }
        
    }//GEN-LAST:event_botonBuscarOdontologoActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed

        try {
            capturarDatosHorario();           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error de ingreso de datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            guardarHorario();
            inicializarNuevoHorario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);        
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    
    private void guardarHorario() throws Exception, HeadlessException {
        registrarHorarioDeAtencionServicio.guardar(horario);
        JOptionPane.showMessageDialog(this, "Se guardo el horario", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    private void capturarDatosHorario()throws NumberFormatException{
        String fecha=txtfecha.getText().trim();
        Date date= Date.valueOf(fecha);
        horario.setHorarioAtencionID(Integer.parseInt(txtIdHorarioAtencion.getText()));
        horario.setHorarioAtencionEstado(txtestado.getText().trim());
        horario.setHorarioAtencionFechaRegistro(date);
        horario.setHorarioAtencionHoraInicio(txthorainicio.getText().trim());
        horario.setHorarioAtencionHoraFin(txthorafin.getText().trim());                
    }
    
    
    public void inicializarNuevoHorario(){        
        registrarHorarioDeAtencionServicio=new RegistrarHorarioDeAtencionServicio();
        horario=new HorarioAtencion();
        txthorafin.setText("");
        txthorainicio.setText("");
        txtfecha.setText("");
        txtdniodontologo.setText("");
        txtnombresodontologo.setText("");
        botonGuardar.setEnabled(false);
        txtfecha.requestFocus();
        try {
            int id=registrarHorarioDeAtencionServicio.idSiguiente();
            txtIdHorarioAtencion.setText(String.valueOf(id));            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }                
    }
    
  
    private void activarBotonGuardar() {
        if (horario.getOdontologoID() != null) {
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
            java.util.logging.Logger.getLogger(VentanaRegistrarHorarioDeAtencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarHorarioDeAtencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarHorarioDeAtencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarHorarioDeAtencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaRegistrarHorarioDeAtencion dialog = new VentanaRegistrarHorarioDeAtencion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botonBuscarOdontologo;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtIdHorarioAtencion;
    private javax.swing.JTextField txtdniodontologo;
    private javax.swing.JTextField txtestado;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txthorafin;
    private javax.swing.JTextField txthorainicio;
    private javax.swing.JTextField txtnombresodontologo;
    // End of variables declaration//GEN-END:variables
}
