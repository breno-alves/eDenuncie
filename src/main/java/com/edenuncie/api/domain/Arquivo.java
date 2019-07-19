package com.edenuncie.api.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Arquivo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "denuncia_id")
	@JsonIgnore
	private Denuncia denuncia_id;
	
	@OneToOne
	private Anexo anexo_id;
	
	public Arquivo() {
		super();
	}

	public Arquivo(Integer id, String nome, String url, Denuncia denuncia_id, Anexo anexo_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.url = url;
		this.denuncia_id = denuncia_id;
		this.anexo_id = anexo_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Denuncia getDenuncia_id() {
		return denuncia_id;
	}

	public void setDenuncia_id(Denuncia denuncia_id) {
		this.denuncia_id = denuncia_id;
	}

	public Anexo getAnexos_id() {
		return anexo_id;
	}

	public void setAnexos_id(Anexo anexo_id) {
		this.anexo_id = anexo_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arquivo other = (Arquivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}