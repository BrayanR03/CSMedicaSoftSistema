
package presentacion;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import aplicacion.RegistrarPagosServicio;
import dominio.Cita;
import dominio.FormaPago;
import dominio.Pagos;

public class VentanaRegistrarPagos extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    private Pagos pagos;
    private RegistrarPagosServicio registrarPagosServicio;
    private DefaultComboBoxModel<String> comboString;
    private DefaultComboBoxModel<FormaPago> formita;
    private FormaPago formaPago;
    private Cita cita;

    public VentanaRegistrarPagos() {
        initComponents();
        setLocationRelativeTo(null);
        inicializarNuevoPago();
        fechaActual();
        try {                       
            formita = registrarPagosServicio.comboFormaPago();
            comboString = new DefaultComboBoxModel<>();
            for (int i = 0; i < formita.getSize(); i++) {
                formaPago = formita.getElementAt(i);
                String nombreFormaPago = formaPago.getFormaPagoDescripcion();
                comboString.addElement(nombreFormaPago);
            }
            cboFormaPago.setModel(comboString);
            cboFormaPago.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedIndex = cboFormaPago.getSelectedIndex();
                    if (selectedIndex >= 0) {
                        formaPago = formita.getElementAt(selectedIndex);
                        String codigo = formaPago.getFormaPagoCodigo();
                        txtcodigoformapago.setText(codigo);
                    }
                }
            });

            add(cboFormaPago);
            add(txtcodigoformapago);

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        datosCitas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if (Mouse_evt.getClickCount() == 1) {
                    
                    txtidcita.setText(datosCitas.getValueAt(datosCitas.getSelectedRow(), 0).toString());
                    txtfecha.setText(datosCitas.getValueAt(datosCitas.getSelectedRow(), 1).toString());
                    txthorainicio.setText(datosCitas.getValueAt(datosCitas.getSelectedRow(), 2).toString());
                    txthorafin.setText(datosCitas.getValueAt(datosCitas.getSelectedRow(), 3).toString());
                    txtestadocita.setText(datosCitas.getValueAt(datosCitas.getSelectedRow(), 4).toString());
                    
                }
            }

        });
    }

    private void fechaActual() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate currentDate = LocalDate.now();
                String formattedDate = currentDate.format(dateFormatter);
                txtfechapago.setText(formattedDate);
            }
        });

        timer.start();
    }

    private void inicializarNuevoPago() {
        txtdnipaciente.requestFocus();
        
        txtcodigoformapago.setVisible(false);
        registrarPagosServicio = new RegistrarPagosServicio();
        pagos = new Pagos();
        formaPago = new FormaPago();
        cita = new Cita();
        txtdnipaciente.setText("");
        txtmontototal.setText("");
        txtcodigoformapago.setText("");
        cboFormaPago.setSelectedIndex(0);
        txtidcita.setText("");
        txtfecha.setText("");
        txthorainicio.setText("");
        txthorafin.setText("");
        txtestadocita.setText("");
        try {
             txtpagosid.setText(String.valueOf(registrarPagosServicio.siguienteIDPago()));
            registrarPagosServicio.mostrarCitasSinCancelar(modelo);
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtdnipaciente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        datosCitas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtidcita = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        txthorainicio = new javax.swing.JTextField();
        txthorafin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtestadocita = new javax.swing.JTextField();
        txtpagosid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtfechapago = new javax.swing.JTextField();
        cboFormaPago = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtmontototal = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        txtcodigoformapago = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nro Pago");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Citas"));

        jLabel2.setText("Dni Paciente:");

        txtdnipaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdnipacienteActionPerformed(evt);
            }
        });
        txtdnipaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdnipacienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdnipacienteKeyReleased(evt);
            }
        });

        datosCitas.setModel(modelo);
        jScrollPane1.setViewportView(datosCitas);

        jLabel3.setText("ID CITA");

        jLabel4.setText("FECHA");

        jLabel5.setText("HORA INICIO");

        jLabel6.setText("HORA FIN");

        txtidcita.setEditable(false);

        txtfecha.setEditable(false);

        txthorainicio.setEditable(false);

        txthorafin.setEditable(false);

        jLabel10.setText("ESTADO");

        txtestadocita.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(txtdnipaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtidcita, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txthorainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(txthorafin, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtestadocita)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(49, 49, 49))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtdnipaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtestadocita, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txthorafin, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txtidcita, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txtfecha)
                    .addComponent(txthorainicio))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        txtpagosid.setEditable(false);

        jLabel7.setText("Forma Pago");

        jLabel8.setText("Fecha:");

        txtfechapago.setEditable(false);

        cboFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboFormaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFormaPagoActionPerformed(evt);
            }
        });

        jLabel9.setText("Monto Total ");

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txtcodigoformapago.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboFormaPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcodigoformapago, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpagosid, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(185, 185, 185)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtfechapago, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(437, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel9)
                .addGap(26, 26, 26)
                .addComponent(txtmontototal, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpagosid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtcodigoformapago, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(btnRegistrar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtmontototal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtfechapago, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdnipacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdnipacienteKeyPressed

    }//GEN-LAST:event_txtdnipacienteKeyPressed

    private void cboFormaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFormaPagoActionPerformed


    }//GEN-LAST:event_cboFormaPagoActionPerformed

    private void txtdnipacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdnipacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdnipacienteActionPerformed

    private void txtdnipacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdnipacienteKeyReleased
        String dni = txtdnipaciente.getText();
        try {
            registrarPagosServicio.mostrarCitasSinCancelarDni(modelo, dni);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtdnipacienteKeyReleased

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            capturarDatosDePago();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            guardarPago();
            inicializarNuevoPago();          

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar La Cita : " + " " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void guardarPago() throws Exception {
        registrarPagosServicio.registrar(pagos);
        JOptionPane.showMessageDialog(this, "Se Registro El Pago", "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }

    private void capturarDatosDePago() throws Exception {
            pagos.setPagoID(Integer.parseInt(txtpagosid.getText().trim()));
            String fechaText = txtfechapago.getText().trim();
            Date fechita = Date.valueOf(fechaText);
            System.out.println("fecha " + fechita);
            pagos.setFechaPago(fechita);
            
            
            String codigoFormaPago = txtcodigoformapago.getText().trim();
            System.out.println("codigo fforma"+codigoFormaPago);
            if (codigoFormaPago.isEmpty()) {
                throw new Exception("Debes seleccionar una forma de pago");
            }
            formaPago = registrarPagosServicio.buscarFormaPago(codigoFormaPago);
            pagos.setFormaPagoCodigo(formaPago);
            
        try {
            int citaID = Integer.parseInt(txtidcita.getText().trim());
            System.out.println("cita de caja de texto "+citaID);
            cita = registrarPagosServicio.buscarCita(citaID);
            System.out.println("cita de linea 432 "+cita.getCitaID());
            pagos.setCitaID(cita);
            System.out.println("pagos con citaid capturada "+pagos.getCitaID().getCitaID());
        } catch (Exception e) {
            throw new Exception("Debes seleccionar una cita a pagar!",e);
        }
        try {
            double monto=Double.parseDouble(txtmontototal.getText().trim());
            pagos.setMontoTotal(monto);

        } catch (Exception e) {
            throw new Exception("Debes ingresar un monto",e);
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
            java.util.logging.Logger.getLogger(VentanaRegistrarPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistrarPagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboFormaPago;
    private javax.swing.JTable datosCitas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcodigoformapago;
    private javax.swing.JTextField txtdnipaciente;
    private javax.swing.JTextField txtestadocita;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtfechapago;
    private javax.swing.JTextField txthorafin;
    private javax.swing.JTextField txthorainicio;
    private javax.swing.JTextField txtidcita;
    private javax.swing.JTextField txtmontototal;
    private javax.swing.JTextField txtpagosid;
    // End of variables declaration//GEN-END:variables
}
