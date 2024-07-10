package com.gamificlass.repository;

import java.util.List;

import com.gamificlass.entity.Asignatura;
import com.gamificlass.entity.Estudiante;

public interface AsignaturaDAO {

	Asignatura obtenerAsignaturaPorID(int ID);
	
	Asignatura obtenerAsignaturaPorNombre(String asignatura_nombre);
	
	List<Estudiante> obtenerEstudiantesDeAsignaturaID(int ID);
	
}
