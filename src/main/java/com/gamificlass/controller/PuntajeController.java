package com.gamificlass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gamificlass.service.EstudianteService;

@Controller
public class PuntajeController {

	@Autowired
	private EstudianteService estudianteService;
	
	@PostMapping
	public String responderPregunta(@PathVariable int id) {
		Long puntajeObtenido = 500l;
		estudianteService.actualizarPuntajePorId(puntajeObtenido, id);
		
		return "redirect:/ListaAsignatura";
	}
}
