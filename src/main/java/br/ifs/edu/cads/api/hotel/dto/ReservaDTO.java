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

    public ReservaDTO(Long idReserva, Date dataInicio, Date dataFim, Date dataCheckin, Date dataCheckout, Double valorReserva,
                      FormaPagamento formaPagamento, StatusReserva statusReserva) {
        this.idReserva = idReserva;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
        this.valorReserva = valorReserva;
        this.formaPagamento = formaPagamento;
        this.statusReserva = statusReserva;
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
