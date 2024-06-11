package com.poo.avaliacao3.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.avaliacao3.model.Jogador;
import com.poo.avaliacao3.services.JogadorService;

@RestController
@RequestMapping("/jogador")
public class JogadorResource {
	
	@Autowired
	JogadorService jogadorService;
	
	@PostMapping
	public Jogador insertJogador(@RequestBody Jogador jogador) {
		return jogadorService.insert(jogador);
	}

	@PutMapping
	public Jogador updateJogador(@RequestBody Jogador jogador) {
		return jogadorService.update(jogador);
	}
	
	@GetMapping
	public List<Jogador> listAllJogador() { 
		return jogadorService.findAll();
	}
	
	@GetMapping("/{id}")
	public Jogador findByIdJogador(@PathVariable Integer id) {
		return jogadorService.findById(id);
	}
	
	@GetMapping("/nome/{nome}")
	public Jogador findByNome(@PathVariable String nome) {
		return jogadorService.findByNome(nome);
	}
	
	@DeleteMapping
	public void deleteJogador(@RequestBody Jogador jogador) {
		jogadorService.delete(jogador);
	}
}
