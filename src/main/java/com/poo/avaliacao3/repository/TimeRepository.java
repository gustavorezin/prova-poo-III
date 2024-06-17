package com.poo.avaliacao3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.avaliacao3.model.Time;

public interface TimeRepository extends JpaRepository<Time, Integer> {
	List<Time> findByNomeContaining(String nome);

	List<Time> findByNomeOrAnoFundacao(String nome, int anoFundacao);
}
