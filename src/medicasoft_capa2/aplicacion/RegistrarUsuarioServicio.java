/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicasoft_capa2.aplicacion;

import medicasoft_capa4.persistencia.AccesoDatosJDBC;
import medicasoft_capa4.persistencia.AccesoDatosJDBCSqlServer;
import medicasoft_capa4.persistencia.UsuarioSqlServer;

/**
 *
 * @author MrDev
 */
public class RegistrarUsuarioServicio {

    private AccesoDatosJDBC accesoDatosJDBC;
    private UsuarioSqlServer usuarioSqlServer;

    public RegistrarUsuarioServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCSqlServer();
        usuarioSqlServer = new UsuarioSqlServer(accesoDatosJDBC);
    }

    
    public boolean validarUsuario(String usuario, String password) {
        
        boolean usuarioValidado = false;
        try {
            accesoDatosJDBC.abrirConexion();
            usuarioValidado = usuarioSqlServer.ValidarUsuario(usuario, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuarioValidado;
    }
}
