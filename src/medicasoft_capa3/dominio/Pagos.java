
package medicasoft_capa3.dominio;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Pagos {
    
    private int pagoID;
    private Cita citaID;
    private java.sql.Date fechaPago;
    private double montoTotal;
    private FormaPago formaPagoCodigo;

    public Pagos() {
    }

    public Pagos(int pagoID, Cita citaID, Date fechaPago, double montoTotal, FormaPago formaPagoCodigo) {
        this.pagoID = pagoID;
        this.citaID = citaID;
        this.fechaPago = fechaPago;
        this.montoTotal = montoTotal;
        this.formaPagoCodigo = formaPagoCodigo;
    }

    public int getPagoID() {
        return pagoID;
    }

    public void setPagoID(int pagoID) {
        this.pagoID = pagoID;
    }

    public Cita getCitaID() {
        return citaID;
    }

    public void setCitaID(Cita citaID) {
        this.citaID = citaID;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public FormaPago getFormaPagoCodigo() {
        return formaPagoCodigo;
    }

    public void setFormaPagoCodigo(FormaPago formaPagoCodigo) {
        this.formaPagoCodigo = formaPagoCodigo;
    }

    @Override
    public String toString() {
        return "Pagos{" + "PagoID=" + pagoID + ", CitaID=" + citaID.getCitaID() + ", FechaPago=" + fechaPago + ", MontoTotal=" + montoTotal + ", FormaPagoCodigo=" + formaPagoCodigo.getFormaPagoCodigo() + '}';
    }
    
    
}
