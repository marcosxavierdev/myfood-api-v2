package br.com.marcosxavierdev.myfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.marcosxavierdev.myfood.MyfoodApiV2Application;
import br.com.marcosxavierdev.myfood.domain.model.FormaDePagamento;
import br.com.marcosxavierdev.myfood.domain.repository.FormaDePagamentoRepository;

public class ConsultaFormaDePagamentoMain {

        public static void main(String[] args) {
            ApplicationContext applicationContext = new SpringApplicationBuilder(MyfoodApiV2Application.class)
                    .web(WebApplicationType.NONE)
                    .run(args);
            
            FormaDePagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaDePagamentoRepository.class);
            
            List<FormaDePagamento> todasFormasPagamentos = formaPagamentoRepository.listar();
            
            for (FormaDePagamento formaPagamento : todasFormasPagamentos) {
                System.out.println(formaPagamento.getDescricao());
            }
        }
        
    }