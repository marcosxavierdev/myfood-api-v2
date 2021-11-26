package br.com.marcosxavierdev.myfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcosxavierdev.myfood.domain.exception.EntidadeNaoEncontradaException;
import br.com.marcosxavierdev.myfood.domain.model.Cozinha;
import br.com.marcosxavierdev.myfood.domain.model.Restaurante;
import br.com.marcosxavierdev.myfood.domain.repository.RestauranteRepository;
import br.com.marcosxavierdev.myfood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CadastroRestauranteService cadastroRestauranteService;

	@GetMapping
	public List<Restaurante> listar() {
		return restauranteRepository.listar();
	}

	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
		Restaurante restaurante = restauranteRepository.buscar(restauranteId);
		if (restaurante != null) {
			return ResponseEntity.ok(restaurante);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
		try {
			restaurante = cadastroRestauranteService.salvar(restaurante);
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
		} catch (EntidadeNaoEncontradaException exception) {
			return ResponseEntity.badRequest().body(exception.getMessage());
		}
	}

}


/*
 * ResponseEntity<?> - ResponseEntity de qualquer tipo
 * 
 * return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
 * não usa forma resumida pq o created recebe como parametro uma uri de onde o novo recurso pode ser acessado
 * 
 * return ResponseEntity.badRequest().build();
 * não retornar NOT FOUND, por que a uri existe, porem sem valor, usar BAD REQUEST
 * 
 * */



