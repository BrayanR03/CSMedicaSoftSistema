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
    
    
    public Usuario BuscarUsuario(int idusuario)throws Exception{
    
        String consultaSQL="SELECT Usuario,Password,Rol FROM Usuario WHERE UsuarioID=?";
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
}
