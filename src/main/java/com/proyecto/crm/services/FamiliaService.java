package com.proyecto.crm.services;

import java.util.List;

import com.proyecto.crm.dtos.FamiliaRequestDto;
import com.proyecto.crm.dtos.FamiliaResponseDto;

public interface FamiliaService {
	FamiliaResponseDto obtenerPorId(Long id);
	FamiliaResponseDto crear(FamiliaRequestDto requestDto);
	FamiliaResponseDto actualizar(Long id, FamiliaRequestDto requestDto);
    void eliminar(Long id);
    List<FamiliaResponseDto>obtenerTodos();
}
