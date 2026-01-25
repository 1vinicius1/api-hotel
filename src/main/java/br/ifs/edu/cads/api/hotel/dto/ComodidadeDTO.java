package br.ifs.edu.cads.api.hotel.dto;

public class ComodidadeDTO {

    private Long idComodidade;
    private String nome;
    private String descricao;

    public ComodidadeDTO(){}

    public ComodidadeDTO(Long idComodidade, String nome, String descricao) {
        this.idComodidade = idComodidade;
        this.nome = nome;
        this.descricao = descricao;
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
