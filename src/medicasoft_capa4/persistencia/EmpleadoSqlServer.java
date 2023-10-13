/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa4.persistencia;

import java.sql.*;
import medicasoft_capa3.dominio.Empleado;
import medicasoft_capa3.dominio.Usuario;

/**
 *
 * @author USER
 */
public class EmpleadoSqlServer {
    
    private AccesoDatosJDBC accesoDatosJDBC;
    private UsuarioSqlServer usuarioSqlServer;
    
    public EmpleadoSqlServer(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
        this.usuarioSqlServer=new UsuarioSqlServer(accesoDatosJDBC);
    }
    
    
    public Empleado BuscarEmpleado(int idEmpleado){
    
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
                Usuario usuario=usuarioSqlServer.BuscarUsuario(resultado.getInt("UsuarioID"));
                empleado=new Empleado(idEmpleado,descripcion,usuario);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return empleado;
        
    }
    
    public String DescripcionEmpleado(int idUsuario)throws Exception{
        
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
        } catch (Exception e) {
            throw new Exception("Error Al Capturar La Descripcion",e);
        }
        return descripcion;
    }
    

}
