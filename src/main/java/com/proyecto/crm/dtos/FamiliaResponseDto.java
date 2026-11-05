package com.proyecto.crm.dtos;

public record FamiliaResponseDto(
		Long idFamilia,
		String nombreMadre,
		String nombrePadre,
		String apellidoMadre,
		String apellidoPadre,
		String emailMadre,
		String eamilPadre,
		Integer telefonoMadre,
		Integer telefonoPadre,
		Integer direccionMadre,
		Integer direccionPadre,
		Integer cpMadre,
		Integer cpPadre,
		String municipioMadre,
		String municipioPadre,
		String provinciaMadre,
		String provinciaPadre,
		String sonSeparados,
		String esCompartida,
		String esMadre,
		String esPadre
		) {}
