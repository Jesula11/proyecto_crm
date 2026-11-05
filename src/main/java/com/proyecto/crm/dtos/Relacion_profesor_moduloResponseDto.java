package com.proyecto.crm.dtos;

public record Relacion_profesor_moduloResponseDto(
		Long idRelacionProfesorModulo,
		ModuloResponseDto modulo,
		ProfesorResponseDto profesor
		) {}
