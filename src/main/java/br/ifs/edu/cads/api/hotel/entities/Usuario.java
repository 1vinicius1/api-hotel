package br.ifs.edu.cads.api.hotel.entities;

import br.ifs.edu.cads.api.hotel.entities.enums.PapelUsuario;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String email;
    private String senha;
    private PapelUsuario papel;
    private boolean ativo;

    @OneToOne(mappedBy = "usuario")
    private Funcionario funcionario;

    @OneToOne
    @JoinColumn(name = "hospede_id", nullable = false, unique = true)
    private Hospede hospede;

    public Usuario(){}

    public Usuario(Long idUsuario, String email, String senha, PapelUsuario papel, boolean ativo, Funcionario funcionario, Hospede hospede) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.senha = senha;
        this.papel = papel;
        this.ativo = ativo;
        this.funcionario = funcionario;
        this.hospede = hospede;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PapelUsuario getPapel() {
        return papel;
    }

    public void setPapel(PapelUsuario papel) {
        this.papel = papel;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return ativo == usuario.ativo && Objects.equals(idUsuario, usuario.idUsuario) && Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha) && papel == usuario.papel && Objects.equals(funcionario, usuario.funcionario) && Objects.equals(hospede, usuario.hospede);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, email, senha, papel, ativo, funcionario, hospede);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", papel=" + papel +
                ", ativo=" + ativo +
                ", funcionario=" + funcionario +
                ", hospede=" + hospede +
                '}';
    }
}
