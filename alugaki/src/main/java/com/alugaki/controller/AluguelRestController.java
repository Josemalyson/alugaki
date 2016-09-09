package com.alugaki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alugaki.model.Aluguel;
import com.alugaki.service.AluguelService;

@RestController
public class AluguelRestController {

	@Autowired
	private AluguelService aluguelService;
	
	@GetMapping("/aluguel")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Aluguel>> findAll(){
		return new ResponseEntity<>(aluguelService.findaAll(), HttpStatus.OK);
	}
}
