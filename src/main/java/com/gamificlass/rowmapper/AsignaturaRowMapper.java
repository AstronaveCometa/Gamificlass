package com.gamificlass.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gamificlass.entity.Asignatura;

public class AsignaturaRowMapper implements RowMapper<Asignatura>{

	public Asignatura mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Asignatura asignatura = new Asignatura();
		asignatura.setAsignatura_id(resultSet.getInt("Asignatura_id"));
		asignatura.setAsignatura_inicio(resultSet.getString("Asignatura_inicio"));
		asignatura.setAsignatura_nombre(resultSet.getString("Asignatura_nombre"));
		return asignatura;
	}
}
