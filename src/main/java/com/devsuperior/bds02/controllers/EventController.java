package com.devsuperior.bds02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.services.EventService;

// The Resources implements the REST Controller
@RestController   																// Configure this class goes to be a Rest Controller
@RequestMapping(value = "/events")   											// Always on plural, route Rest resource
public class EventController {

	@Autowired
	private EventService service;

//	@GetMapping    																// Configure this method goes to be a EndPoint (WebService) 
//	public ResponseEntity<List<EventDTO>> findAll() {							// ResponseEntity is a Generic, that encapsulate a answer HTTP
//		List<EventDTO> list = service.findAll();
//		return ResponseEntity.ok().body(list);
//	}
//	
//	@PostMapping
//	public ResponseEntity<EventDTO> insert(@RequestBody EventDTO dto) {
//		dto = service.insert(dto);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(dto.getId()).toUri();
//		return ResponseEntity.created(uri).body(dto);
//	}
//
	//Um método HTTP é idempotente se uma requisição idêntica pode ser feita uma ou mais vezes em sequência com o mesmo efeito enquanto deixa o servidor no mesmo estado.
	@PutMapping(value = "/{id}") 												// idempotent method, Configure this method goes to be a EndPoint (WebService)
	public ResponseEntity<EventDTO> update(@PathVariable Long id, @RequestBody EventDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
}
