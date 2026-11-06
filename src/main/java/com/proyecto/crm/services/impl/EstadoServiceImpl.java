package com.proyecto.crm.services.impl;

import org.springframework.stereotype.Service;

import com.proyecto.crm.dtos.EstadoRequestDto;
import com.proyecto.crm.dtos.EstadoResponseDto;
import com.proyecto.crm.entities.Estado;
import com.proyecto.crm.repositories.EstadoRepository;
import com.proyecto.crm.services.EstadoService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstadoServiceImpl implements EstadoService {
	private final EstadoRepository estadoRepository;

	public EstadoServiceImpl(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}

	@Override
	public EstadoResponseDto obtenerPorId(Long id) {
		Estado estado = estadoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Estado no encontrado."));
		return convertirEstado(estado);
	}

	@Override
	public EstadoResponseDto crear(EstadoRequestDto requestDto) {
		Estado estado = new Estado();
		actualizarEstado(estado, requestDto);
		return convertirEstado(estadoRepository.save(estado));
	}

	@Override
	public EstadoResponseDto actualizar(Long id, EstadoRequestDto requestDto) {
		Estado estado = estadoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Estado no encontrado."));
		actualizarEstado(estado, requestDto);
		return convertirEstado(estadoRepository.save(estado));
	}

	@Override
	public void eliminar(Long id) {
		Estado estado = estadoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Estado no encontrado."));
		estadoRepository.delete(estado);
	}

	private void actualizarEstado(Estado estado, EstadoRequestDto requestDto) {
		estado.setNombre(requestDto.nombre());
		estado.setDescripcion(requestDto.descripcion());
	}

	private EstadoResponseDto convertirEstado(Estado estado) {
		return new EstadoResponseDto(estado.getIdEstado(), estado.getNombre(), estado.getDescripcion());
	}
}
