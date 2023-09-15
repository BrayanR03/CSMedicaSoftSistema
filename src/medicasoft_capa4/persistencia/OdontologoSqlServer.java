/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa4.persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import medicasoft_capa3.dominio.Odontologo;
import medicasoft_capa3.dominio.Usuario;

/**
 *
 * @author USER
 */
public class OdontologoSqlServer {
    
    private AccesoDatosJDBC accesoDatosJDBC;
    private UsuarioSqlServer usuarioSqlServer;
    
    public OdontologoSqlServer(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
        this.usuarioSqlServer=new UsuarioSqlServer(accesoDatosJDBC);
    }

    
    public void RegistrarOdontologo(Odontologo odontologo){
        
        String insertSQL="EXEC RegistrarOdontologo @apellidos=?,@nombres=?,@fecha=?,@dni=?,@direccion=?,@telefono=?,@correo=?";
        PreparedStatement sentencia;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(insertSQL);
            sentencia.setString(1, odontologo.getOdontologoApellidos());
            sentencia.setString(2, odontologo.getOdontologoNombres());
            sentencia.setDate(3, odontologo.getOdontologoFechaNacimiento());
            sentencia.setString(4, odontologo.getOdontologoDni());
            sentencia.setString(5, odontologo.getOdontologoDireccion());
            sentencia.setString(6, odontologo.getOdontologoTelefono());
            sentencia.setString(7, odontologo.getOdontologoCorreo());
            sentencia.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR" +e.getMessage());
        }
        
    }
    public List<String> obtenerDNIOdontologo(Odontologo odontologo) throws Exception {
        String consultaSQL = "SELECT OdontologoDni FROM Odontologo WHERE OdontologoDni=?";
        PreparedStatement sentencia;
        List<String> dni = new ArrayList<>();
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, odontologo.getOdontologoDni());
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()) {
                dni.add(resultado.getString(1));
                
            }
        } catch (Exception e) {
            System.out.println("error metodo dni unico" + e);
            throw new Exception("Error al verificar si existe el dni");
        }
        return dni;
    }
    /*
    public Odontologo buscar(String dni) throws Exception {
        String consultaSQL = "SELECT O.OdontologoID,O.OdontologoApellidos,O.OdontologoNombres,O.OdontologoFechaNacimiento,O.OdontologoDni,\n" +
                             "O.OdontologoDireccion,O.OdontologoTelefono,O.OdontologoCorreo,u.Usuario as Usuario\n" +
                             "FROM Odontologo O INNER JOIN Usuario u ON u.UsuarioID=O.UsuarioID\n" +
                             "WHERE OdontologoDni=?";
        PreparedStatement sentencia;        
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, dni);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                Odontologo odontologo = new Odontologo();
                odontologo.setOdontologoID(resultado.getInt("OdontologoID"));
                odontologo.setOdontologoApellidos(resultado.getString("OdontologoApellidos"));
                odontologo.setOdontologoNombres(resultado.getString("OdontologoNombres"));
                odontologo.setOdontologoFechaNacimiento(resultado.getDate("OdontologoFechaNacimiento"));
                odontologo.setOdontologoDni(resultado.getString(dni));
                odontologo.setOdontologoDireccion(resultado.getString("OdontologoDireccion"));
                odontologo.setOdontologoTelefono(resultado.getString("OdontologoTelefono"));
                odontologo.setOdontologoCorreo(resultado.getString("OdontologoCorreo"));
                Usuario usu=usuarioSqlServer.BuscarUsuario(resultado.getString("Usuario"));
                odontologo.setUsuarioID(usu);
               
                return odontologo;
            }
            else {
                throw new Exception("No existe el odontologo.");
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar buscar el odontologo.", e);
        }
    }*/
    
    public int OdontologoIDSiguiente(){
        
        String consultaSQL="SELECT ISNULL(MAX(OdontologoID),0)+ 1 AS OdontologoID FROM ODONTOLOGO";
        PreparedStatement sentencia;
        int idOdontologo=0;
        try {
            sentencia=accesoDatosJDBC.prepararSentencia(consultaSQL);
            ResultSet resultado=sentencia.executeQuery();
            if(resultado.next()){
                idOdontologo=resultado.getInt("OdontologoID");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idOdontologo;
    }
}
