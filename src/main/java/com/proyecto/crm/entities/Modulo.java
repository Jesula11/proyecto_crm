package com.proyecto.crm.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "modulos" , schema = "crm", uniqueConstraints = {
        @UniqueConstraint(name = "uk_modulo_codigo", columnNames = "codigo")
})

public class Modulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_modulo", nullable = false)
	private Long idModulo;
	
	@Column(name = "codigo", nullable = false, length = 100, unique = true)
	private String codigo;
	
	@Column(name = "diminutivo", nullable = false, length = 20, unique = true)
	private String diminutivo;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "descripcion", length = 250)
	private String descripcion;
	
	@Column(name = "horas_semanales")
	private Integer horasSemanales;
	
	@Column(name = "creditos")
	private Integer creditos;
	
	@OneToMany(mappedBy = "Modulo")
    private List<Relacion_profesor_modulo> RelacionProfesorModulo;
    
    @OneToMany(mappedBy = "Modulo")
    private List<Relacion_Matricula> relacionMatricula;
    
    @OneToMany(mappedBy = "Modulo")
    private List<Relacion_modulo_curso> relacionModuloCurso;
    
    
    //Constructores
	public Modulo() {
		super();
	}


	public Modulo(Long idModulo, String codigo, String diminutivo, String nombre, String descripcion,
			Integer horasSemanales, Integer creditos, List<Relacion_profesor_modulo> relacionProfesorModulo,
			List<Relacion_Matricula> relacionMatricula, List<Relacion_modulo_curso> relacionModuloCurso) {
		super();
		this.idModulo = idModulo;
		this.codigo = codigo;
		this.diminutivo = diminutivo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horasSemanales = horasSemanales;
		this.creditos = creditos;
		RelacionProfesorModulo = relacionProfesorModulo;
		this.relacionMatricula = relacionMatricula;
		this.relacionModuloCurso = relacionModuloCurso;
	}

	//Getters y Setters
	public Long getIdModulo() {
		return idModulo;
	}


	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
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


	public Integer getHorasSemanales() {
		return horasSemanales;
	}


	public void setHorasSemanales(Integer horasSemanales) {
		this.horasSemanales = horasSemanales;
	}


	public Integer getCreditos() {
		return creditos;
	}


	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}


	public List<Relacion_profesor_modulo> getRelacionProfesorModulo() {
		return RelacionProfesorModulo;
	}


	public void setRelacionProfesorModulo(List<Relacion_profesor_modulo> relacionProfesorModulo) {
		RelacionProfesorModulo = relacionProfesorModulo;
	}


	public List<Relacion_Matricula> getRelacionMatricula() {
		return relacionMatricula;
	}


	public void setRelacionMatricula(List<Relacion_Matricula> relacionMatricula) {
		this.relacionMatricula = relacionMatricula;
	}


	public List<Relacion_modulo_curso> getRelacionModuloCurso() {
		return relacionModuloCurso;
	}


	public void setRelacionModuloCurso(List<Relacion_modulo_curso> relacionModuloCurso) {
		this.relacionModuloCurso = relacionModuloCurso;
	}

}
