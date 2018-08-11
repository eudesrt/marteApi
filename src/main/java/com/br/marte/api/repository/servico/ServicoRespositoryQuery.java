package com.br.marte.api.repository.servico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.br.marte.api.model.Servico;
import com.br.marte.api.repository.filter.ServicoFilter;

public interface ServicoRespositoryQuery {
	
	public Page<Servico> filtrar(ServicoFilter servicoFilter, Pageable pageable);


}
