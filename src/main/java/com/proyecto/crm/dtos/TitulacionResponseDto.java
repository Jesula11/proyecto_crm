package com.proyecto.crm.dtos;

public record TitulacionResponseDto(
		Long idTitulacion,
		String codigo,
		String diminutivo,
		Integer horasTotales
		) {}
