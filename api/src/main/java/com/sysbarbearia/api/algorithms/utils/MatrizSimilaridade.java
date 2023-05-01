package com.sysbarbearia.api.algorithms.utils;

import java.util.List;
import java.util.ArrayList;

import com.sysbarbearia.api.model.Cliente;

public class MatrizSimilaridade {


    private Double[][] content;
    private Integer rowSize;
    private Integer colSize;

    private Integer linhaUsuario;

    public MatrizSimilaridade(MatrizBasica m, Cliente c) {
        this.colSize = m.getColSize() + 2;
        this.rowSize = m.getRowSize();
        this.linhaUsuario = m.getClientes().indexOf(c);
        this.content = new Double[this.rowSize][this.colSize];
        montarTabela(m.getContent());
    }
    private void montarTabela(Double[][] matrizBasica) {
        content = new Double[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            calculateCellsValues(matrizBasica, i);
        }
    }

    private void calculateCellsValues(Double[][] matrizBasica, Integer row) {
        List<Coordenadas> coordenadas = new ArrayList<Coordenadas>();

        for(int j = 0; j < colSize; j++) {
            coordenadas.add(calculateCelula(matrizBasica, row, j, coordenadas));
        }
    }

    private Coordenadas calculateCelula(Double[][] matrizBasica, Integer linha, Integer coluna,  List<Coordenadas> coordenadas) {
        Integer distanceColIndex = colSize - 2;
        Integer similarityColIndex = colSize - 1;
        DistanciaEuclidiana DE = new DistanciaEuclidiana();
        if (coluna.equals(distanceColIndex)) {
            content[linha][coluna] = DE.calcularDistancia(coordenadas);
            return new Coordenadas(new Double(null) , new Double(null) );
        }

        if (coluna.equals(similarityColIndex)) {
            content[linha][coluna] = calcularSimiliridade(DE.calcularDistancia(coordenadas));
            return new Coordenadas(new Double(null) , new Double(null) );
        }

        content[linha][coluna] = matrizBasica[linha][coluna];
        return new Coordenadas(matrizBasica[linhaUsuario][coluna], content[linha][coluna]);
    }

    private Double calcularSimiliridade(Double distancia){
        return 1 / (1 + distancia);
    }

    public Double[][] getContent() {
        return content;
    }
}
