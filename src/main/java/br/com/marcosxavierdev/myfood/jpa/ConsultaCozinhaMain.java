package br.com.marcosxavierdev.myfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.marcosxavierdev.myfood.MyfoodApiV2Application;
import br.com.marcosxavierdev.myfood.domain.model.Cozinha;
import br.com.marcosxavierdev.myfood.domain.repository.CozinhaRepository;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MyfoodApiV2Application.class)
				.web(WebApplicationType.NONE).run(args);

		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
		List<Cozinha> todasCozinhas = cozinhas.listar();
		for (Cozinha cozinha : todasCozinhas) {
			System.out.println(cozinha.getNome());
		}

	}

}
