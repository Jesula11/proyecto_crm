package com.proyecto.crm.services;

import com.proyecto.crm.dtos.Relacion_profesor_moduloRequestDto;
import com.proyecto.crm.dtos.Relacion_profesor_moduloResponseDto;

public interface Relacion_profesor_moduloService {
	Relacion_profesor_moduloResponseDto obtenerPorId(Long id);
	Relacion_profesor_moduloResponseDto crear(Relacion_profesor_moduloRequestDto requestDto);
	Relacion_profesor_moduloResponseDto actualizar(Long id, Relacion_profesor_moduloRequestDto requestDto);
    void eliminar(Long id);
}
