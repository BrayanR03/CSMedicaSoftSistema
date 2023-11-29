
package medicasoft_capa1.presentacion;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class VentanaMenu extends javax.swing.JFrame {


    private static int usuarioIDlogin;
    FondoPanel fondo=new FondoPanel();
    public VentanaMenu(int usuarioIDlogin) {
        this.usuarioIDlogin=usuarioIDlogin;
        initComponents();
        this.setContentPane(fondo);
        System.out.println("ID USUARIO EN LA INTERFAZ DEL MENU "+usuarioIDlogin);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuPaciente = new javax.swing.JMenuItem();
        menuOdontologo = new javax.swing.JMenuItem();
        menuHorarioDeAtencion = new javax.swing.JMenuItem();
        menuCita = new javax.swing.JMenuItem();
        menuPagos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA MEDICASOFT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
        );

        jMenu1.setText("Administración");

        menuPaciente.setText("Registrar Paciente");
        menuPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPacienteActionPerformed(evt);
            }
        });
        jMenu1.add(menuPaciente);

        menuOdontologo.setText("Registrar Odontólogo");
        menuOdontologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOdontologoActionPerformed(evt);
            }
        });
        jMenu1.add(menuOdontologo);

        menuHorarioDeAtencion.setText("Registrar Horario De Atencion");
        menuHorarioDeAtencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHorarioDeAtencionActionPerformed(evt);
            }
        });
        jMenu1.add(menuHorarioDeAtencion);

        menuCita.setText("Reservar Cita");
        menuCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCitaActionPerformed(evt);
            }
        });
        jMenu1.add(menuCita);

        menuPagos.setText("Registrar Pagos");
        menuPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPagosActionPerformed(evt);
            }
        });
        jMenu1.add(menuPagos);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(712, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPacienteActionPerformed
        VentanaRegistrarPaciente formRegistrarPaciente = new VentanaRegistrarPaciente(this, true);
        formRegistrarPaciente.setVisible(true);
    }//GEN-LAST:event_menuPacienteActionPerformed

    private void menuOdontologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOdontologoActionPerformed
        VentanaRegistrarOdontologo formRegistrarOdontologo = new VentanaRegistrarOdontologo(this, true);
        formRegistrarOdontologo.setVisible(true);
    }//GEN-LAST:event_menuOdontologoActionPerformed

    private void menuHorarioDeAtencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHorarioDeAtencionActionPerformed
        VentanaRegistrarHorarioDeAtencion formRegistrarHorarioDeAtencion = new VentanaRegistrarHorarioDeAtencion(this, true);
        formRegistrarHorarioDeAtencion.setVisible(true);
    }//GEN-LAST:event_menuHorarioDeAtencionActionPerformed

    private void menuCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCitaActionPerformed
        VentanaReservarCita formRegistrarCita = new VentanaReservarCita(this, true,usuarioIDlogin);
        formRegistrarCita.setVisible(true);
    }//GEN-LAST:event_menuCitaActionPerformed

    private void menuPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPagosActionPerformed
        VentanaRegistrarPagos menuPago=new VentanaRegistrarPagos();
        menuPago.setVisible(true);
    }//GEN-LAST:event_menuPagosActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMenu(usuarioIDlogin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuCita;
    private javax.swing.JMenuItem menuHorarioDeAtencion;
    private javax.swing.JMenuItem menuOdontologo;
    private javax.swing.JMenuItem menuPaciente;
    private javax.swing.JMenuItem menuPagos;
    // End of variables declaration//GEN-END:variables
    class FondoPanel extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
           imagen = new ImageIcon(getClass().getResource("/imagenes/IMAGEN_PRINCIPAL.jpg")).getImage();
           
           g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
           
           setOpaque(false);
           super.paint(g);
        }        
    }    

}
