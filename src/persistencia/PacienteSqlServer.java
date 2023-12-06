
package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dominio.Paciente;

/**
 *
 * @author USER
 */
public class PacienteSqlServer {
    
    private AccesoDatosJDBC accesoDatosJDBC;

    public PacienteSqlServer(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC=accesoDatosJDBC;
    }
    
    public void registrarPaciente(Paciente paciente){
        
        String insertSQL="INSERT INTO Paciente(PacienteApellidos,PacienteNombres,PacienteFechaNacimiento,PacienteDni,PacienteTelefono,PacienteDireccion,PacienteCorreo)\n" +
                         "VALUES(?,?,?,?,?,?,?)";
        PreparedStatement sentencia;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(insertSQL);
            sentencia.setString(1, paciente.getPacienteApellidos());
            sentencia.setString(2, paciente.getPacienteNombres());
            sentencia.setDate(3, paciente.getPacienteFechaNacimiento());
            sentencia.setString(4, paciente.getPacienteDni());
            sentencia.setString(5, paciente.getPacienteTelefono());
            sentencia.setString(6, paciente.getPacienteDireccion());
            sentencia.setString(7, paciente.getPacienteCorreo());
            sentencia.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<String> obtenerDNIPaciente(Paciente paciente) throws Exception {
        String consultaSQL = "SELECT PacienteDni FROM Paciente WHERE PacienteDni=?";
        PreparedStatement sentencia;
        List<String> horas = new ArrayList<>();
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, paciente.getPacienteDni());
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()) {
                horas.add(resultado.getString(1));
                
            }
        } catch (Exception e) {
            throw new Exception("Error al verificar si existe el dni");
        }
        return horas;
    }
    public Paciente buscar(String PacienteDni) throws Exception {
        String consultaSQL = "SELECT PacienteID,PacienteApellidos,PacienteNombres,PacienteFechaNacimiento,PacienteDni,PacienteTelefono,PacienteDireccion,PacienteCorreo"
                + " FROM Paciente WHERE PacienteDni=?";
        PreparedStatement sentencia;        
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, PacienteDni);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                Paciente paciente = new Paciente();
                paciente.setPacienteDni(PacienteDni);
                paciente.setPacienteID(resultado.getInt("PacienteID"));
                paciente.setPacienteApellidos(resultado.getString("PacienteApellidos"));
                paciente.setPacienteNombres(resultado.getString("PacienteNombres"));
                paciente.setPacienteFechaNacimiento(resultado.getDate("PacienteFechaNacimiento"));
                paciente.setPacienteDni(resultado.getString("PacienteDni"));
                paciente.setPacienteTelefono(resultado.getString("PacienteTelefono"));
                paciente.setPacienteDireccion(resultado.getString("PacienteDireccion"));
                paciente.setPacienteCorreo(resultado.getString("PacienteCorreo"));
               
                return paciente;
            }
            else {
                throw new Exception("No existe el paciente.");
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar buscar el paciente.", e);
        }
    }
    public Paciente buscarIdPaciente(int idPaciente) throws Exception {
        String consultaSQL = "SELECT PacienteDni,PacienteApellidos,PacienteNombres,PacienteFechaNacimiento,PacienteDni,PacienteTelefono,PacienteDireccion,PacienteCorreo"
                + " FROM Paciente WHERE PacienteID=?";
        PreparedStatement sentencia;        
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setInt(1, idPaciente);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                Paciente paciente = new Paciente();
                paciente.setPacienteDni("PacienteDni");
                paciente.setPacienteID(idPaciente);
                paciente.setPacienteApellidos(resultado.getString("PacienteApellidos"));
                paciente.setPacienteNombres(resultado.getString("PacienteNombres"));
                paciente.setPacienteFechaNacimiento(resultado.getDate("PacienteFechaNacimiento"));
                paciente.setPacienteDni(resultado.getString("PacienteDni"));
                paciente.setPacienteTelefono(resultado.getString("PacienteTelefono"));
                paciente.setPacienteDireccion(resultado.getString("PacienteDireccion"));
                paciente.setPacienteCorreo(resultado.getString("PacienteCorreo"));
               
                return paciente;
            }
            else {
                throw new Exception("No existe el paciente.");
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar buscar el paciente.", e);
        }
    }
    
    public int pacienteIDSiguiente()throws Exception{
        
        String consultaSQL="SELECT ISNULL(MAX(PacienteID),0)+1 as PacienteID FROM Paciente";
//        String consultaSQL="SELECT IFNULL(MAX(PacienteID),0)+1as PacienteID FROM Paciente";
        PreparedStatement sentencia;
        int id=0;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(consultaSQL);
            ResultSet resultado=sentencia.executeQuery();
            if(resultado.next()){
                id=resultado.getInt("PacienteID");
            }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
        return id;
    }
    
    
}
