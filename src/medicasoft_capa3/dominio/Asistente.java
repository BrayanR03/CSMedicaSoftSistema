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
    
    
        private int AsistenteID;
	private String AsistenteApellidos;
        private String AsistenteNombres;
        private java.sql.Date AsistenteFechaNacimiento;
        private String AsistenteDni;
        private String AsistenteTelefono;
        private String AsistenteDireccion;
        private String AsistenteCorreo;
        private Empleado EmpleadoID;

    public Asistente() {
    }

    public Asistente(int AsistenteID, String AsistenteApellidos, String AsistenteNombres, Date AsistenteFechaNacimiento, String AsistenteDni, String AsistenteTelefono, String AsistenteDireccion, String AsistenteCorreo, Empleado UsuarioID) {
        this.AsistenteID = AsistenteID;
        this.AsistenteApellidos = AsistenteApellidos;
        this.AsistenteNombres = AsistenteNombres;
        this.AsistenteFechaNacimiento = AsistenteFechaNacimiento;
        this.AsistenteDni = AsistenteDni;
        this.AsistenteTelefono = AsistenteTelefono;
        this.AsistenteDireccion = AsistenteDireccion;
        this.AsistenteCorreo = AsistenteCorreo;
        this.EmpleadoID = EmpleadoID;
    }

    public int getAsistenteID() {
        return AsistenteID;
    }

    public void setAsistenteID(int AsistenteID) {
        this.AsistenteID = AsistenteID;
    }

    public String getAsistenteApellidos() {
        return AsistenteApellidos;
    }

    public void setAsistenteApellidos(String AsistenteApellidos) {
        this.AsistenteApellidos = AsistenteApellidos;
    }

    public String getAsistenteNombres() {
        return AsistenteNombres;
    }

    public void setAsistenteNombres(String AsistenteNombres) {
        this.AsistenteNombres = AsistenteNombres;
    }

    public Date getAsistenteFechaNacimiento() {
        return AsistenteFechaNacimiento;
    }

    public void setAsistenteFechaNacimiento(Date AsistenteFechaNacimiento) {
        this.AsistenteFechaNacimiento = AsistenteFechaNacimiento;
    }

    public String getAsistenteDni() {
        return AsistenteDni;
    }

    public void setAsistenteDni(String AsistenteDni) {
        this.AsistenteDni = AsistenteDni;
    }

    public String getAsistenteTelefono() {
        return AsistenteTelefono;
    }

    public void setAsistenteTelefono(String AsistenteTelefono) {
        this.AsistenteTelefono = AsistenteTelefono;
    }

    public String getAsistenteDireccion() {
        return AsistenteDireccion;
    }

    public void setAsistenteDireccion(String AsistenteDireccion) {
        this.AsistenteDireccion = AsistenteDireccion;
    }

    public String getAsistenteCorreo() {
        return AsistenteCorreo;
    }

    public void setAsistenteCorreo(String AsistenteCorreo) {
        this.AsistenteCorreo = AsistenteCorreo;
    }

    public Empleado getEmpleadoID() {
        return EmpleadoID;
    }

    public void setEmpleadoID(Empleado EmpleadoID) {
        this.EmpleadoID = EmpleadoID;
    }
    
    
        

}
