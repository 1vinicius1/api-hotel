package br.ifs.edu.cads.api.hotel.entities;

import br.ifs.edu.cads.api.hotel.entities.enums.Cargo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idFuncionario;

    private String nome;
    private String cpf;
    private Cargo cargo;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @OneToMany(mappedBy = "funcionario")
    private List<Reserva> reservas = new ArrayList<>();

    public Funcionario(){}

    public Funcionario(String idFuncionario, String nome, String cpf, Cargo cargo, Usuario usuario, List<Reserva> reservas) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.usuario = usuario;
        this.reservas = reservas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(idFuncionario, that.idFuncionario) && Objects.equals(nome, that.nome) && Objects.equals(cpf, that.cpf) && cargo == that.cargo && Objects.equals(usuario, that.usuario) && Objects.equals(reservas, that.reservas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFuncionario, nome, cpf, cargo, usuario, reservas);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "idFuncionario='" + idFuncionario + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cargo=" + cargo +
                ", usuario=" + usuario +
                ", reservas=" + reservas +
                '}';
    }
}
