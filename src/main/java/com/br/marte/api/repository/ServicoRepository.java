package com.br.marte.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.marte.api.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{
	
	//QUERY COM JPQL
	@Query("SELECT u FROM Servico u where u.os = :servico")
	public List<Servico> ordemServico(@Param("servico") Integer servico);
	


}
