package mz.co.muianga.algafood.infrastructure.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mz.co.muianga.algafood.domain.model.Cozinha;
import mz.co.muianga.algafood.domain.repository.CozinhaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Cozinha> listar() {
    return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
  }

  @Override
  public Cozinha buscar(Long id) {
    return manager.find(Cozinha.class, id);
  }

  @Override
  @Transactional
  public Cozinha salvar(Cozinha cozinha) {
    return manager.merge(cozinha);
  }

  @Override
  @Transactional
  public void remover(Long id) {
    var cozinha = this.buscar(id);

    if (cozinha == null) {
      throw new EmptyResultDataAccessException(1);
    }
    manager.remove(cozinha);
  }
}
