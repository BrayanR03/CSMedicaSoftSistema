
package persistencia;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import dominio.FormaPago;

/**
 *
 * @author USER
 */
public class FormaPagoSqlServer {
    
    private AccesoDatosJDBC accesoDatosJDBC;
    
    public FormaPagoSqlServer(AccesoDatosJDBC accesoDatosJDBC){
        this.accesoDatosJDBC=accesoDatosJDBC;
    }
    
    public FormaPago BuscarFormaPago(String codigo)throws Exception{
    
        String consultaSQL="SELECT FormaPagoDescripcion FROM FormaPago WHERE FormaPagoCodigo=?";
        PreparedStatement sentencia;
        FormaPago formaPago=new FormaPago();
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, codigo);
            ResultSet resultado=sentencia.executeQuery();
            if(resultado.next()){
            
                String descripcion=resultado.getString("FormaPagoDescripcion");
                formaPago=new FormaPago(codigo,descripcion);
                
            }
        } catch (Exception e) {
            throw new Exception("Error al seleccionar la forma de pago",e);
        }
        return formaPago;
    }
    
    public DefaultComboBoxModel<FormaPago> FormaPagoDescripcion(){
        String consultaSQL="SELECT FormaPagoCodigo,FormaPagoDescripcion FROM FormaPago ";
        DefaultComboBoxModel<FormaPago> combito=new DefaultComboBoxModel<>();
        PreparedStatement sentencia;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(consultaSQL);
            combito.addElement(new FormaPago("","--SELECCIONAR--"));
            ResultSet resultado=sentencia.executeQuery();
            
            while(resultado.next()){            
                String codigo=resultado.getString("FormaPagoCodigo");
                String descripcion=resultado.getString("FormaPagoDescripcion");
                combito.addElement(new FormaPago(codigo,descripcion));
            }
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        return combito;
    }
    
}
