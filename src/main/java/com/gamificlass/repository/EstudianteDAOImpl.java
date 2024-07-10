package com.gamificlass.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gamificlass.entity.Estudiante;
import com.gamificlass.rowmapper.EstudianteRowMapper;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public EstudianteDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Estudiante> obtenerTodosLosEstudiantes() {
		String sql = "SELECT * FROM Gamificlass.Estudiantes;";
		return jdbcTemplate.query(sql, new EstudianteRowMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Estudiante obtenerEstudiantePorId(int ID) {
		String sql = "SELECT * FROM Gamificlass.Estudiantes WHERE Estudiante_id = ?";
		List<Estudiante> resultado = jdbcTemplate.query(sql, new Object[]{ID}, new EstudianteRowMapper());
		if(resultado.isEmpty()) {
			return null;
		} else {
			Estudiante estudiante = resultado.get(0);
		return estudiante;
		}
	}

	@Override
	public void actualizarPuntajePorId(Long puntajeObtenido, int ID) {
		String sql = "UPDATE Gamificlass.Estudiantes SET Estudiante_puntaje = ? WHERE Estudiante_id = ?;";
		Estudiante estudiante = obtenerEstudiantePorId(ID);
		jdbcTemplate.update(sql, (estudiante.getEstudiante_puntaje() + puntajeObtenido), ID);
	}

	@Override
	public void actualizarNivelPorId(int nivel, int ID) {
		String sql = "UPDATE Gamificlass.Estudiantes SET Estudiante_nivel = ? WHERE Estudiante_id = ?;";
		jdbcTemplate.update(sql, nivel, ID);
	}

	@Override
	public void crearEstudiante(Estudiante estudiante) {
		String sql = "INSERT INTO Gamificlass.Estudiantes (Estudiante_nombre, Estudiante_apellido, Estudiante_puntaje, Estudiante_nivel) VALUE (?, ?, 0, 1);";
		jdbcTemplate.update(sql, estudiante.getEstudiante_nombre(), estudiante.getEstudiante_apellido());
	}

	@Override
	public void eliminarEstudiantePorId(int ID) {
		String sql = "DELETE FROM Gamificlass.Estudiantes WHERE Estudiante_id = ?;";
		jdbcTemplate.update(sql, ID);
	}

}
