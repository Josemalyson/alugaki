package com.alugaki.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alugaki.enums.StatusPagamentoEnum;
import com.alugaki.model.Aluguel;
import com.alugaki.repository.AluguelRepository;

@Service
public class AluguelService implements Serializable {

	private static final long serialVersionUID = 8765331828647518703L;

	@Autowired
	private AluguelRepository aluguelRepository;
	@Autowired
	private StatusPagamentoService statusPagamentoService;

	public List<Aluguel> findaAll() {
		return aluguelRepository.findAll();
	}

	@Transactional
	public Aluguel salvar(Aluguel aluguel) {
		return aluguelRepository.save(aluguel);
	}

	public Aluguel alugar(Aluguel aluguel) {
		aluguel.setDataAluguel(Date.valueOf(LocalDate.now()));
		aluguel.setDataDevolucao(Date.valueOf(LocalDate.now().plusDays(5)));
		aluguel.setStatusPagamento(statusPagamentoService.findOne(StatusPagamentoEnum.NAO_PAGO));
		return salvar(aluguel);
	}

	public Aluguel devolver(Aluguel aluguel) {
		aluguel.setValorTotal(calcularValor(aluguel.getKmPecorrido()));
		verificarDataDeDevolucao(aluguel);
		aluguel.setStatusPagamento(statusPagamentoService.findOne(StatusPagamentoEnum.PAGO));
		return salvar(aluguel);

	}

	private void verificarDataDeDevolucao(Aluguel aluguel) {

		Aluguel aluguelBD = aluguelRepository.findOne(aluguel.getId());

		if (aluguelBD.getDataDevolucao().after(aluguel.getDataDevolucao())) {
			aluguel.getValorTotal().add(calcularMulta(aluguelBD, aluguel));
		}

	}

	private BigDecimal calcularMulta(Aluguel aluguelBD, Aluguel aluguel) {

		LocalDate dataDevolucao = new java.sql.Date(aluguel.getDataDevolucao().getTime()).toLocalDate();
		LocalDate dataDevolucaoBD = new java.sql.Date(aluguelBD.getDataDevolucao().getTime()).toLocalDate();

		Period period = Period.between(dataDevolucaoBD, dataDevolucao);

		if (period.getDays() > 0) {
			return BigDecimal.valueOf(period.getDays() * 100L);
		}

		return BigDecimal.ZERO;
	}

	private BigDecimal calcularValor(Float kmPecorrido) {
		return BigDecimal.valueOf(kmPecorrido != 0 ? kmPecorrido * 100 : kmPecorrido);
	}

}
