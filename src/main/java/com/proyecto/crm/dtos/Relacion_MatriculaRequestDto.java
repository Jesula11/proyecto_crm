package com.proyecto.crm.dtos;

public record Relacion_MatriculaRequestDto(
		AlumnoResponseDto alumno,
		EstadoResponseDto estado,
		ModuloResponseDto modulo
		) {}
