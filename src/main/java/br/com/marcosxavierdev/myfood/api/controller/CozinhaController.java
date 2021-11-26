package br.com.marcosxavierdev.myfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcosxavierdev.myfood.domain.exception.EntidadeEmUsoException;
import br.com.marcosxavierdev.myfood.domain.exception.EntidadeNaoEncontradaException;
import br.com.marcosxavierdev.myfood.domain.model.Cozinha;
import br.com.marcosxavierdev.myfood.domain.repository.CozinhaRepository;
import br.com.marcosxavierdev.myfood.domain.service.CadastroCozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private CadastroCozinhaService cadastroCozinhaService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Cozinha> listar() {
		return cozinhaRepository.listar();
	}

	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
		if(cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cadastroCozinhaService.salvar(cozinha);
	}
	
	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar (@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {
		Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);
		if(cozinhaAtual != null) {
//			cozinhaAtual.setNome(cozinha.getNome());
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
			cozinhaAtual = cozinhaRepository.salvar(cozinhaAtual);
			return ResponseEntity.ok(cozinhaAtual);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover (@PathVariable Long cozinhaId) {
		try {	
			cadastroCozinhaService.excluir(cozinhaId);
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoEncontradaException exception) {
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeEmUsoException exception) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}

}

/*
 * @Controller - define a classe como um controller
 * 
 * @ResponseBody - define que a resposta dos metodos serão enviadas como
 * resposta da requisição
 *
 * @RequestMapping("/cozinhas") - define o mapeamento do uri para acessar o
 * controlador
 * 
 * @autowired - injeção de dependencias
 * 
 * @GetMapping - mapeamento para um requisicão GET
 * 
 * @GetMapping (produces = "application/json") - define o formato especifico
 * (que por padrão é json)
 * 
 * @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE) - com uma constante
 * 
 * @RestController - configura;cão que possue o mesmo valor que o @Controller e
 * o @ResponseBoby
 * 
 * @PathVariable ("cozinhaId") Long id - faz o bind (vinculando) entre o
 * parametro da uri e o parametro do metodo
 * 
 * @ResponseStatus(HttpStatus.CREATED) - define o codigo http da resposta
 * 
 * ResponseEntity - representa uma resposta http que pode ter uma instancia,
 * servindo para customizar
 * 
 * ResponseEntity.status(HttpStatus.OK).body(cozinha); - 
 * .status(HttpStatus.OK) - define o status da resposta 
 * .body(cozinha) - define que tenha um objeto no corpo (no payload) 
 * .build(); - cria o ResponseEntity sem nenhum corpo
 * 
 * **************************************************
 * HttpHeaders headers = new HttpHeaders();
 * headers.add(HttpHeaders.LOCATION, "http://api.myfood.local.8080/cozinhas")
 * 
 * ResponseEntity.status(HttpStatus.FOUND).headers(headers); 
 * .status(HttpStatus.FOUND) - define o status da resposta (302 - movido temporariamente)
 * .headers(headers) - customiza o header da resposta (criado acima)
 * .build(); - cria o ResponseEntity sem nenhum corpo
 * *****************************************************
 * 
 * @RequestBody - define que o parametro vai receber o corpo da requisição
 * 
 * BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
 * cozinha -  origem (copia dos dados da cozinha que vem body (com id null))
 * cozinhaAtual - destino (cola os dados da origem para ac ozinha retornada da busca 
 * (que copiou o id null da instancia que veio no body))
 * "id" - parametro que indica uma propriedade a ser ignorada, nao copiando o id
 * 
 * return ResponseEntity.status(HttpStatus.CONFLICT).build();
 * (HttpStatus.CONFLICT) - 409 conflict por causa da possibilidade da exclusao violar uma constraint do banco 
 * 
 * 200 - objeto com id náo vinculado como fk em outra tabela
 * 404 - objeto não existe
 * 409 - objeto com id vinculada como fk em outra tabela
 * 
 */
