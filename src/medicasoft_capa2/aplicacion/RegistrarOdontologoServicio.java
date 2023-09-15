
package medicasoft_capa2.aplicacion;

import java.util.List;
import medicasoft_capa3.dominio.Odontologo;
import medicasoft_capa4.persistencia.AccesoDatosJDBC;
import medicasoft_capa4.persistencia.AccesoDatosJDBCPostgreSQL;
import medicasoft_capa4.persistencia.OdontologoSqlServer;

public class RegistrarOdontologoServicio {
    private AccesoDatosJDBC accesoDatosJDBC;
    private OdontologoSqlServer odontologoSqlServer;

    public RegistrarOdontologoServicio() {
        accesoDatosJDBC =new AccesoDatosJDBCPostgreSQL();
        odontologoSqlServer=new OdontologoSqlServer(accesoDatosJDBC);
    }
    
    
    public void guardar(Odontologo odontologo)throws Exception{
    
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        List<String> dniod = odontologoSqlServer.obtenerDNIOdontologo(odontologo);

        if (odontologo.TieneDniUnicoOdontologo(dniod)) {
            throw new Exception("Ya esta registrado este dni en la base de datos ");
        }
        odontologoSqlServer.RegistrarOdontologo(odontologo);
        accesoDatosJDBC.terminarTransaccion();
    }
    
    public int retornarID()throws Exception{
    
        accesoDatosJDBC.abrirConexion();
        
        int idSiguiente=odontologoSqlServer.OdontologoIDSiguiente();
        accesoDatosJDBC.cerrarConexion();
        return idSiguiente;
    }
}
