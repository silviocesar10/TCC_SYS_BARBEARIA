package com.sysbarbearia.api.algorithms.utils;
import com.sysbarbearia.api.model.*;
import com.sysbarbearia.api.services.UsoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class MatrizBasica {
	private Double[][] content;
	private Integer rowSize;
	private Integer colSize;

	@Autowired
	private UsoService avservice = new UsoService();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<ServicoOferecido> servicos = new ArrayList<ServicoOferecido>();

	//private Integer usuarioRow;

	public MatrizBasica(List<ServicoOferecido> servicos, List<Cliente> clientes) {
		this.rowSize = clientes.size();
		this.colSize = servicos.size();
		this.servicos = servicos;
		this.clientes = clientes;
		this.content = new Double[this.rowSize][this.colSize];
		preenheMatriz();
	}

	void preenheMatriz() {
		for (int i = 0; i < this.rowSize; i++) {
			Cliente u = this.clientes.get(i);
			for (int j = 0; j < this.colSize; j++) {
				//for(int j =0; j < 2; j++) {
				ServicoOferecido s = this.servicos.get(j);
				Optional<Uso> o = getUsoByServicoByCliente(u, s);
				if (!o.isPresent()) {
					this.content[i][j] = null;
				} else {
					this.content[i][j] = o.get().getNota();
				}

			}

		}
	}

	private Optional<Uso> getUsoByServicoByCliente(Cliente c, ServicoOferecido s) {
		List<Uso> allUso = new ArrayList<Uso>(avservice.findAll());
		if (allUso.stream().filter(a -> a.getServicoofrc().getIdServicoOfrc() == s.getIdServicoOfrc() && a.getCliente().getidCliente() == c.getidCliente()).findFirst() == null) {
			return null;
		} else {
			return allUso.stream().filter(a -> a.getServicoofrc().getIdServicoOfrc() == s.getIdServicoOfrc() && a.getCliente().getidCliente() == c.getidCliente()).findFirst();
		}
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public Double[][] getContent() {
		return content;
	}

	public Integer getRowSize() {
		return rowSize;
	}

	public Integer getColSize() {
		return colSize;
	}
}

