
package persistencia;

import java.sql.*;
import dominio.Pagos;

/**
 *
 * @author USER
 */
public class PagosSqlServer {
    
    private AccesoDatosJDBC accesoDatosJDBC;
    
    public PagosSqlServer(AccesoDatosJDBC accesoDatosJDBC){
        this.accesoDatosJDBC=accesoDatosJDBC;
    }
    
    public void registrarPago(Pagos pagos){
        
        String insertSQL="INSERT INTO Pagos(CitaID,FechaPago,MontoTotal,FormaPagoCodigo)\n" +
                         "VALUES(?,?,?,?)";
        PreparedStatement sentencia;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(insertSQL);
            sentencia.setInt(1, pagos.getCitaID().getCitaID());
            sentencia.setDate(2, pagos.getFechaPago());
            sentencia.setDouble(3, pagos.getMontoTotal());
            sentencia.setString(4, pagos.getFormaPagoCodigo().getFormaPagoCodigo());
            sentencia.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int pagoIdSiguiente(){
        
        String consultaSQL="SELECT ISNULL(MAX(PagosID),0)+1 AS PagosID FROM Pagos";
        PreparedStatement sentencia;
        int id=0;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(consultaSQL);
            ResultSet resultado=sentencia.executeQuery();
            if(resultado.next()){
                id=resultado.getInt("PagosID");
            }
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
        return id;
    }
    
    
}
