package br.com.marcosxavierdev.myfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.marcosxavierdev.myfood.MyfoodApiV2Application;
import br.com.marcosxavierdev.myfood.domain.model.Cidade;
import br.com.marcosxavierdev.myfood.domain.repository.CidadeRepository;

public class ConsultaCidadeMain {

        public static void main(String[] args) {
            ApplicationContext applicationContext = new SpringApplicationBuilder(MyfoodApiV2Application.class)
                    .web(WebApplicationType.NONE)
                    .run(args);
            
            CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
            
            List<Cidade> todasCidades = cidadeRepository.listar();
            
            for (Cidade cidade : todasCidades) {
                System.out.printf("%s - %s\n", cidade.getNome(), cidade.getEstado().getNome());
            }
        }
        
    }