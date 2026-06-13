package mz.co.muianga.algafood.domain.service;

import lombok.RequiredArgsConstructor;
import mz.co.muianga.algafood.domain.model.Cozinha;
import mz.co.muianga.algafood.domain.repository.CozinhaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CozinhaService {

  private final CozinhaRepository cozinhaRepository;

  public Cozinha salvar(Cozinha cozinha) {
    return cozinhaRepository.salvar(cozinha);
  }
}
