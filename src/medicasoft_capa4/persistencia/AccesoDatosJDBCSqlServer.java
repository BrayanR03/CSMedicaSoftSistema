/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa4.persistencia;

import java.sql.DriverManager;

/**
 *
 * @author HOME
 */
public class AccesoDatosJDBCSqlServer extends AccesoDatosJDBC {

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
            conexion = DriverManager.getConnection(url, "sa", "12345");
        } catch (Exception e) {
            throw new Exception("Ocurrio un problema en la conexión con la base de datos.", e);
        }
    }
    
}
