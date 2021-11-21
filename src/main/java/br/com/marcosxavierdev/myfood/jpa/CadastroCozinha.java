package br.com.marcosxavierdev.myfood.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import br.com.marcosxavierdev.myfood.domain.model.Cozinha;

@Component
public class CadastroCozinha {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Cozinha> listar (){
		return entityManager.createQuery("from Cozinha", Cozinha.class).getResultList(); 
	}
	
	public Cozinha buscar (Long id) {
		return entityManager.find(Cozinha.class, id);
	}

	@Transactional
	public Cozinha adicionar (Cozinha cozinha) {
		return entityManager.merge(cozinha);
	}
	
	@Transactional
	public void remover (Cozinha cozinha) {
		cozinha = buscar(cozinha.getId());
		entityManager.remove(cozinha);
	}
	
	
	
	
	
}

/* @Component - define a classe como uma bean
 * 
 * @PersistenceContext - injeta um EntityManager (anotação nativa)
 * 
 * @Transactional - define que o metodo será realizado dentro de uma transação
 * 
 * */
