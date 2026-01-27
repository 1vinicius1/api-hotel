package br.ifs.edu.cads.api.hotel.controllers;

import br.ifs.edu.cads.api.hotel.dto.HospedeDTO;
import br.ifs.edu.cads.api.hotel.services.HospedeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

    private final HospedeService hospedeService;

    public HospedeController(HospedeService hospedeService) {
        this.hospedeService = hospedeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospedeDTO> buscarPorId(@PathVariable Long id) {
        HospedeDTO hospedeDTO = hospedeService.buscarPorId(id);
        return ResponseEntity.ok(hospedeDTO);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<HospedeDTO>> listarTodos() {
        List<HospedeDTO> hospedes = hospedeService.listarTodos();
        return ResponseEntity.ok(hospedes);
    }

    @PostMapping
    public ResponseEntity<HospedeDTO> criar(@RequestBody HospedeDTO hospedeDTO) {
        HospedeDTO hospedeCriado = hospedeService.salvar(hospedeDTO);
        URI location = URI.create("/hospedes/" + hospedeCriado.getIdHospede());
        return ResponseEntity.created(location).body(hospedeCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HospedeDTO> atualizar(@PathVariable Long id, @RequestBody HospedeDTO hospedeDTO) {
        HospedeDTO hospedeAtualizado = hospedeService.atualizar(id, hospedeDTO);
        return ResponseEntity.ok(hospedeAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        hospedeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
