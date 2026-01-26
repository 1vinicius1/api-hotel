package br.ifs.edu.cads.api.hotel.dto;

import br.ifs.edu.cads.api.hotel.entities.Comodidade;

public class ComodidadeDTO {

    private Long idComodidade;
    private String nome;
    private String descricao;

    public ComodidadeDTO(){}

    public ComodidadeDTO(Comodidade comodidade) {
        this.idComodidade = comodidade.getIdComodidade();
        this.nome = comodidade.getNome();
        this.descricao = comodidade.getDescricao();
    }

    public Long getIdComodidade() {
        return idComodidade;
    }

    public void setIdComodidade(Long idComodidade) {
        this.idComodidade = idComodidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
