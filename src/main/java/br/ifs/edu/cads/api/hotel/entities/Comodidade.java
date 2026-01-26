package br.ifs.edu.cads.api.hotel.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Comodidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComodidade;

    private String nome;
    private String descricao;

    @ManyToMany(mappedBy = "comodidades")
    private Set<CategoriaQuarto> categoriasQuarto = new HashSet<>();

    public Comodidade(){}

    public Comodidade(Long idComodidade, String nome, String descricao, Set<CategoriaQuarto> categoriasQuarto) {
        this.idComodidade = idComodidade;
        this.nome = nome;
        this.descricao = descricao;
        this.categoriasQuarto = categoriasQuarto;
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

    public Set<CategoriaQuarto> getCategoriasQuarto() {
        return categoriasQuarto;
    }

    public void setCategoriasQuarto(Set<CategoriaQuarto> categoriasQuarto) {
        this.categoriasQuarto = categoriasQuarto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Comodidade that = (Comodidade) o;
        return Objects.equals(idComodidade, that.idComodidade) && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && Objects.equals(categoriasQuarto, that.categoriasQuarto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComodidade, nome, descricao, categoriasQuarto);
    }

    @Override
    public String toString() {
        return "Comodidade{" +
                "idComodidade=" + idComodidade +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
