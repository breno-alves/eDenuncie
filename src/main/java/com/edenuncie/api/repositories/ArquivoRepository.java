package com.edenuncie.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edenuncie.api.domain.Arquivo;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Integer> {

}