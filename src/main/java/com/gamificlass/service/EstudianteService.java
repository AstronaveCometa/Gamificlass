package com.gamificlass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamificlass.entity.Estudiante;
import com.gamificlass.repository.EstudianteDAO;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteDAO estudianteDAO;
	
	public List<Estudiante> obtenerTodosLosEstudiantes(){
		return estudianteDAO.obtenerTodosLosEstudiantes();
	}
	
	public Estudiante obtenerEstudiantePorId(int ID) {
		return estudianteDAO.obtenerEstudiantePorId(ID);
	}
	
	public void actualizarPuntajePorId(Long puntajeObtenido, int ID) {
		estudianteDAO.actualizarPuntajePorId(puntajeObtenido, ID);
	}
	
	public void actualizarNivelPorId(int nivel, int ID) {
		estudianteDAO.actualizarNivelPorId(nivel, ID);
	}
	
	public void crearEstudiante (Estudiante estudiante) {
		estudianteDAO.crearEstudiante(estudiante);
	}
	
	public void eliminarEstudiantePorId(int ID) {
		estudianteDAO.eliminarEstudiantePorId(ID);
	}
	
}
