
package aplicacion;


//import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeMultipart;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.activation.DataHandler;
//import javax.activation.FileDataSource;


import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import dominio.Paciente;
import persistencia.AccesoDatosJDBC;
import persistencia.AccesoDatosJDBCSqlServer;
import persistencia.PacienteSqlServer;


public class RegistrarPacienteServicio {
    private AccesoDatosJDBC accesoDatosJDBC;
    private PacienteSqlServer pacienteSqlServer;

    public RegistrarPacienteServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCSqlServer();
        pacienteSqlServer = new PacienteSqlServer(accesoDatosJDBC);
    }
    
    public void guardarPaciente(Paciente paciente) throws Exception{
        
        if(!paciente.tieneEdadValida()){
            throw new Exception("La edad no es valida, tiene que ser mayor a 7");
        }
        
        if(!paciente.tieneDniValido()){
            throw new Exception("El DNI no es válido");
        }
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        List<String> dnipac = pacienteSqlServer.obtenerDNIPaciente(paciente);

        if (paciente.tieneDniUnicoPaciente(dnipac)) {
            throw new Exception("El paciente con el DNI ingresado ya se encuentra registrado");
        }
        pacienteSqlServer.registrarPaciente(paciente);
        accesoDatosJDBC.terminarTransaccion();
        
    }
    
    public void enviarCorreo(String correo,String asunto,String mensaje){
    
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
    
    public int retornoID()throws Exception{
        accesoDatosJDBC.abrirConexion();
        int id=pacienteSqlServer.pacienteIDSiguiente();
        accesoDatosJDBC.cerrarConexion();
        return id;
    }
}
