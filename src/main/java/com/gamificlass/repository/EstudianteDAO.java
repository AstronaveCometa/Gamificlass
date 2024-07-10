package com.gamificlass.repository;

import java.util.List;

import com.gamificlass.entity.Estudiante;

public interface EstudianteDAO {

	List<Estudiante> obtenerTodosLosEstudiantes();
	
	Estudiante obtenerEstudiantePorId(int ID);
	
	void actualizarPuntajePorId(Long puntajeObtenido, int ID);
	
	void actualizarNivelPorId(int nivel, int ID);
	
	void crearEstudiante (Estudiante estudiante);
	
	void eliminarEstudiantePorId(int ID);
	
}
