package br.ifs.edu.cads.api.hotel.controllers;

import br.ifs.edu.cads.api.hotel.dto.EstadoDTO;
import br.ifs.edu.cads.api.hotel.services.EstadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> buscarPorId(@PathVariable Long id) {
        EstadoDTO estadoDTO = estadoService.buscarPorId(id);
        return ResponseEntity.ok(estadoDTO);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<EstadoDTO>> listarTodos() {
        List<EstadoDTO> estados = estadoService.listarTodos();
        return ResponseEntity.ok(estados);
    }

    @PostMapping
    public ResponseEntity<EstadoDTO> criar(@RequestBody EstadoDTO estadoDTO) {
        EstadoDTO estadoCriado = estadoService.salvar(estadoDTO);
        URI location = URI.create("/estados/" + estadoCriado.getId());
        return ResponseEntity.created(location).body(estadoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> atualizar(@PathVariable Long id, @RequestBody EstadoDTO estadoDTO) {

        EstadoDTO atualizado = estadoService.atualizar(id, estadoDTO);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        estadoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
