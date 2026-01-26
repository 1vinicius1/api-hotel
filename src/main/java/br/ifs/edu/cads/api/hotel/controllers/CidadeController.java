package br.ifs.edu.cads.api.hotel.controllers;

import br.ifs.edu.cads.api.hotel.dto.CidadeDTO;
import br.ifs.edu.cads.api.hotel.entities.Cidade;
import br.ifs.edu.cads.api.hotel.services.CidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> buscarPorId(@PathVariable Long id) {
        CidadeDTO cidadeDTO = cidadeService.buscarPorId(id);
        return ResponseEntity.ok(cidadeDTO);
    }

    @GetMapping("/listar-todas")
    public ResponseEntity<List<CidadeDTO>> listarTodos() {
        List<CidadeDTO> cidades = cidadeService.listarTodos();
        return ResponseEntity.ok(cidades);
    }

    @PostMapping
    public ResponseEntity<CidadeDTO> criar(@RequestBody CidadeDTO cidadeDTO) {
        CidadeDTO cidadeCriada = cidadeService.salvar(cidadeDTO);
        URI location = URI.create("/cidades/" + cidadeCriada.getIdCidade());
        return ResponseEntity.created(location).body(cidadeCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CidadeDTO> atualizar(@PathVariable Long id, @RequestBody CidadeDTO cidadeDTO) {
        CidadeDTO cidadeAtualizada = cidadeService.atualizar(id, cidadeDTO);
        return ResponseEntity.ok(cidadeAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
