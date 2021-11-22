package br.com.marcosxavierdev.myfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.marcosxavierdev.myfood.MyfoodApiV2Application;
import br.com.marcosxavierdev.myfood.domain.model.Restaurante;
import br.com.marcosxavierdev.myfood.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MyfoodApiV2Application.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
		List<Restaurante> todosRestaurantes = restaurantes.listar();
		for (Restaurante restaurante : todosRestaurantes) {
			System.out.printf("%S - %f - %S\n",restaurante.getNome(), restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
		}

	}

}
