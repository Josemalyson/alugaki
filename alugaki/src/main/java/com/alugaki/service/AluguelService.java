package com.alugaki.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alugaki.model.Aluguel;
import com.alugaki.repository.AluguelRepository;

@Service
public class AluguelService implements Serializable {

	
	private static final long serialVersionUID = 8765331828647518703L;
	
	@Autowired
	private AluguelRepository aluguelRepository;

	public List<Aluguel> findaAll() {
		return aluguelRepository.findAll();
	}

}
