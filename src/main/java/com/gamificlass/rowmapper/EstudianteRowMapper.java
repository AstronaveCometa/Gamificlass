package com.gamificlass.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gamificlass.entity.Estudiante;


public class EstudianteRowMapper implements RowMapper<Estudiante>{

	public Estudiante mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Estudiante estudiante = new Estudiante();
		estudiante.setEstudiante_id(resultSet.getInt("Estudiante_id"));
		estudiante.setEstudiante_nombre(resultSet.getString("Estudiante_nombre"));
		estudiante.setEstudiante_apellido(resultSet.getString("Estudiante_apellido"));
		estudiante.setEstudiante_puntaje(resultSet.getLong("Estudiante_puntaje"));
		estudiante.setEstudiante_nivel(resultSet.getInt("Estudiante_nivel"));
		return estudiante;
	}
}
