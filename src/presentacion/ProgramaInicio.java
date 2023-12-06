
package presentacion;

import persistencia.AccesoDatosJDBC;
import persistencia.AccesoDatosJDBCSqlServer;


public class ProgramaInicio {
    public static void main(String[] args) {
        try {
            AccesoDatosJDBC datito=new AccesoDatosJDBCSqlServer();
            datito.abrirConexion();
            System.out.println("ACA"+datito);
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
        InicioSesion forminiciosesion = new InicioSesion();
        forminiciosesion.setVisible(true);
    }
}

