package com.poo.avaliacao3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Time {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nome;
	@Column 
	private int anoFundacao;

	public Time() {
		super();
	}

	public Time(Integer id, String nome, int anoFundacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.anoFundacao = anoFundacao;
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

	public int getAnoFundacao() {
		return anoFundacao;
	}

	public void setAnoFundacao(int anoFundacao) {
		this.anoFundacao = anoFundacao;
	}

	@Override
	public String toString() {
		return "Time [id=" + id + ", nome=" + nome + ", anoFundacao=" + anoFundacao + "]";
	}
}
