package com.proyecto.crm.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "titulaciones" , schema = "crm", uniqueConstraints = {
        @UniqueConstraint(name = "uk_titulaciones_codigo", columnNames = "codigo")
})

public class Titulacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_titulacion", nullable = false)
	private Long idTitulacion;
	
	@Column(name = "codigo", nullable = false, length = 20, unique = true)
	private String codigo;
	
	@Column(name = "diminutivo", nullable = false, length = 10, unique = true)
	private String diminutivo;
	
	@Column(name = "horas_totales")
	private Integer horasTotales;
	
	@OneToMany(mappedBy = "Titulacion")
    private List<Curso> cursos;
	
	
	//Constructores
	public Titulacion() {
		super();
	}

	public Titulacion(Long idTitulacion, String codigo, String diminutivo, Integer horasTotales, List<Curso> cursos) {
		super();
		this.idTitulacion = idTitulacion;
		this.codigo = codigo;
		this.diminutivo = diminutivo;
		this.horasTotales = horasTotales;
		this.cursos = cursos;
	}
	
	
	//Getters y Setters
	public Long getIdTitulacion() {
		return idTitulacion;
	}

	public void setIdTitulacion(Long idTitulacion) {
		this.idTitulacion = idTitulacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDiminutivo() {
		return diminutivo;
	}

	public void setDiminutivo(String diminutivo) {
		this.diminutivo = diminutivo;
	}

	public Integer getHorasTotales() {
		return horasTotales;
	}

	public void setHorasTotales(Integer horasTotales) {
		this.horasTotales = horasTotales;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}
