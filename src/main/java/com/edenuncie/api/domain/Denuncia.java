package com.edenuncie.api.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Denuncia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private String data;
	
	@OneToOne
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonIgnore
	private Usuario usuario_id;
	
	@OneToMany(mappedBy = "denuncia_id")
	private List<Arquivo> arquivos;
	
	public Denuncia() {
		super();
	}

	public Denuncia(Integer id, String descricao, String data, Endereco endereco, List<Arquivo> arquivos, Usuario usuario_id) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.endereco = endereco;
		this.usuario_id = usuario_id;
		this.arquivos = arquivos;
	}

	public Denuncia(Integer id, String descricao, String data, Endereco endereco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.endereco = endereco;
	}
	
	public Denuncia(Integer id, String descricao, String data, List<Arquivo> arquivos, Endereco endereco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.endereco = endereco;
		this.arquivos = arquivos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario) {
		this.usuario_id = usuario;
	}

	public List<Arquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
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
		Denuncia other = (Denuncia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}