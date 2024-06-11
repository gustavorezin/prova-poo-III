package com.poo.avaliacao3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.avaliacao3.model.Time;

public interface TimeRepository extends JpaRepository<Time, Integer> {
	public Time findByNome(String nome);
}
