package com.nelioalves.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1,"Pagamento Pendente"),
	QUITADO(2,"Pagamento Quitado"),
	CANCELADO(3,"Pagamento Cancelado");
	
	private Integer id;
	private String  nome;

	public Integer getId() {
		return id;
	}

	private void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}
	
	private EstadoPagamento(Integer id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}

	public static EstadoPagamento toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (EstadoPagamento aux : EstadoPagamento.values()) {
			
			if (id.equals(aux.getId())) {
				return aux;
			}
		}
		
		throw new IllegalArgumentException("Id inválido : " + id.toString());
	
	}
	


}
