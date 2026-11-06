package com.proyecto.crm.services.impl;

import org.springframework.stereotype.Service;

import com.proyecto.crm.dtos.AlumnoResponseDto;
import com.proyecto.crm.dtos.EstadoResponseDto;
import com.proyecto.crm.dtos.FamiliaResponseDto;
import com.proyecto.crm.dtos.ModuloResponseDto;
import com.proyecto.crm.dtos.Relacion_MatriculaRequestDto;
import com.proyecto.crm.dtos.Relacion_MatriculaResponseDto;
import com.proyecto.crm.entities.Alumno;
import com.proyecto.crm.entities.Estado;
import com.proyecto.crm.entities.Familia;
import com.proyecto.crm.entities.Modulo;
import com.proyecto.crm.entities.Relacion_Matricula;
import com.proyecto.crm.repositories.AlumnoRepository;
import com.proyecto.crm.repositories.EstadoRepository;
import com.proyecto.crm.repositories.ModuloRepository;
import com.proyecto.crm.repositories.Relacion_MatriculaRepository;
import com.proyecto.crm.services.Relacion_MatriculaService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Relacion_MatriculaServiceImpl implements Relacion_MatriculaService {
	private final Relacion_MatriculaRepository relacionRepository;
	private final AlumnoRepository alumnoRepository;
	private final EstadoRepository estadoRepository;
	private final ModuloRepository moduloRepository;

	public Relacion_MatriculaServiceImpl(
			Relacion_MatriculaRepository relacionRepository,
			AlumnoRepository alumnoRepository,
			EstadoRepository estadoRepository,
			ModuloRepository moduloRepository) {
		this.relacionRepository = relacionRepository;
		this.alumnoRepository = alumnoRepository;
		this.estadoRepository = estadoRepository;
		this.moduloRepository = moduloRepository;
	}

	@Override
	public Relacion_MatriculaResponseDto obtenerPorId(Long id) {
		Relacion_Matricula relacion = relacionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Relación de matrícula no encontrada."));
		return convertirRelacion(relacion);
	}

	@Override
	public Relacion_MatriculaResponseDto crear(Relacion_MatriculaRequestDto requestDto) {
		Relacion_Matricula relacion = new Relacion_Matricula();
		actualizarRelacion(relacion, requestDto);
		return convertirRelacion(relacionRepository.save(relacion));
	}

	@Override
	public Relacion_MatriculaResponseDto actualizar(Long id, Relacion_MatriculaRequestDto requestDto) {
		Relacion_Matricula relacion = relacionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Relación de matrícula no encontrada."));
		actualizarRelacion(relacion, requestDto);
		return convertirRelacion(relacionRepository.save(relacion));
	}

	@Override
	public void eliminar(Long id) {
		Relacion_Matricula relacion = relacionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Relación de matrícula no encontrada."));
		relacionRepository.delete(relacion);
	}

	private void actualizarRelacion(Relacion_Matricula relacion, Relacion_MatriculaRequestDto requestDto) {
		relacion.setAlumno(buscarAlumno(requestDto.alumno()));
		relacion.setEastado(buscarEstado(requestDto.estado()));
		relacion.setModulo(buscarModulo(requestDto.modulo()));
	}

	private Alumno buscarAlumno(AlumnoResponseDto dto) {
		if (dto == null) {
			return null;
		}
		if (dto.idAlumno() == null) {
			throw new IllegalArgumentException("El alumno debe tener un ID.");
		}
		return alumnoRepository.findById(dto.idAlumno())
				.orElseThrow(() -> new RuntimeException("Alumno no encontrado."));
	}

	private Estado buscarEstado(EstadoResponseDto dto) {
		if (dto == null) {
			return null;
		}
		if (dto.idEstado() == null) {
			throw new IllegalArgumentException("El estado debe tener un ID.");
		}
		return estadoRepository.findById(dto.idEstado())
				.orElseThrow(() -> new RuntimeException("Estado no encontrado."));
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

	private Relacion_MatriculaResponseDto convertirRelacion(Relacion_Matricula relacion) {
		return new Relacion_MatriculaResponseDto(
				relacion.getIdRelacionMatricula(),
				convertirAlumno(relacion.getAlumno()),
				convertirEstado(relacion.getEastado()),
				convertirModulo(relacion.getModulo())
		);
	}

	private AlumnoResponseDto convertirAlumno(Alumno alumno) {
		if (alumno == null) {
			return null;
		}
		return new AlumnoResponseDto(
				alumno.getIdAlumno(),
				alumno.getNombre(),
				alumno.getApellidos(),
				alumno.getDni(),
				alumno.getNumeroSS(),
				alumno.getEmailPersonal(),
				alumno.getTelefonoPersonal(),
				alumno.getFechaAlta(),
				alumno.getFechaBaja(),
				alumno.getEmailCentro(),
				convertirFamilia(alumno.getFamilia())
		);
	}

	private FamiliaResponseDto convertirFamilia(Familia familia) {
		if (familia == null) {
			return null;
		}
		return new FamiliaResponseDto(
				familia.getIdFamilia(),
				familia.getNombreMadre(),
				familia.getNombrePadre(),
				familia.getApellidoMadre(),
				familia.getApellidoPadre(),
				familia.getEmailMadre(),
				familia.getEamilPadre(),
				familia.getTelefonoMadre(),
				familia.getTelefonoPadre(),
				familia.getDireccionMadre(),
				familia.getDireccionPadre(),
				familia.getCpMadre(),
				familia.getCpPadre(),
				familia.getMunicipioMadre(),
				familia.getMunicipioPadre(),
				familia.getProvinciaMadre(),
				familia.getProvinciaPadre(),
				familia.getSonSeparados(),
				familia.getEsCompartida(),
				familia.getEsMadre(),
				familia.getEsPadre()
		);
	}

	private EstadoResponseDto convertirEstado(Estado estado) {
		if (estado == null) {
			return null;
		}
		return new EstadoResponseDto(estado.getIdEstado(), estado.getNombre(), estado.getDescripcion());
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
}
