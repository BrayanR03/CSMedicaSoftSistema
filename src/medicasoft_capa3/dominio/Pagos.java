/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa3.dominio;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Pagos {
    
    private int PagoID;
    private Cita CitaID;
    private java.sql.Date FechaPago;
    private double MontoTotal;
    private FormaPago FormaPagoCodigo;

    public Pagos() {
    }

    public Pagos(int PagoID, Cita CitaID, Date FechaPago, double MontoTotal, FormaPago FormaPagoCodigo) {
        this.PagoID = PagoID;
        this.CitaID = CitaID;
        this.FechaPago = FechaPago;
        this.MontoTotal = MontoTotal;
        this.FormaPagoCodigo = FormaPagoCodigo;
    }

    public int getPagoID() {
        return PagoID;
    }

    public void setPagoID(int PagoID) {
        this.PagoID = PagoID;
    }

    public Cita getCitaID() {
        return CitaID;
    }

    public void setCitaID(Cita CitaID) {
        this.CitaID = CitaID;
    }

    public Date getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(Date FechaPago) {
        this.FechaPago = FechaPago;
    }

    public double getMontoTotal() {
        return MontoTotal;
    }

    public void setMontoTotal(double MontoTotal) {
        this.MontoTotal = MontoTotal;
    }

    public FormaPago getFormaPagoCodigo() {
        return FormaPagoCodigo;
    }

    public void setFormaPagoCodigo(FormaPago FormaPagoCodigo) {
        this.FormaPagoCodigo = FormaPagoCodigo;
    }
    
    
}
