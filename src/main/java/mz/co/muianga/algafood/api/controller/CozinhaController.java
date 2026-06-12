package mz.co.muianga.algafood.api.controller;

import lombok.RequiredArgsConstructor;
import mz.co.muianga.algafood.domain.model.Cozinha;
import mz.co.muianga.algafood.domain.repository.CozinhaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
@RequiredArgsConstructor
public class CozinhaController {

  private final  CozinhaRepository cozinhaRepository;

  @GetMapping
  public List<Cozinha> listar() {
    return cozinhaRepository.listar();
  }

  @GetMapping("/{id}")
  public Cozinha buscar(@PathVariable("id") Long id) {
    return cozinhaRepository.buscar(id);
  }
}
