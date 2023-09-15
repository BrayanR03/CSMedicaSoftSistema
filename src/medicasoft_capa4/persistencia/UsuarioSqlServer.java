/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa4.persistencia;

import java.sql.*;
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
    
    
    public Usuario BuscarUsuario(String usuario)throws Exception{
    
        String consultaSQL="SELECT UsuarioID,Usuario,Password,Rol FROM Usuario WHERE Usuario=?";
        PreparedStatement sentencia;
        ResultSet resultado=null;
        Usuario user=null;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, usuario);
            resultado=sentencia.executeQuery();
            if(resultado.next()){
            
                int idUsuario=resultado.getInt("UsuarioID");
                String password=resultado.getString("Password");
                String rol=resultado.getString("Rol");
                user=new Usuario(idUsuario,usuario,password,rol);
                
                return user;
            }else{
                throw new Exception("No existe el Usuario");
            }
        } catch (Exception e) {
            throw new Exception("Error Al Buscar",e);
        }
        
    }
}
