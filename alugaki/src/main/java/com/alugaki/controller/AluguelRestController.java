package com.alugaki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alugaki.model.Aluguel;
import com.alugaki.service.AluguelService;

@RestController
public class AluguelRestController {

	@Autowired
	private AluguelService aluguelService;
	
	@RequestMapping("/aluguel")
	public ResponseEntity<List<Aluguel>> findAll(){
		return new ResponseEntity<>(aluguelService.findaAll(), HttpStatus.OK);
	}
}
