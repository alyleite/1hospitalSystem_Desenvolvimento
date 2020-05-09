package com.hospital.mmgservices.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CategoriaExame implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome", length = 50, nullable = true)
	private String nome;
	
	@OneToMany(mappedBy = "categoriaexame")
	private List<NomeExame> nomeexame;
	
	public CategoriaExame() {
		
	}

	public CategoriaExame(Integer id, String nome, List<NomeExame> nomeexame) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeexame = nomeexame;
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

	public List<NomeExame> getNomeexame() {
		return nomeexame;
	}

	public void setNomeexame(List<NomeExame> nomeexame) {
		this.nomeexame = nomeexame;
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
		CategoriaExame other = (CategoriaExame) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}