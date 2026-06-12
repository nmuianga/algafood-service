package mz.co.muianga.algafood.api.controller;

import lombok.RequiredArgsConstructor;
import mz.co.muianga.algafood.domain.model.Estado;
import mz.co.muianga.algafood.domain.repository.EstadoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
@RequiredArgsConstructor
public class EstadoController {

  private final EstadoRepository estadoRepository;

  @GetMapping
  public List<Estado> listar() {
    return estadoRepository.listar();
  }
}
