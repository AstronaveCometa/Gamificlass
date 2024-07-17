package com.gamificlass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gamificlass.service.EstudianteService;
import com.gamificlass.service.NivelService;

@Controller
public class PuntajeController {

	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private NivelService nivelService;
	
	@GetMapping(value = "/respondeEnClase/{id}")
	public String responderPregunta(@PathVariable int id) {
		Long puntajeObtenido = 500l;
		estudianteService.actualizarPuntajePorId(puntajeObtenido, id);
		nivelService.subirDeNivel(id, puntajeObtenido);
		return "redirect:/ListaAsignatura";
	}
}
