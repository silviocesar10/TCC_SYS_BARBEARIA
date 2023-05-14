package com.sysbarbearia.api.algorithms.utils;

public class PosicaoCelula {
    private Integer linha;
    private Integer coluna;

    public Integer getLinha() {
        return linha;
    }

    public void setLinha(Integer linha) {
        this.linha = linha;
    }

    public Integer getColuna() {
        return coluna;
    }

    public void setColuna(Integer coluna) {
        this.coluna = coluna;
    }

    public PosicaoCelula(Integer linha, Integer coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }
}
