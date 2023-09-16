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
    
    private int UsuarioID;
    private String Usuario;
    private String Password;

    public Usuario() {
    }

    public Usuario(int UsuarioID, String Usuario, String Password) {
        this.UsuarioID = UsuarioID;
        this.Usuario = Usuario;
        this.Password = Password;
    }

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    
}
