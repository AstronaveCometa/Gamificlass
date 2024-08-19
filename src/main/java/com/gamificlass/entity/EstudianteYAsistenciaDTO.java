package com.gamificlass.entity;

import java.util.List;

public class EstudianteYAsistenciaDTO {

	private String Estudiante_nombre;
	private String Estudiante_apellido;
	private List<Asistencia> Asistencias;
	
	public EstudianteYAsistenciaDTO() {
	}

	public EstudianteYAsistenciaDTO(String estudiante_nombre, String estudiante_apellido,
			List<Asistencia> asistencias) {
		Estudiante_nombre = estudiante_nombre;
		Estudiante_apellido = estudiante_apellido;
		Asistencias = asistencias;
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

	public List<Asistencia> getAsistencias() {
		return Asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		Asistencias = asistencias;
	}
	
}
