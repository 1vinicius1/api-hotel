package br.ifs.edu.cads.api.hotel.controllers;

import br.ifs.edu.cads.api.hotel.dto.CategoriaQuartoDTO;
import br.ifs.edu.cads.api.hotel.services.CategoriaQuartoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaQuartoController {

    private final CategoriaQuartoService categoriaQuartoService;

    public CategoriaQuartoController(CategoriaQuartoService categoriaQuartoService) {
        this.categoriaQuartoService = categoriaQuartoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaQuartoDTO> buscarPorId(@PathVariable Long id) {
        CategoriaQuartoDTO categoriaQuartoDTO = categoriaQuartoService.buscarPorId(id);
        return ResponseEntity.ok(categoriaQuartoDTO);
    }

    @GetMapping("/listar-todas")
    public ResponseEntity<List<CategoriaQuartoDTO>> listarTodas() {
        List<CategoriaQuartoDTO> categorias = categoriaQuartoService.listarTodas();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping
    public ResponseEntity<CategoriaQuartoDTO> criar(@RequestBody CategoriaQuartoDTO categoriaQuartoDTO) {
        CategoriaQuartoDTO categoriaCriada = categoriaQuartoService.salvar(categoriaQuartoDTO);
        URI location = URI.create("/categorias/" + categoriaCriada.getIdCategoriaQuarto());
        return ResponseEntity.created(location).body(categoriaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaQuartoDTO> atualizar(@PathVariable Long id, @RequestBody CategoriaQuartoDTO categoriaQuartoDTO) {
        CategoriaQuartoDTO categoriaAtualizada = categoriaQuartoService.atualizar(id, categoriaQuartoDTO);
        return ResponseEntity.ok(categoriaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaQuartoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
