package com.proyecto.crm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.proyecto.crm.entities.Curso;


@Repository
public interface CursoRepository extends JpaRepositoryImplementation<Curso, Long> {
	boolean existsByDiminutivo(String diminutivo);
    Optional<Curso> findByDiminutivo(String diminutivo);
    int countByDiminutivo(String diminutivo);
    void deleteByDiminutivo(String diminutivo);
}
