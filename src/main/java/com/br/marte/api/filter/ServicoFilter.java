package com.br.marte.api.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ServicoFilter {
	
	private Integer os;
	
	private String titulo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtEntrada;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtCommit;
	

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

	public LocalDate getDtCommit() {
		return dtCommit;
	}

	public void setDtCommit(LocalDate dtCommit) {
		this.dtCommit = dtCommit;
	}	
	
}
