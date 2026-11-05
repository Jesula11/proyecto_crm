package com.proyecto.crm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.proyecto.crm.entities.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepositoryImplementation<Profesor, Long> {
	boolean existsByDni(String dni);
    Optional<Profesor> findByDni(String dni);
    int countByDni(String dni);
    void deleteByDni(String dni);
}
