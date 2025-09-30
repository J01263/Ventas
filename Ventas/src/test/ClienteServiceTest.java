package com.empresa;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteServiceTest {

    @Test
    public void clienteSeEncuentraSinImportarMayusculas() {
        ClienteService servicio = new ClienteService();
        boolean resultado = servicio.buscarCliente("juan"); // en minúsculas
        assertTrue(resultado);
    }


}
