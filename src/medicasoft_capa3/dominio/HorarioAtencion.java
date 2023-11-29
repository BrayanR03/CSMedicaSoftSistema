package medicasoft_capa3.dominio;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author USER
 */
public class HorarioAtencion {
    
    private int horarioAtencionID;
    private String horarioAtencionEstado;
    private java.sql.Date horarioAtencionFechaRegistro;
    private String horarioAtencionHoraInicio;
    private String horarioAtencionHoraFin;
    private Odontologo odontologoID;

    public HorarioAtencion() {
    }

    public HorarioAtencion(int horarioAtencionID, String horarioAtencionEstado, Date horarioAtencionFechaRegistro, String horarioAtencionHoraInicio, String horarioAtencionHoraFin, Odontologo odontologoID) {
        this.horarioAtencionID = horarioAtencionID;
        this.horarioAtencionEstado = horarioAtencionEstado;
        this.horarioAtencionFechaRegistro = horarioAtencionFechaRegistro;
        this.horarioAtencionHoraInicio = horarioAtencionHoraInicio;
        this.horarioAtencionHoraFin = horarioAtencionHoraFin;
        this.odontologoID = odontologoID;
    }

    public int getHorarioAtencionID() {
        return horarioAtencionID;
    }

    public void setHorarioAtencionID(int horarioAtencionID) {
        this.horarioAtencionID = horarioAtencionID;
    }

    public String getHorarioAtencionEstado() {
        return horarioAtencionEstado;
    }

    public void setHorarioAtencionEstado(String horarioAtencionEstado) {
        this.horarioAtencionEstado = horarioAtencionEstado;
    }

    public Date getHorarioAtencionFechaRegistro() {
        return horarioAtencionFechaRegistro;
    }

    public void setHorarioAtencionFechaRegistro(Date horarioAtencionFechaRegistro) {
        this.horarioAtencionFechaRegistro = horarioAtencionFechaRegistro;
    }

    public String getHorarioAtencionHoraInicio() {
        return horarioAtencionHoraInicio;
    }

    public void setHorarioAtencionHoraInicio(String horarioAtencionHoraInicio) {
        this.horarioAtencionHoraInicio = horarioAtencionHoraInicio;
    }

    public String getHorarioAtencionHoraFin() {
        return horarioAtencionHoraFin;
    }

    public void setHorarioAtencionHoraFin(String horarioAtencionHoraFin) {
        this.horarioAtencionHoraFin = horarioAtencionHoraFin;
    }

    public Odontologo getOdontologoID() {
        return odontologoID;
    }

    public void setOdontologoID(Odontologo odontologoID) {
        this.odontologoID = odontologoID;
    }
    
    public boolean tieneHoraValida() {
        return     horarioAtencionHoraInicio.equalsIgnoreCase("09:00")
                && horarioAtencionHoraFin.equalsIgnoreCase("09:59")
                
                || horarioAtencionHoraInicio.equalsIgnoreCase("10:00")
                && horarioAtencionHoraFin.equalsIgnoreCase("10:59")
                
                || horarioAtencionHoraInicio.equalsIgnoreCase("11:00")
                && horarioAtencionHoraFin.equalsIgnoreCase("11:59")
                
                || horarioAtencionHoraInicio.equalsIgnoreCase("12:00")
                && horarioAtencionHoraFin.equalsIgnoreCase("12:59")
                
                || horarioAtencionHoraInicio.equalsIgnoreCase("14:00")
                && horarioAtencionHoraFin.equalsIgnoreCase("14:59")
                
                || horarioAtencionHoraInicio.equalsIgnoreCase("15:00")
                && horarioAtencionHoraFin.equalsIgnoreCase("15:59")
                
                || horarioAtencionHoraInicio.equalsIgnoreCase("16:00")
                && horarioAtencionHoraFin.equalsIgnoreCase("16:59")
                
                || horarioAtencionHoraInicio.equalsIgnoreCase("17:00")
                && horarioAtencionHoraFin.equalsIgnoreCase("17:59");
                
                
    }
    
    
    public boolean tieneHoraUnicaValida(List<String> horas) {
        return horas.contains(getHorarioAtencionHoraInicio()) || horas.contains(getHorarioAtencionHoraFin());
    }
    
    public boolean tieneDiaValido() {        
        boolean fechaValida = true;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");        
        LocalDate fechaformat = LocalDate.parse(String.valueOf(horarioAtencionFechaRegistro), formato);        
        DayOfWeek dia = fechaformat.getDayOfWeek();        
        if(dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY){
            fechaValida = false;
        }               
        return fechaValida;
    }
}
