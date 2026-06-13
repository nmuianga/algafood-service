package mz.co.muianga.algafood.api.controller;

import lombok.RequiredArgsConstructor;
import mz.co.muianga.algafood.domain.model.Restaurante;
import mz.co.muianga.algafood.domain.repository.RestauranteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {

  private final RestauranteRepository restauranteRepository;

  @GetMapping("/{id}")
  public ResponseEntity<Restaurante> buscar(@PathVariable Long id) {
    var restaurante = restauranteRepository.buscar(id);
    if (restaurante == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(restauranteRepository.buscar(id));
  }

  @GetMapping
  public ResponseEntity<List<Restaurante>> listar() {
    return ResponseEntity.ok(restauranteRepository.listar());
  }
}
