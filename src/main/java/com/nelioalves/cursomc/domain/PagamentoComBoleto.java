package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nelioalves.cursomc.domain.enums.EstadoPagamento;


@Entity
public class PagamentoComBoleto extends Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;
	
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	
	public PagamentoComBoleto() {
		super();
	}

	public PagamentoComBoleto(EstadoPagamento estado) {
		super(estado);
	}
	
	public PagamentoComBoleto(Integer id, EstadoPagamento estado,Date dataVencimento, Date dataPagamento) {
		super(id, estado);
		this.setDataPagamento(dataPagamento);
		this.setDataVencimento(dataVencimento); 
	}
	
	public PagamentoComBoleto(EstadoPagamento estado,Date dataVencimento, Date dataPagamento) {
		super(estado);
		this.setDataPagamento(dataPagamento);
		this.setDataVencimento(dataVencimento); 	
	}


	public PagamentoComBoleto(Integer id, EstadoPagamento estado,Date dataVencimento, Date dataPagamento, Pedido pedido) {
		super(id, estado,pedido);
		this.setDataPagamento(dataPagamento);
		this.setDataVencimento(dataVencimento); 
	}
	
	public PagamentoComBoleto(EstadoPagamento estado,Date dataVencimento, Date dataPagamento, Pedido pedido) {
		super(estado,pedido);
		this.setDataPagamento(dataPagamento);
		this.setDataVencimento(dataVencimento); 	
	}
	
	
}

