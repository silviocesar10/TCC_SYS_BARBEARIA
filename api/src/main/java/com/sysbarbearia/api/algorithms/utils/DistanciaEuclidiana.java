package com.sysbarbearia.api.algorithms.utils;
import java.util.List;
public class DistanciaEuclidiana {
    public Double calcularDistancia(List<Coordenadas> coordenadas) {
        Double somaDaDiferencaDosPares = 0.0;

        for (Coordenadas coordenada : coordenadas) {
            somaDaDiferencaDosPares += calculoDosPares(coordenada.getX(), coordenada.getY());
        }

        return Math.sqrt(somaDaDiferencaDosPares);
    }

    private Double calculoDosPares(Double x, Double y) {
        if (x == null || y == null) {
            return new Double(0.0);
        }
        return Math.pow((x - y), 2);
    }
}
