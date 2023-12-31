
package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dominio.Empleado;
import dominio.Odontologo;
import dominio.Usuario;

public class OdontologoSqlServer {
    
    private AccesoDatosJDBC accesoDatosJDBC;
    private EmpleadoSqlServer empleadoSqlServer;
    
    public OdontologoSqlServer(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
        this.empleadoSqlServer=new EmpleadoSqlServer(accesoDatosJDBC);
    }

    
    public void registrarOdontologo(Odontologo odontologo){
        
        String insertSQL="EXEC RegistrarOdontologo @apellidos=?,@nombres=?,@fecha=?,@dni=?,@direccion=?,@telefono=?,@correo=?";
        PreparedStatement sentencia;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(insertSQL);
            sentencia.setString(1, odontologo.getOdontologoApellidos());
            sentencia.setString(2, odontologo.getOdontologoNombres());
            sentencia.setDate(3, odontologo.getOdontologoFechaNacimiento());
            sentencia.setString(4, odontologo.getOdontologoDni());
            sentencia.setString(5, odontologo.getOdontologoDireccion());
            sentencia.setString(6, odontologo.getOdontologoTelefono());
            sentencia.setString(7, odontologo.getOdontologoCorreo());
            sentencia.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR" +e.getMessage());
        }
        
    }
    public List<String> obtenerDNIOdontologo(Odontologo odontologo) throws Exception {
        String consultaSQL = "SELECT OdontologoDni FROM Odontologo WHERE OdontologoDni=?";
        PreparedStatement sentencia;
        List<String> dni = new ArrayList<>();
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, odontologo.getOdontologoDni());
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()) {
                dni.add(resultado.getString(1));
                
            }
        } catch (Exception e) {
            throw new Exception("Error al verificar si existe el dni");
        }
        return dni;
    }
    
    public Odontologo buscar(String dni) throws SQLException {
        String consultaSQL = "SELECT O.OdontologoID,O.OdontologoApellidos,O.OdontologoNombres,O.OdontologoFechaNacimiento,O.OdontologoDni,\n" +
                             "O.OdontologoDireccion,O.OdontologoTelefono,O.OdontologoCorreo,e.EmpleadoID as Empleado\n" +
                             "FROM Odontologo O INNER JOIN Empleado E ON e.EmpleadoID=O.EmpleadoID\n" +
                             "WHERE OdontologoDni=?";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, dni);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                Odontologo odontologo = new Odontologo();
                odontologo.setOdontologoID(resultado.getInt("OdontologoID"));
                odontologo.setOdontologoApellidos(resultado.getString("OdontologoApellidos"));
                odontologo.setOdontologoNombres(resultado.getString("OdontologoNombres"));
                odontologo.setOdontologoFechaNacimiento(resultado.getDate("OdontologoFechaNacimiento"));
                odontologo.setOdontologoDni(dni);
                odontologo.setOdontologoDireccion(resultado.getString("OdontologoDireccion"));
                odontologo.setOdontologoTelefono(resultado.getString("OdontologoTelefono"));
                odontologo.setOdontologoCorreo(resultado.getString("OdontologoCorreo"));
                Empleado empleado=empleadoSqlServer.buscarEmpleado(resultado.getInt("Empleado"));
                odontologo.setEmpleadoID(empleado);
                return odontologo;
            }
            else {
                throw new SQLException("No existe el odontologo.");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al intentar buscar el odontologo." + e.getMessage());
        }
    }
    
    public int odontologoIDSiguiente(){
        
        String consultaSQL="SELECT ISNULL(MAX(OdontologoID),0)+ 1 AS OdontologoID FROM ODONTOLOGO";
        PreparedStatement sentencia;
        int idOdontologo=0;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(consultaSQL);
            ResultSet resultado=sentencia.executeQuery();
            if(resultado.next()){
                idOdontologo=resultado.getInt("OdontologoID");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idOdontologo;
    }
    
    public Usuario datosUsuarioOdontologo(int idOdontologo)throws Exception{
        String consultaSQL="EXEC BusquedaUsuarioOdontologo @idOdontologo=?";
        PreparedStatement sentencia;
        Usuario usuaario=new Usuario();
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setInt(1, idOdontologo);
            ResultSet resultado=sentencia.executeQuery();
            if(resultado.next()){
                int idUsuario=resultado.getInt("UsuarioID");
                String usuarioTabla=resultado.getString("Usuario");
                String password=resultado.getString("Password");
                usuaario=new Usuario(idUsuario,usuarioTabla,password);
            }
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        return usuaario;
    }
}
