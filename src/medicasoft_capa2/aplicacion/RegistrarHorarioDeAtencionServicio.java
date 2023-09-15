/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa2.aplicacion;

import java.util.List;
//import medicasoft_capa3.dominio.Horario;
import medicasoft_capa3.dominio.Odontologo;
import medicasoft_capa4.persistencia.AccesoDatosJDBC;
import medicasoft_capa4.persistencia.AccesoDatosJDBCPostgreSQL;
///import medicasoft_capa4.persistencia.HorarioPostgreSQL;
//import medicasoft_capa4.persistencia.OdontologoPostgreSQL;

public class RegistrarHorarioDeAtencionServicio {
/*
    private AccesoDatosJDBC accesoDatosJDBC;
    private HorarioPostgreSQL horarioPostgreSQL;
    private OdontologoPostgreSQL odontologoPostgreSQL;

    public RegistrarHorarioDeAtencionServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCPostgreSQL();
        horarioPostgreSQL = new HorarioPostgreSQL(accesoDatosJDBC);
        odontologoPostgreSQL = new OdontologoPostgreSQL(accesoDatosJDBC);
    }

    public Odontologo buscar(String codigoodontologo) throws Exception {

        accesoDatosJDBC.abrirConexion();
        Odontologo odontologo = odontologoPostgreSQL.buscar(codigoodontologo);
        accesoDatosJDBC.cerrarConexion();
        return odontologo;
    }

    public void guardar(Horario horario) throws Exception {

        if (!horario.tieneHoraValida()) {
            throw new Exception("La hora no es valida");
        }

        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        List<String> horas = horarioPostgreSQL.obtenerHoras(horario);

        if (horario.tieneHoraUnicaValida(horas)) {
            throw new Exception("Ya existe un horario con las horas ingresadas");
        }
        horarioPostgreSQL.guardar(horario);
        accesoDatosJDBC.terminarTransaccion();
        accesoDatosJDBC.cerrarConexion();
    }*/
}
