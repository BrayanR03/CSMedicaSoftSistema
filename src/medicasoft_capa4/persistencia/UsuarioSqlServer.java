/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa4.persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import medicasoft_capa3.dominio.Usuario;

/**
 *
 * @author USER
 */
public class UsuarioSqlServer {
    
    
    private AccesoDatosJDBC accesoDatosJDBC;

    public UsuarioSqlServer(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
    }
    
    
    public Usuario BuscarUsuario(int idusuario)throws Exception{
    
        String consultaSQL="SELECT Usuario,Password FROM Usuario WHERE UsuarioID=?";
        PreparedStatement sentencia;
        ResultSet resultado=null;
        Usuario user=null;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setInt(1, idusuario);
            resultado=sentencia.executeQuery();
            if(resultado.next()){
            
                String usuario=resultado.getString("Usuario");
                String password=resultado.getString("Password");
                user=new Usuario(idusuario,usuario,password);
                
                return user;
            }else{
                throw new Exception("No existe el Usuario");
            }
        } catch (Exception e) {
            throw new Exception("Error Al Buscar",e);
        }
        
    }
    
    public boolean ValidarUsuario(String usuario,String password)throws Exception{
        
        String consultaSQL="SELECT Usuario,Password,UsuarioID FROM USUARIO where Usuario=? and Password=?";
        PreparedStatement sentencia;
        boolean validar=false;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, usuario);
            sentencia.setString(2, password);
            ResultSet resultado=sentencia.executeQuery();
            List<String> usuariobd=new ArrayList();
            List<String> passwordbd=new ArrayList();
            List<Integer> idusuariobd=new ArrayList();
            if(resultado.next()){
                
                String usuarioTabla=resultado.getString("Usuario");
                String passwordTabla=resultado.getString("Password");           
                int idUsuarioTabla=resultado.getInt("UsuarioID");
                
                usuariobd.add(usuarioTabla.trim());
                passwordbd.add(passwordTabla.trim());
                idusuariobd.add(idUsuarioTabla);
                if(usuariobd.contains(usuario) && passwordbd.contains(password)){
                    validar=true;
                }
                
            }
        } catch (Exception e) {
            throw new Exception("Datos Inválidos",e);
        }
        return validar;
    }
    public int RetornarIDUsuario(String usuario,String password)throws Exception{
        
        String consultaSQL="SELECT UsuarioID FROM USUARIO where Usuario=? and Password=?";
        PreparedStatement sentencia;
        int idUsuarioTabla=0;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, usuario);
            sentencia.setString(2, password);
            ResultSet resultado=sentencia.executeQuery();
            if(resultado.next()){
                idUsuarioTabla=resultado.getInt("UsuarioID");
            }
            
        } catch (Exception e) {
            throw new Exception("Datos Inválidos",e);
        }
        return idUsuarioTabla;
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
