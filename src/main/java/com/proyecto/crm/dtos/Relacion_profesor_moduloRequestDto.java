package com.proyecto.crm.dtos;

public record Relacion_profesor_moduloRequestDto(
		ModuloResponseDto modulo,
		ProfesorResponseDto profesor
		) {}
