/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicasoft_capa3.dominio;

import dominio.Cita;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class CitaTest {
    
    public CitaTest() {
    }

    @Test
    public void test1PermiteNuevaCita() {
        System.out.println("permiteNuevaCita");
        int totalDeCitasRegistradas = 7;
        Cita cita = new Cita();
        boolean expResult = false;
        boolean result = cita.permiteNuevaCita(totalDeCitasRegistradas);
        assertEquals(expResult, result);
    }

    @Test
    public void test2PermiteNuevaCita() {
        System.out.println("permiteNuevaCita");
        int totalDeCitasRegistradas = 6;
        Cita cita = new Cita();
        boolean expResult = true;
        boolean result = cita.permiteNuevaCita(totalDeCitasRegistradas);
        assertEquals(expResult, result);
    }
    @Test
    public void test1PermiteNuevaCitaPaciente() {
        System.out.println("permiteNuevaCitaPaciente");
        int totalDeCitasPaciente = 1;
        Cita instance = new Cita();
        boolean expResult = false;
        boolean result = instance.permiteNuevaCitaPaciente(totalDeCitasPaciente);
        assertEquals(expResult, result);
    }
    
    @Test
    public void test2PermiteNuevaCitaPaciente() {
        System.out.println("permiteNuevaCitaPaciente");
        int totalDeCitasPaciente = 0;
        Cita instance = new Cita();
        boolean expResult = true;
        boolean result = instance.permiteNuevaCitaPaciente(totalDeCitasPaciente);
        assertEquals(expResult, result);
    }
}
