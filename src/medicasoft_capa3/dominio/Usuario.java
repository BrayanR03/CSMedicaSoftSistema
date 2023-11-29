/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa3.dominio;

/**
 *
 * @author USER
 */
public class Usuario {
    
    private int usuarioID;
    private String usuario;
    private String pass;

    public Usuario() {
    }

    public Usuario(int usuarioID, String usuario, String pass) {
        this.usuarioID = usuarioID;
        this.usuario = usuario;
        this.pass = pass;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String pass) {
        this.pass = pass;
    }

    
}
