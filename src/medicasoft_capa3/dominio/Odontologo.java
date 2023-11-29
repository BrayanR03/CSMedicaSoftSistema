package medicasoft_capa3.dominio;

import java.sql.Date;
import java.util.List;

/**
 * @author HP
 * @version 1.0
 * @created 17-may.-2022 18:08:12
 */
public class Odontologo {

    private int odontologoID;
    private String odontologoApellidos;
    private String odontologoNombres;
    private java.sql.Date odontologoFechaNacimiento;
    private String odontologoDni;
    private String odontologoTelefono;
    private String odontologoDireccion;
    private String odontologoCorreo;
    private Empleado empleadoID;

    public Odontologo() {
    }

    public Odontologo(int odontologoID, String odontologoApellidos, String odontologoNombres, Date odontologoFechaNacimiento, String odontologoDni, String odontologoTelefono, String odontologoDireccion, String odontologoCorreo, Empleado empleadoID) {
        this.odontologoID = odontologoID;
        this.odontologoApellidos = odontologoApellidos;
        this.odontologoNombres = odontologoNombres;
        this.odontologoFechaNacimiento = odontologoFechaNacimiento;
        this.odontologoDni = odontologoDni;
        this.odontologoTelefono = odontologoTelefono;
        this.odontologoDireccion = odontologoDireccion;
        this.odontologoCorreo = odontologoCorreo;
        this.empleadoID = empleadoID;
    }

    public int getOdontologoID() {
        return odontologoID;
    }

    public void setOdontologoID(int odontologoID) {
        this.odontologoID = odontologoID;
    }

    public String getOdontologoApellidos() {
        return odontologoApellidos;
    }

    public void setOdontologoApellidos(String odontologoApellidos) {
        this.odontologoApellidos = odontologoApellidos;
    }

    public String getOdontologoNombres() {
        return odontologoNombres;
    }

    public void setOdontologoNombres(String odontologoNombres) {
        this.odontologoNombres = odontologoNombres;
    }

    public Date getOdontologoFechaNacimiento() {
        return odontologoFechaNacimiento;
    }

    public void setOdontologoFechaNacimiento(Date odontologoFechaNacimiento) {
        this.odontologoFechaNacimiento = odontologoFechaNacimiento;
    }

    public String getOdontologoDni() {
        return odontologoDni;
    }

    public void setOdontologoDni(String odontologoDni) {
        this.odontologoDni = odontologoDni;
    }

    public String getOdontologoTelefono() {
        return odontologoTelefono;
    }

    public void setOdontologoTelefono(String odontologoTelefono) {
        this.odontologoTelefono = odontologoTelefono;
    }

    public String getOdontologoDireccion() {
        return odontologoDireccion;
    }

    public void setOdontologoDireccion(String odontologoDireccion) {
        this.odontologoDireccion = odontologoDireccion;
    }

    public String getOdontologoCorreo() {
        return odontologoCorreo;
    }

    public void setOdontologoCorreo(String odontologoCorreo) {
        this.odontologoCorreo = odontologoCorreo;
    }

    public Empleado getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(Empleado empleadoID) {
        this.empleadoID = empleadoID;
    }

    public boolean tieneDniUnicoOdontologo(List<String> dniUnico) {
        return dniUnico.contains(getOdontologoDni());
    }

}//end Odontologo
