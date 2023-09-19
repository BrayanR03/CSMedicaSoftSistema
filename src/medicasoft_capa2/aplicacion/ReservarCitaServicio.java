package medicasoft_capa2.aplicacion;

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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import medicasoft_capa3.dominio.Cita;
import medicasoft_capa3.dominio.HorarioAtencion;
//import medicasoft_capa3.dominio.Horario;
import medicasoft_capa3.dominio.Paciente;
import medicasoft_capa3.dominio.Usuario;
import medicasoft_capa4.persistencia.AccesoDatosJDBC;
import medicasoft_capa4.persistencia.AccesoDatosJDBCSqlServer;
import medicasoft_capa4.persistencia.*;
public class ReservarCitaServicio {

    private AccesoDatosJDBC accesoDatosJDBC;
    private PacienteSqlServer pacienteSqlServer;
    private CitaSqlServer citaSqlServer;
    private HorarioAtencionSqlServer horarioAtencionSqlServer;

    public ReservarCitaServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCSqlServer();
        pacienteSqlServer = new PacienteSqlServer(accesoDatosJDBC);
        citaSqlServer = new CitaSqlServer(accesoDatosJDBC);
        horarioAtencionSqlServer= new HorarioAtencionSqlServer(accesoDatosJDBC);

    }

    public Paciente buscarPaciente(String dni) throws Exception {

        accesoDatosJDBC.abrirConexion();
        Paciente paciente = pacienteSqlServer.buscar(dni);
        accesoDatosJDBC.cerrarConexion();
        return paciente;
    }

    public HorarioAtencion buscarHorario(int idhorario) throws Exception {
        accesoDatosJDBC.abrirConexion();
        HorarioAtencion horario = horarioAtencionSqlServer.buscar(idhorario);
        accesoDatosJDBC.cerrarConexion();
        return horario;
    }
   

    public void MostrarHorario(DefaultTableModel modelo) throws Exception {

        accesoDatosJDBC.abrirConexion();
        
        horarioAtencionSqlServer.Mostrar(modelo);
        accesoDatosJDBC.cerrarConexion();

    }

    public void GuardarCita(Cita cita) throws Exception {
        
        HorarioAtencion horario = cita.getHorarioAtencionID();
        
        accesoDatosJDBC.abrirConexion();
        int totalDeCitasAldia = citaSqlServer.consultarTotalDeCitasRegistradas(horario);
        
        if (!cita.permiteNuevaCita(totalDeCitasAldia)) {
            throw new Exception("El total de citas al día llego al limite.");
        }
        int totalDeCitasRegistradasPorPaciente=citaSqlServer.verificarNumeroDeCitasPaciente(cita);
        if(!cita.permiteNuevaCitaPaciente(totalDeCitasRegistradasPorPaciente)){
            throw new Exception("El Paciente ya tiene registrada una cita en esta fecha "+" "+horario.getHorarioAtencionFechaRegistro());
        }
        if (!citaSqlServer.verificarHorarioDisponible(horario)) {
            throw new Exception("El horario escogido no esta disponible");
        }
        
            accesoDatosJDBC.iniciarTransaccion();
            citaSqlServer.guardar(cita);
            
            accesoDatosJDBC.terminarTransaccion();

       
    }
    
    public int MostrarID()throws Exception{
        accesoDatosJDBC.abrirConexion();
        int idCita=citaSqlServer.SiguienteCita();
        accesoDatosJDBC.cerrarConexion();
        return idCita;
    }
    
    
    public void EnviarCorreoCita(String dniPaciente,int idHorarioAtencion,int idCita)throws Exception{
        
        accesoDatosJDBC.abrirConexion();
        HorarioAtencion horario=horarioAtencionSqlServer.buscar(idHorarioAtencion);
        Paciente paciente=pacienteSqlServer.buscar(dniPaciente);
        Cita cita=citaSqlServer.BuscarCita(idCita);
        accesoDatosJDBC.cerrarConexion();
        String asunto="Cita Pendiente";
        String mensaje="Estimado: "+paciente.getPacienteNombres()+" "+paciente.getPacienteApellidos()+"\n"
                       +"Tiene una cita registrada!\n"
                       +"Nro Cita: "+cita.getCitaID()+"\n"
                       + "Fecha: "+horario.getHorarioAtencionFechaRegistro()+"\n"
                       + "Hora Inicio: "+horario.getHorarioAtencionHoraInicio()+"\n"
                       + "Hora Fin: "+horario.getHorarioAtencionHoraFin()+"\n"
                       + "Gracias!";
        
                       
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

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(paciente.getPacienteCorreo()));
            message.setSubject(asunto);
            message.setContent(miltiParte);
            
            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
        } catch (AddressException ex) {
            Logger.getLogger(ReservarCitaServicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ReservarCitaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
