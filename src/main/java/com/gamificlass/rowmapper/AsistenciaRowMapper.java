package com.gamificlass.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gamificlass.entity.Asistencia;

public class AsistenciaRowMapper implements RowMapper<Asistencia>{

	public Asistencia mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Asistencia asistencia = new Asistencia();
		asistencia.setAsistencia_id(resultSet.getInt("Asistencia_id"));
		asistencia.setAsistencia_estudiante_id(resultSet.getInt("Asistencia_estudiante_id"));
		asistencia.setAsistencia_fecha(resultSet.getString("Asistencia_fecha"));
		asistencia.setAsistencia_semana(resultSet.getInt("Asistencia_semana"));
		asistencia.setAsistencia_estado(resultSet.getString("Asistencia_estado"));
		return asistencia;
	}
}
