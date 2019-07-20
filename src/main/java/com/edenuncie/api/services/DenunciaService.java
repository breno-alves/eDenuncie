package com.edenuncie.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edenuncie.api.domain.Denuncia;
import com.edenuncie.api.repositories.DenunciaRepository;

@Service
public class DenunciaService {
	
	@Autowired
	private DenunciaRepository repo;
	
	public Denuncia buscar(Integer id) {
		Optional<Denuncia> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Denuncia inserir(Denuncia obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}