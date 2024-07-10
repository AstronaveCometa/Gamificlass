package com.gamificlass.entity;

public class Asignatura {

	private int Asignatura_id;
	private String Asignatura_nombre;
	
	public Asignatura() {
	}

	public Asignatura(int asignatura_id, String asignatura_nombre) {
		Asignatura_id = asignatura_id;
		Asignatura_nombre = asignatura_nombre;
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
	

	
}
