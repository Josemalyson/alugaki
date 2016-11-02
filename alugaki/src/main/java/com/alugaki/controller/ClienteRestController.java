package com.alugaki.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alugaki.model.Cliente;
import com.alugaki.service.ClienteService;

@RestController
@CrossOrigin
@RequestMapping("/clientes")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> findAll() {
		return clienteService.findaAll();
	}

	@GetMapping("{id}")
	public Cliente buscarClientePorId(@PathVariable("id") Long id) {
		// TODO VALIDACOES DE CAMPO ID NAO PODE SER NULO
		// VALIDACOES SE CLIENTE NAO EXISTE
		
		if (id != null) {
			return clienteService.buscarClientePorId(id);
		}
		
		return new Cliente();
	}

	@GetMapping("/nome/{nome}")
	public List<Cliente> buscarClientePorNome(@PathVariable("nome") String nome) {

		if (nome != null) {
			return clienteService.findaAll()
									.stream()
										.filter(c -> c.getNome().trim().toLowerCase().contains(nome.trim().toLowerCase()))
											.collect(Collectors.toList());
		}

		return new ArrayList<>();
	}

	@PostMapping
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		// TODO VERIFICAR PQ O NUMERO 0 (ZERO) E DESCONSIDERADO NO INICIO DO CPF
		// VALIDACOES DE CAMPOS OBRIGATORIOS
		// VALIDACOES DE CLIENTE JA EXISTENTE PELO CPF
		// VALIDAR CPF VALIDO

		if (isClienteValido(cliente)) {
			return clienteService.salvar(cliente);
		}

		return new Cliente();
	}

	private boolean isClienteValido(Cliente cliente) {
		return cliente != null;
	}

	@PutMapping
	public Cliente editarCliente(@RequestBody Cliente cliente) {
		// TODO VALIDACOES DE CAMPO ID NAO PODE SER NULO
		// VALIDACOES SE CLIENTE EXISTE PARA PODER SER EDITADO

		if (isClienteValido(cliente) && cliente.getId() != null) {
			return clienteService.salvar(cliente);
		}

		return new Cliente();
	}

	@DeleteMapping
	public Cliente excluirCliente(@RequestBody Cliente cliente) {
		// TODO VALIDACOES DE CAMPO ID NAO PODE SER NULO
		// VALIDACOES SE CLIENTE EXISTE PARA PODER SER EXCLUIDO

		if (isClienteValido(cliente)) {
			clienteService.excluir(cliente);
			return cliente;
		}

		return new Cliente();
	}

	@DeleteMapping("{id}")
	public Cliente excluirCliente(@PathVariable("id") Long id) {
		// TODO VALIDACOES DE CAMPO ID NAO PODE SER NULO
		// VALIDACOES SE CLIENTE EXISTE PARA PODER SER EXCLUIDO
		
		if (id != null) {
			
			Cliente cliente = clienteService.buscarClientePorId(id);
			
			if (isClienteValido(cliente)) {
				clienteService.excluir(cliente);
				return cliente;
			}
			
		}
		
		return new Cliente();
	}

}
