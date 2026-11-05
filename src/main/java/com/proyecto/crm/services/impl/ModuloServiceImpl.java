package com.proyecto.crm.services.impl;

import org.springframework.stereotype.Service;

import com.proyecto.crm.dtos.ModuloRequestDto;
import com.proyecto.crm.dtos.ModuloResponseDto;
import com.proyecto.crm.entities.Modulo;
import com.proyecto.crm.repositories.ModuloRepository;
import com.proyecto.crm.services.ModuloService;

import jakarta.transaction.Transactional;

@Service
public class ModuloServiceImpl implements ModuloService {
	private final ModuloRepository moduloRepository;

	public ModuloServiceImpl(ModuloRepository moduloRepository) {
		this.moduloRepository = moduloRepository;
	}

	@Override
	@Transactional
	public ModuloResponseDto obtenerPorId(Long id) {
		Modulo modulo = moduloRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Módulo no encontrado."));
		return convertirModulo(modulo);
	}

	@Override
	@Transactional
	public ModuloResponseDto obtenerPorCodigo(String codigo) {
		Modulo modulo = moduloRepository.findByCodigo(codigo)
				.orElseThrow(() -> new RuntimeException("Módulo no encontrado."));
		return convertirModulo(modulo);
	}

	@Override
	@Transactional
	public ModuloResponseDto crear(ModuloRequestDto requestDto) {
		Modulo modulo = new Modulo();
		actualizarModulo(modulo, requestDto);
		return convertirModulo(moduloRepository.save(modulo));
	}

	@Override
	@Transactional
	public ModuloResponseDto actualizar(Long id, ModuloRequestDto requestDto) {
		Modulo modulo = moduloRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Módulo no encontrado."));
		actualizarModulo(modulo, requestDto);
		return convertirModulo(moduloRepository.save(modulo));
	}

	@Override
	@Transactional
	public ModuloResponseDto actualizar(String codigo, ModuloRequestDto requestDto) {
		Modulo modulo = moduloRepository.findByCodigo(codigo)
				.orElseThrow(() -> new RuntimeException("Módulo no encontrado."));
		actualizarModulo(modulo, requestDto);
		return convertirModulo(moduloRepository.save(modulo));
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		Modulo modulo = moduloRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Módulo no encontrado."));
		moduloRepository.delete(modulo);
	}

	@Override
	@Transactional
	public void eliminar(String codigo) {
		Modulo modulo = moduloRepository.findByCodigo(codigo)
				.orElseThrow(() -> new RuntimeException("Módulo no encontrado."));
		moduloRepository.delete(modulo);
	}

	private void actualizarModulo(Modulo modulo, ModuloRequestDto requestDto) {
		modulo.setCodigo(requestDto.codigo());
		modulo.setDiminutivo(requestDto.diminutivo());
		modulo.setNombre(requestDto.nombre());
		modulo.setDescripcion(requestDto.descripcion());
		modulo.setHorasSemanales(requestDto.horasSemanales());
		modulo.setCreditos(requestDto.creditos());
	}

	private ModuloResponseDto convertirModulo(Modulo modulo) {
		return new ModuloResponseDto(
				modulo.getIdModulo(),
				modulo.getCodigo(),
				modulo.getDiminutivo(),
				modulo.getNombre(),
				modulo.getDescripcion(),
				modulo.getHorasSemanales(),
				modulo.getCreditos()
		);
	}
}
