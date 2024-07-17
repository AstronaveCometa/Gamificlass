package com.gamificlass.entity;

public class Nivel {

	private int Nivel_id;
	private Long Nivel_puntaje_inicio;
	private Long Nivel_puntaje_final;
	private int Nivel_nivel;
	
	public Nivel() {
	}

	public Nivel(int nivel_id, Long nivel_puntaje_inicio, Long nivel_puntaje_final, int nivel_nivel) {
		Nivel_id = nivel_id;
		Nivel_puntaje_inicio = nivel_puntaje_inicio;
		Nivel_puntaje_final = nivel_puntaje_final;
		Nivel_nivel = nivel_nivel;
	}

	public int getNivel_id() {
		return Nivel_id;
	}

	public void setNivel_id(int nivel_id) {
		Nivel_id = nivel_id;
	}

	public Long getNivel_puntaje_inicio() {
		return Nivel_puntaje_inicio;
	}

	public void setNivel_puntaje_inicio(Long nivel_puntaje_inicio) {
		Nivel_puntaje_inicio = nivel_puntaje_inicio;
	}

	public Long getNivel_puntaje_final() {
		return Nivel_puntaje_final;
	}

	public void setNivel_puntaje_final(Long nivel_puntaje_final) {
		Nivel_puntaje_final = nivel_puntaje_final;
	}

	public int getNivel_nivel() {
		return Nivel_nivel;
	}

	public void setNivel_nivel(int nivel_nivel) {
		Nivel_nivel = nivel_nivel;
	}
	
	
}
