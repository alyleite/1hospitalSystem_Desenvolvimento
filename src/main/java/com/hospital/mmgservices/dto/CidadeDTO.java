package com.hospital.mmgservices.dto;

import com.hospital.mmgservices.domain.Cidade;

import java.io.Serializable;

public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private EstadoDTO estado;

	public CidadeDTO() {

	}

	public CidadeDTO(Cidade obj) {
		if(obj != null) {
			this.id = obj.getId();
			this.nome = obj.getNome();
			this.estado = new EstadoDTO(obj.getEstado());
		}
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

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "CidadeDTO [id=" + id + ", nome=" + nome + ", estado=" + estado + "]";
	}


}
