package com.proyecto.crm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "relacion_matricula" , schema = "crm")

public class Relacion_Matricula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_relacion_matricula", nullable = false)
	private Long idRelacionMatricula;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_alumno",
				referencedColumnName = "id_alumno")
	private Alumno Alumno;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_estado",
				referencedColumnName = "id_estado")
	private Estado Estado;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_modulo",
				referencedColumnName = "id_modulo")
	private Modulo Modulo;
	
	
	//Constructores
	public Relacion_Matricula() {
		super();
	}

	public Relacion_Matricula(Long idRelacionMatricula, com.proyecto.crm.entities.Alumno alumno, Estado eastado,
			com.proyecto.crm.entities.Modulo modulo) {
		super();
		this.idRelacionMatricula = idRelacionMatricula;
		Alumno = alumno;
		Estado = eastado;
		Modulo = modulo;
	}
	
	
	//Getters y Setters
	public Long getIdRelacionMatricula() {
		return idRelacionMatricula;
	}

	public void setIdRelacionMatricula(Long idRelacionMatricula) {
		this.idRelacionMatricula = idRelacionMatricula;
	}

	public Alumno getAlumno() {
		return Alumno;
	}

	public void setAlumno(Alumno alumno) {
		Alumno = alumno;
	}

	public Estado getEastado() {
		return Estado;
	}

	public void setEastado(Estado eastado) {
		Estado = eastado;
	}

	public Modulo getModulo() {
		return Modulo;
	}

	public void setModulo(Modulo modulo) {
		Modulo = modulo;
	}

}
