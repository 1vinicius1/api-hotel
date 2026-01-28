package br.ifs.edu.cads.api.hotel.dto;
import br.ifs.edu.cads.api.hotel.entities.Funcionario;
import br.ifs.edu.cads.api.hotel.entities.enums.Cargo;


public class FuncionarioDTO {

    private Long idFuncionario;

    private String nome;
    private String cpf;
    private Cargo cargo;
    private Long idUsuario;

    public FuncionarioDTO(){}

    public FuncionarioDTO(Funcionario funcionario) {
        this.idFuncionario = funcionario.getIdFuncionario();
        this.nome = funcionario.getNome();
        this.cpf = funcionario.getCpf();
        this.cargo = funcionario.getCargo();

        this.idUsuario = (funcionario.getUsuario() != null)
                ? funcionario.getUsuario().getIdUsuario()
                : null;
    }


    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
