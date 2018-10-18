package com.nelioalves.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1,"Pessoa Física"),
	PESSOAJURIDICA(2,"Pessoa Juridica");
	
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
	
	private TipoCliente(Integer id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}

	public static TipoCliente toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (TipoCliente tipoCliente : TipoCliente.values()) {
			
			if (id.equals(tipoCliente.getId())) {
				return tipoCliente;
			}
		}
		
		throw new IllegalArgumentException("Id inválido : " + id.toString());
	
	}
	


}
