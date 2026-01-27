package br.ifs.edu.cads.api.hotel.services;

import br.ifs.edu.cads.api.hotel.dto.QuartoDTO;
import br.ifs.edu.cads.api.hotel.entities.CategoriaQuarto;
import br.ifs.edu.cads.api.hotel.entities.Quarto;
import br.ifs.edu.cads.api.hotel.repositories.CategoriaQuartoRepository;
import br.ifs.edu.cads.api.hotel.repositories.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private CategoriaQuartoRepository categoriaQuartoRepository;

    @Transactional
    public QuartoDTO salvar(QuartoDTO dto) {

        CategoriaQuarto categoriaQuarto = categoriaQuartoRepository.findById(dto.getIdCategoriaQuarto())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Quarto quarto = new Quarto();
        quarto.setCategoria(categoriaQuarto);
        quarto.setNumQuarto(dto.getNumQuarto());
        quarto.setNumAndar(dto.getNumAndar());
        quarto.setStatusQuarto(dto.getStatusQuarto());

        quarto = quartoRepository.save(quarto);
        return new QuartoDTO(quarto);
    }

    public List<QuartoDTO> listarTodos() {
        return quartoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Transactional
    public QuartoDTO atualizar(Long id, QuartoDTO quartoDTO) {

        Quarto existente = quartoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        CategoriaQuarto categoriaQuarto = categoriaQuartoRepository.findById(quartoDTO.getIdCategoriaQuarto())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        existente.setCategoria(categoriaQuarto);
        existente.setNumQuarto(quartoDTO.getNumQuarto());
        existente.setNumAndar(quartoDTO.getNumAndar());
        existente.setStatusQuarto(quartoDTO.getStatusQuarto());

        Quarto atualizado = quartoRepository.save(existente);

        return toDTO(atualizado);
    }

    public QuartoDTO buscarPorId(Long id) {
        Quarto quarto = quartoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        return toDTO(quarto);
    }

    @Transactional
    public void deletar(Long id) {

        Quarto quarto = quartoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        quartoRepository.delete(quarto);
    }

    public QuartoDTO toDTO(Quarto quarto) {
        QuartoDTO dto = new QuartoDTO();
        dto.setIdQuarto(quarto.getIdQuarto());
        dto.setIdCategoriaQuarto(quarto.getCategoria().getIdCategoriaQuarto());
        dto.setNumQuarto(quarto.getNumQuarto());
        dto.setStatusQuarto(quarto.getStatusQuarto());
        dto.setNumAndar(quarto.getNumAndar());

        return dto;
    }



}
