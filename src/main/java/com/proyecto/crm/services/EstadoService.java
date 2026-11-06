package com.proyecto.crm.services;

import java.util.List;

import com.proyecto.crm.dtos.EstadoRequestDto;
import com.proyecto.crm.dtos.EstadoResponseDto;

public interface EstadoService {
	EstadoResponseDto obtenerPorId(Long id);
	EstadoResponseDto crear(EstadoRequestDto requestDto);
	EstadoResponseDto actualizar(Long id, EstadoRequestDto requestDto);
    void eliminar(Long id);
    List<EstadoResponseDto>obtenerTodos();
}
