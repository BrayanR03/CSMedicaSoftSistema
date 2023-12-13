
package persistencia;

import java.sql.*;
import dominio.Empleado;
import dominio.Usuario;

public class EmpleadoSqlServer {
    
    private AccesoDatosJDBC accesoDatosJDBC;
    private UsuarioSqlServer usuarioSqlServer;
    
    public EmpleadoSqlServer(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
        this.usuarioSqlServer=new UsuarioSqlServer(accesoDatosJDBC);
    }
    
    
    public Empleado buscarEmpleado(int idEmpleado){
    
        String consultaSQL="SELECT EmpleadoID,EmpleadoDescripcion,UsuarioID\n" +
                            "FROM Empleado\n" +
                            "WHERE EmpleadoID=?";
        PreparedStatement sentencia;
        Empleado empleado=null;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setInt(1, idEmpleado);
            ResultSet resultado=sentencia.executeQuery();
            if(resultado.next()){
            
                String descripcion=resultado.getString("EmpleadoDescripcion");
                Usuario usuario=usuarioSqlServer.buscarUsuario(resultado.getInt("UsuarioID"));
                empleado=new Empleado(idEmpleado,descripcion,usuario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return empleado;
        
    }
    
    public String descripcionEmpleado(int idUsuario)throws SQLException{
        
        String descripcion="";
        String consultaSQL="SELECT E.EmpleadoDescripcion AS Descripcion\n" +
                            "FROM Usuario U INNER JOIN Empleado E\n" +
                            "ON U.UsuarioID=E.UsuarioID\n" +
                            "WHERE U.UsuarioID=?";
        
        PreparedStatement sentencia;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setInt(1, idUsuario);
            ResultSet resultado=sentencia.executeQuery();
            if(resultado.next()){
                descripcion=resultado.getString("Descripcion");
            }
        } catch (SQLException e) {
            throw new SQLException("Error Al Capturar La Descripcion",e);
        }
        return descripcion;
    }
    

}
