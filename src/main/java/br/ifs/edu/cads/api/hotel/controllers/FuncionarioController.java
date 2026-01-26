package br.ifs.edu.cads.api.hotel.controllers;

import br.ifs.edu.cads.api.hotel.dto.FuncionarioDTO;
import br.ifs.edu.cads.api.hotel.services.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarPorId(@PathVariable Long id) {
        FuncionarioDTO funcionarioDTO = funcionarioService.buscarPorId(id);
        return ResponseEntity.ok(funcionarioDTO);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<FuncionarioDTO>> listarTodos() {
        List<FuncionarioDTO> funcionarios = funcionarioService.listarTodos();
        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> criar(@RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO funcionarioCriado = funcionarioService.salvar(funcionarioDTO);
        URI location = URI.create("/funcionarios/" + funcionarioCriado.getIdFuncionario());
        return ResponseEntity.created(location).body(funcionarioCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> atualizar(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO funcionarioAtualizado = funcionarioService.atualizar(id, funcionarioDTO);
        return ResponseEntity.ok(funcionarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
