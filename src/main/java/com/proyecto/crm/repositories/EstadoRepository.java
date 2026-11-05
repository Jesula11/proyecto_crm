package com.proyecto.crm.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.proyecto.crm.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepositoryImplementation<Estado, Long> {
	
}
