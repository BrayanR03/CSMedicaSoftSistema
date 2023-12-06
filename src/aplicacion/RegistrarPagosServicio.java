/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import persistencia.CitaSqlServer;
import persistencia.FormaPagoSqlServer;
import persistencia.PagosSqlServer;
import persistencia.AccesoDatosJDBC;
import persistencia.AccesoDatosJDBCSqlServer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import dominio.Cita;
import dominio.FormaPago;
import dominio.Pagos;

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
    
    public void mostrarCitasSinCancelar(DefaultTableModel modelo)throws Exception{
        accesoDatosJDBC.abrirConexion();
        citaSqlServer.mostrarCitas(modelo);
        accesoDatosJDBC.cerrarConexion();
    }
    public void mostrarCitasSinCancelarDni(DefaultTableModel modelo,String dni)throws Exception{
        accesoDatosJDBC.abrirConexion();
        citaSqlServer.mostrarCitasDni(modelo,dni);
        accesoDatosJDBC.cerrarConexion();
    }
    
    public Cita buscarCita(int citaID)throws Exception{
        
        accesoDatosJDBC.abrirConexion();
        Cita cita=citaSqlServer.buscarCita(citaID);
        accesoDatosJDBC.cerrarConexion();
        return cita;
        
    }
    public DefaultComboBoxModel<FormaPago> comboFormaPago()throws Exception{
        accesoDatosJDBC.abrirConexion();
        DefaultComboBoxModel<FormaPago> forma= formaPagoSqlServer.formaPagoDescripcion();
        accesoDatosJDBC.cerrarConexion();
        return forma;
    }
    
    public FormaPago buscarFormaPago(String codigo)throws Exception{
    
        accesoDatosJDBC.abrirConexion();
        FormaPago formaPago=formaPagoSqlServer.buscarFormaPago(codigo);
        accesoDatosJDBC.cerrarConexion();
        return formaPago;
    }
    public int siguienteIDPago()throws Exception{
        accesoDatosJDBC.abrirConexion();
        int idPago=pagosSqlServer.pagoIdSiguiente();
        accesoDatosJDBC.cerrarConexion();
        return idPago;
    }
    public void registrar(Pagos pagos)throws Exception{
        
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        pagosSqlServer.registrarPago(pagos);
        accesoDatosJDBC.terminarTransaccion();
    
    }
    
}
