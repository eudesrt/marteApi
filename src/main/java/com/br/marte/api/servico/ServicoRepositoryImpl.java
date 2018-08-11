package com.br.marte.api.servico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.br.marte.api.filter.ServicoFilter;
import com.br.marte.api.model.Servico;
import com.br.marte.api.model.Servico_;

public class ServicoRepositoryImpl implements ServicoRespositoryQuery{
	
	@Autowired
	private EntityManager manager;

	@Override
	public Page<Servico> filtrar(ServicoFilter servicoFilter,Pageable pageable) {
		CriteriaBuilder buider = manager.getCriteriaBuilder();
		CriteriaQuery<Servico> criteria = buider.createQuery(Servico.class);

		Root<Servico> root = criteria.from(Servico.class);

		// Criar restrições
		Predicate[] predicates = criarRestricoes(servicoFilter, buider, root);
		criteria.where(predicates);

		TypedQuery<Servico> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(servicoFilter));
	}

	private Long total(ServicoFilter servicoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		
		Root<Servico> root = criteria.from(Servico.class);
		
		Predicate[] predicates = criarRestricoes(servicoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Servico> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistroPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistroPagina);
	}

	private Predicate[] criarRestricoes(ServicoFilter servicoFilter, CriteriaBuilder buider,
			Root<Servico> root) {

		List<Predicate> predicates = new ArrayList<>();
		
//		if (!StringUtils.isEmpty(servicoFilter.getOs())) {
//
//			predicates.add(buider.lessThan((root.get(Servico_.os)),servicoFilter.getOs()));
//		}


		if (!StringUtils.isEmpty(servicoFilter.getTitulo())) {

			predicates.add(buider.like(buider.lower(root.get(Servico_.titulo)),
					"%" + servicoFilter.getTitulo().toLowerCase() + "%"));
		}

		if (servicoFilter.getDtCommit() != null) {
			predicates.add(buider.greaterThanOrEqualTo(root.get(Servico_.dtCommit),servicoFilter.getDtCommit()));
		}

		if (servicoFilter.getDtEntrada() != null) {
			predicates.add(buider.lessThanOrEqualTo(root.get(Servico_.dtEntrada),servicoFilter.getDtEntrada()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
