package mz.co.muianga.algafood.domain.service;

import lombok.RequiredArgsConstructor;
import mz.co.muianga.algafood.domain.exception.EntidadeEmUsoexception;
import mz.co.muianga.algafood.domain.exception.EntidadeNaoEncontradaException;
import mz.co.muianga.algafood.domain.model.Cozinha;
import mz.co.muianga.algafood.domain.repository.CozinhaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CozinhaService {

  private final CozinhaRepository cozinhaRepository;

  public Cozinha salvar(Cozinha cozinha) {
    return cozinhaRepository.salvar(cozinha);
  }

  public void excluir(Long id) {
    try {
      cozinhaRepository.remover(id);
    }catch (EmptyResultDataAccessException e) {
      throw new EntidadeNaoEncontradaException(String.format("Nao existe cadastro de Cozinha com codigo %d", id));
    } catch (DataIntegrityViolationException e) {
      throw new EntidadeEmUsoexception(String.format("Cozinha de codigo %d nao pode ser removida, pois esta em uso", id));
    }
  }
}
