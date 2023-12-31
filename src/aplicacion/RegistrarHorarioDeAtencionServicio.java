/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.List;
import dominio.HorarioAtencion;
import dominio.Odontologo;
import persistencia.AccesoDatosJDBC;
import persistencia.AccesoDatosJDBCSqlServer;
import persistencia.HorarioAtencionSqlServer;
import persistencia.OdontologoSqlServer;
public class RegistrarHorarioDeAtencionServicio {

    private AccesoDatosJDBC accesoDatosJDBC;
    private HorarioAtencionSqlServer horarioAtencionSqlServer;
    private OdontologoSqlServer odontologoSqlServer;

    public RegistrarHorarioDeAtencionServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCSqlServer();
        horarioAtencionSqlServer = new HorarioAtencionSqlServer(accesoDatosJDBC);
        odontologoSqlServer = new OdontologoSqlServer(accesoDatosJDBC);
    }

    public Odontologo buscar(String dniodontologo) throws Exception {

        accesoDatosJDBC.abrirConexion();
        
        Odontologo odontologo = odontologoSqlServer.buscar(dniodontologo);
        accesoDatosJDBC.cerrarConexion();
        return odontologo;
    }

    public void guardar(HorarioAtencion horario) throws Exception {

        if (!horario.tieneHoraValida()) {
            throw new Exception("La hora no es valida");
        }

        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        List<String> horas = horarioAtencionSqlServer.obtenerHoras(horario);
        if (horario.tieneHoraUnicaValida(horas)) {
            throw new Exception("Ya existe un horario con las horas ingresadas");
        }
        if (!horario.tieneDiaValido()) {
            throw new Exception("No se puede registrar un horario los días SABADO o DOMINGO");
        }
        horarioAtencionSqlServer.guardar(horario);
        accesoDatosJDBC.terminarTransaccion();
        accesoDatosJDBC.cerrarConexion();
    }
    
    public int idSiguiente()throws Exception{
        accesoDatosJDBC.abrirConexion();
        int horarioID=horarioAtencionSqlServer.siguienteHorarioAtencionID();
        accesoDatosJDBC.cerrarConexion();
        return horarioID;
    }
}
