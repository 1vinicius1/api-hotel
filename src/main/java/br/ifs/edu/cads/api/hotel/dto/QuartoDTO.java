package br.ifs.edu.cads.api.hotel.dto;

import br.ifs.edu.cads.api.hotel.entities.Quarto;
import br.ifs.edu.cads.api.hotel.entities.enums.StatusQuarto;

public class QuartoDTO {

    private Long idQuarto;
    private Integer numQuarto;
    private Integer numAndar;
    private StatusQuarto statusQuarto;

    public QuartoDTO(){}

    public QuartoDTO(Quarto quarto) {
        this.idQuarto = quarto.getIdQuarto();
        this.numQuarto = quarto.getNumQuarto();
        this.numAndar = quarto.getNumAndar();
        this.statusQuarto = quarto.getStatusQuarto();
    }

    public Long getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Long idQuarto) {
        this.idQuarto = idQuarto;
    }

    public Integer getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(Integer numQuarto) {
        this.numQuarto = numQuarto;
    }

    public Integer getNumAndar() {
        return numAndar;
    }

    public void setNumAndar(Integer numAndar) {
        this.numAndar = numAndar;
    }

    public StatusQuarto getStatusQuarto() {
        return statusQuarto;
    }

    public void setStatusQuarto(StatusQuarto statusQuarto) {
        this.statusQuarto = statusQuarto;
    }
}
