package com.edenuncie.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edenuncie.api.domain.Anexo;
import com.edenuncie.api.repositories.AnexoRepository;

@Service
public class AnexoService {

	@Autowired
	private AnexoRepository repo;
	
	public Anexo buscar(Integer id) {
		Optional<Anexo> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Anexo inserir(Anexo obj) {
		obj.setId_tipo(null);
		return repo.save(obj);
	}
}
