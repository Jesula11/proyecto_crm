package com.proyecto.crm.services;

import java.util.List;

import com.proyecto.crm.dtos.ModuloRequestDto;
import com.proyecto.crm.dtos.ModuloResponseDto;

public interface ModuloService {
	ModuloResponseDto obtenerPorId(Long id);
	ModuloResponseDto obtenerPorCodigo(String codigo);
	ModuloResponseDto crear(ModuloRequestDto requestDto);
	ModuloResponseDto actualizar(Long id, ModuloRequestDto requestDto);
	ModuloResponseDto actualizar(String codigo, ModuloRequestDto requestDto);
    void eliminar(Long id);
    void eliminar(String codigo);
    List<ModuloResponseDto>obtenerTodos();
}
