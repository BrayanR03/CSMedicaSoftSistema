
package medicasoft_capa2.aplicacion;

import java.util.List;
import medicasoft_capa3.dominio.Paciente;
import medicasoft_capa4.persistencia.AccesoDatosJDBC;
import medicasoft_capa4.persistencia.AccesoDatosJDBCPostgreSQL;


public class RegistrarPacienteServicio {
   /* private AccesoDatosJDBC accesoDatosJDBC;
    private PacientePostgreSQL pacientePostgreSQL;

    public RegistrarPacienteServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCPostgreSQL();
        pacientePostgreSQL = new PacientePostgreSQL(accesoDatosJDBC);
    }
    
    public void guardarPaciente(Paciente paciente) throws Exception{
        if(!paciente.tieneEdadValida()){
            throw new Exception("La edad no es valida, tiene que ser mayor a 7");
        }
        
        
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        List<String> dnipac = pacientePostgreSQL.obtenerDNIPaciente(paciente);

        if (paciente.TieneDniUnicoPaciente(dnipac)) {
            throw new Exception("Ya esta registrado este dni en la base de datos");
        }
        pacientePostgreSQL.guardar(paciente);
        accesoDatosJDBC.terminarTransaccion();
        
    }*/
}
