package com.proyecto.crm.entities;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "departamentos" , schema = "crm", uniqueConstraints = {
        @UniqueConstraint(name = "uk_departamento_codigo", columnNames = "codigo")
})

public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_departamento", nullable = false)
	private Long idDepartamento;
	
	@Column(name = "codigo", nullable = false, length = 100, unique = true)
	private String codigo;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "descripcion",length = 250)
	private String descripcion;
	
	@Column(name = "telefono", nullable = false, length = 9)
	private String telefono;
	
	@OneToMany(mappedBy = "Departamento")
    private List<Profesor> profesores;
	
	
	//Constructores
	public Departamento() {
		super();
	}


	public Departamento(Long idDepartamento, String codigo, String nombre, String descripcion, String telefono,
			List<Profesor> profesores) {
		super();
		this.idDepartamento = idDepartamento;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.telefono = telefono;
		this.profesores = profesores;
	}

	
	//Getters y Setters
	public Long getIdDepartamento() {
		return idDepartamento;
	}


	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
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


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public List<Profesor> getProfesores() {
		return profesores;
	}


	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
	
}
