package com.proyecto.crm.services;

import com.proyecto.crm.dtos.Relacion_MatriculaRequestDto;
import com.proyecto.crm.dtos.Relacion_MatriculaResponseDto;

public interface Relacion_MatriculaService {
	Relacion_MatriculaResponseDto obtenerPorId(Long id);
	Relacion_MatriculaResponseDto crear(Relacion_MatriculaRequestDto requestDto);
	Relacion_MatriculaResponseDto actualizar(Long id, Relacion_MatriculaRequestDto requestDto);
    void eliminar(Long id);
}
