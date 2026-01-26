package br.ifs.edu.cads.api.hotel.services;

import br.ifs.edu.cads.api.hotel.dto.CategoriaQuartoDTO;
import br.ifs.edu.cads.api.hotel.entities.CategoriaQuarto;
import br.ifs.edu.cads.api.hotel.repositories.CategoriaQuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaQuartoService {

    @Autowired
    private CategoriaQuartoRepository categoriaQuartoRepository;

    @Transactional
    public CategoriaQuartoDTO salvar(CategoriaQuartoDTO dto) {

        CategoriaQuarto categoriaQuarto = new CategoriaQuarto();
        categoriaQuarto.setDescricao(dto.getDescricao());
        categoriaQuarto.setNome(dto.getNome());
        categoriaQuarto.setPosicao(dto.getPosicao());
        categoriaQuarto.setMaxHospedes(dto.getMaxHospedes());
        categoriaQuarto.setValorDiaria(dto.getValorDiaria());

        categoriaQuarto = categoriaQuartoRepository.save(categoriaQuarto);

        return new CategoriaQuartoDTO(categoriaQuarto);
    }

    public List<CategoriaQuartoDTO> listarTodas(){
        return categoriaQuartoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Transactional
    public CategoriaQuartoDTO atualizar(Long id, CategoriaQuartoDTO categoriaQuartoDTO) {

        CategoriaQuarto existente = categoriaQuartoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria de Quarto não encontrada"));

        existente.setDescricao(categoriaQuartoDTO.getDescricao());
        existente.setNome(categoriaQuartoDTO.getNome());
        existente.setPosicao(categoriaQuartoDTO.getPosicao());
        existente.setMaxHospedes(categoriaQuartoDTO.getMaxHospedes());
        existente.setValorDiaria(categoriaQuartoDTO.getValorDiaria());

        CategoriaQuarto atualizada = categoriaQuartoRepository.save(existente);

        return toDTO(atualizada);
    }

    public CategoriaQuartoDTO buscarPorId(Long id) {
        CategoriaQuarto categoriaQuarto = categoriaQuartoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria de Quarto não encontrada"));

        return toDTO(categoriaQuarto);
    }

    @Transactional
    public void deletar(Long id) {
        CategoriaQuarto categoriaQuarto = categoriaQuartoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria de Quarto não encontrada"));

        categoriaQuartoRepository.delete(categoriaQuarto);
    }

    private CategoriaQuartoDTO toDTO(CategoriaQuarto categoriaQuarto) {
        CategoriaQuartoDTO dto = new CategoriaQuartoDTO();

        dto.setIdCategoriaQuarto(categoriaQuarto.getIdCategoriaQuarto());
        dto.setDescricao(categoriaQuarto.getDescricao());
        dto.setNome(categoriaQuarto.getNome());
        dto.setPosicao(categoriaQuarto.getPosicao());
        dto.setMaxHospedes(categoriaQuarto.getMaxHospedes());
        dto.setValorDiaria(categoriaQuarto.getValorDiaria());

        return dto;
    }
}
