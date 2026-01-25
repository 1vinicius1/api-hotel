package br.ifs.edu.cads.api.hotel.repositories;

import br.ifs.edu.cads.api.hotel.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
