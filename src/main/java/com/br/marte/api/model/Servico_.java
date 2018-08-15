package com.br.marte.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Servico.class)
public abstract class Servico_ {

	public static volatile SingularAttribute<Servico, Long> codigo;
	public static volatile SingularAttribute<Servico, Integer> os;
	public static volatile SingularAttribute<Servico, String> titulo;
	public static volatile SingularAttribute<Servico, LocalDate> dtEntrada;
	public static volatile SingularAttribute<Servico, LocalDate> dtHomologacao;
	public static volatile SingularAttribute<Servico, Usuario> usuario;
	public static volatile SingularAttribute<Servico, LocalDate> dtCommit;
	public static volatile SingularAttribute<Servico, Descricao> descricao;
	public static volatile SingularAttribute<Servico, Status> status;

}

