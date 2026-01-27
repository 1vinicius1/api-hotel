package br.ifs.edu.cads.api.hotel.services;

import br.ifs.edu.cads.api.hotel.dto.HospedeDTO;
import br.ifs.edu.cads.api.hotel.entities.Cidade;
import br.ifs.edu.cads.api.hotel.entities.Hospede;
import br.ifs.edu.cads.api.hotel.repositories.CidadeRepository;
import br.ifs.edu.cads.api.hotel.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional
    public HospedeDTO salvar(HospedeDTO dto) {

        Cidade cidade = cidadeRepository.findById(dto.getCidadeId())
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

        Hospede hospede = new Hospede();
        hospede.setNome(dto.getNome());
        hospede.setCpf(dto.getCpf());
        hospede.setDataNascimento(dto.getDataNascimento());
        hospede.setTelefone(dto.getTelefone());
        hospede.setCidade(cidade);

        hospede = hospedeRepository.save(hospede);
        return new HospedeDTO(hospede);
    }

    public List<HospedeDTO> listarTodos() {
        return hospedeRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Transactional
    public HospedeDTO atualizar(Long id, HospedeDTO hospedeDTO) {

        Hospede existente = hospedeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospéde não encontrado"));

        Cidade cidade = cidadeRepository.findById(hospedeDTO.getCidadeId())
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

        existente.setNome(hospedeDTO.getNome());
        existente.setCpf(hospedeDTO.getCpf());
        existente.setDataNascimento(hospedeDTO.getDataNascimento());
        existente.setTelefone(hospedeDTO.getTelefone());
        existente.setCidade(cidade);

        Hospede atualizado = hospedeRepository.save(existente);

        return toDTO(atualizado);
    }

    public HospedeDTO buscarPorId(Long id) {
        Hospede hospede = hospedeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospéde não encontrado"));

        return toDTO(hospede);
    }

    @Transactional
    public void deletar(Long id) {

        Hospede hospede = hospedeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospéde não encontrado"));

        hospedeRepository.delete(hospede);
    }

    public HospedeDTO toDTO(Hospede hospede) {

        HospedeDTO dto = new HospedeDTO();
        dto.setIdHospede(hospede.getIdHospede());
        dto.setNome(hospede.getNome());
        dto.setCpf(hospede.getCpf());
        dto.setDataNascimento(hospede.getDataNascimento());
        dto.setTelefone(hospede.getTelefone());
        dto.setCidadeId(hospede.getCidade().getCidadeId());

        return dto;
    }
}
