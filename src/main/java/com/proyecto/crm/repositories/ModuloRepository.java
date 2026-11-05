package com.proyecto.crm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.proyecto.crm.entities.Modulo;

@Repository
public interface ModuloRepository extends JpaRepositoryImplementation<Modulo, Long> {
	boolean existsByModulo(String modulo);
    Optional<Modulo> findByModulo(String modulo);
    int countByModulo(String modulo);
    void deleteByModulo(String modulo);
}
