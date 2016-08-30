package com.alugaki.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alugaki.model.Veiculo;
import com.alugaki.repository.VeiculoRepository;

@Service
public class VeiculoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private VeiculoRepository veiculoRepository;

	public List<Veiculo> findaAll() {
		return veiculoRepository.findAll();
	}

}
