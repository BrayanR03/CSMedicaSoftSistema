package medicasoft_capa2.aplicacion;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import medicasoft_capa3.dominio.Cita;
//import medicasoft_capa3.dominio.Horario;
import medicasoft_capa3.dominio.Paciente;
import medicasoft_capa4.persistencia.AccesoDatosJDBC;
import medicasoft_capa4.persistencia.AccesoDatosJDBCPostgreSQL;
//import medicasoft_capa4.persistencia.CitaPostgreSQL;
//import medicasoft_capa4.persistencia.HorarioPostgreSQL;
//import medicasoft_capa4.persistencia.PacientePostgreSQL;

public class RegistrarCitaServicio {

   /* private AccesoDatosJDBC accesoDatosJDBC;
    private PacientePostgreSQL pacientePostgreSQL;
    private CitaPostgreSQL citaPostgreSQL;
    private HorarioPostgreSQL horarioPostgreSQL;

    public RegistrarCitaServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCPostgreSQL();
        pacientePostgreSQL = new PacientePostgreSQL(accesoDatosJDBC);
        citaPostgreSQL = new CitaPostgreSQL(accesoDatosJDBC);
        horarioPostgreSQL = new HorarioPostgreSQL(accesoDatosJDBC);

    }

    public Paciente buscarPaciente(String dni) throws Exception {

        accesoDatosJDBC.abrirConexion();
        Paciente paciente = pacientePostgreSQL.buscar(dni);
        accesoDatosJDBC.cerrarConexion();
        return paciente;
    }

    public Horario buscarHorario(String codigohorario) throws Exception {
        accesoDatosJDBC.abrirConexion();
        Horario horario = horarioPostgreSQL.buscar(codigohorario);
        accesoDatosJDBC.cerrarConexion();
        return horario;
    }
   

    public void MostrarHorario(DefaultTableModel modelo) throws Exception {

        accesoDatosJDBC.abrirConexion();
        
        horarioPostgreSQL.Mostrar(modelo);
        accesoDatosJDBC.cerrarConexion();

    }

    public void GuardarCita(Cita cita) throws Exception {
        if (!cita.montoTotalValido()) {
            throw new Exception("El monto total no es valido.");
        }

        Horario horario = cita.getHorario();
        
        accesoDatosJDBC.abrirConexion();
        int totalDeCitasAldia = citaPostgreSQL.consultarTotalDeCitasRegistradas(horario);
        
        if (!cita.permiteNuevaCita(totalDeCitasAldia)) {
            throw new Exception("El total de citas al día llego al limite.");
        }
        int totalDeCitasRegistradasPorPaciente=citaPostgreSQL.verificarNumeroDeCitasPaciente(cita);
        if(!cita.permiteNuevaCitaPaciente(totalDeCitasRegistradasPorPaciente)){
            throw new Exception("El Paciente ya tiene registrada una cita en esta fecha "+" "+horario.getFecha());
        }
        if (!citaPostgreSQL.verificarHorarioDisponible(horario)) {
            throw new Exception("El horario escogido no esta disponible");
        }
        
            accesoDatosJDBC.iniciarTransaccion();
            citaPostgreSQL.guardar(cita);
            
            citaPostgreSQL.desactivarEstado(horario);
            accesoDatosJDBC.terminarTransaccion();

        
    }*/
}
