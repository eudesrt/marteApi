package com.br.marte.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.marte.api.execption.ServicoInexistenteOuInativaException;
import com.br.marte.api.model.Servico;
import com.br.marte.api.repository.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	public Servico salvar(Servico servico) {

 		List<Servico> ordemServico = servicoRepository.ordemServico(servico.getOs());
		
		
		if(!ordemServico.isEmpty()) {
			throw new ServicoInexistenteOuInativaException();
		}			
		
		return servicoRepository.save(servico);
	}

}
