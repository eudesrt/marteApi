package com.br.marte.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.marte.api.repository.StatusRepository;
import com.br.marte.api.model.Status;


@RestController
@RequestMapping("/status")
public class StatusResource {
	
	@Autowired
	private StatusRepository statusRepository;
	
	@GetMapping
	private List<Status> findAll(){
		
		return statusRepository.findAll();		
	}

}
