package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Drogaria;
import com.example.demo.services.DrogariaService;

@RestController
@RequestMapping("/Drogaria")
public class DrogariaController {

	private final DrogariaService drogariaService;

	@Autowired
	public DrogariaController(DrogariaService drogariaService) {
		this.drogariaService = drogariaService;
	}

	@PostMapping("/criar")
	public Drogaria criarDrogaria(@RequestBody Drogaria drogaria) {
		return drogariaService.salvarDrogaria(drogaria);
	}

	@GetMapping
	public List<Drogaria> buscarTodos() {
		return drogariaService.buscarTodasDrogarias();
	}

	@GetMapping("/{id}")
	public Drogaria buscarPorId(@PathVariable Long id) {
		return drogariaService.buscarDrogariaPorId(id);
	}

	@DeleteMapping("/{id}")
	public void deletarDrogaria(@PathVariable Long id) {
		drogariaService.excluirDrogaria(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Drogaria> atualizarDrogaria(@PathVariable Long id, @RequestBody Drogaria drogaria) {
		Drogaria drogariaAtualizada = drogariaService.atualizarDrogaria(id, drogaria);
		if (drogariaAtualizada != null) {
			return ResponseEntity.ok(drogariaAtualizada);
		} else {
			return null;
		}
	}

}
