package br.ifs.edu.cads.api.hotel.dto;

import br.ifs.edu.cads.api.hotel.entities.CategoriaQuarto;
import br.ifs.edu.cads.api.hotel.entities.enums.Posicao;


public class CategoriaQuartoDTO {

    private Long idCategoriaQuarto;
    private String nome;
    private String descricao;
    private Integer maxHospedes;
    private Double valorDiaria;
    private Posicao posicao;

    public CategoriaQuartoDTO(CategoriaQuarto categoriaQuarto) {
        this.idCategoriaQuarto = categoriaQuarto.getIdCategoriaQuarto();
        this.nome = categoriaQuarto.getNome();
        this.descricao = categoriaQuarto.getDescricao();
        this.maxHospedes = categoriaQuarto.getMaxHospedes();
        this.valorDiaria = categoriaQuarto.getValorDiaria();
        this.posicao = categoriaQuarto.getPosicao();
    }

    public CategoriaQuartoDTO(){}

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
