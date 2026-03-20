package mz.co.muianga.algafood.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import mz.co.muianga.algafood.domain.model.Cozinha;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CadastroCozinha {

  @PersistenceContext
  private EntityManager manager;

  public List<Cozinha> listar() {
    TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
    return query.getResultList();
  }
}
