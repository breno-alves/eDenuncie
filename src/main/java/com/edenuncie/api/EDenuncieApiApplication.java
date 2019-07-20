package com.edenuncie.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edenuncie.api.repositories.AnexoRepository;
import com.edenuncie.api.repositories.ArquivoRepository;
import com.edenuncie.api.repositories.DenunciaRepository;
import com.edenuncie.api.repositories.EnderecoRepository;
import com.edenuncie.api.repositories.UsuarioRepository;

@SpringBootApplication
public class EDenuncieApiApplication{
	
	@Autowired
	private EnderecoRepository repo_endereco;
	
	@Autowired
	private DenunciaRepository repo_denuncia;
	
	@Autowired
	private ArquivoRepository repo_arquivo;
	
	@Autowired
	private AnexoRepository repo_anexo;
	
	@Autowired
	private UsuarioRepository repo_usuario;
	
	public static void main(String[] args) {
		SpringApplication.run(EDenuncieApiApplication.class, args);
	}

}
