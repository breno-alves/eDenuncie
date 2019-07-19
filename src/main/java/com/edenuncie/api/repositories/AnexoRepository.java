package com.edenuncie.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edenuncie.api.domain.Anexo;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo, Integer>{

}