package br.com.marcosxavierdev.myfood.infrasctructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import br.com.marcosxavierdev.myfood.domain.model.FormaDePagamento;
import br.com.marcosxavierdev.myfood.domain.repository.FormaDePagamentoRepository;

@Component
public class FormaDePagamentoRepositoryJpa implements FormaDePagamentoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<FormaDePagamento> listar() {
		return manager.createQuery("from FormaDePagamento", FormaDePagamento.class).getResultList();
	}

	@Override
	public FormaDePagamento buscar(Long id) {
		return manager.find(FormaDePagamento.class, id);
	}

	@Transactional
	@Override
	public FormaDePagamento salvar(FormaDePagamento formaDePagamento) {
		return manager.merge(formaDePagamento);
	}

	@Transactional
	@Override
	public void remover(FormaDePagamento formaDePagamento) {
		formaDePagamento = buscar(formaDePagamento.getId());
		manager.remove(formaDePagamento);
	}

}
