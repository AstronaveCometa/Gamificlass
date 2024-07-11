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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ListaController {
	
	@Autowired
	private AsignaturaDAO asignaturaDAO;
	
	@GetMapping(value = {"/","/ListaAsignatura"})
	public String abrirLista(HttpServletRequest request, Model modelo) {
		List<Asignatura> todasLasAsignaturas = asignaturaDAO.obtenerTodasLasAsignaturas();
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("asignaturaActual") != null) {
			Asignatura asignaturaActual = (Asignatura) session.getAttribute("asignaturaActual");
			List<Estudiante> todosLosEstudiantes = asignaturaDAO.obtenerEstudiantesDeAsignaturaID(asignaturaActual.getAsignatura_id());
			modelo.addAttribute("todosLosEstudiantes", todosLosEstudiantes);
			modelo.addAttribute("todasLasAsignaturas", todasLasAsignaturas);
			modelo.addAttribute("asignaturaActual", asignaturaActual);
		} else {
			Asignatura asignaturaActual = new Asignatura();
			modelo.addAttribute("todasLasAsignaturas", todasLasAsignaturas);
			modelo.addAttribute("asignaturaActual", asignaturaActual);
		}
		return "ListaAsignatura";
	}
	
	@PostMapping(value = "/seleccionarAsignatura")
	public String mostrarLista(HttpServletRequest request, @ModelAttribute(value = "asignaturaActual") Asignatura asignaturaActual) {
		HttpSession session = request.getSession();
		session.setAttribute("asignaturaActual", asignaturaActual);	
		return "redirect:/ListaAsignatura";
	}
	
}
