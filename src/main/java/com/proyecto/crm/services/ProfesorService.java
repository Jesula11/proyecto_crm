package com.proyecto.crm.services;

import java.util.List;

import com.proyecto.crm.dtos.ProfesorRequestDto;
import com.proyecto.crm.dtos.ProfesorResponseDto;

public interface ProfesorService {
	ProfesorResponseDto obtenerPorId(Long id);
	ProfesorResponseDto obtenerPorIDni(String dni);
	ProfesorResponseDto crear(ProfesorRequestDto requestDto);
	ProfesorResponseDto actualizar(Long id, ProfesorRequestDto requestDto);
	ProfesorResponseDto actualizar(String dni, ProfesorRequestDto requestDto);
    void eliminar(Long id);
    void eliminar(String dni);
    List<ProfesorResponseDto>obtenerTodos();
}
