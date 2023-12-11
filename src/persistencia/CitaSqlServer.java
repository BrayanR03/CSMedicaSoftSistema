package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import dominio.Cita;
import dominio.HorarioAtencion;
import dominio.Paciente;

/**
 *
 * @author USER
 */
public class CitaSqlServer {

    private AccesoDatosJDBC accesoDatosJDBC;
    private HorarioAtencionSqlServer horarioAtencionSqlServer;
    private PacienteSqlServer pacienteSqlServer;

    public CitaSqlServer(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
        this.horarioAtencionSqlServer = new HorarioAtencionSqlServer(accesoDatosJDBC);
        this.pacienteSqlServer = new PacienteSqlServer(accesoDatosJDBC);
    }

    public void guardar(Cita cita) {

        String insertSQL = "INSERT INTO Cita(HorarioAtencionID,PacienteID,CitaEstado)\n"
                + "VALUES(?,?,?)";
        PreparedStatement sentencia;
        try {

            sentencia = accesoDatosJDBC.prepararSentencia(insertSQL);
            sentencia.setInt(1, cita.getHorarioAtencionID().getHorarioAtencionID());
            sentencia.setInt(2, cita.getPacienteID().getPacienteID());
            sentencia.setString(3, cita.getCitaEstado());
            sentencia.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR" + ex.getMessage());
        }
    }

    public boolean verificarHorarioDisponible(HorarioAtencion horario) throws SQLException {
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
            throw new SQLException("Error al intentar consultar citas.", e);
        }
    }

    public int consultarTotalDeCitasRegistradas(HorarioAtencion horario) throws SQLException {
        String consultaSQL = "SELECT COUNT(HA.HorarioAtencionFechaRegistro) AS TotalCitas\n"
                + "FROM Cita C INNER JOIN HorarioAtencion HA\n"
                + "ON C.HorarioAtencionID=HA.HorarioAtencionID\n"
                + "WHERE HA.HorarioAtencionFechaRegistro=?\n"
                + "GROUP BY HA.HorarioAtencionFechaRegistro";
        PreparedStatement sentencia;
        int totalDeCitas = 0;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);

            sentencia.setDate(1, horario.getHorarioAtencionFechaRegistro());
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                totalDeCitas = resultado.getInt("TotalCitas");
            }
            return totalDeCitas;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException("Error al intentar consultar citas.", e);
        }

    }

    public int verificarNumeroDeCitasPaciente(Cita cita) throws SQLException {
        String consultaSQL = "SELECT COUNT(P.PacienteID) AS TotalCitasPacienteDia\n"
                + "FROM CITA C INNER JOIN HorarioAtencion HA\n"
                + "ON HA.HorarioAtencionID=C.HorarioAtencionID\n"
                + "INNER JOIN Paciente P ON P.PacienteID=C.PacienteID\n"
                + "WHERE P.PacienteID=? AND HA.HorarioAtencionFechaRegistro=?";
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
            throw new SQLException("Error al intentar consultar citas.", e);
        }
        return total;
    }

    public Cita buscarCita(int IdCita)throws SQLException {

        String consultaSQL = "SELECT HorarioAtencionID,PacienteID,CitaEstado FROM Cita WHERE CitaID=?";

        PreparedStatement sentencia;
        
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setInt(1, IdCita);
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                Cita cita = new Cita();
                cita.setCitaID(IdCita);
                int idHorario = resultado.getInt("HorarioAtencionID");
                HorarioAtencion horario = horarioAtencionSqlServer.buscar(idHorario);
                cita.setHorarioAtencionID(horario);
                int idPaciente = resultado.getInt("PacienteID");
                System.out.println("paciente id de cita sqlserver "+idPaciente);
                Paciente paciente = pacienteSqlServer.buscarIdPaciente(idPaciente);
                cita.setPacienteID(paciente);
                cita.setCitaEstado(resultado.getString("CitaEstado"));
//                String estado = resultado.getString("CitaEstado");
//                cita = new Cita(IdCita, horario, paciente, estado);
                return cita;
            } else {
                throw new SQLException("No existe la cita.");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al buscar " + e.getMessage());//System.out.println(e.getMessage());
        }
       
    }

    public int siguienteCita() throws SQLException {
        String consultaSQL = "SELECT ISNULL(MAX(CitaID),0)+1 AS CitaID FROM Cita";
        PreparedStatement sentencia;
        int id = 0;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                id = resultado.getInt("CitaID");
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return id;
    }

    public void mostrarCitasDni(DefaultTableModel modelo, String dniPaciente) {
        String consultaSQL = "SELECT c.CitaID,HA.HorarioAtencionFechaRegistro AS Fecha,HA.HorarioAtencionHoraInicio AS HoraInicio,\n"
                + "HA.HorarioAtencionHoraFin AS HoraFin,C.CitaEstado\n"
                + "FROM Cita C INNER JOIN Paciente P\n"
                + "ON C.PacienteID=P.PacienteID\n"
                + "INNER JOIN HorarioAtencion HA \n"
                + "on ha.HorarioAtencionID=c.HorarioAtencionID\n"
                + "WHERE P.PacienteDni like ? AND HA.HorarioAtencionFechaRegistro>=CAST(GETDATE() AS DATE) AND C.CitaEstado='Pendiente'";

        PreparedStatement sentencia;
        String[] titulos = {"CITA ID", "FECHA", "HORA INICIO", "HORA FIN", "ESTADO"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, dniPaciente + "%");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {

                int idCita = resultado.getInt("CitaID");
                java.sql.Date fecha = resultado.getDate("Fecha");
                String hinicio = resultado.getString("HoraInicio");
                String hfin = resultado.getString("HoraFin");
                String estado = resultado.getString("CitaEstado");
                String[]  fila= {String.valueOf(idCita), String.valueOf(fecha), hinicio, hfin, estado};
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public void mostrarCitas(DefaultTableModel modelo) throws SQLException {
        String consultaSQL = "SELECT c.CitaID,HA.HorarioAtencionFechaRegistro AS Fecha,HA.HorarioAtencionHoraInicio AS HoraInicio,\n"
                + "HA.HorarioAtencionHoraFin AS HoraFin, C.CitaEstado\n"
                + "FROM Cita C INNER JOIN Paciente P\n"
                + "ON C.PacienteID=P.PacienteID\n"
                + "INNER JOIN HorarioAtencion HA \n"
                + "on ha.HorarioAtencionID=c.HorarioAtencionID\n"
                + "WHERE HA.HorarioAtencionFechaRegistro>=CAST(GETDATE() AS DATE) AND C.CitaEstado='Pendiente'";
        PreparedStatement sentencia;
        String[] titulos = {"CITA ID", "FECHA CITA", "HORA INICIO", "HORA FIN", "ESTADO"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {

                int idCita = resultado.getInt("CitaID");
                java.sql.Date fecha = resultado.getDate("Fecha");
                String hinicio = resultado.getString("HoraInicio");
                String hfin = resultado.getString("HoraFin");
                String estado = resultado.getString("CitaEstado");
                String[] fila = {String.valueOf(idCita), String.valueOf(fecha), hinicio, hfin, estado};
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}
