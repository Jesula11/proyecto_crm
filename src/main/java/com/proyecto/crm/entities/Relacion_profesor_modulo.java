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
@Table(name = "relacion_profesor_modulo" , schema = "crm")

public class Relacion_profesor_modulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_relacion_profesor_modulo", nullable = false)
	private Long idRelacionProfesorModulo;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_modulo",
				referencedColumnName = "id_modulo")
	private Modulo Modulo;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_profesor",
				referencedColumnName = "id_profesor")
	private Profesor Profesor;

	//Constructores
	public Relacion_profesor_modulo() {
		super();
	}

	public Relacion_profesor_modulo(Long idRelacionProfesorModulo, com.proyecto.crm.entities.Modulo modulo,
			com.proyecto.crm.entities.Profesor profesor) {
		super();
		this.idRelacionProfesorModulo = idRelacionProfesorModulo;
		Modulo = modulo;
		Profesor = profesor;
	}
	
	
	//Getters y Setters
	public Long getIdRelacionProfesorModulo() {
		return idRelacionProfesorModulo;
	}

	public void setIdRelacionProfesorModulo(Long idRelacionProfesorModulo) {
		this.idRelacionProfesorModulo = idRelacionProfesorModulo;
	}

	public Modulo getModulo() {
		return Modulo;
	}

	public void setModulo(Modulo modulo) {
		Modulo = modulo;
	}

	public Profesor getProfesor() {
		return Profesor;
	}

	public void setProfesor(Profesor profesor) {
		Profesor = profesor;
	}

	
}
