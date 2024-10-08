package com.gamificlass.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gamificlass.entity.Asignatura;
import com.gamificlass.entity.Estudiante;
import com.gamificlass.rowmapper.AsignaturaRowMapper;
import com.gamificlass.rowmapper.EstudianteRowMapper;

@Repository
public class AsignaturaDAOImpl implements AsignaturaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Asignatura> obtenerTodasLasAsignaturas(){
		String sql = "SELECT * FROM Gamificlass.Asignaturas;";
		List<Asignatura> resultado = jdbcTemplate.query(sql, new AsignaturaRowMapper());
		return resultado;
	}
	
	@Override
	public Asignatura obtenerAsignaturaPorID(int ID) {
		String sql = "SELECT * FROM Gamificlass.Asignaturas WHERE Asignatura_id = ?";
		@SuppressWarnings("deprecation")
		List<Asignatura> resultado = jdbcTemplate.query(sql, new Object[]{ID}, new AsignaturaRowMapper());
		if(resultado.isEmpty()) {
			return null;
		} else {
			Asignatura asignatura = resultado.get(0);
		return asignatura;
		}
	}

	@Override
	public Asignatura obtenerAsignaturaPorNombre(String asignatura_nombre) {
		String sql = "SELECT * FROM Gamificlass.Asignaturas WHERE Asignatura_nombre = ?";
		@SuppressWarnings("deprecation")
		List<Asignatura> resultado = jdbcTemplate.query(sql, new Object[]{asignatura_nombre}, new AsignaturaRowMapper());
		if(resultado.isEmpty()) {
			return null;
		} else {
			Asignatura asignatura = resultado.get(0);
		return asignatura;
		}
	}

	@Override
	public List<Estudiante> obtenerEstudiantesDeAsignaturaID(int ID) {
		String sql = "SELECT e.Estudiante_id AS Estudiante_id, Estudiante_nombre, Estudiante_apellido, Estudiante_puntaje, Estudiante_nivel"
				+ "	FROM Estudiantes e RIGHT JOIN Estudiante_tiene_Asignatura ea"
				+ " ON e.Estudiante_id = ea.Estudiante_id"
				+ " WHERE ea.Asignatura_id = ?;";
		@SuppressWarnings("deprecation")
		List<Estudiante> resultado = jdbcTemplate.query(sql, new Object[]{ID}, new EstudianteRowMapper());
		return resultado;
	}

	@Override
	public int obtenerSemanaDeAsignaturaPorID(int ID) {
		String sql = "SELECT * FROM Gamificlass.Asignaturas WHERE Asignatura_id = ?";
		@SuppressWarnings("deprecation")
		List<Asignatura> resultado = jdbcTemplate.query(sql, new Object[]{ID}, new AsignaturaRowMapper());
		if(resultado.isEmpty()) {
			return 0;
		} else {
			String inicio = resultado.get(0).getAsignatura_inicio();
			Date fechaActual = new Date();
			System.out.println(fechaActual);
			int diasInicio = Integer.parseInt(inicio.substring(5, 7))*30 + Integer.parseInt(inicio.substring(8));
			int diasActual = (fechaActual.getMonth()+1)*30 + fechaActual.getDate();
			int diasTranscurridos = diasActual - diasInicio;
			return Math.floorDiv(diasTranscurridos,7) + 1;
		}
	}

}
