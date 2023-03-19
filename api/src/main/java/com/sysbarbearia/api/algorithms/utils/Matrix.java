package com.sysbarbearia.api.algorithms.utils;

public class Matrix {
	private Double[][] content;
    private Integer rowSize;
    private Integer colSize;
    //private Integer usuarioRow;
	public Double[][] getContent() {
		return content;
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
	public Matrix(Integer rowSize, Integer colSize) {
		super();
		this.rowSize = rowSize;
		this.colSize = colSize;
	}
    
   
}
