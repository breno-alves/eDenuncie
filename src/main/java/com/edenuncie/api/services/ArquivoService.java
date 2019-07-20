package com.edenuncie.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edenuncie.api.domain.Arquivo;
import com.edenuncie.api.repositories.ArquivoRepository;

@Service
public class ArquivoService {

	@Autowired
	private ArquivoRepository repo;
	
	public Arquivo buscar(Integer id) {
		Optional<Arquivo> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Arquivo inserir(Arquivo obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
