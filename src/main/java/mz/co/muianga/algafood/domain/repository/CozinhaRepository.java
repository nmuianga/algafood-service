package mz.co.muianga.algafood.domain.repository;

import mz.co.muianga.algafood.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {
  List<Cozinha> listar();

  Cozinha buscar(Long id);

  Cozinha salvar(Cozinha cozinha);

  void remover(Cozinha cozinha);
}
