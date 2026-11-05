package com.proyecto.crm.services;

import com.proyecto.crm.dtos.DepartamentoRequestDto;
import com.proyecto.crm.dtos.DepartamentoResponseDto;

public interface DepartamentoService {
	DepartamentoResponseDto obtenerPorId(Long id);
	DepartamentoResponseDto obtenerPorId(String codigo);
	DepartamentoResponseDto crear(DepartamentoRequestDto requestDto);
	DepartamentoResponseDto actualizar(Long id, DepartamentoRequestDto requestDto);
	DepartamentoResponseDto actualizar(String codigo, DepartamentoRequestDto requestDto);
    void eliminar(Long id);
    void eliminar(String codigo);
}
