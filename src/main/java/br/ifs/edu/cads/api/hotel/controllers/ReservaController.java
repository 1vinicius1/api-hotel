package br.ifs.edu.cads.api.hotel.controllers;

import br.ifs.edu.cads.api.hotel.dto.ReservaDTO;
import br.ifs.edu.cads.api.hotel.services.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> buscarPorId(@PathVariable Long id) {
        ReservaDTO reservaDTO = reservaService.buscarPorId(id);
        return ResponseEntity.ok(reservaDTO);
    }

    @GetMapping("/listar-todas")
    public ResponseEntity<List<ReservaDTO>> listarTodas() {
        List<ReservaDTO> reservas = reservaService.listarTodas();
        return ResponseEntity.ok(reservas);
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> criar(@RequestBody ReservaDTO reservaDTO) {
        ReservaDTO reservaCriada = reservaService.salvar(reservaDTO);
        URI location = URI.create("/reservas/" + reservaCriada.getIdReserva());
        return ResponseEntity.created(location).body(reservaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> atualizar(@PathVariable Long id, @RequestBody ReservaDTO reservaDTO) {
        ReservaDTO reservaAtualizada = reservaService.atualizar(id, reservaDTO);
        return ResponseEntity.ok(reservaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        reservaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
