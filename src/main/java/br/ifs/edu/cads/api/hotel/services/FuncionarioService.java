package br.ifs.edu.cads.api.hotel.services;

import br.ifs.edu.cads.api.hotel.dto.FuncionarioDTO;
import br.ifs.edu.cads.api.hotel.entities.Funcionario;
import br.ifs.edu.cads.api.hotel.entities.Usuario;
import br.ifs.edu.cads.api.hotel.repositories.FuncionarioRepository;
import br.ifs.edu.cads.api.hotel.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public FuncionarioDTO salvar(FuncionarioDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Funcionario funcionario = new Funcionario();
        funcionario.setUsuario(usuario);
        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setCargo(dto.getCargo());

        funcionario = funcionarioRepository.save(funcionario);
        return new FuncionarioDTO(funcionario);
    }

    public List<FuncionarioDTO> listarTodos() {
        return funcionarioRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Transactional
    public FuncionarioDTO atualizar(Long id, FuncionarioDTO funcionarioDTO) {

        Funcionario existente = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        existente.setNome(funcionarioDTO.getNome());
        existente.setCpf(funcionarioDTO.getCpf());
        existente.setCargo(funcionarioDTO.getCargo());

        Funcionario atualizado = funcionarioRepository.save(existente);

        return toDTO(atualizado);
    }

    public FuncionarioDTO buscarPorId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        return toDTO(funcionario);
    }

    @Transactional
    public void deletar(Long id) {

        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        funcionarioRepository.delete(funcionario);
    }


    public FuncionarioDTO toDTO(Funcionario funcionario) {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setIdFuncionario(funcionario.getIdFuncionario());
        dto.setNome(funcionario.getNome());
        dto.setCpf(funcionario.getCpf());
        dto.setCargo(funcionario.getCargo());

        return dto;
    }
}
