package br.com.marcosxavierdev.myfood.domain.repository;

import java.util.List;

import br.com.marcosxavierdev.myfood.domain.model.Cozinha;

public interface CozinhaRepository {

	List<Cozinha> listar();

	Cozinha buscar(Long id);

	Cozinha salvar(Cozinha cozinha);

	void remover(Long id);

}
