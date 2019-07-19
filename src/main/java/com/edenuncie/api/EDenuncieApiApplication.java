package com.edenuncie.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edenuncie.api.domain.Anexo;
import com.edenuncie.api.domain.Arquivo;
import com.edenuncie.api.domain.Denuncia;
import com.edenuncie.api.domain.Endereco;
import com.edenuncie.api.domain.Usuario;
import com.edenuncie.api.repositories.AnexoRepository;
import com.edenuncie.api.repositories.ArquivoRepository;
import com.edenuncie.api.repositories.DenunciaRepository;
import com.edenuncie.api.repositories.EnderecoRepository;
import com.edenuncie.api.repositories.UsuarioRepository;

@SpringBootApplication
public class EDenuncieApiApplication implements CommandLineRunner{
	
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

	@Override
	public void run(String... args) throws Exception {
		
		
		
		//Criando denuncia anonima
		
		Endereco endereco_01 = new Endereco(null, "", "5050", "bloco b", "Alecrim", "Natal", "RN", "59070211");
		repo_endereco.saveAll(Arrays.asList(endereco_01));
		
		Denuncia denuncia_01 = new Denuncia(null, "Crime virtual", "10/11/2010", null, endereco_01);
		
		
		//criando denuncia anonima com arquivos
		
		//usuario
		Usuario usuario_01 = new Usuario(null, "Breno Alves", "08684439481", "996191511", "Breno550@hotmail.com", "10/11/1995", endereco_01, null);
		repo_usuario.saveAll(Arrays.asList(usuario_01));
		
		Denuncia denuncia_02 = new Denuncia(null, "Crime virtual", "10/11/2010", null, endereco_01, usuario_01);
		
		repo_denuncia.saveAll(Arrays.asList(denuncia_01, denuncia_02));
		
		
		
		Anexo anexo_01 = new Anexo(null, "GIF");
		Arquivo arquivo_01 = new Arquivo(null, "messivomitando.gif", "/home/imagens/messivomitando.gif", denuncia_02, anexo_01);
		
		denuncia_02.setArquivos(Arrays.asList(arquivo_01));
		
		repo_anexo.saveAll(Arrays.asList(anexo_01));
		repo_arquivo.saveAll(Arrays.asList(arquivo_01));
				
		
		
		
	}

}
