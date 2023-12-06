
package dominio;

/**
 *
 * @author USER
 */
public class Empleado {
    
    private int empleadoID;
    private String empleadoDescripcion;
    private Usuario usuario;

    public Empleado() {
    }

    public Empleado(int empleadoID, String empleadoDescripcion, Usuario usuario) {
        this.empleadoID = empleadoID;
        this.empleadoDescripcion = empleadoDescripcion;
        this.usuario = usuario;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public String getEmpleadoDescripcion() {
        return empleadoDescripcion;
    }

    public void setEmpleadoDescripcion(String empleadoDescripcion) {
        this.empleadoDescripcion = empleadoDescripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
