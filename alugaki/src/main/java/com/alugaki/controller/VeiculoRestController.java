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

import com.alugaki.model.Veiculo;
import com.alugaki.service.VeiculoService;

@RestController
@CrossOrigin
@RequestMapping("/veiculos")
public class VeiculoRestController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Veiculo>> findAll() {
		return new ResponseEntity<>(veiculoService.findaAll(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	@ResponseBody
	public ResponseEntity<Veiculo> buscarClientePorId(@PathVariable("id") Long id) {
		Veiculo veiculo = veiculoService.buscarVeiculoPorId(id);
		return new ResponseEntity<>(veiculo, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Veiculo> salvarCliente(@RequestBody Veiculo veiculo ) {
		veiculoService.salvar(veiculo);
		return new ResponseEntity<>(veiculo, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Veiculo> editarCliente(@RequestBody Veiculo veiculo ) {
		veiculoService.salvar(veiculo);
		return new ResponseEntity<>(veiculo, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<Veiculo> excluirCliente(@RequestBody Veiculo veiculo ) {
		veiculoService.excluir(veiculo);
		return new ResponseEntity<>(veiculo, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Veiculo> excluirCliente(@PathVariable("id") Long id) {
		Veiculo veiculo  = veiculoService.buscarVeiculoPorId(id);
		veiculoService.excluir(veiculo);
		return new ResponseEntity<>(veiculo, HttpStatus.OK);
	}
}
