package com.proyecto.crm.entities;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "estados" , schema = "crm")

public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado", nullable = false)
	private Long idEstado;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "descripcion", length = 250)
	private String descripcion;
	
	@OneToMany(mappedBy = "Estado")
    private List<Relacion_Matricula> relacionMatricula;
    
    
    //Constructores
	public Estado() {
		super();
	}

	public Estado(Long idEstado, String nombre, String descripcion, List<Relacion_Matricula> relacionMatricula) {
		super();
		this.idEstado = idEstado;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.relacionMatricula = relacionMatricula;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Relacion_Matricula> getRelacionMatricula() {
		return relacionMatricula;
	}

	public void setRelacionMatricula(List<Relacion_Matricula> relacionMatricula) {
		this.relacionMatricula = relacionMatricula;
	}
	
	
	
}
