package com.poo.avaliacao3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.avaliacao3.model.Jogador;
import com.poo.avaliacao3.repository.JogadorRepository;

@Service
public class JogadorService {
	@Autowired
	JogadorRepository jogadorRp;

	public Jogador insert(Jogador jogador) {
		return jogadorRp.save(jogador);
	}

	public Jogador update(Jogador jogador) {
		return jogadorRp.save(jogador);
	}

	public Jogador findById(Integer id) {
		return jogadorRp.findById(id).orElse(null);
	}

	public List<Jogador> findByNome(String nome) {
		return jogadorRp.findByNomeContaining(nome);
	}

	public List<Jogador> findByNomeOrAnoNascimento(String nome, int anoNascimento) {
		return jogadorRp.findByNomeOrAnoNascimento(nome, anoNascimento);
	}

	public void delete(Integer id) {
		jogadorRp.deleteById(id);
	}

	public List<Jogador> findAll() {
		return jogadorRp.findAll();
	}
}
