package br.ifs.edu.cads.api.hotel.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Cidade {

    private Integer idCidade;
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private Estado estado;

    public Integer getCidadeId() {
        return idCidade;
    }
    public void setCidadeId(Integer cidadeId) {
        this.idCidade = cidadeId;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }




}

