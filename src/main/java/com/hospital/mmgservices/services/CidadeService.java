package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Cidade;
import com.hospital.mmgservices.domain.Estado;
import com.hospital.mmgservices.dto.CidadeDTO;
import com.hospital.mmgservices.repository.CidadeRepository;

@Service
public class CidadeService {


	@Autowired
	private CidadeRepository CidadeRepository;

	public List<Cidade> findAll() {
		return CidadeRepository.findAll();
	}

	public Cidade update(Cidade obj) {
		Cidade newobj = find(obj.getId());
		updateData(newobj, obj);
		return CidadeRepository.save(newobj);
	}

	public Cidade insert(Cidade obj) {
		obj.setId(null);
		return CidadeRepository.save(obj);
	}

	public CidadeDTO fromDTO(Cidade cidade) {
		return new CidadeDTO(cidade);
	}

	public Cidade find(Integer id) {
		Optional<Cidade> obj = CidadeRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName(), null));
	}

	public void delete(Integer id) {
		find(id);
		try {
			CidadeRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não possivel excluir um Cidade");
		}
	}

	private void updateData(Cidade newObj, Cidade obj) {
		newObj.setNome(obj.getNome());
	}

	public List<Cidade> findByEstado(Integer estadoId){
		return CidadeRepository.findCidades(estadoId);
	}

	public Cidade fromDTO(CidadeDTO objDto) {
		//Estado estado = new Estado(objDto.getEstadoId(),null,null);
		//return new Cidade(objDto.getId(), objDto.getNome(), estado);
		Cidade cidade = new Cidade(objDto.getId(), objDto.getNome(), null);
		if(objDto.getEstado() != null){
			cidade.setEstado(new Estado(objDto.getEstado().getId(), objDto.getEstado().getNome(), null));
		}
		return cidade;
	}
}
