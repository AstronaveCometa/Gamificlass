package com.gamificlass.entity;

public class CalculoPuntaje {

	
	public float multiplicador(int semana) {
		float factor = 1;
		for(int i=1;i<semana;i++) {
			factor *= 1.1f;
		}
		return factor;
	}
	
	public Long puntajeResolverEjercicio(int semana) {
		return (long) (163*multiplicador(semana));
	}
	
	public Long puntajeResponderEnClase(int semana) {
		return (long) (122*multiplicador(semana));
	}
	
	public Long puntajeDetectarError(int semana) {
		return (long) (82*multiplicador(semana));
	}
	
	public Long puntajeCorregirError(int semana) {
		return (long) (109*multiplicador(semana));
	}
	
	public Long puntajeMencionarRegla(int semana) {
		return (long) (109*multiplicador(semana));
	}
	
	public Long puntajePreguntarEnChat(int semana) {
		return (long) (68*multiplicador(semana));
	}
	
	public Long puntajeResponderEnChat(int semana) {
		return (long) (163*multiplicador(semana));
	}
}
