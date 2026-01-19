package br.ifs.edu.cads.api.hotel.entities;

import br.ifs.edu.cads.api.hotel.entities.enums.StatusQuarto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuarto;

    private Integer numQuarto;
    private Integer numAndar;

    @ManyToOne
    @JoinColumn(name = "categoria_quarto_id", nullable = false)
    private CategoriaQuarto categoria;

    @OneToMany(mappedBy = "quarto")
    private List<Reserva> reservas = new ArrayList<>();

    private StatusQuarto statusQuarto;

    public Quarto(){}

    public Quarto(Long idQuarto, Integer numQuarto, Integer numAndar, CategoriaQuarto categoria, List<Reserva> reservas, StatusQuarto statusQuarto) {
        this.idQuarto = idQuarto;
        this.numQuarto = numQuarto;
        this.numAndar = numAndar;
        this.categoria = categoria;
        this.reservas = reservas;
        this.statusQuarto = statusQuarto;
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

    public CategoriaQuarto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaQuarto categoria) {
        this.categoria = categoria;
    }

    public StatusQuarto getStatusQuarto() {
        return statusQuarto;
    }

    public void setStatusQuarto(StatusQuarto statusQuarto) {
        this.statusQuarto = statusQuarto;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Quarto quarto = (Quarto) o;
        return Objects.equals(idQuarto, quarto.idQuarto) && Objects.equals(numQuarto, quarto.numQuarto) && Objects.equals(numAndar, quarto.numAndar) && Objects.equals(categoria, quarto.categoria) && Objects.equals(reservas, quarto.reservas) && statusQuarto == quarto.statusQuarto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuarto, numQuarto, numAndar, categoria, reservas, statusQuarto);
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "idQuarto=" + idQuarto +
                ", numQuarto=" + numQuarto +
                ", numAndar=" + numAndar +
                ", categoria=" + categoria +
                ", reservas=" + reservas +
                ", statusQuarto=" + statusQuarto +
                '}';
    }
}
