package com.poo.avaliacao3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Jogador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nome;
	@Column 
	private int anoNascimento;
	@ManyToOne
	private Time time;
	
	public Jogador() {
		super();
	}

	public Jogador(Integer id, String nome, int anoNascimento, Time time) {
		super();
		this.id = id;
		this.nome = nome;
		this.anoNascimento = anoNascimento;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", nome=" + nome + ", anoNascimento=" + anoNascimento + ", time=" + time + "]";
	}
}
