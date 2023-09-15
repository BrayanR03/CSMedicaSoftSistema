
package medicasoft_capa1.presentacion;

import medicasoft_capa4.persistencia.AccesoDatosJDBC;
import medicasoft_capa4.persistencia.AccesoDatosJDBCPostgreSQL;


public class ProgramaInicio {
    public static void main(String[] args) {
        try {
            AccesoDatosJDBC datito=new AccesoDatosJDBCPostgreSQL();
            datito.abrirConexion();
            System.out.println("ACA"+datito);
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
        InicioSesion forminiciosesion = new InicioSesion();
        forminiciosesion.setVisible(true);
    }
}

