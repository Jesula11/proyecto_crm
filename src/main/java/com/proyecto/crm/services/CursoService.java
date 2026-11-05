package com.proyecto.crm.services;

import java.util.List;

import com.proyecto.crm.dtos.CursoRequestDto;
import com.proyecto.crm.dtos.CursoResponseDto;

public interface CursoService {
	CursoResponseDto obtenerPorId(Long id);
	CursoResponseDto obtenerPorDiminutivo(String diminutivo);
    CursoResponseDto crear(CursoRequestDto requestDto);
    CursoResponseDto actualizar(Long id, CursoRequestDto requestDto);
    CursoResponseDto actualizar(String diminutivo, CursoRequestDto requestDto);
    void eliminar(Long id);
    void eliminar(String diminutico);
    List<CursoResponseDto> obtenerTodos();
}