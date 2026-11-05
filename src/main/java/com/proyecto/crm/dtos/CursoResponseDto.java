package com.proyecto.crm.dtos;
public record CursoResponseDto(
		Long idCruso,
		String diminutivo,
		String descripcion,
		TitulacionResponseDto titulacion
		) {}
