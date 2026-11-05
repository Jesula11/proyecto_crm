package com.proyecto.crm.services;

import java.util.List;

import com.proyecto.crm.dtos.AlumnoRequestDto;
import com.proyecto.crm.dtos.AlumnoResponseDto;

public interface AlumnoService {
    AlumnoResponseDto obtenerPorId(Long id);
    AlumnoResponseDto obtenerPorDni(String dni);
    AlumnoResponseDto crear(AlumnoRequestDto requestDto);
    AlumnoResponseDto actualizar(Long id, AlumnoRequestDto requestDto);
    AlumnoResponseDto actualizar(String dni, AlumnoRequestDto requestDto);
    void eliminar(Long id);
    void eliminar(String dni);
	List<AlumnoResponseDto> obtenerTodos();
}
