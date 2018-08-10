package com.br.marte.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.marte.api.model.Servico;
import com.br.marte.api.repository.ServicoRepository;

@RestController
@RequestMapping("/servico")
public class ServicoResource {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@CrossOrigin(maxAge =10 ,origins= {"http://localhost:4200"})
	@GetMapping
	public List<Servico> findAll(){
		return servicoRepository.findAll();
	}
	
}