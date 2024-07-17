package com.gamificlass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamificlass.repository.NivelDAO;

@Service
public class NivelService {

	@Autowired
	private NivelDAO nivelDAO;
	
	public boolean subirDeNivel(int IdEstudiante, Long puntajeObtenido) {
		if(nivelDAO.subeDeNivel(IdEstudiante, puntajeObtenido)) {
			nivelDAO.subirDeNivel(IdEstudiante, puntajeObtenido);
			return true;
		} else {
			return false;
		}
	}
}
