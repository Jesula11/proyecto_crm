package com.proyecto.crm.dtos;

public record Relacion_modulo_cursoResponseDto(
		Long idRelacionModuloCurso,
		ModuloResponseDto modulo,
		CursoResponseDto curso
		) {}
