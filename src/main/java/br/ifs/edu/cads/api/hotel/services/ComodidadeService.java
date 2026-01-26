package br.ifs.edu.cads.api.hotel.services;

import br.ifs.edu.cads.api.hotel.dto.ComodidadeDTO;
import br.ifs.edu.cads.api.hotel.entities.Comodidade;
import br.ifs.edu.cads.api.hotel.repositories.ComodidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComodidadeService {

    @Autowired
    private ComodidadeRepository comodidadeRepository;

    @Transactional
    public ComodidadeDTO salvar(ComodidadeDTO dto) {

        Comodidade comodidade = new Comodidade();
        comodidade.setNome(dto.getNome());
        comodidade.setDescricao(dto.getDescricao());

        comodidade = comodidadeRepository.save(comodidade);

        return new ComodidadeDTO(comodidade);
    }

    public List<ComodidadeDTO> listarTodos(){
        return comodidadeRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Transactional
    public ComodidadeDTO atualizar(Long id, ComodidadeDTO comodidadeDTO) {

        Comodidade existente = comodidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comodidade não encontrada"));

        existente.setNome(comodidadeDTO.getNome());
        existente.setDescricao(comodidadeDTO.getDescricao());

        Comodidade atualizada = comodidadeRepository.save(existente);

        return toDTO(atualizada);
    }

    public ComodidadeDTO buscarPorId(Long id) {
        Comodidade comodidade = comodidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comodidade não encontrada"));

        return toDTO(comodidade);
    }

    @Transactional
    public void deletar(Long id) {

        Comodidade comodidade = comodidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comodidade não encontrada"));

        comodidadeRepository.delete(comodidade);
    }

    private ComodidadeDTO toDTO(Comodidade comodidade) {
        ComodidadeDTO dto = new ComodidadeDTO();
        dto.setIdComodidade(comodidade.getIdComodidade());
        dto.setNome(comodidade.getNome());
        dto.setDescricao(comodidade.getDescricao());

        return dto;
    }


}
