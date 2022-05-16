package edu.curso;

import java.time.LocalDate;

public class Visitante {
	private int id;
	private String nomeVisitante;
	private String nomeEscola;
	private LocalDate dataVisita;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeVisitante() {
		return nomeVisitante;
	}

	public void setNomeVisitante(String nomeVisitante) {
		this.nomeVisitante = nomeVisitante;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public LocalDate getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(LocalDate dataVisita) {
		this.dataVisita = dataVisita;
	}

}
