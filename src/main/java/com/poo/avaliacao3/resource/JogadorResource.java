package com.poo.avaliacao3.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> insertJogador(@RequestBody Jogador jogador) {
		try {
            Jogador novoJogador = jogadorService.insert(jogador);
            return ResponseEntity.ok(novoJogador);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao salvar");
        }
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
	public List<Jogador> findByNome(@PathVariable String nome) {
		return jogadorService.findByNome(nome);
	}
	
	@GetMapping("/nome/{nome}/anoNascimento/{anoNascimento}")
	public List<Jogador> findByNomeOrAnoNascimento(@PathVariable String nome, @PathVariable int anoNascimento) {
		return jogadorService.findByNomeOrAnoNascimento(nome, anoNascimento);
	}
	
	@DeleteMapping("/{id}")
	public void deleteJogador(@RequestBody Integer id) {
		jogadorService.delete(id);
	}
}
