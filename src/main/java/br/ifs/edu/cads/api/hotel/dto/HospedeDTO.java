package br.ifs.edu.cads.api.hotel.dto;


import java.util.Date;

public class HospedeDTO {

    private Long idHospede;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String telefone;

    public HospedeDTO(){}

    public HospedeDTO(Long idHospede, String nome, String cpf, Date dataNascimento, String telefone) {
        this.idHospede = idHospede;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
