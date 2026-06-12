package mz.co.muianga.algafood.infrastructure.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mz.co.muianga.algafood.domain.model.FormaPagamento;
import mz.co.muianga.algafood.domain.repository.FormaPagamentoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<FormaPagamento> listar() {
    return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
  }

  @Override
  public FormaPagamento buscar(Long id) {
    return manager.find(FormaPagamento.class, id);
  }

  @Transactional
  @Override
  public FormaPagamento salvar(FormaPagamento formaPagamento) {
    return manager.merge(formaPagamento);
  }

  @Transactional
  @Override
  public void remover(FormaPagamento formaPagamento) {
    this.buscar(formaPagamento.getId());
    manager.remove(formaPagamento);
  }
}
