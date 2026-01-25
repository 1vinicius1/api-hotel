package br.ifs.edu.cads.api.hotel.dto;

import br.ifs.edu.cads.api.hotel.entities.Usuario;
import br.ifs.edu.cads.api.hotel.entities.enums.PapelUsuario;
import org.springframework.beans.BeanUtils;

public class UsuarioDTO {

    private Long idUsuario;
    private String email;
    private String senha;
    private PapelUsuario papel;
    private boolean ativo;

    public UsuarioDTO(){}

    public UsuarioDTO(Long idUsuario, String email, String senha, PapelUsuario papel, boolean ativo) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.senha = senha;
        this.papel = papel;
        this.ativo = ativo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PapelUsuario getPapel() {
        return papel;
    }

    public void setPapel(PapelUsuario papel) {
        this.papel = papel;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
