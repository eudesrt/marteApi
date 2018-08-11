package com.br.marte.api.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.marte.api.event.RecursoCriadoEvento;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvento>{

	@Override
	public void onApplicationEvent(RecursoCriadoEvento recursoCriadoEvento) {
		HttpServletResponse response = recursoCriadoEvento.getResponse();
		Long codigo = recursoCriadoEvento.getCodigo();
		
		adicionarHeaderLocation(response, codigo);
	}

	private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{codigo}").buildAndExpand(codigo).toUri();
		
		response.setHeader("Location", uri.toASCIIString());
	}

}
