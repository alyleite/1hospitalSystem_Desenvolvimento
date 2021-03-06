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
public class CategoriaMedicamento implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "descricao", length = 50, nullable = true)
	private String descricao;
	
	@OneToMany(mappedBy = "categoriamedicamento")
	private List<Medicamento> medicamento;
	
	public CategoriaMedicamento() {
		
	}

	public CategoriaMedicamento(Integer id, String descricao, List<Medicamento> medicamento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.medicamento = medicamento;
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

	public List<Medicamento> getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(List<Medicamento> medicamento) {
		this.medicamento = medicamento;
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
		CategoriaMedicamento other = (CategoriaMedicamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}

