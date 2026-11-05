package com.proyecto.crm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.crm.dtos.CursoRequestDto;
import com.proyecto.crm.dtos.CursoResponseDto;
import com.proyecto.crm.dtos.TitulacionResponseDto;
import com.proyecto.crm.entities.Curso;
import com.proyecto.crm.entities.Titulacion;
import com.proyecto.crm.repositories.CursoRepository;
import com.proyecto.crm.repositories.TitulacionRepository;
import com.proyecto.crm.services.CursoService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CursoServiceImpl implements CursoService {
	private final CursoRepository cursoRepository;
	private final TitulacionRepository titulacionRepository;

	public CursoServiceImpl(CursoRepository cursoRepository, TitulacionRepository titulacionRepository) {
		this.cursoRepository = cursoRepository;
		this.titulacionRepository = titulacionRepository;
	}

	@Override
	public CursoResponseDto obtenerPorId(Long id) {
		Curso cursoEncontrado = cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso no encontrado."));
		return convertirCursoCogido(cursoEncontrado);
	}

	@Override
	public CursoResponseDto obtenerPorDiminutivo(String diminutivo) {
		Curso cursoEncontrado = cursoRepository.findByDiminutivo(diminutivo).orElseThrow(() -> new RuntimeException("Curso no encontrado."));
		return convertirCursoCogido(cursoEncontrado);
	}

	@Override
	public CursoResponseDto crear(CursoRequestDto requestDto) {
		Curso nuevoCurso = new Curso();
		nuevoCurso.setDiminutivo(requestDto.diminutivo());
		nuevoCurso.setDescripcion(requestDto.descripcion());
		nuevoCurso.setTitulacion(buscarTitulacion(requestDto.titulacion()));

		Curso cursoGuardado = cursoRepository.save(nuevoCurso);
		return convertirCursoCogido(cursoGuardado);
	}

	@Override
	public CursoResponseDto actualizar(Long id, CursoRequestDto requestDto) {
		Curso cursoEncontrado = cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso no encontrado."));
		actualizarCurso(cursoEncontrado, requestDto);
		return convertirCursoCogido(cursoRepository.save(cursoEncontrado));
	}

	@Override
	public CursoResponseDto actualizar(String diminutivo, CursoRequestDto requestDto) {
		Curso cursoEncontrado = cursoRepository.findByDiminutivo(diminutivo)
				.orElseThrow(() -> new RuntimeException("Curso no encontrado."));
		actualizarCurso(cursoEncontrado, requestDto);
		return convertirCursoCogido(cursoRepository.save(cursoEncontrado));
	}

	@Override
	public void eliminar(Long id) {
		Curso cursoEncontrado = cursoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Curso no encontrado."));
		cursoRepository.delete(cursoEncontrado);
	}

	@Override
	public void eliminar(String diminutivo) {
		Curso cursoEncontrado = cursoRepository.findByDiminutivo(diminutivo)
				.orElseThrow(() -> new RuntimeException("Curso no encontrado."));
		cursoRepository.delete(cursoEncontrado);
	}

	@Override
	public List<CursoResponseDto> obtenerTodos() {
		return cursoRepository.findAll().stream().map(this::convertirCursoCogido).toList();
	}

	private void actualizarCurso(Curso curso, CursoRequestDto requestDto) {
		curso.setDiminutivo(requestDto.diminutivo());
		curso.setDescripcion(requestDto.descripcion());
		curso.setTitulacion(buscarTitulacion(requestDto.titulacion()));
	}

	private Titulacion buscarTitulacion(TitulacionResponseDto titulacionDto) {
		if (titulacionDto == null) {
			return null;
		}
		if (titulacionDto.idTitulacion() == null) {
			throw new IllegalArgumentException("La titulación debe tener un ID.");
		}
		return titulacionRepository.findById(titulacionDto.idTitulacion())
				.orElseThrow(() -> new RuntimeException("Titulación no encontrada."));
	}

	private CursoResponseDto convertirCursoCogido(Curso cursoCogido) {
		return new CursoResponseDto(
				cursoCogido.getIdCruso(),
				cursoCogido.getDiminutivo(),
				cursoCogido.getDescripcion(),
				convertirTitulacion(cursoCogido.getTitulacion())
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
