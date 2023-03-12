package dev.taejjeon.calender.controller;

import dev.taejjeon.calender.model.Content;
import dev.taejjeon.calender.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/content")
public class ContentController {

	private final ContentCollectionRepository repository;

	public ContentController(ContentCollectionRepository contentCollectionRepository) {
		this.repository = contentCollectionRepository;
	}

	@GetMapping("")
	public List<Content> findAll(){
		return this.repository.findAll();

	}
	@GetMapping("/{id}")
	public Content getById(@PathVariable Integer id){
		return this.repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"not found data"));
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public void create(@RequestBody @Valid Content content){
		this.repository.save(content);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	public void update(@RequestBody @Valid Content content,@PathVariable Integer id){
		if(!repository.existById(id)){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found data");
		}
		this.repository.save(content);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id){
		if(!repository.existById(id)){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found data");
		}
		this.repository.delete(id);
	}

}
