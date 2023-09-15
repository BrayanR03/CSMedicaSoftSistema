package medicasoft_capa3.dominio;

import java.sql.Date;
import java.util.List;


/**
 * @author HP
 * @version 1.0
 * @created 17-may.-2022 18:08:12
 */
public class Odontologo {

        private int OdontologoID;
	private String OdontologoApellidos;
        private String OdontologoNombres;
        private java.sql.Date OdontologoFechaNacimiento;
        private String OdontologoDni;
        private String OdontologoTelefono;
        private String OdontologoDireccion;
        private String OdontologoCorreo;
        private Empleado EmpleadoID;
    public Odontologo() {
    }

    public Odontologo(int OdontologoID, String OdontologoApellidos, String OdontologoNombres, Date OdontologoFechaNacimiento, String OdontologoDni, String OdontologoTelefono, String OdontologoDireccion, String OdontologoCorreo,Empleado EmpleadoID) {
        this.OdontologoID = OdontologoID;
        this.OdontologoApellidos = OdontologoApellidos;
        this.OdontologoNombres = OdontologoNombres;
        this.OdontologoFechaNacimiento = OdontologoFechaNacimiento;
        this.OdontologoDni = OdontologoDni;
        this.OdontologoTelefono = OdontologoTelefono;
        this.OdontologoDireccion = OdontologoDireccion;
        this.OdontologoCorreo = OdontologoCorreo;
        this.EmpleadoID=EmpleadoID;
    }

    public int getOdontologoID() {
        return OdontologoID;
    }

    public void setOdontologoID(int OdontologoID) {
        this.OdontologoID = OdontologoID;
    }

    public String getOdontologoApellidos() {
        return OdontologoApellidos;
    }

    public void setOdontologoApellidos(String OdontologoApellidos) {
        this.OdontologoApellidos = OdontologoApellidos;
    }

    public String getOdontologoNombres() {
        return OdontologoNombres;
    }

    public void setOdontologoNombres(String OdontologoNombres) {
        this.OdontologoNombres = OdontologoNombres;
    }

    public Date getOdontologoFechaNacimiento() {
        return OdontologoFechaNacimiento;
    }

    public void setOdontologoFechaNacimiento(Date OdontologoFechaNacimiento) {
        this.OdontologoFechaNacimiento = OdontologoFechaNacimiento;
    }

    public String getOdontologoDni() {
        return OdontologoDni;
    }

    public void setOdontologoDni(String OdontologoDni) {
        this.OdontologoDni = OdontologoDni;
    }

    public String getOdontologoTelefono() {
        return OdontologoTelefono;
    }

    public void setOdontologoTelefono(String OdontologoTelefono) {
        this.OdontologoTelefono = OdontologoTelefono;
    }

    public String getOdontologoDireccion() {
        return OdontologoDireccion;
    }

    public void setOdontologoDireccion(String OdontologoDireccion) {
        this.OdontologoDireccion = OdontologoDireccion;
    }

    public String getOdontologoCorreo() {
        return OdontologoCorreo;
    }

    public void setOdontologoCorreo(String OdontologoCorreo) {
        this.OdontologoCorreo = OdontologoCorreo;
    }

    public Empleado getEmpleadoID() {
        return EmpleadoID;
    }

    public void setEmpleadoID(Empleado EmpleadoID) {
        this.EmpleadoID = EmpleadoID;
    }
    
        
        
    public boolean TieneDniUnicoOdontologo(List<String> dniUnico){
        return dniUnico.contains(getOdontologoDni());
    }

}//end Odontologo