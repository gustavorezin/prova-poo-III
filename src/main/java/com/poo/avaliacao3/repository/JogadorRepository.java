package com.poo.avaliacao3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.avaliacao3.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
	public Jogador findByNome(String nome);
}
