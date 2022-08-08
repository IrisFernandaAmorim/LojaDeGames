package com.lojagame.lojagameverso.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lojagame.lojagameverso.model.CategoriaModel;
import com.lojagame.lojagameverso.repository.CategoriaRepository;



@RestController
@RequestMapping ("/Categoria")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity <List<CategoriaModel>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/nomecategoria/{nome}")
	public ResponseEntity <List<CategoriaModel>> getByNome (@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> post (@RequestBody CategoriaModel nomeCategoria){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(nomeCategoria));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> put (@RequestBody CategoriaModel nomeCategoria){
		return ResponseEntity.ok(repository.save(nomeCategoria));
	}
	
	@DeleteMapping ("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}

}
