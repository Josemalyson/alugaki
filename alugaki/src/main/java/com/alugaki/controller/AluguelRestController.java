package com.alugaki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alugaki.model.Aluguel;
import com.alugaki.service.AluguelService;

@RestController
@CrossOrigin
@RequestMapping("/alugueis")
public class AluguelRestController {

	@Autowired
	private AluguelService aluguelService;
	
	@GetMapping
	public List<Aluguel> findAll(){
		return aluguelService.findaAll();
	}
}
