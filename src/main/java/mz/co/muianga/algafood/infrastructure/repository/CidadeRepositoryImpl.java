package mz.co.muianga.algafood.infrastructure.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mz.co.muianga.algafood.domain.model.Cidade;
import mz.co.muianga.algafood.domain.repository.CidadeRepository;

import java.util.List;

public class CidadeRepositoryImpl implements CidadeRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Cidade> listar() {
    return manager.createQuery("from Cidade", Cidade.class).getResultList();
  }

  @Override
  public Cidade buscar(Long id) {
    return manager.find(Cidade.class, id);
  }

  @Override
  public Cidade salvar(Cidade cidade) {
    return manager.merge(cidade);
  }

  @Override
  public void remover(Cidade cidade) {
    this.buscar(cidade.getId());
    manager.remove(cidade);
  }
}
