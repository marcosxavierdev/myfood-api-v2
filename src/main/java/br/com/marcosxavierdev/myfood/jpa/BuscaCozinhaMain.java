package br.com.marcosxavierdev.myfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.marcosxavierdev.myfood.MyfoodApiV2Application;
import br.com.marcosxavierdev.myfood.domain.model.Cozinha;
import br.com.marcosxavierdev.myfood.domain.repository.CozinhaRepository;

public class BuscaCozinhaMain {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MyfoodApiV2Application.class)
				.web(WebApplicationType.NONE).run(args);

		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		Cozinha cozinha = cozinhaRepository.porId(1L);
		System.out.printf("%d - %s\n",cozinha.getId(), cozinha.getNome());

	}

}
