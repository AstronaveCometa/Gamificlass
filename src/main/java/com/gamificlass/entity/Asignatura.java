package com.gamificlass.entity;

public class Asignatura {

	private int Asignatura_id;
	private String Asignatura_nombre;
	private String Asignatura_inicio;
	
	
	public Asignatura() {
	}

	public Asignatura(int asignatura_id, String asignatura_nombre, String asignatura_inicio) {
		Asignatura_id = asignatura_id;
		Asignatura_nombre = asignatura_nombre;
		Asignatura_inicio = asignatura_inicio;
	}

	public int getAsignatura_id() {
		return Asignatura_id;
	}

	public void setAsignatura_id(int asignatura_id) {
		Asignatura_id = asignatura_id;
	}

	public String getAsignatura_nombre() {
		return Asignatura_nombre;
	}

	public void setAsignatura_nombre(String asignatura_nombre) {
		Asignatura_nombre = asignatura_nombre;
	}

	public String getAsignatura_inicio() {
		return Asignatura_inicio;
	}

	public void setAsignatura_inicio(String asignatura_inicio) {
		Asignatura_inicio = asignatura_inicio;
	}
	

	
}
