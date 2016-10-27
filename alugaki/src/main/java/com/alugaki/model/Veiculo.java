package com.alugaki.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.alugaki.enums.CorEnum;

@Entity
@Table(name = "TB_VEICULO")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_VEICULO")
	private Long id;

	@NotNull(message = "Campo MARCA obrigatório")
	@Column(name = "DS_MARCA")
	private String marca;

	@NotNull(message = "Campo NOME obrigatório")
	@Column(name = "DS_NOME")
	private String nome;

	@NotNull(message = "Campo COR obrigatório")
	@Column(name = "DS_COR")
	private String cor;

	@Column(name = "NU_PASSAGEIROS")
	private Integer qtdPassageiros;

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getNome() {
		return nome;
	}

	public String getCor() {
		return cor;
	}

	public Integer getQtdPassageiros() {
		return qtdPassageiros;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setQtdPassageiros(Integer qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", marca=" + marca + ", nome=" + nome + ", cor=" + cor + ", qtdPassageiros="
				+ qtdPassageiros + "]";
	}

}
