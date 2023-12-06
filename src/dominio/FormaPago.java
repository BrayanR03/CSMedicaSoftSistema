
package dominio;

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
