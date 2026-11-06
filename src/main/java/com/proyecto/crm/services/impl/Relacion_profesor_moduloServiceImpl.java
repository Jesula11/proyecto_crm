package com.proyecto.crm.services.impl;

import org.springframework.stereotype.Service;

import com.proyecto.crm.dtos.DepartamentoResponseDto;
import com.proyecto.crm.dtos.ModuloResponseDto;
import com.proyecto.crm.dtos.ProfesorResponseDto;
import com.proyecto.crm.dtos.Relacion_profesor_moduloRequestDto;
import com.proyecto.crm.dtos.Relacion_profesor_moduloResponseDto;
import com.proyecto.crm.entities.Departamento;
import com.proyecto.crm.entities.Modulo;
import com.proyecto.crm.entities.Profesor;
import com.proyecto.crm.entities.Relacion_profesor_modulo;
import com.proyecto.crm.repositories.ModuloRepository;
import com.proyecto.crm.repositories.ProfesorRepository;
import com.proyecto.crm.repositories.Relacion_profesor_moduloRepository;
import com.proyecto.crm.services.Relacion_profesor_moduloService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Relacion_profesor_moduloServiceImpl implements Relacion_profesor_moduloService {
	private final Relacion_profesor_moduloRepository relacionRepository;
	private final ModuloRepository moduloRepository;
	private final ProfesorRepository profesorRepository;

	public Relacion_profesor_moduloServiceImpl(
			Relacion_profesor_moduloRepository relacionRepository,
			ModuloRepository moduloRepository,
			ProfesorRepository profesorRepository) {
		this.relacionRepository = relacionRepository;
		this.moduloRepository = moduloRepository;
		this.profesorRepository = profesorRepository;
	}

	@Override
	public Relacion_profesor_moduloResponseDto obtenerPorId(Long id) {
		Relacion_profesor_modulo relacion = relacionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Relación profesor-módulo no encontrada."));
		return convertirRelacion(relacion);
	}

	@Override
	public Relacion_profesor_moduloResponseDto crear(Relacion_profesor_moduloRequestDto requestDto) {
		Relacion_profesor_modulo relacion = new Relacion_profesor_modulo();
		actualizarRelacion(relacion, requestDto);
		return convertirRelacion(relacionRepository.save(relacion));
	}

	@Override
	public Relacion_profesor_moduloResponseDto actualizar(
			Long id,
			Relacion_profesor_moduloRequestDto requestDto) {
		Relacion_profesor_modulo relacion = relacionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Relación profesor-módulo no encontrada."));
		actualizarRelacion(relacion, requestDto);
		return convertirRelacion(relacionRepository.save(relacion));
	}

	@Override
	public void eliminar(Long id) {
		Relacion_profesor_modulo relacion = relacionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Relación profesor-módulo no encontrada."));
		relacionRepository.delete(relacion);
	}

	private void actualizarRelacion(
			Relacion_profesor_modulo relacion,
			Relacion_profesor_moduloRequestDto requestDto) {
		relacion.setModulo(buscarModulo(requestDto.modulo()));
		relacion.setProfesor(buscarProfesor(requestDto.profesor()));
	}

	private Modulo buscarModulo(ModuloResponseDto dto) {
		if (dto == null) {
			return null;
		}
		if (dto.idModulo() == null) {
			throw new IllegalArgumentException("El módulo debe tener un ID.");
		}
		return moduloRepository.findById(dto.idModulo())
				.orElseThrow(() -> new RuntimeException("Módulo no encontrado."));
	}

	private Profesor buscarProfesor(ProfesorResponseDto dto) {
		if (dto == null) {
			return null;
		}
		if (dto.idProfesor() == null) {
			throw new IllegalArgumentException("El profesor debe tener un ID.");
		}
		return profesorRepository.findById(dto.idProfesor())
				.orElseThrow(() -> new RuntimeException("Profesor no encontrado."));
	}

	private Relacion_profesor_moduloResponseDto convertirRelacion(Relacion_profesor_modulo relacion) {
		return new Relacion_profesor_moduloResponseDto(
				relacion.getIdRelacionProfesorModulo(),
				convertirModulo(relacion.getModulo()),
				convertirProfesor(relacion.getProfesor())
		);
	}

	private ModuloResponseDto convertirModulo(Modulo modulo) {
		if (modulo == null) {
			return null;
		}
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

	private ProfesorResponseDto convertirProfesor(Profesor profesor) {
		if (profesor == null) {
			return null;
		}
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
