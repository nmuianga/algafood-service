package mz.co.muianga.algafood.jpa;

import mz.co.muianga.algafood.AlgafoodServiceApplication;
import mz.co.muianga.algafood.domain.model.Cozinha;
import mz.co.muianga.algafood.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteracaoCozinhaMain {

  public static void main(String[] args) {
    ApplicationContext context = new SpringApplicationBuilder(AlgafoodServiceApplication.class)
      .web(WebApplicationType.NONE)
      .run(args);

    CozinhaRepository cadastroCozinha = context.getBean(CozinhaRepository.class);

    Cozinha c1 = new Cozinha();
    c1.setId(1L);
    c1.setNome("Mocambicana");

    cadastroCozinha.salvar(c1);

  }
}
