/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa2.aplicacion;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
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
    
    public void MostrarCitasSinCancelar(DefaultTableModel modelo)throws Exception{
        accesoDatosJDBC.abrirConexion();
        citaSqlServer.MostrarCitas(modelo);
        accesoDatosJDBC.cerrarConexion();
    }
    public void MostrarCitasSinCancelarDni(DefaultTableModel modelo,String dni)throws Exception{
        accesoDatosJDBC.abrirConexion();
        citaSqlServer.MostrarCitasDni(modelo,dni);
        accesoDatosJDBC.cerrarConexion();
    }
    
    public Cita buscarCita(int citaID)throws Exception{
        
        accesoDatosJDBC.abrirConexion();
        Cita cita=citaSqlServer.BuscarCita(citaID);
        accesoDatosJDBC.cerrarConexion();
        return cita;
        
    }
    public DefaultComboBoxModel<FormaPago> comboFormaPago()throws Exception{
        accesoDatosJDBC.abrirConexion();
        DefaultComboBoxModel<FormaPago> forma= formaPagoSqlServer.FormaPagoDescripcion();
        accesoDatosJDBC.cerrarConexion();
        return forma;
    }
    
    public FormaPago buscarFormaPago(String codigo)throws Exception{
    
        accesoDatosJDBC.abrirConexion();
        FormaPago formaPago=formaPagoSqlServer.BuscarFormaPago(codigo);
        accesoDatosJDBC.cerrarConexion();
        return formaPago;
    }
    public int SiguienteIDPago()throws Exception{
        accesoDatosJDBC.abrirConexion();
        int idPago=pagosSqlServer.PagoIDSiguiente();
        accesoDatosJDBC.cerrarConexion();
        return idPago;
    }
    public void registrar(Pagos pagos)throws Exception{
        
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        pagosSqlServer.RegistrarPago(pagos);
        accesoDatosJDBC.terminarTransaccion();
    
    }
    
}
