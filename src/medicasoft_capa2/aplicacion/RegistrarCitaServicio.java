package medicasoft_capa2.aplicacion;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import medicasoft_capa3.dominio.Cita;
import medicasoft_capa3.dominio.HorarioAtencion;
//import medicasoft_capa3.dominio.Horario;
import medicasoft_capa3.dominio.Paciente;
import medicasoft_capa4.persistencia.AccesoDatosJDBC;
import medicasoft_capa4.persistencia.AccesoDatosJDBCSqlServer;
import medicasoft_capa4.persistencia.*;
public class RegistrarCitaServicio {

    private AccesoDatosJDBC accesoDatosJDBC;
    private PacienteSqlServer pacienteSqlServer;
    private CitaSqlServer citaSqlServer;
    private HorarioAtencionSqlServer horarioAtencionSqlServer;

    public RegistrarCitaServicio() {
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
}
