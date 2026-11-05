package com.proyecto.crm.services.impl;

import org.springframework.stereotype.Service;

import com.proyecto.crm.dtos.FamiliaRequestDto;
import com.proyecto.crm.dtos.FamiliaResponseDto;
import com.proyecto.crm.entities.Familia;
import com.proyecto.crm.repositories.FamiliaRepository;
import com.proyecto.crm.services.FamiliaService;

import jakarta.transaction.Transactional;

@Service
public class FamiliaServiceImpl implements FamiliaService {
	private final FamiliaRepository familiaRepository;

	public FamiliaServiceImpl(FamiliaRepository familiaRepository) {
		this.familiaRepository = familiaRepository;
	}

	@Override
	@Transactional
	public FamiliaResponseDto obtenerPorId(Long id) {
		Familia familia = familiaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Familia no encontrada."));
		return convertirFamilia(familia);
	}

	@Override
	@Transactional
	public FamiliaResponseDto crear(FamiliaRequestDto requestDto) {
		Familia familia = new Familia();
		actualizarFamilia(familia, requestDto);
		return convertirFamilia(familiaRepository.save(familia));
	}

	@Override
	@Transactional
	public FamiliaResponseDto actualizar(Long id, FamiliaRequestDto requestDto) {
		Familia familia = familiaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Familia no encontrada."));
		actualizarFamilia(familia, requestDto);
		return convertirFamilia(familiaRepository.save(familia));
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		Familia familia = familiaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Familia no encontrada."));
		familiaRepository.delete(familia);
	}

	private void actualizarFamilia(Familia familia, FamiliaRequestDto requestDto) {
		familia.setNombreMadre(requestDto.nombreMadre());
		familia.setNombrePadre(requestDto.nombrePadre());
		familia.setApellidoMadre(requestDto.apellidoMadre());
		familia.setApellidoPadre(requestDto.apellidoPadre());
		familia.setEmailMadre(requestDto.emailMadre());
		familia.setEamilPadre(requestDto.eamilPadre());
		familia.setTelefonoMadre(requestDto.telefonoMadre());
		familia.setTelefonoPadre(requestDto.telefonoPadre());
		familia.setDireccionMadre(requestDto.direccionMadre());
		familia.setDireccionPadre(requestDto.direccionPadre());
		familia.setCpMadre(requestDto.cpMadre());
		familia.setCpPadre(requestDto.cpPadre());
		familia.setMunicipioMadre(requestDto.municipioMadre());
		familia.setMunicipioPadre(requestDto.municipioPadre());
		familia.setProvinciaMadre(requestDto.provinciaMadre());
		familia.setProvinciaPadre(requestDto.provinciaPadre());
		familia.setSonSeparados(requestDto.sonSeparados());
		familia.setEsCompartida(requestDto.esCompartida());
		familia.setEsMadre(requestDto.esMadre());
		familia.setEsPadre(requestDto.esPadre());
	}

	private FamiliaResponseDto convertirFamilia(Familia familia) {
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
}
