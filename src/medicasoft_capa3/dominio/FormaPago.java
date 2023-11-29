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
    
    private String formaPagoCodigo;
    private String formaPagoDescripcion;

    public FormaPago() {
    }

    public FormaPago(String formaPagoCodigo, String formaPagoDescripcion) {
        this.formaPagoCodigo = formaPagoCodigo;
        this.formaPagoDescripcion = formaPagoDescripcion;
    }

    public String getFormaPagoCodigo() {
        return formaPagoCodigo;
    }

    public void setFormaPagoCodigo(String formaPagoCodigo) {
        this.formaPagoCodigo = formaPagoCodigo;
    }

    public String getFormaPagoDescripcion() {
        return formaPagoDescripcion;
    }

    public void setFormaPagoDescripcion(String formaPagoDescripcion) {
        this.formaPagoDescripcion = formaPagoDescripcion;
    }
    
    
}
