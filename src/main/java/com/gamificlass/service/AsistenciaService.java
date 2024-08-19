package com.gamificlass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamificlass.entity.Asistencia;
import com.gamificlass.repository.AsistenciaDAO;

@Service
public class AsistenciaService {

	@Autowired
	private AsistenciaDAO asistenciaDAO;
	
	public List<Asistencia> obtenerAsistenciasPorIdEstudiante(int ID){
		return asistenciaDAO.obtenerAsistenciasPorIdEstudiante(ID);
	}
	
	public Asistencia obtenerAsistenciaPorIdYFecha(int ID, String fecha) {
		return asistenciaDAO.obtenerAsistenciaPorIdYFecha(ID, fecha);
	}
	
	public void crearAsistenciaPorIdEstudiante(int ID, String estado) {
		asistenciaDAO.crearAsistenciaPorIdEstudiante(ID, estado);
	}
	
	public void actualizarAsistenciaPorIdAsistencia(int ID, String nuevoEstado) {
		asistenciaDAO.actualizarAsistenciaPorIdAsistencia(ID, nuevoEstado);
	}
}
