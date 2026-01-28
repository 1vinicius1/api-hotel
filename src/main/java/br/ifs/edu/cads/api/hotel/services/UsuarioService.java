package br.ifs.edu.cads.api.hotel.services;

import br.ifs.edu.cads.api.hotel.dto.UsuarioDTO;
import br.ifs.edu.cads.api.hotel.entities.Hospede;
import br.ifs.edu.cads.api.hotel.entities.Usuario;
import br.ifs.edu.cads.api.hotel.repositories.HospedeRepository;
import br.ifs.edu.cads.api.hotel.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HospedeRepository hospedeRepository;

    @Transactional
    public UsuarioDTO salvar(UsuarioDTO dto) {

        Usuario usuario = new Usuario();

        if (dto.getIdHospede() != null) {
            Hospede hospede = hospedeRepository.findById(dto.getIdHospede())
                    .orElseThrow(() -> new RuntimeException("Hospéde não encontrado"));
            usuario.setHospede(hospede);
        }

        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setPapel(dto.getPapel());
        usuario.setAtivo(dto.isAtivo());

        usuario = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }

    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Transactional
    public UsuarioDTO atualizar(Long id, UsuarioDTO usuarioDTO) {

        Usuario existente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        existente.setEmail(usuarioDTO.getEmail());
        existente.setSenha(usuarioDTO.getSenha());
        existente.setPapel(usuarioDTO.getPapel());
        existente.setAtivo(usuarioDTO.isAtivo());

        if (usuarioDTO.getIdHospede() != null) {
            Hospede hospede = hospedeRepository.findById(usuarioDTO.getIdHospede())
                    .orElseThrow(() -> new RuntimeException("Hospéde não encontrado"));
            existente.setHospede(hospede);
        } else {
            existente.setHospede(null);
        }

        Usuario atualizado = usuarioRepository.save(existente);
        return toDTO(atualizado);
    }


    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return toDTO(usuario);
    }

    @Transactional
    public void deletar(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (usuario.getFuncionario() != null) {
            usuario.getFuncionario().setUsuario(null);
            usuario.setFuncionario(null);
        }

        usuarioRepository.delete(usuario);
    }


    public UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setEmail(usuario.getEmail());
        dto.setSenha(usuario.getSenha());
        dto.setPapel(usuario.getPapel());
        dto.setAtivo(usuario.isAtivo());

        if (usuario.getHospede() != null) {
            dto.setIdHospede(usuario.getHospede().getIdHospede());
        } else {
            dto.setIdHospede(null);
        }

        return dto;
    }

}
