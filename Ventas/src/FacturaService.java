package com.empresa;

public class FacturaService {

    public double calcularTotal(double precioUnitario, int cantidad, double igv, double descuento) {
        double subtotal = precioUnitario * cantidad;
        double totalPagar = subtotal + igv + descuento;

        // Redondeo
        subtotal = Math.round(subtotal * 100) / 100.0;
        igv = Math.round(igv * 100) / 100.0;
        descuento = Math.round(descuento * 100) / 100.0;
        totalPagar = Math.round(totalPagar * 100) / 100.0;

        return totalPagar;
    }
}

