package com.gamificlass.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gamificlass.entity.Asignatura;
import com.gamificlass.entity.Asistencia;
import com.gamificlass.entity.Estudiante;
import com.gamificlass.entity.EstudianteYAsistenciaDTO;
import com.gamificlass.repository.AsignaturaDAO;
import com.gamificlass.service.AsistenciaService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AsistenciaController {

	@Autowired
	private AsistenciaService asistenciaService;
	
	@Autowired
	private AsignaturaDAO asignaturaDAO;
	
	@SuppressWarnings("null")
	@GetMapping(value = {"/AsistenciaAsignatura"})
	public String abrirAsistencia(HttpServletRequest request, Model modelo) {
		List<Asignatura> todasLasAsignaturas = asignaturaDAO.obtenerTodasLasAsignaturas();
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("asignaturaActual") != null) {
			Asignatura asignaturaActual = (Asignatura) session.getAttribute("asignaturaActual");
			List<Estudiante> todosLosEstudiantes = asignaturaDAO.obtenerEstudiantesDeAsignaturaID(asignaturaActual.getAsignatura_id());
			
			List<EstudianteYAsistenciaDTO> estudiantesYAsistencias = null;
			
			for(int i=0;i<todosLosEstudiantes.size();i++) {
				EstudianteYAsistenciaDTO estYAsis = new EstudianteYAsistenciaDTO(
						todosLosEstudiantes.get(i).getEstudiante_nombre(),
						todosLosEstudiantes.get(i).getEstudiante_apellido(),
						null
						);
				List<Asistencia> asistenciasDelEstudiante = asistenciaService.obtenerAsistenciasPorIdEstudiante(todosLosEstudiantes.get(i).getEstudiante_id());
				
				for(int j=estYAsis.getAsistencias().size();j<17;j++) {
					Asistencia asistenciaVacia = new Asistencia(0, todosLosEstudiantes.get(i).getEstudiante_id(), null, j+1, "P"); //se crea una asistencia ficticia para añadir a la asistencia del estudiante para mostrar en la página
					asistenciasDelEstudiante.add(asistenciaVacia);
				}
				estYAsis.setAsistencias(asistenciasDelEstudiante);
				estudiantesYAsistencias.add(estYAsis);
			}
			
			/*Es necesario arreglar las asistencias en la base de datos, hay que agregar las semanas*/
			
			
			
			int semana = asignaturaDAO.obtenerSemanaDeAsignaturaPorID(asignaturaActual.getAsignatura_id());
			modelo.addAttribute("semana", semana);
			modelo.addAttribute("EstudiantesYAsistencias", estudiantesYAsistencias);
			modelo.addAttribute("todasLasAsignaturas", todasLasAsignaturas);
			modelo.addAttribute("asignaturaActual", asignaturaActual);
		} else {
			Asignatura asignaturaActual = new Asignatura();
			Integer semana = 0;
			modelo.addAttribute("semana", semana);
			modelo.addAttribute("todasLasAsignaturas", todasLasAsignaturas);
			modelo.addAttribute("asignaturaActual", asignaturaActual);
		}
		return "redirect:/Asistencia";
	}
	
}
