package com.proyecto.crm.services.impl;

import org.springframework.stereotype.Service;

import com.proyecto.crm.dtos.DepartamentoResponseDto;
import com.proyecto.crm.dtos.ProfesorRequestDto;
import com.proyecto.crm.dtos.ProfesorResponseDto;
import com.proyecto.crm.entities.Departamento;
import com.proyecto.crm.entities.Profesor;
import com.proyecto.crm.repositories.DepartamentoRepository;
import com.proyecto.crm.repositories.ProfesorRepository;
import com.proyecto.crm.services.ProfesorService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProfesorServiceImpl implements ProfesorService {
	private final ProfesorRepository profesorRepository;
	private final DepartamentoRepository departamentoRepository;

	public ProfesorServiceImpl(
			ProfesorRepository profesorRepository,
			DepartamentoRepository departamentoRepository) {
		this.profesorRepository = profesorRepository;
		this.departamentoRepository = departamentoRepository;
	}

	@Override
	public ProfesorResponseDto obtenerPorId(Long id) {
		Profesor profesor = profesorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Profesor no encontrado."));
		return convertirProfesor(profesor);
	}

	@Override
	public ProfesorResponseDto obtenerPorIDni(String dni) {
		Profesor profesor = profesorRepository.findByDni(dni)
				.orElseThrow(() -> new RuntimeException("Profesor no encontrado."));
		return convertirProfesor(profesor);
	}

	@Override
	public ProfesorResponseDto crear(ProfesorRequestDto requestDto) {
		Profesor profesor = new Profesor();
		actualizarProfesor(profesor, requestDto);
		return convertirProfesor(profesorRepository.save(profesor));
	}

	@Override
	public ProfesorResponseDto actualizar(Long id, ProfesorRequestDto requestDto) {
		Profesor profesor = profesorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Profesor no encontrado."));
		actualizarProfesor(profesor, requestDto);
		return convertirProfesor(profesorRepository.save(profesor));
	}

	@Override
	public ProfesorResponseDto actualizar(String dni, ProfesorRequestDto requestDto) {
		Profesor profesor = profesorRepository.findByDni(dni)
				.orElseThrow(() -> new RuntimeException("Profesor no encontrado."));
		actualizarProfesor(profesor, requestDto);
		return convertirProfesor(profesorRepository.save(profesor));
	}

	@Override
	public void eliminar(Long id) {
		Profesor profesor = profesorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Profesor no encontrado."));
		profesorRepository.delete(profesor);
	}

	@Override
	public void eliminar(String dni) {
		Profesor profesor = profesorRepository.findByDni(dni)
				.orElseThrow(() -> new RuntimeException("Profesor no encontrado."));
		profesorRepository.delete(profesor);
	}

	private void actualizarProfesor(Profesor profesor, ProfesorRequestDto requestDto) {
		profesor.setNombre(requestDto.nombre());
		profesor.setApellidos(requestDto.apellidos());
		profesor.setDni(requestDto.dni());
		profesor.setEmailPersonal(requestDto.emailPersonal());
		profesor.setEmailCentro(requestDto.emailCentro());
		profesor.setTelefonoPersonal(requestDto.telefonoPersonal());
		profesor.setDepartamento(buscarDepartamento(requestDto.departamento()));
	}

	private Departamento buscarDepartamento(DepartamentoResponseDto departamentoDto) {
		if (departamentoDto == null) {
			return null;
		}
		if (departamentoDto.idDepartamento() == null) {
			throw new IllegalArgumentException("El departamento debe tener un ID.");
		}
		return departamentoRepository.findById(departamentoDto.idDepartamento())
				.orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
	}

	private ProfesorResponseDto convertirProfesor(Profesor profesor) {
		return new ProfesorResponseDto(
				profesor.getIdProfesor(),
				profesor.getNombre(),
				profesor.getApellidos(),
				profesor.getDni(),
				profesor.getEmailPersonal(),
				profesor.getEmailCentro(),
				profesor.getTelefonoPersonal(),
				convertirDepartamento(profesor.getDepartamento())
		);
	}

	private DepartamentoResponseDto convertirDepartamento(Departamento departamento) {
		if (departamento == null) {
			return null;
		}
		return new DepartamentoResponseDto(
				departamento.getIdDepartamento(),
				departamento.getCodigo(),
				departamento.getNombre(),
				departamento.getDescripcion(),
				departamento.getTelefono()
		);
	}
}
