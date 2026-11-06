package com.proyecto.crm.services.impl;

import org.springframework.stereotype.Service;

import com.proyecto.crm.dtos.DepartamentoRequestDto;
import com.proyecto.crm.dtos.DepartamentoResponseDto;
import com.proyecto.crm.entities.Departamento;
import com.proyecto.crm.repositories.DepartamentoRepository;
import com.proyecto.crm.services.DepartamentoService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartamentoServiceImpl implements DepartamentoService {
	private final DepartamentoRepository departamentoRepository;

	public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	@Override
	public DepartamentoResponseDto obtenerPorId(Long id) {
		Departamento departamento = departamentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
		return convertirDepartamento(departamento);
	}

	@Override
	public DepartamentoResponseDto obtenerPorId(String codigo) {
		Departamento departamento = departamentoRepository.findByCodigo(codigo)
				.orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
		return convertirDepartamento(departamento);
	}

	@Override
	public DepartamentoResponseDto crear(DepartamentoRequestDto requestDto) {
		Departamento departamento = new Departamento();
		actualizarDepartamento(departamento, requestDto);
		return convertirDepartamento(departamentoRepository.save(departamento));
	}

	@Override
	public DepartamentoResponseDto actualizar(Long id, DepartamentoRequestDto requestDto) {
		Departamento departamento = departamentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
		actualizarDepartamento(departamento, requestDto);
		return convertirDepartamento(departamentoRepository.save(departamento));
	}

	@Override
	public DepartamentoResponseDto actualizar(String codigo, DepartamentoRequestDto requestDto) {
		Departamento departamento = departamentoRepository.findByCodigo(codigo)
				.orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
		actualizarDepartamento(departamento, requestDto);
		return convertirDepartamento(departamentoRepository.save(departamento));
	}

	@Override
	public void eliminar(Long id) {
		Departamento departamento = departamentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
		departamentoRepository.delete(departamento);
	}

	@Override
	public void eliminar(String codigo) {
		Departamento departamento = departamentoRepository.findByCodigo(codigo)
				.orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
		departamentoRepository.delete(departamento);
	}

	private void actualizarDepartamento(Departamento departamento, DepartamentoRequestDto requestDto) {
		departamento.setCodigo(requestDto.codigo());
		departamento.setNombre(requestDto.nombre());
		departamento.setDescripcion(requestDto.descripcion());
		departamento.setTelefono(requestDto.telefono());
	}

	private DepartamentoResponseDto convertirDepartamento(Departamento departamento) {
		return new DepartamentoResponseDto(
				departamento.getIdDepartamento(),
				departamento.getCodigo(),
				departamento.getNombre(),
				departamento.getDescripcion(),
				departamento.getTelefono()
		);
	}
}
