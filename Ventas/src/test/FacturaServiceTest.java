package com.empresa;

import org.junit.Test;
import static org.junit.Assert.*;

public class FacturaServiceTest {

    @Test
    public void totalCorrectoConValoresSimples() {
        FacturaService servicio = new FacturaService();
        double resultado = servicio.calcularTotal(10.0, 2, 3.0, -1.0);
        assertEquals(22.0, resultado, 0.01);
    }

    @Test
    public void totalConRedondeoDecimal() {
        FacturaService servicio = new FacturaService();
        double resultado = servicio.calcularTotal(9.99, 3, 2.345, 1.111);
        assertEquals(33.42, resultado, 0.01); // ajusta según cálculo real
    }
}

