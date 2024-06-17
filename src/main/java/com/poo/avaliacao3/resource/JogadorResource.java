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
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar jogador");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateJogador(@PathVariable Integer id, @RequestBody Jogador jogador) {
		try {
			Jogador jogadorAlterado = jogadorService.update(id, jogador);
			return ResponseEntity.ok(jogadorAlterado);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao alterar jogador");
		}
	}

	@GetMapping
	public ResponseEntity<?> listAllJogador() {
		try {
			List<Jogador> jogadores = jogadorService.findAll();
			return ResponseEntity.ok(jogadores);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao listar jogadores");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdJogador(@PathVariable Integer id) {
		try {
			Jogador jogador = jogadorService.findById(id);
			return ResponseEntity.ok(jogador);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogador não encontrado");
		}
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<?> findByNome(@PathVariable String nome) {
		try {
			List<Jogador> jogadores = jogadorService.findByNome(nome);
			return ResponseEntity.ok(jogadores);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao encontrar jogadores");
		}
	}

	@GetMapping("/nome/{nome}/anoNascimento/{anoNascimento}")
	public ResponseEntity<?> findByNomeOrAnoNascimento(@PathVariable String nome, @PathVariable int anoNascimento) {
		try {
			List<Jogador> jogadores = jogadorService.findByNomeOrAnoNascimento(nome, anoNascimento);
			return ResponseEntity.ok(jogadores);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao encontrar jogadores");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteJogador(@PathVariable Integer id) {
		try {
			jogadorService.delete(id);
			return ResponseEntity.ok("Deletado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar jogador");
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteAllJogadorAndResetIncrement() {
		try {
			jogadorService.deleteAllAndResetIncrement();
			return ResponseEntity.ok("Todos os jogadores deletados com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar todos os jogadores");
		}
	}
}
