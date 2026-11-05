package com.proyecto.crm.dtos;

public record ProfesorResponseDto(
		Long idProfesor,
		String nombre,
		String apellidos,
		String dni,
		String emailPersonal,
		String emailCentro,
		String telefonoPersonal,
		DepartamentoResponseDto departamento
		) {}
