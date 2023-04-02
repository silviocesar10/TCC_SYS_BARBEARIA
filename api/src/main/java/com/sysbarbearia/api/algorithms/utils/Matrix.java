package com.sysbarbearia.api.algorithms.utils;

public class Matrix {
	private Double[][] content;
    private Integer rowSize;
    private Integer colSize;
    //private Integer usuarioRow;
	public Double[][] getContent() {
		return content;
	}
	public Double getContentByIndex(Integer row, Integer col) {
		return this.content[row][col];
	}

	public void setContent(Double[][] content) {
		this.content = content;
	}
	public void setContentByIndex(Integer row, Integer col, Double content) {
		this.content[row][col] = content;
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
	public Matrix(Integer rowSize, Integer colSize) {
		this.rowSize = rowSize;
		this.colSize = colSize;
		this.content = new Double[this.rowSize][this.colSize];
	}
    
   
}
