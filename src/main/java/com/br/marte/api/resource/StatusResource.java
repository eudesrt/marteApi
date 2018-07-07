package com.br.marte.api.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.marte.api.model.Status;
import com.br.marte.api.repository.StatusRepository;


@RestController
@RequestMapping("/status")
public class StatusResource {
	
	@Autowired
	private StatusRepository ws;
	
	@GetMapping
	private List<Status> findAll(){
		
		return ws.findAll();		
	}
	
	@PostMapping
	public Status statusAdd(@Valid @RequestBody Status status) {
		
		System.out.println("Entrei em status add ");
		
		return ws.save(status);
	}
	

}
