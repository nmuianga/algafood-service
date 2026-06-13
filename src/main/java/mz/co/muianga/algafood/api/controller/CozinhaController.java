package mz.co.muianga.algafood.api.controller;

import lombok.RequiredArgsConstructor;
import mz.co.muianga.algafood.domain.exception.EntidadeEmUsoexception;
import mz.co.muianga.algafood.domain.exception.EntidadeNaoEncontradaException;
import mz.co.muianga.algafood.domain.model.Cozinha;
import mz.co.muianga.algafood.domain.repository.CozinhaRepository;
import mz.co.muianga.algafood.domain.service.CozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
@RequiredArgsConstructor
public class CozinhaController {

  private final CozinhaRepository cozinhaRepository;
  private final CozinhaService cozinhaService;

  @GetMapping
  public List<Cozinha> listar() {
    return cozinhaRepository.listar();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {
    var cozinha = cozinhaRepository.buscar(id);
    if (cozinha == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.status(HttpStatus.OK)
      .body(cozinha);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Cozinha adicionar(@RequestBody Cozinha cozinha) {
    return cozinhaService.salvar(cozinha);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha) {
    Cozinha cozinhaAtual = cozinhaRepository.buscar(id);
    if (cozinhaAtual == null) {
      return ResponseEntity.notFound().build();
    }

    BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
    cozinhaAtual = cozinhaService.salvar(cozinhaAtual);
    return ResponseEntity.ok(cozinhaAtual);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> remover(@PathVariable Long id) {
    try {

      cozinhaService.excluir(id);
      return ResponseEntity.noContent().build();
    } catch (EntidadeNaoEncontradaException e) {
      return ResponseEntity.notFound().build();
    } catch (EntidadeEmUsoexception e) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
  }
}
