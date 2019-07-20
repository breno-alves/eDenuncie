package com.edenuncie.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edenuncie.api.domain.Denuncia;
import com.edenuncie.api.domain.Usuario;
import com.edenuncie.api.repositories.DenunciaRepository;
import com.edenuncie.api.repositories.EnderecoRepository;
import com.edenuncie.api.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo_usuario;
	
	@Autowired
	private DenunciaRepository repo_denuncia;
	
	@Autowired
	private EnderecoRepository repo_endereco;
	
	public Usuario buscar(Integer id) {
		Optional<Usuario> obj = repo_usuario.findById(id);
		return obj.orElse(null);
	}
	
	public Usuario inserir(Usuario obj) {
		obj.setId(null);
		
		if(obj.getDenuncias() != null) {
			for(Denuncia d : obj.getDenuncias()) {
				d.setId(null);
				repo_denuncia.save(d);
			}
		}
		
		if(obj.getEndereco() != null) {
			obj.getEndereco().setId(null);
			repo_endereco.save(obj.getEndereco());
		}
	
		return repo_usuario.save(obj);
	}
}