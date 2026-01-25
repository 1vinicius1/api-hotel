package br.ifs.edu.cads.api.hotel.dto;

import br.ifs.edu.cads.api.hotel.entities.enums.Posicao;


public class CategoriaQuartoDTO {

    private Long idCategoriaQuarto;
    private String nome;
    private String descricao;
    private Integer maxHospedes;
    private Double valorDiaria;
    private Posicao posicao;

    public CategoriaQuartoDTO(Long idCategoriaQuarto, String nome, String descricao, Integer maxHospedes, Double valorDiaria, Posicao posicao) {
        this.idCategoriaQuarto = idCategoriaQuarto;
        this.nome = nome;
        this.descricao = descricao;
        this.maxHospedes = maxHospedes;
        this.valorDiaria = valorDiaria;
        this.posicao = posicao;
    }

    public Long getIdCategoriaQuarto() {
        return idCategoriaQuarto;
    }

    public void setIdCategoriaQuarto(Long idCategoriaQuarto) {
        this.idCategoriaQuarto = idCategoriaQuarto;
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

    public Integer getMaxHospedes() {
        return maxHospedes;
    }

    public void setMaxHospedes(Integer maxHospedes) {
        this.maxHospedes = maxHospedes;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }
}
