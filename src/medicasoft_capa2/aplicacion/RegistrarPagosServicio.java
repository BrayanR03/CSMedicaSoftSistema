/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa2.aplicacion;

import medicasoft_capa3.dominio.Cita;
import medicasoft_capa3.dominio.FormaPago;
import medicasoft_capa3.dominio.Pagos;
import medicasoft_capa4.persistencia.*;

/**
 *
 * @author USER
 */
public class RegistrarPagosServicio {
    
    private AccesoDatosJDBC accesoDatosJDBC;
    private CitaSqlServer citaSqlServer;
    private PagosSqlServer pagosSqlServer;
    private FormaPagoSqlServer formaPagoSqlServer;
    
    
    public RegistrarPagosServicio(){
        this.accesoDatosJDBC=new AccesoDatosJDBCSqlServer();
        this.citaSqlServer=new CitaSqlServer(accesoDatosJDBC);
        this.formaPagoSqlServer=new FormaPagoSqlServer(accesoDatosJDBC);
        this.pagosSqlServer=new PagosSqlServer(accesoDatosJDBC);
    }
    
    
    public Cita buscarCita(int citaID)throws Exception{
        
        accesoDatosJDBC.abrirConexion();
        Cita cita=citaSqlServer.BuscarCita(citaID);
        accesoDatosJDBC.cerrarConexion();
        return cita;
        
    }
    
    public FormaPago buscarFormaPago(String codigo)throws Exception{
    
        accesoDatosJDBC.abrirConexion();
        FormaPago formaPago=formaPagoSqlServer.BuscarFormaPago(codigo);
        accesoDatosJDBC.cerrarConexion();
        return formaPago;
    }
    
    public void registrar(Pagos pagos)throws Exception{
        
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        pagosSqlServer.RegistrarPago(pagos);
        accesoDatosJDBC.terminarTransaccion();
    
    }
    
}
