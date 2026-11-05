package com.proyecto.crm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.proyecto.crm.entities.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepositoryImplementation<Departamento, Long> {
	boolean existsByCodigo(String codigo);
    Optional<Departamento> findByCodigo(String codigo);
    int countByCodigo(String codigo);
    void deleteByCodigo(String codigo);
}
