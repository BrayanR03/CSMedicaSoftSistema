package medicasoft_capa3.dominio;

import java.util.List;


/**
 * @author HP
 * @version 1.0
 * @created 17-may.-2022 18:08:12
 */
public class Cita {

    private int CitaID;
    private HorarioAtencion HorarioAtencionID;
    private Paciente PacienteID;
    private String CitaEstado;

    public Cita() {
    }

    public Cita(int CitaID, HorarioAtencion HorarioAtencionID, Paciente PacienteID, String CitaEstado) {
        this.CitaID = CitaID;
        this.HorarioAtencionID = HorarioAtencionID;
        this.PacienteID = PacienteID;
        this.CitaEstado = CitaEstado;
    }

    public int getCitaID() {
        return CitaID;
    }

    public void setCitaID(int CitaID) {
        this.CitaID = CitaID;
    }

    public HorarioAtencion getHorarioAtencionID() {
        return HorarioAtencionID;
    }

    public void setHorarioAtencionID(HorarioAtencion HorarioAtencionID) {
        this.HorarioAtencionID = HorarioAtencionID;
    }

    public Paciente getPacienteID() {
        return PacienteID;
    }

    public void setPacienteID(Paciente PacienteID) {
        this.PacienteID = PacienteID;
    }

    public String getCitaEstado() {
        return CitaEstado;
    }

    public void setCitaEstado(String CitaEstado) {
        this.CitaEstado = CitaEstado;
    }
    
    
    
    
    public boolean permiteNuevaCita(int totalDeCitasRegistradas) {
        return totalDeCitasRegistradas <7;
    }
    
    public boolean permiteNuevaCitaPaciente(int totalDeCitasPaciente){
        return totalDeCitasPaciente < 1;
    }

    @Override
    public String toString() {
        return "Cita{" + "CitaID=" + CitaID + ", HorarioAtencionID=" + HorarioAtencionID + ", PacienteID=" + PacienteID + ", CitaEstado=" + CitaEstado + '}';
    }
    
    
 

	
}//end Cita