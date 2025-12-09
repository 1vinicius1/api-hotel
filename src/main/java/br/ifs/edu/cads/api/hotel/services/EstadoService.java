package br.ifs.edu.cads.api.hotel.services;

import br.ifs.edu.cads.api.hotel.dto.CidadeDTO;
import br.ifs.edu.cads.api.hotel.dto.EstadoDTO;
import br.ifs.edu.cads.api.hotel.entities.Cidade;
import br.ifs.edu.cads.api.hotel.entities.Estado;
import br.ifs.edu.cads.api.hotel.repositories.CidadeRepository;
import br.ifs.edu.cads.api.hotel.repositories.EstadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional
    public EstadoDTO salvar(EstadoDTO estadoDTO) {

        Estado estado = fromDTO(estadoDTO);
        estado = estadoRepository.save(estado);
        return toDTO(estado);
    }

    public EstadoDTO buscarPorId(Long id) {

        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));

        return toDTO(estado);
    }

    public List<EstadoDTO> listarTodos() {
        return estadoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Transactional
    public EstadoDTO atualizar(Long id, EstadoDTO dto) {

        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));

        estado.setNome(dto.getNome());
        estado.setSigla(dto.getSigla());

        estado = estadoRepository.save(estado);

        return toDTO(estado);
    }

    @Transactional
    public void deletar(Long id) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));

        estadoRepository.delete(estado);

    }

    private EstadoDTO toDTO(Estado estado) {
        EstadoDTO dto = new EstadoDTO();
        dto.setNome(estado.getNome());
        dto.setId(estado.getId());
        dto.setSigla(estado.getSigla());

        return dto;
    }

    public Estado fromDTO(EstadoDTO dto) {
        Estado estado = new Estado();
        estado.setId(dto.getId());
        estado.setSigla(dto.getSigla());
        estado.setNome(dto.getNome());

        return estado;
    }



}
