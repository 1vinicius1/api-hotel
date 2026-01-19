package br.ifs.edu.cads.api.hotel.entities;

import br.ifs.edu.cads.api.hotel.entities.enums.FormaPagamento;
import br.ifs.edu.cads.api.hotel.entities.enums.StatusReserva;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "categoria_quarto_id", nullable = false)
    private CategoriaQuarto categoriaQuarto;

    @ManyToOne
    @JoinColumn(name = "quarto_id", nullable = false)
    private Quarto quarto;

    @OneToOne
    @JoinColumn(name = "hospede_id", nullable = false, unique = true)
    private Hospede hospede;

    @ElementCollection
    @CollectionTable(name = "reserva_convidados", joinColumns = @JoinColumn(name = "reserva_id"))
    @Column(name = "nome_convidado")
    private List<String> convidados = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    private Date dataInicio;
    private Date dataFim;
    private Date dataCheckin;
    private Date dataCheckout;
    private Double valorReserva;
    private FormaPagamento formaPagamento;
    private StatusReserva statusReserva;

    public Reserva(){}

    public Reserva(Long idReserva, CategoriaQuarto categoriaQuarto, Quarto quarto, Hospede hospede, List<String> convidados, Funcionario funcionario, Date dataInicio, Date dataFim, Date dataCheckin, Date dataCheckout, Double valorReserva, FormaPagamento formaPagamento, StatusReserva statusReserva) {
        this.idReserva = idReserva;
        this.categoriaQuarto = categoriaQuarto;
        this.quarto = quarto;
        this.hospede = hospede;
        this.convidados = convidados;
        this.funcionario = funcionario;
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

    public CategoriaQuarto getCategoriaQuarto() {
        return categoriaQuarto;
    }

    public void setCategoriaQuarto(CategoriaQuarto categoriaQuarto) {
        this.categoriaQuarto = categoriaQuarto;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<String> getConvidados() {
        return convidados;
    }

    public void setConvidados(List<String> convidados) {
        this.convidados = convidados;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(idReserva, reserva.idReserva) && Objects.equals(categoriaQuarto, reserva.categoriaQuarto) && Objects.equals(quarto, reserva.quarto) && Objects.equals(hospede, reserva.hospede) && Objects.equals(convidados, reserva.convidados) && Objects.equals(funcionario, reserva.funcionario) && Objects.equals(dataInicio, reserva.dataInicio) && Objects.equals(dataFim, reserva.dataFim) && Objects.equals(dataCheckin, reserva.dataCheckin) && Objects.equals(dataCheckout, reserva.dataCheckout) && Objects.equals(valorReserva, reserva.valorReserva) && formaPagamento == reserva.formaPagamento && statusReserva == reserva.statusReserva;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReserva, categoriaQuarto, quarto, hospede, convidados, funcionario, dataInicio, dataFim, dataCheckin, dataCheckout, valorReserva, formaPagamento, statusReserva);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", categoriaQuarto=" + categoriaQuarto +
                ", quarto=" + quarto +
                ", hospede=" + hospede +
                ", convidados=" + convidados +
                ", funcionario=" + funcionario +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", dataCheckin=" + dataCheckin +
                ", dataCheckout=" + dataCheckout +
                ", valorReserva=" + valorReserva +
                ", formaPagamento=" + formaPagamento +
                ", statusReserva=" + statusReserva +
                '}';
    }
}
