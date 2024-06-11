package com.poo.avaliacao3.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Time insertTime(@RequestBody Time time) {
		return timeService.insert(time);
	}

	@PutMapping
	public Time updateTime(@RequestBody Time time) {
		return timeService.update(time);
	}
	
	@GetMapping
	public List<Time> listAllTime() { 
		return timeService.findAll();
	}
	
	@GetMapping("/{id}")
	public Time findByIdTime(@PathVariable Integer id) {
		return timeService.findById(id);
	}
	
	@GetMapping("/nome/{nome}")
	public Time findByNome(@PathVariable String nome) {
		return timeService.findByNome(nome);
	}
	
	@DeleteMapping
	public void deleteTime(@RequestBody Time time) {
		timeService.delete(time);
	}
}
