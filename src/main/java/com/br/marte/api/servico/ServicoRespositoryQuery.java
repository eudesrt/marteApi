package com.br.marte.api.servico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.br.marte.api.filter.ServicoFilter;
import com.br.marte.api.model.Servico;

public interface ServicoRespositoryQuery {
	
	public Page<Servico> filtrar(ServicoFilter servicoFilter, Pageable pageable);


}
