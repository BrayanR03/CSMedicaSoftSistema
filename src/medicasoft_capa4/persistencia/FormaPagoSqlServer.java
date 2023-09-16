/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa4.persistencia;

import java.sql.*;
import medicasoft_capa3.dominio.FormaPago;

/**
 *
 * @author USER
 */
public class FormaPagoSqlServer {
    
    private AccesoDatosJDBC accesoDatosJDBC;
    
    public FormaPagoSqlServer(AccesoDatosJDBC accesoDatosJDBC){
        this.accesoDatosJDBC=accesoDatosJDBC;
    }
    
    public FormaPago BuscarFormaPago(String codigo){
    
        String consultaSQL="SELECT FormaPagoDescripcion FROM FormaPago WHERE FormaPagoCodigo=?";
        PreparedStatement sentencia;
        FormaPago formaPago=null;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(codigo);
            sentencia.setString(1, codigo);
            ResultSet resultado=sentencia.executeQuery();
            if(resultado.next()){
            
                String descripcion=resultado.getString("FormaPagoDescripcion");
                formaPago=new FormaPago(codigo,descripcion);
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return formaPago;
    }
}
