package com.nelioalves.cursomc.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date  instante;

	@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL,mappedBy="pedido")
	private Pagamento pagamento; 

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente; 

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="endereco_de_entrega_id")
	private Endereco enderecoDeEntrega; 
	
	
	public Pedido() {
		super();
	}


	public Pedido(Date instante,Pagamento pagamento,Cliente cliente,Endereco enderecoDeEntrega) {
		this();
		this.setInstante(instante);
		this.setPagamento(pagamento);
		this.setCliente(cliente);
		this.setEnderecoDeEntrega(enderecoDeEntrega);
		
	}

	public Pedido(Integer id, Date instante,Pagamento pagamento,Cliente cliente,Endereco enderecoDeEntrega) {
		this();
		this.setId(id);
		this.setInstante(instante);
		this.setPagamento(pagamento);
		this.setCliente(cliente);
		this.setEnderecoDeEntrega(enderecoDeEntrega);
	}
	
	public Pedido(Date instante,Cliente cliente,Endereco enderecoDeEntrega) {
		this();
		this.setInstante(instante);
		this.setCliente(cliente);
		this.setEnderecoDeEntrega(enderecoDeEntrega);
		
	}

	public Pedido(Integer id, Date instante,Cliente cliente,Endereco enderecoDeEntrega) {
		this();
		this.setId(id);
		this.setInstante(instante);
		this.setCliente(cliente);
		this.setEnderecoDeEntrega(enderecoDeEntrega);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}


	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	
	
}
