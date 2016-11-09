package com.alugaki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
//	@PostMapping(params={"idCliente", "idVeiculo"})
//	public Aluguel alugarVeiculo(@RequestParam("idCliente") Long cliente, @RequestParam("idVeiculo") Long veiculo){
//		System.out.println("Cliente id:" + cliente + " Veiculo id: " + veiculo);
//		return new Aluguel();
//	}
	
	@PostMapping
	public Aluguel alugarVeiculo(@RequestBody Aluguel aluguel){
		System.out.println(aluguel.toString());
		return new Aluguel();
	}
}
