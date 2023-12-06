
package aplicacion;

import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import dominio.Odontologo;
import dominio.Usuario;
import persistencia.AccesoDatosJDBC;
import persistencia.AccesoDatosJDBCSqlServer;
import persistencia.OdontologoSqlServer;

public class RegistrarOdontologoServicio {
    private AccesoDatosJDBC accesoDatosJDBC;
    private OdontologoSqlServer odontologoSqlServer;

    public RegistrarOdontologoServicio() {
        accesoDatosJDBC =new AccesoDatosJDBCSqlServer();
        odontologoSqlServer=new OdontologoSqlServer(accesoDatosJDBC);
    }
    
    
    public void guardar(Odontologo odontologo)throws Exception{
    
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        List<String> dniod = odontologoSqlServer.obtenerDNIOdontologo(odontologo);

        if (odontologo.tieneDniUnicoOdontologo(dniod)) {
            throw new Exception("Ya esta registrado este dni en la base de datos ");
        }
        odontologoSqlServer.registrarOdontologo(odontologo);
        accesoDatosJDBC.terminarTransaccion();
    }
    
    public int retornarID()throws Exception{
    
        accesoDatosJDBC.abrirConexion();
        
        int idSiguiente=odontologoSqlServer.odontologoIDSiguiente();
        accesoDatosJDBC.cerrarConexion();
        return idSiguiente;
    }
    public void enviarCorreo(int idOdontologo,String correo)throws Exception{
        
        accesoDatosJDBC.abrirConexion();
        Usuario usuarioto=odontologoSqlServer.datosUsuarioOdontologo(idOdontologo);
        accesoDatosJDBC.cerrarConexion();
        String asunto="Datos Usuario Odontologo";
        String mensaje="Felicidades, ya tienes una cuenta de usuario!!."
                       + "Usuario ID: "+usuarioto.getUsuarioID()
                       + "Usuario: "+usuarioto.getUsuario()
                       + "Password: "+usuarioto.getPassword();
                       
        try {
            //PropiedadesCorreoJava
            Properties props=new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            
            Session session= Session.getDefaultInstance(props);
            //DatosCorreo
            String correoRemitente = "bryanneciosup626@gmail.com";
            String passwordRemitente = "pwaifdslersttfsm";
            
            
             javax.mail.internet.MimeBodyPart texto = new javax.mail.internet.MimeBodyPart();
            texto.setContent(mensaje, "text/html");
            javax.mail.internet.MimeMultipart miltiParte = new javax.mail.internet.MimeMultipart();
            miltiParte.addBodyPart(texto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            message.setSubject(asunto);
            message.setContent(miltiParte);
            
            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
        } catch (AddressException ex) {
            Logger.getLogger(RegistrarPacienteServicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(RegistrarPacienteServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
