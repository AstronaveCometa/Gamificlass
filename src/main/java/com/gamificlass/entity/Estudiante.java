package com.gamificlass.entity;

public class Estudiante {

	private int Estudiante_id;
    private String Estudiante_nombre;
    private String Estudiante_apellido;
    private Long Estudiante_puntaje;
    private int Estudiante_nivel;
    
	public Estudiante(int estudiante_id, String estudiante_nombre, String estudiante_apellido, Long estudiante_puntaje,
			int estudiante_nivel) {
		Estudiante_id = estudiante_id;
		Estudiante_nombre = estudiante_nombre;
		Estudiante_apellido = estudiante_apellido;
		Estudiante_puntaje = estudiante_puntaje;
		Estudiante_nivel = estudiante_nivel;
	}

	public Estudiante() {
	}

	public int getEstudiante_id() {
		return Estudiante_id;
	}

	public void setEstudiante_id(int estudiante_id) {
		Estudiante_id = estudiante_id;
	}

	public String getEstudiante_nombre() {
		return Estudiante_nombre;
	}

	public void setEstudiante_nombre(String estudiante_nombre) {
		Estudiante_nombre = estudiante_nombre;
	}

	public String getEstudiante_apellido() {
		return Estudiante_apellido;
	}

	public void setEstudiante_apellido(String estudiante_apellido) {
		Estudiante_apellido = estudiante_apellido;
	}

	public Long getEstudiante_puntaje() {
		return Estudiante_puntaje;
	}

	public void setEstudiante_puntaje(Long estudiante_puntaje) {
		Estudiante_puntaje = estudiante_puntaje;
	}

	public int getEstudiante_nivel() {
		return Estudiante_nivel;
	}

	public void setEstudiante_nivel(int estudiante_nivel) {
		Estudiante_nivel = estudiante_nivel;
	}
	
	
	
    
    
}
