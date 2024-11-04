package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Fornecedor;
import com.example.demo.repositories.FornecedorRepository;

@Service
public class FornecedorService {
	private final FornecedorRepository fornecedorRepository;

	@Autowired
	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}

	public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}

	public Fornecedor buscarFornecedorPorId(Long id) {
		return fornecedorRepository.findById(id).orElse(null);
	}

	public List<Fornecedor> buscarTodosFornecedores() {
		return fornecedorRepository.findAll();
	}

	public void excluirFornecedor(Long id) {
		fornecedorRepository.deleteById(id);
	}

	public Fornecedor atualizarFornecedor(Long id, Fornecedor fornecedorAtualizado) {
		Optional<Fornecedor> fornecedorExistente = fornecedorRepository.findById(id);
		if (fornecedorExistente.isPresent()) {
			Fornecedor fornecedor = fornecedorExistente.get();
			fornecedor.setCnpj(fornecedorAtualizado.getCnpj());
			fornecedor.setEmail(fornecedorAtualizado.getEmail());
			fornecedor.setEndereco(fornecedorAtualizado.getEndereco());
			fornecedor.setFone(fornecedorAtualizado.getFone());
			fornecedor.setInscricaoEstadual(fornecedorAtualizado.getInscricaoEstadual());
			fornecedor.setNomeFantasia(fornecedorAtualizado.getNomeFantasia());
			fornecedor.setRazaoSocial(fornecedorAtualizado.getRazaoSocial());
			return fornecedorRepository.save(fornecedor);
		} else {
			return null;
		}
	}
}
