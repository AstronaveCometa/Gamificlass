package com.gamificlass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gamificlass.entity.Asignatura;
import com.gamificlass.entity.CalculoPuntaje;
import com.gamificlass.repository.AsignaturaDAO;
import com.gamificlass.service.EstudianteService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class PuntajeController {

	@Autowired
	private EstudianteService estudianteService;
	
	
	@Autowired
	private AsignaturaDAO asignaturaDAO;
	
	private CalculoPuntaje calculo = new CalculoPuntaje();
	
	@GetMapping(value = "/respondeEnClase/{idEstudiante}")
	public String responderPregunta(@PathVariable String idEstudiante, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Asignatura asignaturaActual = (Asignatura) session.getAttribute("asignaturaActual");
		int idAsignatura = asignaturaActual.getAsignatura_id();
		Long puntajeObtenido = calculo.puntajeResponderEnClase(asignaturaDAO.obtenerSemanaDeAsignaturaPorID(idAsignatura));
		estudianteService.actualizarPuntajePorId(puntajeObtenido, Integer.parseInt(idEstudiante));
		estudianteService.subirDeNivel(Integer.parseInt(idEstudiante), puntajeObtenido);
		return "redirect:/ListaAsignatura";
	}
	
	@GetMapping(value = "/resuelveEnClase/{idEstudiante}")
	public String resolverEnClase(@PathVariable String idEstudiante, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Asignatura asignaturaActual = (Asignatura) session.getAttribute("asignaturaActual");
		int idAsignatura = asignaturaActual.getAsignatura_id();
		Long puntajeObtenido = calculo.puntajeResolverEjercicio(asignaturaDAO.obtenerSemanaDeAsignaturaPorID(idAsignatura));
		estudianteService.actualizarPuntajePorId(puntajeObtenido, Integer.parseInt(idEstudiante));
		estudianteService.subirDeNivel(Integer.parseInt(idEstudiante), puntajeObtenido);
		return "redirect:/ListaAsignatura";
	}
	
	@GetMapping(value = "/detectaErrores/{idEstudiante}")
	public String detectarErrores(@PathVariable String idEstudiante, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Asignatura asignaturaActual = (Asignatura) session.getAttribute("asignaturaActual");
		int idAsignatura = asignaturaActual.getAsignatura_id();
		Long puntajeObtenido = calculo.puntajeDetectarError(asignaturaDAO.obtenerSemanaDeAsignaturaPorID(idAsignatura));
		estudianteService.actualizarPuntajePorId(puntajeObtenido, Integer.parseInt(idEstudiante));
		estudianteService.subirDeNivel(Integer.parseInt(idEstudiante), puntajeObtenido);
		return "redirect:/ListaAsignatura";
	}
	
	@GetMapping(value = "/corrigeErrores/{idEstudiante}")
	public String corregirErrores(@PathVariable String idEstudiante, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Asignatura asignaturaActual = (Asignatura) session.getAttribute("asignaturaActual");
		int idAsignatura = asignaturaActual.getAsignatura_id();
		Long puntajeObtenido = calculo.puntajeCorregirError(asignaturaDAO.obtenerSemanaDeAsignaturaPorID(idAsignatura));
		estudianteService.actualizarPuntajePorId(puntajeObtenido, Integer.parseInt(idEstudiante));
		estudianteService.subirDeNivel(Integer.parseInt(idEstudiante), puntajeObtenido);
		return "redirect:/ListaAsignatura";
	}
	
	
	@GetMapping(value = "/mencionaRegla/{idEstudiante}")
	public String mencionarRegla(@PathVariable String idEstudiante, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Asignatura asignaturaActual = (Asignatura) session.getAttribute("asignaturaActual");
		int idAsignatura = asignaturaActual.getAsignatura_id();
		Long puntajeObtenido = calculo.puntajeMencionarRegla(asignaturaDAO.obtenerSemanaDeAsignaturaPorID(idAsignatura));
		estudianteService.actualizarPuntajePorId(puntajeObtenido, Integer.parseInt(idEstudiante));
		estudianteService.subirDeNivel(Integer.parseInt(idEstudiante), puntajeObtenido);
		return "redirect:/ListaAsignatura";
	}
	
	@GetMapping(value = "/preguntaEnChat/{idEstudiante}")
	public String preguntarEnChat(@PathVariable String idEstudiante, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Asignatura asignaturaActual = (Asignatura) session.getAttribute("asignaturaActual");
		int idAsignatura = asignaturaActual.getAsignatura_id();
		Long puntajeObtenido = calculo.puntajePreguntarEnChat(asignaturaDAO.obtenerSemanaDeAsignaturaPorID(idAsignatura));
		estudianteService.actualizarPuntajePorId(puntajeObtenido, Integer.parseInt(idEstudiante));
		estudianteService.subirDeNivel(Integer.parseInt(idEstudiante), puntajeObtenido);
		return "redirect:/ListaAsignatura";
	}
	
	@GetMapping(value = "/respondeEnChat/{idEstudiante}")
	public String responderEnChat(@PathVariable String idEstudiante, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Asignatura asignaturaActual = (Asignatura) session.getAttribute("asignaturaActual");
		int idAsignatura = asignaturaActual.getAsignatura_id();
		Long puntajeObtenido = calculo.puntajeResponderEnChat(asignaturaDAO.obtenerSemanaDeAsignaturaPorID(idAsignatura));
		estudianteService.actualizarPuntajePorId(puntajeObtenido, Integer.parseInt(idEstudiante));
		estudianteService.subirDeNivel(Integer.parseInt(idEstudiante), puntajeObtenido);
		return "redirect:/ListaAsignatura";
	}
}
