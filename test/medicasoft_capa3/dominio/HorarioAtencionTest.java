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
    public void test1_TieneHoraValida() {
        System.out.println("test1_tieneHoraValida");
        HorarioAtencion horario = new HorarioAtencion();
        horario.setHorarioAtencionHoraInicio("10:00");
        horario.setHorarioAtencionHoraFin("10:59");
        boolean expResult = true;
        boolean result = horario.tieneHoraValida();
        assertEquals(expResult, result);
    }
    
        @Test
    public void test2_TieneHoraValida() {
        System.out.println("test2_tieneHoraValida");
        HorarioAtencion horario = new HorarioAtencion();
        horario.setHorarioAtencionHoraInicio("18:00");
        horario.setHorarioAtencionHoraFin("18:59");
        boolean expResult = false;
        boolean result = horario.tieneHoraValida();
        assertEquals(expResult, result);
    }

    @Test
    public void test1_TieneHoraUnicaValida() {
        System.out.println("test1_tieneHoraUnicaValida");
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
        boolean expResult = true;
        boolean result = horario.tieneHoraUnicaValida(horas);
        assertEquals(expResult, result);
    }
    
        @Test
    public void test2_TieneHoraUnicaValida() {
        System.out.println("test2_tieneHoraUnicaValida");
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
        horario.setHorarioAtencionHoraInicio("11:00");
        horario.setHorarioAtencionHoraFin("11:59");
        boolean expResult = false;
        boolean result = horario.tieneHoraUnicaValida(horas);
        assertEquals(expResult, result);
    }
    
    @Test 
    public void test1_tieneDiaValido(){
        System.out.println("test1_tieneDiaValido");
        HorarioAtencion horario = new HorarioAtencion();                
        horario.setHorarioAtencionFechaRegistro(Date.valueOf("2023-11-02"));
        boolean expResult = true;
        boolean result = horario.tieneDiaValido();
        assertEquals(expResult, result);
    }
    
        @Test 
    public void test2_tieneDiaValido(){
        System.out.println("test2_tieneDiaValido");
        HorarioAtencion horario = new HorarioAtencion();                
        horario.setHorarioAtencionFechaRegistro(Date.valueOf("2023-11-04"));
        boolean expResult = false;
        boolean result = horario.tieneDiaValido();
        assertEquals(expResult, result);
    }    
}
