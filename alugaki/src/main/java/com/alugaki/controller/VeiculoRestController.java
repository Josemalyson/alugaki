package com.alugaki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alugaki.model.Veiculo;
import com.alugaki.service.VeiculoService;

@RestController
public class VeiculoRestController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping("/veiculo")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Veiculo>> findAll() {
		return new ResponseEntity<>(veiculoService.findaAll(), HttpStatus.OK);
	}
}
