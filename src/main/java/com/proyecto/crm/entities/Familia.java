package com.proyecto.crm.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "familias" , schema = "crm")

public class Familia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_familia", nullable = false)
	private Long idFamilia;
	
	@Column(name = "nombre_madre", length = 100)
	private String nombreMadre;
	
	@Column(name = "nombre_padre", length = 100)
	private String nombrePadre;
	
	@Column(name = "apellido_madre", length = 100)
	private String apellidoMadre;
	
	@Column(name = "apellido_padre", length = 100)
	private String apellidoPadre;
	
	@Column(name = "email_madre", length = 100)
	private String emailMadre;
	
	@Column(name = "email_padre", length = 100)
	private String eamilPadre;
	
	@Column(name = "telefono_madre", length = 9)
	private Integer telefonoMadre;
	
	@Column(name = "telefono_padre", length = 9)
	private Integer telefonoPadre;
	
	@Column(name = "direccion_madre", length = 100)
	private Integer direccionMadre;
	
	@Column(name = "direccion_padre", length = 100)
	private Integer direccionPadre;
	
	@Column(name = "CP_madre", length = 5)
	private Integer cpMadre;
	
	@Column(name = "CP_padre", length = 15)
	private Integer cpPadre;
	
	@Column(name = "municipio_madre", length = 100)
	private String municipioMadre;
	
	@Column(name = "municipio_padre", length = 100)
	private String municipioPadre;
	
	@Column(name = "provincia_madre", length = 100)
	private String provinciaMadre;
	
	@Column(name = "provincia_padre", length = 100)
	private String provinciaPadre;
	
	@Column(name = "son_separados", length = 100)
	private String sonSeparados;
	
	@Column(name = "es_compartida", length = 100)
	private String esCompartida;
	
	@Column(name = "es_madre", length = 100)
	private String esMadre;
	
	@Column(name = "es_padre", length = 100)
	private String esPadre;
	
	@OneToMany(mappedBy = "Familia")
    private List<Alumno> alumnos;
	
	//Constructores
	public Familia() {
		super();
	}

	public Familia(Long idFamilia, String nombreMadre, String nombrePadre, String apellidoMadre, String apellidoPadre,
			String emailMadre, String eamilPadre, Integer telefonoMadre, Integer telefonoPadre, Integer direccionMadre,
			Integer direccionPadre, Integer cpMadre, Integer cpPadre, String municipioMadre, String municipioPadre,
			String provinciaMadre, String provinciaPadre, String sonSeparados, String esCompartida, String esMadre,
			String esPadre, List<Alumno> alumnos) {
		super();
		this.idFamilia = idFamilia;
		this.nombreMadre = nombreMadre;
		this.nombrePadre = nombrePadre;
		this.apellidoMadre = apellidoMadre;
		this.apellidoPadre = apellidoPadre;
		this.emailMadre = emailMadre;
		this.eamilPadre = eamilPadre;
		this.telefonoMadre = telefonoMadre;
		this.telefonoPadre = telefonoPadre;
		this.direccionMadre = direccionMadre;
		this.direccionPadre = direccionPadre;
		this.cpMadre = cpMadre;
		this.cpPadre = cpPadre;
		this.municipioMadre = municipioMadre;
		this.municipioPadre = municipioPadre;
		this.provinciaMadre = provinciaMadre;
		this.provinciaPadre = provinciaPadre;
		this.sonSeparados = sonSeparados;
		this.esCompartida = esCompartida;
		this.esMadre = esMadre;
		this.esPadre = esPadre;
		this.alumnos = alumnos;
	}
	
	
	//Getters y Setters
	public Long getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(Long idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getNombreMadre() {
		return nombreMadre;
	}

	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}

	public String getNombrePadre() {
		return nombrePadre;
	}

	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	public String getApellidoMadre() {
		return apellidoMadre;
	}

	public void setApellidoMadre(String apellidoMadre) {
		this.apellidoMadre = apellidoMadre;
	}

	public String getApellidoPadre() {
		return apellidoPadre;
	}

	public void setApellidoPadre(String apellidoPadre) {
		this.apellidoPadre = apellidoPadre;
	}

	public String getEmailMadre() {
		return emailMadre;
	}

	public void setEmailMadre(String emailMadre) {
		this.emailMadre = emailMadre;
	}

	public String getEamilPadre() {
		return eamilPadre;
	}

	public void setEamilPadre(String eamilPadre) {
		this.eamilPadre = eamilPadre;
	}

	public Integer getTelefonoMadre() {
		return telefonoMadre;
	}

	public void setTelefonoMadre(Integer telefonoMadre) {
		this.telefonoMadre = telefonoMadre;
	}

	public Integer getTelefonoPadre() {
		return telefonoPadre;
	}

	public void setTelefonoPadre(Integer telefonoPadre) {
		this.telefonoPadre = telefonoPadre;
	}

	public Integer getDireccionMadre() {
		return direccionMadre;
	}

	public void setDireccionMadre(Integer direccionMadre) {
		this.direccionMadre = direccionMadre;
	}

	public Integer getDireccionPadre() {
		return direccionPadre;
	}

	public void setDireccionPadre(Integer direccionPadre) {
		this.direccionPadre = direccionPadre;
	}

	public Integer getCpMadre() {
		return cpMadre;
	}

	public void setCpMadre(Integer cpMadre) {
		this.cpMadre = cpMadre;
	}

	public Integer getCpPadre() {
		return cpPadre;
	}

	public void setCpPadre(Integer cpPadre) {
		this.cpPadre = cpPadre;
	}

	public String getMunicipioMadre() {
		return municipioMadre;
	}

	public void setMunicipioMadre(String municipioMadre) {
		this.municipioMadre = municipioMadre;
	}

	public String getMunicipioPadre() {
		return municipioPadre;
	}

	public void setMunicipioPadre(String municipioPadre) {
		this.municipioPadre = municipioPadre;
	}

	public String getProvinciaMadre() {
		return provinciaMadre;
	}

	public void setProvinciaMadre(String provinciaMadre) {
		this.provinciaMadre = provinciaMadre;
	}

	public String getProvinciaPadre() {
		return provinciaPadre;
	}

	public void setProvinciaPadre(String provinciaPadre) {
		this.provinciaPadre = provinciaPadre;
	}

	public String getSonSeparados() {
		return sonSeparados;
	}

	public void setSonSeparados(String sonSeparados) {
		this.sonSeparados = sonSeparados;
	}

	public String getEsCompartida() {
		return esCompartida;
	}

	public void setEsCompartida(String esCompartida) {
		this.esCompartida = esCompartida;
	}

	public String getEsMadre() {
		return esMadre;
	}

	public void setEsMadre(String esMadre) {
		this.esMadre = esMadre;
	}

	public String getEsPadre() {
		return esPadre;
	}

	public void setEsPadre(String esPadre) {
		this.esPadre = esPadre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
}
