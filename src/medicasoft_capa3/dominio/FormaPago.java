/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa3.dominio;

/**
 *
 * @author USER
 */
public class FormaPago {
    
    private String FormaPagoCodigo;
    private String FormaPagoDescripcion;

    public FormaPago() {
    }

    public FormaPago(String FormaPagoCodigo, String FormaPagoDescripcion) {
        this.FormaPagoCodigo = FormaPagoCodigo;
        this.FormaPagoDescripcion = FormaPagoDescripcion;
    }

    public String getFormaPagoCodigo() {
        return FormaPagoCodigo;
    }

    public void setFormaPagoCodigo(String FormaPagoCodigo) {
        this.FormaPagoCodigo = FormaPagoCodigo;
    }

    public String getFormaPagoDescripcion() {
        return FormaPagoDescripcion;
    }

    public void setFormaPagoDescripcion(String FormaPagoDescripcion) {
        this.FormaPagoDescripcion = FormaPagoDescripcion;
    }
    
    
}
