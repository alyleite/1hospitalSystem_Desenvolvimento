package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mmgservices.domain.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{

}
