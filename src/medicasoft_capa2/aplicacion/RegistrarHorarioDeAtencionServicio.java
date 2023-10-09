/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa2.aplicacion;

import java.util.List;
import medicasoft_capa3.dominio.HorarioAtencion;
//import medicasoft_capa3.dominio.Horario;
import medicasoft_capa3.dominio.Odontologo;
import medicasoft_capa4.persistencia.AccesoDatosJDBC;
import medicasoft_capa4.persistencia.AccesoDatosJDBCSqlServer;
import medicasoft_capa4.persistencia.HorarioAtencionSqlServer;
import medicasoft_capa4.persistencia.OdontologoSqlServer;
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
        System.out.println("hora lista "+horas.toString());
        if (horario.tieneHoraUnicaValida(horas)) {
            throw new Exception("Ya existe un horario con las horas ingresadas");
        }
        horarioAtencionSqlServer.guardar(horario);
        accesoDatosJDBC.terminarTransaccion();
        accesoDatosJDBC.cerrarConexion();
    }
    
    public int idSiguiente()throws Exception{
        accesoDatosJDBC.abrirConexion();
        int horarioID=horarioAtencionSqlServer.SiguienteHorarioAtencionID();
        accesoDatosJDBC.cerrarConexion();
        return horarioID;
    }
}
