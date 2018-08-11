package com.br.marte.api.resource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.br.marte.api.event.RecursoCriadoEvento;
import com.br.marte.api.exceptionhandler.demoExceptionHandlerextends.Erro;
import com.br.marte.api.execption.ServicoInexistenteOuInativaException;
import com.br.marte.api.model.Servico;
import com.br.marte.api.model.Status;
import com.br.marte.api.model.Usuario;
import com.br.marte.api.repository.ServicoRepository;
import com.br.marte.api.repository.filter.ServicoFilter;
import com.br.marte.api.service.ServicoService;

@RestController
@RequestMapping("/servico")
public class ServicoResource {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	ServicoService servicoService;
		
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource ;
	
	
	@CrossOrigin(maxAge =10 ,origins= {"http://localhost:4200"})
	@GetMapping
	public List<Servico> findAll(){
		
		List<Servico> lista = servicoRepository.findAll();
		
		lista.sort(Comparator.comparing(Servico::getDtEntrada).reversed());
		
		return lista;
	}
	
	
	@GetMapping
	@RequestMapping("/busca")
	public Page<Servico> pesquisar(ServicoFilter servicoFilter, Pageable pageable) {
		return servicoRepository.filtrar(servicoFilter,pageable);
	}

	
	@GetMapping("/{codigo}")
	public ResponseEntity<Servico> buscarPeloCodigo(@PathVariable Long codigo) {
		Servico servico = servicoRepository.findOne(codigo);

		return servico != null ? ResponseEntity.ok(servico) : ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	public ResponseEntity<Servico> criar(@RequestBody Servico servico, HttpServletResponse response) {
		LocalDate localDate = LocalDate.now();
		
		Usuario usuario = new Usuario();
		usuario.setCodigo((long) 1);
		
		Status status = new Status();
		status.setCodigo((long) 1);
		
		servico.setDtEntrada(localDate);
		servico.setStatus(status);
		servico.setUsuario(usuario);
		
		Servico servicoSalvo = servicoService.salvar(servico);

		publisher.publishEvent(new RecursoCriadoEvento(this, response, servicoSalvo.getCodigo()));

		return ResponseEntity.status(HttpStatus.CREATED).body(servicoSalvo);
	}
	
	@ExceptionHandler({ ServicoInexistenteOuInativaException.class })
	public ResponseEntity<Object> handleServicoInexistenteOuInativaException(ServicoInexistenteOuInativaException ex,
			WebRequest request) {

		String mensagemUsuario = messageSource.getMessage("os.inexistente-ou-inativa", null,
				LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();

		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));

		return ResponseEntity.badRequest().body(erros);
	}
	
}
