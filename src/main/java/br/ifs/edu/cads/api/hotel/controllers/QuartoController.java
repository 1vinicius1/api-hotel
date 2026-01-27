package br.ifs.edu.cads.api.hotel.controllers;

import br.ifs.edu.cads.api.hotel.dto.QuartoDTO;
import br.ifs.edu.cads.api.hotel.services.QuartoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/quartos")
public class QuartoController {

    private final QuartoService quartoService;

    public QuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuartoDTO> buscarPorId(@PathVariable Long id) {
        QuartoDTO quartoDTO = quartoService.buscarPorId(id);
        return ResponseEntity.ok(quartoDTO);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<QuartoDTO>> listarTodos() {
        List<QuartoDTO> quartos = quartoService.listarTodos();
        return ResponseEntity.ok(quartos);
    }

    @PostMapping
    public ResponseEntity<QuartoDTO> criar(@RequestBody QuartoDTO quartoDTO) {
        QuartoDTO quartoCriado = quartoService.salvar(quartoDTO);
        URI location = URI.create("/quartos/" + quartoCriado.getIdQuarto());
        return ResponseEntity.created(location).body(quartoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuartoDTO> atualizar(@PathVariable Long id, @RequestBody QuartoDTO quartoDTO) {
        QuartoDTO quartoAtualizado = quartoService.atualizar(id, quartoDTO);
        return ResponseEntity.ok(quartoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        quartoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
