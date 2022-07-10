package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
	
	Page<Consulta> findAll(Pageable pageable);
}
