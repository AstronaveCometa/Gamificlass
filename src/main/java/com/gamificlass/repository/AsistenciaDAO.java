package com.gamificlass.repository;

import java.util.List;

import com.gamificlass.entity.Asistencia;

public interface AsistenciaDAO {

	List<Asistencia> obtenerAsistenciasPorIdEstudiante(int ID);
	
	Asistencia obtenerAsistenciaPorIdYFecha(int ID, String fecha);
	
	void crearAsistenciaPorIdEstudiante(int ID, String estado);
	
	void actualizarAsistenciaPorIdAsistencia(int ID, String nuevoEstado);
	
}
