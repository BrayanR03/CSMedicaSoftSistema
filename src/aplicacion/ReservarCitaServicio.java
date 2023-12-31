package aplicacion;

import persistencia.HorarioAtencionSqlServer;
import persistencia.CitaSqlServer;
import persistencia.PacienteSqlServer;
import javax.swing.table.DefaultTableModel;
import dominio.Cita;
import dominio.HorarioAtencion;
import dominio.Paciente;
import persistencia.AccesoDatosJDBC;
import persistencia.AccesoDatosJDBCSqlServer;
import utils.EnviarCorreo;
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
   

    public void mostrarHorario(DefaultTableModel modelo,int usuarioid) throws Exception {

        accesoDatosJDBC.abrirConexion();
        
        horarioAtencionSqlServer.mostrar(modelo,usuarioid);
        accesoDatosJDBC.cerrarConexion();

    }

    public void guardarCita(Cita cita) throws Exception {
        
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
    
    public int mostrarID()throws Exception{
        accesoDatosJDBC.abrirConexion();
        int idCita=citaSqlServer.siguienteCita();
        accesoDatosJDBC.cerrarConexion();
        return idCita;
    }
    
    
    public void enviarCorreoCita(String dniPaciente,int idHorarioAtencion,int idCita)throws Exception{
        
        accesoDatosJDBC.abrirConexion();
        HorarioAtencion horario=horarioAtencionSqlServer.buscar(idHorarioAtencion);
        Paciente paciente=pacienteSqlServer.buscar(dniPaciente);        
        accesoDatosJDBC.cerrarConexion();
        String asunto="Cita Pendiente";
        String mensaje="Estimado: "+paciente.getPacienteNombres()+" "+paciente.getPacienteApellidos()+"\n"
                       +"Tiene una cita registrada!\n"
                       +"Nro Cita: "+idCita+"\n"
                       + "Fecha: "+horario.getHorarioAtencionFechaRegistro()+"\n"
                       + "Hora Inicio: "+horario.getHorarioAtencionHoraInicio()+"\n"
                       + "Hora Fin: "+horario.getHorarioAtencionHoraFin()+"\n"
                       + "Gracias!";        
        String correo = paciente.getPacienteCorreo();
        
        EnviarCorreo.enviarCorreo(correo, asunto, mensaje);                               
    }
}
