package br.com.marcosxavierdev.myfood.domain.repository;

import java.util.List;

import br.com.marcosxavierdev.myfood.domain.model.Cozinha;

public interface CozinhaRepository  {
	
	List<Cozinha> todas ();
	Cozinha porId (Long id);
	Cozinha adicionar (Cozinha cozinha);
	void remover (Cozinha cozinhas);

}
