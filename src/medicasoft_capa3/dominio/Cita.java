package medicasoft_capa3.dominio;

import java.util.List;


/**
 * @author HP
 * @version 1.0
 * @created 17-may.-2022 18:08:12
 */
public class Cita {

    private int citaID;
    private HorarioAtencion horarioAtencionID;
    private Paciente pacienteID;
    private String citaEstado;

    public Cita() {
    }

    public Cita(int citaID, HorarioAtencion horarioAtencionID, Paciente pacienteID, String citaEstado) {
        this.citaID = citaID;
        this.horarioAtencionID = horarioAtencionID;
        this.pacienteID = pacienteID;
        this.citaEstado = citaEstado;
    }

    public int getCitaID() {
        return citaID;
    }

    public void setCitaID(int citaID) {
        this.citaID = citaID;
    }

    public HorarioAtencion getHorarioAtencionID() {
        return horarioAtencionID;
    }

    public void setHorarioAtencionID(HorarioAtencion horarioAtencionID) {
        this.horarioAtencionID = horarioAtencionID;
    }

    public Paciente getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(Paciente pacienteID) {
        this.pacienteID = pacienteID;
    }

    public String getCitaEstado() {
        return citaEstado;
    }

    public void setCitaEstado(String citaEstado) {
        this.citaEstado = citaEstado;
    }
    
    
    
    
    public boolean permiteNuevaCita(int totalDeCitasRegistradas) {
        return totalDeCitasRegistradas <7;
    }
    
    public boolean permiteNuevaCitaPaciente(int totalDeCitasPaciente){
        return totalDeCitasPaciente < 1;
    }

    @Override
    public String toString() {
        return "Cita{" + "CitaID=" + citaID + ", HorarioAtencionID=" + horarioAtencionID + ", PacienteID=" + pacienteID + ", CitaEstado=" + citaEstado + '}';
    }
    
    
 

	
}//end Cita