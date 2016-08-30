package com.alugaki.enums;

public enum CorEnum {

	PRETO(1L, "Preto"), BRANCO(2L, "Branco"), VERMELHO(3L, "Vermelho");

	private Long id;
	private String descricao;

	private CorEnum(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}
