package com.nelioalves.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import com.nelioalves.cursomc.domain.enums.EstadoPagamento;


@Entity
public class PagamentoComCartao extends Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;
			
	private Integer numeroDeParcelas;

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public PagamentoComCartao() {
		super();
	}


	public PagamentoComCartao(EstadoPagamento estado) {
		super(estado);
	}
	
	public PagamentoComCartao(Integer id, EstadoPagamento estado,Integer numeroDeParcelas) {
		super(id, estado);
		this.setNumeroDeParcelas(numeroDeParcelas);
	}
	
	public PagamentoComCartao(EstadoPagamento estado,Integer numeroDeParcelas) {
		super(estado);
		this.setNumeroDeParcelas(numeroDeParcelas);
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado,Integer numeroDeParcelas, Pedido pedido) {
		super(id, estado,pedido);
		this.setNumeroDeParcelas(numeroDeParcelas);
	}
	
	public PagamentoComCartao(EstadoPagamento estado,Integer numeroDeParcelas, Pedido pedido) {
		super(estado,pedido);
		this.setNumeroDeParcelas(numeroDeParcelas);
	}
	


	
	
}