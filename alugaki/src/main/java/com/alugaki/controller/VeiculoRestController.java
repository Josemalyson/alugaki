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

import com.alugaki.model.Veiculo;
import com.alugaki.service.VeiculoService;

@RestController
@CrossOrigin
@RequestMapping("/veiculos")
public class VeiculoRestController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping
	public List<Veiculo> findAll() {
		return veiculoService.findaAll();
	}

	@GetMapping("{id}")
	public Veiculo buscarClientePorId(@PathVariable("id") Long id) {
		return veiculoService.buscarVeiculoPorId(id);
	}
	
	@GetMapping("/marca/{marca}")
	public List<Veiculo> buscarVeiculoPorMarca(@PathVariable("marca") String marca) {

		if (marca != null) {
			return veiculoService.findaAll()
									.stream()
										.filter(v -> v.getMarca().trim().toLowerCase().contains(marca.trim().toLowerCase()))
											.collect(Collectors.toList());
		}

		return new ArrayList<>();
	}

	@PostMapping
	public Veiculo salvarCliente(@RequestBody Veiculo veiculo) {

		if (isVeiculoValido(veiculo)) {
			return veiculoService.salvar(veiculo);
		}

		return new Veiculo();
	}

	private boolean isVeiculoValido(Veiculo veiculo) {
		return veiculo != null;
	}

	@PutMapping
	public Veiculo editarCliente(@RequestBody Veiculo veiculo) {

		if (isVeiculoValido(veiculo) && veiculo.getId() != null) {
			return veiculoService.salvar(veiculo);

		}

		return new Veiculo();
	}

	@DeleteMapping
	public Veiculo excluirCliente(@RequestBody Veiculo veiculo) {

		if (isVeiculoValido(veiculo)) {
			veiculoService.excluir(veiculo);
			return veiculo;
		}

		return new Veiculo();
	}

	@DeleteMapping("{id}")
	public Veiculo excluirCliente(@PathVariable("id") Long id) {

		if (id != null) {
			
			Veiculo veiculo = veiculoService.buscarVeiculoPorId(id);

			if (isVeiculoValido(veiculo)) {
				veiculoService.excluir(veiculo);
				return veiculo;
			}
			
		}
		
		return new Veiculo();

	}
}
