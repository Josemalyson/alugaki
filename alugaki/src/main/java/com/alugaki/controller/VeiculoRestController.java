package com.alugaki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alugaki.model.Veiculo;
import com.alugaki.service.VeiculoService;

@RestController
public class VeiculoRestController {

	@Autowired
	private VeiculoService veiculoService;

	@RequestMapping("/veiculo")
	public ResponseEntity<List<Veiculo>> findAll() {
		return new ResponseEntity<>(veiculoService.findaAll(), HttpStatus.OK);
	}
}
