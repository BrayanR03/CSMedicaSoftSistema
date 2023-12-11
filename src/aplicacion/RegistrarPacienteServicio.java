
package aplicacion;


import java.util.List;
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
    
    public int retornoID()throws Exception{
        accesoDatosJDBC.abrirConexion();
        int id=pacienteSqlServer.pacienteIDSiguiente();
        accesoDatosJDBC.cerrarConexion();
        return id;
    }
}
