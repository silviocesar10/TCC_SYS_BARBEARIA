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
        montarTabela(m.getContent());
    }
    private void montarTabela(Double[][] matrizBasica) {
        content = new Double[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            calculoValorCelula(matrizBasica, i);
        }
    }

    private void calculoValorCelula(Double[][] matrizBasica, Integer row) {
        List<Coordenadas> coordenadas = new ArrayList<Coordenadas>();

        for(int j = 0; j < colSize; j++) {
            coordenadas.add(calculoCelula(matrizBasica, row, j, coordenadas));
        }
    }

    private Coordenadas calculoCelula(Double[][] matrizBasica, Integer linha, Integer coluna,  List<Coordenadas> coordenadas) {
        Integer distanceColIndex = colSize - 2;
        Integer similarityColIndex = colSize - 1;
        DistanciaEuclidiana DE = new DistanciaEuclidiana();
        if (coluna.equals(distanceColIndex)) {
            content[linha][coluna] = DE.calcularDistancia(coordenadas);
            return montarCooordenada(null, null);
        }

        if (coluna.equals(similarityColIndex)) {
            content[linha][coluna] = calcularSimiliridade(DE.calcularDistancia(coordenadas));
            return montarCooordenada(null, null);
        }
        content[linha][coluna] = matrizBasica[linha][coluna];
        return montarCooordenada(matrizBasica[linhaUsuario][coluna], content[linha][coluna]);
    }

    private Double calcularSimiliridade(Double distancia){
        return 1 / (1 + distancia);
    }

    public Double[][] getContent() {
        return content;
    }

    private  Coordenadas montarCooordenada(Double x, Double y){
        Coordenadas c = new Coordenadas(x,y);
        return c;
    }

    public void setContent(Double[][] content) {
        this.content = content;
    }

    public Integer getRowSize() {
        return rowSize;
    }

    public void setRowSize(Integer rowSize) {
        this.rowSize = rowSize;
    }

    public Integer getColSize() {
        return colSize;
    }

    public void setColSize(Integer colSize) {
        this.colSize = colSize;
    }

    public Integer getLinhaUsuario() {
        return linhaUsuario;
    }

    public void setLinhaUsuario(Integer linhaUsuario) {
        this.linhaUsuario = linhaUsuario;
    }
}
