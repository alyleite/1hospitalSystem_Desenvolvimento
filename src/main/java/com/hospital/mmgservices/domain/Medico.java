package com.hospital.mmgservices.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome", length = 50, nullable = true)
	private String nome;

	@Column(name = "crm", length = 50, nullable = true)
	private String crm;

	@ManyToOne
	@JoinColumn(name = "expecialidade_id")
	private ExpecialidadeMedico expecialidademedico;

	public Medico() {

	}

	public Medico(Integer id, String nome, String crm, ExpecialidadeMedico expecialidademedico) {
		super();
		this.id = id;
		this.nome = nome;
		this.crm = crm;
		this.expecialidademedico = expecialidademedico;
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

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public ExpecialidadeMedico getExpecialidademedico() {
		return expecialidademedico;
	}

	public void setExpecialidademedico(ExpecialidadeMedico expecialidademedico) {
		this.expecialidademedico = expecialidademedico;
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
		Medico other = (Medico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
