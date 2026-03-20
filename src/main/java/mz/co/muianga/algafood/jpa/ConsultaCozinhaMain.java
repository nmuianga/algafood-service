package mz.co.muianga.algafood.jpa;

import mz.co.muianga.algafood.AlgafoodServiceApplication;
import mz.co.muianga.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {

  public static void main(String[] args) {
    ApplicationContext context = new SpringApplicationBuilder(AlgafoodServiceApplication.class)
      .web(WebApplicationType.NONE)
      .run(args);

    CadastroCozinha cadastroCozinha = context.getBean(CadastroCozinha.class);
    List<Cozinha> cozinhas = cadastroCozinha.listar();
    for(Cozinha cozinha : cozinhas) {
      System.out.println(cozinha.getNome());
    }
  }
}
