package com.proyecto.crm.dtos;

public record DepartamentoResponseDto(
		Long idDepartamento,
		String codigo,
		String nombre,
		String descripcion,
		String telefono
		) {}
