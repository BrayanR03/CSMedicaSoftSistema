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
public class HorarioAtencionTest {
    
    public HorarioAtencionTest() {
    }


    @Test
    public void testTieneHoraValida() {
        System.out.println("tieneHoraValida");
        HorarioAtencion horario = new HorarioAtencion();
        horario.setHorarioAtencionHoraInicio("10:00");
        horario.setHorarioAtencionHoraFin("10:59");
        boolean expResult = true;
        boolean result = horario.tieneHoraValida();
        assertEquals(expResult, result);
    }

    @Test
    public void testTieneHoraUnicaValida() {
        System.out.println("tieneHoraUnicaValida");
        List<String> horas = new ArrayList<>();
        horas.add("09:00");
        horas.add("09:59");
        horas.add("10:00");
        horas.add("10:59");
        horas.add("11:00");
        horas.add("11:59");
        horas.add("14:00");
        horas.add("14:59");

        HorarioAtencion horario = new HorarioAtencion();
        horario.setHorarioAtencionHoraInicio("15:00");
        horario.setHorarioAtencionHoraFin("15:59");
        boolean expResult = false;
        boolean result = horario.tieneHoraUnicaValida(horas);
        assertEquals(expResult, result);
    }
    
}
