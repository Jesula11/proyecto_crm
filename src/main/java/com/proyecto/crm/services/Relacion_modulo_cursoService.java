package com.proyecto.crm.services;

import com.proyecto.crm.dtos.Relacion_modulo_cursoRequestDto;
import com.proyecto.crm.dtos.Relacion_modulo_cursoResponseDto;

public interface Relacion_modulo_cursoService {
	Relacion_modulo_cursoResponseDto obtenerPorId(Long id);
	Relacion_modulo_cursoResponseDto crear(Relacion_modulo_cursoRequestDto requestDto);
	Relacion_modulo_cursoResponseDto actualizar(Long id, Relacion_modulo_cursoRequestDto requestDto);
    void eliminar(Long id);
}
