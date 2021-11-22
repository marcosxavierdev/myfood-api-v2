package br.com.marcosxavierdev.myfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.marcosxavierdev.myfood.MyfoodApiV2Application;
import br.com.marcosxavierdev.myfood.domain.model.Permissao;
import br.com.marcosxavierdev.myfood.domain.repository.PermissaoRepository;

public class ConsultaPermissaoMain {

        public static void main(String[] args) {
            ApplicationContext applicationContext = new SpringApplicationBuilder(MyfoodApiV2Application.class)
                    .web(WebApplicationType.NONE)
                    .run(args);
            
            PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);
            
            List<Permissao> todasPermissoes = permissaoRepository.listar();
            
            for (Permissao permissao : todasPermissoes) {
                System.out.printf("%s - %s\n", permissao.getNome(), permissao.getDescricao());
            }
        }
        
    }