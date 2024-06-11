package com.poo.avaliacao3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.avaliacao3.model.Time;
import com.poo.avaliacao3.repository.TimeRepository;

@Service
public class TimeService {
	@Autowired
	TimeRepository timeRp;
	
	public Time insert(Time time) {
		return timeRp.save(time);		
	}
	
	public Time update(Time time) {
		return timeRp.save(time);
	}

	public Time findById(Integer id) {
		return timeRp.findById(id).orElse(null);
	}
	
	public Time findByNome(String nome) {
		return timeRp.findByNome(nome);
	}

	public void delete(Time time) {
		timeRp.delete(time);
	}
	
	public List<Time> findAll() {
		return timeRp.findAll();
	}

}
