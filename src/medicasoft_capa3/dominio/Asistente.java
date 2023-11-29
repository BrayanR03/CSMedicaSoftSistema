/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa3.dominio;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Asistente {
    
    
        private int asistenteID
;	private String asistenteApellidos;
        private String asistenteNombres;
        private java.sql.Date asistenteFechaNacimiento;
        private String asistenteDni;
        private String asistenteTelefono;
        private String asistenteDireccion;
        private String asistenteCorreo;
        private Empleado empleadoID;

    public Asistente() {
    }

    public Asistente(int asistenteID, String asistenteApellidos, String asistenteNombres, Date asistenteFechaNacimiento, String asistenteDni, String asistenteTelefono, String asistenteDireccion, String asistenteCorreo, Empleado empleadoID) {
        this.asistenteID = asistenteID;
        this.asistenteApellidos = asistenteApellidos;
        this.asistenteNombres = asistenteNombres;
        this.asistenteFechaNacimiento = asistenteFechaNacimiento;
        this.asistenteDni = asistenteDni;
        this.asistenteTelefono = asistenteTelefono;
        this.asistenteDireccion = asistenteDireccion;
        this.asistenteCorreo = asistenteCorreo;
        this.empleadoID = empleadoID;
    }

    public int getAsistenteID() {
        return asistenteID;
    }

    public void setAsistenteID(int asistenteID) {
        this.asistenteID = asistenteID;
    }

    public String getAsistenteApellidos() {
        return asistenteApellidos;
    }

    public void setAsistenteApellidos(String asistenteApellidos) {
        this.asistenteApellidos = asistenteApellidos;
    }

    public String getAsistenteNombres() {
        return asistenteNombres;
    }

    public void setAsistenteNombres(String asistenteNombres) {
        this.asistenteNombres = asistenteNombres;
    }

    public Date getAsistenteFechaNacimiento() {
        return asistenteFechaNacimiento;
    }

    public void setAsistenteFechaNacimiento(Date asistenteFechaNacimiento) {
        this.asistenteFechaNacimiento = asistenteFechaNacimiento;
    }

    public String getAsistenteDni() {
        return asistenteDni;
    }

    public void setAsistenteDni(String asistenteDni) {
        this.asistenteDni = asistenteDni;
    }

    public String getAsistenteTelefono() {
        return asistenteTelefono;
    }

    public void setAsistenteTelefono(String asistenteTelefono) {
        this.asistenteTelefono = asistenteTelefono;
    }

    public String getAsistenteDireccion() {
        return asistenteDireccion;
    }

    public void setAsistenteDireccion(String asistenteDireccion) {
        this.asistenteDireccion = asistenteDireccion;
    }

    public String getAsistenteCorreo() {
        return asistenteCorreo;
    }

    public void setAsistenteCorreo(String asistenteCorreo) {
        this.asistenteCorreo = asistenteCorreo;
    }

    public Empleado getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(Empleado empleadoID) {
        this.empleadoID = empleadoID;
    }
    
    
        

}
