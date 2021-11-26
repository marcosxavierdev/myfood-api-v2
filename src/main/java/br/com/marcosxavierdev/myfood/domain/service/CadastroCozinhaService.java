package br.com.marcosxavierdev.myfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.marcosxavierdev.myfood.domain.exception.EntidadeEmUsoException;
import br.com.marcosxavierdev.myfood.domain.exception.EntidadeNaoEncontradaException;
import br.com.marcosxavierdev.myfood.domain.model.Cozinha;
import br.com.marcosxavierdev.myfood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.salvar(cozinha);
	}

	
	public void excluir (Long cozinhaId) {
		try {
			cozinhaRepository.remover(cozinhaId);
			
		} catch (EmptyResultDataAccessException exception) {	
			throw new EntidadeNaoEncontradaException( 
					String.format("Não existe um cadastro  com  código %d", cozinhaId));
			
		} catch (DataIntegrityViolationException exception) {
			throw new  EntidadeEmUsoException(
					String.format("Cozinha de código %d não pode ser removida, pois está em uso", cozinhaId));
		}
	}
	
}




/* não se pode ter responseEntity em services
 * 
 * 
 * 
 * 
 * 
 * */
