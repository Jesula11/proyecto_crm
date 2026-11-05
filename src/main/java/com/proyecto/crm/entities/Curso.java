package com.proyecto.crm.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos" , schema = "crm", uniqueConstraints = {
        @UniqueConstraint(name = "uk_estado_diminutivo", columnNames = "diminutivo")
})

public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso", nullable = false)
	private Long idCruso;
	
	@Column(name = "diminutivo", nullable = false, length = 20, unique = true)
	private String diminutivo;
	
	@Column(name = "descripcion", length = 250)
	private String descripcion;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_titulacion",
				referencedColumnName = "id_titulacion")
	private Titulacion Titulacion;
	
	@OneToMany(mappedBy = "Curso")
    private List<Relacion_modulo_curso> relacionModuloCurso;
    
    
    //Constructores
	public Curso() {
		super();
	}


	public Curso(Long idCruso, String diminutivo, String descripcion, com.proyecto.crm.entities.Titulacion titulacion,
			List<Relacion_modulo_curso> relacionModuloCurso) {
		super();
		this.idCruso = idCruso;
		this.diminutivo = diminutivo;
		this.descripcion = descripcion;
		Titulacion = titulacion;
		this.relacionModuloCurso = relacionModuloCurso;
	}

	//Getters y Setters
	public Long getIdCruso() {
		return idCruso;
	}


	public void setIdCruso(Long idCruso) {
		this.idCruso = idCruso;
	}


	public String getDiminutivo() {
		return diminutivo;
	}


	public void setDiminutivo(String diminutivo) {
		this.diminutivo = diminutivo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Titulacion getTitulacion() {
		return Titulacion;
	}


	public void setTitulacion(Titulacion titulacion) {
		Titulacion = titulacion;
	}


	public List<Relacion_modulo_curso> getRelacionModuloCurso() {
		return relacionModuloCurso;
	}


	public void setRelacionModuloCurso(List<Relacion_modulo_curso> relacionModuloCurso) {
		this.relacionModuloCurso = relacionModuloCurso;
	}
	
	
}
