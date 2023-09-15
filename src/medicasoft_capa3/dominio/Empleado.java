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
public class Empleado {
    
    private int EmpleadoID;
    private String EmpleadoDescripcion;
    private Usuario usuario;

    public Empleado() {
    }

    public Empleado(int EmpleadoID, String EmpleadoDescripcion, Usuario usuario) {
        this.EmpleadoID = EmpleadoID;
        this.EmpleadoDescripcion = EmpleadoDescripcion;
        this.usuario = usuario;
    }

    public int getEmpleadoID() {
        return EmpleadoID;
    }

    public void setEmpleadoID(int EmpleadoID) {
        this.EmpleadoID = EmpleadoID;
    }

    public String getEmpleadoDescripcion() {
        return EmpleadoDescripcion;
    }

    public void setEmpleadoDescripcion(String EmpleadoDescripcion) {
        this.EmpleadoDescripcion = EmpleadoDescripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
