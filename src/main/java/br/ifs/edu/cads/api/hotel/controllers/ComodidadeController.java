package br.ifs.edu.cads.api.hotel.controllers;

import br.ifs.edu.cads.api.hotel.dto.ComodidadeDTO;
import br.ifs.edu.cads.api.hotel.services.ComodidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/comodidades")
public class ComodidadeController {

    private final ComodidadeService comodidadeService;

    public ComodidadeController(ComodidadeService comodidadeService) {
        this.comodidadeService = comodidadeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComodidadeDTO> buscarPorId(@PathVariable Long id) {
        ComodidadeDTO comodidadeDTO = comodidadeService.buscarPorId(id);
        return ResponseEntity.ok(comodidadeDTO);
    }

    @GetMapping("/listar-todas")
    public ResponseEntity<List<ComodidadeDTO>> listarTodos() {
        List<ComodidadeDTO> comodidades = comodidadeService.listarTodos();
        return ResponseEntity.ok(comodidades);
    }

    @PostMapping
    public ResponseEntity<ComodidadeDTO> criar(@RequestBody ComodidadeDTO comodidadeDTO) {
        ComodidadeDTO comodidadeCriada = comodidadeService.salvar(comodidadeDTO);
        URI location = URI.create("/comodidades/" + comodidadeCriada.getIdComodidade());
        return ResponseEntity.created(location).body(comodidadeCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComodidadeDTO> atualizar(@PathVariable Long id, @RequestBody ComodidadeDTO comodidadeDTO) {
        ComodidadeDTO comodidadeAtualizada = comodidadeService.atualizar(id, comodidadeDTO);
        return ResponseEntity.ok(comodidadeAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        comodidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }



}
