package com.proyecto.crm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.crm.dtos.AlumnoRequestDto;
import com.proyecto.crm.dtos.AlumnoResponseDto;
import com.proyecto.crm.dtos.FamiliaResponseDto;
import com.proyecto.crm.entities.Alumno;
import com.proyecto.crm.entities.Familia;
import com.proyecto.crm.repositories.AlumnoRepository;
import com.proyecto.crm.repositories.FamiliaRepository;
import com.proyecto.crm.services.AlumnoService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AlumnoServiceImpl implements AlumnoService {
	private final AlumnoRepository alumnoRepository;
	   
	  
	   public AlumnoServiceImpl(AlumnoRepository alumnoRepository, FamiliaRepository familiaRepository) {
	       this.alumnoRepository = alumnoRepository;	       
	   }
	   	@Override
		public AlumnoResponseDto obtenerPorId(Long id) {
			Alumno alumnoEncontrado = alumnoRepository.findById(id).orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
				return convertirAlumnoCogido(alumnoEncontrado);
		}
	   	@Override
		public AlumnoResponseDto obtenerPorDni(String dni) {
			Alumno alumnoEncontrado = alumnoRepository.findByDni(dni).orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
				return convertirAlumnoCogido(alumnoEncontrado);
		}
		@Override
		public AlumnoResponseDto crear(AlumnoRequestDto requestDto) {
			Alumno nuevoAlumno = new Alumno();
				nuevoAlumno.setNombre(requestDto.nombre());
				nuevoAlumno.setApellidos(requestDto.apellidos());
				nuevoAlumno.setDni(requestDto.dni());
				nuevoAlumno.setNumeroSS(requestDto.numeroSS());
				nuevoAlumno.setEmailPersonal(requestDto.emailPersonal());
				nuevoAlumno.setEmailPersonal(requestDto.telefonoPersonal());
				nuevoAlumno.setFechaAlta(requestDto.fechaAlta());
				nuevoAlumno.setFechaBaja(requestDto.fechaBaja());
				nuevoAlumno.setEmailCentro(requestDto.emailCentro());
						alumnoRepository.save(nuevoAlumno);
							return convertirAlumnoCogido(nuevoAlumno);
		}
		
		@Override
		public AlumnoResponseDto actualizar(Long id, AlumnoRequestDto requestDto) {
			Alumno alumnoEncontrado = alumnoRepository.findById(id).orElseThrow(() -> new RuntimeException("Alumno no encontrado."));
			alumnoEncontrado.setNombre(requestDto.nombre());
			alumnoEncontrado.setApellidos(requestDto.apellidos());
			alumnoEncontrado.setDni(requestDto.dni());
			alumnoEncontrado.setNumeroSS(requestDto.numeroSS());
			alumnoEncontrado.setEmailPersonal(requestDto.emailPersonal());
			alumnoEncontrado.setTelefonoPersonal(requestDto.telefonoPersonal());
			alumnoEncontrado.setFechaAlta(requestDto.fechaAlta());
			alumnoEncontrado.setFechaBaja(requestDto.fechaBaja());
			alumnoEncontrado.setEmailCentro(requestDto.emailCentro());
					alumnoRepository.save(alumnoEncontrado);
						return convertirAlumnoCogido(alumnoEncontrado);
		}
		@Override
		public AlumnoResponseDto actualizar(String dni, AlumnoRequestDto requestDto) {
			Alumno alumnoEncontrado = alumnoRepository.findByDni(dni).orElseThrow(() -> new RuntimeException("Alumno no encontrado."));
				alumnoEncontrado.setNombre(requestDto.nombre());
				alumnoEncontrado.setApellidos(requestDto.apellidos());
				alumnoEncontrado.setDni(requestDto.dni());
				alumnoEncontrado.setNumeroSS(requestDto.numeroSS());
				alumnoEncontrado.setEmailCentro(requestDto.emailCentro());
				alumnoEncontrado.setEmailPersonal(requestDto.emailPersonal());
				alumnoEncontrado.setFechaAlta(requestDto.fechaAlta());
				alumnoEncontrado.setFechaBaja(requestDto.fechaBaja());
				alumnoEncontrado.setTelefonoPersonal(requestDto.emailPersonal());
						alumnoRepository.save(alumnoEncontrado);
							return convertirAlumnoCogido(alumnoEncontrado);
		}
		@Override
		public void eliminar(Long id) {
			Alumno alumnoEncontrado = alumnoRepository.findById(id).orElseThrow(() -> new RuntimeException("Alumno no encontrado."));
				alumnoRepository.delete(alumnoEncontrado);
		}
		@Override
		public void eliminar(String dni) {
			Alumno alumnoEncontrado = alumnoRepository.findByDni(dni).orElseThrow(() -> new RuntimeException("Alumno no encontrado."));
				alumnoRepository.delete(alumnoEncontrado);
		}

	private AlumnoResponseDto convertirAlumnoCogido(Alumno alumnoCogido) {
		return new AlumnoResponseDto(
				alumnoCogido.getIdAlumno(),
				alumnoCogido.getNombre(),
				alumnoCogido.getApellidos(),
				alumnoCogido.getDni(),
				alumnoCogido.getNumeroSS(),
				alumnoCogido.getEmailPersonal(),
				alumnoCogido.getTelefonoPersonal(),
				alumnoCogido.getFechaAlta(),
				alumnoCogido.getFechaBaja(),
				alumnoCogido.getEmailCentro(),
				convertirFamilia(alumnoCogido.getFamilia())
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
	
	@Override
	public List<AlumnoResponseDto> obtenerTodos() {
		return alumnoRepository.findAll().stream().map(this::convertirAlumnoCogido).toList();
	}
}
