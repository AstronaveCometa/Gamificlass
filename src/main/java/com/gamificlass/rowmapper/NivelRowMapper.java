package com.gamificlass.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gamificlass.entity.Nivel;

public class NivelRowMapper implements RowMapper<Nivel>{

	public Nivel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Nivel nivel = new Nivel();
		nivel.setNivel_id(resultSet.getInt("Nivel_id"));
		nivel.setNivel_puntaje_inicio(resultSet.getLong("Nivel_puntaje_inicio"));
		nivel.setNivel_puntaje_final(resultSet.getLong("Nivel_puntaje_final"));
		nivel.setNivel_nivel(resultSet.getInt("Nivel_nivel"));
		return nivel;
	}
}
