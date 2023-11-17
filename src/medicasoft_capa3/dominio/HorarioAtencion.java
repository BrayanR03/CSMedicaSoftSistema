/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    private int HorarioAtencionID;
    private String HorarioAtencionEstado;
    private java.sql.Date HorarioAtencionFechaRegistro;
    private String HorarioAtencionHoraInicio;
    private String HorarioAtencionHoraFin;
    private Odontologo OdontologoID;

    public HorarioAtencion() {
    }

    public HorarioAtencion(int HorarioAtencionID, String HorarioAtencionEstado, Date HorarioAtencionFechaRegistro, String HorarioAtencionHoraInicio, String HorarioAtencionHoraFin, Odontologo OdontologoID) {
        this.HorarioAtencionID = HorarioAtencionID;
        this.HorarioAtencionEstado = HorarioAtencionEstado;
        this.HorarioAtencionFechaRegistro = HorarioAtencionFechaRegistro;
        this.HorarioAtencionHoraInicio = HorarioAtencionHoraInicio;
        this.HorarioAtencionHoraFin = HorarioAtencionHoraFin;
        this.OdontologoID = OdontologoID;
    }

    public int getHorarioAtencionID() {
        return HorarioAtencionID;
    }

    public void setHorarioAtencionID(int HorarioAtencionID) {
        this.HorarioAtencionID = HorarioAtencionID;
    }

    public String getHorarioAtencionEstado() {
        return HorarioAtencionEstado;
    }

    public void setHorarioAtencionEstado(String HorarioAtencionEstado) {
        this.HorarioAtencionEstado = HorarioAtencionEstado;
    }

    public Date getHorarioAtencionFechaRegistro() {
        return HorarioAtencionFechaRegistro;
    }

    public void setHorarioAtencionFechaRegistro(Date HorarioAtencionFechaRegistro) {
        this.HorarioAtencionFechaRegistro = HorarioAtencionFechaRegistro;
    }

    public String getHorarioAtencionHoraInicio() {
        return HorarioAtencionHoraInicio;
    }

    public void setHorarioAtencionHoraInicio(String HorarioAtencionHoraInicio) {
        this.HorarioAtencionHoraInicio = HorarioAtencionHoraInicio;
    }

    public String getHorarioAtencionHoraFin() {
        return HorarioAtencionHoraFin;
    }

    public void setHorarioAtencionHoraFin(String HorarioAtencionHoraFin) {
        this.HorarioAtencionHoraFin = HorarioAtencionHoraFin;
    }

    public Odontologo getOdontologoID() {
        return OdontologoID;
    }

    public void setOdontologoID(Odontologo OdontologoID) {
        this.OdontologoID = OdontologoID;
    }
    
    public boolean tieneHoraValida() {
        return     HorarioAtencionHoraInicio.equalsIgnoreCase("09:00")
                && HorarioAtencionHoraFin.equalsIgnoreCase("09:59")
                
                || HorarioAtencionHoraInicio.equalsIgnoreCase("10:00")
                && HorarioAtencionHoraFin.equalsIgnoreCase("10:59")
                
                || HorarioAtencionHoraInicio.equalsIgnoreCase("11:00")
                && HorarioAtencionHoraFin.equalsIgnoreCase("11:59")
                
                || HorarioAtencionHoraInicio.equalsIgnoreCase("12:00")
                && HorarioAtencionHoraFin.equalsIgnoreCase("12:59")
                
                || HorarioAtencionHoraInicio.equalsIgnoreCase("14:00")
                && HorarioAtencionHoraFin.equalsIgnoreCase("14:59")
                
                || HorarioAtencionHoraInicio.equalsIgnoreCase("15:00")
                && HorarioAtencionHoraFin.equalsIgnoreCase("15:59")
                
                || HorarioAtencionHoraInicio.equalsIgnoreCase("16:00")
                && HorarioAtencionHoraFin.equalsIgnoreCase("16:59")
                
                || HorarioAtencionHoraInicio.equalsIgnoreCase("17:00")
                && HorarioAtencionHoraFin.equalsIgnoreCase("17:59");
                
                
    }
    
    
    public boolean tieneHoraUnicaValida(List<String> horas) {
        return horas.contains(getHorarioAtencionHoraInicio()) || horas.contains(getHorarioAtencionHoraFin());
    }
    
    public boolean tieneDiaValido() {        
        boolean fechaValida = true;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");        
        LocalDate fechaformat = LocalDate.parse(String.valueOf(HorarioAtencionFechaRegistro), formato);        
        DayOfWeek dia = fechaformat.getDayOfWeek();        
        if(dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY){
            fechaValida = false;
        }               
        return fechaValida;
    }
}
