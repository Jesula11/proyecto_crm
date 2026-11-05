package com.proyecto.crm.dtos;


public record ProfesorRequestDto(
		String nombre,
		String apellidos,
		String dni,
		String emailPersonal,
		String emailCentro,
		String telefonoPersonal,
		DepartamentoResponseDto departamento
		) {}
