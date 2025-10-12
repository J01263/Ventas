package com.empresa;

import java.util.Arrays;
import java.util.List;

public class ClienteService {

    private List<String> clientes = Arrays.asList("Juan", "Ana", "Luis");

    public boolean validarNombre(String nombre) {
        return !nombre.trim().isEmpty();
    }

    public boolean buscarCliente(String nombre) {
        return clientes.stream()
                .anyMatch(c -> c.equalsIgnoreCase(nombre));
    }


}
