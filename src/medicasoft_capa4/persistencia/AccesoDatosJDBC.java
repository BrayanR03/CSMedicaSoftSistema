/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa4.persistencia;

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

    public abstract void abrirConexion() throws Exception;

    public void cerrarConexion() throws SQLException {
        try {
            conexion.close();
        } catch (Exception e) {
            throw new SQLException("Ocurrio un problema con la conexión", e);
        }

    }

    public void iniciarTransaccion() throws SQLException {
        try {
            conexion.setAutoCommit(false);
        } catch (Exception e) {
            throw new SQLException("Ocurrio un problema con la conexión", e);
        }
    }

    public void terminarTransaccion() throws SQLException {
        try {
            conexion.commit();
            conexion.setAutoCommit(true);
            conexion.close();
        } catch (Exception e) {
            throw new SQLException("Ocurrio un problema con la conexión", e);
        }
    }

    public void cancelarTransaccion() throws SQLException {
        try {
            conexion.rollback();
            conexion.setAutoCommit(true);
            conexion.close();
        } catch (Exception e) {
            throw new SQLException("Ocurrio un problema con la conexión", e);
        }
    }

    public PreparedStatement prepararSentencia(String sql) throws SQLException {
        try {
            return conexion.prepareStatement(sql);
        } catch (Exception e) {
            throw new SQLException("Ocurrio un problema con la conexión", e);
        }
    }

    public ResultSet ejecutarConsulta(String sql) throws SQLException {
            Statement sentencia = null;
            ResultSet resultado = null;
        try {
           
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
            return resultado;
        } catch (Exception e) {
            throw new SQLException("Ocurrio un problema con la conexión", e);
        }finally{
            resultado.close();
            sentencia.close();
        }
    }
}
