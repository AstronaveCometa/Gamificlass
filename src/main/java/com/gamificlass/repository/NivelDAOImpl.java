package com.gamificlass.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gamificlass.entity.Estudiante;
import com.gamificlass.entity.Nivel;
import com.gamificlass.rowmapper.NivelRowMapper;

@Repository
public class NivelDAOImpl implements NivelDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EstudianteDAO estudianteDAO;
	
	@Override
	public Nivel obtenerNivelPorPuntaje(Long puntaje) {
		String sql = "SELECT * FROM Gamificlass.Niveles WHERE Nivel_puntaje_inicio <= " + puntaje + " AND Nivel_puntaje_final >= " + puntaje + ";";
		List<Nivel> resultado = jdbcTemplate.query(sql, new NivelRowMapper());
		if(resultado.isEmpty()) {
			return null;
		} else {
			Nivel nivel = resultado.get(0);
			return nivel;
		}
	}

	@Override
	public boolean subeDeNivel(int IdEstudiante, Long puntajeObtenido) {
		Estudiante estudiante = estudianteDAO.obtenerEstudiantePorId(IdEstudiante);
		Nivel nivel = obtenerNivelPorPuntaje(estudiante.getEstudiante_puntaje() + puntajeObtenido);
		if(nivel.getNivel_nivel() == estudiante.getEstudiante_nivel()) {
			return false;
		} else if (nivel.getNivel_nivel() > estudiante.getEstudiante_nivel()){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void subirDeNivel(int IdEstudiante, Long puntajeObtenido) {
		Estudiante estudiante = estudianteDAO.obtenerEstudiantePorId(IdEstudiante);
		Nivel nivel = obtenerNivelPorPuntaje(estudiante.getEstudiante_puntaje() + puntajeObtenido);
		estudianteDAO.actualizarNivelPorId(nivel.getNivel_nivel(), IdEstudiante);
	}

	
}
