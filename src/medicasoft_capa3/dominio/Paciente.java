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

        private int PacienteID;
	private String PacienteApellidos;
        private String PacienteNombres;
        private java.sql.Date PacienteFechaNacimiento;
        private String PacienteDni;
        private String PacienteTelefono;
        private String PacienteDireccion;
        private String PacienteCorreo;

    public Paciente() {
    }

    public Paciente(int PacienteID, String PacienteApellidos, String PacienteNombres, Date PacienteFechaNacimiento, String PacienteDni, String PacienteTelefono, String PacienteDireccion, String PacienteCorreo) {
        this.PacienteID = PacienteID;
        this.PacienteApellidos = PacienteApellidos;
        this.PacienteNombres = PacienteNombres;
        this.PacienteFechaNacimiento = PacienteFechaNacimiento;
        this.PacienteDni = PacienteDni;
        this.PacienteTelefono = PacienteTelefono;
        this.PacienteDireccion = PacienteDireccion;
        this.PacienteCorreo = PacienteCorreo;
    }

    public int getPacienteID() {
        return PacienteID;
    }

    public void setPacienteID(int PacienteID) {
        this.PacienteID = PacienteID;
    }

    public String getPacienteApellidos() {
        return PacienteApellidos;
    }

    public void setPacienteApellidos(String PacienteApellidos) {
        this.PacienteApellidos = PacienteApellidos;
    }

    public String getPacienteNombres() {
        return PacienteNombres;
    }

    public void setPacienteNombres(String PacienteNombres) {
        this.PacienteNombres = PacienteNombres;
    }

    public Date getPacienteFechaNacimiento() {
        return PacienteFechaNacimiento;
    }

    public void setPacienteFechaNacimiento(Date PacienteFechaNacimiento) {
        this.PacienteFechaNacimiento = PacienteFechaNacimiento;
    }

    public String getPacienteDni() {
        return PacienteDni;
    }

    public void setPacienteDni(String PacienteDni) {
        this.PacienteDni = PacienteDni;
    }

    public String getPacienteTelefono() {
        return PacienteTelefono;
    }

    public void setPacienteTelefono(String PacienteTelefono) {
        this.PacienteTelefono = PacienteTelefono;
    }

    public String getPacienteDireccion() {
        return PacienteDireccion;
    }

    public void setPacienteDireccion(String PacienteDireccion) {
        this.PacienteDireccion = PacienteDireccion;
    }

    public String getPacienteCorreo() {
        return PacienteCorreo;
    }

    public void setPacienteCorreo(String PacienteCorreo) {
        this.PacienteCorreo = PacienteCorreo;
    }
	
        
    public boolean tieneFormatoFechaValida(String fechaDesdeTxt){ 

        SimpleDateFormat formatoEsperado = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date fecha = (Date) formatoEsperado.parse(fechaDesdeTxt);
            System.out.println("fecha correcta");
            return true;
            
        } catch (ParseException e) {
            System.out.println("fecha no correcta");
            return false;
        }
        
    }

	public boolean tieneEdadValida(){
            String fechas=String.valueOf(PacienteFechaNacimiento);
            int año=Integer.parseInt(fechas.substring(0,4));
            int mes=Integer.parseInt(fechas.substring(5,7));
            int dia=Integer.parseInt(fechas.substring(8,10));

            Calendar fechanac=new GregorianCalendar(año,mes,dia);
            Calendar fechactual=Calendar.getInstance();
            int añoact = fechactual.get(Calendar.YEAR);
            int añonac=fechanac.get(Calendar.YEAR);
            int edad=añoact-añonac;
            
            return edad>=7;
	}
    public boolean TieneDniUnicoPaciente(List<String> dniUnico){
    
        return dniUnico.contains(getPacienteDni());
    }
   public boolean tieneDniValido(){
        int longitudDni = PacienteDni.length();
        return longitudDni == 8;
    }
}//end Paciente