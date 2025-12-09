package br.ifs.edu.cads.api.hotel.services;

import br.ifs.edu.cads.api.hotel.dto.CidadeDTO;

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
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional
    public CidadeDTO salvar(CidadeDTO dto) {

        Estado estado = estadoRepository.findById(dto.getId_estado())
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));

        Cidade cidade = new Cidade();
        cidade.setNome(dto.getNome());
        cidade.setEstado(estado);

        cidade = cidadeRepository.save(cidade);

        return new CidadeDTO(cidade);
    }

    public List<CidadeDTO> listarTodos() {
        return cidadeRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Transactional
    public CidadeDTO atualizar(Long id, CidadeDTO cidadeDTO) {

        Cidade existente = cidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

        existente.setNome(cidadeDTO.getNome());

        Estado estado = estadoRepository.findById(cidadeDTO.getId_estado())
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));

        existente.setEstado(estado);

        Cidade atualizada = cidadeRepository.save(existente);

        return toDTO(atualizada);
    }

    public CidadeDTO buscarPorId(Long id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);

        CidadeDTO cidadeDTO = null;
        if (cidade.get() != null) {
            cidadeDTO = toDTO(cidade.get());
        }

        return cidadeDTO;
    }

    @Transactional
    public void deletar(Long id) {
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

        cidadeRepository.delete(cidade);
    }

    private CidadeDTO toDTO(Cidade cidade) {
        CidadeDTO dto = new CidadeDTO();
        dto.setIdCidade(cidade.getCidadeId());
        dto.setNome(cidade.getNome());
        dto.setId_estado(cidade.getEstado().getId());

        return dto;
    }

    public Cidade fromDTO(CidadeDTO dto) {
        Estado estado = estadoRepository.findById(dto.getId_estado())
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));

        Cidade cidade = new Cidade();
        cidade.setCidadeId(dto.getIdCidade());
        cidade.setNome(dto.getNome());
        cidade.setEstado(estado);

        return cidade;
    }

}
