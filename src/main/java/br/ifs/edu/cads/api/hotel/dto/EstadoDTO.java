package br.ifs.edu.cads.api.hotel.dto;

import br.ifs.edu.cads.api.hotel.entities.Estado;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class EstadoDTO {

    private Long id;
    private String sigla;
    private String nome;

    public Long getId() {
        return id;
    }

    public EstadoDTO(Long id, String sigla, String nome) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
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
