package mz.co.muianga.algafood.infrastructure.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mz.co.muianga.algafood.domain.model.Restaurante;
import mz.co.muianga.algafood.domain.repository.RestauranteRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RestauranteRepositoryImpl implements RestauranteRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Restaurante> listar() {
    return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
  }

  @Override
  public Restaurante buscar(Long id) {
    return manager.find(Restaurante.class, id);
  }

  @Transactional
  @Override
  public Restaurante salvar(Restaurante restaurante) {
    return manager.merge(restaurante);
  }

  @Transactional
  @Override
  public void remover(Restaurante restaurante) {
    this.buscar(restaurante.getId());
    manager.remove(restaurante);
  }
}
