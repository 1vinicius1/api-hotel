package br.ifs.edu.cads.api.hotel.dto;
import br.ifs.edu.cads.api.hotel.entities.enums.Cargo;


public class FuncionarioDTO {

    private String idFuncionario;

    private String nome;
    private String cpf;
    private Cargo cargo;

    public FuncionarioDTO(){}

    public FuncionarioDTO(String idFuncionario, String nome, String cpf, Cargo cargo) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
