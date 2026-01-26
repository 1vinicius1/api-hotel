package br.ifs.edu.cads.api.hotel.dto;

import br.ifs.edu.cads.api.hotel.entities.Reserva;
import br.ifs.edu.cads.api.hotel.entities.enums.FormaPagamento;
import br.ifs.edu.cads.api.hotel.entities.enums.StatusReserva;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
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
}
