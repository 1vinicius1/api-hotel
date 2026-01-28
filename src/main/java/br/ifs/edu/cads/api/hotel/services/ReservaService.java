package br.ifs.edu.cads.api.hotel.services;

import br.ifs.edu.cads.api.hotel.dto.ReservaDTO;
import br.ifs.edu.cads.api.hotel.dto.ReservaResumoProjection;
import br.ifs.edu.cads.api.hotel.entities.*;
import br.ifs.edu.cads.api.hotel.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private CategoriaQuartoRepository categoriaQuartoRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Transactional
    public ReservaDTO salvar(ReservaDTO dto) {

        CategoriaQuarto categoriaQuarto = categoriaQuartoRepository.findById(dto.getIdCategoriaQuarto())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Quarto quarto = quartoRepository.findById(dto.getIdQuarto())
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        Hospede hospede = hospedeRepository.findById(dto.getIdHospede())
                .orElseThrow(() -> new RuntimeException("Hospéde não encontrado"));

        Funcionario funcionario = funcionarioRepository.findById(dto.getIdFuncionario())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Reserva reserva = new Reserva();
        reserva.setDataInicio(dto.getDataInicio());
        reserva.setDataFim(dto.getDataFim());
        reserva.setDataCheckin(dto.getDataCheckin());
        reserva.setDataCheckout(dto.getDataCheckout());
        reserva.setValorReserva(dto.getValorReserva());
        reserva.setFormaPagamento(dto.getFormaPagamento());
        reserva.setStatusReserva(dto.getStatusReserva());
        reserva.setCategoriaQuarto(categoriaQuarto);
        reserva.setQuarto(quarto);
        reserva.setHospede(hospede);
        reserva.setFuncionario(funcionario);
        reserva.setConvidados(dto.getConvidados());

        reserva = reservaRepository.save(reserva);
        return new ReservaDTO(reserva);
    }

    public List<ReservaDTO> listarTodas() {
        return reservaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Transactional
    public ReservaDTO atualizar(Long id, ReservaDTO reservaDTO) {

        Reserva existente = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        CategoriaQuarto categoriaQuarto = categoriaQuartoRepository.findById(reservaDTO.getIdCategoriaQuarto())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Quarto quarto = quartoRepository.findById(reservaDTO.getIdQuarto())
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        Hospede hospede = hospedeRepository.findById(reservaDTO.getIdHospede())
                .orElseThrow(() -> new RuntimeException("Hospéde não encontrado"));

        Funcionario funcionario = funcionarioRepository.findById(reservaDTO.getIdFuncionario())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        existente.setDataInicio(reservaDTO.getDataInicio());
        existente.setDataFim(reservaDTO.getDataFim());
        existente.setDataCheckin(reservaDTO.getDataCheckin());
        existente.setDataCheckout(reservaDTO.getDataCheckout());
        existente.setValorReserva(reservaDTO.getValorReserva());
        existente.setFormaPagamento(reservaDTO.getFormaPagamento());
        existente.setStatusReserva(reservaDTO.getStatusReserva());
        existente.setCategoriaQuarto(categoriaQuarto);
        existente.setQuarto(quarto);
        existente.setHospede(hospede);
        existente.setFuncionario(funcionario);
        existente.setConvidados(reservaDTO.getConvidados());

        Reserva atualizada = reservaRepository.save(existente);

        return toDTO(atualizada);
    }

    public ReservaDTO buscarPorId(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        return toDTO(reserva);
    }

    public List<ReservaResumoProjection> buscarResumoPorPeriodo(java.sql.Date inicio, java.sql.Date fim) {
        return reservaRepository.buscarResumoPorPeriodo(inicio, fim);
    }

    public ReservaDTO toDTO(Reserva reserva) {

        ReservaDTO dto = new ReservaDTO();
        dto.setIdReserva(reserva.getIdReserva());
        dto.setDataInicio(reserva.getDataInicio());
        dto.setDataFim(reserva.getDataFim());
        dto.setDataCheckin(reserva.getDataCheckin());
        dto.setDataCheckout(reserva.getDataCheckout());
        dto.setValorReserva(reserva.getValorReserva());
        dto.setFormaPagamento(reserva.getFormaPagamento());
        dto.setStatusReserva(reserva.getStatusReserva());
        dto.setIdCategoriaQuarto(reserva.getCategoriaQuarto().getIdCategoriaQuarto());
        dto.setIdQuarto(reserva.getQuarto().getIdQuarto());
        dto.setIdHospede(reserva.getHospede().getIdHospede());
        dto.setIdFuncionario(reserva.getFuncionario().getIdFuncionario());
        dto.setConvidados(reserva.getConvidados());

        return dto;
    }


}
