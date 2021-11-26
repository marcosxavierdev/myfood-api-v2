package br.com.marcosxavierdev.myfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcosxavierdev.myfood.domain.model.Cozinha;
import br.com.marcosxavierdev.myfood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

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
		return cozinhaRepository.salvar(cozinha);
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
 * cozinha -  cozinha que vem body
 * cozinhaAtual - cozinha retornada da busca
 * "id" - id que sera ignorado da cozinha do body para que a cozinhaAtual, nao fique com o id null
 * 
 * 
 * 
 * 
 */
