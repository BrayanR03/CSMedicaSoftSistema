
package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dominio.Usuario;

/**
 *
 * @author USER
 */
public class UsuarioSqlServer {
    
    
    private AccesoDatosJDBC accesoDatosJDBC;

    public UsuarioSqlServer(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
    }
    
    
    public Usuario buscarUsuario(int idusuario)throws SQLException{
    
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
                throw new SQLException("No existe el Usuario");
            }
        } catch (SQLException e) {
            throw new SQLException("Error Al Buscar" + e.getMessage());
        }
        
    }
    
    public boolean validarUsuario(String usuario,String password)throws SQLException{
        
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
            if(resultado.next()){
                
                String usuarioTabla=resultado.getString("Usuario");
                String passwordTabla=resultado.getString("Password");                           
                
                usuariobd.add(usuarioTabla.trim());
                passwordbd.add(passwordTabla.trim());                
                if(usuariobd.contains(usuario) && passwordbd.contains(password)){
                    validar=true;
                }
                
            }
        } catch (SQLException e) {
            throw new SQLException("Datos Inválidos",e);
        }
        return validar;
    }
    public int retornarIdUsuario(String usuario,String password)throws SQLException{
        
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
            
        } catch (SQLException e) {
            throw new SQLException("Datos Inválidos" + e.getMessage());
        }
        return idUsuarioTabla;
    }    
}
