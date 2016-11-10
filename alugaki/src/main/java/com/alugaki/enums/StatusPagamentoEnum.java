package com.alugaki.enums;

public enum StatusPagamentoEnum {

	PAGO(1L, "Pago", "P"), NAO_PAGO(2L, "Não Pago", "NP");

	private Long id;
	private String descricao;
	private String sigla;

	private StatusPagamentoEnum(Long id, String descricao, String sigla) {
		this.id = id;
		this.descricao = descricao;
		this.sigla = sigla;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getSigla() {
		return sigla;
	}

}
