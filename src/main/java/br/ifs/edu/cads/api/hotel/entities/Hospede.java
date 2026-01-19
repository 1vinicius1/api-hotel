package br.ifs.edu.cads.api.hotel.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHospede;

    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidade cidade;

    @OneToOne(mappedBy = "hospede")
    private Usuario usuario;

    @OneToOne(mappedBy = "hospede")
    private Reserva reserva;

    public Hospede(){}

    public Hospede(Long idHospede, String nome, String cpf, Date dataNascimento, String telefone, Cidade cidade, Usuario usuario, Reserva reserva) {
        this.idHospede = idHospede;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.cidade = cidade;
        this.usuario = usuario;
        this.reserva = reserva;
    }

    public Long getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(Long idHospede) {
        this.idHospede = idHospede;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Hospede hospede = (Hospede) o;
        return Objects.equals(idHospede, hospede.idHospede) && Objects.equals(nome, hospede.nome) && Objects.equals(cpf, hospede.cpf) && Objects.equals(dataNascimento, hospede.dataNascimento) && Objects.equals(telefone, hospede.telefone) && Objects.equals(cidade, hospede.cidade) && Objects.equals(usuario, hospede.usuario) && Objects.equals(reserva, hospede.reserva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHospede, nome, cpf, dataNascimento, telefone, cidade, usuario, reserva);
    }

    @Override
    public String toString() {
        return "Hospede{" +
                "idHospede=" + idHospede +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", telefone='" + telefone + '\'' +
                ", cidade=" + cidade +
                ", usuario=" + usuario +
                ", reserva=" + reserva +
                '}';
    }
}
