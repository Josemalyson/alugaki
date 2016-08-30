package com.alugaki.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ALUGUEL")
public class Aluguel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ALUGUEL")
	private Long id;

	private Date dataAluguel;
	private Date dataDevolucao;
	private BigDecimal valorTotal;
	private Float kmPecorrido;

	@ManyToOne
	@JoinColumn(name = "FK_CLIENTE", nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "FK_VEICULO", nullable = false)
	private Veiculo veiculo;

	@ManyToOne
	@JoinColumn(name = "FK_STATUS_PAGAMENTO", nullable = false)
	private StatusPagamento statusPagamento;

	public Long getId() {
		return id;
	}

	public Date getDataAluguel() {
		return dataAluguel;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public Float getKmPecorrido() {
		return kmPecorrido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDataAluguel(Date dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setKmPecorrido(Float kmPecorrido) {
		this.kmPecorrido = kmPecorrido;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
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
		Aluguel other = (Aluguel) obj;
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
		return "Aluguel [id=" + id + ", dataAluguel=" + dataAluguel + ", dataDevolucao=" + dataDevolucao
				+ ", valorTotal=" + valorTotal + ", kmPecorrido=" + kmPecorrido + ", cliente=" + cliente + ", veiculo="
				+ veiculo + ", statusPagamento=" + statusPagamento + "]";
	}

}
