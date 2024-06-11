package com.poo.avaliacao3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.avaliacao3.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
	public List<Jogador> findByNomeContaining(String nome);
	
	public List<Jogador> findByNomeOrAnoNascimento(String nome, int anoNascimento);
}
