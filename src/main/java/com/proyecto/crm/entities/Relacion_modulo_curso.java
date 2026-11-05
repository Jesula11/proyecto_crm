package com.proyecto.crm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "relacion_modulo_curso" , schema = "crm")

public class Relacion_modulo_curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_relacion_modulo_curso", nullable = false)
	private Long idRelacionModuloCurso;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_modulo",
				referencedColumnName = "id_modulo")
	private Modulo Modulo;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_curso",
				referencedColumnName = "id_curso")
	private Curso Curso;
	
	//Constructores
	public Relacion_modulo_curso() {
		super();
	}

	public Relacion_modulo_curso(Long idRelacionModuloCurso, com.proyecto.crm.entities.Modulo modulo,
			com.proyecto.crm.entities.Curso curso) {
		super();
		this.idRelacionModuloCurso = idRelacionModuloCurso;
		Modulo = modulo;
		Curso = curso;
	}
	
	
	//Getters y Setters
	public Long getIdRelacionModuloCurso() {
		return idRelacionModuloCurso;
	}

	public void setIdRelacionModuloCurso(Long idRelacionModuloCurso) {
		this.idRelacionModuloCurso = idRelacionModuloCurso;
	}

	public Modulo getModulo() {
		return Modulo;
	}

	public void setModulo(Modulo modulo) {
		Modulo = modulo;
	}

	public Curso getCurso() {
		return Curso;
	}

	public void setCurso(Curso curso) {
		Curso = curso;
	}


}
