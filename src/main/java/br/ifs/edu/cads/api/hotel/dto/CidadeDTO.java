package br.ifs.edu.cads.api.hotel.dto;

import br.ifs.edu.cads.api.hotel.entities.Cidade;
import org.springframework.beans.BeanUtils;

public class CidadeDTO {

    private Long idCidade;
    private String nome;

    private Long id_estado;

    public CidadeDTO (Cidade cidade) {
        this.idCidade = cidade.getCidadeId();
        this.nome = cidade.getNome();
        this.id_estado = cidade.getEstado().getId();
    }

    public CidadeDTO(){}

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId_estado() {
        return id_estado;
    }

    public void setId_estado(Long id_estado) {
        this.id_estado = id_estado;
    }
}
