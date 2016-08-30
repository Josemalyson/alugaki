package com.alugaki.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alugaki.model.Cliente;
import com.alugaki.repository.ClienteRepository;

@Service
public class ClienteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findaAll() {
		return clienteRepository.findAll();
	}

}
