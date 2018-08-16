package com.br.marte.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Descricao.class)
public abstract class Descricao_ {

	public static volatile SingularAttribute<Descricao, Long> codigo;
	public static volatile SingularAttribute<Descricao, Integer> os_id;
	public static volatile SingularAttribute<Descricao, LocalDate> dtEntrada;
	public static volatile SingularAttribute<Descricao, String> descricao;

}

