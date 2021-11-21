package br.com.marcosxavierdev.myfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.marcosxavierdev.myfood.MyfoodApiV2Application;
import br.com.marcosxavierdev.myfood.domain.model.Cozinha;

public class BuscaCozinhaMain {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MyfoodApiV2Application.class)
				.web(WebApplicationType.NONE).run(args);

		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		Cozinha cozinha = cadastroCozinha.buscar(1L);
		System.out.printf("%d - %s\n",cozinha.getId(), cozinha.getNome());

	}

}
