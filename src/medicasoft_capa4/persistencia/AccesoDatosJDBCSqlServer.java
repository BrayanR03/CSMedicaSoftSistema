/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa4.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author HOME
 */
public class AccesoDatosJDBCSqlServer extends AccesoDatosJDBC {

    private String pass = "12345";
    
    @Override
    public void abrirConexion() throws Exception {
         try {
            //Class.forName("org.postgresql.Driver");
            String url = "jdbc:sqlserver://LAPTOP-D05MS1MQ\\SQLEXPRESS:1433;"
                    + "database=BD_SistemaCitas;"
                    + "user=sa;"
                    + "password=12345;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;"
                    + "loginTimeout=30";
            conexion = DriverManager.getConnection(url, "sa", pass);
        } catch (Exception e) {
            throw new Exception("Ocurrio un problema en la conexión con la base de datos.", e);
        }
    }

//    private final String HOST = "localhost";
//    private final String PUERTO = "3306";
//    private final String DATABASE ="DB_SistemasCitas";
//    private String user = "root";
//    private String pass = "admin";
//    
//        @Override
//    public void abrirConexion() throws Exception {
//         try {
//            String url = "jdbc:mysql://"+HOST+":"+PUERTO+"/"+DATABASE;
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conexion = DriverManager.getConnection(url, user, pass);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Ocurrio un error al conectarse con la base de datos:" + e.getMessage() , "Sistema", JOptionPane.ERROR_MESSAGE);
//        }        
//    }
    
}
