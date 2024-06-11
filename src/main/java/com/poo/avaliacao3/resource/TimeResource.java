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

import com.poo.avaliacao3.model.Time;
import com.poo.avaliacao3.services.TimeService;

@RestController
@RequestMapping("/time")
public class TimeResource {
	@Autowired
	TimeService timeService;

	@PostMapping
	public ResponseEntity<?> insertTime(@RequestBody Time time) {
		try {
			Time novoTime = timeService.insert(time);
			return ResponseEntity.ok(novoTime);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar time");
		}
	}

	@PutMapping
	public ResponseEntity<?> updateTime(@RequestBody Time time) {
		try {
			Time timeAlterado = timeService.update(time);
			return ResponseEntity.ok(timeAlterado);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao alterar time");
		}
	}

	@GetMapping
	public ResponseEntity<?> listAllTime() {
		try {
			List<Time> listaTimes = timeService.findAll();
			return ResponseEntity.ok(listaTimes);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao listar times");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdTime(@PathVariable Integer id) {
		try {
			Time time = timeService.findById(id);
			return ResponseEntity.ok(time);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao encontrar time");
		}
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<?> findByNome(@PathVariable String nome) {
		try {
			List<Time> times = timeService.findByNome(nome);
			return ResponseEntity.ok(times);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao encontrar times");
		}
	}

	@GetMapping("/nome/{nome}/anoFundacao/{anoFundacao}")
	public ResponseEntity<?> findByNomeOrAnoFundacao(@PathVariable String nome, @PathVariable int anoFundacao) {
		try {
			List<Time> times = timeService.findByNomeOrAnoFundacao(nome, anoFundacao);
			return ResponseEntity.ok(times);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao encontrar times");
		}
	}

	@DeleteMapping
	public ResponseEntity<?> deleteTime(@RequestBody Time time) {
		try {
			timeService.delete(time);
			return ResponseEntity.ok("Deletado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar time");
		}
	}
}
