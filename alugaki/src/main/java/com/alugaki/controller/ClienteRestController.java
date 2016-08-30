package com.alugaki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alugaki.model.Cliente;
import com.alugaki.service.ClienteService;

@RestController
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/cliente")
	public ResponseEntity<List<Cliente>> findAll(){
		return new ResponseEntity<>(clienteService.findaAll(), HttpStatus.OK);
	}
}
