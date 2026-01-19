package br.ifs.edu.cads.api.hotel.entities;

import br.ifs.edu.cads.api.hotel.dto.CidadeDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCidade;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @OneToMany(mappedBy = "cidade")
    private List<Hospede> hospedes = new ArrayList<>();

    public Cidade(){}

    public Cidade(Long idCidade, String nome, Estado estado, List<Hospede> hospedes) {
        this.idCidade = idCidade;
        this.nome = nome;
        this.estado = estado;
        this.hospedes = hospedes;
    }

    public Long getCidadeId() {
        return idCidade;
    }
    public void setCidadeId(Long cidadeId) {
        this.idCidade = cidadeId;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Hospede> getHospedes() {
        return hospedes;
    }

    public void setHospedes(List<Hospede> hospedes) {
        this.hospedes = hospedes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(idCidade, cidade.idCidade) && Objects.equals(nome, cidade.nome) && Objects.equals(estado, cidade.estado) && Objects.equals(hospedes, cidade.hospedes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCidade, nome, estado, hospedes);
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "idCidade=" + idCidade +
                ", nome='" + nome + '\'' +
                ", estado=" + estado +
                ", hospedes=" + hospedes +
                '}';
    }
}

