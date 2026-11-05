package com.proyecto.crm.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "alumnos" , schema = "crm", uniqueConstraints = {
        @UniqueConstraint(name = "uk_alumno_dni", columnNames = "dni")
})

public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alumno", nullable = false)
	private Long idAlumno;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "apellidos", nullable = false, length = 100)
	private String apellidos;
	
	@Column(name = "dni", nullable = false, length = 9, unique = true)
	private String dni;
	
	@Column(name = "numero_ss", length = 12, unique = true)
	private Integer numeroSS;
	
	@Column(name = "email_personal", length = 100)
	private String emailPersonal;
	
	@Column(name = "telefono_personal", length = 9)
	private String telefonoPersonal;
	
	@Column(name = "fecha_alta", nullable = false, length = 30)
	private LocalDate fechaAlta;
	
	@Column(name = "fecha_baja", length = 30)
	private LocalDate fechaBaja;
	
	@Column(name = "email_centro", length = 100)
	private String emailCentro;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_familia",
				referencedColumnName = "id_familia")
	private Familia Familia;
	
	@OneToMany(mappedBy = "Alumno")
    private List<Relacion_Matricula> relacionMatricula;
    
    
    //Constructores
	public Alumno() {
		super();
	}

	public Alumno(Long idAlumno, String nombre, String apellidos, String dni, Integer numeroSS, String emailPersonal,
			String telefonoPersonal, LocalDate fechaAlta, LocalDate fechaBaja, String emailCentro,
			com.proyecto.crm.entities.Familia familia, List<Relacion_Matricula> relacionMatricula) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.numeroSS = numeroSS;
		this.emailPersonal = emailPersonal;
		this.telefonoPersonal = telefonoPersonal;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.emailCentro = emailCentro;
		Familia = familia;
		this.relacionMatricula = relacionMatricula;
	}

	//Getters y Setters
	public Long getIdAlumno() {
		return idAlumno;
	}


	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public Integer getNumeroSS() {
		return numeroSS;
	}


	public void setNumeroSS(Integer numeroSS) {
		this.numeroSS = numeroSS;
	}


	public String getEmailPersonal() {
		return emailPersonal;
	}


	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}


	public String getTelefonoPersonal() {
		return telefonoPersonal;
	}


	public void setTelefonoPersonal(String telefonoPersonal) {
		this.telefonoPersonal = telefonoPersonal;
	}


	public LocalDate getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public LocalDate getFechaBaja() {
		return fechaBaja;
	}


	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}


	public String getEmailCentro() {
		return emailCentro;
	}


	public void setEmailCentro(String emailCentro) {
		this.emailCentro = emailCentro;
	}


	public Familia getFamilia() {
		return Familia;
	}


	public void setFamilia(Familia familia) {
		Familia = familia;
	}


	public List<Relacion_Matricula> getRelacionMatricula() {
		return relacionMatricula;
	}


	public void setRelacionMatricula(List<Relacion_Matricula> relacionMatricula) {
		this.relacionMatricula = relacionMatricula;
	}

}
