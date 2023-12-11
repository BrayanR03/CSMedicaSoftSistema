/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import persistencia.AccesoDatosJDBC;
import persistencia.AccesoDatosJDBCSqlServer;
import persistencia.EmpleadoSqlServer;
import persistencia.UsuarioSqlServer;

/**
 *
 * @author MrDev
 */
public class RegistrarUsuarioServicio {

    private AccesoDatosJDBC accesoDatosJDBC;
    private UsuarioSqlServer usuarioSqlServer;
    private EmpleadoSqlServer empleadoSqlServer;

    public RegistrarUsuarioServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCSqlServer();
        usuarioSqlServer = new UsuarioSqlServer(accesoDatosJDBC);
        empleadoSqlServer = new EmpleadoSqlServer(accesoDatosJDBC);
    }

    public int retornoIDusuario(String usuario,String password){
        int usuarioIDretornado=0;
        try {
            accesoDatosJDBC.abrirConexion();
            usuarioIDretornado=usuarioSqlServer.retornarIdUsuario(usuario, password);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuarioIDretornado;
    }
    public String retornoDescripcion(int idUsuario)throws Exception{
        String descripcion="";
        try {
            accesoDatosJDBC.abrirConexion();
            descripcion=empleadoSqlServer.descripcionEmpleado(idUsuario);
            accesoDatosJDBC.cerrarConexion();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return descripcion;
    }
    public boolean validarUsuario(String usuario, String password) {
        
        boolean usuarioValidado = false;
        try {
            accesoDatosJDBC.abrirConexion();
            usuarioValidado = usuarioSqlServer.validarUsuario(usuario, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuarioValidado;
    }
}
