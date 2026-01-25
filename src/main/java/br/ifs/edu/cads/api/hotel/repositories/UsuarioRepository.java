package br.ifs.edu.cads.api.hotel.repositories;

import br.ifs.edu.cads.api.hotel.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
