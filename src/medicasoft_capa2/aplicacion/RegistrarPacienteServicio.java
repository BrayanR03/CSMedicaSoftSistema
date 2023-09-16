
package medicasoft_capa2.aplicacion;

import java.util.List;
import medicasoft_capa3.dominio.Paciente;
import medicasoft_capa4.persistencia.AccesoDatosJDBC;
import medicasoft_capa4.persistencia.AccesoDatosJDBCSqlServer;
import medicasoft_capa4.persistencia.PacienteSqlServer;


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
        
        
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        List<String> dnipac = pacienteSqlServer.obtenerDNIPaciente(paciente);

        if (paciente.TieneDniUnicoPaciente(dnipac)) {
            throw new Exception("Ya esta registrado este dni en la base de datos");
        }
        pacienteSqlServer.RegistrarPaciente(paciente);
        accesoDatosJDBC.terminarTransaccion();
        
    }
}
