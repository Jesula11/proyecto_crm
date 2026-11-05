package com.proyecto.crm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.proyecto.crm.entities.Modulo;

@Repository
public interface ModuloRepository extends JpaRepositoryImplementation<Modulo, Long> {
	boolean existsByCodigo(String codigo);
    Optional<Modulo> findByCodigo(String codigo);
    int countByCodigo(String codigo);
    void deleteByCodigo(String codigo);
}
