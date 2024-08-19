package com.gamificlass.entity;

public class Asistencia {
	
	private int Asistencia_id;
    private int Asistencia_estudiante_id;
    private String Asistencia_fecha;
    private int Asistencia_semana;
    private String Asistencia_estado;
    
	public Asistencia() {
	}

	public Asistencia(int asistencia_id, int asistencia_estudiante_id, String asistencia_fecha,
			int asistencia_semana, String asistencia_estado) {
		Asistencia_id = asistencia_id;
		Asistencia_estudiante_id = asistencia_estudiante_id;
		Asistencia_fecha = asistencia_fecha;
		Asistencia_semana = asistencia_semana;
		Asistencia_estado = asistencia_estado;
	}

	public int getAsistencia_id() {
		return Asistencia_id;
	}

	public void setAsistencia_id(int asistencia_id) {
		Asistencia_id = asistencia_id;
	}

	public int getAsistencia_estudiante_id() {
		return Asistencia_estudiante_id;
	}

	public void setAsistencia_estudiante_id(int asistencia_estudiante_id) {
		Asistencia_estudiante_id = asistencia_estudiante_id;
	}

	public String getAsistencia_fecha() {
		return Asistencia_fecha;
	}

	public void setAsistencia_fecha(String asistencia_fecha) {
		Asistencia_fecha = asistencia_fecha;
	}

	public String getAsistencia_estado() {
		return Asistencia_estado;
	}

	public void setAsistencia_estado(String asistencia_estado) {
		Asistencia_estado = asistencia_estado;
	}

	public int getAsistencia_semana() {
		return Asistencia_semana;
	}

	public void setAsistencia_semana(int asistencia_semana) {
		Asistencia_semana = asistencia_semana;
	}
    
}
