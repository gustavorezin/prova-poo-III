package com.poo.avaliacao3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.avaliacao3.model.Time;
import com.poo.avaliacao3.repository.TimeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class TimeService {
	@Autowired
	TimeRepository timeRp;
	@PersistenceContext
	EntityManager entityManager;

	public Time insert(Time time) {
		return timeRp.save(time);
	}

	@Transactional
	public Time update(Integer id, Time time) {
		Time timeAtual = findById(id);
		timeAtual.setNome(time.getNome());
		timeAtual.setAnoFundacao(time.getAnoFundacao());
		return timeRp.save(timeAtual);
	}

	public Time findById(Integer id) {
		return timeRp.findById(id).orElseThrow();
	}

	public List<Time> findByNome(String nome) {
		return timeRp.findByNomeContaining(nome);
	}

	public List<Time> findByNomeOrAnoFundacao(String nome, int anoFundacao) {
		return timeRp.findByNomeOrAnoFundacao(nome, anoFundacao);
	}

	public void delete(Integer id) {
		timeRp.deleteById(id);
	}

	@Transactional
	public void deleteAllAndResetIncrement() {
		timeRp.deleteAll();
		entityManager.createNativeQuery("ALTER TABLE time AUTO_INCREMENT = 1").executeUpdate();
	}

	public List<Time> findAll() {
		return timeRp.findAll();
	}
}
