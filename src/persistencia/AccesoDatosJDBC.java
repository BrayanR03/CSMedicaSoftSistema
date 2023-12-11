package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HOME
 */
public abstract class AccesoDatosJDBC {

    protected Connection conexion;
    private final String MENSAJE = "Ocurrio un problema con la conexión";

    public abstract void abrirConexion() throws SQLException;

    public void cerrarConexion() throws SQLException {
        try {
            conexion.close();
        } catch (SQLException e) {
            throw new SQLException(MENSAJE, e);
        }

    }

    public void iniciarTransaccion() throws SQLException {
        try {
            conexion.setAutoCommit(false);
        } catch (SQLException e) {
            throw new SQLException(MENSAJE, e);
        }
    }

    public void terminarTransaccion() throws SQLException {
        try {
            conexion.commit();
            conexion.setAutoCommit(true);
            conexion.close();
        } catch (SQLException e) {
            throw new SQLException(MENSAJE, e);
        }
    }

    public void cancelarTransaccion() throws SQLException {
        try {
            conexion.rollback();
            conexion.setAutoCommit(true);
            conexion.close();
        } catch (SQLException e) {
            throw new SQLException(MENSAJE, e);
        }
    }

    public PreparedStatement prepararSentencia(String sql) throws SQLException {
        try {
            return conexion.prepareStatement(sql);
        } catch (SQLException e) {
            throw new SQLException(MENSAJE, e);
        }
    }

    public ResultSet ejecutarConsulta(String sql) throws SQLException {

        try {            
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            return resultado;
        } catch (SQLException e) {
            throw new SQLException(MENSAJE, e);
        }
    }
}
