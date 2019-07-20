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
	
	private DenunciaService denu_service;
	private AnexoService anexo_service;
	
	public Arquivo buscar(Integer id) {
		Optional<Arquivo> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Arquivo inserir(Arquivo obj) {
		obj.setId(null);
		
		if(obj.getDenuncia_id() != null) {
			obj.getDenuncia_id().setId(null);
			denu_service.inserir(obj.getDenuncia_id());
		}
		
		if(obj.getAnexos_id() != null) {
			anexo_service.inserir(obj.getAnexos_id());
		}
		
		return repo.save(obj);
	}
}
