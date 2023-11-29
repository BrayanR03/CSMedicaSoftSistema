package medicasoft_capa3.dominio;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author HP
 * @version 1.0
 * @created 17-may.-2022 18:08:12
 */
public class Paciente {

    private int pacienteID;
    private String pacienteApellidos;
    private String pacienteNombres;
    private java.sql.Date pacienteFechaNacimiento;
    private String pacienteDni;
    private String pacienteTelefono;
    private String pacienteDireccion;
    private String pacienteCorreo;

    public Paciente() {
    }

    public Paciente(int pacienteID, String pacienteApellidos, String pacienteNombres, Date pacienteFechaNacimiento, String pacienteDni, String pacienteTelefono, String pacienteDireccion, String pacienteCorreo) {
        this.pacienteID = pacienteID;
        this.pacienteApellidos = pacienteApellidos;
        this.pacienteNombres = pacienteNombres;
        this.pacienteFechaNacimiento = pacienteFechaNacimiento;
        this.pacienteDni = pacienteDni;
        this.pacienteTelefono = pacienteTelefono;
        this.pacienteDireccion = pacienteDireccion;
        this.pacienteCorreo = pacienteCorreo;
    }

    public int getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(int pacienteID) {
        this.pacienteID = pacienteID;
    }

    public String getPacienteApellidos() {
        return pacienteApellidos;
    }

    public void setPacienteApellidos(String pacienteApellidos) {
        this.pacienteApellidos = pacienteApellidos;
    }

    public String getPacienteNombres() {
        return pacienteNombres;
    }

    public void setPacienteNombres(String pacienteNombres) {
        this.pacienteNombres = pacienteNombres;
    }

    public Date getPacienteFechaNacimiento() {
        return pacienteFechaNacimiento;
    }

    public void setPacienteFechaNacimiento(Date pacienteFechaNacimiento) {
        this.pacienteFechaNacimiento = pacienteFechaNacimiento;
    }

    public String getPacienteDni() {
        return pacienteDni;
    }

    public void setPacienteDni(String pacienteDni) {
        this.pacienteDni = pacienteDni;
    }

    public String getPacienteTelefono() {
        return pacienteTelefono;
    }

    public void setPacienteTelefono(String pacienteTelefono) {
        this.pacienteTelefono = pacienteTelefono;
    }

    public String getPacienteDireccion() {
        return pacienteDireccion;
    }

    public void setPacienteDireccion(String pacienteDireccion) {
        this.pacienteDireccion = pacienteDireccion;
    }

    public String getPacienteCorreo() {
        return pacienteCorreo;
    }

    public void setPacienteCorreo(String pacienteCorreo) {
        this.pacienteCorreo = pacienteCorreo;
    }

    public boolean tieneFormatoFechaValida(String fecha) {
        String[] fechas = fecha.split("-");

        if (fechas.length != 3) {
            return false;
        }
        if(fechas[0].length()!=4 || fechas[1].length()!=2 || fechas[2].length()!=2){
            return false;
        }
      

        return true;
    }

    public boolean tieneEdadValida() {
        String fechas = String.valueOf(pacienteFechaNacimiento);
        int año = Integer.parseInt(fechas.substring(0, 4));
        int mes = Integer.parseInt(fechas.substring(5, 7));
        int dia = Integer.parseInt(fechas.substring(8, 10));

        Calendar fechanac = new GregorianCalendar(año, mes, dia);
        Calendar fechactual = Calendar.getInstance();
        int añoact = fechactual.get(Calendar.YEAR);
        int añonac = fechanac.get(Calendar.YEAR);
        int edad = añoact - añonac;

        return edad >= 7;
    }

    public boolean tieneDniUnicoPaciente(List<String> dniUnico) {

        return dniUnico.contains(getPacienteDni());
    }

    public boolean tieneDniValido() {
        int longitudDni = pacienteDni.length();
        return longitudDni == 8;
    }
}//end Paciente
