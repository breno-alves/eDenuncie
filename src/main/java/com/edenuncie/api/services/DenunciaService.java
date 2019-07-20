package com.edenuncie.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edenuncie.api.domain.Arquivo;
import com.edenuncie.api.domain.Denuncia;
import com.edenuncie.api.repositories.DenunciaRepository;

@Service
public class DenunciaService {
	
	@Autowired
	private DenunciaRepository repo;
	
	private ArquivoService arq_service;
	private UsuarioService user_service;
	private EnderecoService end_service;
	
	public Denuncia buscar(Integer id) {
		Optional<Denuncia> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Denuncia inserir(Denuncia obj) {
		obj.setId(null);
		
		
		if(obj.getArquivos() != null) {
			for(Arquivo arq : obj.getArquivos()) {
				arq_service.inserir(arq);
			}
		}
		
		if(obj.getEndereco() != null) {
			end_service.inserir(obj.getEndereco());
		}
		
		if(obj.getUsuario_id() != null) {
			obj.getUsuario_id().setId(null);
			user_service.inserir(obj.getUsuario_id());
		}
		
		return repo.save(obj);
	}
}