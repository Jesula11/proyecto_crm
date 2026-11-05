package com.proyecto.crm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.proyecto.crm.entities.Titulacion;

@Repository
public interface TitulacionRepository extends JpaRepositoryImplementation<Titulacion, Long> {
	boolean existsByDiminutivo(String diminutivo);
    Optional<Titulacion> findByDiminutivo(String diminutivo);
    int countByDiminutivo(String diminutivo);
    void deleteByDiminutivo(String diminutivo);
    
    boolean existsByCodigo(String codigo);
    Optional<Titulacion> findByCodigo(String codigo);
    int countByCodigo(String codigo);
    void deleteByCodigo(String codigo);
}
