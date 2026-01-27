package br.ifs.edu.cads.api.hotel.dto;


import br.ifs.edu.cads.api.hotel.entities.Hospede;

import java.util.Date;

public class HospedeDTO {

    private Long idHospede;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String telefone;
    private Long cidadeId;

    public HospedeDTO(){}

    public HospedeDTO(Hospede hospede) {
        this.idHospede = hospede.getIdHospede();
        this.nome = hospede.getNome();
        this.cpf = hospede.getCpf();
        this.dataNascimento = hospede.getDataNascimento();
        this.telefone = hospede.getTelefone();
        this.cidadeId = hospede.getCidade().getCidadeId();
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

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }
}
