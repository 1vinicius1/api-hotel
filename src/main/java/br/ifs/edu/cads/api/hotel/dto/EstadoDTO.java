package br.ifs.edu.cads.api.hotel.dto;

import br.ifs.edu.cads.api.hotel.entities.Estado;
import org.springframework.beans.BeanUtils;

public class EstadoDTO {

    private Long id;
    private String sigla;
    private String nome;

    public Long getId() {
        return id;
    }

    public EstadoDTO(Estado estado){
        BeanUtils.copyProperties(estado, this);
    }

    public EstadoDTO(){}

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
