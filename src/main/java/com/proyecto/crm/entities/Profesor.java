package com.proyecto.crm.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "profesores" , schema = "crm", uniqueConstraints = {
        @UniqueConstraint(name = "uk_profesores_dni", columnNames = "dni")
})

public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_profesor", nullable = false)
	private Long idProfesor;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "apellidos", nullable = false, length = 100)
	private String apellidos;
	
	@Column(name = "dni", nullable = false, length = 9, unique = true)
	private String dni;
	
	@Column(name = "email_personal", length = 100)
	private String emailPersonal;
	
	@Column(name = "email_centro", length = 100)
	private String emailCentro;
	
	@Column(name = "telefono_personal", length = 9)
	private String telefonoPersonal;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_departamento",
				referencedColumnName = "id_departamento")
	private Departamento Departamento;
	
	@OneToMany(mappedBy = "Profesor")
    private List<Relacion_profesor_modulo> RelacionProfesorModulo;
	
    //Constructores
	public Profesor() {
		super();
	}

	public Profesor(Long idProfesor, String nombre, String apellidos, String dni, String emailPersonal,
			String emailCentro, String telefonoPersonal, com.proyecto.crm.entities.Departamento departamento,
			List<Relacion_profesor_modulo> relacionProfesorModulo) {
		super();
		this.idProfesor = idProfesor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.emailPersonal = emailPersonal;
		this.emailCentro = emailCentro;
		this.telefonoPersonal = telefonoPersonal;
		Departamento = departamento;
		RelacionProfesorModulo = relacionProfesorModulo;
	}
	
	
	//Getters y Setters
	public Long getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
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

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public String getEmailCentro() {
		return emailCentro;
	}

	public void setEmailCentro(String emailCentro) {
		this.emailCentro = emailCentro;
	}

	public String getTelefonoPersonal() {
		return telefonoPersonal;
	}

	public void setTelefonoPersonal(String telefonoPersonal) {
		this.telefonoPersonal = telefonoPersonal;
	}

	public Departamento getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(Departamento departamento) {
		Departamento = departamento;
	}

	public List<Relacion_profesor_modulo> getRelacionProfesorModulo() {
		return RelacionProfesorModulo;
	}

	public void setRelacionProfesorModulo(List<Relacion_profesor_modulo> relacionProfesorModulo) {
		RelacionProfesorModulo = relacionProfesorModulo;
	}
	
}
