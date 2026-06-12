package mz.co.muianga.algafood.domain.repository;

import mz.co.muianga.algafood.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {
  List<Permissao> listar();

  Permissao buscar(Long id);

  Permissao salvar(Permissao permissao);

  void remover(Permissao permissao);
}
