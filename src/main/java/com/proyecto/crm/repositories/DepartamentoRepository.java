package com.proyecto.crm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.proyecto.crm.entities.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepositoryImplementation<Departamento, Long> {
	boolean existsByDepartamento(String departamento);
    Optional<Departamento> findByDepartamento(String departamento);
    int countByDepartamento(String departamento);
    void deleteByDepartamento(String departamento);
}
