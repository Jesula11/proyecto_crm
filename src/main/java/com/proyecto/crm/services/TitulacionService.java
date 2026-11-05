package com.proyecto.crm.services;

import com.proyecto.crm.dtos.TitulacionRequestDto;
import com.proyecto.crm.dtos.TitulacionResponseDto;

public interface TitulacionService {
	TitulacionResponseDto obtenerPorId(Long id);
	TitulacionResponseDto obtenerPorCodigo(String codigo);
	TitulacionResponseDto crear(TitulacionRequestDto requestDto);
	TitulacionResponseDto actualizar(Long id, TitulacionRequestDto requestDto);
	TitulacionResponseDto actualizar(String codigo, TitulacionRequestDto requestDto);
    void eliminar(Long id);
    void eliminar(String codigo);
}
