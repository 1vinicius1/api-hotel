package br.ifs.edu.cads.api.hotel.entities;

import br.ifs.edu.cads.api.hotel.entities.enums.Posicao;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table
public class CategoriaQuarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoriaQuarto;

    private String nome;
    private String descricao;
    private Integer maxHospedes;

    @OneToMany(mappedBy = "categoriaQuarto")
    private List<Quarto> quartos = new ArrayList<>();

    private Double valorDiaria;

    @Enumerated(EnumType.STRING)
    private Posicao posicao;

    @OneToMany(mappedBy = "categoriaQuarto")
    private List<Reserva> reservas = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "categoria_quarto_comodidade", joinColumns = @JoinColumn(name = "categoria_quarto_id"),
    inverseJoinColumns = @JoinColumn(name = "comodidade_id"))
    private Set<Comodidade> comodidades = new HashSet<>();

    public CategoriaQuarto(){}

    public CategoriaQuarto(Long idCategoriaQuarto, String nome, String descricao, Integer maxHospedes, List<Quarto> quartos, Double valorDiaria, Posicao posicao, List<Reserva> reservas, Set<Comodidade> comodidades) {
        this.idCategoriaQuarto = idCategoriaQuarto;
        this.nome = nome;
        this.descricao = descricao;
        this.maxHospedes = maxHospedes;
        this.quartos = quartos;
        this.valorDiaria = valorDiaria;
        this.posicao = posicao;
        this.reservas = reservas;
        this.comodidades = comodidades;
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

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
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

    public Set<Comodidade> getComodidades() {
        return comodidades;
    }

    public void setComodidades(Set<Comodidade> comodidades) {
        this.comodidades = comodidades;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriaQuarto other)) return false;
        return idCategoriaQuarto != null && idCategoriaQuarto.equals(other.idCategoriaQuarto);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    @Override
    public String toString() {
        return "CategoriaQuarto{" +
                "idCategoriaQuarto=" + idCategoriaQuarto +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", maxHospedes=" + maxHospedes +
                ", valorDiaria=" + valorDiaria +
                ", posicao=" + posicao +
                '}';
    }
}
