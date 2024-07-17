package com.gamificlass.repository;

import com.gamificlass.entity.Nivel;

public interface NivelDAO {

	Nivel obtenerNivelPorPuntaje(Long puntaje);
	
	boolean subeDeNivel(int IdEstudiante, Long puntajeObtenido);
	
	void subirDeNivel(int IdEstudiante, Long puntajeObtenido);
}
