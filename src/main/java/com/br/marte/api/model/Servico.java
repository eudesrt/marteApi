package com.br.marte.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ws_servico")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private Integer os;
	private String titulo;

	@Column(name = "dt_entrada")
	private LocalDate dtEntrada;

	@Column(name = "dt_homologacao")
	private LocalDate dtHomologacao;

	@Column(name = "dt_commit")
	private LocalDate dtCommit;

	@ManyToOne
	@JoinColumn(name = "descricao_id")
	private Descricao descricao;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Status status;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getOs() {
		return os;
	}

	public void setOs(Integer os) {
		this.os = os;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(LocalDate dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public LocalDate getDtHomologacao() {
		return dtHomologacao;
	}

	public void setDtHomologacao(LocalDate dtHomologacao) {
		this.dtHomologacao = dtHomologacao;
	}

	public LocalDate getDtCommit() {
		return dtCommit;
	}

	public void setDtCommit(LocalDate dtCommit) {
		this.dtCommit = dtCommit;
	}

	public Descricao getDescricao() {
		return descricao;
	}

	public void setDescricao(Descricao descricao) {
		this.descricao = descricao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
