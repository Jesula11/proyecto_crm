package com.proyecto.crm.services.impl;

import org.springframework.stereotype.Service;

import com.proyecto.crm.dtos.CursoResponseDto;
import com.proyecto.crm.dtos.ModuloResponseDto;
import com.proyecto.crm.dtos.Relacion_modulo_cursoRequestDto;
import com.proyecto.crm.dtos.Relacion_modulo_cursoResponseDto;
import com.proyecto.crm.dtos.TitulacionResponseDto;
import com.proyecto.crm.entities.Curso;
import com.proyecto.crm.entities.Modulo;
import com.proyecto.crm.entities.Relacion_modulo_curso;
import com.proyecto.crm.entities.Titulacion;
import com.proyecto.crm.repositories.CursoRepository;
import com.proyecto.crm.repositories.ModuloRepository;
import com.proyecto.crm.repositories.Relacion_modulo_cursoRepository;
import com.proyecto.crm.services.Relacion_modulo_cursoService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Relacion_modulo_cursoServiceImpl implements Relacion_modulo_cursoService {
	private final Relacion_modulo_cursoRepository relacionRepository;
	private final ModuloRepository moduloRepository;
	private final CursoRepository cursoRepository;

	public Relacion_modulo_cursoServiceImpl(
			Relacion_modulo_cursoRepository relacionRepository,
			ModuloRepository moduloRepository,
			CursoRepository cursoRepository) {
		this.relacionRepository = relacionRepository;
		this.moduloRepository = moduloRepository;
		this.cursoRepository = cursoRepository;
	}

	@Override
	public Relacion_modulo_cursoResponseDto obtenerPorId(Long id) {
		Relacion_modulo_curso relacion = relacionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Relación módulo-curso no encontrada."));
		return convertirRelacion(relacion);
	}

	@Override
	public Relacion_modulo_cursoResponseDto crear(Relacion_modulo_cursoRequestDto requestDto) {
		Relacion_modulo_curso relacion = new Relacion_modulo_curso();
		actualizarRelacion(relacion, requestDto);
		return convertirRelacion(relacionRepository.save(relacion));
	}

	@Override
	public Relacion_modulo_cursoResponseDto actualizar(Long id, Relacion_modulo_cursoRequestDto requestDto) {
		Relacion_modulo_curso relacion = relacionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Relación módulo-curso no encontrada."));
		actualizarRelacion(relacion, requestDto);
		return convertirRelacion(relacionRepository.save(relacion));
	}

	@Override
	public void eliminar(Long id) {
		Relacion_modulo_curso relacion = relacionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Relación módulo-curso no encontrada."));
		relacionRepository.delete(relacion);
	}

	private void actualizarRelacion(Relacion_modulo_curso relacion, Relacion_modulo_cursoRequestDto requestDto) {
		relacion.setModulo(buscarModulo(requestDto.modulo()));
		relacion.setCurso(buscarCurso(requestDto.curso()));
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

	private Curso buscarCurso(CursoResponseDto dto) {
		if (dto == null) {
			return null;
		}
		if (dto.idCruso() == null) {
			throw new IllegalArgumentException("El curso debe tener un ID.");
		}
		return cursoRepository.findById(dto.idCruso())
				.orElseThrow(() -> new RuntimeException("Curso no encontrado."));
	}

	private Relacion_modulo_cursoResponseDto convertirRelacion(Relacion_modulo_curso relacion) {
		return new Relacion_modulo_cursoResponseDto(
				relacion.getIdRelacionModuloCurso(),
				convertirModulo(relacion.getModulo()),
				convertirCurso(relacion.getCurso())
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

	private CursoResponseDto convertirCurso(Curso curso) {
		if (curso == null) {
			return null;
		}
		return new CursoResponseDto(
				curso.getIdCruso(),
				curso.getDiminutivo(),
				curso.getDescripcion(),
				convertirTitulacion(curso.getTitulacion())
		);
	}

	private TitulacionResponseDto convertirTitulacion(Titulacion titulacion) {
		if (titulacion == null) {
			return null;
		}
		return new TitulacionResponseDto(
				titulacion.getIdTitulacion(),
				titulacion.getCodigo(),
				titulacion.getDiminutivo(),
				titulacion.getHorasTotales()
		);
	}
}
