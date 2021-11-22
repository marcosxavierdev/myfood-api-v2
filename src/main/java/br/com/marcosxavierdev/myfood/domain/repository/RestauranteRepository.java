package br.com.marcosxavierdev.myfood.domain.repository;

import java.util.List;

import br.com.marcosxavierdev.myfood.domain.model.Cozinha;
import br.com.marcosxavierdev.myfood.domain.model.Restaurante;

public interface RestauranteRepository  {
	
	List<Restaurante> listar ();
	Restaurante buscar (Long id);
	Restaurante salvar (Restaurante restaurante);
	void remover (Restaurante restaurante);

}
