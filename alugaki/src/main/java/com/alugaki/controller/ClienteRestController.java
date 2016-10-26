package com.alugaki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@ResponseBody
	public ResponseEntity<List<Cliente>> findAll() {
		return new ResponseEntity<>(clienteService.findaAll(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	@ResponseBody
	public ResponseEntity<Cliente> buscarClientePorId(@PathVariable("id") Long id) {
		// TODO VALIDACOES DE CAMPO ID NAO PODE SER NULO
		// VALIDACOES SE CLIENTE NAO EXISTE
		Cliente cliente = clienteService.buscarClientePorId(id);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
		// TODO VERIFICAR PQ O NUMERO 0 (ZERO) E DESCONSIDERADO NO INICIO DO CPF
		// VALIDACOES DE CAMPOS OBRIGATORIOS
		// VALIDACOES DE CLIENTE JA EXISTENTE PELO CPF
		// VALIDAR CPF VALIDO
		clienteService.salvar(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Cliente> editarCliente(@RequestBody Cliente cliente) {
		// TODO VALIDACOES DE CAMPO ID NAO PODE SER NULO
		// VALIDACOES SE CLIENTE EXISTE PARA PODER SER EDITADO
		clienteService.salvar(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<Cliente> excluirCliente(@RequestBody Cliente cliente) {
		// TODO VALIDACOES DE CAMPO ID NAO PODE SER NULO
		// VALIDACOES SE CLIENTE EXISTE PARA PODER SER EXCLUIDO
		clienteService.excluir(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable("id") Long id) {
		// TODO VALIDACOES DE CAMPO ID NAO PODE SER NULO
		// VALIDACOES SE CLIENTE EXISTE PARA PODER SER EXCLUIDO
		Cliente cliente = clienteService.buscarClientePorId(id);
		clienteService.excluir(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

}
