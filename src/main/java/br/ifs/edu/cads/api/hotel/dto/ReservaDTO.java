package br.ifs.edu.cads.api.hotel.dto;

import br.ifs.edu.cads.api.hotel.entities.Reserva;
import br.ifs.edu.cads.api.hotel.entities.enums.FormaPagamento;
import br.ifs.edu.cads.api.hotel.entities.enums.StatusReserva;

import java.util.Date;
import java.util.List;


public class ReservaDTO {

    private Long idReserva;
    private Date dataInicio;
    private Date dataFim;
    private Date dataCheckin;
    private Date dataCheckout;
    private Double valorReserva;
    private FormaPagamento formaPagamento;
    private StatusReserva statusReserva;
    private List<String> convidados;
    private Long idCategoriaQuarto;
    private Long idQuarto;
    private Long idHospede;
    private Long idFuncionario;

    public ReservaDTO(){}

    public ReservaDTO(Reserva reserva) {
        this.idReserva = reserva.getIdReserva();
        this.dataInicio = reserva.getDataInicio();
        this.dataFim = reserva.getDataFim();
        this.dataCheckin = reserva.getDataCheckin();
        this.dataCheckout = reserva.getDataCheckout();
        this.valorReserva = reserva.getValorReserva();
        this.formaPagamento = reserva.getFormaPagamento();
        this.statusReserva = reserva.getStatusReserva();
        this.idCategoriaQuarto = reserva.getCategoriaQuarto().getIdCategoriaQuarto();
        this.idQuarto = reserva.getQuarto().getIdQuarto();
        this.idHospede = reserva.getHospede().getIdHospede();
        this.idFuncionario = reserva.getFuncionario().getIdFuncionario();
        this.convidados = reserva.getConvidados();
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(Date dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public Date getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(Date dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public Double getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(Double valorReserva) {
        this.valorReserva = valorReserva;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public StatusReserva getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(StatusReserva statusReserva) {
        this.statusReserva = statusReserva;
    }

    public Long getIdCategoriaQuarto() {
        return idCategoriaQuarto;
    }

    public Long getIdQuarto() {
        return idQuarto;
    }

    public Long getIdHospede() {
        return idHospede;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdCategoriaQuarto(Long idCategoriaQuarto) {
        this.idCategoriaQuarto = idCategoriaQuarto;
    }

    public void setIdQuarto(Long idQuarto) {
        this.idQuarto = idQuarto;
    }

    public void setIdHospede(Long idHospede) {
        this.idHospede = idHospede;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public List<String> getConvidados() {
        return convidados;
    }

    public void setConvidados(List<String> convidados) {
        this.convidados = convidados;
    }
}
