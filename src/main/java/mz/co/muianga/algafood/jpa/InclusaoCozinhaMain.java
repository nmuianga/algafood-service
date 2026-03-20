package mz.co.muianga.algafood.jpa;

import mz.co.muianga.algafood.AlgafoodServiceApplication;
import mz.co.muianga.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoCozinhaMain {

  public static void main(String[] args) {
    ApplicationContext context = new SpringApplicationBuilder(AlgafoodServiceApplication.class)
      .web(WebApplicationType.NONE)
      .run(args);

    CadastroCozinha cadastroCozinha = context.getBean(CadastroCozinha.class);

    Cozinha cozinha = new Cozinha();
    cozinha.setNome("Cozinha 1");

    Cozinha cozinha2 = new Cozinha();
    cozinha2.setNome("Cozinha 2");

    cadastroCozinha.adicionar(cozinha);
    cadastroCozinha.adicionar(cozinha2);
  }
}
