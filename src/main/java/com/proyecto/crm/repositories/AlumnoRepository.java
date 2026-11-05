package com.proyecto.crm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.proyecto.crm.entities.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepositoryImplementation<Alumno, Long> {
	
	boolean existsByDni(String dni);
    Optional<Alumno> findByDni(String dni);
    int countByDni(String dni);
    void deleteByDni(String dni);
    
    boolean existsByNumeroSS(String numeroSS);
    Optional<Alumno> findByNumeroSS(String numeroSS);
    int countByNumeroSS(String numeroSS);
    void deleteByNumeroSS(String numeroSS);
}
