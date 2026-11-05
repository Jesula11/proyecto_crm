package com.proyecto.crm.dtos;

public record Relacion_MatriculaResponseDto(
		Long idRelacionMatricula,
		AlumnoResponseDto alumno,
		EstadoResponseDto estado,
		ModuloResponseDto modulo
		) {}
