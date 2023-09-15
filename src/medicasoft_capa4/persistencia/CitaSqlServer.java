/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa4.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import medicasoft_capa3.dominio.Cita;
import medicasoft_capa3.dominio.HorarioAtencion;

/**
 *
 * @author USER
 */
public class CitaSqlServer {
    
    
     private AccesoDatosJDBC accesoDatosJDBC;

    public CitaSqlServer(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
    }

    public void guardar(Cita cita) {

        String insertSQL = "INSERT INTO Cita(HorarioAtencionID,PacienteID,CitaEstado)\n" +
                           "VALUES(?,?,?)";
        PreparedStatement sentencia;
        try {

            sentencia = accesoDatosJDBC.prepararSentencia(insertSQL);
            sentencia.setInt(1, cita.getHorarioAtencionID().getHorarioAtencionID());
            sentencia.setInt(2, cita.getPacienteID().getPacienteID());
            sentencia.setString(3, cita.getCitaEstado());
            sentencia.executeUpdate();

        } catch (Exception ex) {
            System.out.println("ERROR" + ex.getMessage());
        }
    }
    
    
    public boolean verificarHorarioDisponible(HorarioAtencion horario) throws Exception {
        String consultaSQL = "SELECT HorarioAtencionEstado FROM HorarioAtencion WHERE HorarioAtencionID=?";
        PreparedStatement sentencia;
        String estado = "";
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);

            sentencia.setInt(1, horario.getHorarioAtencionID());
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                estado = resultado.getString(1);
            }
            if (estado.equalsIgnoreCase("disponible")) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al intentar consultar citas.", e);
        }
    }
    
    
    
    public int consultarTotalDeCitasRegistradas(HorarioAtencion horario) throws Exception {
        // String consultaSQL = "select count(codigohorario) as totalCitas from horario where fecha = ?";
        String consultaSQL = "SELECT COUNT(HA.HorarioAtencionFechaRegistro) AS TotalCitas\n" +
"FROM Cita C INNER JOIN HorarioAtencion HA\n" +
"ON C.HorarioAtencionID=HA.HorarioAtencionID\n" +
"WHERE HA.HorarioAtencionFechaRegistro=?\n" +
"GROUP BY HA.HorarioAtencionFechaRegistro";
        PreparedStatement sentencia;
        int totalDeCitas = 0;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            System.out.println(horario.getHorarioAtencionFechaRegistro());

            sentencia.setDate(1, horario.getHorarioAtencionFechaRegistro());
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                totalDeCitas = resultado.getInt("TotalCitas");
            }
            return totalDeCitas;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al intentar consultar citas.", e);
        }

    }
    
    
    
    public int verificarNumeroDeCitasPaciente(Cita cita) throws Exception {
        String consultaSQL = "SELECT COUNT(P.PacienteID) AS TotalCitasPacienteDia\n" +
"FROM CITA C INNER JOIN HorarioAtencion HA\n" +
"ON HA.HorarioAtencionID=C.HorarioAtencionID\n" +
"INNER JOIN Paciente P ON P.PacienteID=C.PacienteID\n" +
"WHERE P.PacienteID=? AND HA.HorarioAtencionFechaRegistro=?";
        PreparedStatement sentencia;
        int total = 0;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setInt(1, cita.getPacienteID().getPacienteID());
            sentencia.setDate(2, cita.getHorarioAtencionID().getHorarioAtencionFechaRegistro());
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                total = resultado.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al intentar consultar citas.", e);
        }
        return total;
    }
    
}
