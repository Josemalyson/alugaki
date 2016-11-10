package com.alugaki.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alugaki.enums.StatusPagamentoEnum;
import com.alugaki.model.StatusPagamento;
import com.alugaki.repository.StatusPagamentoRepository;

@Service
public class StatusPagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private StatusPagamentoRepository statusPagamentoRepository;

	public StatusPagamento findOne(StatusPagamentoEnum statusPagamentoEnum){
		return statusPagamentoRepository.findOne(statusPagamentoEnum.getId());
	}

}
