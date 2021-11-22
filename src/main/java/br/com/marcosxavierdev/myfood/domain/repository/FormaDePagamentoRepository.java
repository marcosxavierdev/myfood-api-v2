package br.com.marcosxavierdev.myfood.domain.repository;

import java.util.List;

import br.com.marcosxavierdev.myfood.domain.model.FormaDePagamento;

public interface FormaDePagamentoRepository {

	List<FormaDePagamento> listar();

	FormaDePagamento buscar(Long id);

	FormaDePagamento salvar(FormaDePagamento formaDePagamento);

	void remover(FormaDePagamento formaDePagamento);

}
