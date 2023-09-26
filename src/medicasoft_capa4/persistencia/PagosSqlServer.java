/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa4.persistencia;

import java.sql.*;
import medicasoft_capa3.dominio.Pagos;

/**
 *
 * @author USER
 */
public class PagosSqlServer {
    
    private AccesoDatosJDBC accesoDatosJDBC;
    
    public PagosSqlServer(AccesoDatosJDBC accesoDatosJDBC){
        this.accesoDatosJDBC=accesoDatosJDBC;
    }
    
    public void RegistrarPago(Pagos pagos){
        
        String insertSQL="INSERT INTO Pagos(CitaID,FechaPago,MontoTotal,FormaPagoCodigo)\n" +
                         "VALUES(?,?,?,?)";
        PreparedStatement sentencia;
        try {
            
            System.out.println(pagos.toString());
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
    
    public int PagoIDSiguiente(){
        
//        String consultaSQL="SELECT ISNULL(MAX(PagosID),0)+1 PagosID FROM Pagos";
        String consultaSQL="SELECT IFNULL(MAX(PagosID),0)+1 PagosID FROM Pagos";
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
