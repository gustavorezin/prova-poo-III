package com.poo.avaliacao3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.avaliacao3.model.Jogador;
import com.poo.avaliacao3.repository.JogadorRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class JogadorService {
	@Autowired
	JogadorRepository jogadorRp;
	@PersistenceContext
	EntityManager entityManager;

	public Jogador insert(Jogador jogador) {
		return jogadorRp.save(jogador);
	}

	@Transactional
	public Jogador update(Integer id, Jogador jogador) {
		Jogador jogadorAtual = findById(id);
		jogadorAtual.setNome(jogador.getNome());
		jogadorAtual.setAnoNascimento(jogador.getAnoNascimento());
	    jogadorAtual.setTime(jogador.getTime());
	        
	    return jogadorRp.save(jogadorAtual);
	}

	public Jogador findById(Integer id) {
		return jogadorRp.findById(id).orElseThrow();
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
	
	@Transactional
	public void deleteAllAndResetIncrement() {
		jogadorRp.deleteAll();
		entityManager.createNativeQuery("ALTER TABLE jogador AUTO_INCREMENT = 1").executeUpdate();
	}

	public List<Jogador> findAll() {
		return jogadorRp.findAll();
	}
}
