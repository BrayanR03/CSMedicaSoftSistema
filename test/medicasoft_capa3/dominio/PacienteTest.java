/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa3.dominio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class PacienteTest {

    public PacienteTest() {
    }

    @Test
    public void test1TieneEdadValida() {
        System.out.println("tieneEdadValida");
        Paciente paciente = new Paciente();
        String fecha = "2002-10-10";
        java.sql.Date fechita = Date.valueOf(fecha);
        paciente.setPacienteFechaNacimiento(fechita);
        boolean expResult = true;
        boolean result = paciente.tieneEdadValida();
        assertEquals(expResult, result);
    }

    @Test
    public void test2TieneEdadValida() {
        System.out.println("tieneEdadValida");
        Paciente paciente = new Paciente();
        String fecha = "2018-10-10";
        java.sql.Date fechita = Date.valueOf(fecha);
        paciente.setPacienteFechaNacimiento(fechita);
        boolean expResult = false;
        boolean result = paciente.tieneEdadValida();
        assertEquals(expResult, result);
    }

    @Test
    public void tes1tTieneDniUnicoPaciente() {
        System.out.println("TieneDniUnicoPaciente");
        List<String> dniUnico = new ArrayList();
        Paciente paciente = new Paciente();
        dniUnico.add("75411821");
        dniUnico.add("98765432");
        paciente.setPacienteDni("47586921");
        System.out.println(dniUnico.toString() + "dnis de lista");
        boolean expResult = false;
        boolean result = paciente.TieneDniUnicoPaciente(dniUnico);
        assertEquals(expResult, result);
    }

    @Test
    public void tes2tTieneDniUnicoPaciente() {
        System.out.println("TieneDniUnicoPaciente");
        List<String> dniUnico = new ArrayList();
        Paciente paciente = new Paciente();
        dniUnico.add("75411821");
        dniUnico.add("98765432");
        paciente.setPacienteDni("75411821");
        System.out.println(dniUnico.toString() + "dnis de lista");
        boolean expResult = true;
        boolean result = paciente.TieneDniUnicoPaciente(dniUnico);
        assertEquals(expResult, result);
    }

    @Test
    public void test1TieneDniValido() {
        System.out.println("test1_TieneDniValido");
        Paciente paciente = new Paciente();
        paciente.setPacienteDni("74890302");
        boolean expResult = true;
        boolean result = paciente.tieneDniValido();
        assertEquals(expResult, result);
    }

    @Test
    public void test2TieneDniValido() {
        System.out.println("test2_TieneDniValido");
        Paciente paciente = new Paciente();
        paciente.setPacienteDni("74890");
        boolean expResult = false;
        boolean result = paciente.tieneDniValido();
        assertEquals(expResult, result);
    }

    @Test
    public void test1TieneFormatoFechaValido() {
        System.out.println("test1_TieneFormatoFechaValida");
        Paciente paciente = new Paciente();
        boolean expected = true;
        boolean result = paciente.tieneFormatoFechaValida("2004-03-12");
        assertEquals(expected, result);
    }

    @Test
    public void test2TieneFormatoFechaValido() {
        System.out.println("test2_TieneFormatoFechaValida");
        Paciente paciente = new Paciente();
        boolean expected = false;
        boolean result = paciente.tieneFormatoFechaValida("12-03-2004");
        assertEquals(expected, result);
    }
}
