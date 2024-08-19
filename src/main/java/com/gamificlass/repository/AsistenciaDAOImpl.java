package com.gamificlass.repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gamificlass.entity.Asistencia;
import com.gamificlass.rowmapper.AsistenciaRowMapper;

@Repository
public class AsistenciaDAOImpl implements AsistenciaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public AsistenciaDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Asistencia> obtenerAsistenciasPorIdEstudiante(int ID) {
		String sql = "SELECT * FROM Gamificlass.Asistencias WHERE Asistencia_estudiante_id = " + ID + ";";
		return jdbcTemplate.query(sql, new AsistenciaRowMapper());
	}

	@Override
	public Asistencia obtenerAsistenciaPorIdYFecha(int ID, String fecha) {
		String sql = "SELECT * FROM Gamificlass.Asistencias WHERE Asistencia_estudiante_id = " + ID +
				" AND Asistencia_fecha = " + fecha + ";";
		List<Asistencia> resultado = jdbcTemplate.query(sql, new AsistenciaRowMapper());
		if(resultado.isEmpty()) {
			return null;
		} else {
			Asistencia asistencia = resultado.get(0);
			return asistencia;
		}
	}

	@Override
	public void crearAsistenciaPorIdEstudiante(int ID, String estado) {
		Date fechaActual = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String fechaFormateada = formato.format(fechaActual);
		String sql = "INSERT INTO Gamificlass.Asistencias (Asistencia_estudiante_id, Asistencia_fecha, Asistencia_estado) VALUE (?,'" +
				fechaFormateada + "', ?);";
		jdbcTemplate.update(sql, ID, estado);
	}

	@Override
	public void actualizarAsistenciaPorIdAsistencia(int ID, String nuevoEstado) {
		String sql = "UPDATE Gamificlass.Asistencias SET Asistencia_estado = ? WHERE Asistencia_id = ?;";
		jdbcTemplate.update(sql, nuevoEstado, ID);
		
	}




}
