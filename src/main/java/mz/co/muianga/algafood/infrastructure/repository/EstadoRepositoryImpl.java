package mz.co.muianga.algafood.infrastructure.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mz.co.muianga.algafood.domain.model.Estado;
import mz.co.muianga.algafood.domain.repository.EstadoRepository;

import java.util.List;

public class EstadoRepositoryImpl implements EstadoRepository {
  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Estado> listar() {
    return manager.createQuery("from Estado", Estado.class).getResultList();
  }

  @Override
  public Estado buscar(Long id) {
    return manager.find(Estado.class, id);
  }

  @Override
  public Estado salvar(Estado estado) {
    return manager.merge(estado);
  }

  @Override
  public void remover(Estado estado) {
    this.buscar(estado.getId());
    manager.remove(estado);
  }
}
