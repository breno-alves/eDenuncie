package com.edenuncie.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edenuncie.api.domain.Endereco;
import com.edenuncie.api.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;
	
	public Endereco buscar(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Endereco inserir(Endereco obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
