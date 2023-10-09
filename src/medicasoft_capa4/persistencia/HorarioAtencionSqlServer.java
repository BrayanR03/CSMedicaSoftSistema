/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa4.persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import medicasoft_capa3.dominio.HorarioAtencion;
import medicasoft_capa3.dominio.Odontologo;

/**
 *
 * @author USER
 */
public class HorarioAtencionSqlServer {
     
    private AccesoDatosJDBC accesoDatosJDBC;
     private OdontologoSqlServer odontologoSqlServer;

    public HorarioAtencionSqlServer(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
        this.odontologoSqlServer = new OdontologoSqlServer(accesoDatosJDBC);
    }

    public void guardar(HorarioAtencion horario) {

        String insertSQL = "INSERT INTO HorarioAtencion(HorarioAtencionEstado,HorarioAtencionFechaRegistro,HorarioAtencionHoraInicio,HorarioAtencionHoraFin,OdontologoID)\n" +
                           "VALUES(?,?,?,?,?)";
        PreparedStatement sentencia;

        try {

            sentencia = accesoDatosJDBC.prepararSentencia(insertSQL);
            sentencia.setString(1, horario.getHorarioAtencionEstado());
            sentencia.setDate(2, horario.getHorarioAtencionFechaRegistro());
            sentencia.setString(3, horario.getHorarioAtencionHoraInicio());
            sentencia.setString(4, horario.getHorarioAtencionHoraFin());
            sentencia.setInt(5, horario.getOdontologoID().getOdontologoID());
            sentencia.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR AL INGRESAR DATOS" + e.getMessage());
        }

    }
    
    public HorarioAtencion buscar(int horarioID) throws Exception {
        String consultaSQL ="SELECT HA.HorarioAtencionEstado,HA.HorarioAtencionFechaRegistro,HA.HorarioAtencionHoraInicio,\n" +
"HA.HorarioAtencionHoraFin,ODO.OdontologoDni \n" +
"FROM HorarioAtencion HA INNER JOIN Odontologo ODO\n" +
"ON ODO.OdontologoID=HA.OdontologoID\n" +
"WHERE HA.HorarioAtencionID=?"; 
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setInt(1,horarioID);
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                HorarioAtencion horario = new HorarioAtencion();
                horario.setHorarioAtencionID(horarioID);
                horario.setHorarioAtencionEstado(resultado.getString("HorarioAtencionEstado"));
                horario.setHorarioAtencionFechaRegistro(resultado.getDate("HorarioAtencionFechaRegistro"));
                horario.setHorarioAtencionHoraInicio(resultado.getString("HorarioAtencionHoraInicio"));
                horario.setHorarioAtencionHoraFin(resultado.getString("HorarioAtencionHoraFin"));
                Odontologo odontologo = odontologoSqlServer.buscar(resultado.getString("OdontologoDni"));
                horario.setOdontologoID(odontologo);

                return horario;
            } else {
                throw new Exception("No existe el odontologo.");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar ", e);
        }
    }
    
    
     public List<String> obtenerHoras(HorarioAtencion horario) throws Exception {
        String consultaSQL = "SELECT HorarioAtencionHoraInicio,HorarioAtencionHoraFin FROM HorarioAtencion WHERE HorarioAtencionFechaRegistro=?";
        PreparedStatement sentencia;
        List<String> horas = new ArrayList<>();
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setDate(1, horario.getHorarioAtencionFechaRegistro());
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()) {
                horas.add(resultado.getString("HorarioAtencionHoraInicio").trim());
                horas.add(resultado.getString("HorarioAtencionHoraFin").trim());
            }
            System.out.println("capa persistencia lista horas "+horas.toString());
        } catch (Exception e) {
            System.out.println("error metodo obtenerhoras" + e);
            throw new Exception("Error al verificar si existe el horario");
        }
        return horas;
    }
     
      public void Mostrar(DefaultTableModel modelo,int usuario) throws Exception {

        String mostraSQL ="select hor.HorarioAtencionID,hor.HorarioAtencionEstado,hor.HorarioAtencionFechaRegistro,hor.HorarioAtencionHoraInicio,hor.HorarioAtencionHoraFin,hor.OdontologoID ,odo.OdontologoNombres,odo.OdontologoApellidos\n" +
"from HorarioAtencion HOR LEFT JOIN Odontologo ODO on hor.OdontologoID=odo.OdontologoID\n" +
"inner join Empleado e on e.EmpleadoID=odo.EmpleadoID\n" +
"inner join Usuario u on u.UsuarioID=e.UsuarioID\n" +
"where HOR.HorarioAtencionEstado='DISPONIBLE' and HOR.HorarioAtencionFechaRegistro>=CAST(GETDATE() AS DATE) and u.UsuarioID=?";
        PreparedStatement sentencia;

        String titulos[] = {"HORARIO ID", "ESTADO", "FECHA", "HORA INICIO", "HORA FIN", "ODONTOLOGO","ID ODONTOLOGO"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(mostraSQL);
            sentencia.setInt(1, usuario);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String codigohorario = resultado.getString("HorarioAtencionID");
                String estado = resultado.getString("HorarioAtencionEstado");
                java.sql.Date fecha = resultado.getDate("HorarioAtencionFechaRegistro");
                String horainicio = resultado.getString("HorarioAtencionHoraInicio");
                String horafin = resultado.getString("HorarioAtencionHoraFin");
                int odontologoID=resultado.getInt("OdontologoID");
                String nombresyapellidos = resultado.getString("OdontologoNombres")+" "+resultado.getString("OdontologoApellidos");
                String fila[] = {codigohorario, estado, String.valueOf(fecha), horainicio, horafin, nombresyapellidos,String.valueOf(odontologoID)};
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar buscar el horario.", e);
        }

    }

  public int SiguienteHorarioAtencionID()throws Exception{
      String consultaSQL="SELECT ISNULL(MAX(HorarioAtencionID),0)+1 AS HorarioAtencionID FROM HorarioAtencion";
//      String consultaSQL="SELECT IFNULL(MAX(HorarioAtencionID),0)+1 AS HorarioAtencionID FROM HorarioAtencion";
      PreparedStatement sentencia;
      int id=0;
      try {
          sentencia=accesoDatosJDBC.prepararSentencia(consultaSQL);
          ResultSet resultado=sentencia.executeQuery();
          if(resultado.next()){
              id=resultado.getInt("HorarioAtencionID");
          }
      } catch (Exception e) {
          System.out.println("Error"+e.getMessage());
      }
      return id;
  }


    
}
