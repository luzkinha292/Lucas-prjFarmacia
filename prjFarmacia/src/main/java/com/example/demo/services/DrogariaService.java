package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Drogaria;
import com.example.demo.repositories.DrogariaRepository;

@Service
public class DrogariaService {
	private final DrogariaRepository drogariaRepository;

	@Autowired
	public DrogariaService(DrogariaRepository drogariaRepository) {
		this.drogariaRepository = drogariaRepository;
	}

	public Drogaria salvarDrogaria(Drogaria drogaria) {
		return drogariaRepository.save(drogaria);
	}

	public Drogaria buscarDrogariaPorId(Long id) {
		return drogariaRepository.findById(id).orElse(null);
	}

	public List<Drogaria> buscarTodasDrogarias() {
		return drogariaRepository.findAll();
	}

	public void excluirDrogaria(Long id) {
		drogariaRepository.deleteById(id);
	}

	public Drogaria atualizarDrogaria(Long id, Drogaria drogariaAtualizada) {
		Optional<Drogaria> drogariaExistente = drogariaRepository.findById(id);
		if (drogariaExistente.isPresent()) {
			Drogaria drogaria = drogariaExistente.get();
			drogaria.setNome(drogariaAtualizada.getNome());
			drogaria.setCnpj(drogariaAtualizada.getCnpj());
			return drogariaRepository.save(drogaria);
		} else {
			return null;
		}
	}
}
