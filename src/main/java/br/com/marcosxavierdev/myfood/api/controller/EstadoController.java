package br.com.marcosxavierdev.myfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcosxavierdev.myfood.domain.model.Estado;
import br.com.marcosxavierdev.myfood.domain.repository.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping
	private List<Estado> listar() {
		return estadoRepository.listar();
	}

}

/* @Controller - define a classe como um controller
 * 
 * @ResponseBody - define que a resposta dos metodos serão enviadas como resposta da requisição
 *
 * @RequestMapping("/cozinhas") - define o mapeamento do uri para acessar o controlador
 * 
 * @GetMapping - mapeamento para um requisicão GET
 * 
 * @RestController - configura;cão que possue o mesmo valor que o @Controller e o @ResponseBoby
 * 
 * */
