package com.gamificlass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gamificlass.entity.Asignatura;
import com.gamificlass.entity.Estudiante;
import com.gamificlass.repository.AsignaturaDAO;

@Controller
public class ListaController {
	
	@Autowired
	private AsignaturaDAO asignaturaDAO;
	
	@GetMapping(value = {"/","/ListaAsignatura"})
	public String abrirLista(Model modelo) {
		List<Asignatura> todasLasAsignaturas = asignaturaDAO.obtenerTodasLasAsignaturas();
		Asignatura asignaturaActual = new Asignatura();
		modelo.addAttribute("todasLasAsignaturas", todasLasAsignaturas);
		modelo.addAttribute("asignaturaActual", asignaturaActual);
		return "ListaAsignatura";
	}
	
	@PostMapping(value = "/seleccionarAsignatura")
	public String mostrarLista(@ModelAttribute(value = "asignaturaActual") Asignatura asignaturaActual, Model modelo) {
		List<Estudiante> todosLosEstudiantes = asignaturaDAO.obtenerEstudiantesDeAsignaturaID(asignaturaActual.getAsignatura_id());
		modelo.addAttribute("todosLosEstudiantes", todosLosEstudiantes);		
		return "redirect:/ListaAsignatura";
	}
	
}
