package com.proyecto.crm.services.impl;

import org.springframework.stereotype.Service;

import com.proyecto.crm.dtos.TitulacionRequestDto;
import com.proyecto.crm.dtos.TitulacionResponseDto;
import com.proyecto.crm.entities.Titulacion;
import com.proyecto.crm.repositories.TitulacionRepository;
import com.proyecto.crm.services.TitulacionService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TitulacionServiceImpl implements TitulacionService {
	private final TitulacionRepository titulacionRepository;

	public TitulacionServiceImpl(TitulacionRepository titulacionRepository) {
		this.titulacionRepository = titulacionRepository;
	}

	@Override
	public TitulacionResponseDto obtenerPorId(Long id) {
		Titulacion titulacion = titulacionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Titulación no encontrada."));
		return convertirTitulacion(titulacion);
	}

	@Override
	public TitulacionResponseDto obtenerPorCodigo(String codigo) {
		Titulacion titulacion = titulacionRepository.findByCodigo(codigo)
				.orElseThrow(() -> new RuntimeException("Titulación no encontrada."));
		return convertirTitulacion(titulacion);
	}

	@Override
	public TitulacionResponseDto crear(TitulacionRequestDto requestDto) {
		Titulacion titulacion = new Titulacion();
		actualizarTitulacion(titulacion, requestDto);
		return convertirTitulacion(titulacionRepository.save(titulacion));
	}

	@Override
	public TitulacionResponseDto actualizar(Long id, TitulacionRequestDto requestDto) {
		Titulacion titulacion = titulacionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Titulación no encontrada."));
		actualizarTitulacion(titulacion, requestDto);
		return convertirTitulacion(titulacionRepository.save(titulacion));
	}

	@Override
	public TitulacionResponseDto actualizar(String codigo, TitulacionRequestDto requestDto) {
		Titulacion titulacion = titulacionRepository.findByCodigo(codigo)
				.orElseThrow(() -> new RuntimeException("Titulación no encontrada."));
		actualizarTitulacion(titulacion, requestDto);
		return convertirTitulacion(titulacionRepository.save(titulacion));
	}

	@Override
	public void eliminar(Long id) {
		Titulacion titulacion = titulacionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Titulación no encontrada."));
		titulacionRepository.delete(titulacion);
	}

	@Override
	public void eliminar(String codigo) {
		Titulacion titulacion = titulacionRepository.findByCodigo(codigo)
				.orElseThrow(() -> new RuntimeException("Titulación no encontrada."));
		titulacionRepository.delete(titulacion);
	}

	private void actualizarTitulacion(Titulacion titulacion, TitulacionRequestDto requestDto) {
		titulacion.setCodigo(requestDto.codigo());
		titulacion.setDiminutivo(requestDto.diminutivo());
		titulacion.setHorasTotales(requestDto.horasTotales());
	}

	private TitulacionResponseDto convertirTitulacion(Titulacion titulacion) {
		return new TitulacionResponseDto(
				titulacion.getIdTitulacion(),
				titulacion.getCodigo(),
				titulacion.getDiminutivo(),
				titulacion.getHorasTotales()
		);
	}
}
